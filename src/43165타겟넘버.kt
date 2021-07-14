class Solution5 {
    var g_ans = 0
    fun solution(numbers: IntArray, target: Int): Int {
        recursive(0, target, 0, numbers)
        return g_ans
    }

    fun recursive(idx: Int, target: Int, current: Int, numbers: IntArray) {
        if (idx == numbers.size) {
            if (target == current) {
                g_ans += 1
            }
            return
        } else {
            recursive(idx+1, target, current + numbers[idx], numbers)
            recursive(idx+1, target, current - numbers[idx], numbers)
        }
    }

}
fun main() {
    println(Solution5().solution(intArrayOf(1, 1, 1, 1, 1), 3))
}

fun solution2(numbers: IntArray, target: Int): Int{
    var tree = arrayListOf(0)
    numbers.forEach { number ->
        val childs = arrayListOf<Int>()
        tree.forEach { parent ->
            childs.add(parent + number)
            childs.add(parent - number)
        }
        tree = childs
        print(tree)
    }
    return tree.filter { it == target }.count()
}

//var g_ans = 0
//fun solution(numbers: IntArray, target: Int): Int {
//    recursive(numbers.size, target, 0)
//    return g_ans
//}
//
//fun recursive(length: Int, target: Int, current: Int) {
//    if (length == 0) {
//        if (target == current) {
//            g_ans += 1
//        }
//        return
//    } else {
//        val len = length - 1
//        recursive(len, target, current + 1)
//        recursive(len, target, current - 1)
//    }
//}