import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val count = br.readLine().toInt()
    val stack = mutableListOf<Int>()
    repeat(count) { i ->
        val tokens = br.readLine()
        if (tokens.startsWith("push")) {
            stack.add(tokens.split(" ")[1].toInt())
        } else {
            when (tokens) {
                "top" -> {
                    if (stack.size == 0) {
                        println(-1)
                    } else {
                        println(stack.last())
                    }
                }
                "size" -> {
                    println(stack.size)
                }
                "empty" -> {
                    if (stack.size == 0) {
                        println(1)
                    } else {
                        println(0)
                    }
                }
                "pop" -> {
                    if (stack.size == 0) {
                        println(-1)
                    } else {
                        println(stack.removeAt(stack.size-1))
                    }
                }
            }
        }
    }
}