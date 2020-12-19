package ru.job4j.safe;

public class NPE {
    static class Foo {
        String name() {
            return "Foo foo foo";
        }
    }

    public static void main(String[] args) {
        print(null);
    }

    public static void print(Foo foo) {
        System.out.println(foo.name());
    }
}
