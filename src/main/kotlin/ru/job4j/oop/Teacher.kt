package ru.job4j.oop

class Teacher(val name: String, var toStudy: Int, val subject: String) : Profession(name, toStudy) {
    override fun action() {
        super.action()
        println("Action by teacher - the study is - $toStudy year")
    }

    override fun getName() {
        super.getName()
        println("Name is $name")
    }
}