import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val M = br.readLine().toInt()
    val N = br.readLine().toInt()
    var sosus = mutableListOf<Int>()
    for (i in M..N) {
        if (isPrime(i)) {
            sosus.add(i)
        }
    }
    if (sosus.size == 0) {
        print(-1)
    } else {
        println(sosus.sum())
        println(sosus.get(0))
    }
}
fun isPrime(i: Int): Boolean {
    if (i == 1) return false
    for (j in 2..i-1) {
        if (i % j == 0) return false
    }
    return true
}