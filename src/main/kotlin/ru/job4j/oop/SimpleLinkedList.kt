package ru.job4j.oop

class SimpleLinkedList<T> : Iterable<T?> {
    private var head: Node<T>? = null
    private var size = 0

    fun add(value: T) {
        val newNode = Node(value)
        newNode.next = head
        head = newNode
        size++
    }

    fun getNodeByIndex(index: Int): T? {
        var res = head
        for (i in 0 until index) {
            res = res?.next
        }
        return res?.value
    }

    fun getSize() = size

    override fun iterator(): Iterator<T?> {
        return LinkedIt()
    }

    inner class LinkedIt : Iterator<T?> {

        var currentNode = head

        override fun hasNext(): Boolean {
            return currentNode != null
        }

        override fun next(): T? {
            if (!hasNext()) {
                throw NoSuchElementException()
            }
            val res = currentNode?.value
            currentNode = currentNode?.next
            return res
        }
    }

    class Node<K>(val value: K, var next: Node<K>? = null)
}

fun main() {
    val node = SimpleLinkedList.Node<String>("Kotlin")
    println(node.value)
    val list = SimpleLinkedList<String>()
    list.add("Kotlin")
    list.add("Java")
    list.add("Spark")
    println(list.getNodeByIndex(0))
    println(list.getNodeByIndex(1))
    println(list.getNodeByIndex(2))
    println(list.getSize())
    println(list.getNodeByIndex(1))
    for (value in list) {
        println(value)
    }
}