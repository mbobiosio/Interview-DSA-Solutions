package kotlinsolutions

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
// Kotlin program of factorial using recursion
fun fact(num: Int): Long {
    return when (num) {
        1 -> num.toLong()        // terminate condition
        else -> num * fact(num-1)
    }
}
//main method
fun main() {
    println("Factorial of 5 is: "+fact(5))
//Recursive call
}