package com.example.basic

/*
 * ============================================
 * ABSTRACT CLASSES IN KOTLIN - BEGINNER'S GUIDE
 * ============================================
 * 
 * WHAT IS AN ABSTRACT CLASS?
 * --------------------------
 * Think of an abstract class as a "BLUEPRINT" or "TEMPLATE"
 * 
 * Real-world analogy:
 * - Imagine a blueprint for a house
 * - The blueprint says "there MUST be doors and windows"
 * - But it doesn't say EXACTLY what type of doors/windows
 * - Each actual house will decide: wooden door? glass door? sliding door?
 * 
 * In programming:
 * - Abstract class is an INCOMPLETE class
 * - You CANNOT create objects directly from it
 * - It's meant to be INHERITED by other classes
 * - Child classes MUST complete the incomplete parts
 * 
 * SIMPLE EXPLANATION:
 * -------------------
 * 🏗️  Abstract Class = Blueprint/Template (not a real building)
 * 🏠 Regular Class = Actual building you can use
 * 
 * WHY USE ABSTRACT CLASSES?
 * -------------------------
 * 1. FORCE A CONTRACT: Child classes MUST implement certain methods
 * 2. SHARE COMMON CODE: Put common methods in abstract class
 * 3. ORGANIZED DESIGN: Define what ALL children should have
 * 4. PREVENT MISTAKES: Can't create objects from incomplete class
 * 
 * ABSTRACT vs REGULAR CLASS:
 * --------------------------
 * Regular Class: Complete, can create objects
 *   val dog = Dog() ✅ This works!
 * 
 * Abstract Class: Incomplete, CANNOT create objects
 *   val shape = Shape() ❌ ERROR! Shape is abstract!
 *   val circle = Circle() ✅ This works! Circle is complete.
 * 
 * KEY RULES:
 * ----------
 * 1. Use 'abstract' keyword to declare abstract class
 * 2. Abstract class can have:
 *    - Abstract methods (no implementation) 
 *    - Concrete methods (with implementation)
 *    - Properties
 * 3. Child classes MUST override ALL abstract methods
 * 4. Abstract classes are 'open' by default (inheritable)
 */

// ============================================
// EXAMPLE 1: SHAPES (Simple Understanding)
// ============================================

/*
 * ABSTRACT CLASS: AbstractShape
 * This is a TEMPLATE - not a real shape
 * We can't create a generic "Shape" - it has to be a specific shape
 */
abstract class AbstractShape {
    /*
     * Abstract property - child MUST provide this
     * We declare it but don't give it a value
     */
    abstract val name: String
    
    /*
     * Abstract method - child MUST implement this
     * Different shapes calculate area differently:
     * - Circle: π × r²
     * - Rectangle: length × width
     * - Triangle: ½ × base × height
     */
    abstract fun calculateArea(): Double
    
    /*
     * Concrete method - already implemented
     * All children can use this as-is or override it
     */
    fun describe() {
        println("━━━━━━━━━━━━━━━━━━━━━━━━━━━")
        println("Shape: $name")
        println("Area: ${calculateArea()} square units")
        println("━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    }
}

/*
 * CONCRETE CLASS: CircleShape
 * This is a COMPLETE class - we can create objects
 */
class CircleShape(val radius: Double) : AbstractShape() {
    // MUST provide the abstract property
    override val name: String = "Circle"
    
    // MUST implement the abstract method
    override fun calculateArea(): Double {
        return 3.14159 * radius * radius
    }
    
    // Circle's own method
    fun getCircumference(): Double {
        return 2 * 3.14159 * radius
    }
}

/*
 * CONCRETE CLASS: RectangleShape
 */
class RectangleShape(val length: Double, val width: Double) : AbstractShape() {
    override val name: String = "Rectangle"
    
    override fun calculateArea(): Double {
        return length * width
    }
    
    fun getPerimeter(): Double {
        return 2 * (length + width)
    }
}

/*
 * CONCRETE CLASS: TriangleShape
 */
class TriangleShape(val base: Double, val height: Double) : AbstractShape() {
    override val name: String = "Triangle"
    
    override fun calculateArea(): Double {
        return 0.5 * base * height
    }
}

// ============================================
// EXAMPLE 2: PAYMENT SYSTEM (Real-World)
// ============================================

/*
 * Abstract class for payment methods
 * All payments need to process, but HOW they process is different
 * - Credit Card: needs card number, CVV
 * - PayPal: needs email
 * - Cash: just take the money
 */
abstract class Payment(val amount: Double) {
    /*
     * Abstract method - each payment type processes differently
     * Child classes MUST implement this
     */
    abstract fun processPayment(): Boolean
    
    /*
     * Abstract method - each payment type validates differently
     */
    abstract fun validatePayment(): Boolean
    
    /*
     * Concrete method - all payments can use this
     */
    fun displayAmount() {
        println("💰 Amount to pay: $$amount")
    }
    
    /*
     * Concrete method with logic
     */
    fun executePayment() {
        println("\n🔄 Starting payment process...")
        displayAmount()
        
        if (validatePayment()) {
            println("✓ Validation successful")
            if (processPayment()) {
                println("✅ Payment successful!")
                sendReceipt()
            } else {
                println("❌ Payment failed!")
            }
        } else {
            println("❌ Validation failed!")
        }
    }
    
    /*
     * Another concrete method
     */
    private fun sendReceipt() {
        println("📧 Receipt sent to your email")
    }
}

/*
 * Concrete class: CreditCardPayment
 */
class CreditCardPayment(
    amount: Double,
    val cardNumber: String,
    val cvv: String
) : Payment(amount) {
    
    override fun validatePayment(): Boolean {
        println("🔍 Validating credit card...")
        // Simple validation: card number should be 16 digits, CVV should be 3 digits
        if (cardNumber.length == 16 && cvv.length == 3) {
            println("✓ Card details valid")
            return true
        }
        println("✗ Invalid card details")
        return false
    }
    
    override fun processPayment(): Boolean {
        println("💳 Processing credit card payment...")
        println("   Card: **** **** **** ${cardNumber.takeLast(4)}")
        // Simulate processing
        return true
    }
}

/*
 * Concrete class: PayPalPayment
 */
class PayPalPayment(
    amount: Double,
    val email: String
) : Payment(amount) {
    
    override fun validatePayment(): Boolean {
        println("🔍 Validating PayPal account...")
        // Simple validation: email should contain @
        if (email.contains("@")) {
            println("✓ Email valid")
            return true
        }
        println("✗ Invalid email")
        return false
    }
    
    override fun processPayment(): Boolean {
        println("💙 Processing PayPal payment...")
        println("   PayPal account: $email")
        // Simulate processing
        return true
    }
}

/*
 * Concrete class: CashPayment
 */
class CashPayment(amount: Double) : Payment(amount) {
    
    override fun validatePayment(): Boolean {
        println("🔍 Validating cash payment...")
        // Cash is always valid if amount is positive
        if (amount > 0) {
            println("✓ Amount is valid")
            return true
        }
        println("✗ Invalid amount")
        return false
    }
    
    override fun processPayment(): Boolean {
        println("💵 Processing cash payment...")
        println("   Received: $$amount")
        println("   Thank you!")
        return true
    }
}

// ============================================
// EXAMPLE 3: VEHICLES (Transportation)
// ============================================

/*
 * Abstract AbstractVehicle class
 * All vehicles can move and stop, but HOW they do it is different
 */
abstract class AbstractVehicle(val name: String) {
    // Concrete property
    protected var currentSpeed: Int = 0
    
    // Abstract methods - must be implemented by children
    abstract fun start()
    abstract fun stop()
    
    // Concrete method - all vehicles can use this
    fun accelerate(speed: Int) {
        currentSpeed += speed
        println("⚡ $name accelerating... Speed: $currentSpeed km/h")
    }
    
    fun displayInfo() {
        println("🚗 Vehicle: $name")
        println("   Current speed: $currentSpeed km/h")
    }
}

/*
 * Concrete class: TransportCar
 */
class TransportCar(name: String, val fuelType: String) : AbstractVehicle(name) {
    
    override fun start() {
        println("🚗 $name ($fuelType): Starting engine... Vroom!")
        currentSpeed = 0
    }
    
    override fun stop() {
        println("🚗 $name: Applying brakes... Stopped.")
        currentSpeed = 0
    }
}

/*
 * Concrete class: TransportBicycle
 */
class TransportBicycle(name: String) : AbstractVehicle(name) {
    
    override fun start() {
        println("🚴 $name: Starting to pedal...")
        currentSpeed = 0
    }
    
    override fun stop() {
        println("🚴 $name: Stopping pedaling...")
        currentSpeed = 0
    }
    
    fun ringBell() {
        println("🔔 Ring ring!")
    }
}

/*
 * Concrete class: TransportScooter
 */
class TransportScooter(name: String, var batteryLevel: Int) : AbstractVehicle(name) {
    
    override fun start() {
        if (batteryLevel > 10) {
            println("🛴 $name: Electric motor on! Battery: $batteryLevel%")
            currentSpeed = 0
        } else {
            println("🛴 $name: Low battery! Please charge.")
        }
    }
    
    override fun stop() {
        println("🛴 $name: Motor off. Battery: $batteryLevel%")
        currentSpeed = 0
    }
}

// ============================================
// EXAMPLE 4: EMPLOYEES (Work System)
// ============================================

/*
 * Abstract AbstractEmployee class
 * All employees work and get paid, but their work is different
 */
abstract class AbstractEmployee(
    val employeeId: String,
    val name: String,
    protected val baseSalary: Double
) {
    // Abstract method - each employee works differently
    abstract fun doWork()
    
    // Abstract method - salary calculation might differ
    abstract fun calculateSalary(): Double
    
    // Concrete method - all employees can clock in
    fun clockIn() {
        println("⏰ $name clocked in at ${getCurrentTime()}")
    }
    
    fun clockOut() {
        println("⏰ $name clocked out at ${getCurrentTime()}")
    }
    
    private fun getCurrentTime(): String {
        return "09:00 AM" // Simplified
    }
    
    fun displayInfo() {
        println("╔═══════════════════════════════╗")
        println("  Employee: $name")
        println("  ID: $employeeId")
        println("  Salary: $${calculateSalary()}")
        println("╚═══════════════════════════════╝")
    }
}

/*
 * Concrete class: FullTimeStaff
 */
class FullTimeStaff(
    employeeId: String,
    name: String,
    baseSalary: Double,
    val bonus: Double
) : AbstractEmployee(employeeId, name, baseSalary) {
    
    override fun doWork() {
        println("💼 $name is working full-time (9 AM - 6 PM)")
    }
    
    override fun calculateSalary(): Double {
        return baseSalary + bonus
    }
}

/*
 * Concrete class: PartTimeStaff
 */
class PartTimeStaff(
    employeeId: String,
    name: String,
    val hourlyRate: Double,
    val hoursWorked: Int
) : AbstractEmployee(employeeId, name, 0.0) {
    
    override fun doWork() {
        println("⏱️  $name is working part-time ($hoursWorked hours/week)")
    }
    
    override fun calculateSalary(): Double {
        return hourlyRate * hoursWorked
    }
}

/*
 * Concrete class: InternStaff
 */
class InternStaff(
    employeeId: String,
    name: String,
    val stipend: Double,
    val mentor: String
) : AbstractEmployee(employeeId, name, stipend) {
    
    override fun doWork() {
        println("🎓 $name (Intern) is learning and working under $mentor")
    }
    
    override fun calculateSalary(): Double {
        return stipend
    }
    
    fun attendTraining() {
        println("📚 $name is attending training session")
    }
}

// ============================================
// EXAMPLE 5: NOTIFICATION SYSTEM
// ============================================

/*
 * Abstract Notification class
 * Different types of notifications send messages differently
 */
abstract class Notification(val recipient: String, val message: String) {
    
    // Abstract method - each notification sends differently
    abstract fun send()
    
    // Abstract method - validate recipient
    abstract fun validateRecipient(): Boolean
    
    // Concrete method
    fun prepare() {
        println("\n📨 Preparing notification...")
        println("To: $recipient")
        println("Message: $message")
        
        if (validateRecipient()) {
            send()
            logNotification()
        } else {
            println("❌ Invalid recipient!")
        }
    }
    
    private fun logNotification() {
        println("📝 Notification logged in system")
    }
}

/*
 * Concrete class: EmailNotification
 */
class EmailNotification(
    recipient: String,
    message: String,
    val subject: String
) : Notification(recipient, message) {
    
    override fun validateRecipient(): Boolean {
        return recipient.contains("@") && recipient.contains(".")
    }
    
    override fun send() {
        println("📧 Sending email...")
        println("   Subject: $subject")
        println("✅ Email sent to $recipient")
    }
}

/*
 * Concrete class: SMSNotification
 */
class SMSNotification(
    recipient: String,
    message: String
) : Notification(recipient, message) {
    
    override fun validateRecipient(): Boolean {
        // Simple check: phone number should have 10+ digits
        return recipient.replace(Regex("[^0-9]"), "").length >= 10
    }
    
    override fun send() {
        println("📱 Sending SMS...")
        println("✅ SMS sent to $recipient")
    }
}

/*
 * Concrete class: PushNotification
 */
class PushNotification(
    recipient: String,
    message: String,
    val deviceId: String
) : Notification(recipient, message) {
    
    override fun validateRecipient(): Boolean {
        // Device ID should not be empty
        return deviceId.isNotEmpty()
    }
    
    override fun send() {
        println("🔔 Sending push notification...")
        println("   Device: $deviceId")
        println("✅ Push notification sent to $recipient")
    }
}

// ============================================
// MAIN FUNCTION - DEMONSTRATION
// ============================================
fun main() {
    println("╔════════════════════════════════════════════╗")
    println("║   ABSTRACT CLASSES - BEGINNER'S GUIDE     ║")
    println("╚════════════════════════════════════════════╝\n")
    
    // ========================================
    // EXAMPLE 1: Shapes
    // ========================================
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 1: Shapes (Understanding Abstract) 📐")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
    
    // val shape = AbstractShape() // ❌ ERROR! Cannot create abstract class
    
    // But we CAN create concrete shapes
    val circle = CircleShape(5.0)
    circle.describe()
    println("Circumference: ${circle.getCircumference()} units\n")
    
    val rectangle = RectangleShape(10.0, 5.0)
    rectangle.describe()
    println("Perimeter: ${rectangle.getPerimeter()} units\n")
    
    val triangle = TriangleShape(8.0, 6.0)
    triangle.describe()
    
    // We can store different shapes in a list of AbstractShape type
    println("\n📊 Calculating areas of all shapes:")
    val shapes: List<AbstractShape> = listOf(
        CircleShape(3.0),
        RectangleShape(4.0, 6.0),
        TriangleShape(5.0, 8.0)
    )
    
    for (shape in shapes) {
        println("${shape.name}: ${shape.calculateArea()} square units")
    }
    
    // ========================================
    // EXAMPLE 2: Payment System
    // ========================================
    println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 2: Payment System 💳")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    
    val creditCard = CreditCardPayment(150.0, "1234567890123456", "123")
    creditCard.executePayment()
    
    val paypal = PayPalPayment(75.50, "user@example.com")
    paypal.executePayment()
    
    val cash = CashPayment(50.0)
    cash.executePayment()
    
    // Example with invalid payment
    println("\n--- Trying invalid payment ---")
    val invalidCard = CreditCardPayment(100.0, "12345", "12")
    invalidCard.executePayment()
    
    // ========================================
    // EXAMPLE 3: Vehicles
    // ========================================
    println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 3: Vehicles 🚗")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
    
    val car = TransportCar("Tesla Model 3", "Electric")
    car.start()
    car.accelerate(50)
    car.accelerate(30)
    car.displayInfo()
    car.stop()
    
    println()
    val bicycle = TransportBicycle("Mountain Bike")
    bicycle.start()
    bicycle.accelerate(20)
    bicycle.ringBell()
    bicycle.displayInfo()
    bicycle.stop()
    
    println()
    val scooter = TransportScooter("Xiaomi Scooter", 85)
    scooter.start()
    scooter.accelerate(25)
    scooter.displayInfo()
    scooter.stop()
    
    // ========================================
    // EXAMPLE 4: Employees
    // ========================================
    println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 4: Employee System 👨‍💼")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
    
    val fullTime = FullTimeStaff("FT001", "Alice", 5000.0, 1000.0)
    fullTime.displayInfo()
    fullTime.clockIn()
    fullTime.doWork()
    fullTime.clockOut()
    
    println()
    val partTime = PartTimeStaff("PT001", "Bob", 25.0, 80)
    partTime.displayInfo()
    partTime.clockIn()
    partTime.doWork()
    partTime.clockOut()
    
    println()
    val intern = InternStaff("IN001", "Charlie", 800.0, "Alice")
    intern.displayInfo()
    intern.clockIn()
    intern.doWork()
    intern.attendTraining()
    intern.clockOut()
    
    // ========================================
    // EXAMPLE 5: Notification System
    // ========================================
    println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 5: Notification System 📨")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    
    val email = EmailNotification(
        "john@example.com",
        "Your order has been shipped!",
        "Order Shipment"
    )
    email.prepare()
    
    val sms = SMSNotification(
        "+1-555-123-4567",
        "Your verification code is 123456"
    )
    sms.prepare()
    
    val push = PushNotification(
        "JohnDoe",
        "You have a new message!",
        "device_12345"
    )
    push.prepare()
    
    // Invalid notification
    val invalidEmail = EmailNotification(
        "invalid-email",
        "This won't be sent",
        "Test"
    )
    invalidEmail.prepare()
    
    // ========================================
    // DEMONSTRATING WHY ABSTRACT IS USEFUL
    // ========================================
    println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("WHY ABSTRACT CLASSES ARE USEFUL 💡")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
    
    // We can treat different payments as Payment type
    val payments: List<Payment> = listOf(
        CreditCardPayment(100.0, "1234567890123456", "123"),
        PayPalPayment(50.0, "user@example.com"),
        CashPayment(25.0)
    )
    
    println("Processing multiple payments:")
    var totalProcessed = 0.0
    for (payment in payments) {
        payment.executePayment()
        totalProcessed += payment.amount
        println()
    }
    println("💰 Total amount processed: $$totalProcessed")
    
    // ========================================
    // KEY TAKEAWAYS
    // ========================================
    println("\n╔════════════════════════════════════════════╗")
    println("║           KEY TAKEAWAYS                    ║")
    println("╚════════════════════════════════════════════╝")
    println("""
        1. 🏗️  ABSTRACT CLASS = Blueprint/Template
           - Cannot create objects from it directly
           - Must be inherited by other classes
           - Example: val shape = Shape() ❌ ERROR!
           - Example: val circle = Circle() ✅ Works!
        
        2. 📋 CONTAINS TWO TYPES OF MEMBERS:
           - ABSTRACT: No implementation (child MUST provide)
           - CONCRETE: Has implementation (child can use as-is)
        
        3. ✅ KEYWORDS:
           - 'abstract' class = Cannot instantiate
           - 'abstract' method = Must be overridden
           - 'override' = Implement abstract method in child
        
        4. 🎯 WHEN TO USE:
           - When you have common behavior across classes
           - When you want to FORCE children to implement methods
           - When creating a hierarchy makes sense
        
        5. 💡 REAL-WORLD EXAMPLES:
           - Shape (Circle, Rectangle, Triangle)
           - Payment (CreditCard, PayPal, Cash)
           - Vehicle (Car, Bicycle, Scooter)
           - Employee (FullTime, PartTime, Intern)
        
        6. ⚖️  ABSTRACT vs INTERFACE:
           Abstract Class:
           - Can have properties with state
           - Can have concrete methods
           - Single inheritance only
           
           Interface:
           - No state (only in Kotlin 1.3+)
           - Default implementations allowed
           - Multiple inheritance
        
        7. 🎨 GOLDEN RULE:
           "Use abstract class when you want to share CODE
            and FORCE certain methods to be implemented."
    """.trimIndent())
    
    println("\n╔════════════════════════════════════════════╗")
    println("║    END OF ABSTRACT CLASSES TUTORIAL        ║")
    println("╚════════════════════════════════════════════╝")
}

