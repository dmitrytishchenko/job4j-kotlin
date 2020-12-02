package ru.job4j.base

fun draw(size: Int) {
    var whitespace = size
    for (value in 0 until size) {
        for (v in 0..size) {
            if (v == size - whitespace || v == whitespace - 1) {
                print("X")
            } else {
                print(" ")
            }
        }
        println()
        whitespace--
    }
}

fun main() {
    draw(11)
}