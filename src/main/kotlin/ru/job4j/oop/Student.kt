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
}