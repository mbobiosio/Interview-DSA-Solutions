package kotlinsolutions

import java.util.*

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
/**
 * Find max value of IntArray and count the occurrence
 * Using [Collections.frequency]
 * */
object MaxOccurrenceSolutions {

    @JvmStatic
    fun main(args: Array<String>) {
        val list = listOf(12, 1, 17, 3, 17)
        println(getMaxAndOccurrenceCount(list))
    }

    private fun getMaxAndOccurrenceCount(list: List<Int>) {
        for (item in list.distinct()) {
            println("Frequency $item ${Collections.frequency(list, item)}")
        }
        println("Max Int ${list.maxOrNull()}")
    }
}