package se.mattec.geocaching

import java.lang.Math.pow

fun main(args: Array<String>) {
    val wxyz = getWXYZ().toString()
    val w = wxyz[0].toString().toInt()
    val x = wxyz[1].toString().toInt()
    val y = wxyz[2].toString().toInt()
    val z = wxyz[3].toString().toInt()
    println("N59°22.${(pow(w.toDouble(), 0.0) + pow(x.toDouble(), 1.0) + pow(y.toDouble(), 2.0) + pow(z.toDouble(), 3.0) + w + x + z).toInt()}")
    println("E17°47.${3L * w * factorial((y - w)) / (w + x + y + z) + z * (w + y) + 3L * w}")
}

fun factorial(n: Int): Long {
    var fact = 1L
    for (i in 2..n) {
        fact *= i
    }
    return fact
}

private fun getWXYZ(): Int {
    for (a in 1..9) {
        for (b in 0..9) {
            for (c in 1..9) {
                if (a < c) {
                    break
                }

                val abc = a * 100 + b * 10 + c
                val cba = c * 100 + b * 10 + a
                val def = abc - cba

                if (def < 100) {
                    break
                }

                val defString = def.toString()
                val fed = defString[2].toString().toInt() * 100 + defString[1].toString().toInt() * 10 + defString[0].toString().toInt()
                val wxyz = def + fed

                // When printing wxyz it always returned the same value, so just return the first one
                println(wxyz)
                return wxyz
            }
        }
    }
    throw IllegalStateException("No solution found - should never happen.")
}
