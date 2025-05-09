package com.example.introkotlin.temas

import kotlin.math.sqrt

fun main() {
    var respuesta: String

    do {
        println("Digite el valor de a:")
        val a = readln().toDouble()
        println("Digite el valor de b:")
        val b = readln().toDouble()
        println("Digite el valor de c:")
        val c = readln().toDouble()

        val discriminante = b * b - 4 * a * c

        if (discriminante >= 0) {
            val x1 = (-b + sqrt(discriminante)) / (2 * a)
            val x2 = (-b - sqrt(discriminante)) / (2 * a)
            println("x1 = $x1")
            println("x2 = $x2")
        } else {
            val parteReal = -b / (2 * a)
            val parteImaginaria = sqrt(-discriminante) / (2 * a)
            println("x1 = $parteReal + ${parteImaginaria}i")
            println("x2 = $parteReal - ${parteImaginaria}i")
        }

        println("\n¿Desea resolver otra ecuación? (s/n):")
        respuesta = readln().lowercase()
    } while (respuesta == "s")

    println("Programa finalizado")
}