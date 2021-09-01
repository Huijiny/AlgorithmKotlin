fun main() {
    val br = System.`in`.bufferedReader();
    var sentence = br.readLine()
    while (!sentence.equals(".")) {
        var flag = true
        var stack = mutableListOf<Char>()
        for (i in 0..sentence.length-1) {
            when (sentence[i]) {
                '(' -> stack.add('(')
                ')' -> {
                    if (stack.size> 0) {
                        if (stack[stack.size-1].equals('(')) {
                            stack.removeAt(stack.size-1)
                        } else {
                            flag = false
                            break
                        }
                    } else {
                        flag = false
                        break
                    }
                }
                '[' -> stack.add('[')
                ']' -> {
                    if (stack.size > 0) {
                        if (stack[stack.size-1].equals('[')) {
                            stack.removeAt(stack.size-1)
                        } else {
                            flag = false
                            break
                        }
                    } else {
                        flag = false
                        break
                    }
                }
            }
        }
        if (!flag) {
            println("no")
        } else {
            println("yes")
        }
       sentence = br.readLine()
    }
}