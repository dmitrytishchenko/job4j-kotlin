package ru.job4j.lambda

import java.lang.StringBuilder

class HtmlTable {
    fun tab(row: Int, cell: Int): String {
        val table = StringBuilder()
        table.apply {
            append("<table>")
            for (i in 0..row) {
                append("<tr>")
                for (j in 0..cell) {
                    append("<td>Some data</td>")
                }
                append("</tr>")
            }
            append("</table>")
        }
        return table.toString()
    }
}
