package com.example.basic

fun main(args: Array<String>) {
    val a: Short = 6;
    val b: Int = 32
    val r = a * b

    val al: Long = 456892832
    val af: Float = 23.33F
    val result = al/af

    println(r::class.java)
    println("Float result is ${result::class.java}")
}