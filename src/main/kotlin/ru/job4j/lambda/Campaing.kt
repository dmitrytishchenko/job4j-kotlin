package ru.job4j.lambda

import java.util.*
import kotlin.collections.ArrayList


data class Campaing(val name: String, val address: Address, val created: Date)

fun method(list: ArrayList<Campaing>): List<String> {
    return list.map { it.name + " " + it.address.name + " " + it.created }
}

fun main() {
    val campaing1 = Campaing("name1", Address("address1"), Date())
    val campaing2 = Campaing("name2", Address("address2"), Date())
    val campaing3 = Campaing("name3", Address("address3"), Date())
    val campaing4 = Campaing("name4", Address("address4"), Date())
    val list = ArrayList<Campaing>()
    list.add(campaing1)
    list.add(campaing2)
    list.add(campaing3)
    list.add(campaing4)
    println(method(list))
}