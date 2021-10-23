package se.mattec.geocaching

fun main(args: Array<String>) {
    for (Gyrid in 1..9) {
        for (Ormhild in 1..9) {
            for (Disa in 1..9) {
                for (Joar in 1..9) {
                    for (Unn in 1..9) {
                        for (Loke in 1..9) {
                            if (Gyrid * Ormhild * Disa != 144) continue
                            if (Gyrid >= Ormhild) continue
                            if (Gyrid >= Disa) continue
                            if (Ormhild >= Disa) continue
                            if (Joar * Unn * Loke != 72) continue
                            if (Joar + Unn + Loke != Disa + Ormhild) continue
                            if (Unn <= Loke) continue
                            println("$Gyrid, $Ormhild, $Disa, $Joar, $Unn, $Loke")
                            // Second answer was correct
                        }
                    }
                }
            }
        }
    }
}
