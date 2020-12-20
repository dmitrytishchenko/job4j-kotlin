package ru.job4j.safe

import java.lang.StringBuilder
import java.util.*

data class Purchase(val name: String, var created: Date, val address: Address?) {
}

fun createHTMLTable(list: List<Purchase>): String {
    val table = StringBuilder()
    table.apply {
        append("<table>\n")
        list.forEach {
            append("<tr>\n")
            append("<td>")
            append(it.name)
            append("</td>")
            append("<td>")
            append(it.created)
            append("</td>")
            append("<td>")
            append(it.address?.street ?: "")
            append("</td>\n")
            append("</tr>\n")
        }
        append("<table>\n")
    }
    return table.toString()
}

fun main() {
    val address1 = Address("Mira", "Home", 5)
    val address2 = null
    val purchase1 = Purchase("Milk", Date(), address1)
    val purchase2 = Purchase("Kefir", Date(), address2)
    val list = listOf<Purchase>(purchase1, purchase2)
    println(createHTMLTable(list))
}