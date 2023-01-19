fun main() {
    val palindromes = findPalindromes(666)
    val allCombinations = mutableListOf<List<Int>>()
    findPalindromeCombinations(666, palindromes, palindromes.size, 666, mutableListOf<Int>(), allCombinations)
    println(allCombinations.size)
}

fun findPalindromes(n: Int): List<Int> {
    val palindromes = mutableListOf<Int>()
    for (i in 11 until n) {
        val str = i.toString()
        if (str == str.reversed()) {
            palindromes.add(i)
        }
    }
    return palindromes
}

fun findPalindromeCombinations(sum: Int, palindromes: List<Int>, i: Int, j: Int, current: MutableList<Int>, allCombinations: MutableList<List<Int>>) {
    if (j == 0 && current.size == 3) {
        allCombinations.add(current.toList())
        return
    }
    if (i == 0) {
        return
    }
    if (palindromes[i - 1] > j) {
        findPalindromeCombinations(sum, palindromes, i - 1, j, current, allCombinations)
    } else {
        findPalindromeCombinations(sum, palindromes, i, j - palindromes[i - 1], (current + palindromes[i - 1]).toMutableList(), allCombinations)
        findPalindromeCombinations(sum, palindromes, i - 1, j, current, allCombinations)
    }
}