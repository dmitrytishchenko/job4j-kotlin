package ru.job4j.dsl


class BasicDataSourceDsl private constructor(
    private val driverClassName: String,
    private val url: String,
    private val username: String,
    private val password: String,
    private val minIdle: Int,
    private val maxIdle: Int,
    private val maxOpenPreparedStatement: Int
) {

    fun print() {
        println(
            "BasicDataSourceDsl("
                    + "$driverClassName, $url, $username, $password,"
                    + " $minIdle, $maxIdle, $maxOpenPreparedStatement)"
        )
    }

    companion object Builder {
        private var driver: String? = null
        private var url: String? = null
        private var username: String? = null
        private var password: String? = null
        private var minIdle: Int? = null
        private var maxIdle: Int? = null
        private var maxOpenPreparedStatement: Int? = null

        fun driver(dr: String) = apply { driver = dr }
        fun url(u: String) = apply { url = u }
        fun username(name: String) = apply { username = name }
        fun password(pass: String) = apply { password = pass }
        fun minId(min: Int) = apply { minIdle = min }
        fun maxId(max: Int) = apply { maxIdle = max }
        fun maxOpenPreparedStatement(st: Int) = apply { maxOpenPreparedStatement = st }

        fun build(): BasicDataSourceDsl = BasicDataSourceDsl(
            driver ?: "",
            url ?: "",
            username ?: "",
            password ?: "",
            minIdle ?: 0,
            maxIdle ?: 0,
            maxOpenPreparedStatement ?: 0
        )
    }
}

fun main() {
    val pool = BasicDataSourceDsl
        .driver("org.postgres.Driver")
        .url("localhost")
        .username("postgres")
        .password("password")
        .minId(5)
        .maxId(10)
        .maxOpenPreparedStatement(100)
        .build()
    pool.print()
}