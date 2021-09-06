class Solution76502 {
    val map = mapOf(')' to '(',
        '}' to '{',
        ']' to '['
    )
    fun solution(s: String): Int {
        var cnt = 0
        for (i in 0..s.length-1) {
            val tmpS = s.substring(i) + s.substring(0, i)
            if (isPair(tmpS)) {
                cnt += 1
            }
        }
        print(cnt)
        return cnt
    }

    fun isPair(s: String): Boolean {
        val stack = mutableListOf<Char>()
        for (i in 0..s.length-1) {
            if (s[i] in "({[") {
                stack.add(s[i])
            } else {
                if (stack.isEmpty()) return false

                val last = stack.last()
                if (last != map.get(s[i])) return false

                stack.removeAt(stack.size-1)
            }
        }
       if (!stack.isEmpty()) return false

        return true
    }
}
fun main() {
    Solution76502().solution("[](){}")
}