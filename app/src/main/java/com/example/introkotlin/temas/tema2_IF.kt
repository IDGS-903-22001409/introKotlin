package com.example.introkotlin.temasKotlin

//IF
fun main (){
    print("Ingrese el sueldo del empleado")
    val sueldo = readln().toDouble()

    if (sueldo > 3000){
        println("Debe de pagar impuestos")
    }else {
        println("No debe pagar impuestos")
    }
}