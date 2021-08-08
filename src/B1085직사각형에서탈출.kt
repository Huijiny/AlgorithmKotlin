import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (x, y, w, h) = br.readLine().split(" ").map { it.toInt() }
    val values = mutableListOf<Int>()
    values.add(w-x)
    values.add(h-y)
    values.add(x-0)
    values.add(y-0)
    print(values.sortedWith(compareBy { it }).first())
}