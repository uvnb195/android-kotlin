package com.example.lab1.src

import kotlin.math.PI

private fun main () {
    bai1()
    bai2()
    bai3()
}

fun input():Double{
    var s :String?
    while (true) {
        s = readLine()
        if (s!=null) {
            return s.toDouble()
        }
    }
}

fun bai1 () {
    print("n = ")
    val n = input().toInt()

    if (n%2==0) println("$n la so chan.")
    else println("$n la so le.")
}

fun bai2 () {
    print("ban kinh hinh tron r = ")
    val r = input()

    println("Chu vi hinh tron: ${"%.2f".format((2*r* PI))}")
    println("Dien tich hinh tron: ${"%.2f".format((r*r* PI))}")
}

fun bai3 () {
    print("Chieu dai a = ")
    val a = input()

    print("Chieu rong b = ")
    val b = input()

    println("Dien tich: ${"%.2f".format(a*b)}")
    println("Chu vi: ${"%.2f".format((a+b)*2)}")

}