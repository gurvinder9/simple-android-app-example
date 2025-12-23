package com.example.basic

/*
 * ============================================
 * INTERFACES IN KOTLIN - BEGINNER'S GUIDE
 * ============================================
 * 
 * WHAT IS AN INTERFACE?
 * ---------------------
 * Think of an interface as a "CONTRACT" or "PROMISE"
 * 
 * Real-world analogy:
 * - Imagine a "Driver's License"
 * - Anyone with a license MUST know how to: drive, park, follow traffic rules
 * - The license doesn't teach you HOW to do these things
 * - It just says you MUST be able to do them
 * - Different people drive differently, but all must follow the contract
 * 
 * In programming:
 * - Interface defines WHAT a class should do
 * - NOT HOW it should do it (that's up to the class)
 * - A class "implements" an interface = signs the contract
 * - Multiple classes can implement the same interface
 * 
 * SIMPLE EXPLANATION:
 * -------------------
 * 📋 Interface = A list of things a class MUST do (contract)
 * 📝 Class = Implements the interface and decides HOW to do those things
 * 
 * WHY USE INTERFACES?
 * -------------------
 * 1. FLEXIBILITY: Different classes can do the same thing differently
 * 2. MULTIPLE IMPLEMENTATION: A class can implement multiple interfaces
 * 3. LOOSE COUPLING: Code depends on contracts, not specific implementations
 * 4. TESTABILITY: Easy to swap implementations for testing
 * 
 * INTERFACE vs ABSTRACT CLASS:
 * ----------------------------
 * Interface:
 * - Pure contract (what to do)
 * - Multiple interfaces allowed
 * - No state (no instance variables with values)
 * - All properties must be overridden
 * 
 * Abstract Class:
 * - Partial implementation (what & how)
 * - Single inheritance only
 * - Can have state (properties with values)
 * - Can have concrete methods
 * 
 * KEY RULES:
 * ----------
 * 1. Use 'interface' keyword to declare
 * 2. Methods are abstract by default (no body)
 * 3. Can have default implementations (with body)
 * 4. Use ':' to implement an interface
 * 5. Can implement multiple interfaces with ','
 * 6. Must override all abstract members
 */

// ============================================
// EXAMPLE 1: BASIC INTERFACE (Simple Understanding)
// ============================================

/*
 * Basic interface for drawable things
 * Anything that implements this MUST be able to draw itself
 */
interface InterfaceDrawable {
    // Abstract method - no implementation
    // Every class MUST provide its own implementation
    fun draw()
}

/*
 * Circle implements Drawable
 * It MUST implement the draw() method
 */
class InterfaceCircle(val radius: Double) : InterfaceDrawable {
    // MUST implement draw()
    override fun draw() {
        println("⭕ Drawing a circle with radius $radius")
    }
    
    fun calculateArea(): Double {
        return 3.14159 * radius * radius
    }
}

/*
 * Square also implements Drawable
 * It implements draw() differently than Circle
 */
class InterfaceSquare(val side: Double) : InterfaceDrawable {
    // Same method name, different implementation
    override fun draw() {
        println("⬜ Drawing a square with side $side")
    }
}

/*
 * Text also implements Drawable
 * Completely different from shapes, but can still be drawn
 */
class InterfaceText(val content: String) : InterfaceDrawable {
    override fun draw() {
        println("📝 Drawing text: \"$content\"")
    }
}

// ============================================
// EXAMPLE 2: INTERFACE WITH PROPERTIES
// ============================================

/*
 * Interface can have properties (but no backing field)
 * Implementing class must provide the value
 */
interface InterfaceAnimal {
    // Abstract property - must be overridden
    val name: String
    val species: String
    
    // Abstract method
    fun makeSound()
    
    // Method with default implementation
    fun sleep() {
        println("💤 $name is sleeping... Zzz")
    }
}

class InterfaceDog(override val name: String) : InterfaceAnimal {
    override val species: String = "Canine"
    
    override fun makeSound() {
        println("🐕 $name barks: Woof! Woof!")
    }
    
    fun fetch() {
        println("🐕 $name is fetching the ball!")
    }
}

class InterfaceCat(override val name: String) : InterfaceAnimal {
    override val species: String = "Feline"
    
    override fun makeSound() {
        println("🐱 $name meows: Meow! Meow!")
    }
    
    fun scratch() {
        println("🐱 $name is scratching the furniture!")
    }
}

// ============================================
// EXAMPLE 3: MULTIPLE INTERFACE IMPLEMENTATION
// ============================================

/*
 * A class can implement multiple interfaces
 * This is POWERFUL - you can't inherit from multiple classes!
 */

interface Swimmable {
    fun swim() {
        println("🏊 Swimming in water...")
    }
}

interface Flyable {
    fun fly() {
        println("✈️  Flying in the sky...")
    }
}

interface Walkable {
    fun walk() {
        println("🚶 Walking on ground...")
    }
}

// Duck can do all three!
class InterfaceDuck(val name: String) : Swimmable, Flyable, Walkable {
    fun introduce() {
        println("🦆 Hi! I'm $name the duck!")
    }
    
    override fun swim() {
        println("🦆 $name is swimming gracefully!")
    }
    
    override fun fly() {
        println("🦆 $name is flying across the pond!")
    }
    
    override fun walk() {
        println("🦆 $name is waddling on the ground!")
    }
}

// Fish can only swim
class InterfaceFish(val name: String) : Swimmable {
    override fun swim() {
        println("🐟 $name is swimming underwater!")
    }
}

// Bird can fly and walk
class InterfaceBird(val name: String) : Flyable, Walkable {
    override fun fly() {
        println("🐦 $name is soaring high!")
    }
    
    override fun walk() {
        println("🐦 $name is hopping around!")
    }
}

// ============================================
// EXAMPLE 4: REAL-WORLD - PAYMENT PROCESSING
// ============================================

/*
 * Interface for payment methods
 * All payment methods must be able to process payments
 */
interface InterfacePaymentProcessor {
    val processorName: String
    
    // Abstract method - must be implemented
    fun processPayment(amount: Double): Boolean
    
    // Default implementation - can be overridden
    fun validateAmount(amount: Double): Boolean {
        return amount > 0
    }
    
    // Method with logic
    fun printReceipt(amount: Double) {
        println("═══════════════════════════")
        println("     PAYMENT RECEIPT")
        println("═══════════════════════════")
        println("Processor: $processorName")
        println("Amount: $$amount")
        println("═══════════════════════════")
    }
}

class CreditCardProcessor(override val processorName: String = "Credit Card") : InterfacePaymentProcessor {
    override fun processPayment(amount: Double): Boolean {
        if (!validateAmount(amount)) {
            println("❌ Invalid amount!")
            return false
        }
        
        println("💳 Processing credit card payment of $$amount...")
        println("✅ Payment successful via credit card!")
        printReceipt(amount)
        return true
    }
}

class PayPalProcessor(override val processorName: String = "PayPal") : InterfacePaymentProcessor {
    override fun processPayment(amount: Double): Boolean {
        if (!validateAmount(amount)) {
            println("❌ Invalid amount!")
            return false
        }
        
        println("💙 Processing PayPal payment of $$amount...")
        println("✅ Payment successful via PayPal!")
        printReceipt(amount)
        return true
    }
}

class CryptoProcessor(override val processorName: String = "Cryptocurrency") : InterfacePaymentProcessor {
    override fun processPayment(amount: Double): Boolean {
        if (!validateAmount(amount)) {
            println("❌ Invalid amount!")
            return false
        }
        
        println("₿ Processing crypto payment of $$amount...")
        println("✅ Payment successful via cryptocurrency!")
        printReceipt(amount)
        return true
    }
    
    // Override default validation with custom logic
    override fun validateAmount(amount: Double): Boolean {
        // Crypto might have minimum transaction amount
        return amount >= 10.0
    }
}

// ============================================
// EXAMPLE 5: INTERFACE INHERITANCE
// ============================================

/*
 * Interfaces can inherit from other interfaces
 * This creates a hierarchy of contracts
 */

interface InterfaceVehicle {
    val vehicleName: String
    
    fun start()
    fun stop()
}

// AdvancedVehicle inherits from Vehicle and adds more requirements
interface AdvancedInterfaceVehicle : InterfaceVehicle {
    fun enableAutoPilot()
    fun displayDashboard()
}

class TeslaInterfaceCar(override val vehicleName: String) : AdvancedInterfaceVehicle {
    private var isRunning = false
    private var autoPilot = false
    
    override fun start() {
        isRunning = true
        println("🚗 $vehicleName: Electric motor started silently...")
    }
    
    override fun stop() {
        isRunning = false
        autoPilot = false
        println("🚗 $vehicleName: Motor stopped")
    }
    
    override fun enableAutoPilot() {
        if (isRunning) {
            autoPilot = true
            println("🤖 $vehicleName: Autopilot enabled! Hands-free driving!")
        } else {
            println("❌ Start the car first!")
        }
    }
    
    override fun displayDashboard() {
        println("╔════════════════════════════╗")
        println("   🚗 $vehicleName Dashboard")
        println("╠════════════════════════════╣")
        println("   Engine: ${if (isRunning) "ON" else "OFF"}")
        println("   Autopilot: ${if (autoPilot) "ACTIVE" else "OFF"}")
        println("╚════════════════════════════╝")
    }
}

// ============================================
// EXAMPLE 6: CLICKABLE INTERFACE (Android-like)
// ============================================

/*
 * Similar to how Android UI elements work
 * Any UI element can be clickable
 */
interface InterfaceClickable {
    fun onClick()
    
    fun onLongClick() {
        println("Long click detected (default behavior)")
    }
}

class InterfaceButton(val label: String) : InterfaceClickable {
    override fun onClick() {
        println("🔘 Button '$label' clicked!")
        performAction()
    }
    
    override fun onLongClick() {
        println("🔘 Button '$label' long-pressed!")
        showTooltip()
    }
    
    private fun performAction() {
        println("   ➜ Executing button action...")
    }
    
    private fun showTooltip() {
        println("   ℹ️  Showing tooltip for '$label'")
    }
}

class InterfaceImage(val imageName: String) : InterfaceClickable {
    override fun onClick() {
        println("🖼️  Image '$imageName' clicked!")
        openFullScreen()
    }
    
    private fun openFullScreen() {
        println("   ➜ Opening image in full screen...")
    }
}

// ============================================
// EXAMPLE 7: DATABASE OPERATIONS
// ============================================

/*
 * Interface for database operations
 * Different databases implement the same interface
 */
interface InterfaceDatabase {
    val databaseName: String
    
    fun connect(): Boolean
    fun disconnect()
    fun executeQuery(query: String): List<String>
    
    // Default logging
    fun log(message: String) {
        println("📝 [$databaseName] $message")
    }
}

class MySQLInterfaceDatabase(override val databaseName: String = "MySQL") : InterfaceDatabase {
    private var isConnected = false
    
    override fun connect(): Boolean {
        println("🔌 Connecting to MySQL database...")
        isConnected = true
        log("Connected successfully!")
        return true
    }
    
    override fun disconnect() {
        println("🔌 Disconnecting from MySQL...")
        isConnected = false
        log("Disconnected")
    }
    
    override fun executeQuery(query: String): List<String> {
        if (!isConnected) {
            log("ERROR: Not connected!")
            return emptyList()
        }
        
        log("Executing query: $query")
        return listOf("Result 1", "Result 2", "Result 3")
    }
}

class MongoInterfaceDatabase(override val databaseName: String = "MongoDB") : InterfaceDatabase {
    private var isConnected = false
    
    override fun connect(): Boolean {
        println("🔌 Connecting to MongoDB database...")
        isConnected = true
        log("Connected successfully!")
        return true
    }
    
    override fun disconnect() {
        println("🔌 Disconnecting from MongoDB...")
        isConnected = false
        log("Disconnected")
    }
    
    override fun executeQuery(query: String): List<String> {
        if (!isConnected) {
            log("ERROR: Not connected!")
            return emptyList()
        }
        
        log("Executing NoSQL query: $query")
        return listOf("Document 1", "Document 2")
    }
}

// ============================================
// EXAMPLE 8: COMPARABLE INTERFACE
// ============================================

/*
 * Interface for comparing objects
 * Useful for sorting
 */
interface InterfaceComparable {
    fun compareTo(other: InterfaceComparable): Int
}

class InterfaceStudent(val name: String, val grade: Int) : InterfaceComparable {
    override fun compareTo(other: InterfaceComparable): Int {
        if (other is InterfaceStudent) {
            return this.grade.compareTo(other.grade)
        }
        return 0
    }
    
    override fun toString(): String {
        return "$name (Grade: $grade)"
    }
}

// ============================================
// MAIN FUNCTION - DEMONSTRATION
// ============================================
fun main() {
    println("╔════════════════════════════════════════════╗")
    println("║      INTERFACES - BEGINNER'S GUIDE        ║")
    println("╚════════════════════════════════════════════╝\n")
    
    // ========================================
    // EXAMPLE 1: Basic Interface
    // ========================================
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 1: Basic Interface (Drawable) ✏️")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
    
    val circle = InterfaceCircle(5.0)
    circle.draw()
    println("Area: ${circle.calculateArea()}")
    
    println()
    val square = InterfaceSquare(4.0)
    square.draw()
    
    println()
    val text = InterfaceText("Hello, Kotlin!")
    text.draw()
    
    // Using interface type (polymorphism)
    println("\n--- Using Interface Type ---")
    val drawables: List<InterfaceDrawable> = listOf(
        InterfaceCircle(3.0),
        InterfaceSquare(5.0),
        InterfaceText("Interface Example")
    )
    
    println("Drawing all drawable objects:")
    for (drawable in drawables) {
        drawable.draw()
    }
    
    // ========================================
    // EXAMPLE 2: Interface with Properties
    // ========================================
    println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 2: Interface with Properties 🐾")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
    
    val dog = InterfaceDog("Max")
    println("Name: ${dog.name}, Species: ${dog.species}")
    dog.makeSound()
    dog.fetch()
    dog.sleep()  // Default implementation from interface
    
    println()
    val cat = InterfaceCat("Luna")
    println("Name: ${cat.name}, Species: ${cat.species}")
    cat.makeSound()
    cat.scratch()
    cat.sleep()  // Default implementation from interface
    
    // ========================================
    // EXAMPLE 3: Multiple Interfaces
    // ========================================
    println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 3: Multiple Interface Implementation 🦆")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
    
    val duck = InterfaceDuck("Donald")
    duck.introduce()
    duck.swim()
    duck.fly()
    duck.walk()
    println("✅ Duck can do everything!")
    
    println()
    val fish = InterfaceFish("Nemo")
    fish.swim()
    println("✅ Fish can only swim")
    
    println()
    val bird = InterfaceBird("Tweety")
    bird.fly()
    bird.walk()
    println("✅ Bird can fly and walk")
    
    // ========================================
    // EXAMPLE 4: Payment Processing
    // ========================================
    println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 4: Payment Processing 💳")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
    
    val creditCard = CreditCardProcessor()
    creditCard.processPayment(150.0)
    
    println()
    val paypal = PayPalProcessor()
    paypal.processPayment(75.50)
    
    println()
    val crypto = CryptoProcessor()
    crypto.processPayment(250.0)
    
    // Try invalid amount with crypto (minimum $10)
    println("\n--- Testing validation ---")
    crypto.processPayment(5.0)
    
    // Using interface type for flexibility
    println("\n--- Processing multiple payments ---")
    val processors: List<InterfacePaymentProcessor> = listOf(
        CreditCardProcessor(),
        PayPalProcessor(),
        CryptoProcessor()
    )
    
    val amounts = listOf(100.0, 200.0, 50.0)
    for ((index, processor) in processors.withIndex()) {
        println("\nPayment ${index + 1}:")
        processor.processPayment(amounts[index])
    }
    
    // ========================================
    // EXAMPLE 5: Interface Inheritance
    // ========================================
    println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 5: Interface Inheritance 🚗")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
    
    val tesla = TeslaInterfaceCar("Model S")
    tesla.displayDashboard()
    
    println()
    tesla.start()
    tesla.displayDashboard()
    
    println()
    tesla.enableAutoPilot()
    tesla.displayDashboard()
    
    println()
    tesla.stop()
    
    // ========================================
    // EXAMPLE 6: Clickable Interface
    // ========================================
    println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 6: Clickable UI Elements 🖱️")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
    
    val submitButton = InterfaceButton("Submit")
    submitButton.onClick()
    submitButton.onLongClick()
    
    println()
    val profileImage = InterfaceImage("profile_photo.jpg")
    profileImage.onClick()
    
    // ========================================
    // EXAMPLE 7: Database Operations
    // ========================================
    println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 7: Database Operations 🗄️")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
    
    val mysql = MySQLInterfaceDatabase()
    mysql.connect()
    val results1 = mysql.executeQuery("SELECT * FROM users")
    println("Results: $results1")
    mysql.disconnect()
    
    println()
    val mongo = MongoInterfaceDatabase()
    mongo.connect()
    val results2 = mongo.executeQuery("db.users.find()")
    println("Results: $results2")
    mongo.disconnect()
    
    // Using interface type - can switch databases easily!
    println("\n--- Using Interface Type ---")
    val database: InterfaceDatabase = MySQLInterfaceDatabase()
    database.connect()
    database.executeQuery("SELECT * FROM products")
    database.disconnect()
    
    // ========================================
    // EXAMPLE 8: Comparable Interface
    // ========================================
    println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 8: Comparable Interface (Sorting) 📊")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
    
    val students = listOf(
        InterfaceStudent("Alice", 85),
        InterfaceStudent("Bob", 92),
        InterfaceStudent("Charlie", 78),
        InterfaceStudent("Diana", 95)
    )
    
    println("Original list:")
    students.forEach { println("  $it") }
    
    println("\nSorted by grade:")
    val sorted = students.sortedBy { it.grade }
    sorted.forEach { println("  $it") }
    
    // ========================================
    // WHY INTERFACES ARE POWERFUL
    // ========================================
    println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("WHY INTERFACES ARE POWERFUL 💪")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
    
    println("Example: Payment system can accept ANY payment processor!")
    
    fun processCustomerPayment(processor: InterfacePaymentProcessor, amount: Double) {
        println("Customer wants to pay $$amount")
        processor.processPayment(amount)
    }
    
    println("\n--- Customer 1 uses Credit Card ---")
    processCustomerPayment(CreditCardProcessor(), 99.99)
    
    println("\n--- Customer 2 uses PayPal ---")
    processCustomerPayment(PayPalProcessor(), 149.99)
    
    println("\n--- Customer 3 uses Crypto ---")
    processCustomerPayment(CryptoProcessor(), 199.99)
    
    println("\n✅ Same function works with ANY payment processor!")
    println("✅ Easy to add new payment methods without changing existing code!")
    
    // ========================================
    // KEY TAKEAWAYS
    // ========================================
    println("\n╔════════════════════════════════════════════╗")
    println("║           KEY TAKEAWAYS                    ║")
    println("╚════════════════════════════════════════════╝")
    println("""
        1. 📋 INTERFACE = Contract/Promise
           - Defines WHAT a class should do
           - Not HOW it should do it
        
        2. ✅ IMPLEMENTATION:
           - Use ':' to implement interface
           - Must override ALL abstract members
           - Use 'override' keyword
        
        3. 🎯 MULTIPLE INTERFACES:
           - A class can implement multiple interfaces
           - Use comma: class Duck : Swimmable, Flyable, Walkable
           - This is NOT possible with classes (single inheritance)
        
        4. 🔧 DEFAULT IMPLEMENTATIONS:
           - Interface methods can have default implementations
           - Classes can use or override them
        
        5. 💡 REAL-WORLD USE CASES:
           - Payment processors (Credit Card, PayPal, Crypto)
           - Database connections (MySQL, MongoDB, PostgreSQL)
           - UI elements (Button, Image, Text - all clickable)
           - Shapes (Circle, Square, Triangle - all drawable)
        
        6. ⚖️  INTERFACE vs ABSTRACT CLASS:
           Interface:
           - Pure contract
           - Multiple implementation ✅
           - No state
           
           Abstract Class:
           - Partial implementation
           - Single inheritance only
           - Can have state
        
        7. 🎨 POLYMORPHISM:
           val processor: PaymentProcessor = CreditCardProcessor()
           
           You can treat different implementations as the same type!
        
        8. 🎯 GOLDEN RULE:
           "Use interfaces when you want to define a CONTRACT
            that multiple unrelated classes can implement."
        
        9. 💪 BENEFITS:
           - Flexible code
           - Easy to test (mock implementations)
           - Easy to extend (add new implementations)
           - Loose coupling
    """.trimIndent())
    
    println("\n╔════════════════════════════════════════════╗")
    println("║       END OF INTERFACES TUTORIAL           ║")
    println("╚════════════════════════════════════════════╝")
}

