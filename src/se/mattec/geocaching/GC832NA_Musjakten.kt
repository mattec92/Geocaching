package se.mattec.geocaching

fun main() {
    val gridSize = 1000
    val grid = Array(gridSize) { Array(gridSize) { 0 } };

    var count = 1;

    for (col in 0 until gridSize * 2) {
        var colReverse = col
        for (row in 0 until gridSize * 2) {
            val colToUse = colReverse--
            if (row < gridSize && colToUse < gridSize) {
                grid[row][colToUse] = count++
            }

            if (colReverse < 0) {
                break
            }
        }
    }

    fun validSteps(row: Int, col: Int): List<Pair<Int, Int>> {
        return listOf(
                row + 2 to col + 1,
                row + 2 to col - 1,
                row + 1 to col + 2,
                row + 1 to col - 2,
                row - 2 to col + 1,
                row - 2 to col - 1,
                row - 1 to col + 2,
                row - 1 to col - 2
        ).filter { it.first >= 0 && it.second >= 0 }
    }

    var row = 0
    var col = 0
    val steps = Array(500 + 1) { 0 }
    val stepsSet = mutableSetOf<Int>()

    steps[1] = grid[row][col]
    stepsSet.add(grid[row][col])

    for (step in 2 until steps.size) {
        var bestNumber = Int.MAX_VALUE
        lateinit var bestStep: Pair<Int, Int>
        for (validStep in validSteps(row, col)) {
            val number = grid[validStep.first][validStep.second]
            if (number < bestNumber && !stepsSet.contains(number)) {
                bestNumber = number
                bestStep = validStep
            }
        }
        steps[step] = bestNumber
        stepsSet.add(bestNumber)
        row = bestStep.first
        col = bestStep.second
    }

    println("N${steps[85]}°${steps[25]}.0${steps[344] - steps[489]} E${steps[22]}°${steps[44]}.0${steps[250] - steps[187]}")
}