import java.util.*
import kotlin.collections.ArrayList

class `81302거리두기확인하기` {

    var direction = arrayOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))
    fun solution(places: Array<Array<String>>): IntArray {
        val answer = ArrayList<Int>()

        places.forEach { place ->
            // P의 위치를 찾는 포문
            var check = 1

            for (i in 0..4) {
                for (j in 0..4) {
                    if (place[i][j].equals('P')) {
                        if (!find(place, i, j)) {
                            check = 0
                            break
                        }
                    }
                }
                if (check == 0) {
                    break
                }
            }
            answer.add(check)
        }
        answer.forEach{ println(it)}
        return answer.toIntArray()
    }

    fun find(place: Array<String>, nowy: Int, nowx: Int): Boolean {
        var check = true

        for (i in 0..3) {
            val newx = nowx + direction[i].second
            val newy = nowy + direction[i].first

            if (0 <= newx && newx < 5 && 0 <= newy && newy < 5) {
                if (place[newy][newx].equals('X')) continue
                if (place[newy][newx].equals('P')) {
                    check = false
                    break
                } else {
                    for (j in 0..3) {
                        val newx2 = newx + direction[j].second
                        val newy2 = newy + direction[j].first
                        if (newx2 == nowx && newy2 == nowy) {
                            continue
                        }
                        if (0 <= newx2 && newx2 < 5 && 0 <= newy2 && newy2 < 5) {
                            if (place[newy2][newx2].equals('X')) continue
                            if (place[newy2][newx2].equals('P')) {
                                check = false
                                break
                            }
                        }
                    }

                }
            }
            if (!check) {
                break
            }
        }
        return check
    }
}
fun main() {
    print(
    `81302거리두기확인하기`().solution(arrayOf(
        arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
        arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
        arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
        arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
        arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"))))
}