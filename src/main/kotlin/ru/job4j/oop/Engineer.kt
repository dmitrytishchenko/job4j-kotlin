package ru.job4j.oop

class Engineer(val name: String, var toStudy: Int, spec: String) : Profession(name, toStudy) {
    override fun action() {
        super.action()
        println("Action by engineer - the study is - $toStudy year")
    }

    override fun getName() {
        super.getName()
        println("Name is $name")
    }
}