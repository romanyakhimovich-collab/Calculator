fun main() {
    val num1 = readln().toDouble()
    val sign = readln()
    val num2 = readln().toDouble()
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
    println(res)
}