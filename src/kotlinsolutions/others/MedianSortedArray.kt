package kotlinsolutions.others

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
fun main() {
    println(findMedianSortedArrays(intArrayOf(3,6), intArrayOf()))
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    if (nums1.isEmpty() && nums2.isEmpty()) return 0.0
    val m = nums1.size
    val n = nums2.size
    val len = m + n
    var start1 = 0
    var start2 = 0
    var left = 0
    var right = 0
    (0..len / 2).forEach { _ ->
        left = right
        right = when {
            start1 < m && (start2 >= n || nums1[start1] < nums2[start2]) -> {
                nums1[start1++]
            }
            else -> {
                nums2[start2++]
            }
        }
    }
    return when {
        len % 2 == 0 -> {
            (left + right).toDouble() / 2
        }
        else -> {
            right.toDouble()
        }
    }
}
