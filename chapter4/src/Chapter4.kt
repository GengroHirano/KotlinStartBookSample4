/**
 * Chapter4
 */

package sample


fun main(args: Array<String>) {
    printNumeric()
    printString()
    printArrays()
    printPrimitiveArrays()
    printCollections()
    printRange()
    branching()
    loopSample()
}

fun loopSample() {
    divider()
//    break も continue も普通に使える
    var count = 10
    while(count-- > 0) {
        println("Hello ${count}")
    }

//    forも使える 使い方は for(要素名 in イテレータを提供するオブジェクト)
    for (x in 1..10) {
        println("HELLO ${x}")
    }


    //イテレータを提供するオブジェクトの作り方
    class MyIterator {
        operator fun hasNext(): Boolean = Math.random() < 0.5
        operator fun next(): String = "Wasshoi!!"
    }

    class MyIterable {
        operator fun iterator() = MyIterator()
    }

    for (x in MyIterable()) {
        println(x)
    }

//    ラベルジャンプ どうやら関数名とかぶる名前のラベルは使えないみたい…
    loop@for (x in 1..10) {
        for (y in 1..10) {
            println("Hello ${x}, ${y}")
            if (y == 5)
                break@loop
        }
    }

}

fun branching() {
    divider()
//    条件分岐の使い方はjavaとほぼ変わらないから省略
//    三項演算子がいらないね if式は最後に評価された式がかえされる
    val score = 50
    val message = if (score >= 50) "合格" else "不合格"
    println(message)

    val x = if (true){
        1
        2
    } else {
        3
    }
    println(x)

    fun myFavoriteInt(): Int {
        return 2
    }

//    when式 色々なものが比較対象として使える
    println(
            when(x) {
                1 -> "one"
                myFavoriteInt() -> "favorite: $x"
                in 3..10 -> "1 <= $x =< 10"
                else -> x.toString()
            }
    )
}

fun printRange() {
    println(1..10)
//    レンジをリストにしたいときは
    println((1..10).toList())

//    レンジを逆順にしたいときは reversed または downtoを使う
    println((10 downTo 1).toList())
//    指定した数値で刻むときは
    println((1..10 step 2).toList())
    println(5 in 1..10)
}

fun printCollections() {
    divider()
//    list 変更不可
    val ints: List<Int> = listOf(1, 2, 3)
    println("ints size: ${ints.size}")
    println(ints)

//    list 変更可能
    val chars: MutableList<Char> = mutableListOf('a', 'b', 'c')
    chars[0] = 'c'
    println(chars)
    chars += 'X'
    println(chars)
    chars -= 'X'
    println(chars)
    chars.removeAt(0)
    println(chars)

//    set 変更不可
    val intSets: Set<Int> = setOf(1, 2, 3, 1)
    println(intSets)
//    どうやらinも使えるみたい
    println(4 in intSets)

//    set 変更可能
    val charSets: MutableSet<Char> = mutableSetOf('a', 'b', 'a')
    println(charSets)
    charSets -= 'a'
    println(charSets)

//    map 変更不可
    val numberMap: Map<String, Int> = mapOf("one" to 1, "two" to 2)
    println(numberMap["one"])

//    map 変更可能
    val mutableNumberMap: MutableMap<String, Int> = mutableMapOf("one" to 1, "two" to 2)
    println(mutableNumberMap)
    mutableNumberMap += "three" to 3
    println(mutableNumberMap)

}

fun printPrimitiveArrays() {
    divider()
    val ints = intArrayOf(1, 2, 3)
    println(ints[0])

    val chars = charArrayOf('a', 'b')
    println("${chars[0]}, ${chars[1]}")
}

fun printArrays() {
    divider()
    val ints = kotlin.arrayOfNulls<Int>(5)
    val strs = arrayOf("red", "green", "blue")
    println("size: ${ints.size}")
    println(ints[0])
    println(strs[0])

    ints[0] = 123
    println(ints[0])
}

fun printString() {
    divider()
    val name: String = "abcdefg"

    println("length: ${name.length}")

    // capitalize: 頭文字を大文字にして返す
    println("capitalize: ${name.capitalize()}")

    val blank: String  = "   　　　"
    // isBlank: から文字化空白のみで構成された文字列の時にtrueを返す
    println("text is blank?: ${blank.isBlank()}")

    //raw string trimMarginについてはよく調べておこう
    println("""
                |It's
                |Kotlin
                |Raw String
            """.trimMargin())
}

fun printNumeric() {
    divider()
    val double: Double = 123.4
    val float: Float = 123.4f

    println("normal double value: ${double}")
    println("normal float value: ${float}")

    val double2: Double = 123.4e2
    println("double value 123.4 * 10^2: ${double2}")

    val double3: Double = 123.4e-1
    println("double value 123.4 * 10^-1: ${double3}")

    println("decimal value: ${1234}")
    println("hexadecimal value: ${0xFF}")
    println("binary value: ${0b1010}")
}

fun divider() = println("------------------------------")




