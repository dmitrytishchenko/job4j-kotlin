package ru.job4j.safe

class Web {
    val params = HashMap<String, String>()
    val logic = Logic()

    fun service(req: String) {
        val name = params.get("name")
        if (name != null) {
            logic.create(name)
        }
    }
}

class Logic {
    val store = ArrayList<String>()

    fun create(name: String) {
        store.add(name)
    }
}

fun main() {
    Web().service("")
}