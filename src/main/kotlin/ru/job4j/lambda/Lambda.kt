package ru.job4j.lambda

import kotlin.math.pow

fun main() {
    val decr = { x: Int -> x - 1 }
    println(decr(10))
    val pow = { x: Double -> x.pow(2) }
    println(pow(5.0))
    val dec = { x: Double -> (x - 1).pow(2) }
    println(dec(4.0))
}