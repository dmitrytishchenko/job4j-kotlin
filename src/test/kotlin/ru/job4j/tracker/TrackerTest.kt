package ru.job4j.tracker

import io.kotlintest.specs.StringSpec
import io.kotlintest.shouldBe

class TrackerTest : StringSpec({
    "addItem" {
        var item = Item(1, "testName", "testDesc", "testComments")
        var tracker = Tracker()
        tracker.addItem(item) shouldBe item
    }

    "findAllItems" {
        var item = Item(1, "testName", "testDesc", "testComments")
        var tracker = Tracker()
        tracker.addItem(item)
        tracker.findAllItems().size shouldBe 1
    }

    "findItemById" {
        var item = Item(1, "testName", "testDesc", "testComments")
        var tracker = Tracker()
        tracker.addItem(item)
        tracker.findItemById(1) shouldBe item
    }

    "deleteItem" {
        var item = Item(1, "testName", "testDesc", "testComments")
        var tracker = Tracker()
        tracker.addItem(item)
        tracker.deleteItem(1)

    }
})