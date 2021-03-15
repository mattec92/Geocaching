package se.mattec.geocaching

@ExperimentalUnsignedTypes
fun main(args: Array<String>) {
    // L         A1,North
    var A1 = 3892315697.toUInt()

    // L         A2,East
    var A2 = 369098810.toUInt()

    // DSC     A1,9
    val combined1 = A1.toULong().shl(32) + A2.toULong()
    val shifted1 = combined1.rotateRight(9)
    A1 = shifted1.shr(32).toUInt()
    A2 = shifted1.shl(32).shr(32).toUInt()

    // LSSC   A1,5
    A1 = A1.rotateLeft(5)

    // LSSC   A2,7
    A2 = A2.rotateLeft(7)

    // DSC     A1,8
    val combined2 = A1.toULong().shl(32) + A2.toULong()
    val shifted2 = combined2.rotateRight(8)
    A1 = shifted2.shr(32).toUInt()
    A2 = shifted2.shl(32).shr(32).toUInt()

    // SSC     A1,13
    A1 = A1.rotateRight(13)

    // SSC     A2,15
    A2 = A2.rotateRight(15)

    println("N $A1")
    println("E $A2")
}

@ExperimentalUnsignedTypes
fun UInt.rotateLeft(bitCount: Int): UInt = Integer.rotateLeft(toInt(), bitCount).toUInt()

@ExperimentalUnsignedTypes
fun UInt.rotateRight(bitCount: Int): UInt = Integer.rotateRight(toInt(), bitCount).toUInt()

@ExperimentalUnsignedTypes
fun ULong.rotateLeft(bitCount: Int): ULong = java.lang.Long.rotateLeft(toLong(), bitCount).toULong()

@ExperimentalUnsignedTypes
fun ULong.rotateRight(bitCount: Int): ULong = java.lang.Long.rotateRight(toLong(), bitCount).toULong()
