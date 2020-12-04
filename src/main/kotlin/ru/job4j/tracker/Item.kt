package ru.job4j.tracker

data class Item(private var id: Int = 0,
                private var name: String = "",
                private var description: String = "",
                private var comments: String = "")