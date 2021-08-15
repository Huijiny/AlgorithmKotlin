package codingTest

import kotlin.math.pow

class oy_1 {
    fun solution(x: IntArray, y: IntArray, r: IntArray, v: IntArray): Int {
        var answer: Int = 0
        val top = getMax(y, r)
        val btm = getMin(y, r)
        val right = getMax(x, r)
        val left = getMin(x, r)

        for (i in 0..v.size-1 step 2) {
            val pair = getRadomNumber(v[i], v[i+1], top, btm, right, left)
            for (i in 0..r.size-1) {
                if ((pair.first - x[i]).toFloat().pow(2) + (pair.second - y[i]).toFloat().pow(2) <= r[i].toFloat().pow(2)) {
                    answer += 1
                    break
                }
            }
        }
        return (answer.toFloat() / (v.size/2).toFloat() * (top-btm) * (right-left)).toInt()
    }
    fun getRadomNumber(x: Int, y: Int, t: Int, b: Int, r: Int, l: Int): Pair<Int, Int> {
        return Pair(l + x % (r - l), b + y % (t - b))
    }
    fun getMax(arr: IntArray, r: IntArray): Int {
        var max = 0
        var maxIdx = 0
        for (i in 0..arr.size-1) {
            if (arr[i] > max) {
                max = arr[i]
                maxIdx = i
            }
        }
        return max + r[maxIdx]
    }
    fun getMin(arr: IntArray, r: IntArray): Int {
        var min = 1000000
        var minIdx = 0
        for (i in 0..arr.size-1) {
            if (arr[i] < min) {
                min = arr[i]
                minIdx = i
            }
        }
        return min - r[minIdx]
    }
}

fun main() {
    oy_1().solution(intArrayOf(3, 4), intArrayOf(3, 5), intArrayOf(2, 3), intArrayOf(12, 83, 54, 35, 686, 337, 258, 95, 170, 831, 8, 15))
}