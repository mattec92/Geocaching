package se.mattec.geocaching

fun main() {
    var aaa = 0
    var bbb = 0
    var x = 1
    while (aaa < 1000 && bbb < 1000) {
        aaa = fibonacci(15) + fibonacci(x) - 39
        bbb = fibonacci(13) - 20
        println("aaa=$aaa, bbb=$bbb x=$x")
        // Second to last was correct (x=14)
        x++
    }
}

fun fibonacci(n: Int): Int {
    return when (n) {
        1, 2 -> 1
        else -> fibonacci(n - 1) + fibonacci(n - 2)
    }
}