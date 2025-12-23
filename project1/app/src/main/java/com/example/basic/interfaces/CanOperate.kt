package com.example.basic.interfaces

interface CanOperate {
    val name: String
        get() ="BMW"

    fun go() {
        println("Go")
    }

    fun stop()
}