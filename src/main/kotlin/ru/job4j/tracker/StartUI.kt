package ru.job4j.tracker

import java.util.*

object StartUI : Action {
    private val tracker = Tracker()
    private val consoleInput = ConsoleInput()

    private val input = Scanner(System.`in`)

    init {
        var work = true
        while (work) {
            printMenu()
            println("Введите пункт меню: ")
            when (input.next()) {
                "1" -> {
                    addItem(tracker, consoleInput)
                }
                "2" -> {
                    showAllItems(tracker, consoleInput)
                }
                else -> {
                    work = exit()
                }
            }
        }
    }

    private fun printMenu() {
        println("Меню приложения Tracker")
        println("1. Добавить заявку")
        println("2. Показать все заявки")
        println("3. Выход")
    }

    override fun addItem(tracker: Tracker, input: Input) {
        tracker.addItem(Item(
            input.ask("Input id"),
            input.ask("Input name"),
            input.ask("Input description"),
            input.ask("Input comments")))
    }

    override fun showAllItems(tracker: Tracker, input: Input) {
        for (i in StartUI.tracker.findAllItems()) {
            input.ask("Заявка - $i")
        }
    }

    override fun exit(): Boolean {
        return false
    }
}

fun main() {
    StartUI
}