package com.example.ejercicios

val rockPlanets = arrayOf("Mercury","Venus","Earth","Mars")
val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
val solarSystem = rockPlanets + gasPlanets
val newSolarSystem = arrayOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto")
fun main(){


    val solarSystem = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )

    println(solarSystem.size)

    solarSystem["Pluto"] = 5

    println(solarSystem.size)

    println(solarSystem["Tehia"])
    solarSystem.remove("Pluto")
    solarSystem["Jupiter"] = 78
    println(solarSystem["Jupiter"])
}