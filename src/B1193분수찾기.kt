import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val number = br.readLine().toInt()
    var i = 1
    var sum = 0
    var row = 0
    var col = 0
    while (number > sum + i) {
        sum += i
        i++
    }
    if (i % 2 == 1) {
        row = (number - sum)
        col = (i + 1) - row
    } else {
        col = (number - sum)
        row = (i + 1) - col
    }
    print(col.toString()+'/'+row.toString())
    br.close()
}
