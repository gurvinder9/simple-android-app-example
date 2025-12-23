package com.example.basic

class CarsSecondaryConstructor {
    //private var name: String? = null;
    var name: String? = null
        private set

    constructor(n: String) {
        this.name = n;
    }
}