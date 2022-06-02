package kotlinsolutions.dynamic

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
fun main(args: Array<String>) {
    print(
        suggestedMeetingTime(
            480 to 1080,
            arrayListOf(600 to 660, 720 to 780, 780 to 825, 900 to 940),
            780,
            45
        )
    )
}

fun suggestedMeetingTime(
    workingHours: Pair<Int, Int>,
    meetings: List<Pair<Int, Int>>,
    currentTime: Int,
    duration: Int
): String {
    when {
        currentTime < workingHours.first || currentTime > workingHours.second -> {
            return "No time available"
        }
        else -> {
            meetings.indices.forEach { i ->
                if (currentTime >= meetings[i].second && (currentTime + duration) <= meetings[i + 1].first) {
                    return "${meetings[i].second}-${meetings[i].second + duration}"
                }
            }

            return "No time available"
        }
    }
}

