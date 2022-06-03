package kotlinsolutions.meetingtime

import java.util.*
import kotlin.Comparator

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class MeetingTime {
    /*
     *
     * Complete the 'suggestedMeetingTime' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. workingHours - Pair<Int, Int> - Start and end time of the working day
     *  2. meetings - List<Pair<Int, Int>> - List of meetings
     *  3. currentTime - Int
     *  4. duration - Int
     */
    /*
    *
    println(
        suggestedMeetingTime(
            480 to 1080,
            arrayListOf(600 to 660, 720 to 780, 780 to 825, 900 to 940),
            780,
            45
        )
    )
    * */
    fun suggestedMeetingTime(
        workingHours: Pair<Int, Int>,
        meetings: List<Pair<Int, Int>>,
        currentTime: Int,
        duration: Int
    ): String {

        val workStartTime = workingHours.first
        val workEndTime = workingHours.second

        val availableScheduleTime = Pair(workStartTime.coerceAtLeast(currentTime), workEndTime)

        var startTemp = availableScheduleTime.first

        val filtered = meetings.filter {
            it.first >= startTemp
        }

        filtered.forEachIndexed { index, pair ->

            when (startTemp) {
                in pair.first..pair.second -> {
                    startTemp = pair.second
                    return@forEachIndexed
                }
                else -> {
                    val end = startTemp + duration

                    val availableEnd = if (index != meetings.lastIndex) {
                        meetings[index + 1].first
                    } else {
                        availableScheduleTime.second
                    }


                    if (startTemp >= pair.second && end >= availableEnd) {
                        return "$startTemp-$end"
                    }
                }
            }
        }

        return "No time available"
    }


    /*
    *
    * */
    private fun findAvailable(
        meetings: List<Pair<Int, Int>>,
        availableScheduleTime: Pair<Int, Int>,
        start: Int,
        end: Int
    ): String? {
        meetings.forEachIndexed { index, pair ->

            val availableEnd = if (index != meetings.lastIndex) {
                meetings[index + 1].first
            } else {
                availableScheduleTime.second
            }

            if (start >= pair.second && end >= availableEnd) {
                return "$start-$end"
            }
        }

        return null
    }

    /*
    print(
        arrayOf(
            intArrayOf(0,30),
            intArrayOf(5,10),
            intArrayOf(15,20)
        )
    )
    * */

    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        if(intervals.isEmpty()) return 0
        val priority = PriorityQueue<Int>()
        Arrays.sort(intervals, Comparator<IntArray>{ a, b -> a[0] - b[0]})
        println(intervals)

        priority.add(intervals[0][1])
        for(i in 1 until intervals.size) {
            if(intervals[i][0] >= priority.peek()) {
                priority.poll()
            }
            priority.add(intervals[i][1])
        }
        return priority.size
    }
}