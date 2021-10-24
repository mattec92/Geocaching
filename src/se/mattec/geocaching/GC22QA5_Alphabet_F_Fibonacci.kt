package se.mattec.geocaching

fun main() {
    var aaa = 0
    var bbb = 0
    var x = 3
    while (aaa < 1000 && bbb < 1000) {
        aaa = fibonacci(13) + fibonacci(11) + fibonacci(x + 1)
        bbb = fibonacci(10) + fibonacci(x - 2) - fibonacci(4)
        x++
        println("aaa=$aaa, bbb=$bbb")
        // Second to last was correct
    }
}

fun fibonacci(n: Int): Int {
    return when (n) {
        1, 2 -> 1
        else -> fibonacci(n - 1) + fibonacci(n - 2)
    }
}