class Solution4 {
    companion object {
        const val Enter = "님이 들어왔습니다."
        const val Leave = "님이 나갔습니다."
    }
    fun solution(record: Array<String>): Array<String> {
        var answer = mutableListOf<String>()
        var map = HashMap<String, String>()
        record.forEach {
            when (it.split(" ".toRegex())[0]) {
                "Enter", "Change" -> {
                    val uid = it.split(" ".toRegex())[1]
                    val name = it.split(" ".toRegex())[2]
                    map.put(uid, name)
                }
            }
        }
        record.forEach {
            when (it.split(" ".toRegex())[0]) {
                "Enter" -> {
                    answer.add(map[it.split(" ".toRegex())[1]]+Enter)
                }
                "Leave" -> {
                    answer.add(map[it.split(" ".toRegex())[1]]+Leave)
                }
            }
        }

        return answer.toTypedArray()
    }
}

fun main() {
    val lst = arrayOf(
        "Enter uid1234 Muzi",
        "Enter uid4567 Prodo",
        "Leave uid1234",
        "Enter uid1234 Prodo",
        "Change uid4567 Ryan"
    )
    println(Solution4().solution(lst))
}
/*fun solution(record: Array<String>): Array<String> {
        var answer = mutableListOf<String>()
        var UidName: MutableMap<String, String> = mutableMapOf()
        var changes = record.filter {
            it.startsWith("Change")
        }

        changes = changes.reversed()
        var changedUID: MutableMap<String, Boolean> = mutableMapOf()

        record.filter { it.startsWith("Enter") }
            .forEach {
                val orders = it.split(" ")
                UidName.put(orders[1], orders[2])
            }
        changes.forEach { change ->
            val (change, uid, name) = change.split(" ")
            if (changedUID[uid] == null) {
                changedUID.put(uid, true)
                UidName[uid] = name
            }
        }
        record.filter {
            !it.startsWith("Change")
        }.forEach {
            val orders = it.split(" ")
            val uid = orders[1]
            if (orders.size == 2) { //Leave
                answer.add(UidName[uid] + Leave)
            } else {
                answer.add(UidName[uid] + Enter)
            }
        }
        return answer.toTypedArray()
    }*/