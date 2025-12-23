package com.example.basic

/**
 * Kotlin Operators Tutorial
 *
 * This file demonstrates all operators in Kotlin, including arithmetic,
 * comparison, logical, assignment, and special operators commonly used
 * in Android development.
 */

fun main() {
    println("=== Kotlin Operators Tutorial ===\n")
    
    // 1. ARITHMETIC OPERATORS
    demonstrateArithmeticOperators()
    
    // 2. COMPARISON OPERATORS
    demonstrateComparisonOperators()
    
    // 3. LOGICAL OPERATORS
    demonstrateLogicalOperators()
    
    // 4. ASSIGNMENT OPERATORS
    demonstrateAssignmentOperators()
    
    // 5. INCREMENT AND DECREMENT
    demonstrateIncrementDecrement()
    
    // 6. RANGE OPERATORS
    demonstrateRangeOperators()
    
    // 7. ELVIS AND SAFE CALL OPERATORS
    demonstrateNullSafetyOperators()
    
    // 8. BITWISE OPERATORS
    demonstrateBitwiseOperators()
    
    // 9. OPERATOR OVERLOADING
    demonstrateOperatorOverloading()
    
    // 10. SPECIAL OPERATORS
    demonstrateSpecialOperators()
}

private fun demonstrateArithmeticOperators() {
    println("1. ARITHMETIC OPERATORS:")
    
    val a = 10
    val b = 3
    
    // Basic arithmetic
    println("   Basic arithmetic:")
    println("   a = $a, b = $b")
    println("   Addition (a + b): ${a + b}")
    println("   Subtraction (a - b): ${a - b}")
    println("   Multiplication (a * b): ${a * b}")
    println("   Division (a / b): ${a / b}")
    println("   Modulus (a % b): ${a % b}")
    
    // Floating point arithmetic
    val x = 10.0
    val y = 3.0
    
    println("   Floating point arithmetic:")
    println("   x = $x, y = $y")
    println("   Division (x / y): ${x / y}")
    println("   Modulus (x % y): ${x % y}")
    
    // Unary operators
    val num = 5
    println("   Unary operators:")
    println("   Positive (+num): ${+num}")
    println("   Negative (-num): ${-num}")
    
    // Mixed operations
    val result1 = 10 + 5 * 2
    val result2 = (10 + 5) * 2
    println("   Mixed operations:")
    println("   10 + 5 * 2 = $result1")
    println("   (10 + 5) * 2 = $result2")
    
    // Integer division vs floating point
    println("   Integer vs floating point division:")
    println("   10 / 3 = ${10 / 3}")
    println("   10.0 / 3 = ${10.0 / 3}")
    println("   10 / 3.0 = ${10 / 3.0}")
    
    println()
}

private fun demonstrateComparisonOperators() {
    println("2. COMPARISON OPERATORS:")
    
    val a = 10
    val b = 20
    val c = 10
    
    println("   a = $a, b = $b, c = $c")
    
    // Equality operators
    println("   Equality operators:")
    println("   a == b: ${a == b}")
    println("   a == c: ${a == c}")
    println("   a != b: ${a != b}")
    println("   a != c: ${a != c}")
    
    // Relational operators
    println("   Relational operators:")
    println("   a < b: ${a < b}")
    println("   a > b: ${a > b}")
    println("   a <= c: ${a <= c}")
    println("   a >= c: ${a >= c}")
    
    // String comparison
    val str1 = "apple"
    val str2 = "banana"
    val str3 = "apple"
    
    println("   String comparison:")
    println("   str1 = \"$str1\", str2 = \"$str2\", str3 = \"$str3\"")
    println("   str1 == str2: ${str1 == str2}")
    println("   str1 == str3: ${str1 == str3}")
    println("   str1 < str2: ${str1 < str2}")
    
    // Reference equality
    val list1 = listOf(1, 2, 3)
    val list2 = listOf(1, 2, 3)
    val list3 = list1
    
    println("   Reference equality:")
    println("   list1 == list2 (structural): ${list1 == list2}")
    println("   list1 === list2 (referential): ${list1 === list2}")
    println("   list1 === list3 (referential): ${list1 === list3}")
    
    println()
}

private fun demonstrateLogicalOperators() {
    println("3. LOGICAL OPERATORS:")
    
    val isAdult = true
    val hasLicense = false
    val hasExperience = true
    
    println("   isAdult = $isAdult")
    println("   hasLicense = $hasLicense")
    println("   hasExperience = $hasExperience")
    
    // AND operator
    println("   AND operator (&&):")
    println("   isAdult && hasLicense: ${isAdult && hasLicense}")
    println("   isAdult && hasExperience: ${isAdult && hasExperience}")
    
    // OR operator
    println("   OR operator (||):")
    println("   hasLicense || hasExperience: ${hasLicense || hasExperience}")
    println("   !isAdult || hasLicense: ${!isAdult || hasLicense}")
    
    // NOT operator
    println("   NOT operator (!):")
    println("   !isAdult: ${!isAdult}")
    println("   !hasLicense: ${!hasLicense}")
    
    // Complex expressions
    println("   Complex expressions:")
    println("   isAdult && (hasLicense || hasExperience): ${isAdult && (hasLicense || hasExperience)}")
    println("   !isAdult || (hasLicense && hasExperience): ${!isAdult || (hasLicense && hasExperience)}")
    
    // Short-circuit evaluation
    println("   Short-circuit evaluation:")
    var count = 0
    fun incrementCount(): Boolean {
        count++
        return true
    }
    
    val result1 = false && incrementCount()
    println("   false && incrementCount(): $result1, count = $count")
    
    count = 0
    val result2 = true || incrementCount()
    println("   true || incrementCount(): $result2, count = $count")
    
    println()
}

private fun demonstrateAssignmentOperators() {
    println("4. ASSIGNMENT OPERATORS:")
    
    // Simple assignment
    var x = 10
    println("   Simple assignment:")
    println("   x = 10: x = $x")
    
    // Compound assignment
    println("   Compound assignment:")
    x += 5  // x = x + 5
    println("   x += 5: x = $x")
    
    x -= 3  // x = x - 3
    println("   x -= 3: x = $x")
    
    x *= 2  // x = x * 2
    println("   x *= 2: x = $x")
    
    x /= 4  // x = x / 4
    println("   x /= 4: x = $x")
    
    x %= 3  // x = x % 3
    println("   x %= 3: x = $x")
    
    // Multiple assignment
    println("   Multiple assignment with destructuring:")
    val (a, b, c) = Triple(1, 2, 3)
    println("   (a, b, c) = Triple(1, 2, 3)")
    println("   a = $a, b = $b, c = $c")
    
    // Swap values
    println("   Swapping values:")
    var num1 = 10
    var num2 = 20
    println("   Before: num1 = $num1, num2 = $num2")
    num1 = num2.also { num2 = num1 }
    println("   After: num1 = $num1, num2 = $num2")
    
    println()
}

private fun demonstrateIncrementDecrement() {
    println("5. INCREMENT AND DECREMENT OPERATORS:")
    
    // Prefix increment
    var a = 10
    println("   Prefix increment (++a):")
    println("   a = $a")
    println("   ++a = ${++a}")
    println("   a = $a")
    
    // Postfix increment
    var b = 10
    println("   Postfix increment (a++):")
    println("   b = $b")
    println("   b++ = ${b++}")
    println("   b = $b")
    
    // Prefix decrement
    var c = 10
    println("   Prefix decrement (--c):")
    println("   c = $c")
    println("   --c = ${--c}")
    println("   c = $c")
    
    // Postfix decrement
    var d = 10
    println("   Postfix decrement (d--):")
    println("   d = $d")
    println("   d-- = ${d--}")
    println("   d = $d")
    
    // In expressions
    println("   In expressions:")
    var x = 5
    val result1 = ++x * 2
    println("   x = 5, ++x * 2 = $result1, x = $x")
    
    var y = 5
    val result2 = y++ * 2
    println("   y = 5, y++ * 2 = $result2, y = $y")
    
    println()
}

private fun demonstrateRangeOperators() {
    println("6. RANGE OPERATORS:")
    
    // Range with ..
    println("   Range with .. (inclusive):")
    val range1 = 1..10
    println("   1..10: $range1")
    println("   Contains 5: ${5 in range1}")
    println("   Contains 15: ${15 in range1}")
    
    // Range with until
    println("   Range with until (exclusive):")
    val range2 = 1 until 10
    println("   1 until 10: $range2")
    println("   Contains 10: ${10 in range2}")
    
    // Downward range
    println("   Downward range:")
    val range3 = 10 downTo 1
    println("   10 downTo 1: $range3")
    
    // Range with step
    println("   Range with step:")
    val range4 = 1..10 step 2
    println("   1..10 step 2: ${range4.toList()}")
    
    val range5 = 10 downTo 1 step 3
    println("   10 downTo 1 step 3: ${range5.toList()}")
    
    // Character range
    println("   Character range:")
    val charRange = 'a'..'z'
    println("   'a'..'z' contains 'm': ${'m' in charRange}")
    
    // Iterating over range
    println("   Iterating over range:")
    print("   1..5: ")
    for (i in 1..5) {
        print("$i ")
    }
    println()
    
    // Range operations
    println("   Range operations:")
    val numbers = 1..100
    println("   First: ${numbers.first}")
    println("   Last: ${numbers.last}")
    println("   Step: ${numbers.step}")
    
    println()
}

private fun demonstrateNullSafetyOperators() {
    println("7. ELVIS AND SAFE CALL OPERATORS:")
    
    // Safe call operator (?.)
    println("   Safe call operator (?.):")
    val str: String? = "Hello"
    val nullStr: String? = null
    
    println("   str = \"$str\"")
    println("   str?.length = ${str?.length}")
    println("   nullStr = $nullStr")
    println("   nullStr?.length = ${nullStr?.length}")
    
    // Elvis operator (?:)
    println("   Elvis operator (?:):")
    val length1 = str?.length ?: 0
    val length2 = nullStr?.length ?: 0
    println("   str?.length ?: 0 = $length1")
    println("   nullStr?.length ?: 0 = $length2")
    
    // Chaining safe calls
    println("   Chaining safe calls:")
    data class Address(val street: String?, val city: String?)
    data class Person(val name: String?, val address: Address?)
    
    val person1 = Person("John", Address("Main St", "NYC"))
    val person2 = Person("Jane", null)
    
    println("   person1.address?.city = ${person1.address?.city}")
    println("   person2.address?.city = ${person2.address?.city}")
    println("   person2.address?.city ?: \"Unknown\" = ${person2.address?.city ?: "Unknown"}")
    
    // Not-null assertion (!!)
    println("   Not-null assertion (!!):")
    println("   str!!.length = ${str!!.length}")
    
    // Let function with safe call
    println("   Let function with safe call:")
    str?.let {
        println("   String is not null: $it")
    }
    nullStr?.let {
        println("   This won't print")
    }
    
    println()
}

private fun demonstrateBitwiseOperators() {
    println("8. BITWISE OPERATORS:")
    
    val a = 12  // 1100 in binary
    val b = 10  // 1010 in binary
    
    println("   a = $a (${Integer.toBinaryString(a)})")
    println("   b = $b (${Integer.toBinaryString(b)})")
    
    // AND
    val and = a and b
    println("   a and b = $and (${Integer.toBinaryString(and)})")
    
    // OR
    val or = a or b
    println("   a or b = $or (${Integer.toBinaryString(or)})")
    
    // XOR
    val xor = a xor b
    println("   a xor b = $xor (${Integer.toBinaryString(xor)})")
    
    // Inversion
    val inv = a.inv()
    println("   a.inv() = $inv (${Integer.toBinaryString(inv)})")
    
    // Left shift
    val shl = a shl 2
    println("   a shl 2 = $shl (${Integer.toBinaryString(shl)})")
    
    // Right shift (signed)
    val shr = a shr 2
    println("   a shr 2 = $shr (${Integer.toBinaryString(shr)})")
    
    // Right shift (unsigned)
    val ushr = a ushr 2
    println("   a ushr 2 = $ushr (${Integer.toBinaryString(ushr)})")
    
    // Practical example: flags
    println("   Practical example - flags:")
    val FLAG_READ = 1 shl 0    // 0001
    val FLAG_WRITE = 1 shl 1   // 0010
    val FLAG_EXECUTE = 1 shl 2 // 0100
    
    var permissions = 0
    permissions = permissions or FLAG_READ or FLAG_WRITE
    
    println("   Has read: ${(permissions and FLAG_READ) != 0}")
    println("   Has write: ${(permissions and FLAG_WRITE) != 0}")
    println("   Has execute: ${(permissions and FLAG_EXECUTE) != 0}")
    
    println()
}

private fun demonstrateOperatorOverloading() {
    println("9. OPERATOR OVERLOADING:")
    
    // Custom class with operator overloading
    data class Point(val x: Int, val y: Int) {
        operator fun plus(other: Point) = Point(x + other.x, y + other.y)
        operator fun minus(other: Point) = Point(x - other.x, y - other.y)
        operator fun times(scalar: Int) = Point(x * scalar, y * scalar)
        operator fun unaryMinus() = Point(-x, -y)
        operator fun inc() = Point(x + 1, y + 1)
    }
    
    val p1 = Point(3, 4)
    val p2 = Point(1, 2)
    
    println("   Custom Point class:")
    println("   p1 = $p1")
    println("   p2 = $p2")
    
    // Addition
    val sum = p1 + p2
    println("   p1 + p2 = $sum")
    
    // Subtraction
    val diff = p1 - p2
    println("   p1 - p2 = $diff")
    
    // Multiplication
    val scaled = p1 * 2
    println("   p1 * 2 = $scaled")
    
    // Unary minus
    val negated = -p1
    println("   -p1 = $negated")
    
    // Increment
    var p3 = Point(5, 5)
    p3++
    println("   p3++ = $p3")
    
    // Comparison operators
    data class Version(val major: Int, val minor: Int) : Comparable<Version> {
        override fun compareTo(other: Version): Int {
            return when {
                major != other.major -> major - other.major
                else -> minor - other.minor
            }
        }
    }
    
    val v1 = Version(1, 5)
    val v2 = Version(2, 0)
    val v3 = Version(1, 3)
    
    println("   Custom Version class:")
    println("   v1 = $v1, v2 = $v2, v3 = $v3")
    println("   v1 < v2: ${v1 < v2}")
    println("   v1 > v3: ${v1 > v3}")
    
    println()
}

private fun demonstrateSpecialOperators() {
    println("10. SPECIAL OPERATORS:")
    
    // In operator
    println("   In operator:")
    val numbers = listOf(1, 2, 3, 4, 5)
    println("   3 in numbers: ${3 in numbers}")
    println("   10 in numbers: ${10 in numbers}")
    println("   10 !in numbers: ${10 !in numbers}")
    
    // Is operator
    println("   Is operator (type checking):")
    val value: Any = "Hello"
    println("   value is String: ${value is String}")
    println("   value is Int: ${value is Int}")
    println("   value !is Int: ${value !is Int}")
    
    // As operator (type casting)
    println("   As operator (type casting):")
    val str = value as String
    println("   value as String: $str")
    
    // Safe cast
    val num = value as? Int
    println("   value as? Int: $num")
    
    // Index access operator
    println("   Index access operator:")
    val list = listOf("a", "b", "c")
    println("   list[1]: ${list[1]}")
    
    val map = mapOf("key1" to "value1", "key2" to "value2")
    println("   map[\"key1\"]: ${map["key1"]}")
    
    // Invoke operator
    println("   Invoke operator:")
    class Greeter {
        operator fun invoke(name: String) = "Hello, $name!"
    }
    
    val greeter = Greeter()
    println("   greeter(\"World\"): ${greeter("World")}")
    
    // Spread operator
    println("   Spread operator (*):")
    fun printNumbers(vararg numbers: Int) {
        println("   Numbers: ${numbers.joinToString(", ")}")
    }
    
    val array = intArrayOf(1, 2, 3, 4, 5)
    printNumbers(*array)
    
    // To operator (pair creation)
    println("   To operator (pair creation):")
    val pair = "name" to "John"
    println("   \"name\" to \"John\": $pair")
    
    println()
}

/**
 * OPERATORS SUMMARY:
 *
 * ARITHMETIC OPERATORS:
 * - +  : Addition
 * - -  : Subtraction
 * - *  : Multiplication
 * - /  : Division
 * - %  : Modulus (remainder)
 * - +a : Unary plus
 * - -a : Unary minus
 *
 * COMPARISON OPERATORS:
 * - == : Structural equality
 * - != : Structural inequality
 * - === : Referential equality
 * - !== : Referential inequality
 * - <  : Less than
 * - >  : Greater than
 * - <= : Less than or equal
 * - >= : Greater than or equal
 *
 * LOGICAL OPERATORS:
 * - && : AND (short-circuit)
 * - || : OR (short-circuit)
 * - !  : NOT
 *
 * ASSIGNMENT OPERATORS:
 * - =  : Simple assignment
 * - += : Add and assign
 * - -= : Subtract and assign
 * - *= : Multiply and assign
 * - /= : Divide and assign
 * - %= : Modulus and assign
 *
 * INCREMENT/DECREMENT:
 * - ++ : Increment
 * - -- : Decrement
 * - Prefix: ++a (increment first)
 * - Postfix: a++ (use first, then increment)
 *
 * RANGE OPERATORS:
 * - .. : Range (inclusive)
 * - until : Range (exclusive)
 * - downTo : Downward range
 * - step : Range with step
 * - in : Check if value in range
 *
 * NULL SAFETY:
 * - ?. : Safe call
 * - ?: : Elvis operator
 * - !! : Not-null assertion
 * - ?  : Nullable type
 *
 * BITWISE OPERATORS:
 * - and : Bitwise AND
 * - or : Bitwise OR
 * - xor : Bitwise XOR
 * - inv() : Bitwise inversion
 * - shl : Shift left
 * - shr : Shift right (signed)
 * - ushr : Shift right (unsigned)
 *
 * SPECIAL OPERATORS:
 * - in : Membership check
 * - !in : Not in
 * - is : Type check
 * - !is : Not type
 * - as : Type cast
 * - as? : Safe cast
 * - [] : Index access
 * - () : Invoke
 * - * : Spread operator
 * - to : Pair creation
 *
 * OPERATOR OVERLOADING:
 * - Define operator fun in class
 * - plus, minus, times, div, rem
 * - unaryPlus, unaryMinus
 * - inc, dec
 * - compareTo for <, >, <=, >=
 * - get, set for []
 * - invoke for ()
 * - rangeTo for ..
 *
 * BEST PRACTICES:
 * - Use appropriate operator for the task
 * - Be careful with operator precedence
 * - Use parentheses for clarity
 * - Avoid excessive operator overloading
 * - Use null-safety operators properly
 * - Prefer safe cast over unsafe cast
 * - Use meaningful overloaded operators
 * - Consider readability over brevity
 */
