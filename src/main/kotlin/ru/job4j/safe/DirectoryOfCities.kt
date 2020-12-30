package ru.job4j.safe

class DirectoryOfCities {
    val cities: List<CityForDir> by lazy { getDir() }

    private fun getDir(): List<CityForDir> = listOf(
        CityForDir("Moscow"),
        CityForDir("Saint Petersburg")
    )

    inner class CityForDir(val name: String)
}

fun main() {
    val dir = DirectoryOfCities()
    dir.cities.stream().forEach { println(it.name) }
}