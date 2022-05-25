package kotlinsolutions

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
// FIFO
class Queue<T : Any> {
    private val list = mutableListOf<T>()
    fun enqueue(value: T) {
        list.add(value)
    }

    fun dequeue(): T {
        require(list.isNotEmpty())
        return list.removeAt(0)
    }

    val items
        get() = list
}

fun main() {
    val s = Queue<Int>()

    s.enqueue(12)
    s.enqueue(13)
    s.enqueue(2)
    s.enqueue(65)

    s.items.forEach {
        println(it)
    }
    println("dequeue ${s.dequeue()}")

    s.items.forEach {
        println(it)
    }
}