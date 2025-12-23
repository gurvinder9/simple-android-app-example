package com.example.basic

/**
 * Kotlin Set Tutorial
 *
 * This file demonstrates Set in Kotlin, including creation, operations,
 * and various set operations commonly used in Android development.
 * 
 * Set is a collection that contains no duplicate elements.
 * It models the mathematical set abstraction.
 */

fun main() {
    println("=== Kotlin Set Tutorial ===\n")
    
    // 1. SET CREATION
    demonstrateSetCreation()
    
    // 2. SET OPERATIONS
    demonstrateSetOperations()
    
    // 3. ADDING ELEMENTS
    demonstrateAddingElements()
    
    // 4. REMOVING ELEMENTS
    demonstrateRemovingElements()
    
    // 5. SET MATHEMATICAL OPERATIONS
    demonstrateSetMathOperations()
    
    // 6. SEARCHING AND FILTERING
    demonstrateSearchingAndFiltering()
    
    // 7. SET TRANSFORMATIONS
    demonstrateSetTransformations()
    
    // 8. SET TYPES
    demonstrateSetTypes()
    
    // 9. SET UTILITIES
    demonstrateSetUtilities()
    
    // 10. COMMON SET PATTERNS
    demonstrateCommonSetPatterns()
}

private fun demonstrateSetCreation() {
    println("1. SET CREATION:")
    
    // Creating empty set
    val emptySet = setOf<String>()
    val emptyMutableSet = mutableSetOf<Int>()
    val emptyHashSet = hashSetOf<String>()
    
    println("   Empty sets:")
    println("   Empty set: $emptySet")
    println("   Empty mutable set: $emptyMutableSet")
    println("   Empty hash set: $emptyHashSet")
    
    // Creating set with elements
    val fruits = setOf("apple", "banana", "cherry")
    val numbers = setOf(1, 2, 3, 4, 5)
    val duplicates = setOf(1, 2, 2, 3, 3, 3)  // Duplicates removed
    
    println("   Sets with elements:")
    println("   Fruits: $fruits")
    println("   Numbers: $numbers")
    println("   With duplicates: $duplicates")
    
    // Creating mutable set
    val mutableFruits = mutableSetOf("apple", "banana", "cherry")
    val hashSetNumbers = hashSetOf(1, 2, 3, 4, 5)
    
    println("   Mutable sets:")
    println("   Mutable fruits: $mutableFruits")
    println("   Hash set: $hashSetNumbers")
    
    // Creating from collection
    val listWithDuplicates = listOf(1, 2, 2, 3, 3, 3, 4, 4, 4, 4)
    val setFromList = listWithDuplicates.toSet()
    val mutableSetFromList = listWithDuplicates.toMutableSet()
    
    println("   From collection:")
    println("   List with duplicates: $listWithDuplicates")
    println("   Set from list: $setFromList")
    println("   Mutable set from list: $mutableSetFromList")
    
    // Creating sorted set
    val sortedSet = sortedSetOf(5, 2, 8, 1, 9, 3)
    println("   Sorted set: $sortedSet")
    
    // Creating linked hash set (maintains insertion order)
    val linkedSet = linkedSetOf("first", "second", "third")
    println("   Linked hash set: $linkedSet")
    
    println()
}

private fun demonstrateSetOperations() {
    println("2. SET OPERATIONS:")
    
    val set = setOf("apple", "banana", "cherry")
    
    // Checking size
    println("   Set properties:")
    println("   Set: $set")
    println("   Size: ${set.size}")
    println("   Is empty: ${set.isEmpty()}")
    println("   Is not empty: ${set.isNotEmpty()}")
    
    // Checking if element exists
    println("   Checking existence:")
    println("   Contains 'banana': ${set.contains("banana")}")
    println("   'cherry' in set: ${"cherry" in set}")
    println("   Contains 'mango': ${set.contains("mango")}")
    
    // Checking multiple elements
    val toCheck = setOf("apple", "mango")
    println("   Contains all $toCheck: ${set.containsAll(toCheck)}")
    
    // Converting to list
    val list = set.toList()
    println("   To list: $list")
    
    // Converting to array
    val array = set.toTypedArray()
    println("   To array: ${array.contentToString()}")
    
    println()
}

private fun demonstrateAddingElements() {
    println("3. ADDING ELEMENTS:")
    
    val fruits = mutableSetOf("apple", "banana")
    
    // Adding single element
    println("   Adding single element:")
    println("   Original: $fruits")
    fruits.add("cherry")
    println("   After add('cherry'): $fruits")
    
    // Adding duplicate (no effect)
    val added = fruits.add("apple")
    println("   After add('apple'): $fruits (added: $added)")
    
    // Adding multiple elements
    fruits.addAll(listOf("date", "elderberry"))
    println("   After addAll: $fruits")
    
    // Using += operator
    val numbers = mutableSetOf(1, 2, 3)
    numbers += 4
    numbers += setOf(5, 6, 7)
    println("   Using += operator: $numbers")
    
    // Plus operator (creates new set)
    val set1 = setOf("a", "b")
    val newSet = set1 + "c"
    val newSet2 = set1 + setOf("d", "e")
    println("   Plus operator:")
    println("   Original: $set1")
    println("   With 'c': $newSet")
    println("   With set: $newSet2")
    
    println()
}

private fun demonstrateRemovingElements() {
    println("4. REMOVING ELEMENTS:")
    
    val fruits = mutableSetOf("apple", "banana", "cherry", "date", "elderberry")
    
    // Removing single element
    println("   Removing single element:")
    println("   Original: $fruits")
    fruits.remove("cherry")
    println("   After remove('cherry'): $fruits")
    
    // Removing non-existent element
    val removed = fruits.remove("mango")
    println("   After remove('mango'): $fruits (removed: $removed)")
    
    // Removing multiple elements
    val numbers = mutableSetOf(1, 2, 3, 4, 5, 6, 7, 8)
    println("   Removing multiple elements:")
    println("   Original: $numbers")
    numbers.removeAll(setOf(2, 4, 6))
    println("   After removeAll([2, 4, 6]): $numbers")
    
    // Removing with condition
    val numbers2 = mutableSetOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("   Removing with condition:")
    println("   Original: $numbers2")
    numbers2.removeIf { it % 2 == 0 }
    println("   After removeIf (even): $numbers2")
    
    // Retaining elements
    val numbers3 = mutableSetOf(1, 2, 3, 4, 5, 6, 7, 8)
    println("   Retaining elements:")
    println("   Original: $numbers3")
    numbers3.retainAll(setOf(2, 4, 6, 8))
    println("   After retainAll([2, 4, 6, 8]): $numbers3")
    
    // Clearing all elements
    val set = mutableSetOf("a", "b", "c")
    println("   Clearing all:")
    println("   Original: $set")
    set.clear()
    println("   After clear(): $set")
    
    // Using -= operator
    val set2 = mutableSetOf(1, 2, 3, 4, 5)
    set2 -= 3
    set2 -= setOf(1, 2)
    println("   Using -= operator: $set2")
    
    println()
}

private fun demonstrateSetMathOperations() {
    println("5. SET MATHEMATICAL OPERATIONS:")
    
    val set1 = setOf(1, 2, 3, 4, 5)
    val set2 = setOf(4, 5, 6, 7, 8)
    
    println("   Set 1: $set1")
    println("   Set 2: $set2")
    
    // Union
    val union = set1 union set2
    val unionWithPlus = set1 + set2
    println("   Union (set1 ∪ set2): $union")
    println("   Union with +: $unionWithPlus")
    
    // Intersection
    val intersection = set1 intersect set2
    println("   Intersection (set1 ∩ set2): $intersection")
    
    // Difference
    val difference = set1 subtract set2
    val difference2 = set2 subtract set1
    println("   Difference (set1 - set2): $difference")
    println("   Difference (set2 - set1): $difference2")
    
    // Symmetric difference (union - intersection)
    val symmetricDiff = (set1 union set2) subtract (set1 intersect set2)
    println("   Symmetric difference: $symmetricDiff")
    
    // Subset checking
    val subset = setOf(2, 3, 4)
    println("   Is $subset subset of set1: ${subset.all { it in set1 }}")
    
    // Superset checking
    println("   Is set1 superset of $subset: ${subset.all { it in set1 }}")
    
    // Disjoint sets (no common elements)
    val set3 = setOf(10, 11, 12)
    val hasCommon = (set1 intersect set3).isNotEmpty()
    println("   Sets $set1 and $set3 are disjoint: ${!hasCommon}")
    
    println()
}

private fun demonstrateSearchingAndFiltering() {
    println("6. SEARCHING AND FILTERING:")
    
    val numbers = setOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    
    // Filtering
    val evenNumbers = numbers.filter { it % 2 == 0 }.toSet()
    val oddNumbers = numbers.filter { it % 2 != 0 }.toSet()
    val largeNumbers = numbers.filter { it > 5 }.toSet()
    
    println("   Filtering:")
    println("   Original: $numbers")
    println("   Even: $evenNumbers")
    println("   Odd: $oddNumbers")
    println("   Large (>5): $largeNumbers")
    
    // Finding elements
    val firstEven = numbers.find { it % 2 == 0 }
    val firstLarge = numbers.firstOrNull { it > 5 }
    
    println("   Finding elements:")
    println("   First even: $firstEven")
    println("   First large (>5): $firstLarge")
    
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
    println("   Even partition: ${even.toSet()}")
    println("   Odd partition: ${odd.toSet()}")
    
    println()
}

private fun demonstrateSetTransformations() {
    println("7. SET TRANSFORMATIONS:")
    
    val numbers = setOf(1, 2, 3, 4, 5)
    
    // Map transformation
    val squared = numbers.map { it * it }.toSet()
    val strings = numbers.map { "Number $it" }.toSet()
    
    println("   Map transformation:")
    println("   Original: $numbers")
    println("   Squared: $squared")
    println("   Strings: $strings")
    
    // FlatMap transformation
    val nestedSets = setOf(setOf(1, 2), setOf(3, 4), setOf(5, 6))
    val flattened = nestedSets.flatMap { it }.toSet()
    
    println("   FlatMap:")
    println("   Nested: $nestedSets")
    println("   Flattened: $flattened")
    
    // Grouping
    val grouped = numbers.groupBy { it % 2 }
    
    println("   Grouping:")
    println("   Grouped by even/odd: $grouped")
    
    // Sorting
    val sortedSet = setOf(5, 2, 8, 1, 9, 3)
    val sorted = sortedSet.sorted()
    val sortedDesc = sortedSet.sortedDescending()
    
    println("   Sorting:")
    println("   Original: $sortedSet")
    println("   Sorted: $sorted")
    println("   Sorted desc: $sortedDesc")
    
    // Distinct by
    val fruits = setOf("apple", "apricot", "banana", "blueberry", "cherry")
    val distinctByFirst = fruits.distinctBy { it.first() }
    
    println("   Distinct by:")
    println("   Original: $fruits")
    println("   Distinct by first char: $distinctByFirst")
    
    println()
}

private fun demonstrateSetTypes() {
    println("8. SET TYPES:")
    
    // HashSet (unordered, fast)
    val hashSet = hashSetOf(5, 2, 8, 1, 9, 3)
    println("   HashSet (unordered):")
    println("   HashSet: $hashSet")
    
    // LinkedHashSet (maintains insertion order)
    val linkedHashSet = linkedSetOf(5, 2, 8, 1, 9, 3)
    println("   LinkedHashSet (insertion order):")
    println("   LinkedHashSet: $linkedHashSet")
    
    // SortedSet (automatically sorted)
    val sortedSet = sortedSetOf(5, 2, 8, 1, 9, 3)
    println("   SortedSet (automatically sorted):")
    println("   SortedSet: $sortedSet")
    
    // Comparing iteration order
    println("   Comparing iteration order:")
    print("   HashSet iteration: ")
    hashSet.forEach { print("$it ") }
    println()
    
    print("   LinkedHashSet iteration: ")
    linkedHashSet.forEach { print("$it ") }
    println()
    
    print("   SortedSet iteration: ")
    sortedSet.forEach { print("$it ") }
    println()
    
    // Performance characteristics
    println("   Performance notes:")
    println("   HashSet: O(1) add, remove, contains")
    println("   LinkedHashSet: O(1) add, remove, contains + maintains order")
    println("   SortedSet: O(log n) add, remove, contains + automatic sorting")
    
    println()
}

private fun demonstrateSetUtilities() {
    println("9. SET UTILITIES:")
    
    val numbers = setOf(1, 2, 3, 4, 5)
    
    // Set properties
    println("   Set properties:")
    println("   Size: ${numbers.size}")
    println("   First: ${numbers.first()}")
    println("   Last: ${numbers.last()}")
    println("   FirstOrNull: ${numbers.firstOrNull()}")
    println("   LastOrNull: ${numbers.lastOrNull()}")
    
    // Set statistics
    println("   Set statistics:")
    println("   Sum: ${numbers.sum()}")
    println("   Average: ${numbers.average()}")
    println("   Min: ${numbers.minOrNull()}")
    println("   Max: ${numbers.maxOrNull()}")
    
    // Set joining
    val joinedString = numbers.joinToString(", ")
    val joinedWithPrefix = numbers.joinToString(", ", "Numbers: ", ".")
    
    println("   Set joining:")
    println("   Joined: \"$joinedString\"")
    println("   With prefix/suffix: \"$joinedWithPrefix\"")
    
    // Set iteration
    println("   Set iteration:")
    numbers.forEach { num ->
        println("   Element: $num")
    }
    
    // Set with index
    println("   Set with index:")
    numbers.forEachIndexed { index, value ->
        println("   Index $index: $value")
    }
    
    println()
}

private fun demonstrateCommonSetPatterns() {
    println("10. COMMON SET PATTERNS:")
    
    // Pattern 1: Remove duplicates from list
    fun removeDuplicates(list: List<Int>): List<Int> {
        return list.toSet().toList()
    }
    
    val listWithDuplicates = listOf(1, 2, 2, 3, 3, 3, 4, 4, 4, 4)
    val unique = removeDuplicates(listWithDuplicates)
    println("   Pattern 1 - Remove duplicates:")
    println("   Original: $listWithDuplicates")
    println("   Unique: $unique")
    
    // Pattern 2: Find common elements
    fun findCommonElements(list1: List<Int>, list2: List<Int>): Set<Int> {
        return list1.toSet() intersect list2.toSet()
    }
    
    val list1 = listOf(1, 2, 3, 4, 5)
    val list2 = listOf(4, 5, 6, 7, 8)
    val common = findCommonElements(list1, list2)
    println("   Pattern 2 - Find common elements:")
    println("   List 1: $list1")
    println("   List 2: $list2")
    println("   Common: $common")
    
    // Pattern 3: Find unique elements
    fun findUniqueElements(list1: List<Int>, list2: List<Int>): Set<Int> {
        val set1 = list1.toSet()
        val set2 = list2.toSet()
        return (set1 subtract set2) union (set2 subtract set1)
    }
    
    val unique1 = findUniqueElements(list1, list2)
    println("   Pattern 3 - Find unique elements:")
    println("   Unique to either list: $unique1")
    
    // Pattern 4: Validate unique values
    fun hasUniqueValues(list: List<String>): Boolean {
        return list.size == list.toSet().size
    }
    
    val uniqueList = listOf("apple", "banana", "cherry")
    val duplicateList = listOf("apple", "banana", "apple")
    println("   Pattern 4 - Validate unique values:")
    println("   $uniqueList has unique values: ${hasUniqueValues(uniqueList)}")
    println("   $duplicateList has unique values: ${hasUniqueValues(duplicateList)}")
    
    // Pattern 5: Track visited items
    fun processItems(items: List<String>): List<String> {
        val visited = mutableSetOf<String>()
        val processed = mutableListOf<String>()
        
        for (item in items) {
            if (visited.add(item)) {
                processed.add("Processed: $item")
            } else {
                processed.add("Already processed: $item")
            }
        }
        return processed
    }
    
    val items = listOf("A", "B", "C", "A", "D", "B")
    val result = processItems(items)
    println("   Pattern 5 - Track visited items:")
    result.forEach { println("   $it") }
    
    // Pattern 6: Set-based caching
    class Cache {
        private val cache = mutableSetOf<String>()
        
        fun isCached(key: String): Boolean = key in cache
        
        fun cache(key: String): Boolean = cache.add(key)
        
        fun invalidate(key: String): Boolean = cache.remove(key)
        
        fun size(): Int = cache.size
    }
    
    val cache = Cache()
    println("   Pattern 6 - Set-based caching:")
    println("   Cache 'user1': ${cache.cache("user1")}")
    println("   Cache 'user2': ${cache.cache("user2")}")
    println("   Is 'user1' cached: ${cache.isCached("user1")}")
    println("   Cache 'user1' again: ${cache.cache("user1")}")
    println("   Cache size: ${cache.size()}")
    
    println()
}

/**
 * SET SUMMARY:
 *
 * CREATION:
 * - setOf(): Immutable set
 * - mutableSetOf(): Mutable set
 * - hashSetOf(): Hash set
 * - linkedSetOf(): Linked hash set
 * - sortedSetOf(): Sorted set
 * - toSet(): Convert collection to set
 *
 * PROPERTIES:
 * - size: Number of elements
 * - isEmpty(): Check if empty
 * - isNotEmpty(): Check if not empty
 * - No duplicate elements allowed
 * - No specific order (except LinkedHashSet/SortedSet)
 *
 * ADDING ELEMENTS:
 * - add(element): Add element
 * - addAll(collection): Add multiple
 * - += operator: Add elements
 * - + operator: Create new set
 * - Duplicates are automatically ignored
 *
 * REMOVING ELEMENTS:
 * - remove(element): Remove element
 * - removeAll(collection): Remove multiple
 * - removeIf(condition): Remove with condition
 * - retainAll(collection): Keep only specified
 * - clear(): Remove all
 * - -= operator: Remove elements
 *
 * MATHEMATICAL OPERATIONS:
 * - union: Combine sets (set1 ∪ set2)
 * - intersect: Common elements (set1 ∩ set2)
 * - subtract: Difference (set1 - set2)
 * - Symmetric difference: (A ∪ B) - (A ∩ B)
 *
 * SEARCHING AND FILTERING:
 * - contains(element): Check existence
 * - containsAll(collection): Check multiple
 * - filter(): Filter by condition
 * - find(): Find first match
 * - any(), all(), none(): Check conditions
 * - count(): Count matches
 *
 * TRANSFORMATIONS:
 * - map(): Transform elements
 * - flatMap(): Flatten nested sets
 * - groupBy(): Group elements
 * - sorted(): Sort elements
 * - distinctBy(): Unique by property
 *
 * SET TYPES:
 * - HashSet: Unordered, fast O(1) operations
 * - LinkedHashSet: Maintains insertion order
 * - SortedSet: Automatically sorted, O(log n)
 *
 * UTILITIES:
 * - first(), last(): Get elements
 * - sum(), average(), min(), max(): Statistics
 * - joinToString(): Convert to string
 * - forEach(): Iterate elements
 *
 * BEST PRACTICES:
 * - Use sets for unique collections
 * - Use sets for fast membership testing
 * - Use sets for mathematical operations
 * - Choose appropriate set type for use case
 * - Use immutable sets when possible
 * - HashSet for best performance
 * - LinkedHashSet when order matters
 * - SortedSet for automatic sorting
 * - Sets are ideal for removing duplicates
 */
