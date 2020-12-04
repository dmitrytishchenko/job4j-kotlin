package ru.job4j.base

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class MaxIfTest : StringSpec({
    "(1, 5) = 5" {
        max(1, 5) shouldBe 5
    }
    "(1, 2, 3) = 3" {
        max3(1, 2, 3) shouldBe 3
    }
    "(5, 10, 3) = 10" {
        max3(5, 10, 3) shouldBe 10
    }
})