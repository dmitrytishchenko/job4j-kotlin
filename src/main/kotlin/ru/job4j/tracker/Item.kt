package ru.job4j.tracker

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Item(@Id
                @GeneratedValue(strategy = GenerationType.AUTO) internal var id: Int,
                internal var name: String,
                internal val description: String,
                internal var comments: String) {
}