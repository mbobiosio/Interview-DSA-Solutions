package kotlinsolutions

import java.util.*
import java.util.stream.Collectors


/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
object StringMaxOccurrence {

    private fun countInstances(string: String) {

        val count = countChar(string)
        val noRepeatString = Arrays.stream(string.split("".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
                .distinct()
                .collect(Collectors.joining())
        for (i in noRepeatString.indices) {
            println("The char '" + noRepeatString[i] + "' shows up "
                    + count[noRepeatString[i].code] + " times")
        }
    }

    private fun countChar(string: String): IntArray {
        val count = IntArray(string.chars().max().orElse(0) + 1)
        for (element in string) count[element.code]++
        return count
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val str = "mbuodileobiosio"

        println(countInstances(str))
    }

}