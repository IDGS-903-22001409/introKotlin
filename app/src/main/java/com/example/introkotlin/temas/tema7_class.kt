package com.example.introkotlin.temas

class usuarios() {
    val materia:String=""
}

class usuario(val id:Int, val nombre:String ){
    val materia:String=""
    fun hola(){
        println("Hola")
    }
}

fun main(){
    val alumno = usuario(1,"Sergio")

    println(alumno.id)
    println(alumno.nombre)
    println(alumno.hola())

}