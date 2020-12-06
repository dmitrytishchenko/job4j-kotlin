package ru.job4j.tracker

data class Item(internal val id: Int,
                internal val name: String,
                internal val description: String,
                internal var comments: String)