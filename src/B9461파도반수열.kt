fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        println(wave(n))

    }
}

fun wave(n: Int): Long {
    val dp = LongArray(101){0}

    dp[1] = 1
    dp[2] = 1
    dp[3] = 1

    for (i in 4..n) {
        dp[i] = dp[i-3] + dp[i-2]
    }
    dp.forEach { println(it) }
    return dp[n]
}