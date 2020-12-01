package ru.job4j.base

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class CalcTest : StringSpec({
    "1 + 1 = 2" {
        add(1, 1) shouldBe 2
    }
    "1 - 1 = 0" {
        subtract(1, 1) shouldBe 0
    }
    "5 * 5 = 25" {
        multiple(5, 5) shouldBe 25
    }
    "33 / 11 = 3" {
        div(33, 11) shouldBe 3
    }
})