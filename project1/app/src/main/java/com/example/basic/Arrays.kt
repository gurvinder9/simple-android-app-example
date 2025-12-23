package com.example.basic

/**
 * Kotlin Arrays Tutorial
 *
 * This file demonstrates arrays in Kotlin, including array creation, manipulation,
 * operations, and various array types commonly used in Android development.
 */

fun main() {
    println("=== Kotlin Arrays Tutorial ===\n")
    
    // 1. ARRAY CREATION
    demonstrateArrayCreation()
    
    // 2. ARRAY ACCESS AND MODIFICATION
    demonstrateArrayAccess()
    
    // 3. ARRAY OPERATIONS
    demonstrateArrayOperations()
    
    // 4. ARRAY ITERATION
    demonstrateArrayIteration()
    
    // 5. ARRAY TRANSFORMATIONS
    demonstrateArrayTransformations()
    
    // 6. ARRAY FILTERING AND SEARCHING
    demonstrateArrayFiltering()
    
    // 7. MULTI-DIMENSIONAL ARRAYS
    demonstrateMultiDimensionalArrays()
    
    // 8. ARRAY COMPARISON AND SORTING
    demonstrateArrayComparison()
    
    // 9. ARRAY UTILITIES
    demonstrateArrayUtilities()
    
    // 10. COMMON ARRAY PATTERNS
    demonstrateCommonArrayPatterns()
}

private fun demonstrateArrayCreation() {
    println("1. ARRAY CREATION:")
    
    // Using arrayOf() function
    val stringArray = arrayOf("apple", "banana", "cherry")
    val intArray = arrayOf(1, 2, 3, 4, 5)
    val mixedArray = arrayOf("hello", 42, true, 3.14)
    
    println("   Using arrayOf():")
    println("   String array: ${stringArray.contentToString()}")
    println("   Int array: ${intArray.contentToString()}")
    println("   Mixed array: ${mixedArray.contentToString()}")
    
    // Using Array constructor
    val sizedArray = Array(5) { it * 2 }  // Creates [0, 2, 4, 6, 8]
    val charArray = Array(3) { 'A' + it }  // Creates ['A', 'B', 'C']
    val stringArray2 = Array(4) { "Item $it" }  // Creates ["Item 0", "Item 1", ...]
    
    println("   Using Array constructor:")
    println("   Sized array: ${sizedArray.contentToString()}")
    println("   Char array: ${charArray.contentToString()}")
    println("   String array: ${stringArray2.contentToString()}")
    
    // Primitive type arrays
    val intArrayPrimitive = intArrayOf(1, 2, 3, 4, 5)
    val doubleArrayPrimitive = doubleArrayOf(1.1, 2.2, 3.3, 4.4, 5.5)
    val booleanArrayPrimitive = booleanArrayOf(true, false, true, false)
    val charArrayPrimitive = charArrayOf('a', 'b', 'c', 'd', 'e')
    
    println("   Primitive type arrays:")
    println("   Int array: ${intArrayPrimitive.contentToString()}")
    println("   Double array: ${doubleArrayPrimitive.contentToString()}")
    println("   Boolean array: ${booleanArrayPrimitive.contentToString()}")
    println("   Char array: ${charArrayPrimitive.contentToString()}")
    
    // Empty arrays
    val emptyStringArray = arrayOf<String>()
    val emptyIntArray = intArrayOf()
    val sizedEmptyArray = Array(3) { "" }
    
    println("   Empty arrays:")
    println("   Empty string array: ${emptyStringArray.contentToString()}")
    println("   Empty int array: ${emptyIntArray.contentToString()}")
    println("   Sized empty array: ${sizedEmptyArray.contentToString()}")
    
    // Nullable arrays
    val nullableArray = arrayOfNulls<String>(3)
    val nullableIntArray = arrayOfNulls<Int>(4)
    
    println("   Nullable arrays:")
    println("   Nullable string array: ${nullableArray.contentToString()}")
    println("   Nullable int array: ${nullableIntArray.contentToString()}")
    
    println()
}

private fun demonstrateArrayAccess() {
    println("2. ARRAY ACCESS AND MODIFICATION:")
    
    val numbers = arrayOf(10, 20, 30, 40, 50)
    
    // Reading array elements
    println("   Reading array elements:")
    println("   Array: ${numbers.contentToString()}")
    println("   First element: ${numbers[0]}")
    println("   Last element: ${numbers[numbers.size - 1]}")
    println("   Element at index 2: ${numbers[2]}")
    
    // Using get() and set() methods
    println("   Using get() and set() methods:")
    println("   Get element at index 1: ${numbers.get(1)}")
    numbers.set(1, 25)
    println("   After set(1, 25): ${numbers.contentToString()}")
    
    // Array bounds checking
    println("   Array bounds checking:")
    try {
        println("   Accessing index 10: ${numbers[10]}")
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("   Caught ArrayIndexOutOfBoundsException: ${e.message}")
    }
    
    // Safe array access
    val safeIndex = 3
    if (safeIndex < numbers.size) {
        println("   Safe access at index $safeIndex: ${numbers[safeIndex]}")
    }
    
    // Modifying array elements
    println("   Modifying array elements:")
    numbers[0] = 100
    numbers[numbers.size - 1] = 500
    println("   After modifications: ${numbers.contentToString()}")
    
    // Array size
    println("   Array properties:")
    println("   Array size: ${numbers.size}")
    println("   Array indices: ${numbers.indices}")
    println("   Last index: ${numbers.lastIndex}")
    
    println()
}

private fun demonstrateArrayOperations() {
    println("3. ARRAY OPERATIONS:")
    
    val array1 = arrayOf(1, 2, 3, 4, 5)
    val array2 = arrayOf(6, 7, 8, 9, 10)
    
    // Array concatenation
    val combinedArray = array1 + array2
    println("   Array concatenation:")
    println("   Array 1: ${array1.contentToString()}")
    println("   Array 2: ${array2.contentToString()}")
    println("   Combined: ${combinedArray.contentToString()}")
    
    // Array slicing
    val slice1 = array1.sliceArray(1..3)
    val slice2 = array1.sliceArray(0..2)
    val slice3 = array1.sliceArray(2 until array1.size)
    
    println("   Array slicing:")
    println("   Slice 1..3: ${slice1.contentToString()}")
    println("   Slice 0..2: ${slice2.contentToString()}")
    println("   Slice 2 until end: ${slice3.contentToString()}")
    
    // Array copying
    val copiedArray = array1.copyOf()
    val copiedWithSize = array1.copyOf(7)
    val copiedRange = array1.copyOfRange(1, 4)
    
    println("   Array copying:")
    println("   Original: ${array1.contentToString()}")
    println("   Copied: ${copiedArray.contentToString()}")
    println("   Copied with size 7: ${copiedWithSize.contentToString()}")
    println("   Copied range 1..3: ${copiedRange.contentToString()}")
    
    // Array filling
    val filledArray = Array(5) { 0 }
    filledArray.fill(42)
    println("   Array filling:")
    println("   Filled array: ${filledArray.contentToString()}")
    
    // Array reversal
    val reversedArray = array1.reversedArray()
    println("   Array reversal:")
    println("   Original: ${array1.contentToString()}")
    println("   Reversed: ${reversedArray.contentToString()}")
    
    println()
}

private fun demonstrateArrayIteration() {
    println("4. ARRAY ITERATION:")
    
    val fruits = arrayOf("apple", "banana", "cherry", "date", "elderberry")
    
    // Basic for loop
    println("   Basic for loop:")
    for (i in fruits.indices) {
        println("   Index $i: ${fruits[i]}")
    }
    
    // For-each loop
    println("   For-each loop:")
    for (fruit in fruits) {
        println("   Fruit: $fruit")
    }
    
    // For-each with index
    println("   For-each with index:")
    for ((index, fruit) in fruits.withIndex()) {
        println("   Index $index: $fruit")
    }
    
    // While loop
    println("   While loop:")
    var i = 0
    while (i < fruits.size) {
        println("   While index $i: ${fruits[i]}")
        i++
    }
    
    // ForEach function
    println("   ForEach function:")
    fruits.forEach { fruit ->
        println("   ForEach: $fruit")
    }
    
    // ForEachIndexed function
    println("   ForEachIndexed function:")
    fruits.forEachIndexed { index, fruit ->
        println("   ForEachIndexed $index: $fruit")
    }
    
    // Iterating backwards
    println("   Iterating backwards:")
    for (i in fruits.lastIndex downTo 0) {
        println("   Backwards index $i: ${fruits[i]}")
    }
    
    // Iterating with step
    println("   Iterating with step:")
    for (i in 0 until fruits.size step 2) {
        println("   Step 2 index $i: ${fruits[i]}")
    }
    
    println()
}

private fun demonstrateArrayTransformations() {
    println("5. ARRAY TRANSFORMATIONS:")
    
    val numbers = arrayOf(1, 2, 3, 4, 5)
    
    // Map transformation
    val squaredNumbers = numbers.map { it * it }.toTypedArray()
    val stringNumbers = numbers.map { "Number $it" }.toTypedArray()
    
    println("   Map transformation:")
    println("   Original: ${numbers.contentToString()}")
    println("   Squared: ${squaredNumbers.contentToString()}")
    println("   String: ${stringNumbers.contentToString()}")
    
    // Filter transformation
    val evenNumbers = numbers.filter { it % 2 == 0 }.toIntArray()
    val largeNumbers = numbers.filter { it > 3 }.toTypedArray()
    
    println("   Filter transformation:")
    println("   Even numbers: ${evenNumbers.contentToString()}")
    println("   Large numbers: ${largeNumbers.contentToString()}")
    
    // FlatMap transformation
    val nestedArray = arrayOf(arrayOf(1, 2), arrayOf(3, 4), arrayOf(5, 6))
    val flattenedArray = nestedArray.flatMap { it.toList() }.toIntArray()
    
    println("   FlatMap transformation:")
    println("   Nested array: ${nestedArray.contentDeepToString()}")
    println("   Flattened: ${flattenedArray.contentToString()}")
    
    // Reduce operations
    val sum = numbers.reduce { acc, num -> acc + num }
    val product = numbers.reduce { acc, num -> acc * num }
    val max = numbers.reduce { acc, num -> if (num > acc) num else acc }
    
    println("   Reduce operations:")
    println("   Sum: $sum")
    println("   Product: $product")
    println("   Max: $max")
    
    // Fold operations
    val sumWithInitial = numbers.fold(10) { acc, num -> acc + num }
    val stringConcat = numbers.fold("Numbers: ") { acc, num -> "$acc$num " }
    
    println("   Fold operations:")
    println("   Sum with initial 10: $sumWithInitial")
    println("   String concatenation: $stringConcat")
    
    println()
}

private fun demonstrateArrayFiltering() {
    println("6. ARRAY FILTERING AND SEARCHING:")
    
    val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    
    // Basic filtering
    val evenNumbers = numbers.filter { it % 2 == 0 }.toIntArray()
    val oddNumbers = numbers.filter { it % 2 != 0 }.toIntArray()
    val largeNumbers = numbers.filter { it > 5 }.toIntArray()
    
    println("   Basic filtering:")
    println("   Original: ${numbers.contentToString()}")
    println("   Even: ${evenNumbers.contentToString()}")
    println("   Odd: ${oddNumbers.contentToString()}")
    println("   Large (>5): ${largeNumbers.contentToString()}")
    
    // Searching operations
    val firstEven = numbers.find { it % 2 == 0 }
    val lastEven = numbers.findLast { it % 2 == 0 }
    val firstEvenIndex = numbers.indexOfFirst { it % 2 == 0 }
    val lastEvenIndex = numbers.indexOfLast { it % 2 == 0 }
    
    println("   Searching operations:")
    println("   First even: $firstEven")
    println("   Last even: $lastEven")
    println("   First even index: $firstEvenIndex")
    println("   Last even index: $lastEvenIndex")
    
    // Existence checking
    val hasEven = numbers.any { it % 2 == 0 }
    val allEven = numbers.all { it % 2 == 0 }
    val noneEven = numbers.none { it % 2 == 0 }
    
    println("   Existence checking:")
    println("   Has even: $hasEven")
    println("   All even: $allEven")
    println("   None even: $noneEven")
    
    // Count operations
    val evenCount = numbers.count { it % 2 == 0 }
    val largeCount = numbers.count { it > 5 }
    
    println("   Count operations:")
    println("   Even count: $evenCount")
    println("   Large count: $largeCount")
    
    // Partition
    val (evenPart, oddPart) = numbers.partition { it % 2 == 0 }
    println("   Partition:")
    println("   Even part: ${evenPart.toIntArray().contentToString()}")
    println("   Odd part: ${oddPart.toIntArray().contentToString()}")
    
    println()
}

private fun demonstrateMultiDimensionalArrays() {
    println("7. MULTI-DIMENSIONAL ARRAYS:")
    
    // 2D Array creation
    val matrix2D = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6),
        arrayOf(7, 8, 9)
    )
    
    println("   2D Array creation:")
    println("   Matrix: ${matrix2D.contentDeepToString()}")
    
    // Accessing 2D array elements
    println("   Accessing 2D array elements:")
    println("   Element at [0][0]: ${matrix2D[0][0]}")
    println("   Element at [1][2]: ${matrix2D[1][2]}")
    println("   Element at [2][1]: ${matrix2D[2][1]}")
    
    // Iterating through 2D array
    println("   Iterating through 2D array:")
    for (i in matrix2D.indices) {
        for (j in matrix2D[i].indices) {
            print("   ${matrix2D[i][j]} ")
        }
        println()
    }
    
    // 3D Array creation
    val matrix3D = arrayOf(
        arrayOf(
            arrayOf(1, 2),
            arrayOf(3, 4)
        ),
        arrayOf(
            arrayOf(5, 6),
            arrayOf(7, 8)
        )
    )
    
    println("   3D Array creation:")
    println("   3D Matrix: ${matrix3D.contentDeepToString()}")
    
    // Array of arrays
    val jaggedArray = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5),
        arrayOf(6, 7, 8, 9)
    )
    
    println("   Jagged array:")
    println("   Jagged: ${jaggedArray.contentDeepToString()}")
    
    // Creating arrays with Array constructor
    val custom2D = Array(3) { Array(3) { 0 } }
    custom2D[0][0] = 1
    custom2D[1][1] = 1
    custom2D[2][2] = 1
    
    println("   Custom 2D array:")
    println("   Custom: ${custom2D.contentDeepToString()}")
    
    println()
}

private fun demonstrateArrayComparison() {
    println("8. ARRAY COMPARISON AND SORTING:")
    
    val array1 = arrayOf(3, 1, 4, 1, 5)
    val array2 = arrayOf(3, 1, 4, 1, 5)
    val array3 = arrayOf(1, 1, 3, 4, 5)
    
    // Content comparison
    println("   Content comparison:")
    println("   Array 1: ${array1.contentToString()}")
    println("   Array 2: ${array2.contentToString()}")
    println("   Array 3: ${array3.contentToString()}")
    println("   Array1 == Array2: ${array1.contentEquals(array2)}")
    println("   Array1 == Array3: ${array1.contentEquals(array3)}")
    
    // Deep comparison for nested arrays
    val nested1 = arrayOf(arrayOf(1, 2), arrayOf(3, 4))
    val nested2 = arrayOf(arrayOf(1, 2), arrayOf(3, 4))
    val nested3 = arrayOf(arrayOf(1, 2), arrayOf(3, 5))
    
    println("   Deep comparison:")
    println("   Nested1 == Nested2: ${nested1.contentDeepEquals(nested2)}")
    println("   Nested1 == Nested3: ${nested1.contentDeepEquals(nested3)}")
    
    // Array sorting
    val unsortedArray = arrayOf(5, 2, 8, 1, 9, 3)
    val sortedArray = unsortedArray.sortedArray()
    val sortedDescArray = unsortedArray.sortedArrayDescending()
    
    println("   Array sorting:")
    println("   Original: ${unsortedArray.contentToString()}")
    println("   Sorted: ${sortedArray.contentToString()}")
    println("   Sorted desc: ${sortedDescArray.contentToString()}")
    
    // Custom sorting
    val stringArray = arrayOf("apple", "banana", "cherry", "date")
    val sortedByLength = stringArray.sortedBy { it.length }.toTypedArray()
    val sortedByLengthDesc = stringArray.sortedByDescending { it.length }.toTypedArray()
    
    println("   Custom sorting:")
    println("   Original: ${stringArray.contentToString()}")
    println("   Sorted by length: ${sortedByLength.contentToString()}")
    println("   Sorted by length desc: ${sortedByLengthDesc.contentToString()}")
    
    // In-place sorting
    val mutableArray = arrayOf(5, 2, 8, 1, 9, 3)
    mutableArray.sort()
    println("   In-place sorting:")
    println("   After sort(): ${mutableArray.contentToString()}")
    
    println()
}

private fun demonstrateArrayUtilities() {
    println("9. ARRAY UTILITIES:")
    
    val numbers = arrayOf(1, 2, 3, 4, 5)
    
    // Array properties
    println("   Array properties:")
    println("   Size: ${numbers.size}")
    println("   Indices: ${numbers.indices}")
    println("   Last index: ${numbers.lastIndex}")
    println("   First element: ${numbers.first()}")
    println("   Last element: ${numbers.last()}")
    
    // Array statistics
    val intNumbers = intArrayOf(1, 2, 3, 4, 5)
    println("   Array statistics:")
    println("   Sum: ${intNumbers.sum()}")
    println("   Average: ${intNumbers.average()}")
    println("   Min: ${intNumbers.minOrNull()}")
    println("   Max: ${intNumbers.maxOrNull()}")
    
    // Array conversion
    val stringNumbers = arrayOf("1", "2", "3", "4", "5")
    val intArray = stringNumbers.map { it.toInt() }.toIntArray()
    val stringArray = numbers.map { it.toString() }.toTypedArray()
    
    println("   Array conversion:")
    println("   String to int: ${intArray.contentToString()}")
    println("   Int to string: ${stringArray.contentToString()}")
    
    // Array joining
    val joinedString = numbers.joinToString(", ")
    val joinedWithPrefix = numbers.joinToString(", ", "Numbers: ", ".")
    
    println("   Array joining:")
    println("   Joined: \"$joinedString\"")
    println("   With prefix/suffix: \"$joinedWithPrefix\"")
    
    // Array chunking
    val chunkedArray = numbers.toList().chunked(2)
    println("   Array chunking:")
    println("   Chunked by 2: $chunkedArray")
    
    // Array windowing
    val windowedArray = numbers.toList().windowed(3)
    println("   Array windowing:")
    println("   Windowed by 3: $windowedArray")
    
    println()
}

private fun demonstrateCommonArrayPatterns() {
    println("10. COMMON ARRAY PATTERNS:")
    
    // Pattern 1: Array initialization with default values
    fun createArrayWithDefaults(size: Int, defaultValue: Int): IntArray {
        return IntArray(size) { defaultValue }
    }
    
    val defaultArray = createArrayWithDefaults(5, 0)
    println("   Pattern 1 - Array with defaults:")
    println("   Default array: ${defaultArray.contentToString()}")
    
    // Pattern 2: Array filtering and transformation
    fun processNumbers(numbers: IntArray): IntArray {
        return numbers
            .filter { it > 0 }
            .map { it * it }
            .toIntArray()
    }
    
    val inputNumbers = intArrayOf(-2, -1, 0, 1, 2, 3, 4)
    val processedNumbers = processNumbers(inputNumbers)
    println("   Pattern 2 - Filter and transform:")
    println("   Input: ${inputNumbers.contentToString()}")
    println("   Processed: ${processedNumbers.contentToString()}")
    
    // Pattern 3: Array searching
    fun findIndices(numbers: IntArray, target: Int): List<Int> {
        return numbers.indices.filter { numbers[it] == target }
    }
    
    val searchArray = intArrayOf(1, 2, 3, 2, 4, 2, 5)
    val indices = findIndices(searchArray, 2)
    println("   Pattern 3 - Array searching:")
    println("   Array: ${searchArray.contentToString()}")
    println("   Indices of 2: $indices")
    
    // Pattern 4: Array rotation
    fun rotateArray(array: IntArray, positions: Int): IntArray {
        val rotated = array.copyOf()
        val n = array.size
        val k = positions % n
        
        for (i in 0 until n) {
            rotated[(i + k) % n] = array[i]
        }
        return rotated
    }
    
    val originalArray = intArrayOf(1, 2, 3, 4, 5)
    val rotatedArray = rotateArray(originalArray, 2)
    println("   Pattern 4 - Array rotation:")
    println("   Original: ${originalArray.contentToString()}")
    println("   Rotated by 2: ${rotatedArray.contentToString()}")
    
    // Pattern 5: Array validation
    fun validateArray(array: IntArray): Boolean {
        return array.isNotEmpty() && 
               array.all { it >= 0 } && 
               array.distinct().size == array.size
    }
    
    val validArray = intArrayOf(1, 2, 3, 4, 5)
    val invalidArray = intArrayOf(1, 2, 2, 4, 5)
    println("   Pattern 5 - Array validation:")
    println("   Valid array: ${validateArray(validArray)}")
    println("   Invalid array: ${validateArray(invalidArray)}")
    
    // Pattern 6: Array statistics
    fun getArrayStats(array: IntArray): Map<String, Any> {
        return mapOf(
            "sum" to array.sum(),
            "average" to array.average(),
            "min" to (array.minOrNull() ?: 0),
            "max" to (array.maxOrNull() ?: 0),
            "count" to array.size
        )
    }
    
    val statsArray = intArrayOf(10, 20, 30, 40, 50)
    val stats = getArrayStats(statsArray)
    println("   Pattern 6 - Array statistics:")
    println("   Array: ${statsArray.contentToString()}")
    println("   Stats: $stats")
    
    println()
}

/**
 * ARRAYS SUMMARY:
 *
 * ARRAY CREATION:
 * - arrayOf(): Creates array with specified elements
 * - Array(size) { init }: Creates array with constructor
 * - Primitive arrays: intArrayOf(), doubleArrayOf(), etc.
 * - Empty arrays: arrayOf(), intArrayOf()
 * - Nullable arrays: arrayOfNulls()
 *
 * ARRAY ACCESS:
 * - Index access: array[index]
 * - Safe access: Check bounds before access
 * - get() and set() methods
 * - First and last elements
 *
 * ARRAY OPERATIONS:
 * - Concatenation: array1 + array2
 * - Slicing: sliceArray()
 * - Copying: copyOf(), copyOfRange()
 * - Filling: fill()
 * - Reversal: reversedArray()
 *
 * ARRAY ITERATION:
 * - For loop with indices
 * - For-each loop
 * - For-each with index: withIndex()
 * - While loop
 * - ForEach functions
 * - Backwards iteration
 * - Step iteration
 *
 * ARRAY TRANSFORMATIONS:
 * - Map: Transform each element
 * - Filter: Select elements based on condition
 * - FlatMap: Flatten nested arrays
 * - Reduce: Combine elements into single value
 * - Fold: Reduce with initial value
 *
 * ARRAY FILTERING:
 * - Basic filtering with conditions
 * - Searching: find(), findLast()
 * - Index searching: indexOfFirst(), indexOfLast()
 * - Existence: any(), all(), none()
 * - Counting: count()
 * - Partitioning: partition()
 *
 * MULTI-DIMENSIONAL ARRAYS:
 * - 2D arrays: arrayOf(arrayOf(...))
 * - 3D arrays: Nested arrayOf()
 * - Jagged arrays: Different sizes
 * - Deep operations: contentDeepToString()
 *
 * ARRAY COMPARISON:
 * - Content comparison: contentEquals()
 * - Deep comparison: contentDeepEquals()
 * - Sorting: sortedArray(), sortedArrayDescending()
 * - Custom sorting: sortedBy(), sortedByDescending()
 * - In-place sorting: sort()
 *
 * ARRAY UTILITIES:
 * - Properties: size, indices, lastIndex
 * - Statistics: sum(), average(), min(), max()
 * - Conversion: toIntArray(), toTypedArray()
 * - Joining: joinToString()
 * - Chunking: chunked()
 * - Windowing: windowed()
 *
 * BEST PRACTICES:
 * - Use primitive arrays for better performance
 * - Check bounds before array access
 * - Use appropriate array type for your data
 * - Consider using collections for dynamic sizing
 * - Use array utilities for common operations
 * - Prefer immutable operations when possible
 * - Use meaningful variable names for arrays
 * - Consider memory usage for large arrays
 */
