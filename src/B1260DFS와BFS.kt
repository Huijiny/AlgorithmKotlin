fun main() {
    val br = System.`in`.bufferedReader()
    val (N, M, V) = br.readLine().split(" ").map { it.toInt() }
    val hashMap = HashMap<Int, MutableList<Int>>()
    for (i in 1..N) {
        hashMap[i] = mutableListOf()
    }
    repeat(M) {
        val (node, next) = br.readLine().split(" ")
        hashMap[node.toInt()]!!.add(next.toInt())
        hashMap[next.toInt()]!!.add(node.toInt())
    }
    hashMap.forEach { t, u -> u.sort() }
    dfs(hashMap, V, Array(N+1){0})
    println()
    bfs(hashMap, V, Array(N+1){0})
}

fun dfs(map: HashMap<Int, MutableList<Int>>, current: Int, visited: Array<Int>) {
    visited[current] = 1
    print("$current ")
    if (map[current]!!.size == 0) {// 만약에 더 이상 갈 곳이 없으면
        return
    }
    for (i in map[current]!!) {
        if (visited[i] == 1) continue
        dfs(map, i, visited)
    }
}

fun bfs(map: HashMap<Int, MutableList<Int>>, current: Int, visited: Array<Int>) {
    val q = mutableListOf<Int>()
    q.add(current)
    while (q.isNotEmpty()) {
        val cur = q.get(0)
        q.removeAt(0)
        if (visited[cur] == 0) {
            visited[cur] = 1
            print("$cur ")
            for (i in map[cur]!!) {
                q.add(i)
            }
        }
    }
}

