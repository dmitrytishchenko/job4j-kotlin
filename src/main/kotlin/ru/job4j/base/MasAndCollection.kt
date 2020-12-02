package ru.job4j.base

import java.util.ArrayList

fun createArray() {
    val names = arrayOfNulls<String>(10)
    names[0] = "Dmitriy Tishchenko"
    for ((index, name) in names.withIndex()) {
        println("$index " + name?.length)
    }
}

fun createArrayList() {
    val names = ArrayList<String>()
    names.add("Dmitriy Tishchenko")
    for (name in names) {
        println(name)
    }
}

fun defragment(array: Array<String?>): Array<String?> {
    array.sortBy { S -> S == null }
    return array
}

fun main() {
    createArray()
    createArrayList()
}