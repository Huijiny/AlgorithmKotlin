class Solution70129 {
    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf(0, 0)
        var x = s
        var cnt = 0
        var round = 0
        while (!x.equals("1")) {
            x.forEach { i ->
                if (i == '0') cnt += 1
            }
            val l = x.replace("0", "").length
            x = Integer.toBinaryString(l)
            round += 1
            println(x)
        }
        answer[0] = round
        answer[1] = cnt
        return answer
    }
}
fun main() {
    Solution70129().solution("110010101001")
}