package ru.job4j.lambda

import java.lang.StringBuilder

class EmailService {
    fun emailTo(message: Message): String {
        return with(StringBuilder()) {
            append("Subject : ").append(message.email).append(" ")
            append("Body : ").append("Hello, Dmitri ").append(message.email).append(" ")
            append("You win!")
        }.toString()

    }
}

fun main() {
    println(EmailService().emailTo(Message("TestMessage", "tdmitriu@mail.ru")))
}