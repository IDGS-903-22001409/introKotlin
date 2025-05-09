package com.example.introkotlin.temas

// Colecciones
fun main (){
    /*
    List -Val (Constante)
    Mutablelist
    Set -Var (Cambiante)
    MutableSet
    Map -Diccionario de Python
    MutableMap
    */
    var lista = listOf<String>("Lunes", "Martes", "Míercoles")
    println(lista)
    println(lista.size)
    println(lista.get(0))
    println(lista.count())
    println(lista.first())
    println(lista.last())
    println(lista.indexOf("Míercoles"))

    var listaMutable = mutableListOf<String>("Lunes", "Martes", "Míercoles")
    println(listaMutable)
    listaMutable.add("Jueves")
    println(listaMutable)
    listaMutable.add(0, "Domingo")
    println(listaMutable)
}