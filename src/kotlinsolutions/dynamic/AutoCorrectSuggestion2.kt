package kotlinsolutions.dynamic

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class AutoCorrectSuggestion2 {
}

fun autoCorrectSuggestions(input: String, destinations: Array<String>): Array<String> {
    val res = arrayListOf<String>()
    val n = input.length
    var currentDiff = Int.MAX_VALUE
    destinations.forEach { s ->
        when {
            s.length != n -> {
                return@forEach
            }
            else -> {
                val diff = diffLength(input, s, currentDiff)
                when {
                    diff < currentDiff -> {
                        currentDiff = diff
                        res.clear()
                    }
                }
                when (diff) {
                    currentDiff -> {
                        res.add(s)
                    }
                }
            }
        }
    }
    return res.toTypedArray()
}

private fun diffLength(input: String, b: String, max: Int): Int {
    when {
        input.length != b.length -> {
            return Int.MAX_VALUE
        }
        else -> {
            var diff = 0
            input.indices.forEach { i ->
                when {
                    input[i] != b[i] -> {
                        diff++
                    }
                }
                when {
                    diff > max -> {
                        return Int.MAX_VALUE
                    }
                }
            }
            return diff
        }
    }
}
