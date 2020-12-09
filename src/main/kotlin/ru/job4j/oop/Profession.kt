package ru.job4j.oop

open class Profession(name: String, toStudy: Int)

fun main() {
    val teacher1 = Teacher("Школьный учитель", 5, "Русский язык")
    val teacher2 = Teacher("Преподаватель ВУЗа", 5, "Экономика")
    val doc1 = Doctor("Хирург", 11, "Сосудистый хирург")
    val doc2 = Doctor("Невролог", 9, "Детский невролог")
    val engineer1 = Engineer("Разработчик", 5, "Java")
    val engineer2 = Engineer("Строитель", 5, "промышленное и гражданское строительство")
}