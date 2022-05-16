package kotlinsolutions

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
object SortArrays {

    @JvmStatic
    fun main(string: Array<String>) {
        val array1 = arrayOf(12, 1, 3, 5, 17)
        val array2 = arrayOf(3, 8, 15, 16, 22)

        sortArrays(array1, array2)
    }

    private fun sortArrays(array1: Array<Int>, arrays: Array<Int>) {
        val result = (array1 + arrays).sortedDescending().take(5)
        println(result)

    }
}