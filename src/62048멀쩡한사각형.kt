import kotlin.math.max
import kotlin.math.min

class Solution1 {
    fun solution(w: Int, h: Int): Long {
        val g = gcd(max(w, h), min(w, h))
        val longw = w.toLong()
        val longh = h.toLong()

        return ((longw * longh) - (longh+longw-g))
    }

    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)


}
fun main() {
    Solution1().solution(8, 12)
}