package se.mattec.geocaching

fun main() {
    for (base10 in 2345665432L downTo 0) {
        val base22 = baseConversionLong(base10.toString(), 10, 22)
        if (base22 == base22.reversed()) {
            val base33 = baseConversionLong(base10.toString(), 10, 33)
            if (base33 == base33.reversed()) {
                println("$base10,$base22,$base33")
                break
            }
        }
    }
}

private fun baseConversionLong(number: String, sourceBase: Int, destinationBase: Int): String {
    return java.lang.Long.toString(java.lang.Long.parseLong(number, sourceBase), destinationBase)
}