package ru.job4j.collection

class ArrayNotNullIt(private val data: Array<Int?>): Iterator<Int> {
    private var index = 0
    override fun hasNext(): Boolean {
        while (data.size > index && data[index] == null) {
            index++
        }
        return data.size > index
    }

    override fun next(): Int {
        if (!hasNext()) {
            throw NoSuchElementException()
        }
        return data[index++]!!
    }
}

fun main() {
    val data = arrayOfNulls<Int>(4)
    data[0] = 1
    data[1] = null
    data[2] = 2
    data[3] = null
    ArrayNotNullIt(data).forEach { println(it) }
}