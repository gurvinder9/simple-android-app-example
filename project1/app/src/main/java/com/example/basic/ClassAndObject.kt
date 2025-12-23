package com.example.basic

// ============================================
// ACCESS MODIFIERS IN KOTLIN
// ============================================
/*
 * Kotlin has 4 visibility modifiers:
 * 
 * 1. PUBLIC (default) - Visible everywhere
 * 2. PRIVATE - Visible inside the class/file only
 * 3. PROTECTED - Visible in the class and its subclasses
 * 4. INTERNAL - Visible within the same module
 */

// ============================================
// 1. BASIC CLASS
// ============================================
/*
 * Classes are blueprints for creating objects
 * Use 'class' keyword to define a class
 * If no visibility modifier is specified, it's PUBLIC by default
 */
class Person {
    // Properties (variables in a class)
    var name: String = ""
    var age: Int = 0
    
    // Member function (method)
    fun introduce() {
        println("Hi, I'm $name and I'm $age years old.")
    }
}

// ============================================
// 2. CLASS WITH PRIMARY CONSTRUCTOR
// ============================================
/*
 * Primary constructor is part of the class header
 * Parameters can be properties using 'var' or 'val'
 * 'val' makes the property read-only (immutable)
 * 'var' makes the property mutable
 */
class BasicStudent(val name: String, var grade: Int) {
    // Init block runs when object is created
    init {
        println("Student $name created with grade $grade")
    }
    
    fun displayInfo() {
        println("Student: $name, Grade: $grade")
    }
}

// ============================================
// 3. ACCESS MODIFIERS IN CLASS
// ============================================
class BankAccount(private val accountNumber: String, private var balance: Double) {
    /*
     * PRIVATE properties can only be accessed within this class
     * External code cannot directly access accountNumber or balance
     */
    
    // PUBLIC function (default) - can be called from anywhere
    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Deposited: $$amount. New balance: $$balance")
        }
    }
    
    // PUBLIC function to access private property safely
    fun getBalance(): Double {
        return balance
    }
    
    // PRIVATE function - only accessible within this class
    private fun validateTransaction(amount: Double): Boolean {
        return amount > 0 && amount <= balance
    }
    
    fun withdraw(amount: Double) {
        if (validateTransaction(amount)) {
            balance -= amount
            println("Withdrawn: $$amount. New balance: $$balance")
        } else {
            println("Invalid transaction")
        }
    }
}

// ============================================
// 4. SECONDARY CONSTRUCTORS
// ============================================
/*
 * Secondary constructors provide alternative ways to create objects
 * Must call the primary constructor using 'this()'
 */
class Rectangle(val width: Double, val height: Double) {
    var area: Double = 0.0
    
    init {
        area = width * height
    }
    
    // Secondary constructor for creating a square
    constructor(side: Double) : this(side, side) {
        println("Created a square with side $side")
    }
    
    fun displayDimensions() {
        println("Rectangle: ${width}x$height, Area: $area")
    }
}

// ============================================
// 5. INHERITANCE AND PROTECTED MODIFIER
// ============================================
/*
 * Use 'open' keyword to make class inheritable
 * By default, classes are final (cannot be inherited)
 * PROTECTED members are accessible in the class and subclasses
 */
open class BasicAnimal(protected val name: String, protected var age: Int) {
    // PROTECTED - accessible in this class and subclasses
    protected fun sleep() {
        println("$name is sleeping")
    }
    
    // OPEN function can be overridden in subclasses
    open fun makeSound() {
        println("$name makes a sound")
    }
    
    // PUBLIC function
    fun displayInfo() {
        println("Animal: $name, Age: $age")
    }
}

// BasicDog inherits from BasicAnimal
class BasicDog(name: String, age: Int, private val breed: String) : BasicAnimal(name, age) {
    // Override function from parent class
    override fun makeSound() {
        println("$name barks: Woof! Woof!")
    }
    
    fun play() {
        println("$name the $breed is playing")
        sleep() // Can access protected function from parent class
    }
}

// ============================================
// 6. DATA CLASS
// ============================================
/*
 * Data classes are used to hold data
 * Automatically generates: equals(), hashCode(), toString(), copy()
 * All parameters must be 'val' or 'var'
 */
data class Book(
    val title: String,
    val author: String,
    val year: Int,
    var isAvailable: Boolean = true
)

// ============================================
// 7. OBJECT DECLARATION (SINGLETON)
// ============================================
/*
 * Object is a singleton - only one instance exists
 * Created lazily when first accessed
 * Useful for utility classes or global state
 */
object DatabaseConfig {
    private const val DB_NAME = "MyDatabase"
    private const val DB_VERSION = 1
    
    fun getConnectionString(): String {
        return "jdbc:mysql://localhost:3306/$DB_NAME"
    }
    
    fun getDatabaseInfo() {
        println("Database: $DB_NAME, Version: $DB_VERSION")
    }
}

// ============================================
// 8. COMPANION OBJECT
// ============================================
/*
 * Companion objects belong to the class, not instances
 * Similar to static members in Java
 * Can access private members of the class
 */
class MathOperations {
    companion object {
        // Constant
        const val PI = 3.14159
        
        // Companion object functions (like static methods)
        fun add(a: Int, b: Int): Int {
            return a + b
        }
        
        fun multiply(a: Int, b: Int): Int {
            return a * b
        }
        
        fun circleArea(radius: Double): Double {
            return PI * radius * radius
        }
    }
}

// ============================================
// 9. INTERNAL MODIFIER
// ============================================
/*
 * INTERNAL makes declarations visible within the same module
 * A module is a set of Kotlin files compiled together
 */
internal class InternalHelper {
    internal fun helperFunction() {
        println("This is visible within the same module")
    }
}

// ============================================
// 10. ABSTRACT CLASS
// ============================================
/*
 * Abstract classes cannot be instantiated
 * Can have abstract members (must be implemented by subclasses)
 * Can have concrete members (with implementation)
 */
abstract class BasicShape {
    abstract val name: String
    abstract fun calculateArea(): Double
    
    // Concrete function in abstract class
    fun describe() {
        println("This is a $name with area: ${calculateArea()}")
    }
}

class BasicCircle(val radius: Double) : BasicShape() {
    override val name: String = "Circle"
    
    override fun calculateArea(): Double {
        return 3.14159 * radius * radius
    }
}

class BasicSquare(val side: Double) : BasicShape() {
    override val name: String = "Square"
    
    override fun calculateArea(): Double {
        return side * side
    }
}

// ============================================
// 11. INTERFACE
// ============================================
/*
 * Interfaces define contracts that classes must implement
 * Can have abstract functions and properties
 * Can have default implementations
 */
interface Drawable {
    // Abstract property
    val color: String
    
    // Abstract function
    fun draw()
    
    // Function with default implementation
    fun describe() {
        println("Drawing with color: $color")
    }
}

class Pencil(override val color: String) : Drawable {
    override fun draw() {
        println("Drawing with $color pencil")
    }
}

// ============================================
// 12. OBJECT EXPRESSION (ANONYMOUS OBJECT)
// ============================================
/*
 * Object expressions create anonymous objects
 * Useful for one-time implementations
 */
interface ClickListener {
    fun onClick()
}

fun createButton() {
    // Anonymous object implementing interface
    val clickListener = object : ClickListener {
        override fun onClick() {
            println("Button clicked!")
        }
    }
    
    clickListener.onClick()
}

// ============================================
// 13. GETTERS AND SETTERS
// ============================================
class Temperature {
    // Custom getter and setter
    var celsius: Double = 0.0
        set(value) {
            // Custom validation in setter
            if (value >= -273.15) {
                field = value
            } else {
                println("Temperature cannot be below absolute zero")
            }
        }
    
    // Computed property (only getter)
    val fahrenheit: Double
        get() = celsius * 9/5 + 32
    
    val kelvin: Double
        get() = celsius + 273.15
}

// ============================================
// 14. NESTED AND INNER CLASSES
// ============================================
class Outer {
    private val outerProperty = "Outer"
    
    // Nested class (static by default in Kotlin)
    class Nested {
        fun display() {
            println("I'm a nested class")
            // Cannot access outerProperty
        }
    }
    
    // Inner class (can access outer class members)
    inner class Inner {
        fun display() {
            println("I'm an inner class and can access: $outerProperty")
        }
    }
}

// ============================================
// MAIN FUNCTION - EXAMPLES
// ============================================
fun main() {
    val myCar = Cars("BMW", 2025);

    println("Cars is ${myCar.displayCarDetail()}")

    println("========== KOTLIN CLASSES AND OBJECTS ==========\n")
    
    // 1. Basic Class
    println("--- Basic Class ---")
    val person = Person()
    person.name = "Alice"
    person.age = 25
    person.introduce()
    
    // 2. Primary Constructor
    println("\n--- Primary Constructor ---")
    val student = BasicStudent("Bob", 85)
    student.displayInfo()
    // student.name = "Robert" // Error: val cannot be reassigned
    student.grade = 90 // OK: var can be reassigned
    student.displayInfo()
    
    // 3. Access Modifiers
    println("\n--- Access Modifiers (Private) ---")
    val account = BankAccount("ACC123", 1000.0)
    account.deposit(500.0)
    account.withdraw(200.0)
    println("Current balance: $${account.getBalance()}")
    // account.balance = 5000.0 // Error: balance is private
    // account.validateTransaction(100.0) // Error: private function
    
    // 4. Secondary Constructor
    println("\n--- Secondary Constructor ---")
    val rectangle = Rectangle(5.0, 3.0)
    rectangle.displayDimensions()
    val square = Rectangle(4.0) // Using secondary constructor
    square.displayDimensions()
    
    // 5. Inheritance and Protected
    println("\n--- Inheritance and Protected ---")
    val dog = BasicDog("Buddy", 3, "Golden Retriever")
    dog.displayInfo()
    dog.makeSound()
    dog.play()
    // dog.sleep() // Error: protected function
    
    // 6. Data Class
    println("\n--- Data Class ---")
    val book1 = Book("1984", "George Orwell", 1949)
    val book2 = Book("1984", "George Orwell", 1949)
    println(book1) // Automatic toString()
    println("book1 == book2: ${book1 == book2}") // Automatic equals()
    val book3 = book1.copy(year = 2020) // copy() function
    println("Copied book: $book3")
    
    // 7. Object Declaration (Singleton)
    println("\n--- Object Declaration (Singleton) ---")
    DatabaseConfig.getDatabaseInfo()
    println("Connection: ${DatabaseConfig.getConnectionString()}")
    
    // 8. Companion Object
    println("\n--- Companion Object ---")
    println("PI = ${MathOperations.PI}")
    println("Add: ${MathOperations.add(5, 3)}")
    println("Multiply: ${MathOperations.multiply(4, 7)}")
    println("Circle area (r=5): ${MathOperations.circleArea(5.0)}")
    
    // 9. Internal Modifier
    println("\n--- Internal Modifier ---")
    val helper = InternalHelper()
    helper.helperFunction()
    
    // 10. Abstract Class
    println("\n--- Abstract Class ---")
    val circle = BasicCircle(5.0)
    val square2 = BasicSquare(4.0)
    circle.describe()
    square2.describe()
    
    // 11. Interface
    println("\n--- Interface ---")
    val pencil = Pencil("Blue")
    pencil.draw()
    pencil.describe()
    
    // 12. Object Expression
    println("\n--- Object Expression (Anonymous Object) ---")
    createButton()
    
    // Another example of object expression
    val tempClickListener = object : ClickListener {
        override fun onClick() {
            println("Temporary button clicked!")
        }
    }
    tempClickListener.onClick()
    
    // 13. Getters and Setters
    println("\n--- Custom Getters and Setters ---")
    val temp = Temperature()
    temp.celsius = 25.0
    println("Temperature: ${temp.celsius}°C = ${temp.fahrenheit}°F = ${temp.kelvin}K")
    temp.celsius = -300.0 // Will trigger validation
    
    // 14. Nested and Inner Classes
    println("\n--- Nested and Inner Classes ---")
    val nested = Outer.Nested()
    nested.display()
    
    val outer = Outer()
    val inner = outer.Inner()
    inner.display()
    
    // Summary of Access Modifiers
    println("\n--- Access Modifiers Summary ---")
    println("""
        PUBLIC (default):  Visible everywhere
        PRIVATE:           Visible in the same class/file only
        PROTECTED:         Visible in the class and subclasses
        INTERNAL:          Visible within the same module
    """.trimIndent())
    
    println("\n========== END OF EXAMPLES ==========")
}

