fun convertToRoman(num: Int): String {
    var n = num
    val roman = StringBuilder()
    while (n >= 1000) {
        roman.append("M")
        n -= 1000
    }
    while (n >= 900) {
        roman.append("CM")
        n -= 900
    }
    while (n >= 500) {
        roman.append("D")
        n -= 500
    }
    while (n >= 400) {
        roman.append("CD")
        n -= 400
    }
    while (n >= 100) {
        roman.append("C")
        n -= 100
    }
    while (n >= 90) {
        roman.append("XC")
        n -= 90
    }
    while (n >= 50) {
        roman.append("L")
        n -= 50
    }
    while (n >= 40) {
        roman.append("XL")
        n -= 40
    }
    while (n >= 10) {
        roman.append("X")
        n -= 10
    }
    while (n >= 9) {
        roman.append("IX")
        n -= 9
    }
    while (n >= 5) {
        roman.append("V")
        n -= 5
    }
    while (n >= 4) {
        roman.append("IV")
        n -= 4
    }
    while (n >= 1) {
        roman.append("I")
        n -= 1
    }
    return roman.toString()
}

fun main() {
    val palindromes = mutableListOf<String>()
    for (i in 1 until 5445) {
        val roman = convertToRoman(i)
        if (roman == roman.reversed()) {
            palindromes += roman
        }
    }
    println(convertToRoman(palindromes.size))
}