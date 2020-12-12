package ru.job4j.oop

open class Profession(name: String, toStudy: Int) {
    open fun action() {
        println("Some action")
    }

    open fun getName() {
        println("The name is profession")
    }
}

fun main() {
    val teacher1 = Teacher("Школьный учитель", 5, "Русский язык")
    teacher1.action()
    teacher1.getName()
    val teacher2 = Teacher("Преподаватель ВУЗа", 5, "Экономика")
    teacher2.action()
    teacher2.getName()
    val doc1 = Doctor("Хирург", 11, "Сосудистый хирург")
    doc1.action()
    doc1.getName()
    val doc2 = Doctor("Невролог", 9, "Детский невролог")
    doc2.action()
    doc2.getName()
    val engineer1 = Engineer("Разработчик", 5, "Java")
    engineer1.action()
    engineer1.getName()
    val engineer2 = Engineer("Строитель", 5, "промышленное и гражданское строительство")
    engineer2.action()
    engineer2.getName()
}