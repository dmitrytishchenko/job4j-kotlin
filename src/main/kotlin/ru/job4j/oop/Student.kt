package ru.job4j.oop

class Student(private val name: String) {
    private var surname: String = ""
    private var phone: String = ""
    var email: String = ""

    constructor(name: String, surname: String) : this(name) {
        this.surname = surname
    }

    constructor(name: String, surname: String, phone: String) : this(name, surname) {
        this.phone = phone
    }

    constructor(name: String, surname: String, phone: String, email: String) : this(name, surname, phone) {
        this.email = email
    }

    fun show() {
        println("$name $surname $email $phone")
    }
}

fun main() {
    val student1 = Student("Dimitry")
    val student2 = Student("Dimitry", "Tishchenko")
    val student3 = Student("Dimitry", "Tishchenko", "123-56-78")
    val student4 = Student("Dimitry", "Tishchenko", "123-56-78", "tdmitriu@mail.ru")
    student1.show()
    student2.show()
    student3.show()
    student4.show()
}