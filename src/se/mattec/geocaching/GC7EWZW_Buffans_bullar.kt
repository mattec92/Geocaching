package se.mattec.geocaching

fun main(args: Array<String>) {
    val total1 = 336

    val alternatives = mutableSetOf<Alternatives>()

    (0..(total1 / 3)).forEach { snurra ->
        (0..(total1 / 4)).forEach { katt ->
            (0..(total1 / 6)).forEach { bjorn ->
                if (snurra * 3 + katt * 4 + bjorn * 6 == total1) {
                    alternatives += Alternatives(snurra, katt, bjorn)
                }
            }
        }
    }

    println("B=${alternatives.size}")

    val total2 = 36

    var count = 0

    fun decide(current: Int, next: Int) {
        if (current + next == total2) {
            count++
        } else if (current < total2) {
            decide(current + next, 3)
            decide(current + next, 6)
        }
    }

    decide(0, 3)
    decide(0, 6)

    println("C=$count")
}

private data class Alternatives(
        val snurra: Int,
        val katt: Int,
        val bjorn: Int
)