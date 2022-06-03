package kotlinsolutions.meetingtime

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
 class AutoCorrectSuggestion {

    private fun autoCorrectSuggestion(input: String, destinations: Array<String>): Array<String> {
        val result = arrayListOf<String>()
        destinations.forEach { item ->
            when (input.length) {
                item.length -> {
                    difference(input, item)?.let { (a, _) ->
                        if (a.length <= 3)
                            result.add(item)
                    }
                }
            }
        }
        return result.toTypedArray()
    }


    private fun difference(a: String, b: String): Pair<String, String>? {
        return differenceHelper(a, b, HashMap<Long, Pair<String, String>?>())
    }

    private fun differenceHelper(
        a: String,
        b: String,
        lookup: HashMap<Long, Pair<String, String>?>
    ): Pair<String, String>? {
        val key = a.length.toLong() shl 32 or b.length.toLong()
        when {
            !lookup.containsKey(key) -> {
                val value: Pair<String, String>? = when {
                    a.isEmpty() || b.isEmpty() -> {
                        Pair(a, b)
                    }
                    a[0] == b[0] -> {
                        differenceHelper(a.substring(1), b.substring(1), lookup)
                    }
                    else -> {
                        val aa: Pair<String, String>? = differenceHelper(a.substring(1), b, lookup)
                        val bb: Pair<String, String>? = differenceHelper(a, b.substring(1), lookup)
                        when {
                            aa != null && bb != null -> if (aa.first.length + aa.second.length < bb.first.length + bb.second.length) {
                                Pair(a[0] + aa.first, aa.second)
                            } else {
                                Pair(bb.first, b[0] + bb.second)
                            }
                            else -> null
                        }
                    }
                }
                lookup[key] = value
            }
        }
        return lookup[key]
    }
}

