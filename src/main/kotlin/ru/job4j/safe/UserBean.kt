package ru.job4j.safe

class UserBean {
    val emails: List<String> by lazy { loadEmails() }

    private fun loadEmails(): List<String> = listOf("tdmitriu@mail.ru")
}

fun main() {
    val user = UserBean()
    println(user.emails)
}