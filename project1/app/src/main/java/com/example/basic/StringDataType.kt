package com.example.basic

/**
 * Kotlin String Data Type Tutorial
 *
 * This file demonstrates the String data type in Kotlin, including string creation,
 * manipulation, formatting, and various string operations commonly used in Android development.
 */

fun main() {
    println("=== Kotlin String Data Type Tutorial ===\n")
    
    // 1. STRING CREATION AND BASICS
    demonstrateStringCreation()
    
    // 2. STRING INTERPOLATION
    demonstrateStringInterpolation()
    
    // 3. STRING MANIPULATION
    demonstrateStringManipulation()
    
    // 4. STRING COMPARISON
    demonstrateStringComparison()
    
    // 5. STRING SEARCHING AND FILTERING
    demonstrateStringSearching()
    
    // 6. STRING FORMATTING
    demonstrateStringFormatting()
    
    // 7. MULTI-LINE STRINGS
    demonstrateMultiLineStrings()
    
    // 8. STRING REGULAR EXPRESSIONS
    demonstrateStringRegex()
    
    // 9. STRING COLLECTIONS AND TRANSFORMATIONS
    demonstrateStringCollections()
    
    // 10. COMMON STRING PATTERNS
    demonstrateCommonStringPatterns()
}

private fun demonstrateStringCreation() {
    println("1. STRING CREATION AND BASICS:")
    
    // Basic string creation
    val string1 = "Hello, World!"
    val string2 = String(charArrayOf('H', 'e', 'l', 'l', 'o'))
    val string3 = String("Hello".toCharArray())
    
    println("   Basic string creation:")
    println("   String literal: \"$string1\"")
    println("   From char array: \"$string2\"")
    println("   From char array (method): \"$string3\"")
    
    // Empty and null strings
    val emptyString = ""
    val blankString = "   "
    val nullString: String? = null
    
    println("   Empty and null strings:")
    println("   Empty string: \"$emptyString\"")
    println("   Blank string: \"$blankString\"")
    println("   Null string: $nullString")
    
    // String properties
    println("   String properties:")
    println("   Length of \"$string1\": ${string1.length}")
    println("   Is empty: ${emptyString.isEmpty()}")
    println("   Is blank: ${blankString.isBlank()}")
    println("   Is not blank: ${string1.isNotBlank()}")
    
    // String indexing
    println("   String indexing:")
    println("   First character: '${string1[0]}'")
    println("   Last character: '${string1[string1.length - 1]}'")
    println("   Character at index 7: '${string1[7]}'")
    
    println()
}

private fun demonstrateStringInterpolation() {
    println("2. STRING INTERPOLATION:")
    
    val name = "John"
    val age = 25
    val salary = 50000.50
    
    // Simple variable interpolation
    val simpleInterpolation = "Hello, $name!"
    println("   Simple interpolation: \"$simpleInterpolation\"")
    
    // Expression interpolation
    val expressionInterpolation = "Name: $name, Age: $age, Next year: ${age + 1}"
    println("   Expression interpolation: \"$expressionInterpolation\"")
    
    // Complex expressions
    val complexInterpolation = "Salary: $salary, Monthly: ${salary / 12}, Formatted: ${String.format("%.2f", salary)}"
    println("   Complex interpolation: \"$complexInterpolation\"")
    
    // Nested interpolation
    val nestedInterpolation = "User info: ${"Name: $name, Age: $age"}"
    println("   Nested interpolation: \"$nestedInterpolation\"")
    
    // Interpolation with different data types
    val booleanValue = true
    val listValue = listOf(1, 2, 3)
    val mapValue = mapOf("key" to "value")
    
    println("   Different data types:")
    println("   Boolean: $booleanValue")
    println("   List: $listValue")
    println("   Map: $mapValue")
    
    println()
}

private fun demonstrateStringManipulation() {
    println("3. STRING MANIPULATION:")
    
    val originalString = "  Hello, Kotlin!  "
    
    // Trimming
    val trimmed = originalString.trim()
    val trimStart = originalString.trimStart()
    val trimEnd = originalString.trimEnd()
    
    println("   Trimming:")
    println("   Original: \"$originalString\"")
    println("   Trimmed: \"$trimmed\"")
    println("   Trim start: \"$trimStart\"")
    println("   Trim end: \"$trimEnd\"")
    
    // Case conversion
    val upperCase = originalString.uppercase()
    val lowerCase = originalString.lowercase()
    val titleCase = originalString.replaceFirstChar { it.uppercase() }
    
    println("   Case conversion:")
    println("   Uppercase: \"$upperCase\"")
    println("   Lowercase: \"$lowerCase\"")
    println("   Title case: \"$titleCase\"")
    
    // Substring operations
    val substring1 = originalString.substring(2, 7)
    val substring2 = originalString.substring(2)
    val substring3 = originalString.substringBefore(",")
    val substring4 = originalString.substringAfter(",")
    
    println("   Substring operations:")
    println("   Substring(2, 7): \"$substring1\"")
    println("   Substring(2): \"$substring2\"")
    println("   Before comma: \"$substring3\"")
    println("   After comma: \"$substring4\"")
    
    // String replacement
    val replaced = originalString.replace("Kotlin", "Android")
    val replacedAll = originalString.replace("l", "L")
    val replacedRegex = originalString.replace(Regex("[^a-zA-Z]"), "")
    
    println("   String replacement:")
    println("   Replace 'Kotlin': \"$replaced\"")
    println("   Replace all 'l': \"$replacedAll\"")
    println("   Remove non-letters: \"$replacedRegex\"")
    
    println()
}

private fun demonstrateStringComparison() {
    println("4. STRING COMPARISON:")
    
    val string1 = "Hello"
    val string2 = "hello"
    val string3 = "Hello"
    val string4 = "HELLO"
    
    // Equality comparison
    println("   Equality comparison:")
    println("   \"$string1\" == \"$string2\": ${string1 == string2}")
    println("   \"$string1\" == \"$string3\": ${string1 == string3}")
    println("   \"$string1\" === \"$string3\": ${string1 === string3}")
    
    // Case-insensitive comparison
    println("   Case-insensitive comparison:")
    println("   \"$string1\" equals \"$string2\" (ignore case): ${string1.equals(string2, ignoreCase = true)}")
    println("   \"$string1\" equals \"$string4\" (ignore case): ${string1.equals(string4, ignoreCase = true)}")
    
    // Lexicographical comparison
    val compareResult1 = string1.compareTo(string2)
    val compareResult2 = string1.compareTo(string3)
    val compareResult3 = string1.compareTo(string4, ignoreCase = true)
    
    println("   Lexicographical comparison:")
    println("   \"$string1\" compareTo \"$string2\": $compareResult1")
    println("   \"$string1\" compareTo \"$string3\": $compareResult2")
    println("   \"$string1\" compareTo \"$string4\" (ignore case): $compareResult3")
    
    // String ordering
    val strings = listOf("banana", "apple", "cherry", "date")
    val sortedStrings = strings.sorted()
    val sortedIgnoreCase = strings.sortedWith(String.CASE_INSENSITIVE_ORDER)
    
    println("   String ordering:")
    println("   Original: $strings")
    println("   Sorted: $sortedStrings")
    println("   Sorted (ignore case): $sortedIgnoreCase")
    
    println()
}

private fun demonstrateStringSearching() {
    println("5. STRING SEARCHING AND FILTERING:")
    
    val text = "Hello, World! Welcome to Kotlin programming."
    
    // Contains operations
    println("   Contains operations:")
    println("   Text: \"$text\"")
    println("   Contains 'World': ${text.contains("World")}")
    println("   Contains 'world' (ignore case): ${text.contains("world", ignoreCase = true)}")
    println("   Contains 'Kotlin' or 'Java': ${text.contains(Regex("Kotlin|Java"))}")
    
    // Index operations
    println("   Index operations:")
    println("   Index of 'World': ${text.indexOf("World")}")
    println("   Last index of 'l': ${text.lastIndexOf("l")}")
    println("   Index of 'o' from position 5: ${text.indexOf("o", 5)}")
    
    // Starts with and ends with
    println("   Starts with and ends with:")
    println("   Starts with 'Hello': ${text.startsWith("Hello")}")
    println("   Starts with 'hello' (ignore case): ${text.startsWith("hello", ignoreCase = true)}")
    println("   Ends with 'programming.': ${text.endsWith("programming.")}")
    
    // Filtering characters
    val lettersOnly = text.filter { it.isLetter() }
    val digitsOnly = text.filter { it.isDigit() }
    val alphanumericOnly = text.filter { it.isLetterOrDigit() }
    
    println("   Character filtering:")
    println("   Letters only: \"$lettersOnly\"")
    println("   Digits only: \"$digitsOnly\"")
    println("   Alphanumeric only: \"$alphanumericOnly\"")
    
    // String splitting
    val words = text.split(" ")
    val sentences = text.split(". ")
    val customSplit = text.split(Regex("[ ,.!]"))
    
    println("   String splitting:")
    println("   Split by space: $words")
    println("   Split by '. ': $sentences")
    println("   Split by regex: $customSplit")
    
    println()
}

private fun demonstrateStringFormatting() {
    println("6. STRING FORMATTING:")
    
    val name = "John"
    val age = 25
    val salary = 50000.50
    val percentage = 0.15
    
    // String.format() method
    val formatted1 = String.format("Name: %s, Age: %d", name, age)
    val formatted2 = String.format("Salary: $%.2f", salary)
    val formatted3 = String.format("Percentage: %.1f%%", percentage * 100)
    
    println("   String.format() method:")
    println("   Basic formatting: \"$formatted1\"")
    println("   Currency formatting: \"$formatted2\"")
    println("   Percentage formatting: \"$formatted3\"")
    
    // Format specifiers
    val number = 12345
    val formatted4 = String.format("Decimal: %d", number)
    val formatted5 = String.format("Hex: %x", number)
    val formatted6 = String.format("Octal: %o", number)
    val formatted7 = String.format("Binary: %s", number.toString(2))
    
    println("   Number formatting:")
    println("   $formatted4")
    println("   $formatted5")
    println("   $formatted6")
    println("   $formatted7")
    
    // Padding and alignment
    val padded1 = String.format("|%10s|", name)
    val padded2 = String.format("|%-10s|", name)
    val padded3 = String.format("|%010d|", age)
    
    println("   Padding and alignment:")
    println("   Right aligned: \"$padded1\"")
    println("   Left aligned: \"$padded2\"")
    println("   Zero padded: \"$padded3\"")
    
    // Date and time formatting (if available)
    val currentTime = System.currentTimeMillis()
    val formattedTime = String.format("Current time: %d", currentTime)
    println("   Time formatting: \"$formattedTime\"")
    
    println()
}

private fun demonstrateMultiLineStrings() {
    println("7. MULTI-LINE STRINGS:")
    
    // Basic multi-line string
    val multiLine1 = """
        This is a multi-line string
        It can span multiple lines
        and preserves formatting
    """.trimIndent()
    
    println("   Basic multi-line string:")
    println(multiLine1)
    
    // Multi-line string with trimMargin
    val multiLine2 = """
        |This is a multi-line string
        |with margin markers
        |using trimMargin()
    """.trimMargin()
    
    println("   Multi-line string with trimMargin:")
    println(multiLine2)
    
    // Multi-line string with custom margin
    val multiLine3 = """
        >This is a multi-line string
        >with custom margin marker
        >using trimMargin(">")
    """.trimMargin(">")
    
    println("   Multi-line string with custom margin:")
    println(multiLine3)
    
    // Multi-line string with interpolation
    val userName = "Alice"
    val userAge = 30
    val multiLine4 = """
        User Information:
        Name: $userName
        Age: $userAge
        Next year: ${userAge + 1}
    """.trimIndent()
    
    println("   Multi-line string with interpolation:")
    println(multiLine4)
    
    // Raw string (preserves all characters)
    val rawString = """
        This is a raw string
        It preserves    all    spaces
        And newlines
        
        Even empty lines
    """.trimIndent()
    
    println("   Raw string (preserves formatting):")
    println(rawString)
    
    println()
}

private fun demonstrateStringRegex() {
    println("8. STRING REGULAR EXPRESSIONS:")
    
    val text = "Contact us at support@example.com or call +1-555-123-4567"
    
    // Basic regex matching
    val emailRegex = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
    val phoneRegex = Regex("\\+?[0-9-]+")
    
    println("   Basic regex matching:")
    println("   Text: \"$text\"")
    println("   Contains email: ${emailRegex.containsMatchIn(text)}")
    println("   Contains phone: ${phoneRegex.containsMatchIn(text)}")
    
    // Finding matches
    val emailMatch = emailRegex.find(text)
    val phoneMatches = phoneRegex.findAll(text)
    
    println("   Finding matches:")
    println("   Email match: ${emailMatch?.value}")
    println("   Phone matches: ${phoneMatches.map { it.value }.toList()}")
    
    // Regex replacement
    val maskedEmail = emailRegex.replace(text) { match ->
        val email = match.value
        val (local, domain) = email.split("@")
        "${local.take(2)}***@$domain"
    }
    
    val maskedPhone = phoneRegex.replace(text) { match ->
        val phone = match.value
        if (phone.length > 4) {
            "${phone.take(2)}***${phone.takeLast(2)}"
        } else {
            "***"
        }
    }
    
    println("   Regex replacement:")
    println("   Masked email: \"$maskedEmail\"")
    println("   Masked phone: \"$maskedPhone\"")
    
    // Common regex patterns
    val patterns = mapOf(
        "Email" to Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"),
        "Phone" to Regex("\\+?[0-9-]+"),
        "URL" to Regex("https?://[^\\s]+"),
        "Date" to Regex("\\d{4}-\\d{2}-\\d{2}"),
        "Time" to Regex("\\d{2}:\\d{2}:\\d{2}")
    )
    
    val testText = "Visit https://example.com on 2024-01-15 at 14:30:00"
    println("   Common regex patterns:")
    println("   Test text: \"$testText\"")
    patterns.forEach { (name, regex) ->
        val matches = regex.findAll(testText).map { it.value }.toList()
        println("   $name matches: $matches")
    }
    
    println()
}

private fun demonstrateStringCollections() {
    println("9. STRING COLLECTIONS AND TRANSFORMATIONS:")
    
    val words = listOf("apple", "banana", "cherry", "date", "elderberry")
    
    // Basic transformations
    val upperWords = words.map { it.uppercase() }
    val wordLengths = words.map { it.length }
    val longWords = words.filter { it.length > 5 }
    
    println("   Basic transformations:")
    println("   Original words: $words")
    println("   Uppercase: $upperWords")
    println("   Word lengths: $wordLengths")
    println("   Long words (>5 chars): $longWords")
    
    // String joining
    val joined = words.joinToString(", ")
    val joinedWithPrefix = words.joinToString(", ", "Fruits: ", ".")
    val joinedWithTransform = words.joinToString(", ") { it.uppercase() }
    
    println("   String joining:")
    println("   Joined: \"$joined\"")
    println("   With prefix/suffix: \"$joinedWithPrefix\"")
    println("   With transform: \"$joinedWithTransform\"")
    
    // String grouping
    val groupedByLength = words.groupBy { it.length }
    val groupedByFirstChar = words.groupBy { it.first() }
    
    println("   String grouping:")
    println("   Grouped by length: $groupedByLength")
    println("   Grouped by first char: $groupedByFirstChar")
    
    // String sorting
    val sortedAlphabetically = words.sorted()
    val sortedByLength = words.sortedBy { it.length }
    val sortedByLengthDesc = words.sortedByDescending { it.length }
    
    println("   String sorting:")
    println("   Alphabetically: $sortedAlphabetically")
    println("   By length: $sortedByLength")
    println("   By length (desc): $sortedByLengthDesc")
    
    // String reduction
    val longestWord = words.maxByOrNull { it.length }
    val shortestWord = words.minByOrNull { it.length }
    val totalLength = words.sumOf { it.length }
    
    println("   String reduction:")
    println("   Longest word: $longestWord")
    println("   Shortest word: $shortestWord")
    println("   Total length: $totalLength")
    
    println()
}

private fun demonstrateCommonStringPatterns() {
    println("10. COMMON STRING PATTERNS:")
    
    // Pattern 1: Input validation
    fun isValidEmail(email: String): Boolean {
        return email.contains("@") && email.contains(".") && email.length > 5
    }
    
    fun isValidPhone(phone: String): Boolean {
        return phone.matches(Regex("\\+?[0-9-\\s()]+")) && phone.length >= 10
    }
    
    val emails = listOf("user@example.com", "invalid-email", "test@domain.org")
    val phones = listOf("+1-555-123-4567", "123-456-7890", "invalid-phone")
    
    println("   Pattern 1 - Input validation:")
    println("   Valid emails: ${emails.filter(::isValidEmail)}")
    println("   Valid phones: ${phones.filter(::isValidPhone)}")
    
    // Pattern 2: Text processing
    fun processText(text: String): String {
        return text.trim()
            .lowercase()
            .replace(Regex("[^a-zA-Z0-9\\s]"), "")
            .split("\\s+".toRegex())
            .joinToString(" ")
    }
    
    val rawText = "  Hello, World! This is a TEST.  "
    val processedText = processText(rawText)
    
    println("   Pattern 2 - Text processing:")
    println("   Raw text: \"$rawText\"")
    println("   Processed: \"$processedText\"")
    
    // Pattern 3: String templating
    fun createEmailTemplate(name: String, product: String, price: Double): String {
        return """
            Dear $name,
            
            Thank you for your interest in $product.
            The price is $${String.format("%.2f", price)}.
            
            Best regards,
            Sales Team
        """.trimIndent()
    }
    
    val emailTemplate = createEmailTemplate("John", "Premium Plan", 99.99)
    println("   Pattern 3 - String templating:")
    println(emailTemplate)
    
    // Pattern 4: String parsing
    fun parseUserInput(input: String): Map<String, String> {
        val parts = input.split(",")
        return mapOf(
            "name" to (parts.getOrNull(0)?.trim() ?: ""),
            "email" to (parts.getOrNull(1)?.trim() ?: ""),
            "phone" to (parts.getOrNull(2)?.trim() ?: "")
        )
    }
    
    val userInput = "John Doe, john@example.com, +1-555-123-4567"
    val parsedUser = parseUserInput(userInput)
    
    println("   Pattern 4 - String parsing:")
    println("   Input: \"$userInput\"")
    println("   Parsed: $parsedUser")
    
    // Pattern 5: String formatting for display
    fun formatCurrency(amount: Double): String {
        return String.format("$%.2f", amount)
    }
    
    fun formatPercentage(value: Double): String {
        return String.format("%.1f%%", value * 100)
    }
    
    fun formatDate(year: Int, month: Int, day: Int): String {
        return String.format("%04d-%02d-%02d", year, month, day)
    }
    
    println("   Pattern 5 - String formatting for display:")
    println("   Currency: ${formatCurrency(1234.56)}")
    println("   Percentage: ${formatPercentage(0.15)}")
    println("   Date: ${formatDate(2024, 1, 15)}")
    
    println()
}

/**
 * STRING DATA TYPE SUMMARY:
 *
 * STRING CREATION:
 * - String literals: "Hello, World!"
 * - String constructor: String(charArray)
 * - Empty strings: "" or String()
 * - Nullable strings: String?
 *
 * STRING PROPERTIES:
 * - length: Number of characters
 * - isEmpty(): True if length is 0
 * - isBlank(): True if empty or contains only whitespace
 * - isNotBlank(): Opposite of isBlank()
 *
 * STRING INTERPOLATION:
 * - Simple: $variable
 * - Expression: ${expression}
 * - Nested: ${"nested $variable"}
 * - Works with all data types
 *
 * STRING MANIPULATION:
 * - Case: uppercase(), lowercase(), replaceFirstChar()
 * - Trimming: trim(), trimStart(), trimEnd()
 * - Substrings: substring(), substringBefore(), substringAfter()
 * - Replacement: replace(), replaceFirst(), replaceLast()
 *
 * STRING COMPARISON:
 * - Equality: == (content) vs === (reference)
 * - Case-insensitive: equals(ignoreCase = true)
 * - Lexicographical: compareTo()
 * - Ordering: sorted(), sortedBy()
 *
 * STRING SEARCHING:
 * - Contains: contains(), contains(ignoreCase = true)
 * - Index: indexOf(), lastIndexOf()
 * - Prefix/Suffix: startsWith(), endsWith()
 * - Filtering: filter { condition }
 *
 * STRING FORMATTING:
 * - String.format(): %s, %d, %f, %x, %o
 * - Padding: %10s, %-10s, %010d
 * - Precision: %.2f, %.1f%%
 *
 * MULTI-LINE STRINGS:
 * - Triple quotes: """
 * - trimIndent(): Remove common leading whitespace
 * - trimMargin(): Remove margin markers
 * - Custom margin: trimMargin(">")
 *
 * REGULAR EXPRESSIONS:
 * - Regex class for pattern matching
 * - Common patterns: email, phone, URL, date, time
 * - Replacement: replace(), replaceFirst()
 * - Finding: find(), findAll()
 *
 * STRING COLLECTIONS:
 * - Transformations: map(), filter(), groupBy()
 * - Joining: joinToString()
 * - Sorting: sorted(), sortedBy()
 * - Reduction: maxBy(), minBy(), sumOf()
 *
 * BEST PRACTICES:
 * - Use string interpolation for readability
 * - Prefer immutable string operations
 * - Use safe string operations for nullable strings
 * - Validate input strings before processing
 * - Use appropriate string formatting for display
 * - Consider performance for large string operations
 * - Use StringBuilder for complex string building
 */
