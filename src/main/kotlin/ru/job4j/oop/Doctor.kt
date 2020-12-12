package ru.job4j.oop

class Doctor(val name: String, var toStudy: Int, specialization: String) : Profession(name, toStudy) {
    override fun action() {
        super.action()
        println("Action by doctor - the study is - $toStudy year")
    }

    override fun getName() {
        super.getName()
        println("Name is $name")
    }
}