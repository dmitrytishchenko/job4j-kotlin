package ru.job4j.lambda

import java.util.stream.Collectors


fun count(list: ArrayList<Int>): Long {
    return list
        .stream()
        .filter { it > 3 }
        .map { it + 1 }
        .collect(Collectors.toList())
        .sum().toLong()
}

fun main() {
    var list = arrayListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(count(list))
}