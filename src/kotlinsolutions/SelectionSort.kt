package kotlinsolutions

// The time complexity of selection sort is (O(n2)).

fun selectionSort(sampleArray: IntArray) {
    val n = sampleArray.size
    var temp: Int
    for (i in 0 until n) {
        var indexOfMin = i
        for (j in n - 1 downTo i) {
            if (sampleArray[j] < sampleArray[indexOfMin])
                indexOfMin = j
        }
        if (i != indexOfMin) {
            temp = sampleArray[i]
            sampleArray[i] = sampleArray[indexOfMin]
            sampleArray[indexOfMin] = temp
        }
    }
}

fun main() {
    println("Before Sort")
    val a = intArrayOf(1, 7, 3, 9, 4)
    for (i in a) print(i)

    selectionSort(a)

    println(" Sorted array is : ")
    for (i in a) print(i)
}