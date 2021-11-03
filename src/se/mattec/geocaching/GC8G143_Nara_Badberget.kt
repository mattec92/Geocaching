package se.mattec.geocaching

fun main() {
    for (L in 1..9) {
        for (E in 0..9) {
            if (setOf(L, E).size != 2) continue
            for (T in 0..9) {
                if (setOf(L, E, T).size != 3) continue
                for (A in 0..9) {
                    if (setOf(L, E, T, A).size != 4) continue
                    for (C in 1..9) {
                        if (setOf(L, E, T, A, C).size != 5) continue
                        for (H in 0..9) {
                            if (setOf(L, E, T, A, C, H).size != 6) continue
                            for (S in 1..9) {
                                if (setOf(L, E, T, A, C, H, S).size != 7) continue
                                for (G in 0..9) {
                                    if (setOf(L, E, T, A, C, H, S, G).size != 8) continue
                                    for (V in 1..9) {
                                        if (setOf(L, E, T, A, C, H, S, G, V).size != 9) continue
                                        for (N in 0..9) {
                                            if (setOf(L, E, T, A, C, H, S, G, V, N).size != 10) continue
                                            val leta = 1000 * L + 100 * E + 10 * T + A
                                            val cache = 10000 * C + 1000 * A + 100 * C + 10 * H + E
                                            val segla = 10000 * S + 1000 * E + 100 * G + 10 * L + A
                                            val vatten = 100000 * V + 10000 * A + 1000 * T + 100 * T + 10 * E + N
                                            if (leta + cache + segla != vatten) continue
                                            println("L=$L, E=$E, T=$T, A=$A, C=$C, H=$H, S=$S, G=$G, V=$V, N=$N")
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
