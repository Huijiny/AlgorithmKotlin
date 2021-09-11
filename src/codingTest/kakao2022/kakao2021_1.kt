package codingTest.kakao2022

class kakao2021_1 {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer: IntArray = intArrayOf()
        // 아이디별로 신고한 애들 map 만들기
        val reportedUserListPerId = mutableMapOf<String, List<String>>()
        val reportedUserIdCount = mutableMapOf<String, Int>()
        val mailedCount = mutableMapOf<String, Int>()
        id_list.forEach { id ->
            reportedUserListPerId.put(id, emptyList())
            reportedUserIdCount.put(id, 0)
            mailedCount.put(id, 0)
        }
        println(reportedUserListPerId)
        report.forEach { repo ->
            val (userId, reportedUserId) = repo.split(" ")
            if (!reportedUserListPerId.get(userId)!!.contains(reportedUserId)) {
                reportedUserListPerId.put(userId, reportedUserListPerId.get(userId)!!.plus(reportedUserId))
            }
        }
        println(reportedUserListPerId)

        // 아이디별로 신고당한 횟수 배열
        reportedUserListPerId.values.forEach { ids ->
            ids.forEach { id ->
                reportedUserIdCount.put(id, (reportedUserIdCount.get(id)!! + 1))
            }
        }
        println(reportedUserIdCount)

        reportedUserListPerId.forEach { key, value ->
            value.forEach { v ->
                if(reportedUserIdCount.get(v)!! >= k) {
                    mailedCount.put(key, mailedCount.get(key)!! + 1)
                }
            }
        }
        println(mailedCount)
        answer = mailedCount.values.toIntArray()
        answer.forEach { print(it) }
        return answer
    }
}
fun main() {
    kakao2021_1().solution(arrayOf("con", "ryan"), arrayOf("ryan con", "ryan con", "ryan con", "ryan con"), 3)
}