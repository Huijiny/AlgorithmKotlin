fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val multiArray: Array<Array<Int>> = Array<Array<Int>>(n) {
        var list = br.readLine().split("")
        list = list.subList(1, list.size-1)
        Array<Int>(n) {
            list.get(it).toInt()
        }
    }
    recursive(0, 0, multiArray, n)
}

fun recursive(col: Int, row: Int, multiArray: Array<Array<Int>>, n: Int) {
    var flag = true
    val first = multiArray[col][row]
    if (n == 1) {
        print(first)
        return
    }
    for (i in col..col+n-1) {
        for (j in row..row+n-1) {
            if (multiArray[i][j] != first) {
                flag = false
            }
        }
    }
    if (flag) {
        print(first)
    } else {
        print("(")
        recursive(col, row, multiArray, n/2)
        recursive(col, row+n/2, multiArray, n/2)
        recursive(col+n/2, row, multiArray, n/2)
        recursive(col+n/2, row+n/2, multiArray, n/2)
        print(")")
    }
}