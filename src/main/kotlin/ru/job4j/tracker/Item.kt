package ru.job4j.tracker

data class Item(val id: Int,
                val name: String,
                val description: String,
                var comments: String)