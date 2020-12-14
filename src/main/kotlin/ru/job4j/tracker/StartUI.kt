package ru.job4j.tracker

import java.util.*

object StartUI {
    private val tracker = Tracker()
    private var input = Scanner(System.`in`)

    init {
        var work = true
        while (work) {
            printMenu()
            println("Введите пункт меню: ")
            work = getMenuItem()
        }
    }

    private fun getMenuItem(): Boolean {
        return when (input.next()) {
            "1" -> addItem()
            "2" -> showAllItem()
            else -> exit()
        }
    }

    private fun printMenu() {
        println("Меню приложения Tracker")
        println("1. Добавить заявку")
        println("2. Показать все заявки")
        println("3. Выход")
    }

    private fun addItem(): Boolean{
        print("Введите id заявки: ")
        val id = input.nextInt()
        print("Введите имя заявки: ")
        val name = input.next()
        print("Введите описание заявки: ")
        val desc = input.next()
        print("Введите комментарий заявки: ")
        val comments = input.next()
        return tracker.addItem(Item(id, name, desc, comments))
    }

    private fun showAllItem(): Boolean {
        var result = false
        if (tracker.findAllItems().size != 0) {
            result = true
            for (i in tracker.findAllItems()) {
                println("Заявка - $i")
                println()
            }
        }
        return result
    }

    private fun exit(): Boolean {
        return false
    }
}

fun main() {
    StartUI
}