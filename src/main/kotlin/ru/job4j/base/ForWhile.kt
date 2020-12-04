package ru.job4j.base

fun fitness(ivan: Int, nik: Int): Int {
    var month = 0
    var powerIvan = ivan
    var powerNik = nik
    while (powerIvan < powerNik) {
        powerIvan *= 3
        powerNik *= 2
        month++
    }
    return month
}

fun addFor(start: Int, finish: Int): Int {
    var rst = 0
    for (value in start..finish) {
        rst += value
    }
    return rst
}

fun addForUntil(start: Int, finish: Int): Int {
    var rst = 0
    for (value in start until finish) {
        rst += value
    }
    return rst
}

fun addForStep(start: Int, finish: Int): Int {
    var rst = 0
    for (value in start..finish step 5) {
        rst += value
    }
    return rst
}

fun main() {

    val rsl = fitness(50, 90)
    println("Month : $rsl")

    val rst = addFor(0, 10)
    println("Sum from 0 to 10 is $rst")

    val rstUntil = addForUntil(0, 10)
    println("Sum from 0 to 10 is $rstUntil")

    val rstStep = addForStep(0, 10)
    println("Sum from 0 to 10 is $rstStep")
}