package com.example.basic

/**
 * Kotlin ArrayList Tutorial
 *
 * This file demonstrates ArrayList (and List) in Kotlin, including creation,
 * manipulation, operations, and various list operations commonly used in Android development.
 * 
 * ArrayList is a resizable array implementation of the List interface.
 * It provides dynamic array functionality with fast random access.
 */

fun main() {
    println("=== Kotlin ArrayList Tutorial ===\n")
    
    // 1. ARRAYLIST CREATION
    demonstrateArrayListCreation()
    
    // 2. ADDING ELEMENTS
    demonstrateAddingElements()
    
    // 3. ACCESSING ELEMENTS
    demonstrateAccessingElements()
    
    // 4. MODIFYING ELEMENTS
    demonstrateModifyingElements()
    
    // 5. REMOVING ELEMENTS
    demonstrateRemovingElements()
    
    // 6. SEARCHING AND FILTERING
    demonstrateSearchingAndFiltering()
    
    // 7. SORTING AND ORDERING
    demonstrateSortingAndOrdering()
    
    // 8. LIST TRANSFORMATIONS
    demonstrateListTransformations()
    
    // 9. LIST OPERATIONS
    demonstrateListOperations()
    
    // 10. COMMON ARRAYLIST PATTERNS
    demonstrateCommonArrayListPatterns()
}

private fun demonstrateArrayListCreation() {
    println("1. ARRAYLIST CREATION:")
    
    // Creating empty ArrayList
    val emptyList = ArrayList<String>()
    val emptyList2 = arrayListOf<Int>()
    val emptyMutableList = mutableListOf<String>()
    
    println("   Empty ArrayList:")
    println("   Empty list: $emptyList")
    println("   Empty list 2: $emptyList2")
    println("   Empty mutable list: $emptyMutableList")
    
    // Creating ArrayList with initial elements
    val fruits = arrayListOf("apple", "banana", "cherry")
    val numbers = arrayListOf(1, 2, 3, 4, 5)
    val mixedList = arrayListOf<Any>("hello", 42, true, 3.14)
    
    println("   ArrayList with initial elements:")
    println("   Fruits: $fruits")
    println("   Numbers: $numbers")
    println("   Mixed list: $mixedList")
    
    // Creating ArrayList with specific size
    val sizedList = ArrayList<String>(10)
    println("   Sized ArrayList (capacity 10): $sizedList")
    
    // Creating from collection
    val fromArray = arrayListOf(*arrayOf(1, 2, 3, 4, 5))
    val fromList = ArrayList(listOf("a", "b", "c"))
    
    println("   From collection:")
    println("   From array: $fromArray")
    println("   From list: $fromList")
    
    // Immutable vs Mutable lists
    val immutableList = listOf("red", "green", "blue")
    val mutableList = mutableListOf("red", "green", "blue")
    
    println("   Immutable vs Mutable:")
    println("   Immutable list: $immutableList")
    println("   Mutable list: $mutableList")
    
    println()
}

private fun demonstrateAddingElements() {
    println("2. ADDING ELEMENTS:")
    
    val list = arrayListOf("apple", "banana")
    
    // Adding single element
    println("   Adding single element:")
    println("   Original list: $list")
    list.add("cherry")
    println("   After add('cherry'): $list")
    
    // Adding at specific index
    list.add(1, "blueberry")
    println("   After add(1, 'blueberry'): $list")
    
    // Adding multiple elements
    list.addAll(listOf("date", "elderberry"))
    println("   After addAll: $list")
    
    // Adding at specific index
    list.addAll(2, listOf("fig", "grape"))
    println("   After addAll at index 2: $list")
    
    // Using += operator
    val list2 = arrayListOf(1, 2, 3)
    list2 += 4
    list2 += listOf(5, 6, 7)
    println("   Using += operator: $list2")
    
    // Plus operator (creates new list)
    val list3 = arrayListOf("a", "b")
    val newList = list3 + "c"
    val newList2 = list3 + listOf("d", "e")
    println("   Plus operator:")
    println("   Original: $list3")
    println("   With 'c': $newList")
    println("   With list: $newList2")
    
    println()
}

private fun demonstrateAccessingElements() {
    println("3. ACCESSING ELEMENTS:")
    
    val fruits = arrayListOf("apple", "banana", "cherry", "date", "elderberry")
    
    // Accessing by index
    println("   Accessing by index:")
    println("   List: $fruits")
    println("   First element: ${fruits[0]}")
    println("   Last element: ${fruits[fruits.size - 1]}")
    println("   Element at index 2: ${fruits[2]}")
    
    // Using get method
    println("   Using get method:")
    println("   Get(1): ${fruits.get(1)}")
    println("   Get(3): ${fruits.get(3)}")
    
    // Safe access methods
    println("   Safe access methods:")
    println("   First: ${fruits.first()}")
    println("   Last: ${fruits.last()}")
    println("   FirstOrNull: ${fruits.firstOrNull()}")
    println("   LastOrNull: ${fruits.lastOrNull()}")
    println("   GetOrNull(10): ${fruits.getOrNull(10)}")
    println("   GetOrElse(10): ${fruits.getOrElse(10) { "default" }}")
    
    // Getting sub-list
    val subList = fruits.subList(1, 4)
    println("   Sub-list (1 to 4): $subList")
    
    // Checking if element exists
    println("   Checking existence:")
    println("   Contains 'banana': ${fruits.contains("banana")}")
    println("   'cherry' in fruits: ${"cherry" in fruits}")
    println("   Contains 'mango': ${fruits.contains("mango")}")
    
    // Getting index
    println("   Getting index:")
    println("   Index of 'cherry': ${fruits.indexOf("cherry")}")
    println("   Last index of 'banana': ${fruits.lastIndexOf("banana")}")
    println("   Index of 'mango': ${fruits.indexOf("mango")}")
    
    println()
}

private fun demonstrateModifyingElements() {
    println("4. MODIFYING ELEMENTS:")
    
    val numbers = arrayListOf(10, 20, 30, 40, 50)
    
    // Modifying by index
    println("   Modifying by index:")
    println("   Original: $numbers")
    numbers[0] = 100
    numbers[numbers.size - 1] = 500
    println("   After modification: $numbers")
    
    // Using set method
    numbers.set(2, 300)
    println("   After set(2, 300): $numbers")
    
    // Replacing elements
    val fruits = arrayListOf("apple", "banana", "cherry", "banana")
    println("   Replacing elements:")
    println("   Original: $fruits")
    
    val index = fruits.indexOf("banana")
    if (index != -1) {
        fruits[index] = "blueberry"
    }
    println("   After replacing first 'banana': $fruits")
    
    // Replace all occurrences
    val replaceAll = arrayListOf("apple", "banana", "cherry", "banana", "date")
    println("   Replace all:")
    println("   Original: $replaceAll")
    replaceAll.replaceAll { if (it == "banana") "blueberry" else it }
    println("   After replaceAll: $replaceAll")
    
    println()
}

private fun demonstrateRemovingElements() {
    println("5. REMOVING ELEMENTS:")
    
    val fruits = arrayListOf("apple", "banana", "cherry", "date", "elderberry")
    
    // Removing by element
    println("   Removing by element:")
    println("   Original: $fruits")
    fruits.remove("cherry")
    println("   After remove('cherry'): $fruits")
    
    // Removing by index
    fruits.removeAt(0)
    println("   After removeAt(0): $fruits")
    
    // Removing multiple elements
    val list2 = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8)
    println("   Removing multiple elements:")
    println("   Original: $list2")
    list2.removeAll(listOf(2, 4, 6))
    println("   After removeAll([2, 4, 6]): $list2")
    
    // Removing with condition
    val list3 = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("   Removing with condition:")
    println("   Original: $list3")
    list3.removeIf { it % 2 == 0 }
    println("   After removeIf (even numbers): $list3")
    
    // Removing first and last
    val list4 = arrayListOf("a", "b", "c", "d", "e")
    println("   Removing first and last:")
    println("   Original: $list4")
    list4.removeAt(0)
    println("   After removeFirst(): $list4")
    list4.removeAt(list4.size - 1)
    println("   After removeLast(): $list4")
    
    // Retaining elements
    val list5 = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8)
    println("   Retaining elements:")
    println("   Original: $list5")
    list5.retainAll(listOf(2, 4, 6, 8))
    println("   After retainAll([2, 4, 6, 8]): $list5")
    
    // Clearing all elements
    val list6 = arrayListOf("a", "b", "c")
    println("   Clearing all elements:")
    println("   Original: $list6")
    list6.clear()
    println("   After clear(): $list6")
    
    println()
}

private fun demonstrateSearchingAndFiltering() {
    println("6. SEARCHING AND FILTERING:")
    
    val numbers = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    
    // Filtering
    val evenNumbers = numbers.filter { it % 2 == 0 }
    val oddNumbers = numbers.filter { it % 2 != 0 }
    val largeNumbers = numbers.filter { it > 5 }
    
    println("   Filtering:")
    println("   Original: $numbers")
    println("   Even numbers: $evenNumbers")
    println("   Odd numbers: $oddNumbers")
    println("   Large numbers (>5): $largeNumbers")
    
    // Finding elements
    val firstEven = numbers.find { it % 2 == 0 }
    val lastEven = numbers.findLast { it % 2 == 0 }
    val firstLarge = numbers.firstOrNull { it > 5 }
    val lastLarge = numbers.lastOrNull { it > 5 }
    
    println("   Finding elements:")
    println("   First even: $firstEven")
    println("   Last even: $lastEven")
    println("   First large (>5): $firstLarge")
    println("   Last large (>5): $lastLarge")
    
    // Checking conditions
    val hasEven = numbers.any { it % 2 == 0 }
    val allPositive = numbers.all { it > 0 }
    val noneNegative = numbers.none { it < 0 }
    
    println("   Checking conditions:")
    println("   Has even: $hasEven")
    println("   All positive: $allPositive")
    println("   None negative: $noneNegative")
    
    // Counting
    val evenCount = numbers.count { it % 2 == 0 }
    val largeCount = numbers.count { it > 5 }
    
    println("   Counting:")
    println("   Even count: $evenCount")
    println("   Large count: $largeCount")
    
    // Partitioning
    val (even, odd) = numbers.partition { it % 2 == 0 }
    println("   Partitioning:")
    println("   Even partition: $even")
    println("   Odd partition: $odd")
    
    println()
}

private fun demonstrateSortingAndOrdering() {
    println("7. SORTING AND ORDERING:")
    
    val numbers = arrayListOf(5, 2, 8, 1, 9, 3, 7, 4, 6)
    
    // Basic sorting
    val sorted = numbers.sorted()
    val sortedDesc = numbers.sortedDescending()
    
    println("   Basic sorting:")
    println("   Original: $numbers")
    println("   Sorted: $sorted")
    println("   Sorted descending: $sortedDesc")
    
    // In-place sorting
    val mutableList = arrayListOf(5, 2, 8, 1, 9, 3)
    println("   In-place sorting:")
    println("   Original: $mutableList")
    mutableList.sort()
    println("   After sort(): $mutableList")
    mutableList.sortDescending()
    println("   After sortDescending(): $mutableList")
    
    // Sorting strings
    val fruits = arrayListOf("banana", "apple", "cherry", "date")
    val sortedFruits = fruits.sorted()
    val sortedByLength = fruits.sortedBy { it.length }
    val sortedByLengthDesc = fruits.sortedByDescending { it.length }
    
    println("   Sorting strings:")
    println("   Original: $fruits")
    println("   Sorted: $sortedFruits")
    println("   Sorted by length: $sortedByLength")
    println("   Sorted by length desc: $sortedByLengthDesc")
    
    // Reversing
    val reversed = numbers.reversed()
    println("   Reversing:")
    println("   Reversed: $reversed")
    
    // Shuffling
    val shuffled = numbers.shuffled()
    println("   Shuffling:")
    println("   Shuffled: $shuffled")
    
    println()
}

private fun demonstrateListTransformations() {
    println("8. LIST TRANSFORMATIONS:")
    
    val numbers = arrayListOf(1, 2, 3, 4, 5)
    
    // Map transformation
    val squared = numbers.map { it * it }
    val strings = numbers.map { "Number $it" }
    
    println("   Map transformation:")
    println("   Original: $numbers")
    println("   Squared: $squared")
    println("   Strings: $strings")
    
    // MapIndexed transformation
    val indexed = numbers.mapIndexed { index, value -> "Index $index: Value $value" }
    println("   MapIndexed: $indexed")
    
    // FlatMap transformation
    val nestedList = arrayListOf(listOf(1, 2), listOf(3, 4), listOf(5, 6))
    val flattened = nestedList.flatMap { it }
    println("   FlatMap:")
    println("   Nested: $nestedList")
    println("   Flattened: $flattened")
    
    // Distinct transformation
    val duplicates = arrayListOf(1, 2, 2, 3, 3, 3, 4, 4, 4, 4)
    val distinct = duplicates.distinct()
    val distinctBy = arrayListOf("apple", "apricot", "banana", "blueberry")
        .distinctBy { it.first() }
    
    println("   Distinct:")
    println("   With duplicates: $duplicates")
    println("   Distinct: $distinct")
    println("   Distinct by first char: $distinctBy")
    
    // Grouping
    val grouped = numbers.groupBy { it % 2 }
    val groupedBy = arrayListOf("apple", "banana", "apricot", "blueberry", "cherry")
        .groupBy { it.first() }
    
    println("   Grouping:")
    println("   Grouped by even/odd: $grouped")
    println("   Grouped by first char: $groupedBy")
    
    println()
}

private fun demonstrateListOperations() {
    println("9. LIST OPERATIONS:")
    
    val list1 = arrayListOf(1, 2, 3)
    val list2 = arrayListOf(3, 4, 5)
    
    // Union
    val union = (list1 + list2).distinct()
    println("   Union:")
    println("   List 1: $list1")
    println("   List 2: $list2")
    println("   Union: $union")
    
    // Intersection
    val intersection = list1.intersect(list2.toSet())
    println("   Intersection: $intersection")
    
    // Difference
    val difference = list1.subtract(list2.toSet())
    println("   Difference (list1 - list2): $difference")
    
    // Zip operation
    val names = arrayListOf("Alice", "Bob", "Charlie")
    val ages = arrayListOf(25, 30, 35)
    val zipped = names.zip(ages)
    val zippedWithTransform = names.zip(ages) { name, age -> "$name is $age years old" }
    
    println("   Zip operation:")
    println("   Names: $names")
    println("   Ages: $ages")
    println("   Zipped: $zipped")
    println("   Zipped with transform: $zippedWithTransform")
    
    // Chunking
    val numbers = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val chunked = numbers.chunked(3)
    val chunkedWithTransform = numbers.chunked(3) { it.sum() }
    
    println("   Chunking:")
    println("   Original: $numbers")
    println("   Chunked by 3: $chunked")
    println("   Chunked with sum: $chunkedWithTransform")
    
    // Windowed
    val windowed = numbers.windowed(3)
    val windowedWithStep = numbers.windowed(3, step = 2)
    
    println("   Windowed:")
    println("   Windowed by 3: $windowed")
    println("   Windowed with step 2: $windowedWithStep")
    
    // Take and Drop
    val taken = numbers.take(5)
    val dropped = numbers.drop(5)
    val takeLast = numbers.takeLast(3)
    val dropLast = numbers.dropLast(3)
    
    println("   Take and Drop:")
    println("   Take 5: $taken")
    println("   Drop 5: $dropped")
    println("   Take last 3: $takeLast")
    println("   Drop last 3: $dropLast")
    
    println()
}

private fun demonstrateCommonArrayListPatterns() {
    println("10. COMMON ARRAYLIST PATTERNS:")
    
    // Pattern 1: Building a list
    fun buildNumberList(n: Int): ArrayList<Int> {
        val list = arrayListOf<Int>()
        for (i in 1..n) {
            list.add(i)
        }
        return list
    }
    
    val builtList = buildNumberList(10)
    println("   Pattern 1 - Building a list:")
    println("   Built list: $builtList")
    
    // Pattern 2: Filtering and transforming
    fun processScores(scores: ArrayList<Int>): List<String> {
        return scores
            .filter { it >= 60 }
            .map { score ->
                when {
                    score >= 90 -> "A"
                    score >= 80 -> "B"
                    score >= 70 -> "C"
                    score >= 60 -> "D"
                    else -> "F"
                }
            }
    }
    
    val scores = arrayListOf(55, 65, 75, 85, 95, 45, 88, 92)
    val grades = processScores(scores)
    println("   Pattern 2 - Process scores:")
    println("   Scores: $scores")
    println("   Grades: $grades")
    
    // Pattern 3: Finding duplicates
    fun findDuplicates(list: ArrayList<Int>): List<Int> {
        return list.groupingBy { it }
            .eachCount()
            .filter { it.value > 1 }
            .keys
            .toList()
    }
    
    val numbersWithDuplicates = arrayListOf(1, 2, 3, 2, 4, 5, 3, 6, 1)
    val duplicates = findDuplicates(numbersWithDuplicates)
    println("   Pattern 3 - Find duplicates:")
    println("   Numbers: $numbersWithDuplicates")
    println("   Duplicates: $duplicates")
    
    // Pattern 4: Removing duplicates while preserving order
    fun removeDuplicates(list: ArrayList<String>): ArrayList<String> {
        val seen = mutableSetOf<String>()
        val result = arrayListOf<String>()
        for (item in list) {
            if (seen.add(item)) {
                result.add(item)
            }
        }
        return result
    }
    
    val withDuplicates = arrayListOf("apple", "banana", "apple", "cherry", "banana")
    val withoutDuplicates = removeDuplicates(withDuplicates)
    println("   Pattern 4 - Remove duplicates:")
    println("   Original: $withDuplicates")
    println("   Without duplicates: $withoutDuplicates")
    
    // Pattern 5: List statistics
    fun getListStats(list: ArrayList<Int>): Map<String, Double> {
        return mapOf(
            "sum" to list.sum().toDouble(),
            "average" to list.average(),
            "min" to (list.minOrNull()?.toDouble() ?: 0.0),
            "max" to (list.maxOrNull()?.toDouble() ?: 0.0),
            "count" to list.size.toDouble()
        )
    }
    
    val statsList = arrayListOf(10, 20, 30, 40, 50)
    val stats = getListStats(statsList)
    println("   Pattern 5 - List statistics:")
    println("   List: $statsList")
    println("   Stats: $stats")
    
    // Pattern 6: Batch processing
    fun processBatches(items: ArrayList<String>, batchSize: Int) {
        items.chunked(batchSize).forEachIndexed { index, batch ->
            println("   Processing batch ${index + 1}: $batch")
        }
    }
    
    val items = arrayListOf("item1", "item2", "item3", "item4", "item5", "item6", "item7")
    println("   Pattern 6 - Batch processing:")
    processBatches(items, 3)
    
    println()
}

/**
 * ARRAYLIST SUMMARY:
 *
 * CREATION:
 * - ArrayList(): Empty ArrayList
 * - arrayListOf(): ArrayList with elements
 * - mutableListOf(): Mutable list (similar to ArrayList)
 * - listOf(): Immutable list
 * - ArrayList(collection): From existing collection
 *
 * ADDING ELEMENTS:
 * - add(element): Add to end
 * - add(index, element): Add at specific position
 * - addAll(collection): Add multiple elements
 * - += operator: Add elements
 * - + operator: Create new list with elements
 *
 * ACCESSING ELEMENTS:
 * - [index]: Access by index
 * - get(index): Access by index (method)
 * - first(), last(): Get first/last element
 * - firstOrNull(), lastOrNull(): Safe access
 * - getOrNull(index): Safe access by index
 * - contains(element): Check if exists
 * - indexOf(element): Get index of element
 *
 * MODIFYING ELEMENTS:
 * - [index] = value: Set by index
 * - set(index, value): Set by index (method)
 * - replaceAll(): Replace all elements
 *
 * REMOVING ELEMENTS:
 * - remove(element): Remove by element
 * - removeAt(index): Remove by index
 * - removeAll(collection): Remove multiple
 * - removeIf(condition): Remove with condition
 * - removeFirst(), removeLast(): Remove ends
 * - retainAll(collection): Keep only specified
 * - clear(): Remove all elements
 *
 * SEARCHING AND FILTERING:
 * - filter(): Filter by condition
 * - find(), findLast(): Find first/last match
 * - any(), all(), none(): Check conditions
 * - count(): Count matching elements
 * - partition(): Split into two lists
 *
 * SORTING:
 * - sorted(), sortedDescending(): Create sorted list
 * - sort(), sortDescending(): Sort in-place
 * - sortedBy(), sortedByDescending(): Sort by property
 * - reversed(): Reverse list
 * - shuffled(): Random shuffle
 *
 * TRANSFORMATIONS:
 * - map(): Transform each element
 * - mapIndexed(): Transform with index
 * - flatMap(): Flatten nested lists
 * - distinct(): Remove duplicates
 * - groupBy(): Group by key
 *
 * OPERATIONS:
 * - + operator: Concatenate lists
 * - intersect(): Common elements
 * - subtract(): Difference
 * - zip(): Combine two lists
 * - chunked(): Split into chunks
 * - windowed(): Sliding window
 * - take(), drop(): Get/skip elements
 *
 * BEST PRACTICES:
 * - Use immutable lists (listOf) when possible
 * - Use ArrayList for dynamic resizing
 * - Check size before accessing elements
 * - Use safe access methods (getOrNull)
 * - Prefer functional operations (map, filter)
 * - Use appropriate capacity for large lists
 * - Consider LinkedList for frequent insertions
 * - Use distinctBy for custom uniqueness
 */
