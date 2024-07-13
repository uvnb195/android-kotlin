package com.example.lab1.src

private fun main() {
//    println(lab2_bai1())
    lab2_bai3()
}

//Bài 1: Nhập 2 số a và b, Viết chương trình giải phương trình bậc 1: ax+b=0
fun lab2_bai1(): String {
    print("a = ")
    val a = input().toInt()
    print("b = ")
    val b = input().toInt()
    if (a == 0) {
        if (b == 0) return "Phuong trinh co VO SO NGHIEM"
        else return "Phuong trinh VO NGHIEM"
    } else {
        return "Phuong trinh co nghiem x =  ${"%.2f".format((-b.toDouble())/a)}"
    }
}

//Bài 2: Nhập vào một tháng bất kỳ, hỏi tháng này thuộc quý mấy trong năm. Biết
//rằng tháng 1, 2, 3 là quý 1; tháng 4, 5, 6 là quý 2; tháng 7, 8, 9 là quý 3; tháng 10,
//11, 12 là quý 4

fun lab2_bai2(): String {
    print("Nhap thang: ")
    val month = input().toInt()
    val message = "Thang ${month} "

    when (month){
        1,2,3 -> return( message + "thuoc quy 1")
        4,5,6 -> return ( message + "thuoc quy 2")
        7,8,9-> return ( message + "thuoc quy 3")
        10,11,12-> return ( message + "thuoc quy 4")
        else->  return "Nhap sai"
    }
}

//Bài 3: Viết chương trình kiểm tra 1 năm bất kỳ có phải năm nhuần hay không
//(Năm nhuần là năm chia hết cho 4 nhưng không chia hết cho 100 hoặc chia hết
//cho 400). Chương trình bắt buộc phải nhập năm >=0, nếu nhập sai bắt nhập lại
//cho tới khi nào nhập đúng, kết thúc chương trình cho phép người dùng lựa chọn
//tiếp tục hay không?

fun input2 ():Int{
    while (true){
        val s= readLine()
        if (s!=null && s.toInt() >0){
            return s.toInt()
        }
    }
}

fun checkYear (){
    print("Nhap nam: ")
    var year = input2()
    if ((year %4== 0 && year%100!=0) || (year % 400 ==0) ){
        println("${year} la nam nhuan")
    }else
        println("${year} khong phai la nam nhuan")
}

fun lab2_bai3 (){
    var s:String?
    while (true){
        checkYear()
        println("Ban co muon tiep tuc khong? (Y/N) ")
        s = readLine()
        if (s!=null && s.lowercase().equals("n")){
            return
        }
    }
}