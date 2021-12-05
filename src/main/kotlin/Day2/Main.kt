package Day2

import java.io.File

enum class Type {
    FORWARD, DOWN, UP, DUMMY
}

data class SubmarineState(var horizontal: Int, var depth: Int, var aim: Int)
data class Command(val type: Type, val delta: Int)

fun main() {
    val input = File("src\\main\\kotlin\\Day2\\input").readLines()
    var submarine = SubmarineState(0, 0, 0)
    for (elem in input) {
        val (instruction, delta) = elem.split(" ")
        val command = Command(instruction.toCommandType(), delta.toInt())
        submarine = command.execute(submarine)

    }
    println(submarine.depth)
    println(submarine.horizontal)
    println(submarine.depth * submarine.horizontal)
}

fun Command.execute(submarineState: SubmarineState): SubmarineState {
    return when (this.type) {
        Type.DOWN -> submarineState.copy(aim = submarineState.aim + this.delta)
        Type.UP -> submarineState.copy(aim = submarineState.aim - this.delta)
        Type.FORWARD -> {
            submarineState.copy(horizontal = submarineState.horizontal + this.delta,
                depth = submarineState.depth + submarineState.aim * this.delta)
        }
        else -> error("Error")
    }
}

fun String.toCommandType(): Type {
    return when (this) {
        "forward" -> Type.FORWARD
        "down" -> Type.DOWN
        "up" -> Type.UP
        else -> throw IllegalArgumentException("Invalid type")
    }
}