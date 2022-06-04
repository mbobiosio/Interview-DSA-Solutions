package kotlinsolutions.others

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
fun main() {
    val card1 = mutableListOf("Jack", 8, 2, 6, "King", 5, 3, "Queen")
    val card2 = mutableListOf("Jack", 8, 2, 6, "King", 5, 3, "Queen", "Jack", "King", "Queen", "Queen", "King", "Jack")
    val card3 = mutableListOf("Jack", 8, 2, 6, 5, 3)

    println(sortCards(card2))
}

private fun sortCards(cards: MutableList<*>): List<*> {
    val orderCards = arrayListOf("Ace", 2, 3, 4, 5, 6, 7, 8, 9, 10, "Jack", "Queen", "King")
    cards.sortWith { p, p2 ->
        orderCards.indexOf(p) - orderCards.indexOf(p2)
    }
    return cards
}
