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
        // println(maxOccurrenceMap())

        // sorting list
        // println(sortingArray(array))

        // arrayToList
        // println(arrayToList(array))

        // double array
        findDoubleArray()
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

    private fun sortingArray(array: Array<Int>) {
        array.sort()

        println("Max: ${array.first()}")
        println("Min: ${array.last()}")
    }

    private fun arrayToList(array: Array<Int>) {
        val ints = array.toList()

        println("Max: ${ints.maxOrNull()}")
        println("Min: ${ints.minOrNull()}")
    }

    /**
    * find common element in a list using a generic
    * */
    fun <T> findCommon(list: List<T>): T? {
        return list
                .groupBy { it }
                .maxByOrNull { it.value.size }
                ?.key
    }

    fun findDoubleArray() {
        val array = doubleArrayOf(3.4, -34.5, 50.0, 33.5, 55.5, 43.7, 5.7, -66.5)
        var largest = array[0]

        for (num in array) {
            if (largest < num)
                largest = num
        }

        println("Largest = %.2f".format(largest))
    }
}