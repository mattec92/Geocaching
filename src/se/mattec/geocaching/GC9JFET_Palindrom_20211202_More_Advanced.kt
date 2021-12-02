package se.mattec.geocaching

import kotlin.math.round

fun main() {
    val max = baseConversion("1000000", 22, 10).toInt();
    var num = 0
    var sum = 0L
    for (potentialPalindrome in 0 until max) {
        val potentialPalindromeString = baseConversion(potentialPalindrome.toString(), 10, 22)
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
            sum += potentialPalindrome
        }
    }
    println(baseConversionLong(sum.toString(), 10, 22))
}

private fun baseConversion(number: String, sourceBase: Int, destinationBase: Int): String {
    return Integer.toString(Integer.parseInt(number, sourceBase), destinationBase)
}

private fun baseConversionLong(number: String, sourceBase: Int, destinationBase: Int): String {
    return java.lang.Long.toString(java.lang.Long.parseLong(number, sourceBase), destinationBase)
}