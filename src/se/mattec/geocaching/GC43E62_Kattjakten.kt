package se.mattec.geocaching

fun main(args: Array<String>) {
    val boxes = GC43E62_Kattjakten.boxes()
    val openBoxIndices = boxes
            .mapIndexed { index, open -> if (open) index else 0 }
            .filter { it != 0 }
    val sumOfOpenBoxIndices = openBoxIndices.sum()
    val numberOfCats = openBoxIndices.size

    val xxx = sumOfOpenBoxIndices * 3 + numberOfCats - 4
    // Boxes are 0-indexed in array, while 1-indexed in problem description.
    val yyy = openBoxIndices[3] * openBoxIndices[5] + numberOfCats - 6

    println("XXX=$xxx")
    println("YYY=$yyy")
    println("N 59° 28.$xxx")
    println("E 17° 53.$yyy")
}

object GC43E62_Kattjakten {

    fun boxes(): Array<Boolean> {
        val boxes = Array(49) { true }

        for (iteration in 2 until 49) {
            for (boxIndex in 0 until 49) {
                if (boxIndex % iteration == 0) {
                    boxes[boxIndex] = !boxes[boxIndex]
                }
            }
        }

        return boxes
    }


}