package Day1

import java.io.File


fun main() {
    val input = File("src\\main\\kotlin\\Day1\\input").readLines()
    var counter1 = 0
    val input1 = input.zipWithNext()
    input1.map { if (it.second > it.first) counter1++ }

    val input2 = File("src\\main\\kotlin\\Day1\\input").readLines().map { it.toInt() }.windowed(3)
    var counter2 = 0
    for (elem in 0..input2.size - 2) {
        if (input2[elem + 1].sum() > input2[elem].sum()) counter2++
    }
    println("Solution part1:$counter1")
    println("Solution part2:$counter2")
}



