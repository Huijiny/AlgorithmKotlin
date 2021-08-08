import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val K = br.readLine().toInt()
    val stack = mutableListOf<Int>()
    stack.add(0)
    for (i in 0..K-1) {
        val num = br.readLine().toInt()
        if (num == 0) {
            stack.removeAt(stack.size-1)
        } else {
            stack.add(num)
        }
    }
    print(stack.sum())
}