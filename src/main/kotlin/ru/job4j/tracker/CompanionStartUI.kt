package ru.job4j.tracker

import java.util.*

class CompanionStartUI {
    companion object CompStartUI {
        private val tracker = Tracker()
        private var input = Scanner(System.`in`)

        init {
            var work = true
            while (work) {
                printMenu()
                println("Введите пункт меню: ")
                when (input.next()) {
                    "1" -> {
                        addItem()
                    }
                    "2" -> {
                        showAllItem()
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

        private fun addItem() {
            print("Введите id заявки: ")
            val id = input.nextInt()
            print("Введите имя заявки: ")
            val name = input.next()
            print("Введите описание заявки: ")
            val desc = input.next()
            print("Введите комментарий заявки: ")
            val comments = input.next()
            tracker.addItem(Item(id, name, desc, comments))
        }

        private fun showAllItem() {
            for (i in tracker.findAllItems()) {
                println("Заявка - $i")
                println()
            }
        }

        private fun exit(): Boolean {
            return false
        }
    }
}

fun main() {
    CompanionStartUI.CompStartUI
}