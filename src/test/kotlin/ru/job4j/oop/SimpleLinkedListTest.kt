package ru.job4j.oop

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class SimpleLinkedListTest: StringSpec ({
    val list = SimpleLinkedList<String>()
    list.add("Kotlin")
    list.add("Java")
    list.add("Spark")

    "add new Node" {
        list.getSize() shouldBe 3
    }

    "get Node by index" {
        list.getNodeByIndex(1) shouldBe "Java"
        list.getNodeByIndex(2) shouldBe "Kotlin"
        list.getNodeByIndex(0) shouldBe "Spark"
    }
})