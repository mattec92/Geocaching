package se.mattec.geocaching

fun main(args: Array<String>) {
    var min = Int.MAX_VALUE
    var minRoute: List<Int>? = null

    (0 until 8).forEach { r1 ->
        (0 until 8).forEach { r2 ->
            (0 until 8).forEach { r3 ->
                (0 until 8).forEach { r4 ->
                    (0 until 8).forEach { r5 ->
                        (0 until 8).forEach { r6 ->
                            (0 until 8).forEach { r7 ->
                                val route = listOf(r1, r2, r3, r4, r5, r6, r7, 0)
                                if (route.toSet().size == 8) {
                                    var sum = 0
                                    var last = 0
                                    route.forEach {
                                        sum += distances[last][it]
                                        last = it
                                    }
                                    if (sum < min) {
                                        min = sum
                                        minRoute = route
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    println("${minRoute!!.map { (it + 65).toChar() }.joinToString("").reversed()}A$min")
}

private val distances = listOf(
        listOf(0, 25, 24, 26, 27, 35, 41, 32),
        listOf(25, 0, 12, 27, 14, 10, 29, 37),
        listOf(24, 12, 0, 10, 13, 45, 35, 40),
        listOf(26, 27, 10, 0, 22, 16, 32, 24),
        listOf(27, 14, 13, 22, 0, 28, 31, 12),
        listOf(35, 10, 45, 16, 28, 0, 18, 25),
        listOf(41, 29, 35, 32, 31, 18, 0, 19),
        listOf(32, 37, 40, 24, 12, 25, 19, 0)
)
