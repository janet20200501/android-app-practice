package com.soetek.bmi

class Bmi() {
    var height: Float = 0F
    var weight: Float = 0F

    fun calculate(): Float {
        return this.weight / (this.height * this.height / 100 / 100)
    }

    fun clear() {
        this.height = 0F
        this.weight = 0F
    }
}