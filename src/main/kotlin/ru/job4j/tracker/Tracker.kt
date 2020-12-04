package ru.job4j.tracker

class Tracker {
    private var items = ArrayList<Item>()

    fun addItem(item: Item): Item {
        items.add(item)
        return item
    }

    fun findAllItems(): ArrayList<Item> = items

    fun deleteItem(id: Int) {
        items.remove(findItemById(id))
    }

    fun findItemById(id: Int): Item? {
        var resultItem: Item? = null
        for (i in items) {
            if (i.id == id) {
                resultItem = i
            }
        }
        return resultItem
    }
}