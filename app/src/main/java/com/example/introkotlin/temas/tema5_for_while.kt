package com.example.introkotlin.temas

fun main(){
    /*
    Range
    1..4 = 1,2,3,4

    1..<4 = 1,2,3

    4..1 = 4,3,2,1

    1..5 step 2 = 1,3,5

    'a'..'z' = a,b,c,d,e,f,g,h,i,j,k,l,m,n,ñ,o,p,q,r,s,t...
     */
    for (num in 1..5){
        println(num)
    }

    val pizzas = listOf("Pepperoni", "Hawahiana", "Tocino", "Chorizo")
    for (pizza in pizzas){
        println(pizza)
    }

    var n = 10
    var d = 1
    while(d <= n){
        println(d)
        d++
    }

    /*
    Practica 2 = imprimir una piramide es * segun el numero dado por el usuario
    *
    **
    ***
   cuando se capture 0 terminar el programa usando solo do-while

   practica 3= Formula general de la serie de fibonnaci
     */
}