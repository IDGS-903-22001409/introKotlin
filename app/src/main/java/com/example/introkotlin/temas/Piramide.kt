package com.example.introkotlin.temas

fun main() {

    var continuar = true

    do{
        println("Digite un número para la pirámide:")
        var cantidad = readln().toInt()

        if (cantidad > 0) {
            var nivel = 1
            var icono = "*"

            do {
                println(icono)
                icono += "*"
                nivel++
            } while (nivel <= cantidad)
        } else {
            println("Acción terminada por el usuario")
            continuar = false
        }
    }while (continuar)
}