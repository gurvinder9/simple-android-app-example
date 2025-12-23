package com.example.basic.abstractClass

fun main(args: Array<String>) {
//    val vehicle = Vehicle()
    val car = CarT(2025)
    println(car.vehicleName("Mercedes"))
    car.vehicleType("SUV")
}