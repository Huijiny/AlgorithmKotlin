// 미완성 코드
class Solution77885 {
    fun solution(numbers: LongArray): LongArray {
        var answer: LongArray = LongArray(numbers.size)
        for (i in 0..numbers.size-1) {
            answer[i] = findNumber(numbers[i])
        }
        println(answer)
        return answer
    }

    fun findNumber(number: Long): Long {
        var num = number
        var notfind = true
        while (notfind) {
            num += 1
            val n = Integer.toBinaryString(num.toInt().xor(number.toInt())).count{ it == '1'}
            if (n < 3) {
                notfind = false
            }
        }
        return num
    }
}
fun main() {
    Solution77885().solution(longArrayOf(2, 7))
}