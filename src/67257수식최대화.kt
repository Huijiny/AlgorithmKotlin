import kotlin.math.abs
import kotlin.math.exp
import kotlin.reflect.typeOf

class Solution6 {
    fun solution(expression: String): Long {
        var answer: Long = 0
        var operations = expression.filter {
            !it.isDigit()
        }.toSet()
        permutation(operations.toList())
            .forEach { perm ->
            answer = dfs(expression, perm, 0).let { if (abs(it) > answer ) abs(it) else answer }
        }
        return answer
    }

    fun dfs(expression: String, operations: List<Char>, depth: Int): Long {
        if (expression.isLong()) return expression.toLong()

        val bundles = expression.split(operations[depth])

        var result: Long? = null
        for (bundle in bundles) {
            var value = dfs(bundle, operations, depth + 1)
            if (result == null) {
                result = value
            } else {
                result = calculation(operations[depth], result, value)
            }
        }
        return result!!

    }
    fun String.isLong(): Boolean {
        return try {
            this.toLong()
            true
        } catch (e: Exception) {
            false
        }
    }

    fun calculation(operation: Char, a: Long, b: Long): Long {
        return when (operation) {
            '*' -> (a * b)
            '+' -> (a + b)
            else -> (a - b)
        }
    }

    fun <T> permutation(el: List<T>, fin: List<T> = listOf(), sub: List<T> = el ): List<List<T>> {
        return if(sub.isEmpty()) listOf(fin)
        else sub.flatMap { permutation(el, fin + it, sub - it) }
    }
}

fun main() {
    print(Solution6().solution("50*6-3*2"))
}
//expression.forEach { char ->
//    if (operation == char) {
//        val before = stack.pop()
//        if (operation == '+') {
//            calculation( before.toLong(), char)
//        }
//    }
//}