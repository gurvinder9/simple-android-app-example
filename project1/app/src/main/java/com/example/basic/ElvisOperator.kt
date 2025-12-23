package com.example.basic

fun main(args: Array<String>) {
    val name: String? = null;
    println(name?: "No Name Give")

    // Non null assertion
    // !!. Developer guarantee that the variable is not null. Warning: This bypass all the language checks for null safety. Can trigger
    // a program crash. Try to avoid as much as you can.

    val city: String? = "Chandigarh";
    println(city!!.length);
}