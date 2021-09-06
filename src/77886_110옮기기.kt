// 미완성 코드
class Solution77886 {
    fun solution(s: Array<String>): Array<String> {
        var answer = Array<String>(s.size){""}
        s.forEachIndexed { index, str ->
            var afterStr = str
            var countOf110 = 0
            while ("110" in afterStr) {
                countOf110 += 1
                afterStr = afterStr.replace("110", "")
            }
            var baseString = ""
            for (i in 0..afterStr.length-1) {
                if(afterStr[i] == '1') {
                    if (afterStr.length == 1) {
                        baseString =  "110" + afterStr[i]
                        break
                    }
                    var j = i+1 // i다음부터 시작해서 0이 끝나는 점까지 돌아
                    while (j < afterStr.length && afterStr[j] == '0') {
                        j += 1
                    }
                    //110 개수만큼 맨끝에 있는 0 뒤에 더해
                    baseString = afterStr.substring(0, j) // j뒤에다가 붙일거
                    var lastString = afterStr.substring(j)
                    repeat(countOf110) {
                        baseString += "110"
                    }
                    baseString += lastString
                    break
                }
            }
            answer[index] = baseString
        }
        return answer
    }
}
fun main() {
    Solution77886().solution(arrayOf("1110","100111100","0111111010"))
}