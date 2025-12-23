package com.example.basic

/**
 * Kotlin Loops Tutorial
 *
 * This file demonstrates all loop types in Kotlin, including for, while,
 * do-while loops, and various iteration patterns commonly used in
 * Android development.
 */

fun main() {
    println("=== Kotlin Loops Tutorial ===\n")
    
    // 1. FOR LOOP
    demonstrateForLoop()
    
    // 2. WHILE LOOP
    demonstrateWhileLoop()
    
    // 3. DO-WHILE LOOP
    demonstrateDoWhileLoop()
    
    // 4. RANGES IN LOOPS
    demonstrateRangesInLoops()
    
    // 5. ITERATING COLLECTIONS
    demonstrateIteratingCollections()
    
    // 6. LOOP CONTROL STATEMENTS
    demonstrateLoopControl()
    
    // 7. NESTED LOOPS
    demonstrateNestedLoops()
    
    // 8. FUNCTIONAL ITERATION
    demonstrateFunctionalIteration()
    
    // 9. ADVANCED LOOP PATTERNS
    demonstrateAdvancedLoopPatterns()
    
    // 10. COMMON LOOP PATTERNS
    demonstrateCommonLoopPatterns()
}

private fun demonstrateForLoop() {
    println("1. FOR LOOP:")
    
    // Basic for loop with range
    println("   Basic for loop (1 to 5):")
    for (i in 1..5) {
        println("   i = $i")
    }
    
    // For loop with until
    println("   For loop with until (1 until 5):")
    for (i in 1 until 5) {
        println("   i = $i")
    }
    
    // Downward for loop
    println("   Downward for loop (5 down to 1):")
    for (i in 5 downTo 1) {
        println("   i = $i")
    }
    
    // For loop with step
    println("   For loop with step (1 to 10 step 2):")
    for (i in 1..10 step 2) {
        println("   i = $i")
    }
    
    // For loop with custom step
    println("   For loop with step 3 (0 to 20 step 3):")
    for (i in 0..20 step 3) {
        println("   i = $i")
    }
    
    // Character range
    println("   Character range ('a' to 'e'):")
    for (c in 'a'..'e') {
        println("   c = $c")
    }
    
    // Iterating over array
    println("   Iterating over array:")
    val numbers = arrayOf(10, 20, 30, 40, 50)
    for (num in numbers) {
        println("   num = $num")
    }
    
    // Iterating with index
    println("   Iterating with index:")
    for (i in numbers.indices) {
        println("   numbers[$i] = ${numbers[i]}")
    }
    
    // Iterating with withIndex()
    println("   Iterating with withIndex():")
    for ((index, value) in numbers.withIndex()) {
        println("   Index $index: $value")
    }
    
    println()
}

private fun demonstrateWhileLoop() {
    println("2. WHILE LOOP:")
    
    // Basic while loop
    println("   Basic while loop:")
    var i = 1
    while (i <= 5) {
        println("   i = $i")
        i++
    }
    
    // While with condition
    println("   While with condition:")
    var sum = 0
    var num = 1
    while (sum < 50) {
        sum += num
        println("   num = $num, sum = $sum")
        num++
    }
    
    // While with multiple conditions
    println("   While with multiple conditions:")
    var x = 1
    var y = 10
    while (x < 5 && y > 5) {
        println("   x = $x, y = $y")
        x++
        y--
    }
    
    // Infinite loop with break
    println("   Infinite loop with break:")
    var count = 0
    while (true) {
        count++
        println("   count = $count")
        if (count >= 3) {
            println("   Breaking out of loop")
            break
        }
    }
    
    // Reading until condition
    println("   While loop for accumulation:")
    val values = listOf(5, 10, 15, 20, -1, 25)
    var index = 0
    var total = 0
    while (index < values.size && values[index] >= 0) {
        total += values[index]
        println("   Adding ${values[index]}, total = $total")
        index++
    }
    
    println()
}

private fun demonstrateDoWhileLoop() {
    println("3. DO-WHILE LOOP:")
    
    // Basic do-while loop
    println("   Basic do-while loop:")
    var i = 1
    do {
        println("   i = $i")
        i++
    } while (i <= 5)
    
    // Do-while executes at least once
    println("   Do-while executes at least once:")
    var j = 10
    do {
        println("   j = $j (executes even though j > 5)")
        j++
    } while (j <= 5)
    
    // Do-while with user input simulation
    println("   Do-while for input validation:")
    var attempt = 0
    var validInput = false
    do {
        attempt++
        println("   Attempt $attempt")
        // Simulate validation
        validInput = attempt >= 3
        if (!validInput) {
            println("   Invalid input, try again")
        }
    } while (!validInput)
    println("   Valid input received")
    
    // Do-while for menu
    println("   Do-while for menu simulation:")
    var choice = 0
    var menuCount = 0
    do {
        menuCount++
        println("   Menu iteration $menuCount")
        choice = menuCount  // Simulate user choice
        when (choice) {
            1 -> println("   Option 1 selected")
            2 -> println("   Option 2 selected")
            3 -> println("   Option 3 selected")
            else -> println("   Invalid choice")
        }
    } while (choice != 3)
    println("   Exiting menu")
    
    println()
}

private fun demonstrateRangesInLoops() {
    println("4. RANGES IN LOOPS:")
    
    // Inclusive range
    println("   Inclusive range (1..5):")
    for (i in 1..5) {
        print("$i ")
    }
    println()
    
    // Exclusive range
    println("   Exclusive range (1 until 5):")
    for (i in 1 until 5) {
        print("$i ")
    }
    println()
    
    // Reverse range
    println("   Reverse range (5 downTo 1):")
    for (i in 5 downTo 1) {
        print("$i ")
    }
    println()
    
    // Range with different steps
    println("   Range with step 2:")
    for (i in 0..10 step 2) {
        print("$i ")
    }
    println()
    
    println("   Range with step 3:")
    for (i in 0..20 step 3) {
        print("$i ")
    }
    println()
    
    // Reverse range with step
    println("   Reverse range with step:")
    for (i in 20 downTo 0 step 4) {
        print("$i ")
    }
    println()
    
    // Checking if value in range
    println("   Checking if value in range:")
    val range = 1..10
    println("   5 in range: ${5 in range}")
    println("   15 in range: ${15 in range}")
    
    // Range properties
    println("   Range properties:")
    println("   First: ${range.first}")
    println("   Last: ${range.last}")
    println("   Step: ${range.step}")
    
    println()
}

private fun demonstrateIteratingCollections() {
    println("5. ITERATING COLLECTIONS:")
    
    // Iterating list
    println("   Iterating list:")
    val fruits = listOf("apple", "banana", "cherry")
    for (fruit in fruits) {
        println("   Fruit: $fruit")
    }
    
    // Iterating with index
    println("   Iterating list with index:")
    for ((index, fruit) in fruits.withIndex()) {
        println("   ${index + 1}. $fruit")
    }
    
    // Iterating set
    println("   Iterating set:")
    val numbers = setOf(1, 2, 3, 4, 5)
    for (num in numbers) {
        println("   Number: $num")
    }
    
    // Iterating map
    println("   Iterating map:")
    val ages = mapOf("Alice" to 25, "Bob" to 30, "Charlie" to 35)
    for ((name, age) in ages) {
        println("   $name is $age years old")
    }
    
    // Iterating map keys
    println("   Iterating map keys:")
    for (name in ages.keys) {
        println("   Name: $name")
    }
    
    // Iterating map values
    println("   Iterating map values:")
    for (age in ages.values) {
        println("   Age: $age")
    }
    
    // Iterating map entries
    println("   Iterating map entries:")
    for (entry in ages.entries) {
        println("   ${entry.key} -> ${entry.value}")
    }
    
    // Iterating string
    println("   Iterating string:")
    val text = "Hello"
    for (char in text) {
        println("   Char: $char")
    }
    
    println()
}

private fun demonstrateLoopControl() {
    println("6. LOOP CONTROL STATEMENTS:")
    
    // Break statement
    println("   Break statement:")
    for (i in 1..10) {
        if (i == 6) {
            println("   Breaking at i = $i")
            break
        }
        println("   i = $i")
    }
    
    // Continue statement
    println("   Continue statement:")
    for (i in 1..10) {
        if (i % 2 == 0) {
            continue
        }
        println("   Odd number: $i")
    }
    
    // Break with label
    println("   Break with label:")
    outer@ for (i in 1..3) {
        for (j in 1..3) {
            if (i == 2 && j == 2) {
                println("   Breaking outer loop at i=$i, j=$j")
                break@outer
            }
            println("   i=$i, j=$j")
        }
    }
    
    // Continue with label
    println("   Continue with label:")
    outer@ for (i in 1..3) {
        for (j in 1..3) {
            if (j == 2) {
                continue@outer
            }
            println("   i=$i, j=$j")
        }
    }
    
    // Return from loop
    fun findValue(): Int {
        for (i in 1..10) {
            if (i * i > 50) {
                return i
            }
        }
        return -1
    }
    
    println("   Return from loop:")
    println("   First value where i*i > 50: ${findValue()}")
    
    println()
}

private fun demonstrateNestedLoops() {
    println("7. NESTED LOOPS:")
    
    // Basic nested loops
    println("   Basic nested loops (multiplication table):")
    for (i in 1..3) {
        for (j in 1..3) {
            print("${i * j}\t")
        }
        println()
    }
    
    // Nested loops with different ranges
    println("   Nested loops with different ranges:")
    for (i in 1..3) {
        for (j in 1..i) {
            print("* ")
        }
        println()
    }
    
    // Triple nested loop
    println("   Triple nested loop:")
    for (i in 1..2) {
        for (j in 1..2) {
            for (k in 1..2) {
                println("   i=$i, j=$j, k=$k")
            }
        }
    }
    
    // Nested loop with break
    println("   Nested loop with break:")
    for (i in 1..3) {
        for (j in 1..3) {
            if (j == 2) break
            println("   i=$i, j=$j")
        }
    }
    
    // Nested loop with labeled break
    println("   Nested loop with labeled break:")
    outer@ for (i in 1..3) {
        inner@ for (j in 1..3) {
            if (i * j >= 4) break@outer
            println("   i=$i, j=$j, product=${i * j}")
        }
    }
    
    // Nested iteration of collections
    println("   Nested iteration of collections:")
    val groups = listOf(
        listOf("Alice", "Bob"),
        listOf("Charlie", "David"),
        listOf("Eve")
    )
    
    for ((groupIndex, group) in groups.withIndex()) {
        println("   Group ${groupIndex + 1}:")
        for ((memberIndex, member) in group.withIndex()) {
            println("     ${memberIndex + 1}. $member")
        }
    }
    
    println()
}

private fun demonstrateFunctionalIteration() {
    println("8. FUNCTIONAL ITERATION:")
    
    val numbers = listOf(1, 2, 3, 4, 5)
    
    // forEach
    println("   forEach:")
    numbers.forEach { num ->
        println("   Number: $num")
    }
    
    // forEachIndexed
    println("   forEachIndexed:")
    numbers.forEachIndexed { index, num ->
        println("   Index $index: $num")
    }
    
    // map
    println("   map:")
    val squared = numbers.map { it * it }
    println("   Squared: $squared")
    
    // filter
    println("   filter:")
    val evenNumbers = numbers.filter { it % 2 == 0 }
    println("   Even numbers: $evenNumbers")
    
    // fold
    println("   fold:")
    val sum = numbers.fold(0) { acc, num -> acc + num }
    println("   Sum: $sum")
    
    // reduce
    println("   reduce:")
    val product = numbers.reduce { acc, num -> acc * num }
    println("   Product: $product")
    
    // takeWhile
    println("   takeWhile:")
    val taken = numbers.takeWhile { it < 4 }
    println("   Take while < 4: $taken")
    
    // dropWhile
    println("   dropWhile:")
    val dropped = numbers.dropWhile { it < 3 }
    println("   Drop while < 3: $dropped")
    
    // any
    println("   any:")
    val hasEven = numbers.any { it % 2 == 0 }
    println("   Has even number: $hasEven")
    
    // all
    println("   all:")
    val allPositive = numbers.all { it > 0 }
    println("   All positive: $allPositive")
    
    // none
    println("   none:")
    val noneNegative = numbers.none { it < 0 }
    println("   None negative: $noneNegative")
    
    println()
}

private fun demonstrateAdvancedLoopPatterns() {
    println("9. ADVANCED LOOP PATTERNS:")
    
    // Sequence iteration (lazy evaluation)
    println("   Sequence iteration (lazy):")
    val sequence = generateSequence(1) { it + 1 }
        .take(5)
        .map { it * it }
    sequence.forEach { println("   $it") }
    
    // Infinite sequence with takeWhile
    println("   Infinite sequence with takeWhile:")
    val limited = generateSequence(1) { it + 1 }
        .takeWhile { it <= 5 }
        .toList()
    println("   Limited: $limited")
    
    // Windowed iteration
    println("   Windowed iteration:")
    val numbers = listOf(1, 2, 3, 4, 5)
    val windows = numbers.windowed(3)
    windows.forEach { window ->
        println("   Window: $window")
    }
    
    // Windowed with step
    println("   Windowed with step:")
    val steppedWindows = numbers.windowed(2, step = 2)
    steppedWindows.forEach { window ->
        println("   Window: $window")
    }
    
    // Chunked iteration
    println("   Chunked iteration:")
    val chunks = numbers.chunked(2)
    chunks.forEach { chunk ->
        println("   Chunk: $chunk")
    }
    
    // Zipped iteration
    println("   Zipped iteration:")
    val names = listOf("Alice", "Bob", "Charlie")
    val ages = listOf(25, 30, 35)
    names.zip(ages).forEach { (name, age) ->
        println("   $name is $age years old")
    }
    
    // Partition
    println("   Partition:")
    val (even, odd) = numbers.partition { it % 2 == 0 }
    println("   Even: $even")
    println("   Odd: $odd")
    
    // GroupBy
    println("   GroupBy:")
    val words = listOf("apple", "apricot", "banana", "blueberry", "cherry")
    val grouped = words.groupBy { it.first() }
    grouped.forEach { (letter, words) ->
        println("   $letter: $words")
    }
    
    println()
}

private fun demonstrateCommonLoopPatterns() {
    println("10. COMMON LOOP PATTERNS:")
    
    // Pattern 1: Sum of elements
    fun sumElements(numbers: List<Int>): Int {
        var sum = 0
        for (num in numbers) {
            sum += num
        }
        return sum
    }
    
    val numbers = listOf(1, 2, 3, 4, 5)
    println("   Pattern 1 - Sum of elements:")
    println("   Sum: ${sumElements(numbers)}")
    
    // Pattern 2: Find maximum
    fun findMax(numbers: List<Int>): Int? {
        if (numbers.isEmpty()) return null
        var max = numbers[0]
        for (num in numbers) {
            if (num > max) {
                max = num
            }
        }
        return max
    }
    
    println("   Pattern 2 - Find maximum:")
    println("   Max: ${findMax(numbers)}")
    
    // Pattern 3: Count occurrences
    fun countOccurrences(items: List<String>, target: String): Int {
        var count = 0
        for (item in items) {
            if (item == target) {
                count++
            }
        }
        return count
    }
    
    val fruits = listOf("apple", "banana", "apple", "cherry", "apple")
    println("   Pattern 3 - Count occurrences:")
    println("   'apple' count: ${countOccurrences(fruits, "apple")}")
    
    // Pattern 4: Reverse a list
    fun reverseList(list: List<Int>): List<Int> {
        val reversed = mutableListOf<Int>()
        for (i in list.size - 1 downTo 0) {
            reversed.add(list[i])
        }
        return reversed
    }
    
    println("   Pattern 4 - Reverse list:")
    println("   Original: $numbers")
    println("   Reversed: ${reverseList(numbers)}")
    
    // Pattern 5: Build frequency map
    fun buildFrequencyMap(items: List<String>): Map<String, Int> {
        val frequency = mutableMapOf<String, Int>()
        for (item in items) {
            frequency[item] = frequency.getOrDefault(item, 0) + 1
        }
        return frequency
    }
    
    println("   Pattern 5 - Frequency map:")
    val freqMap = buildFrequencyMap(fruits)
    for ((fruit, count) in freqMap) {
        println("   $fruit: $count")
    }
    
    // Pattern 6: Matrix operations
    fun printMatrix(matrix: Array<IntArray>) {
        for (row in matrix) {
            for (value in row) {
                print("$value ")
            }
            println()
        }
    }
    
    println("   Pattern 6 - Matrix iteration:")
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )
    printMatrix(matrix)
    
    // Pattern 7: Search with early exit
    fun findFirst(numbers: List<Int>, target: Int): Int {
        for ((index, num) in numbers.withIndex()) {
            if (num == target) {
                return index
            }
        }
        return -1
    }
    
    println("   Pattern 7 - Search with early exit:")
    println("   Index of 3: ${findFirst(numbers, 3)}")
    println("   Index of 10: ${findFirst(numbers, 10)}")
    
    // Pattern 8: Accumulate with condition
    fun sumEvenNumbers(numbers: List<Int>): Int {
        var sum = 0
        for (num in numbers) {
            if (num % 2 == 0) {
                sum += num
            }
        }
        return sum
    }
    
    println("   Pattern 8 - Accumulate with condition:")
    println("   Sum of even: ${sumEvenNumbers(numbers)}")
    
    // Pattern 9: Nested structure processing
    fun processNestedList(nested: List<List<Int>>): Int {
        var total = 0
        for (sublist in nested) {
            for (num in sublist) {
                total += num
            }
        }
        return total
    }
    
    val nested = listOf(listOf(1, 2), listOf(3, 4), listOf(5, 6))
    println("   Pattern 9 - Process nested list:")
    println("   Total: ${processNestedList(nested)}")
    
    // Pattern 10: Loop with state
    fun findPairs(numbers: List<Int>, target: Int): List<Pair<Int, Int>> {
        val pairs = mutableListOf<Pair<Int, Int>>()
        for (i in numbers.indices) {
            for (j in i + 1 until numbers.size) {
                if (numbers[i] + numbers[j] == target) {
                    pairs.add(Pair(numbers[i], numbers[j]))
                }
            }
        }
        return pairs
    }
    
    val testNumbers = listOf(1, 2, 3, 4, 5, 6)
    println("   Pattern 10 - Find pairs that sum to 7:")
    val pairs = findPairs(testNumbers, 7)
    pairs.forEach { (a, b) ->
        println("   $a + $b = 7")
    }
    
    println()
}

/**
 * LOOPS SUMMARY:
 *
 * FOR LOOP:
 * - for (i in range) { }
 * - for (item in collection) { }
 * - for ((index, value) in collection.withIndex()) { }
 * - for (i in array.indices) { }
 * - Ranges: 1..10, 1 until 10, 10 downTo 1
 * - Step: 1..10 step 2
 *
 * WHILE LOOP:
 * - while (condition) { }
 * - Checks condition before execution
 * - Can execute zero times
 * - Use for unknown iteration count
 *
 * DO-WHILE LOOP:
 * - do { } while (condition)
 * - Executes at least once
 * - Checks condition after execution
 * - Good for input validation
 *
 * RANGES:
 * - .. : Inclusive range (1..10)
 * - until : Exclusive range (1 until 10)
 * - downTo : Descending range (10 downTo 1)
 * - step : Custom step (1..10 step 2)
 * - in : Check membership
 *
 * COLLECTION ITERATION:
 * - Lists: for (item in list)
 * - Sets: for (item in set)
 * - Maps: for ((key, value) in map)
 * - Arrays: for (item in array)
 * - Strings: for (char in string)
 *
 * LOOP CONTROL:
 * - break: Exit loop
 * - continue: Skip to next iteration
 * - break@label: Break labeled loop
 * - continue@label: Continue labeled loop
 * - return: Exit function
 *
 * NESTED LOOPS:
 * - Loop inside loop
 * - Use labels for control
 * - Watch performance
 * - Consider alternatives (flatMap)
 *
 * FUNCTIONAL ITERATION:
 * - forEach: Execute for each element
 * - forEachIndexed: With index
 * - map: Transform elements
 * - filter: Select elements
 * - fold/reduce: Accumulate
 * - takeWhile/dropWhile: Conditional
 * - any/all/none: Predicates
 *
 * ADVANCED:
 * - Sequences: Lazy evaluation
 * - windowed: Sliding window
 * - chunked: Split into chunks
 * - zip: Combine collections
 * - partition: Split by condition
 * - groupBy: Group elements
 *
 * COMMON PATTERNS:
 * - Sum/count elements
 * - Find min/max
 * - Search with early exit
 * - Frequency counting
 * - Matrix operations
 * - Nested structure processing
 * - Accumulation with condition
 *
 * BEST PRACTICES:
 * - Prefer functional iteration when possible
 * - Use appropriate loop for task
 * - Avoid modifying collection while iterating
 * - Use labels for complex nested loops
 * - Consider sequences for large data
 * - Early exit when found
 * - Use ranges for numeric iteration
 * - Prefer immutable operations
 * - Break complex loops into functions
 * - Watch for infinite loops
 */
