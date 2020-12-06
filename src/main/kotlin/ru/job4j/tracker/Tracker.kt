package ru.job4j.tracker

class Tracker {
    private val items = ArrayList<Item>()

    internal fun addItem(item: Item): Item {
        items.add(item)
        return item
    }

    internal fun findAllItems(): ArrayList<Item> = items

    internal fun deleteItem(id: Int) {
        items.remove(findItemById(id))
    }

    internal fun findItemById(id: Int): Item? {
        for (i in items) {
            if (i.id == id) {
                return i
            }
        }
        return null
    }
}