import kotlin.math.min

class Solution {
    fun solution(s: String): Int {
        var answer = s.length
        for (i in 1 ..  s.length / 2) {
            var newStr = ""
            var prevStr = s.substring(0, i)
            var cnt = 1
            for (j in i .. s.length step i) {
                var currentStr = ""
                if (i+j <= s.length) currentStr  = s.substring(j, j+i)
                else currentStr = s.substring(j)

                // 만약에 현재랑 이전 str이랑 다르면?
                if (currentStr != prevStr) {
                    // 이전꺼 cnt가 1이하면 걔밖에 없단 소리니까 그냥 붙이고
                    if (cnt <= 1) {
                        newStr += prevStr
                    } else {
                        // 이상이면 문자열 만들어서 붙이고
                        newStr += cnt.toString() + prevStr
                    }
                    cnt = 1
                } else {
                    cnt += 1
                }
                prevStr = currentStr
                // 마지막 남은 애들 붙이
                if (i+j > s.length) newStr += prevStr
                if (newStr.length >= answer) break
            }

            answer = Math.min(answer, newStr.length)
        }
        return answer
    }
}

fun main() {
    println(Solution().solution("xababcdcdababcdcd"))
}