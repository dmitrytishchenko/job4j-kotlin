package ru.job4j.base

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class DefragmentTest : StringSpec({
    "Defragment massiv" {
        defragment(arrayOf<String?>("bob", null, "nik", null, "mak", "alex")) shouldBe
                arrayOf<String?>("bob","nik", "mak","alex", null, null)
    }

    "Defragment massiv2" {
        defragment(arrayOf<String?>(null, null, "nik", null, "mak", "alex")) shouldBe
                arrayOf<String?>("nik", "mak","alex", null, null, null)
    }
})