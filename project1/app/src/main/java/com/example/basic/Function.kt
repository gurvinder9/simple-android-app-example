package com.example.basic

// ============================================
// 1. BASIC FUNCTIONS
// ============================================
// Standard function with return type
fun addNum(a: Int, b: Int): Int {
    return a + b
}

// Function with no return value (Unit)
fun greet(name: String) {
    println("Hello, $name!")
}

// Explicitly declaring Unit return type (optional)
fun sayGoodbye(): Unit {
    println("Goodbye!")
}

// ============================================
// 2. SINGLE-EXPRESSION FUNCTIONS
// ============================================
// When function body is a single expression, you can omit braces and return
fun multiply(a: Int, b: Int): Int = a * b

// Return type can be inferred
fun subtract(a: Int, b: Int) = a - b

fun square(x: Int) = x * x

// ============================================
// 3. DEFAULT PARAMETERS
// ============================================
// Parameters can have default values
fun printMessage(message: String = "Hello", prefix: String = "Info") {
    println("[$prefix] $message")
}

fun calculateArea(length: Double, width: Double = 1.0): Double {
    return length * width
}

// ============================================
// 4. NAMED ARGUMENTS
// ============================================
fun createUser(name: String, age: Int, city: String = "Unknown", country: String = "Unknown") {
    println("User: $name, Age: $age, City: $city, Country: $country")
}

// ============================================
// 5. VARIABLE NUMBER OF ARGUMENTS (vararg)
// ============================================
fun sumAll(vararg numbers: Int): Int {
    var sum = 0
    for (num in numbers) {
        sum += num
    }
    return sum
}

fun printItems(vararg items: String) {
    items.forEach { println(it) }
}

// ============================================
// 6. EXTENSION FUNCTIONS
// ============================================
// Add functionality to existing classes without inheritance
fun String.addExclamation(): String {
    return this + "!"
}

fun Int.isEven(): Boolean {
    return this % 2 == 0
}

fun List<Int>.sumOfSquares(): Int {
    return this.map { it * it }.sum()
}

// ============================================
// 7. INFIX FUNCTIONS
// ============================================
// Functions that can be called without dot and parentheses
infix fun Int.power(exponent: Int): Int {
    var result = 1
    repeat(exponent) {
        result *= this
    }
    return result
}

infix fun String.concat(other: String): String {
    return this + other
}

// ============================================
// 8. HIGHER-ORDER FUNCTIONS
// ============================================
// Functions that take functions as parameters or return functions

// Function that takes another function as parameter
fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

// Function that returns a function
fun getMultiplier(factor: Int): (Int) -> Int {
    return { number -> number * factor }
}

// Function with lambda as last parameter
fun performOperation(x: Int, y: Int, op: (Int, Int) -> Int): Int {
    return op(x, y)
}

// ============================================
// 9. LAMBDA EXPRESSIONS
// ============================================
val sum: (Int, Int) -> Int = { a, b -> a + b }
val greetLambda: (String) -> Unit = { name -> println("Hi, $name!") }

// Lambda with single parameter (using 'it')
val doubleValue: (Int) -> Int = { it * 2 }

// Lambda with no parameters
val sayHello: () -> Unit = { println("Hello from lambda!") }

// ============================================
// 10. ANONYMOUS FUNCTIONS
// ============================================
val divide = fun(a: Int, b: Int): Int {
    if (b == 0) {
        println("Cannot divide by zero")
        return 0
    }
    return a / b
}

// ============================================
// 11. INLINE FUNCTIONS
// ============================================
// Reduces overhead of higher-order functions
inline fun performTwice(action: () -> Unit) {
    action()
    action()
}

inline fun measureTime(block: () -> Unit) {
    val startTime = System.currentTimeMillis()
    block()
    val endTime = System.currentTimeMillis()
    println("Time taken: ${endTime - startTime}ms")
}

// ============================================
// 12. TAIL-RECURSIVE FUNCTIONS
// ============================================
// Optimized recursive functions
tailrec fun factorial(n: Int, accumulator: Int = 1): Int {
    return if (n <= 1) accumulator
    else factorial(n - 1, n * accumulator)
}

tailrec fun findGCD(a: Int, b: Int): Int {
    return if (b == 0) a
    else findGCD(b, a % b)
}

// ============================================
// 13. LOCAL FUNCTIONS
// ============================================
// Functions defined inside other functions
fun outerFunction(x: Int) {
    fun innerFunction(y: Int): Int {
        return x + y
    }
    
    println("Result from inner: ${innerFunction(5)}")
}

// ============================================
// 14. GENERIC FUNCTIONS
// ============================================
fun <T> printItem(item: T) {
    println("Item: $item")
}

fun <T> getFirst(list: List<T>): T? {
    return if (list.isNotEmpty()) list[0] else null
}

fun <T, R> transform(value: T, transformer: (T) -> R): R {
    return transformer(value)
}

// ============================================
// MAIN FUNCTION - EXAMPLES
// ============================================
fun main(args: Array<String>) {
    println("========== KOTLIN FUNCTIONS EXAMPLES ==========\n")
    
    // 1. Basic Functions
    println("--- Basic Functions ---")
    println("Sum: ${addNum(10, 20)}")
    greet("Kotlin")
    sayGoodbye()
    
    // 2. Single-Expression Functions
    println("\n--- Single-Expression Functions ---")
    println("Multiply: ${multiply(5, 4)}")
    println("Subtract: ${subtract(20, 8)}")
    println("Square: ${square(7)}")
    
    // 3. Default Parameters
    println("\n--- Default Parameters ---")
    printMessage()
    printMessage("Custom message")
    printMessage("Warning message", "WARN")
    println("Area: ${calculateArea(5.0)}")
    println("Area: ${calculateArea(5.0, 3.0)}")
    
    // 4. Named Arguments
    println("\n--- Named Arguments ---")
    createUser("Alice", 25)
    createUser(name = "Bob", age = 30, country = "USA")
    createUser(age = 28, name = "Charlie", city = "New York")
    
    // 5. Variable Arguments
    println("\n--- Variable Arguments ---")
    println("Sum of 1,2,3: ${sumAll(1, 2, 3)}")
    println("Sum of 10,20,30,40: ${sumAll(10, 20, 30, 40)}")
    printItems("Apple", "Banana", "Cherry")
    
    // 6. Extension Functions
    println("\n--- Extension Functions ---")
    println("Hello".addExclamation())
    println("Is 10 even? ${10.isEven()}")
    println("Is 7 even? ${7.isEven()}")
    println("Sum of squares [1,2,3]: ${listOf(1, 2, 3).sumOfSquares()}")
    
    // 7. Infix Functions
    println("\n--- Infix Functions ---")
    println("2 power 3 = ${2 power 3}")
    println("Hello concat World = ${"Hello" concat " World"}")
    
    // 8. Higher-Order Functions
    println("\n--- Higher-Order Functions ---")
    println("Calculate (5, 3, add): ${calculate(5, 3) { a, b -> a + b }}")
    println("Calculate (5, 3, multiply): ${calculate(5, 3) { a, b -> a * b }}")
    val triple = getMultiplier(3)
    println("Triple of 5: ${triple(5)}")
    
    // 9. Lambda Expressions
    println("\n--- Lambda Expressions ---")
    println("Sum lambda: ${sum(15, 25)}")
    greetLambda("Lambda User")
    println("Double of 8: ${doubleValue(8)}")
    sayHello()
    
    // 10. Anonymous Functions
    println("\n--- Anonymous Functions ---")
    println("Divide 20/5: ${divide(20, 5)}")
    println("Divide 20/0: ${divide(20, 0)}")
    
    // 11. Inline Functions
    println("\n--- Inline Functions ---")
    performTwice { println("Executing action") }
    measureTime {
        var sum = 0
        for (i in 1..1000) {
            sum += i
        }
        println("Sum of 1 to 1000: $sum")
    }
    
    // 12. Tail-Recursive Functions
    println("\n--- Tail-Recursive Functions ---")
    println("Factorial of 5: ${factorial(5)}")
    println("GCD of 48 and 18: ${findGCD(48, 18)}")
    
    // 13. Local Functions
    println("\n--- Local Functions ---")
    outerFunction(10)
    
    // 14. Generic Functions
    println("\n--- Generic Functions ---")
    printItem(42)
    printItem("Hello")
    printItem(3.14)
    println("First of [1,2,3]: ${getFirst(listOf(1, 2, 3))}")
    println("First of empty list: ${getFirst(emptyList<Int>())}")
    val length = transform("Hello") { it.length }
    println("Length of 'Hello': $length")
    
    // Using lambda as trailing parameter
    println("\n--- Lambda Trailing Syntax ---")
    val result = performOperation(10, 5) { x, y -> x + y }
    println("Result: $result")
    
    // Collection operations with functions
    println("\n--- Collection Operations ---")
    val numbers = listOf(1, 2, 3, 4, 5)
    println("Numbers: $numbers")
    println("Doubled: ${numbers.map { it * 2 }}")
    println("Filtered (even): ${numbers.filter { it % 2 == 0 }}")
    println("Sum: ${numbers.reduce { acc, num -> acc + num }}")
    
    println("\n========== END OF EXAMPLES ==========")
}