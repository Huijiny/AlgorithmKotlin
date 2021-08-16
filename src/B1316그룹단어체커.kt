fun main() {
    val br = System.`in`.bufferedReader()
    var count = 0
    for (tc in 0..br.readLine().toInt()-1) {
        val alreadyShown = mutableListOf<Char>()
        var word = br.readLine()
        var beforeAlpah = word[0]
        var flag = true
        // 포문을 돌면서
        for (i in 0..word.length-1) {
            if (!alreadyShown.contains(word[i])){ // 만약에 아직 안보였던 애면 돌아
                if (beforeAlpah != word[i]) { // 달라지면 새로운 알파벳 시작이니까 이전 알파벳 추가하고 이전알파벳에 현재알파벳 추가
                    alreadyShown.add(beforeAlpah)
                    beforeAlpah = word[i]
                }
            } else { // 옛날에 나왔던 애면 연속된애가 아니니까 빼
                flag = false
                break
            }
        }
        if (flag) {
            count += 1
        }
    }
    println(count)
}