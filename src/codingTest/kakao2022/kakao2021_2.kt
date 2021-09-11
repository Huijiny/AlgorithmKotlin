package codingTest.kakao2022

import java.lang.StringBuilder

class kakao2021_2 {
    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0

        val splitBy0 = conversion(n, k).split("0").filter { it.isNotBlank() }.map { it.toInt() }.sortedDescending()

        var isNotPrimeList = getNotPrimeList(splitBy0[0])
        splitBy0.forEach { value ->
            if(!isNotPrimeList[value]) {
                answer += 1
            }
        }
        return answer
    }

    private fun conversion(n: Int, k: Int): StringBuilder {
        var number = n
        var sb = StringBuilder()

        while (number > 0) {
            var rest = number % k
            if (rest < 10) {
                sb.append(rest)
            } else {
                sb.append((number % k - 10 + 'A'.digitToInt()).toChar())
            }
            number /= k
        }
        return sb.reverse()
    }

    private fun getNotPrimeList(m: Int): BooleanArray {
        var notPrime = BooleanArray(m+1)
        notPrime[0] = true
        notPrime[1] = true
        for (i in 2..m) {
            if (notPrime[i]) continue
            var j = i*2
            while (j <= m) {
                notPrime[j] = true
                j += i
            }
        }
        return notPrime
    }
}

fun main() {
    kakao2021_2().solution(437674, 3)
}