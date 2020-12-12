package ru.job4j.lambda

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class AccountTest : StringSpec({

    val account1: Account = Account("Ivan", 50)
    val account2: Account = Account("Mike", 10)
    val account3: Account = Account("Bob", 0)
    val account4: Account = Account("Ben", -50)
    val list: List<Account> = listOf(account1, account2, account3, account4)

    "filter by name" {
        list.first { it.name == "Ivan" } shouldBe account1
    }

    "find account where balance < 0" {
        list.first() { it.balance < 0 } shouldBe account4
    }
})