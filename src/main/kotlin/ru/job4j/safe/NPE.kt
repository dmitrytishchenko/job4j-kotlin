package ru.job4j.safe

class NPE {
    fun print(foo: Foo?) {
        if (foo != null) {
            println(foo.name())
        } else {
            println("null")
        }

    }
    class Foo {
        fun name(): String = "Foo foo foo"
    }
}
fun main() {
    NPE().print(null)
}