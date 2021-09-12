package codingTest.kakao2022

class kakao2021_4 {
    var ryanInfos = listOf<IntArray>()
    lateinit var publicInfo: IntArray
    var diffMax: Int = 0
    fun solution(n: Int, info: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        publicInfo = info
        diffMax = 0
        val ryanInfo = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        recursive(ryanInfo, n, 0)

        if (ryanInfos.size == 0) {
            answer = intArrayOf(-1)
        } else {
            answer = ryanInfos.last()
        }
        println()
        answer.forEach { print("$it ") }
        return answer
    }

    fun recursive(ryan: IntArray, k: Int, index: Int) {
        if (k == 0) {
            var apeachTotal = 0
            var ryanTotal = 0
            for (i in 0..10) {
                if (ryan[i] == 0 && publicInfo[i] == 0) continue
                if (ryan[i] <= publicInfo[i]) {
                    apeachTotal += (10-i) // 어피치 점수 토탈
                }
                else {
                    ryanTotal += (10-i)
                }
            }
            val totalDiff = ryanTotal - apeachTotal // 라이언 토탈점수에서 어피치 토탈점수 빼보기
            // 라이언 점수 더 큼.
            if (totalDiff > 0) { // 0 이상인 상태여야해 무조건
                // totalDiff(현재 라이언 점수와 어피치 점수의 차이)가 diffMax(현재까지의 어피치와 가장 큰 차이) 보다 크면 얘가 제일 큰 차이로 어피치 이길 수 있는거니까 이중배열을 싹 갈아치워
                if (totalDiff > diffMax) {
                    diffMax = totalDiff
                    val copyRyan: IntArray = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
                    for (i in 0..10) {
                        copyRyan[i] = ryan[i]
                    }

                    ryanInfos = listOf(copyRyan)
                    return

                }
                // diffMax와 totalDiff랑 같으면 제일 큰 차이로 이길 수 있는 방법이 여러개이므로 plus 해서 뒤에 붙여
                if (diffMax == totalDiff) {
                    val copyRyan: IntArray = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
                    for (i in 0..10) {
                        copyRyan[i] = ryan[i]
                    }
                    ryanInfos.plus(copyRyan)
                    return
                }
            }
            return
        }
        if (index >= 11) {
            // 11이상으로 인덱스가 넘어왔을 경우
            return
        }
        // 만약에 apeach+1 를 k에서 빼도 쏠수 있는 화살 수가 남았으면
        if (k - (publicInfo[index]+1) >= 0) {
            ryan[index] = publicInfo[index]+1
            // 남은 k를 들고 다음 Index로 가기
            recursive(ryan,k-(publicInfo[index]+1), index+1)
            // 남은 k가 다른데서도 골고루 쓰일 수 있음
//            recursive(ryan, k, index)
        }
        // 화살수가 안남으면 그냥 이대로 다음 Index로 가보

        ryan[index] = 0
        recursive(ryan, k, index+1)
    }

}

fun main() {
    kakao2021_4().solution(10, intArrayOf(0,0,0,0,0,0,0,0,3,4,3))
}