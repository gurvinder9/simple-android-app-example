package com.example.basic.abstractClass

abstract class VehicleT {
    abstract fun vehicleName(name: String): String

    fun vehicleType(type: String): String {
        return "Vehicle type is $type"
    }

    abstract var model: Int
    var speed:Int? = null
}