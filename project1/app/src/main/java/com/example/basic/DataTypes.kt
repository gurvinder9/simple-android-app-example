package com.example.basic

/**
 * Kotlin Data Types Tutorial
 *
 * This file demonstrates the different data types available in Kotlin
 * and how to use them effectively in Android development.
 */

fun main() {
    println("=== Kotlin Data Types Tutorial ===\n")
    
    // 1. NUMERIC DATA TYPES
    demonstrateNumericTypes()
    
    // 2. CHARACTER AND STRING TYPES
    demonstrateCharacterAndStringTypes()
    
    // 3. BOOLEAN TYPE
    demonstrateBooleanType()
    
    // 4. ARRAYS
    demonstrateArrays()
    
    // 5. COLLECTIONS
    demonstrateCollections()
    
    // 6. NULLABLE TYPES
    demonstrateNullableTypes()
    
    // 7. TYPE CONVERSION
    demonstrateTypeConversion()
    
    // 8. TYPE CHECKING AND CASTING
    demonstrateTypeCheckingAndCasting()
}

private fun demonstrateNumericTypes() {
    println("1. NUMERIC DATA TYPES:")
    println("   Kotlin provides several numeric types for different use cases")
    
    // Integer types
    val byteValue: Byte = 127                    // 8-bit signed integer (-128 to 127)
    val shortValue: Short = 32767                // 16-bit signed integer (-32,768 to 32,767)
    val intValue: Int = 2147483647               // 32-bit signed integer (-2^31 to 2^31-1)
    val longValue: Long = 9223372036854775807L   // 64-bit signed integer (-2^63 to 2^63-1)
    
    // Floating-point types
    val floatValue: Float = 3.14f                // 32-bit floating point
    val doubleValue: Double = 3.14159265359      // 64-bit floating point (default for decimals)
    
    println("   Integer types:")
    println("   Byte: $byteValue (${Byte.MIN_VALUE} to ${Byte.MAX_VALUE})")
    println("   Short: $shortValue (${Short.MIN_VALUE} to ${Short.MAX_VALUE})")
    println("   Int: $intValue (${Int.MIN_VALUE} to ${Int.MAX_VALUE})")
    println("   Long: $longValue (${Long.MIN_VALUE} to ${Long.MAX_VALUE})")
    
    println("   Floating-point types:")
    println("   Float: $floatValue")
    println("   Double: $doubleValue")
    
    // Underscores for readability
    val readableNumber = 1_000_000
    val readableFloat = 3.141_592_653_59
    println("   Readable numbers: $readableNumber, $readableFloat")
    
    println()
}

private fun demonstrateCharacterAndStringTypes() {
    println("2. CHARACTER AND STRING TYPES:")
    
    // Character type
    val charValue: Char = 'A'
    val unicodeChar: Char = '\u0041'  // Unicode for 'A'
    val newlineChar: Char = '\n'
    val tabChar: Char = '\t'
    
    println("   Character type:")
    println("   Char: '$charValue'")
    println("   Unicode char: '$unicodeChar'")
    println("   Special chars: newline='$newlineChar', tab='$tabChar'")
    
    // String type
    val stringValue: String = "Hello, Kotlin!"
    val multiLineString = """
        This is a multi-line string
        It can span multiple lines
        and preserves formatting
    """.trimIndent()
    
    val stringWithVariables = "The value is: $stringValue"
    val stringWithExpression = "Length of string: ${stringValue.length}"
    
    println("   String type:")
    println("   String: \"$stringValue\"")
    println("   Multi-line string:")
    println(multiLineString)
    println("   String interpolation: $stringWithVariables")
    println("   Expression interpolation: $stringWithExpression")
    
    // String methods
    println("   String methods:")
    println("   Length: ${stringValue.length}")
    println("   Uppercase: ${stringValue.uppercase()}")
    println("   Lowercase: ${stringValue.lowercase()}")
    println("   Substring: ${stringValue.substring(0, 5)}")
    
    println()
}

private fun demonstrateBooleanType() {
    println("3. BOOLEAN TYPE:")
    
    val isTrue: Boolean = true
    val isFalse: Boolean = false
    
    // Boolean operations
    val andResult = isTrue && isFalse
    val orResult = isTrue || isFalse
    val notResult = !isTrue
    
    println("   Boolean values: $isTrue, $isFalse")
    println("   Logical operations:")
    println("   AND (&&): $isTrue && $isFalse = $andResult")
    println("   OR (||): $isTrue || $isFalse = $orResult")
    println("   NOT (!): !$isTrue = $notResult")
    
    // Boolean expressions
    val number = 10
    val isEven = number % 2 == 0
    val isPositive = number > 0
    
    println("   Boolean expressions:")
    println("   Number: $number")
    println("   Is even: $isEven")
    println("   Is positive: $isPositive")
    
    println()
}

private fun demonstrateArrays() {
    println("4. ARRAYS:")
    
    // Array creation
    val intArray = intArrayOf(1, 2, 3, 4, 5)
    val stringArray = arrayOf("Apple", "Banana", "Cherry")
    val nullableArray = arrayOfNulls<String>(3)
    
    // Array with constructor
    val sizedArray = Array(5) { it * 2 }  // Creates [0, 2, 4, 6, 8]
    
    println("   Array creation:")
    println("   Int array: ${intArray.contentToString()}")
    println("   String array: ${stringArray.contentToString()}")
    println("   Nullable array: ${nullableArray.contentToString()}")
    println("   Sized array: ${sizedArray.contentToString()}")
    
    // Array operations
    println("   Array operations:")
    println("   First element: ${intArray[0]}")
    println("   Last element: ${intArray[intArray.size - 1]}")
    println("   Array size: ${intArray.size}")
    println("   Contains 3: ${3 in intArray}")
    
    // Array iteration
    println("   Array iteration:")
    for (i in intArray.indices) {
        println("   Index $i: ${intArray[i]}")
    }
    
    println()
}

private fun demonstrateCollections() {
    println("5. COLLECTIONS:")
    
    // Lists
    val list = listOf("Red", "Green", "Blue")
    val mutableList = mutableListOf("A", "B", "C")
    mutableList.add("D")
    
    // Sets
    val set = setOf(1, 2, 3, 3, 4)  // Duplicates removed
    val mutableSet = mutableSetOf("X", "Y", "Z")
    
    // Maps
    val map = mapOf("key1" to "value1", "key2" to "value2")
    val mutableMap = mutableMapOf("a" to 1, "b" to 2)
    mutableMap["c"] = 3
    
    println("   Lists:")
    println("   Immutable list: $list")
    println("   Mutable list: $mutableList")
    
    println("   Sets:")
    println("   Immutable set: $set")
    println("   Mutable set: $mutableSet")
    
    println("   Maps:")
    println("   Immutable map: $map")
    println("   Mutable map: $mutableMap")
    
    // Collection operations
    println("   Collection operations:")
    println("   List size: ${list.size}")
    println("   List contains 'Red': ${"Red" in list}")
    println("   Map value for 'key1': ${map["key1"]}")
    
    println()
}

private fun demonstrateNullableTypes() {
    println("6. NULLABLE TYPES:")
    
    // Nullable variables
    var nullableString: String? = "Hello"
    var nullableInt: Int? = null
    
    println("   Nullable variables:")
    println("   Nullable string: $nullableString")
    println("   Nullable int: $nullableInt")
    
    // Safe call operator
    println("   Safe call operator (?.):")
    println("   Length of nullable string: ${nullableString?.length}")
    println("   Length of null string: ${nullableInt?.toString()?.length}")
    
    // Elvis operator
    val result1 = nullableString ?: "Default value"
    val result2 = nullableInt ?: 0
    
    println("   Elvis operator (?:):")
    println("   Result 1: $result1")
    println("   Result 2: $result2")
    
    // Not-null assertion
    nullableString = "World"
    val length = nullableString!!.length  // Use carefully!
    
    println("   Not-null assertion (!!):")
    println("   Length with !!: $length")
    
    // Safe casting
    val anyValue: Any = "Hello"
    val safeCast = anyValue as? String
    val unsafeCast = anyValue as String
    
    println("   Safe casting:")
    println("   Safe cast result: $safeCast")
    println("   Unsafe cast result: $unsafeCast")
    
    println()
}

private fun demonstrateTypeConversion() {
    println("7. TYPE CONVERSION:")
    
    val intValue = 42
    val longValue = intValue.toLong()
    val floatValue = intValue.toFloat()
    val doubleValue = intValue.toDouble()
    val stringValue = intValue.toString()
    
    println("   Explicit type conversion:")
    println("   Int: $intValue")
    println("   To Long: $longValue")
    println("   To Float: $floatValue")
    println("   To Double: $doubleValue")
    println("   To String: \"$stringValue\"")
    
    // String to number conversion
    val stringNumber = "123"
    val parsedInt = stringNumber.toInt()
    val parsedDouble = stringNumber.toDouble()
    
    println("   String to number conversion:")
    println("   String: \"$stringNumber\"")
    println("   To Int: $parsedInt")
    println("   To Double: $parsedDouble")
    
    // Safe conversion
    val invalidString = "abc"
    val safeInt = invalidString.toIntOrNull()
    val safeDouble = invalidString.toDoubleOrNull()
    
    println("   Safe conversion:")
    println("   Invalid string: \"$invalidString\"")
    println("   Safe to Int: $safeInt")
    println("   Safe to Double: $safeDouble")
    
    println()
}

private fun demonstrateTypeCheckingAndCasting() {
    println("8. TYPE CHECKING AND CASTING:")
    
    val anyValue: Any = "Hello World"
    
    // Type checking
    println("   Type checking:")
    println("   Value: $anyValue")
    println("   Is String: ${anyValue is String}")
    println("   Is Int: ${anyValue is Int}")
    
    // Smart casting
    if (anyValue is String) {
        println("   Smart cast - length: ${anyValue.length}")
        println("   Smart cast - uppercase: ${anyValue.uppercase()}")
    }
    
    // Explicit casting
    val stringValue = anyValue as String
    println("   Explicit cast result: $stringValue")
    
    // Safe casting
    val safeString = anyValue as? String
    val safeInt = anyValue as? Int
    
    println("   Safe casting:")
    println("   Safe to String: $safeString")
    println("   Safe to Int: $safeInt")
    
    // When expression with type checking
    val result = when (anyValue) {
        is String -> "It's a string with length ${anyValue.length}"
        is Int -> "It's an integer: $anyValue"
        is Boolean -> "It's a boolean: $anyValue"
        else -> "It's something else"
    }
    
    println("   When expression result: $result")
    
    println()
}

/**
 * DATA TYPES SUMMARY:
 *
 * NUMERIC TYPES:
 * - Byte: 8-bit signed integer (-128 to 127)
 * - Short: 16-bit signed integer (-32,768 to 32,767)
 * - Int: 32-bit signed integer (-2^31 to 2^31-1) - DEFAULT for integers
 * - Long: 64-bit signed integer (-2^63 to 2^63-1)
 * - Float: 32-bit floating point
 * - Double: 64-bit floating point - DEFAULT for decimals
 *
 * CHARACTER AND STRING TYPES:
 * - Char: Single character (16-bit Unicode)
 * - String: Immutable sequence of characters
 *
 * BOOLEAN TYPE:
 * - Boolean: true or false values
 *
 * COLLECTIONS:
 * - List: Ordered collection of elements
 * - Set: Collection of unique elements
 * - Map: Collection of key-value pairs
 * - Array: Fixed-size collection
 *
 * NULLABLE TYPES:
 * - Any type can be made nullable by adding ?
 * - Use ?. for safe calls
 * - Use ?: for null coalescing
 * - Use !! for non-null assertions (use carefully)
 *
 * TYPE CONVERSION:
 * - Use .toXXX() methods for explicit conversion
 * - Use .toXXXOrNull() for safe conversion
 * - Kotlin doesn't support implicit conversion
 *
 * TYPE CHECKING:
 * - Use 'is' operator for type checking
 * - Smart casting automatically casts after type check
 * - Use 'as' for explicit casting
 * - Use 'as?' for safe casting
 */
