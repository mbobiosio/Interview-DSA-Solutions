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
object IntMaxOccurrenceSolutions {

    @JvmStatic
    fun main(args: Array<String>) {
        val list = listOf(12, 1, 17, 3, 17)
        val array = arrayOf(12, 1, 17, 3, 17)

        // getMaxAndOccurrence
        //println(getMaxAndOccurrenceCount(list))

        // maxOrNullOccurrence
        // println(maxOrNullOccurrence(list))

        // countMax
        println(maxOccurrenceMap())
    }

    private fun getMaxAndOccurrenceCount(list: List<Int>) {
        for (item in list.distinct()) {
            println("Frequency $item ${Collections.frequency(list, item)}")
        }
        println("Max Int ${list.maxOrNull()}")
    }

    private fun maxOrNullOccurrence(list: List<Int>) {
        val max = list.maxOrNull()
        val occurrence = list.count {
            it == max
        }
        println(max)
        println(occurrence)
    }

    private fun maxOccurrenceMap() {
        val list = listOf("B", "A", "A", "C", "B", "A")
        val frequencyMap: HashMap<String, Int> = HashMap()

        list.forEach { s ->
            var count = frequencyMap[s]
            if (count == null) count = 0
            frequencyMap[s] = count + 1
        }
        println(frequencyMap)
    }
}