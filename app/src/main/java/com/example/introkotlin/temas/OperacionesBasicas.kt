package com.example.introkotlin.temasKotlin

fun main(){
    println("Digite un numero")
    var num1 = readln().toDouble()

    println("Digite un segundo numero")
    var num2 = readln().toDouble()

    var suma = num1 + num2
    var resta = num1 - num2
    var multiplicacion = num1 * num2
    var division = num1 / num2

    do{
        println("Que operacion deseas Realizar")
        println("1. Sumar")
        println("2. Restar")
        println("3. Restar")
        println("4. Multiplicar")
        println("5. Salir")
        var opcion = readln().toInt();

        if (opcion == 1){
            println(" La suma es $num1 + $num2 es $suma")
        }
        if (opcion == 2){
            println(" La suma es $num1 + $num2 es $resta")
        }
        if (opcion == 3){
            println(" La suma es $num1 + $num2 es $multiplicacion")
        }
        if (opcion == 4){
            println(" La suma es $num1 + $num2 es $division")
        }
    }while (opcion != 5)

}