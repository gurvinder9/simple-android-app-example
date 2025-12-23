package com.example.basic.abstractClass

class CarT(override var model: Int) : VehicleT() {
    override fun vehicleName(name: String): String {
        return "Vehicle Name is $name"
    }

}