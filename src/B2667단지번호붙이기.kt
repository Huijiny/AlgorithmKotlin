val delta = arrayOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))

fun main() {
    val br = System.`in`.bufferedReader()
    val count = br.readLine().toInt()
    val danji = Array(count) {
        val input = br.readLine()
        IntArray(count){ input[it].digitToInt() }
    }
    var areaCount = 0

    val countOfApt = mutableListOf<Int>()
    for (i in 0..count-1) {
        for (j in 0..count-1) {
            if (danji[i][j] == 1) {
                val apts = bfs(danji, i, j, count)
                countOfApt.add(apts)
                areaCount += 1
            }
        }
    }
    println(areaCount)
    countOfApt.sort()
    countOfApt.forEach { println(it) }
}

fun bfs(danji: Array<IntArray>, col: Int, row: Int, count: Int): Int {
    var q = mutableListOf<Pair<Int, Int>>()
    q.add(Pair(col, row))
    danji[col][row] = 0 // 단지를 0으로 만들고,
    var cnt = 1

    while(q.isNotEmpty()) {
        val (curCol, curRow) = q.get(0)
        q.removeAt(0)

        // 4방향 돌면서 방문 안하고, 범위 내에 있는 좌표를 찾는다.
        for ((dc, dr) in delta) {
            val newCol = curCol + dc
            val newRow = curRow + dr
            if (((newCol < count && 0 <= newCol) && (newRow < count && 0 <= newRow)) && danji[newCol][newRow] == 1) {// 아직 방문 안하고, 범위 내에 있으면
                cnt += 1
                q.add(Pair(newCol, newRow)) // q에 추가한다.
                danji[newCol][newRow] = 0 // 단지를 0으로 만들고,

            }
        }
    }
    return cnt
}