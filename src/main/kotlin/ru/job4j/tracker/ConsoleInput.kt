package ru.job4j.tracker

import java.util.*

class ConsoleInput : Input {
    private val input = Scanner(System.`in`)

    override fun ask(question: String): String {
        println(question)
        return input.next()
    }
}