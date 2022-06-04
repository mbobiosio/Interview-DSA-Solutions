package kotlinsolutions.meetingtime

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
val THOUSAND = arrayOf("", "Thousand,", "Million", "Billion")
val LESS_THAN_TWENTY = arrayOf("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
val HUNDRED = arrayOf("", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")

fun numberToWords(_num: Int): String {
    if (_num == 0) {
        return "Zero"
    }
    var num = _num
    val sb = StringBuilder()
    var index = 0
    while (num > 0) {
        when {
            num % 1000 != 0 -> {
                val tmp = StringBuilder()
                helper(num % 1000, tmp)
                sb.insert(0, tmp.append(THOUSAND[index]).append(" "))
            }
        }
        num /= 1000
        index++
    }
    return sb.toString().trim()
}

fun helper(num:Int, sb:StringBuilder) {
    if (num == 0) return
    when {
        num < 20 -> {
            sb.append(LESS_THAN_TWENTY[num]).append(" ")
        }
        num < 100 -> {
            sb.append(HUNDRED[num / 10]).append(" ")
            helper(num % 10, sb)
        }
        else -> {
            sb.append(LESS_THAN_TWENTY[num / 100]).append(" Hundred ")
            helper(num % 100, sb)
        }
    }
}

fun main() {
    val ret = numberToWords(980632)
    println(ret)
}



