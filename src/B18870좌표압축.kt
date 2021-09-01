import java.util.*
import kotlin.collections.HashMap

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val st = StringTokenizer(readLine())
    val arr = IntArray(n)
    var i = 0
    while (st.hasMoreTokens()) {
        arr[i] = st.nextToken().toInt()
        i += 1
    }
    val comparedArr = arr.sorted()
    var map = mutableMapOf<Int, Int>()
    var cnt = -1
    for (i in 0..comparedArr.size-1) {
        map.put(comparedArr[i], map.getOrDefault(comparedArr[i], cnt) + 1)
        cnt += 1
    }

    map.forEach{idx, value -> println("$idx $value")}
    arr.forEach { print("${map.get(it)} ")}
}


// 시간 초과 코드
//fun main() {
//    val br = System.`in`.bufferedReader()
//    val n = br.readLine().toInt()
//    val array = br.readLine().split(" ").map { it.toInt() }
//    val comparedArray = array.distinct().sorted().withIndex()
//    var map = HashMap<Int, Int>()
//    comparedArray.forEach {
//        map.put(it.value, it.index)
//    }
//    array.forEach { print("${map.get(it)} ")}
//}
