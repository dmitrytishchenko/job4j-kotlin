package ru.job4j.oop

class User {
    var name: String = ""
    var login: String = ""

    constructor(name: String) {
        this.name = name
    }

    constructor(name: String, login: String) : this(name) {
        this.login = login
    }

    private fun show() {
        println("$name $login")
    }

    fun main() {
        val user = User("Dmitriy")
        val user2 = User("Dmitriy", "dmt")
        user.show()
        user2.show()
    }
}