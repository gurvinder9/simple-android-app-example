package com.example.basic

/**
 * Kotlin Map Tutorial
 *
 * This file demonstrates Map in Kotlin, including creation, operations,
 * and various map operations commonly used in Android development.
 * 
 * Map is a collection of key-value pairs where each key is unique.
 * It provides fast lookup by key.
 */

fun main() {
    println("=== Kotlin Map Tutorial ===\n")
    
    // 1. MAP CREATION
    demonstrateMapCreation()
    
    // 2. ACCESSING ELEMENTS
    demonstrateAccessingElements()
    
    // 3. ADDING AND UPDATING ELEMENTS
    demonstrateAddingAndUpdating()
    
    // 4. REMOVING ELEMENTS
    demonstrateRemovingElements()
    
    // 5. MAP OPERATIONS
    demonstrateMapOperations()
    
    // 6. SEARCHING AND FILTERING
    demonstrateSearchingAndFiltering()
    
    // 7. MAP TRANSFORMATIONS
    demonstrateMapTransformations()
    
    // 8. MAP TYPES
    demonstrateMapTypes()
    
    // 9. MAP UTILITIES
    demonstrateMapUtilities()
    
    // 10. COMMON MAP PATTERNS
    demonstrateCommonMapPatterns()
}

private fun demonstrateMapCreation() {
    println("1. MAP CREATION:")
    
    // Creating empty map
    val emptyMap = mapOf<String, Int>()
    val emptyMutableMap = mutableMapOf<String, Int>()
    val emptyHashMap = hashMapOf<String, Int>()
    
    println("   Empty maps:")
    println("   Empty map: $emptyMap")
    println("   Empty mutable map: $emptyMutableMap")
    println("   Empty hash map: $emptyHashMap")
    
    // Creating map with elements using to
    val capitals = mapOf(
        "USA" to "Washington DC",
        "UK" to "London",
        "France" to "Paris"
    )
    
    println("   Map with elements (using 'to'):")
    println("   Capitals: $capitals")
    
    // Creating map with Pair
    val ages = mapOf(
        Pair("Alice", 25),
        Pair("Bob", 30),
        Pair("Charlie", 35)
    )
    
    println("   Map with Pair:")
    println("   Ages: $ages")
    
    // Creating mutable map
    val mutableCapitals = mutableMapOf(
        "Germany" to "Berlin",
        "Italy" to "Rome"
    )
    
    println("   Mutable map:")
    println("   Mutable capitals: $mutableCapitals")
    
    // Creating from pairs
    val pairs = listOf("apple" to 1, "banana" to 2, "cherry" to 3)
    val mapFromPairs = pairs.toMap()
    
    println("   From pairs:")
    println("   Pairs: $pairs")
    println("   Map: $mapFromPairs")
    
    // Creating from lists
    val keys = listOf("one", "two", "three")
    val values = listOf(1, 2, 3)
    val zippedMap = keys.zip(values).toMap()
    
    println("   From lists:")
    println("   Keys: $keys")
    println("   Values: $values")
    println("   Zipped map: $zippedMap")
    
    println()
}

private fun demonstrateAccessingElements() {
    println("2. ACCESSING ELEMENTS:")
    
    val ages = mapOf(
        "Alice" to 25,
        "Bob" to 30,
        "Charlie" to 35
    )
    
    // Accessing by key
    println("   Accessing by key:")
    println("   Map: $ages")
    println("   Age of Alice: ${ages["Alice"]}")
    println("   Age of Bob: ${ages["Bob"]}")
    
    // Using get method
    println("   Using get method:")
    println("   Get('Charlie'): ${ages.get("Charlie")}")
    
    // Safe access
    println("   Safe access:")
    println("   Age of David: ${ages["David"]}")
    println("   Get('David'): ${ages.get("David")}")
    println("   GetOrDefault('David', 0): ${ages.getOrDefault("David", 0)}")
    println("   GetOrElse('David'): ${ages.getOrElse("David") { 0 }}")
    
    // Checking if key exists
    println("   Checking if key exists:")
    println("   Contains 'Alice': ${ages.containsKey("Alice")}")
    println("   'Bob' in ages: ${"Bob" in ages}")
    println("   Contains 'David': ${ages.containsKey("David")}")
    
    // Checking if value exists
    println("   Checking if value exists:")
    println("   Contains value 30: ${ages.containsValue(30)}")
    println("   Contains value 100: ${ages.containsValue(100)}")
    
    // Getting keys and values
    println("   Getting keys and values:")
    println("   Keys: ${ages.keys}")
    println("   Values: ${ages.values}")
    println("   Entries: ${ages.entries}")
    
    println()
}

private fun demonstrateAddingAndUpdating() {
    println("3. ADDING AND UPDATING ELEMENTS:")
    
    val fruits = mutableMapOf(
        "apple" to 1,
        "banana" to 2
    )
    
    // Adding single element
    println("   Adding single element:")
    println("   Original: $fruits")
    fruits["cherry"] = 3
    println("   After adding cherry: $fruits")
    
    // Using put method
    fruits.put("date", 4)
    println("   After put('date', 4): $fruits")
    
    // Updating existing element
    println("   Updating existing element:")
    fruits["apple"] = 10
    println("   After updating apple: $fruits")
    
    // Adding multiple elements
    fruits.putAll(mapOf("elderberry" to 5, "fig" to 6))
    println("   After putAll: $fruits")
    
    // Using += operator
    val numbers = mutableMapOf("one" to 1, "two" to 2)
    numbers += ("three" to 3)
    numbers += mapOf("four" to 4, "five" to 5)
    println("   Using += operator: $numbers")
    
    // Put if absent
    val map = mutableMapOf("a" to 1, "b" to 2)
    println("   Put if absent:")
    println("   Original: $map")
    map.putIfAbsent("c", 3)
    println("   After putIfAbsent('c', 3): $map")
    map.putIfAbsent("a", 10)
    println("   After putIfAbsent('a', 10): $map")
    
    // Plus operator (creates new map)
    val map1 = mapOf("x" to 1, "y" to 2)
    val newMap = map1 + ("z" to 3)
    val newMap2 = map1 + mapOf("a" to 4, "b" to 5)
    println("   Plus operator:")
    println("   Original: $map1")
    println("   With 'z': $newMap")
    println("   With map: $newMap2")
    
    println()
}

private fun demonstrateRemovingElements() {
    println("4. REMOVING ELEMENTS:")
    
    val fruits = mutableMapOf(
        "apple" to 1,
        "banana" to 2,
        "cherry" to 3,
        "date" to 4,
        "elderberry" to 5
    )
    
    // Removing by key
    println("   Removing by key:")
    println("   Original: $fruits")
    fruits.remove("cherry")
    println("   After remove('cherry'): $fruits")
    
    // Removing with value check
    val removed = fruits.remove("banana", 2)
    println("   After remove('banana', 2): $fruits (removed: $removed)")
    
    val notRemoved = fruits.remove("apple", 999)
    println("   After remove('apple', 999): $fruits (removed: $notRemoved)")
    
    // Removing multiple keys
    val numbers = mutableMapOf(
        "one" to 1, "two" to 2, "three" to 3,
        "four" to 4, "five" to 5
    )
    println("   Removing multiple keys:")
    println("   Original: $numbers")
    numbers.keys.removeAll(listOf("two", "four"))
    println("   After removing keys: $numbers")
    
    // Using -= operator
    val map = mutableMapOf("a" to 1, "b" to 2, "c" to 3, "d" to 4)
    map -= "b"
    map -= listOf("c", "d")
    println("   Using -= operator: $map")
    
    // Clearing all elements
    val map2 = mutableMapOf("x" to 1, "y" to 2, "z" to 3)
    println("   Clearing all:")
    println("   Original: $map2")
    map2.clear()
    println("   After clear(): $map2")
    
    println()
}

private fun demonstrateMapOperations() {
    println("5. MAP OPERATIONS:")
    
    val ages = mapOf(
        "Alice" to 25,
        "Bob" to 30,
        "Charlie" to 35
    )
    
    // Map properties
    println("   Map properties:")
    println("   Map: $ages")
    println("   Size: ${ages.size}")
    println("   Is empty: ${ages.isEmpty()}")
    println("   Is not empty: ${ages.isNotEmpty()}")
    
    // Iterating over map
    println("   Iterating over map:")
    for ((key, value) in ages) {
        println("   $key -> $value")
    }
    
    // Iterating over keys
    println("   Iterating over keys:")
    for (key in ages.keys) {
        println("   Key: $key")
    }
    
    // Iterating over values
    println("   Iterating over values:")
    for (value in ages.values) {
        println("   Value: $value")
    }
    
    // Iterating over entries
    println("   Iterating over entries:")
    ages.forEach { (key, value) ->
        println("   $key = $value")
    }
    
    // Converting to list
    val list = ages.toList()
    println("   To list: $list")
    
    // Converting to sorted map
    val sortedByKey = ages.toSortedMap()
    println("   Sorted by key: $sortedByKey")
    
    println()
}

private fun demonstrateSearchingAndFiltering() {
    println("6. SEARCHING AND FILTERING:")
    
    val ages = mapOf(
        "Alice" to 25,
        "Bob" to 30,
        "Charlie" to 35,
        "David" to 28,
        "Eve" to 32
    )
    
    // Filtering by value
    val youngPeople = ages.filter { it.value < 30 }
    val oldPeople = ages.filter { it.value >= 30 }
    
    println("   Filtering by value:")
    println("   Original: $ages")
    println("   Young (<30): $youngPeople")
    println("   Old (>=30): $oldPeople")
    
    // Filtering by key
    val startsWithC = ages.filter { it.key.startsWith("C") }
    println("   Starts with 'C': $startsWithC")
    
    // Filter keys
    val filteredKeys = ages.filterKeys { it.length > 3 }
    println("   Keys longer than 3: $filteredKeys")
    
    // Filter values
    val filteredValues = ages.filterValues { it > 28 }
    println("   Values > 28: $filteredValues")
    
    // Finding entries
    val firstYoung = ages.entries.find { it.value < 30 }
    println("   First person under 30: $firstYoung")
    
    // Checking conditions
    val anyYoung = ages.any { it.value < 30 }
    val allAdults = ages.all { it.value >= 18 }
    val noneUnderage = ages.none { it.value < 18 }
    
    println("   Checking conditions:")
    println("   Any young (<30): $anyYoung")
    println("   All adults (>=18): $allAdults")
    println("   None underage (<18): $noneUnderage")
    
    // Counting
    val youngCount = ages.count { it.value < 30 }
    println("   Count of young people: $youngCount")
    
    println()
}

private fun demonstrateMapTransformations() {
    println("7. MAP TRANSFORMATIONS:")
    
    val numbers = mapOf("one" to 1, "two" to 2, "three" to 3)
    
    // Map values
    val doubled = numbers.mapValues { it.value * 2 }
    println("   Map values:")
    println("   Original: $numbers")
    println("   Doubled values: $doubled")
    
    // Map keys
    val upperKeys = numbers.mapKeys { it.key.uppercase() }
    println("   Upper case keys: $upperKeys")
    
    // Map both keys and values
    val transformed = numbers.map { (key, value) ->
        key.uppercase() to value * 10
    }.toMap()
    println("   Transformed: $transformed")
    
    // FlatMap
    val nestedMap = mapOf(
        "group1" to listOf(1, 2, 3),
        "group2" to listOf(4, 5, 6)
    )
    val flattened = nestedMap.flatMap { it.value }
    println("   FlatMap:")
    println("   Nested: $nestedMap")
    println("   Flattened: $flattened")
    
    // Grouping
    val people = listOf(
        "Alice" to 25,
        "Bob" to 30,
        "Charlie" to 25,
        "David" to 30
    )
    val groupedByAge = people.groupBy({ it.second }, { it.first })
    println("   Grouping:")
    println("   People: $people")
    println("   Grouped by age: $groupedByAge")
    
    // Associate
    val fruits = listOf("apple", "banana", "cherry")
    val fruitLengths = fruits.associate { it to it.length }
    val fruitUpper = fruits.associateWith { it.uppercase() }
    val lengthFruit = fruits.associateBy { it.length }
    
    println("   Associate:")
    println("   Fruits: $fruits")
    println("   Fruit lengths: $fruitLengths")
    println("   Fruit upper: $fruitUpper")
    println("   Length to fruit: $lengthFruit")
    
    println()
}

private fun demonstrateMapTypes() {
    println("8. MAP TYPES:")
    
    // HashMap (unordered, fast)
    val hashMap = hashMapOf(
        "c" to 3,
        "a" to 1,
        "b" to 2
    )
    println("   HashMap (unordered):")
    println("   HashMap: $hashMap")
    
    // LinkedHashMap (maintains insertion order)
    val linkedHashMap = linkedMapOf(
        "c" to 3,
        "a" to 1,
        "b" to 2
    )
    println("   LinkedHashMap (insertion order):")
    println("   LinkedHashMap: $linkedHashMap")
    
    // SortedMap (automatically sorted by key)
    val sortedMap = sortedMapOf(
        "c" to 3,
        "a" to 1,
        "b" to 2
    )
    println("   SortedMap (automatically sorted):")
    println("   SortedMap: $sortedMap")
    
    // Comparing iteration order
    println("   Comparing iteration order:")
    print("   HashMap: ")
    hashMap.forEach { (k, v) -> print("$k=$v ") }
    println()
    
    print("   LinkedHashMap: ")
    linkedHashMap.forEach { (k, v) -> print("$k=$v ") }
    println()
    
    print("   SortedMap: ")
    sortedMap.forEach { (k, v) -> print("$k=$v ") }
    println()
    
    // Performance characteristics
    println("   Performance notes:")
    println("   HashMap: O(1) get, put, remove")
    println("   LinkedHashMap: O(1) get, put, remove + maintains order")
    println("   SortedMap: O(log n) get, put, remove + automatic sorting")
    
    println()
}

private fun demonstrateMapUtilities() {
    println("9. MAP UTILITIES:")
    
    val scores = mapOf(
        "Alice" to 95,
        "Bob" to 87,
        "Charlie" to 92,
        "David" to 78
    )
    
    // Map statistics
    println("   Map statistics:")
    println("   Scores: $scores")
    println("   Total scores: ${scores.values.sum()}")
    println("   Average score: ${scores.values.average()}")
    println("   Min score: ${scores.values.minOrNull()}")
    println("   Max score: ${scores.values.maxOrNull()}")
    
    // Min/Max by entry
    val minEntry = scores.minByOrNull { it.value }
    val maxEntry = scores.maxByOrNull { it.value }
    println("   Min entry: $minEntry")
    println("   Max entry: $maxEntry")
    
    // Sorting
    val sortedByValue = scores.toList().sortedBy { it.second }.toMap()
    val sortedByValueDesc = scores.toList().sortedByDescending { it.second }.toMap()
    println("   Sorted by value: $sortedByValue")
    println("   Sorted by value desc: $sortedByValueDesc")
    
    // Map joining
    val joined = scores.map { "${it.key}: ${it.value}" }.joinToString(", ")
    println("   Joined: $joined")
    
    // Merging maps
    val map1 = mapOf("a" to 1, "b" to 2)
    val map2 = mapOf("b" to 3, "c" to 4)
    val merged = map1 + map2
    println("   Merging maps:")
    println("   Map 1: $map1")
    println("   Map 2: $map2")
    println("   Merged: $merged")
    
    println()
}

private fun demonstrateCommonMapPatterns() {
    println("10. COMMON MAP PATTERNS:")
    
    // Pattern 1: Counting occurrences
    fun countOccurrences(items: List<String>): Map<String, Int> {
        val counts = mutableMapOf<String, Int>()
        for (item in items) {
            counts[item] = counts.getOrDefault(item, 0) + 1
        }
        return counts
    }
    
    val fruits = listOf("apple", "banana", "apple", "cherry", "banana", "apple")
    val fruitCounts = countOccurrences(fruits)
    println("   Pattern 1 - Count occurrences:")
    println("   Fruits: $fruits")
    println("   Counts: $fruitCounts")
    
    // Pattern 2: Grouping by property
    data class Person(val name: String, val age: Int)
    
    fun groupByAge(people: List<Person>): Map<Int, List<String>> {
        return people.groupBy({ it.age }, { it.name })
    }
    
    val people = listOf(
        Person("Alice", 25),
        Person("Bob", 30),
        Person("Charlie", 25),
        Person("David", 30)
    )
    val grouped = groupByAge(people)
    println("   Pattern 2 - Group by property:")
    println("   People: $people")
    println("   Grouped: $grouped")
    
    // Pattern 3: Map inversion
    fun invertMap(map: Map<String, Int>): Map<Int, String> {
        return map.entries.associate { it.value to it.key }
    }
    
    val original = mapOf("one" to 1, "two" to 2, "three" to 3)
    val inverted = invertMap(original)
    println("   Pattern 3 - Map inversion:")
    println("   Original: $original")
    println("   Inverted: $inverted")
    
    // Pattern 4: Caching with map
    class Cache<K, V> {
        private val cache = mutableMapOf<K, V>()
        
        fun get(key: K, compute: () -> V): V {
            return cache.getOrPut(key) { compute() }
        }
        
        fun invalidate(key: K) {
            cache.remove(key)
        }
        
        fun size() = cache.size
    }
    
    val cache = Cache<String, Int>()
    println("   Pattern 4 - Caching:")
    println("   Get 'value1': ${cache.get("value1") { 100 }}")
    println("   Get 'value2': ${cache.get("value2") { 200 }}")
    println("   Get 'value1' again: ${cache.get("value1") { 999 }}")
    println("   Cache size: ${cache.size()}")
    
    // Pattern 5: Configuration management
    class Config {
        private val settings = mutableMapOf<String, String>()
        
        fun set(key: String, value: String) {
            settings[key] = value
        }
        
        fun get(key: String, default: String = ""): String {
            return settings.getOrDefault(key, default)
        }
        
        fun getInt(key: String, default: Int = 0): Int {
            return settings[key]?.toIntOrNull() ?: default
        }
        
        fun getAll(): Map<String, String> = settings.toMap()
    }
    
    val config = Config()
    println("   Pattern 5 - Configuration:")
    config.set("port", "8080")
    config.set("host", "localhost")
    config.set("timeout", "30")
    println("   Port: ${config.get("port")}")
    println("   Timeout: ${config.getInt("timeout")}")
    println("   All settings: ${config.getAll()}")
    
    // Pattern 6: Frequency map
    fun findMostFrequent(items: List<String>): String? {
        return items.groupingBy { it }
            .eachCount()
            .maxByOrNull { it.value }
            ?.key
    }
    
    val words = listOf("apple", "banana", "apple", "cherry", "banana", "apple", "date")
    val mostFrequent = findMostFrequent(words)
    println("   Pattern 6 - Most frequent:")
    println("   Words: $words")
    println("   Most frequent: $mostFrequent")
    
    println()
}

/**
 * MAP SUMMARY:
 *
 * CREATION:
 * - mapOf(): Immutable map
 * - mutableMapOf(): Mutable map
 * - hashMapOf(): Hash map
 * - linkedMapOf(): Linked hash map
 * - sortedMapOf(): Sorted map
 * - to infix function: Create pairs
 * - Pair(): Create pairs
 *
 * ACCESSING:
 * - [key]: Access by key (returns null if not found)
 * - get(key): Access by key (method, returns null if not found)
 * - getOrDefault(key, default): With default
 * - getOrElse(key) { }: With lambda
 * - containsKey(key): Check key exists
 * - containsValue(value): Check value exists
 * - keys: Get all keys
 * - values: Get all values
 * - entries: Get all entries
 *
 * ADDING/UPDATING:
 * - [key] = value: Add or update
 * - put(key, value): Add or update (method)
 * - putAll(map): Add multiple
 * - putIfAbsent(key, value): Add if not exists
 * - += operator: Add entries
 * - + operator: Create new map
 *
 * REMOVING:
 * - remove(key): Remove by key
 * - remove(key, value): Remove if matches
 * - -= operator: Remove entries
 * - clear(): Remove all
 *
 * OPERATIONS:
 * - size: Number of entries
 * - isEmpty(): Check if empty
 * - forEach(): Iterate entries
 * - toList(): Convert to list
 * - toSortedMap(): Sort by key
 *
 * FILTERING:
 * - filter(): Filter entries
 * - filterKeys(): Filter by key
 * - filterValues(): Filter by value
 * - any(), all(), none(): Check conditions
 * - count(): Count matches
 *
 * TRANSFORMATIONS:
 * - mapValues(): Transform values
 * - mapKeys(): Transform keys
 * - map(): Transform entries
 * - flatMap(): Flatten nested maps
 * - associate(): Create map from list
 * - associateWith(): Keys to values
 * - associateBy(): Values to keys
 * - groupBy(): Group into map
 *
 * MAP TYPES:
 * - HashMap: Unordered, O(1) operations
 * - LinkedHashMap: Maintains insertion order
 * - SortedMap: Automatically sorted by key
 *
 * UTILITIES:
 * - sum(), average(), min(), max(): Statistics
 * - minByOrNull(), maxByOrNull(): Find entries
 * - sortedBy(): Sort entries
 * - joinToString(): Convert to string
 * - + operator: Merge maps
 *
 * BEST PRACTICES:
 * - Use maps for key-value relationships
 * - Use maps for fast lookup by key
 * - Choose appropriate map type
 * - Use immutable maps when possible
 * - HashMap for best performance
 * - LinkedHashMap when order matters
 * - SortedMap for automatic sorting
 * - Use getOrDefault for safe access
 * - Use computeIfAbsent for lazy values
 * - Consider memory usage for large maps
 */
