val visited = Array<Int>(102){0}
fun main() {
    val br = System.`in`.bufferedReader()
    val count = br.readLine().toInt()
    val connected = br.readLine().toInt()
    val hashMap = HashMap<Int, MutableList<Int>>()
    for (i in 1..count) {
        hashMap[i] = mutableListOf()
    }
    repeat(connected) {
        val (f, s) = br.readLine().split(" ")
        hashMap[f.toInt()]!!.add(s.toInt())
        hashMap[s.toInt()]!!.add(f.toInt())
    }
    dfs1(hashMap, 1)
    print(visited.sum()-1)
}

fun dfs1(map: HashMap<Int, MutableList<Int>>, current: Int) {
    visited[current] = 1
    if (map[current]!!.size == 0) {
        return
    }
    for (i in map[current]!!) {
        if (visited[i] == 1) continue
        dfs1(map, i)
    }
}