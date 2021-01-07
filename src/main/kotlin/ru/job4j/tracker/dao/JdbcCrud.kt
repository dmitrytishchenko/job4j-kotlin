package ru.job4j.tracker.dao

import ru.job4j.tracker.Item
import java.lang.Exception
import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet


fun getConn(): Connection? {
    val url = "jdbc:postgresql://127.0.0.1:5432/tracker"
    val username = "postgres"
    val password = "password"
    var connection: Connection? = null
    try {
        connection = DriverManager.getConnection(url, username, password)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return connection
}

fun tx(sql:String): PreparedStatement {
    return getConn()!!.prepareStatement(sql)
}

fun create(item: Item) {
    val sql = "INSERT into item (id, name, description, comments)" +
            " values(${item.id}, '${item.name}', '${item.description}', '${item.comments}')"
    if (tx(sql).executeUpdate() > 0)
        println("The item ${item.name} is created") else
        println("This item is incorrect")
}

fun read(): List<Item> {
    val list = ArrayList<Item>()
    val sql = "Select * from item"
    val ps = tx(sql)
    val rs: ResultSet = ps.executeQuery()
    while (rs.next()) {
        list.add(
            Item(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getString("comments")
            )
        )
    }
    return list
}

fun update(item: Item) {
    val sql = "Update item set name='${item.name}', description='${item.description}'," +
            " comments='${item.comments}' where id=${item.id}"
    val ps = tx(sql)
    val rows = ps.executeUpdate()
    if (rows > 0) {
        println("The item is update")
    }
}

fun delete(item: Item) {
    val sql = "Delete from item where id=${item.id}"
    val ps = tx(sql)
    val rows = ps.executeUpdate()
    if (rows > 0) {
        println("The item is delete")
    }
}

fun printItem(list: ArrayList<Item>) {
    for (i in list) {
        println(i.toString())
    }
}

fun main() {
    val item1 = Item(1, "name", "desc1", "comments1")
    val item2 = Item(2, "name2", "desc2", "comments2")
    val item3 = Item(3, "name3", "desc3", "comments3")
    create(item1)
    create(item2)
    create(item3)
    printItem(read() as ArrayList<Item>)
    item1.name = "nameUpdate"
    update(item1)
    printItem(read() as ArrayList<Item>)
    delete(item1)
    delete(item3)
    delete(item2)

}