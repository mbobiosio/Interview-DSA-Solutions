package kotlinsolutions

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class LinkedList<T : Any> {

    private var head: Node? = null
    private var tail: Node? = null
    private var size = 0

    fun insertFirst(value: T) {
        val node = Node(value)
        node.next = head
        head = node
        if (tail == null) {
            tail = head
        }
        size += 1
    }

    fun insertLast(value: T) {
        if (tail == null) {
            insertFirst(value)
            return
        }
        val node = Node(value)
        tail?.next = node
        tail = node
        size++
    }

    fun insert(value: T, index: Int) {
        if (index == 0) {
            insertFirst(value)
            return
        }
        if (index == size) {
            insertLast(value)
            return
        }
        var temp = head
        for (i in 1 until index) {
            temp = temp?.next
        }
        val node = Node(value)
        temp?.next = node
        size++
    }

    fun find(value: Int): Node? {
        var node = head
        while (node != null) {
            if (node.value === value) {
                return node
            }
            node = node.next
        }
        return null
    }

    operator fun get(index: Int): Node? {
        var node = head
        for (i in 0 until index) {
            node = node?.next
        }
        return node
    }

    fun display() {
        var temp = head
        while (temp != null) {
            print(temp.value.toString() + " -> ")
            temp = temp.next
        }
        println("END")
    }

    inner class Node(var value: T) {
        var next: Node? = null

    }
}


fun main() {

    val ll = LinkedList<Int>()
    ll.insertFirst(3)
    ll.insertFirst(4)
    ll.insertFirst(5)

    ll.display()
}