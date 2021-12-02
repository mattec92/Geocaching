package se.mattec.geocaching

import kotlin.math.round

fun main() {
    val max = baseConversion("1000000", 33, 10).toInt();
    var num = 0
    for (potentialPalindrome in 0 until max) {
        val potentialPalindromeString = baseConversion(potentialPalindrome.toString(), 10, 33)
        var isPalindrome = true
        for (i in 0 until potentialPalindromeString.length) {
            if (i >= potentialPalindromeString.length - 1 - i) {
                break
            }
            if (potentialPalindromeString[i] != potentialPalindromeString[potentialPalindromeString.length - 1 - i]) {
                isPalindrome = false
                break
            }
        }
        if (isPalindrome) {
            if (num % 100 == 0) {
                println("${round(potentialPalindrome / max.toDouble() * 100)}% complete.")
            }
            num++
        }
    }
    println(baseConversion(num.toString(), 10, 33))
}

private fun baseConversion(number: String, sourceBase: Int, destinationBase: Int): String {
    return Integer.toString(Integer.parseInt(number, sourceBase), destinationBase)
}