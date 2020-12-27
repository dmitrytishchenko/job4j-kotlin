package ru.job4j.collection

import java.lang.IndexOutOfBoundsException
import kotlin.NoSuchElementException

class SimpleLinkedList<T> : Iterable<T>, ListIterator<T> {
    private var head: Node<T>? = null
    private var last: Node<T>? = null
    private var size = 0
    private var index = 0

    class Node<T>(val value: T, var next: Node<T>? = null, var previous: Node<T>? = null)

    inner class LinkedIt : Iterator<T> {
        override fun hasNext(): Boolean {
            return head != null
        }

        override fun next(): T {
            if (!hasNext()) {
                throw NoSuchElementException()
            }
            return head!!.value
        }

    }

    override fun iterator(): Iterator<T> {
        return LinkedIt()
    }

    fun add(value: T) {
        val newNode = Node<T>(value)
        if (head == null) {
            head = newNode
            last = newNode
        } else {
            last!!.next = newNode
            newNode.previous = last
            last = newNode
        }
        size++
    }

    fun getSize() = size

    override fun hasNext(): Boolean = index in 0 until size

    override fun hasPrevious(): Boolean = index in 1..size

    override fun next(): T {
        if (!hasNext()) {
            throw NoSuchElementException()
        }
        return getValueByIndex(index++)
    }

    private fun getValueByIndex(index: Int): T {
        if (index < 0 || index > size) {
            throw IndexOutOfBoundsException()
        }
        var res: Node<T>? = head
        for (i in 1 until index) {
            res = res?.next
        }
        return res!!.value
    }

    override fun nextIndex(): Int = ++index

    override fun previous(): T {
        if (!hasPrevious()) {
            throw NoSuchElementException()
        }
        return getValueByIndex(index--)
    }

    override fun previousIndex(): Int = --index

}

fun main() {
    val list = SimpleLinkedList<String>()
    list.add("val1")
    list.add("val2")
    list.add("val3")
    println("Размер связного списка = ${list.getSize()}")
    println("Проверка метода hasNext() = ${list.hasNext()}")
    println("Проверка метода next() для 1 значения = ${list.next()}")
    println("Проверка метода next() для 2 значения = ${list.next()}")
    println("Проверка метода next() для 3 значения = ${list.next()}")
    println("Проверка метода hasPrevious() = ${list.hasPrevious()}")
    println("Проверка метода previous() = ${list.previous()}")
    println("Проверка метода previous() = ${list.previous()}")
    println("Проверка метода previous() = ${list.previous()}")
    println("Проверка метода nextIndex() = ${list.nextIndex()}")
    println("Проверка метода nextIndex() = ${list.nextIndex()}")
    println("Проверка метода nextIndex() = ${list.nextIndex()}")
    println("Проверка метода previousIndex() = ${list.previousIndex()}")
    println("Проверка метода previousIndex() = ${list.previousIndex()}")
    println("Проверка метода previousIndex() = ${list.previousIndex()}")
}