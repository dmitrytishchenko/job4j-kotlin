package ru.job4j.base


fun add(first: Int, second: Int): Int {
    return first + second
}

fun subtract(first: Int, second: Int): Int {
    return first - second
}

fun multiple(first: Int, second: Int): Int {
    return first * second
}

fun div(first: Int, second: Int): Int {
    return first / second
}

fun main() {
    val plus = add(1, 1)
    println("1 + 1 = $plus")

    val minus = subtract(2, 1)
    println("2 - 1 = $minus")

    val multi = multiple(5, 5)
    println("5 * 5 = $multi")

    val div = div(10, 2)
    println("10 / 2 = $div")
}