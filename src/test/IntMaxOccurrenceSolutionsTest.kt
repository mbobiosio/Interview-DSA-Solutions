package test

import kotlinsolutions.others.findCommon
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class IntMaxOccurrenceSolutionsTest {

    @Test
    fun testFindCommonString() {
        val mostCommon = findCommon(listOf("Hello", "World", "Coding", null, "Hello"))
        assertEquals("Hello", mostCommon)
    }

    @Test
    fun testFindCommonInt() {
        val mostCommon = findCommon(listOf(1, 2, null, 3, 4, 5, 1))
        assertEquals(1, mostCommon)
    }
}