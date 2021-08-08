import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()
    for (i in 0..T-1) {
        var count = 0
        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        val priorities = br.readLine().split(" ").map { it.toInt() }.withIndex().toMutableList()
        while (priorities.isNotEmpty()) {
            val current = priorities.first()
            priorities.removeAt(0)
            if (priorities.any { current.value < it.value }) {
                priorities.add(current)
            } else {
                count += 1
                if (M == current.index) {
                    break
                }
            }
        }
        println(count)
    }
}