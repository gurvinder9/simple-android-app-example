package com.example.basic

/**
 * Kotlin Control Flow Tutorial
 *
 * This file demonstrates control flow statements in Kotlin, including
 * if/else, when, try/catch, and other control flow mechanisms commonly
 * used in Android development.
 */

fun main() {
    println("=== Kotlin Control Flow Tutorial ===\n")
    
    // 1. IF EXPRESSIONS
    demonstrateIfExpressions()
    
    // 2. WHEN EXPRESSIONS
    demonstrateWhenExpressions()
    
    // 3. TRY-CATCH-FINALLY
    demonstrateTryCatchFinally()
    
    // 4. RETURN AND JUMPS
    demonstrateReturnAndJumps()
    
    // 5. LABELED EXPRESSIONS
    demonstrateLabeledExpressions()
    
    // 6. CONDITIONAL EXPRESSIONS
    demonstrateConditionalExpressions()
    
    // 7. ELVIS OPERATOR
    demonstrateElvisOperator()
    
    // 8. SAFE CALLS AND LET
    demonstrateSafeCallsAndLet()
    
    // 9. CONTROL FLOW PATTERNS
    demonstrateControlFlowPatterns()
    
    // 10. ADVANCED CONTROL FLOW
    demonstrateAdvancedControlFlow()
}

private fun demonstrateIfExpressions() {
    println("1. IF EXPRESSIONS:")
    
    // Basic if
    val age = 18
    println("   Basic if:")
    if (age >= 18) {
        println("   You are an adult")
    }
    
    // If-else
    println("   If-else:")
    if (age >= 18) {
        println("   You can vote")
    } else {
        println("   You cannot vote")
    }
    
    // If-else if-else
    val score = 85
    println("   If-else if-else (score = $score):")
    if (score >= 90) {
        println("   Grade: A")
    } else if (score >= 80) {
        println("   Grade: B")
    } else if (score >= 70) {
        println("   Grade: C")
    } else if (score >= 60) {
        println("   Grade: D")
    } else {
        println("   Grade: F")
    }
    
    // If as expression
    println("   If as expression:")
    val max = if (5 > 3) 5 else 3
    println("   max = $max")
    
    val result = if (age >= 18) {
        "Adult"
    } else {
        "Minor"
    }
    println("   Person is: $result")
    
    // Multi-line if expression
    val status = if (score >= 60) {
        val message = "Passed"
        println("   Congratulations!")
        message
    } else {
        val message = "Failed"
        println("   Try again")
        message
    }
    println("   Status: $status")
    
    // Nested if
    val num = 10
    println("   Nested if (num = $num):")
    if (num > 0) {
        if (num % 2 == 0) {
            println("   Positive even number")
        } else {
            println("   Positive odd number")
        }
    } else if (num < 0) {
        println("   Negative number")
    } else {
        println("   Zero")
    }
    
    println()
}

private fun demonstrateWhenExpressions() {
    println("2. WHEN EXPRESSIONS:")
    
    // Basic when
    val day = 3
    println("   Basic when (day = $day):")
    when (day) {
        1 -> println("   Monday")
        2 -> println("   Tuesday")
        3 -> println("   Wednesday")
        4 -> println("   Thursday")
        5 -> println("   Friday")
        6 -> println("   Saturday")
        7 -> println("   Sunday")
        else -> println("   Invalid day")
    }
    
    // When as expression
    println("   When as expression:")
    val dayName = when (day) {
        1 -> "Monday"
        2 -> "Tuesday"
        3 -> "Wednesday"
        4 -> "Thursday"
        5 -> "Friday"
        6 -> "Saturday"
        7 -> "Sunday"
        else -> "Invalid"
    }
    println("   Day name: $dayName")
    
    // When with multiple values
    val number = 3
    println("   When with multiple values (number = $number):")
    when (number) {
        1, 2, 3 -> println("   Small number")
        4, 5, 6 -> println("   Medium number")
        7, 8, 9 -> println("   Large number")
        else -> println("   Other number")
    }
    
    // When with ranges
    val score = 85
    println("   When with ranges (score = $score):")
    when (score) {
        in 90..100 -> println("   Grade: A")
        in 80..89 -> println("   Grade: B")
        in 70..79 -> println("   Grade: C")
        in 60..69 -> println("   Grade: D")
        else -> println("   Grade: F")
    }
    
    // When with conditions
    val x = 15
    println("   When with conditions (x = $x):")
    when {
        x < 0 -> println("   Negative")
        x == 0 -> println("   Zero")
        x % 2 == 0 -> println("   Positive even")
        else -> println("   Positive odd")
    }
    
    // When with type checking
    fun describe(obj: Any): String {
        return when (obj) {
            is String -> "String of length ${obj.length}"
            is Int -> "Integer: $obj"
            is Boolean -> "Boolean: $obj"
            is List<*> -> "List of size ${obj.size}"
            else -> "Unknown type"
        }
    }
    
    println("   When with type checking:")
    println("   describe(\"Hello\"): ${describe("Hello")}")
    println("   describe(42): ${describe(42)}")
    println("   describe(true): ${describe(true)}")
    println("   describe(listOf(1,2,3)): ${describe(listOf(1, 2, 3))}")
    
    // When without argument
    val age = 25
    val hasLicense = true
    println("   When without argument:")
    val canDrive = when {
        age < 16 -> "Too young to drive"
        age >= 16 && hasLicense -> "Can drive"
        age >= 16 && !hasLicense -> "Need a license"
        else -> "Unknown status"
    }
    println("   $canDrive")
    
    println()
}

private fun demonstrateTryCatchFinally() {
    println("3. TRY-CATCH-FINALLY:")
    
    // Basic try-catch
    println("   Basic try-catch:")
    try {
        val result = 10 / 0
        println("   Result: $result")
    } catch (e: ArithmeticException) {
        println("   Caught: ${e.message}")
    }
    
    // Try-catch with multiple catch blocks
    println("   Multiple catch blocks:")
    fun parseInt(str: String) {
        try {
            val num = str.toInt()
            val result = 100 / num
            println("   Result: $result")
        } catch (e: NumberFormatException) {
            println("   Invalid number format: ${e.message}")
        } catch (e: ArithmeticException) {
            println("   Division by zero: ${e.message}")
        }
    }
    
    parseInt("abc")
    parseInt("0")
    parseInt("5")
    
    // Try-catch-finally
    println("   Try-catch-finally:")
    fun processFile(filename: String) {
        try {
            println("   Opening file: $filename")
            throw Exception("File not found")
        } catch (e: Exception) {
            println("   Error: ${e.message}")
        } finally {
            println("   Closing file: $filename")
        }
    }
    
    processFile("data.txt")
    
    // Try as expression
    println("   Try as expression:")
    val numberStr = "123"
    val number = try {
        numberStr.toInt()
    } catch (e: NumberFormatException) {
        0
    }
    println("   Parsed number: $number")
    
    val invalidStr = "abc"
    val defaultNumber = try {
        invalidStr.toInt()
    } catch (e: NumberFormatException) {
        -1
    }
    println("   Default number: $defaultNumber")
    
    // Nested try-catch
    println("   Nested try-catch:")
    try {
        println("   Outer try")
        try {
            val result = "invalid".toInt()
            println("   Inner result: $result")
        } catch (e: NumberFormatException) {
            println("   Inner catch: ${e.message}")
            throw Exception("Rethrowing")
        }
    } catch (e: Exception) {
        println("   Outer catch: ${e.message}")
    }
    
    println()
}

private fun demonstrateReturnAndJumps() {
    println("4. RETURN AND JUMPS:")
    
    // Return from function
    fun checkAge(age: Int): String {
        if (age < 0) {
            return "Invalid age"
        }
        if (age < 18) {
            return "Minor"
        }
        return "Adult"
    }
    
    println("   Return from function:")
    println("   checkAge(15): ${checkAge(15)}")
    println("   checkAge(25): ${checkAge(25)}")
    
    // Early return
    fun processNumber(num: Int): String {
        if (num < 0) return "Negative"
        if (num == 0) return "Zero"
        if (num % 2 == 0) return "Even"
        return "Odd"
    }
    
    println("   Early return:")
    println("   processNumber(-5): ${processNumber(-5)}")
    println("   processNumber(0): ${processNumber(0)}")
    println("   processNumber(4): ${processNumber(4)}")
    println("   processNumber(7): ${processNumber(7)}")
    
    // Return in lambda (returns from enclosing function)
    fun findFirst(): Int {
        val numbers = listOf(1, 2, 3, 4, 5)
        numbers.forEach {
            if (it > 3) {
                // This would return from findFirst if uncommented
                // return it
            }
        }
        return -1
    }
    
    // Return with label
    fun findFirstWithLabel(): Int {
        val numbers = listOf(1, 2, 3, 4, 5)
        numbers.forEach lit@{
            if (it > 3) {
                return@lit  // Returns from lambda, not function
            }
            println("   Checking: $it")
        }
        return -1
    }
    
    println("   Return with label:")
    val result = findFirstWithLabel()
    println("   Result: $result")
    
    println()
}

private fun demonstrateLabeledExpressions() {
    println("5. LABELED EXPRESSIONS:")
    
    // Labeled break
    println("   Labeled break:")
    outer@ for (i in 1..3) {
        for (j in 1..3) {
            if (i == 2 && j == 2) {
                println("   Breaking at i=$i, j=$j")
                break@outer
            }
            println("   i=$i, j=$j")
        }
    }
    
    // Labeled continue
    println("   Labeled continue:")
    outer@ for (i in 1..3) {
        for (j in 1..3) {
            if (j == 2) {
                continue@outer
            }
            println("   i=$i, j=$j")
        }
    }
    
    // Labeled return from lambda
    println("   Labeled return from lambda:")
    val numbers = listOf(1, 2, 3, 4, 5)
    numbers.forEach lit@{
        if (it == 3) return@lit
        println("   Number: $it")
    }
    println("   Finished processing")
    
    // Implicit label
    println("   Implicit label (function name):")
    numbers.forEach {
        if (it == 3) return@forEach
        println("   Value: $it")
    }
    
    // Return to outer function
    fun processNumbers() {
        val numbers = listOf(1, 2, 3, 4, 5)
        numbers.forEach {
            if (it == 3) {
                println("   Found 3, stopping")
                return  // Returns from processNumbers
            }
            println("   Processing: $it")
        }
        println("   This won't print if we found 3")
    }
    
    println("   Return to outer function:")
    processNumbers()
    
    println()
}

private fun demonstrateConditionalExpressions() {
    println("6. CONDITIONAL EXPRESSIONS:")
    
    // Ternary-like expression
    val age = 20
    val status = if (age >= 18) "Adult" else "Minor"
    println("   Ternary-like: $status")
    
    // Chained conditionals
    val score = 75
    val grade = if (score >= 90) "A"
    else if (score >= 80) "B"
    else if (score >= 70) "C"
    else "F"
    println("   Chained: Grade $grade")
    
    // When as ternary
    val number = 5
    val parity = when {
        number % 2 == 0 -> "Even"
        else -> "Odd"
    }
    println("   When as ternary: $parity")
    
    // Conditional with multiple statements
    val isValid = true
    val message = if (isValid) {
        val prefix = "Success"
        val suffix = "Operation completed"
        "$prefix: $suffix"
    } else {
        val prefix = "Error"
        val suffix = "Operation failed"
        "$prefix: $suffix"
    }
    println("   Multi-statement: $message")
    
    // Conditional function calls
    fun processSuccess() = println("   Processing success")
    fun processFailure() = println("   Processing failure")
    
    val success = true
    if (success) processSuccess() else processFailure()
    
    println()
}

private fun demonstrateElvisOperator() {
    println("7. ELVIS OPERATOR:")
    
    // Basic elvis
    val str: String? = null
    val result = str ?: "Default"
    println("   Basic elvis: $result")
    
    // Elvis with expression
    val name: String? = null
    val greeting = "Hello, ${name ?: "Guest"}"
    println("   Elvis in expression: $greeting")
    
    // Elvis chain
    val value1: String? = null
    val value2: String? = null
    val value3 = "Final"
    val chosen = value1 ?: value2 ?: value3
    println("   Elvis chain: $chosen")
    
    // Elvis with return
    fun processUser(username: String?): String {
        val user = username ?: return "No user"
        return "Welcome, $user"
    }
    
    println("   Elvis with return:")
    println("   ${processUser("John")}")
    println("   ${processUser(null)}")
    
    // Elvis with throw
    fun validateAge(age: Int?) {
        val validAge = age ?: throw IllegalArgumentException("Age cannot be null")
        println("   Valid age: $validAge")
    }
    
    println("   Elvis with throw:")
    try {
        validateAge(25)
        validateAge(null)
    } catch (e: IllegalArgumentException) {
        println("   Caught: ${e.message}")
    }
    
    println()
}

private fun demonstrateSafeCallsAndLet() {
    println("8. SAFE CALLS AND LET:")
    
    // Safe call operator
    val str: String? = "Hello"
    val length = str?.length
    println("   Safe call: length = $length")
    
    val nullStr: String? = null
    val nullLength = nullStr?.length
    println("   Safe call on null: length = $nullLength")
    
    // Chained safe calls
    data class Address(val street: String?, val city: String?)
    data class Person(val name: String, val address: Address?)
    
    val person1 = Person("John", Address("Main St", "NYC"))
    val person2 = Person("Jane", null)
    
    println("   Chained safe calls:")
    println("   person1 city: ${person1.address?.city}")
    println("   person2 city: ${person2.address?.city}")
    
    // Let function
    println("   Let function:")
    str?.let {
        println("   String is not null: $it")
        println("   Length: ${it.length}")
    }
    
    nullStr?.let {
        println("   This won't print")
    } ?: println("   String is null")
    
    // Let with elvis
    val result = person2.address?.city?.let {
        "City: $it"
    } ?: "No city"
    println("   Let with elvis: $result")
    
    // Also function
    println("   Also function:")
    val numbers = mutableListOf(1, 2, 3)
    numbers.also {
        println("   Adding 4 to list")
        it.add(4)
    }.also {
        println("   Adding 5 to list")
        it.add(5)
    }
    println("   Final list: $numbers")
    
    // Apply function
    println("   Apply function:")
    data class User(var name: String = "", var age: Int = 0)
    
    val user = User().apply {
        name = "John"
        age = 25
    }
    println("   User: $user")
    
    // Run function
    println("   Run function:")
    val greeting = str?.run {
        val upper = uppercase()
        val exclamation = "$upper!"
        exclamation
    } ?: "No greeting"
    println("   Greeting: $greeting")
    
    println()
}

// Enums and sealed classes for Pattern demonstrations
private enum class MachineState { IDLE, RUNNING, PAUSED, STOPPED }

private sealed class OperationResult<out T> {
    data class Success<T>(val value: T) : OperationResult<T>()
    data class Error(val message: String) : OperationResult<Nothing>()
}

private fun demonstrateControlFlowPatterns() {
    println("9. CONTROL FLOW PATTERNS:")
    
    // Pattern 1: Guard clauses
    fun processOrder(quantity: Int?, price: Double?): String {
        if (quantity == null) return "Invalid quantity"
        if (price == null) return "Invalid price"
        if (quantity <= 0) return "Quantity must be positive"
        if (price <= 0) return "Price must be positive"
        
        val total = quantity * price
        return "Total: $$total"
    }
    
    println("   Pattern 1 - Guard clauses:")
    println("   ${processOrder(5, 10.0)}")
    println("   ${processOrder(null, 10.0)}")
    println("   ${processOrder(-5, 10.0)}")
    
    // Pattern 2: State machine
    fun handleState(state: MachineState): String {
        return when (state) {
            MachineState.IDLE -> "Ready to start"
            MachineState.RUNNING -> "Processing..."
            MachineState.PAUSED -> "Paused, can resume"
            MachineState.STOPPED -> "Finished"
        }
    }
    
    println("   Pattern 2 - State machine:")
    listOf(MachineState.IDLE, MachineState.RUNNING, MachineState.PAUSED, MachineState.STOPPED).forEach {
        println("   ${it}: ${handleState(it)}")
    }
    
    // Pattern 3: Result type
    fun divide(a: Int, b: Int): OperationResult<Int> {
        return if (b == 0) {
            OperationResult.Error("Division by zero")
        } else {
            OperationResult.Success(a / b)
        }
    }
    
    println("   Pattern 3 - Result type:")
    val result1 = divide(10, 2)
    val result2 = divide(10, 0)
    
    when (result1) {
        is OperationResult.Success -> println("   Success: ${result1.value}")
        is OperationResult.Error -> println("   Error: ${result1.message}")
    }
    
    when (result2) {
        is OperationResult.Success -> println("   Success: ${result2.value}")
        is OperationResult.Error -> println("   Error: ${result2.message}")
    }
    
    // Pattern 4: Validation chain
    data class ValidationResult(val isValid: Boolean, val message: String)
    
    fun validateEmail(email: String): ValidationResult {
        return when {
            email.isEmpty() -> ValidationResult(false, "Email is empty")
            !email.contains("@") -> ValidationResult(false, "Missing @")
            !email.contains(".") -> ValidationResult(false, "Missing domain")
            else -> ValidationResult(true, "Valid email")
        }
    }
    
    println("   Pattern 4 - Validation:")
    listOf("", "invalid", "test@", "test@example.com").forEach {
        val result = validateEmail(it)
        println("   \"$it\": ${result.message}")
    }
    
    println()
}

// Sealed class for expression evaluation
private sealed class MathExpression {
    data class Number(val value: Int) : MathExpression()
    data class Add(val left: MathExpression, val right: MathExpression) : MathExpression()
    data class Multiply(val left: MathExpression, val right: MathExpression) : MathExpression()
}

private fun evalExpression(expr: MathExpression): Int = when (expr) {
    is MathExpression.Number -> expr.value
    is MathExpression.Add -> evalExpression(expr.left) + evalExpression(expr.right)
    is MathExpression.Multiply -> evalExpression(expr.left) * evalExpression(expr.right)
}

private fun demonstrateAdvancedControlFlow() {
    println("10. ADVANCED CONTROL FLOW:")
    
    // Pattern matching with sealed classes
    println("   Pattern matching with sealed classes:")
    val expr = MathExpression.Add(
        MathExpression.Number(2),
        MathExpression.Multiply(MathExpression.Number(3), MathExpression.Number(4))
    )
    println("   2 + (3 * 4) = ${evalExpression(expr)}")
    
    // Recursive control flow
    fun factorial(n: Int): Int {
        return if (n <= 1) 1 else n * factorial(n - 1)
    }
    
    println("   Recursive control flow:")
    println("   factorial(5) = ${factorial(5)}")
    
    // Tail recursion
    tailrec fun factorialTail(n: Int, acc: Int = 1): Int {
        return if (n <= 1) acc else factorialTail(n - 1, n * acc)
    }
    
    println("   Tail recursion:")
    println("   factorialTail(5) = ${factorialTail(5)}")
    
    // Control flow with sequences
    println("   Control flow with sequences:")
    val numbers = generateSequence(1) { it + 1 }
        .takeWhile { it <= 10 }
        .filter { it % 2 == 0 }
        .map { it * it }
        .toList()
    println("   Even squares: $numbers")
    
    // Nested when
    fun classifyNumber(num: Int): String {
        return when {
            num < 0 -> when {
                num % 2 == 0 -> "Negative even"
                else -> "Negative odd"
            }
            num == 0 -> "Zero"
            else -> when {
                num % 2 == 0 -> "Positive even"
                else -> "Positive odd"
            }
        }
    }
    
    println("   Nested when:")
    listOf(-4, -3, 0, 3, 4).forEach {
        println("   $it: ${classifyNumber(it)}")
    }
    
    println()
}

/**
 * CONTROL FLOW SUMMARY:
 *
 * IF EXPRESSIONS:
 * - if (condition) { }
 * - if-else: if (condition) { } else { }
 * - if-else if: Multiple conditions
 * - If as expression: val x = if (condition) a else b
 * - Returns last expression in block
 *
 * WHEN EXPRESSIONS:
 * - Replaces switch statement
 * - when (value) { ... }
 * - Multiple values: 1, 2, 3 ->
 * - Ranges: in 1..10 ->
 * - Type checking: is Type ->
 * - Conditions: when { condition -> }
 * - Without argument for complex conditions
 * - Must be exhaustive or have else
 *
 * TRY-CATCH-FINALLY:
 * - try { } catch (e: Exception) { }
 * - Multiple catch blocks
 * - finally block always executes
 * - Try as expression
 * - Can be nested
 *
 * RETURN AND JUMPS:
 * - return: Exit function
 * - break: Exit loop
 * - continue: Skip iteration
 * - return@label: Return from lambda
 * - Early returns for validation
 *
 * LABELS:
 * - label@ for marking expressions
 * - break@label: Break to label
 * - continue@label: Continue to label
 * - return@label: Return from labeled block
 * - Implicit labels for lambdas
 *
 * NULL SAFETY:
 * - ?. : Safe call operator
 * - ?: : Elvis operator
 * - !! : Not-null assertion
 * - let, also, apply, run: Scope functions
 *
 * SCOPE FUNCTIONS:
 * - let: Execute on non-null, returns result
 * - also: Additional operations, returns object
 * - apply: Configure object, returns object
 * - run: Execute block, returns result
 * - with: Execute with object
 *
 * PATTERNS:
 * - Guard clauses: Early returns
 * - State machines: Enum with when
 * - Result types: Sealed classes
 * - Validation chains: Sequential checks
 * - Pattern matching: Sealed classes
 *
 * ADVANCED:
 * - Sealed classes for exhaustive when
 * - Recursive functions
 * - Tail recursion: @tailrec
 * - Sequences for lazy evaluation
 * - Nested when expressions
 *
 * BEST PRACTICES:
 * - Prefer when over if-else chains
 * - Use if/when as expressions
 * - Guard clauses for validation
 * - Safe calls over null checks
 * - Elvis for defaults
 * - Sealed classes for type safety
 * - Early returns for clarity
 * - Let for null-safe operations
 * - Apply for object configuration
 * - Tail recursion for optimization
 */
