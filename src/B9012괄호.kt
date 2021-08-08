import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()
    for (tc in 0..T-1) {
        val stack = mutableListOf<Char>()
        val list = br.readLine()
        for (str in list) {
            if (str.equals('(')) {
                stack.add(str)
            } else {
                if (stack.size > 0) {
                    stack.removeAt(stack.size-1)
                } else {
                    stack.add(str)
                    break
                }
            }
        }
        if (stack.size > 0) {
            println(("NO"))
        } else {
            println("YES")
        }

    }
}