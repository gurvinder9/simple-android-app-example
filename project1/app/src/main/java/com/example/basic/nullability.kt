package com.example.basic

/*
   ? -> Nullable operator
   ?. -> Nullable operator
 */

fun main(args: Array<String>) {
    var name: String? = null
    name = "Sam"
    println("Name is $name")
    println("Length is ${name?.length}")

    var num: Int? = null
    println("Sum is ${num?.plus(1)}")
    num = 5;
    println("Sum is ${num.plus(1)}")
}