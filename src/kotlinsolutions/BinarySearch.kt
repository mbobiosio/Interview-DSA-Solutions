package kotlinsolutions

import java.util.*

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
fun main() {
    print(binarySearch(23, intArrayOf(12, 3, 24, 5, 10, 23, 9)))
}

fun binarySearch(element: Int, array: IntArray): Int {
    Arrays.sort(array)

    var index = 0
    var end = array.size - 1

    while (index <= end) {

        val center: Int = (index + end) / 2

        if (element == array[center]) {
            return center
        } else if (element < array[center]) {
            end = center - 1
        } else if (element > array[center]) {
            index = center + 1
        }
    }
    return -1
}