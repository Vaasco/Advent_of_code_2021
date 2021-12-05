package Day3

import java.io.File

fun main() {
    var counter = 0
    var gamaRate = ""
    var epsilon = ""
    val input = File("src\\main\\kotlin\\Day3\\input").readLines()
    for (elem in input[0]) {
        counter++
    }
    val bitListByIdx = Array(counter) { "" }
    for (elem in input.indices) {
        for (word in 0 until counter) {
            bitListByIdx[word] += input[elem][word].toString()
        }
    }
    for (elem in bitListByIdx) {
        gamaRate += if (elem.checkIf1Majority()) '1'
        else '0'
    }
    for (elem in gamaRate) {
        epsilon += if (elem == '1') '0' else '1'
    }
    val fGamaRate = gamaRate.toInt(2)
    val fepsilon = epsilon.toInt(2)
    println(fGamaRate * fepsilon)
}

fun String.checkIf1Majority(): Boolean {
    var counter0 = 0
    var counter1 = 0
    for (elem in this) {
        if (elem == '1') counter1++
        else counter0++
    }
    return counter1 > counter0
}









