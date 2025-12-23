package com.example.basic

/**
 * Kotlin Type Conversion Tutorial
 *
 * This file demonstrates type conversion in Kotlin, including explicit conversion,
 * safe conversion, and best practices for handling different data types.
 */

fun main() {
    println("=== Kotlin Type Conversion Tutorial ===\n")
    
    // 1. EXPLICIT TYPE CONVERSION
    demonstrateExplicitConversion()
    
    // 2. STRING TO NUMBER CONVERSION
    demonstrateStringToNumberConversion()
    
    // 3. SAFE CONVERSION METHODS
    demonstrateSafeConversion()
    
    // 4. NUMBER TO STRING CONVERSION
    demonstrateNumberToStringConversion()
    
    // 5. CHARACTER CONVERSION
    demonstrateCharacterConversion()
    
    // 6. COLLECTION TYPE CONVERSION
    demonstrateCollectionConversion()
    
    // 7. CUSTOM TYPE CONVERSION
    demonstrateCustomConversion()
    
    // 8. COMMON CONVERSION PATTERNS
    demonstrateCommonPatterns()
}

private fun demonstrateExplicitConversion() {
    println("1. EXPLICIT TYPE CONVERSION:")
    println("   Kotlin requires explicit conversion between different numeric types")
    
    // Integer conversions
    val intValue = 42
    val longValue = intValue.toLong()
    val floatValue = intValue.toFloat()
    val doubleValue = intValue.toDouble()
    val byteValue = intValue.toByte()
    val shortValue = intValue.toShort()
    
    println("   Integer conversions:")
    println("   Int: $intValue")
    println("   To Long: $longValue")
    println("   To Float: $floatValue")
    println("   To Double: $doubleValue")
    println("   To Byte: $byteValue")
    println("   To Short: $shortValue")
    
    // Floating-point conversions
    val doubleNum = 3.14159
    val floatNum = doubleNum.toFloat()
    val intFromDouble = doubleNum.toInt()
    val longFromDouble = doubleNum.toLong()
    
    println("   Floating-point conversions:")
    println("   Double: $doubleNum")
    println("   To Float: $floatNum")
    println("   To Int: $intFromDouble (truncated)")
    println("   To Long: $longFromDouble (truncated)")
    
    // Precision loss example
    val preciseDouble = 3.141592653589793
    val lessPreciseFloat = preciseDouble.toFloat()
    println("   Precision loss example:")
    println("   Original Double: $preciseDouble")
    println("   Converted Float: $lessPreciseFloat")
    
    println()
}

private fun demonstrateStringToNumberConversion() {
    println("2. STRING TO NUMBER CONVERSION:")
    
    // Basic string to number conversion
    val numberString = "123"
    val intFromString = numberString.toInt()
    val longFromString = numberString.toLong()
    val doubleFromString = numberString.toDouble()
    val floatFromString = numberString.toFloat()
    
    println("   Basic conversion:")
    println("   String: \"$numberString\"")
    println("   To Int: $intFromString")
    println("   To Long: $longFromString")
    println("   To Double: $doubleFromString")
    println("   To Float: $floatFromString")
    
    // Decimal string conversion
    val decimalString = "3.14159"
    val doubleFromDecimal = decimalString.toDouble()
    val floatFromDecimal = decimalString.toFloat()
    
    println("   Decimal conversion:")
    println("   String: \"$decimalString\"")
    println("   To Double: $doubleFromDecimal")
    println("   To Float: $floatFromDecimal")
    
    // Hexadecimal and binary conversion
    val hexString = "FF"
    val binaryString = "1010"
    
    println("   Special base conversion:")
    println("   Hex \"$hexString\" to Int: ${hexString.toInt(16)}")
    println("   Binary \"$binaryString\" to Int: ${binaryString.toInt(2)}")
    
    // Invalid conversion (will throw exception)
    println("   Invalid conversion example:")
    try {
        val invalidString = "abc"
        val invalidInt = invalidString.toInt()
        println("   This won't print: $invalidInt")
    } catch (e: NumberFormatException) {
        println("   Caught NumberFormatException: ${e.message}")
    }
    
    println()
}

private fun demonstrateSafeConversion() {
    println("3. SAFE CONVERSION METHODS:")
    println("   Use safe conversion methods to avoid exceptions")
    
    // Safe string to number conversion
    val validString = "123"
    val invalidString = "abc"
    
    val safeInt1 = validString.toIntOrNull()
    val safeInt2 = invalidString.toIntOrNull()
    val safeDouble1 = validString.toDoubleOrNull()
    val safeDouble2 = invalidString.toDoubleOrNull()
    
    println("   Safe string to number conversion:")
    println("   \"$validString\" to Int: $safeInt1")
    println("   \"$invalidString\" to Int: $safeInt2")
    println("   \"$validString\" to Double: $safeDouble1")
    println("   \"$invalidString\" to Double: $safeDouble2")
    
    // Using safe conversion with default values
    val userInput = "not_a_number"
    val number = userInput.toIntOrNull() ?: 0
    val price = userInput.toDoubleOrNull() ?: 0.0
    
    println("   Safe conversion with default values:")
    println("   User input: \"$userInput\"")
    println("   Number (default 0): $number")
    println("   Price (default 0.0): $price")
    
    // Safe conversion in collections
    val stringList = listOf("1", "2", "abc", "4", "xyz")
    val validNumbers = stringList.mapNotNull { it.toIntOrNull() }
    
    println("   Safe conversion in collections:")
    println("   Original list: $stringList")
    println("   Valid numbers only: $validNumbers")
    
    println()
}

private fun demonstrateNumberToStringConversion() {
    println("4. NUMBER TO STRING CONVERSION:")
    
    // Basic number to string conversion
    val intNum = 42
    val doubleNum = 3.14159
    val floatNum = 2.5f
    
    val intString = intNum.toString()
    val doubleString = doubleNum.toString()
    val floatString = floatNum.toString()
    
    println("   Basic conversion:")
    println("   Int $intNum to String: \"$intString\"")
    println("   Double $doubleNum to String: \"$doubleString\"")
    println("   Float $floatNum to String: \"$floatString\"")
    
    // Formatted string conversion
    val price = 19.99
    val formattedPrice = String.format("%.2f", price)
    val currencyFormat = String.format("$%.2f", price)
    
    println("   Formatted conversion:")
    println("   Price: $price")
    println("   Formatted (2 decimals): \"$formattedPrice\"")
    println("   Currency format: \"$currencyFormat\"")
    
    // Different base conversions
    val number = 255
    val binaryString = number.toString(2)
    val hexString = number.toString(16)
    val octalString = number.toString(8)
    
    println("   Different base conversions:")
    println("   Number: $number")
    println("   Binary: \"$binaryString\"")
    println("   Hexadecimal: \"$hexString\"")
    println("   Octal: \"$octalString\"")
    
    // String interpolation vs toString()
    val name = "John"
    val age = 25
    val interpolatedString = "Name: $name, Age: $age"
    val concatenatedString = "Name: " + name + ", Age: " + age.toString()
    
    println("   String interpolation vs toString():")
    println("   Interpolated: \"$interpolatedString\"")
    println("   Concatenated: \"$concatenatedString\"")
    
    println()
}

private fun demonstrateCharacterConversion() {
    println("5. CHARACTER CONVERSION:")
    
    // Character to string conversion
    val char = 'A'
    val charString = char.toString()
    val charCode = char.code
    val charFromCode = charCode.toChar()
    
    println("   Character conversions:")
    println("   Char: '$char'")
    println("   To String: \"$charString\"")
    println("   To Int (Unicode): $charCode")
    println("   From Int to Char: '$charFromCode'")
    
    // Case conversion
    val lowercaseChar = 'a'
    val uppercaseChar = lowercaseChar.uppercaseChar()
    val uppercaseString = lowercaseChar.uppercase()
    
    println("   Case conversion:")
    println("   Lowercase: '$lowercaseChar'")
    println("   Uppercase char: '$uppercaseChar'")
    println("   Uppercase string: \"$uppercaseString\"")
    
    // Character to number conversion
    val digitChar = '5'
    val digitValue = digitChar.digitToInt()
    val digitValueOrNull = digitChar.digitToIntOrNull()
    
    println("   Character to number:")
    println("   Digit char: '$digitChar'")
    println("   Digit value: $digitValue")
    println("   Digit value (safe): $digitValueOrNull")
    
    // Non-digit character
    val nonDigitChar = 'X'
    val nonDigitValue = nonDigitChar.digitToIntOrNull()
    
    println("   Non-digit character:")
    println("   Non-digit char: '$nonDigitChar'")
    println("   Digit value (safe): $nonDigitValue")
    
    println()
}

private fun demonstrateCollectionConversion() {
    println("6. COLLECTION TYPE CONVERSION:")
    
    // Array to list conversion
    val intArray = intArrayOf(1, 2, 3, 4, 5)
    val intList = intArray.toList()
    val mutableList = intArray.toMutableList()
    
    println("   Array to list conversion:")
    println("   Int array: ${intArray.contentToString()}")
    println("   To list: $intList")
    println("   To mutable list: $mutableList")
    
    // List to array conversion
    val stringList = listOf("apple", "banana", "cherry")
    val stringArray = stringList.toTypedArray()
    val intList2 = listOf(1, 2, 3, 4, 5)
    val intArray2 = intList2.toIntArray()
    
    println("   List to array conversion:")
    println("   String list: $stringList")
    println("   To array: ${stringArray.contentToString()}")
    println("   Int list: $intList2")
    println("   To int array: ${intArray2.contentToString()}")
    
    // Set conversion
    val listWithDuplicates = listOf(1, 2, 2, 3, 3, 3, 4)
    val uniqueSet = listWithDuplicates.toSet()
    val sortedSet = listWithDuplicates.toSortedSet()
    
    println("   List to set conversion:")
    println("   List with duplicates: $listWithDuplicates")
    println("   To set: $uniqueSet")
    println("   To sorted set: $sortedSet")
    
    // Map conversion
    val pairList = listOf("a" to 1, "b" to 2, "c" to 3)
    val map = pairList.toMap()
    val mutableMap = pairList.toMap().toMutableMap()
    
    println("   List to map conversion:")
    println("   Pair list: $pairList")
    println("   To map: $map")
    println("   To mutable map: $mutableMap")
    
    println()
}

private fun demonstrateCustomConversion() {
    println("7. CUSTOM TYPE CONVERSION:")
    
    // Extension functions for custom conversion
    fun String.toBooleanOrNull(): Boolean? {
        return when (this.lowercase()) {
            "true", "1", "yes", "on" -> true
            "false", "0", "no", "off" -> false
            else -> null
        }
    }
    
    fun Int.toRomanNumeral(): String {
        val values = listOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val symbols = listOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
        
        var result = ""
        var number = this
        
        for (i in values.indices) {
            while (number >= values[i]) {
                result += symbols[i]
                number -= values[i]
            }
        }
        return result
    }
    
    // Using custom conversion functions
    val booleanString1 = "true"
    val booleanString2 = "false"
    val booleanString3 = "maybe"
    
    println("   Custom string to boolean conversion:")
    println("   \"$booleanString1\" to Boolean: ${booleanString1.toBooleanOrNull()}")
    println("   \"$booleanString2\" to Boolean: ${booleanString2.toBooleanOrNull()}")
    println("   \"$booleanString3\" to Boolean: ${booleanString3.toBooleanOrNull()}")
    
    val numbers = listOf(1, 5, 10, 50, 100, 500, 1000)
    println("   Custom int to Roman numeral conversion:")
    numbers.forEach { num ->
        println("   $num = ${num.toRomanNumeral()}")
    }
    
    println()
}

private fun demonstrateCommonPatterns() {
    println("8. COMMON CONVERSION PATTERNS:")
    
    // Pattern 1: Safe parsing with default
    fun parseAge(input: String): Int {
        return input.toIntOrNull() ?: 0
    }
    
    val ageInputs = listOf("25", "invalid", "30", "not_a_number")
    val ages = ageInputs.map(::parseAge)
    
    println("   Pattern 1 - Safe parsing with default:")
    println("   Inputs: $ageInputs")
    println("   Parsed ages: $ages")
    
    // Pattern 2: Conditional conversion
    fun convertToNumber(input: String): Number? {
        return when {
            input.contains(".") -> input.toDoubleOrNull()
            else -> input.toIntOrNull()
        }
    }
    
    val numberInputs = listOf("42", "3.14", "100", "2.718", "invalid")
    val numbers = numberInputs.mapNotNull(::convertToNumber)
    
    println("   Pattern 2 - Conditional conversion:")
    println("   Inputs: $numberInputs")
    println("   Converted numbers: $numbers")
    
    // Pattern 3: Collection transformation
    val stringNumbers = listOf("1", "2", "3", "4", "5")
    val intNumbers = stringNumbers.mapNotNull { it.toIntOrNull() }
    val sum = intNumbers.sum()
    
    println("   Pattern 3 - Collection transformation:")
    println("   String numbers: $stringNumbers")
    println("   Int numbers: $intNumbers")
    println("   Sum: $sum")
    
    // Pattern 4: Type validation
    fun isValidEmail(email: String): Boolean {
        return email.contains("@") && email.contains(".")
    }
    
    fun isValidPhone(phone: String): Boolean {
        return phone.all { it.isDigit() || it == '-' || it == '(' || it == ')' || it == ' ' }
    }
    
    val contacts = listOf("john@email.com", "123-456-7890", "invalid", "jane@domain.org")
    val emails = contacts.filter(::isValidEmail)
    val phones = contacts.filter(::isValidPhone)
    
    println("   Pattern 4 - Type validation:")
    println("   Contacts: $contacts")
    println("   Valid emails: $emails")
    println("   Valid phones: $phones")
    
    // Pattern 5: Format conversion
    fun formatCurrency(amount: Double): String {
        return String.format("$%.2f", amount)
    }
    
    fun formatPercentage(value: Double): String {
        return String.format("%.1f%%", value * 100)
    }
    
    val prices = listOf(19.99, 25.50, 0.99, 100.0)
    val percentages = listOf(0.15, 0.25, 0.05, 0.10)
    
    println("   Pattern 5 - Format conversion:")
    println("   Prices: ${prices.map(::formatCurrency)}")
    println("   Percentages: ${percentages.map(::formatPercentage)}")
    
    println()
}

/**
 * TYPE CONVERSION SUMMARY:
 *
 * EXPLICIT CONVERSION:
 * - Use .toXXX() methods for explicit conversion
 * - Required between different numeric types
 * - May result in precision loss or overflow
 *
 * SAFE CONVERSION:
 * - Use .toXXXOrNull() methods to avoid exceptions
 * - Returns null for invalid input
 * - Combine with Elvis operator (?:) for default values
 *
 * STRING CONVERSION:
 * - Use .toString() to convert numbers to strings
 * - Use .toInt(), .toDouble(), etc. to convert strings to numbers
 * - Use .toIntOrNull(), .toDoubleOrNull() for safe conversion
 *
 * CHARACTER CONVERSION:
 * - Use .toString() to convert char to string
 * - Use .code to get Unicode value
 * - Use .toChar() to convert Int to char
 * - Use .digitToInt() for digit characters
 *
 * COLLECTION CONVERSION:
 * - Use .toList(), .toSet(), .toMap() for collection conversion
 * - Use .toTypedArray(), .toIntArray() for array conversion
 * - Use .toMutableList(), .toMutableSet() for mutable collections
 *
 * BEST PRACTICES:
 * - Always use safe conversion methods when dealing with user input
 * - Provide default values for failed conversions
 * - Use appropriate formatting for display purposes
 * - Validate input before conversion when possible
 * - Consider precision loss in floating-point conversions
 */
