package ru.job4j.safe

import mu.KotlinLogging
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class ConnectionDB {
    private lateinit var connection: Connection
    private val logger = KotlinLogging.logger {}

    private val url = "jdbc:postgresql://127.0.0.1:5432/postgres"
    private val username = "postgres"
    private val password = "password"
    private val driver = "org.postgresql.Driver"

    fun init() {
        try {
            Class.forName(driver)
            connection = DriverManager.getConnection(url, username, password)
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    fun exposed() {
        Database.connect(
            "jdbc:postgresql://127.0.0.1:5432/postgres", driver = "org.postgresql.Driver",
            user = "postgres", password = "password"
        )
        println("Connection")
        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(Cities)
            val SPB = City.new {
                name = "Saint Petersburg"
            }
            val Moscow = City.new {
                name = "Moscow"
            }
            println("Cities: ${City.all()}")
        }
    }

    fun closeCon() {
        connection.close()
    }

    fun exec(sql: String): String {
        val st = connection.createStatement()
        val rs = st.executeQuery(sql)
        while (rs.next()) {
            println(rs.getString("name"))

        }
        return logger.info("Скрипт выполнен").toString()
    }
}

object Cities : IntIdTable() {
    val name = varchar("name", 50)
}

class City(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<City>(Cities)

    var name by Cities.name
}

fun main() {
    val connectionDB = ConnectionDB()
    connectionDB.init()
    connectionDB.exec("Select * from cities")
    connectionDB.closeCon()
}