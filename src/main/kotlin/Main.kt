fun main() {
    println("Enter the expression (e.g. 2+3):")
    val input = readln()
    val parts = input.split(" ")
    if (parts.size != 3) {
        println("Error: invalid expression")
        return
    }
    val num1 = parts[0].toDouble()
    val sign = parts[1]
    val num2 = parts[2].toDouble()
    if (sign == "/" && num2 == 0.0) {
        println("Error: cannot divide by zero!")
        return
    }
    val res = when (sign) {
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