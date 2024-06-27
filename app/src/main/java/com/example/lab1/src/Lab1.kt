package com.example.lab1.src

fun main () {
    lab2()
}

fun lab1 () {
    println("Đào Hữu Quân - PD09237")
    println("=========================")
    println("Quanh năm buôn bán ở mom sông")
    println("Nuôi đủ năm con với một chồng")
    println("\tlặn lội thân cờ khi quãng vắng")
    println("\teo sèo mặt nước buổi đò đồng")
    println("Một duyên hai nợ âu đành phận")
    println("Năm nắng mười mưa há chẳng công")
    println("\tCha mẹ thói đời \"ăn ở bạc\"")
    println("\tCó chồng hờ hững cũng như không")
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

fun lab2 () {
    print("a=")
    val a = input()

    print("b=")
    val b = input()

    println("$a + $b = ${"%.1f".format(a+b)}")
    println("$a - $b = ${"%.1f".format(a-b)}")
    println("$a x $b = ${"%.1f".format(a*b)}")
    println("$a ÷ $b = ${"%.1f".format(a/b)}")
}