import java.util.*

class `60058괄호변환` {
    fun solution(p: String): String {
        var answer = ""
        var u = ""
        var v = ""
        if (p.isNotBlank()) {
            var left = 0
            var right = 0
            for (i in 0..p.length) {
                if (p[i].equals(')')) {
                    left += 1
                } else {
                    right += 1
                }
                if (left == right) {
                    u = p.substring(0, i+1)
                    v = p.substring(i+1)
                    break
                }
            }
            if (checkIsRight(u)) {
                answer = u + solution(v)
            } else {
                var tmp = ""

                u = u.substring(1, u.length-1)
                for (i in 0..u.length-1) {
                    if (u[i].equals('(')) {
                        tmp += ")"
                    } else {
                        tmp += "("
                    }
                }
                answer = "(" + solution(v) + ")" + tmp
            }
            return answer
        }
        return ""
    }
    fun checkIsRight(s: String): Boolean {
        var open = 0
        var close = 0
        var isRegular = false
        for (i in 0..s.length-1) {
            if (s[i].equals('(')) {
                open += 1
            } else {
                close += 1
            }
            if (open < close) {
                isRegular = false
                break
            } else {
                isRegular = true
            }
        }
        return isRegular
    }
}
fun main() {
    print(`60058괄호변환`().solution("()))((()"))
}