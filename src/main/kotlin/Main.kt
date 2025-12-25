fun main() {
    println("Enter the expression (e.g. 2+3 or 2 + 3):")
    val input = readln().replace(" ", "")
    val operators = listOf("+", "-", "*", "/")
    val operator = operators.firstOrNull() {it in input}
    if (operator == null) {
        println("Error: no operator found in expression")
        return
    }
    val parts = input.split(operator)
    if (parts.size != 2) {
        println("Error: invalid expression")
        return
    }
    val num1 = parts[0].toDouble()
    val num2 = parts[1].toDouble()
    if (operator == "/" && num2 == 0.0) {
        println("Error: cannot divide by zero!")
        return
    }
    val res = when (operator) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        "/" -> num1 / num2
        else -> {
            println("Error: unknown sign")
            return
        }
    }
    println("Result: $res")
}