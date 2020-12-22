package ru.job4j.safe

import java.util.*

data class Stock(val name: String, val currency: String, val created: Date) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Stock
        if (this.name == other.name && this.currency == other.currency && this.created == other.created) return true
        return true
    }

    override fun hashCode(): Int {
        return name.hashCode() * 31 + currency.hashCode() * 31 + created.hashCode() * 31
    }
}