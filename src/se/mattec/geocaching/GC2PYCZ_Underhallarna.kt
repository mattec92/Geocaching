package se.mattec.geocaching

fun main(args: Array<String>) {
    val minToMax = GC2PYCZ_Underhallarna.minToMax()
    val min = minToMax.first
    val max = minToMax.second
    println(min)
    println(max)
    println("N59 26.${min * 5 - 15}")
    println("E17 51.${(max * 2.5 - 22).toInt()}")
}

object GC2PYCZ_Underhallarna {

    fun minToMax(): Pair<Int, Int> {
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE

        (1..6).forEach { A ->
            (1..6).forEach { B ->
                (1..6).forEach { C ->
                    (1..6).forEach { D ->
                        (1..6).forEach { E ->
                            (1..6).forEach { F ->
                                val allIndices = setOf(A, B, C, D, E, F)
                                if (allIndices.size == 6) {
                                    val total = distancesA[A]!! + distancesB[B]!! + distancesC[C]!! + distancesD[D]!! + distancesE[E]!! + distancesF[F]!!
                                    if (total > max) {
                                        max = total
                                    }
                                    if (total < min) {
                                        min = total
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return min to max
    }

    private val distancesA = mapOf(
            1 to 24,
            2 to 22,
            3 to 23,
            4 to 16,
            5 to 33,
            6 to 33
    )

    private val distancesB = mapOf(
            1 to 55,
            2 to 42,
            3 to 34,
            4 to 24,
            5 to 44,
            6 to 55
    )

    private val distancesC = mapOf(
            1 to 21,
            2 to 15,
            3 to 11,
            4 to 24,
            5 to 43,
            6 to 44
    )

    private val distancesD = mapOf(
            1 to 12,
            2 to 12,
            3 to 54,
            4 to 42,
            5 to 35,
            6 to 15
    )

    private val distancesE = mapOf(
            1 to 16,
            2 to 31,
            3 to 14,
            4 to 22,
            5 to 31,
            6 to 21
    )

    private val distancesF = mapOf(
            1 to 36,
            2 to 51,
            3 to 31,
            4 to 26,
            5 to 44,
            6 to 67
    )

}