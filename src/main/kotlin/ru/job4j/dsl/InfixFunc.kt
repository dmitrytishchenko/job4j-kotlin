package ru.job4j.dsl

import org.junit.jupiter.api.Assertions.*
import ru.job4j.tracker.Item

infix fun <T> T.eq(expected: T): Unit = assertEquals(this, expected)
infix fun <T> T.notEq(expected: T): Unit = assertNotEquals(this, expected)
infix fun <T> List<T>.contain(values: List<T>) = assertTrue(this.containsAll(values))

fun main() {
    val item1 = Item(1, "test", "test", "test")
    val item2 = Item(2, "test2", "test2", "test2")
    val item3 = Item(3, "test3", "test3", "test3")
    val sources = listOf(item1, item2, item3)
    val target = listOf(item1, item2)
    println(item1 eq item1)
    println(item1 notEq item2)
    println(sources contain target)
}