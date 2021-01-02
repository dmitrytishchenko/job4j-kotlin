package ru.job4j.dsl

import ru.job4j.tracker.Item
import ru.job4j.tracker.Tracker
import java.io.File

private val tracker = Tracker()

fun File.extension(): String {
    val name = this.name
    if (!name.contains(".")) return ""
    return name.substring(name.indexOf("."), name.length)
}

fun Item.save() {
    val id = this.id
    val name = this.name
    val comments = this.comments
    val desc = this.description
    tracker.addItem(Item(id, name, comments, desc))
}

fun Item.select(): ArrayList<Item> {
    return tracker.findAllItems()
}

fun main() {
    val ext = File("index.jsp").extension()
    println(ext)

    val item = Item(1, "test", "test", "test")
    item.save()

    println(item.select())
}