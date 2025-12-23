/**
 * Kotlin Variables Tutorial
 *
 * This file demonstrates the different types of variables in Kotlin
 * and how to use them effectively.
 */

 const val PI = 3.144
fun main() {
    println("=== Kotlin Variables Tutorial ===\n")

    // 1. VARIABLE DECLARATION
    println("1. Variable Declaration:")
    println("   Variables in Kotlin are declared using 'var' (mutable) or 'val' (immutable)")
    println("PI is $PI")

    // 2. MUTABLE VARIABLES (var)
    println("\n2. Mutable Variables (var):")
    var mutableName = "John"
    var mutableAge = 25
    var mutableSalary = 50000.50

    println("   Initial values:")
    println("   Name: $mutableName, Age: $mutableAge, Salary: $mutableSalary")

    // Changing values
    mutableName = "Jane"
    mutableAge = 30
    mutableSalary = 60000.75

    println("   After modification:")
    println("   Name: $mutableName, Age: $mutableAge, Salary: $mutableSalary")

    // 3. IMMUTABLE VARIABLES (val)
    println("\n3. Immutable Variables (val):")
    val immutableName = "Alice"
    val immutableAge = 28
    val immutableId = 12345

    println("   Immutable values:")
    println("   Name: $immutableName, Age: $immutableAge, ID: $immutableId")

    // Uncommenting the line below would cause a compilation error:
    // immutableName = "Bob" // Error: Val cannot be reassigned

    // 4. TYPE INFERENCE
    println("\n4. Type Inference:")
    val inferredString = "Hello World"        // Inferred as String
    val inferredInt = 42                      // Inferred as Int
    val inferredDouble = 3.14                 // Inferred as Double
    val inferredBoolean = true                // Inferred as Boolean

    println("   Inferred types:")
    println("   String: $inferredString")
    println("   Int: $inferredInt")
    println("   Double: $inferredDouble")
    println("   Boolean: $inferredBoolean")

    // 5. EXPLICIT TYPE DECLARATION
    println("\n5. Explicit Type Declaration:")
    val explicitString: String = "Explicit String"
    val explicitInt: Int = 100
    val explicitFloat: Float = 2.5f
    val explicitLong: Long = 1000000L
    val explicitChar: Char = 'A'

    println("   Explicit types:")
    println("   String: $explicitString")
    println("   Int: $explicitInt")
    println("   Float: $explicitFloat")
    println("   Long: $explicitLong")
    println("   Char: $explicitChar")

    // 6. NULLABLE VARIABLES
    println("\n6. Nullable Variables:")
    var nullableString: String? = "Can be null"
    var nullableInt: Int? = null

    println("   Nullable values:")
    println("   String: $nullableString")
    println("   Int: $nullableInt")

    // Safe call operator
    println("   Length of nullable string: ${nullableString?.length}")
    println("   Length of null string: ${nullableInt?.toString()?.length}")

    // 7. LATE INITIALIZATION
    println("\n7. Late Initialization:")
    lateinit var lateInitString: String

    // Initialize later
    lateInitString = "Initialized later"
    println("   Late initialized string: $lateInitString")

    // 8. CONSTANTS
    println("\n8. Constants:")
    val PI = 3.14159
    val MAX_SIZE = 1000

    println("   Constants:")
    println("   PI: $PI")
    println("   MAX_SIZE: $MAX_SIZE")

    // 9. VARIABLE SCOPE
    println("\n9. Variable Scope:")
    demonstrateScope()

    // 10. BEST PRACTICES
    println("\n10. Best Practices:")
    demonstrateBestPractices()
}

private fun demonstrateScope() {
    val localVariable = "I'm local to this function"
    println("   Local variable: $localVariable")

    // Block scope
    if (true) {
        val blockVariable = "I'm in a block"
        println("   Block variable: $blockVariable")
    }
    // blockVariable is not accessible here
}

private fun demonstrateBestPractices() {
    println("   ✓ Use 'val' by default, 'var' only when necessary")
    println("   ✓ Prefer type inference when the type is obvious")
    println("   ✓ Use meaningful variable names")
    println("   ✓ Initialize variables as close to usage as possible")
    println("   ✓ Use 'const val' for compile-time constants")
    println("   ✓ Use 'lateinit var' for properties that will be initialized later")
    println("   ✓ Handle nullable types safely with ?. and ?:")
}

/**
 * VARIABLE TYPES SUMMARY:
 *
 * 1. var - Mutable variable (can be reassigned)
 * 2. val - Immutable variable (read-only, cannot be reassigned)
 * 3. const val - Compile-time constant
 * 4. lateinit var - Late-initialized non-nullable property
 *
 * COMMON DATA TYPES:
 * - String: Text data
 * - Int: Integer numbers
 * - Double: Floating-point numbers
 * - Float: Single-precision floating-point
 * - Long: Large integers
 * - Boolean: True/false values
 * - Char: Single characters
 *
 * NULL SAFETY:
 * - Use ? to make types nullable
 * - Use ?. for safe calls
 * - Use ?: for null coalescing
 * - Use !! for non-null assertions (use carefully)
 */