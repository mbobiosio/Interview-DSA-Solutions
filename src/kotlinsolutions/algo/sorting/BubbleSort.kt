package kotlinsolutions

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
// space complexity O(1)
// time complexity O(N) - best, O(N^2) - worst
fun bubbleSort(arr: IntArray): IntArray {
    var swap = true
    while (swap) {
        swap = false
        for (i in 0 until arr.size - 1) {
            if (arr[i] > arr[i + 1]) {
                val temp = arr[i]
                arr[i] = arr[i + 1]
                arr[i + 1] = temp

                swap = true
            }
        }
    }
    return arr
}

fun main() {
    val list = bubbleSort(intArrayOf(2, 15, 1, 8, 4))
    list.forEach { k ->
        print("$k ")
    }
}
