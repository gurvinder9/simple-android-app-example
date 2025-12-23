package com.example.basic

class Cars constructor(var name: String, var model: Int) {

    init {
        println("Cars is  $name")
    }

    fun displayCarDetail(): String {
        return "$name,$model"
    }
}