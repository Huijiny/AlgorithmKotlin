import kotlin.math.ceil

class Solution3 {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var days = intArrayOf()
        var answer = intArrayOf()
        for (i in 0..progresses.size-1) {
            days = days.plus(ceil(((100-progresses[i]) / speeds[i]).toDouble()).toInt())
        }
        var last = days[0]
        var cnt = 0
        days.forEach {
            if (last < it) {
                answer = answer.plus(cnt)
                cnt = 1
                last = it
            } else {
                cnt += 1
            }
        }
        if (cnt != 0) {
            answer = answer.plus(cnt)
        }
        answer.forEach {
            print(it)
        }
        return answer
    }
}
fun main() {
    println(Solution3().solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5)))
}