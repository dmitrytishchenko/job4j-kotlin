package ru.job4j.tracker

interface Action {
    fun addItem(tracker: Tracker, input: Input)
    fun showAllItems(tracker: Tracker, input: Input)
    fun exit(): Boolean
}