fun main() {
    val num1 = readln().toDouble()
    val sign = readln()
    val num2 = readln().toDouble()
    if (sign == "/") {
        if (num2 == 0.0) {
            println("Error: cannot divide by zero!")
        }
    }
    val res = when (sign) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        "/" -> num1 / num2
        else -> "Error: unknown sign"
    }
    println(res)
}