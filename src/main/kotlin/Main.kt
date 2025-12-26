fun precedence(op: Char): Int {
    return when (op) {
        '+', '-' -> 1
        '*', '/' -> 2
        else -> 0
    }
}
fun applyOperator(a: Double, b: Double, op: Char): Double {
    return when (op) {
        '+' -> a + b
        '-' -> a - b
        '*' -> a * b
        '/' -> {
            if (b == 0.0) throw IllegalArgumentException("Division by zero")
            a / b
        }
        else -> throw IllegalArgumentException("Unknown operator")
    }
}
fun main() {
    println("Enter the expression (e.g. 2+3 or 2 + 3):")
    val input = readln().replace(" ", "")
    val values = mutableListOf<Double>()
    val ops = mutableListOf<Char>()
    var i = 0
    while (i < input.length) {
        val ch = input[i]
        if (ch.isDigit() || ch == '.') {
            val sb = StringBuilder()
            while (i < input.length && (input[i].isDigit() || input[i] == '.')) {
                sb.append(input[i])
                i++
            }
            values.add(sb.toString().toDouble())
            continue
        }
        if (ch == '(') {
            ops.add(ch)
        }
        else if (ch == ')') {
            while (ops.isNotEmpty() && ops.last() != '(') {
                val b = values.removeLast()
                val a = values.removeLast()
                val op = ops.removeLast()
                values.add(applyOperator(a, b, op))
            }
            ops.removeLast()
        }
        else if (ch in listOf<Char>('+', '-', '*', '/')) {
            while (ops.isNotEmpty() && ops.last() != '(' && precedence(ops.last()) >= precedence(ch)) {
                val b = values.removeLast()
                val a = values.removeLast()
                val op = ops.removeLast()
                values.add(applyOperator(a, b, op))
            }
            ops.add(ch)
        }
        i++
    }
    while (ops.isNotEmpty()) {
        val b = values.removeLast()
        val a = values.removeLast()
        val op = ops.removeLast()
        values.add(applyOperator(a, b, op))
    }
    println("Result: ${values.first()}")
}