package ru.job4j.base

fun max(first : Int, second : Int) = if (first > second) first else second

fun max3(first : Int, second : Int, third : Int) = if (first > if(second > third) second else third) first else if(second > third) second else third
