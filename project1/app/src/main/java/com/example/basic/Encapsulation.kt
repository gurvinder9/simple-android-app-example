package com.example.basic

/*
 * ============================================
 * ENCAPSULATION IN KOTLIN - BEGINNER'S GUIDE
 * ============================================
 * 
 * WHAT IS ENCAPSULATION?
 * ----------------------
 * Encapsulation is like putting your valuable things in a safe box.
 * You hide the internal details and only show what's necessary.
 * 
 * Think of it like a TV remote:
 * - You press buttons (public interface)
 * - You don't see the complex circuit inside (hidden/private)
 * - You can't directly mess with the internal wiring (protected data)
 * 
 * WHY USE ENCAPSULATION?
 * ----------------------
 * 1. SECURITY: Protect data from being changed incorrectly
 * 2. CONTROL: Control how data is accessed and modified
 * 3. FLEXIBILITY: Change internal implementation without breaking code
 * 4. EASY TO USE: Users only see simple methods, not complex logic
 */

// ============================================
// EXAMPLE 1: BAD PRACTICE (NO ENCAPSULATION)
// ============================================
/*
 * This is a BAD example - everything is public
 * Anyone can change anything without any validation
 */
class BankAccountBad {
    var accountNumber: String = ""
    var balance: Double = 0.0
    var pin: String = ""
    
    fun showBalance() {
        println("Balance: $$balance")
    }
}

/*
 * PROBLEM WITH THE ABOVE CODE:
 * Someone can do: account.balance = -1000.0 (negative balance!)
 * Someone can do: account.pin = "0000" (change PIN without verification!)
 * Someone can see: println(account.pin) (see the PIN directly!)
 * 
 * This is dangerous! We need ENCAPSULATION to protect our data.
 */

// ============================================
// EXAMPLE 2: GOOD PRACTICE (WITH ENCAPSULATION)
// ============================================
/*
 * This is a GOOD example with proper encapsulation
 * Data is private and can only be accessed through controlled methods
 */
class BankAccountGood(
    private val accountNumber: String,  // private = can't be accessed from outside
    private var balance: Double,
    private var pin: String
) {
    /*
     * IMPORTANT CONCEPTS:
     * - 'private' means only THIS class can access these variables
     * - We provide public methods (functions) to interact with private data
     * - These methods can validate and control how data is changed
     */
    
    // Public method to safely deposit money
    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("✓ Deposited: $$amount")
            println("✓ New balance: $$balance")
        } else {
            println("✗ Error: Cannot deposit negative amount!")
        }
    }
    
    // Public method to safely withdraw money
    fun withdraw(amount: Double, enteredPin: String) {
        // Check if PIN is correct
        if (enteredPin != pin) {
            println("✗ Error: Wrong PIN!")
            return
        }
        
        // Check if amount is valid
        if (amount <= 0) {
            println("✗ Error: Amount must be positive!")
            return
        }
        
        // Check if sufficient balance
        if (amount > balance) {
            println("✗ Error: Insufficient balance!")
            return
        }
        
        // Everything is OK, withdraw money
        balance -= amount
        println("✓ Withdrawn: $$amount")
        println("✓ New balance: $$balance")
    }
    
    // Public method to check balance (with PIN verification)
    fun checkBalance(enteredPin: String) {
        if (enteredPin == pin) {
            println("✓ Your balance: $$balance")
        } else {
            println("✗ Error: Wrong PIN!")
        }
    }
    
    // Public method to change PIN safely
    fun changePin(oldPin: String, newPin: String) {
        if (oldPin != pin) {
            println("✗ Error: Wrong old PIN!")
            return
        }
        
        if (newPin.length < 4) {
            println("✗ Error: PIN must be at least 4 digits!")
            return
        }
        
        pin = newPin
        println("✓ PIN changed successfully!")
    }
    
    // Public method to get account number (read-only, safe to show)
    fun getAccountNumber(): String {
        return accountNumber
    }
}

// ============================================
// EXAMPLE 3: STUDENT CLASS (SIMPLE EXAMPLE)
// ============================================
/*
 * Real-world example: A student record system
 * We want to protect student data and ensure valid inputs
 */
class Student(
    private val studentId: String,
    private var name: String,
    private var age: Int,
    private var marks: Int
) {
    // We can read the name, but not change it directly
    fun getName(): String {
        return name
    }
    
    // We can update marks, but with validation
    fun updateMarks(newMarks: Int) {
        if (newMarks in 0..100) {  // Marks must be between 0 and 100
            marks = newMarks
            println("✓ Marks updated to $marks")
        } else {
            println("✗ Error: Marks must be between 0 and 100!")
        }
    }
    
    // We can get marks (read-only access)
    fun getMarks(): Int {
        return marks
    }
    
    // Update age with validation
    fun updateAge(newAge: Int) {
        if (newAge in 5..100) {  // Reasonable age range for students
            age = newAge
            println("✓ Age updated to $age")
        } else {
            println("✗ Error: Invalid age!")
        }
    }
    
    // Calculate grade based on marks (using private data)
    fun getGrade(): String {
        return when {
            marks >= 90 -> "A+ (Excellent!)"
            marks >= 80 -> "A (Very Good)"
            marks >= 70 -> "B (Good)"
            marks >= 60 -> "C (Average)"
            marks >= 50 -> "D (Pass)"
            else -> "F (Fail)"
        }
    }
    
    // Display student info
    fun displayInfo() {
        println("═══════════════════════════")
        println("Student ID: $studentId")
        println("Name: $name")
        println("Age: $age")
        println("Marks: $marks")
        println("Grade: ${getGrade()}")
        println("═══════════════════════════")
    }
}

// ============================================
// EXAMPLE 4: CAR CLASS (WITH PROPERTIES)
// ============================================
/*
 * Kotlin provides a shorthand for getters and setters
 * This is another way to achieve encapsulation
 */
class EncapsulatedCar(
    private val brand: String,
    private val model: String,
    initialSpeed: Int = 0
) {
    // Private property with custom getter and setter
    private var speed: Int = initialSpeed
        set(value) {
            // Custom logic in setter for validation
            if (value in 0..200) {
                field = value  // 'field' refers to the backing property
                println("✓ Speed set to $value km/h")
            } else {
                println("✗ Error: Speed must be between 0 and 200 km/h!")
            }
        }
    
    private var engineOn: Boolean = false
    
    // Public method to start the engine
    fun startEngine() {
        if (!engineOn) {
            engineOn = true
            println("✓ $brand $model engine started!")
        } else {
            println("✗ Engine is already running!")
        }
    }
    
    // Public method to stop the engine
    fun stopEngine() {
        if (engineOn) {
            speed = 0
            engineOn = false
            println("✓ $brand $model engine stopped!")
        } else {
            println("✗ Engine is already off!")
        }
    }
    
    // Public method to accelerate
    fun accelerate(increase: Int) {
        if (!engineOn) {
            println("✗ Error: Start the engine first!")
            return
        }
        
        speed += increase
        // The setter will automatically validate the speed
    }
    
    // Public method to brake
    fun brake(decrease: Int) {
        if (!engineOn) {
            println("✗ Error: Engine is not running!")
            return
        }
        
        speed -= decrease
        if (speed < 0) {
            speed = 0
        }
    }
    
    // Public method to get current speed
    fun getCurrentSpeed(): Int {
        return speed
    }
    
    // Display car info
    fun displayCarInfo() {
        println("Car: $brand $model")
        println("Engine: ${if (engineOn) "ON" else "OFF"}")
        println("Speed: $speed km/h")
    }
}

// ============================================
// EXAMPLE 5: PHONE CLASS (REAL-WORLD EXAMPLE)
// ============================================
/*
 * A mobile phone has many internal components
 * Users don't need to know how it works internally
 * They just use simple methods like call(), sendMessage(), etc.
 */
class Phone(
    private val phoneNumber: String,
    private var batteryLevel: Int = 100
) {
    private var isScreenOn: Boolean = false
    private var isLocked: Boolean = true
    private val password: String = "1234"
    
    // Turn screen on/off
    fun pressButton() {
        isScreenOn = !isScreenOn
        if (isScreenOn) {
            println("📱 Screen turned ON")
            showBatteryLevel()
        } else {
            println("📱 Screen turned OFF")
        }
    }
    
    // Unlock phone with password
    fun unlock(enteredPassword: String) {
        if (!isScreenOn) {
            println("✗ Turn on the screen first!")
            return
        }
        
        if (enteredPassword == password) {
            isLocked = false
            println("✓ Phone unlocked!")
        } else {
            println("✗ Wrong password!")
        }
    }
    
    // Lock phone
    fun lock() {
        isLocked = true
        println("🔒 Phone locked!")
    }
    
    // Make a call
    fun makeCall(number: String) {
        if (!isScreenOn) {
            println("✗ Turn on the screen first!")
            return
        }
        
        if (isLocked) {
            println("✗ Unlock the phone first!")
            return
        }
        
        if (batteryLevel < 5) {
            println("✗ Battery too low to make a call!")
            return
        }
        
        println("📞 Calling $number...")
        batteryLevel -= 5  // Using battery
        println("✓ Call ended")
        showBatteryLevel()
    }
    
    // Send message
    fun sendMessage(number: String, message: String) {
        if (!isScreenOn || isLocked) {
            println("✗ Unlock the phone first!")
            return
        }
        
        if (batteryLevel < 2) {
            println("✗ Battery too low!")
            return
        }
        
        println("💬 Sending message to $number: \"$message\"")
        batteryLevel -= 2
        println("✓ Message sent!")
        showBatteryLevel()
    }
    
    // Charge phone
    fun charge(amount: Int) {
        println("🔌 Charging phone...")
        batteryLevel += amount
        if (batteryLevel > 100) {
            batteryLevel = 100
        }
        showBatteryLevel()
    }
    
    // Private method to show battery (internal use)
    private fun showBatteryLevel() {
        val batteryIcon = when {
            batteryLevel > 80 -> "🔋🔋🔋🔋"
            batteryLevel > 50 -> "🔋🔋🔋"
            batteryLevel > 20 -> "🔋🔋"
            batteryLevel > 5 -> "🔋"
            else -> "🪫"
        }
        println("Battery: $batteryIcon $batteryLevel%")
    }
}

// ============================================
// MAIN FUNCTION - DEMONSTRATION
// ============================================
fun main() {
    println("╔════════════════════════════════════════════╗")
    println("║   ENCAPSULATION - BEGINNER'S GUIDE        ║")
    println("╚════════════════════════════════════════════╝\n")
    
    // ========================================
    // DEMONSTRATION 1: BAD vs GOOD Practice
    // ========================================
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 1: BAD PRACTICE (No Encapsulation)")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    
    val badAccount = BankAccountBad()
    badAccount.accountNumber = "BAD123"
    badAccount.balance = 1000.0
    badAccount.pin = "1234"
    
    println("Initial balance: ${badAccount.balance}")
    
    // DANGER! Anyone can do this:
    badAccount.balance = -5000.0  // Negative balance!
    println("Someone set balance to: ${badAccount.balance} (This is BAD!)")
    
    badAccount.pin = "0000"  // Changed PIN without verification!
    println("Someone changed PIN to: ${badAccount.pin} (This is BAD!)\n")
    
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 2: GOOD PRACTICE (With Encapsulation)")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    
    val goodAccount = BankAccountGood("GOOD456", 1000.0, "1234")
    
    println("Account: ${goodAccount.getAccountNumber()}")
    goodAccount.checkBalance("1234")
    
    // Try to deposit
    println("\nTrying to deposit $500:")
    goodAccount.deposit(500.0)
    
    // Try to deposit negative (will be rejected)
    println("\nTrying to deposit -$100:")
    goodAccount.deposit(-100.0)
    
    // Try to withdraw with wrong PIN
    println("\nTrying to withdraw with wrong PIN:")
    goodAccount.withdraw(200.0, "0000")
    
    // Try to withdraw with correct PIN
    println("\nTrying to withdraw with correct PIN:")
    goodAccount.withdraw(200.0, "1234")
    
    // Try to withdraw more than balance
    println("\nTrying to withdraw more than balance:")
    goodAccount.withdraw(5000.0, "1234")
    
    // Change PIN
    println("\nChanging PIN:")
    goodAccount.changePin("1234", "5678")
    
    // Try to access balance with old PIN
    println("\nTrying old PIN:")
    goodAccount.checkBalance("1234")
    
    // Try with new PIN
    println("\nTrying new PIN:")
    goodAccount.checkBalance("5678")
    
    // ========================================
    // DEMONSTRATION 2: Student Example
    // ========================================
    println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 3: Student Class")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    
    val student = Student("STU001", "John Doe", 18, 75)
    student.displayInfo()
    
    // Update marks with valid value
    println("\nUpdating marks to 85:")
    student.updateMarks(85)
    student.displayInfo()
    
    // Try to update marks with invalid value
    println("\nTrying to update marks to 150 (invalid):")
    student.updateMarks(150)
    
    // Update age
    println("\nUpdating age to 19:")
    student.updateAge(19)
    
    // Try invalid age
    println("\nTrying to update age to 200 (invalid):")
    student.updateAge(200)
    
    // ========================================
    // DEMONSTRATION 3: Car Example
    // ========================================
    println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 4: Car Class")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    
    val car = EncapsulatedCar("Toyota", "Camry")
    car.displayCarInfo()
    
    println("\nTrying to accelerate without starting engine:")
    car.accelerate(50)
    
    println("\nStarting the engine:")
    car.startEngine()
    
    println("\nAccelerating:")
    car.accelerate(60)
    car.displayCarInfo()
    
    println("\nAccelerating more:")
    car.accelerate(80)
    car.displayCarInfo()
    
    println("\nTrying to go beyond speed limit:")
    car.accelerate(100)  // This should fail
    
    println("\nBraking:")
    car.brake(40)
    car.displayCarInfo()
    
    println("\nStopping the car:")
    car.stopEngine()
    car.displayCarInfo()
    
    // ========================================
    // DEMONSTRATION 4: Phone Example
    // ========================================
    println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 5: Phone Class (Real-world)")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    
    val phone = Phone("+1-555-1234")
    
    println("Trying to make a call (screen is off):")
    phone.makeCall("+1-555-5678")
    
    println("\nTurning screen on:")
    phone.pressButton()
    
    println("\nTrying to make a call (phone is locked):")
    phone.makeCall("+1-555-5678")
    
    println("\nTrying to unlock with wrong password:")
    phone.unlock("0000")
    
    println("\nUnlocking with correct password:")
    phone.unlock("1234")
    
    println("\nMaking a call:")
    phone.makeCall("+1-555-5678")
    
    println("\nSending a message:")
    phone.sendMessage("+1-555-9999", "Hello! This is a test message.")
    
    println("\nMaking multiple calls to drain battery:")
    for (i in 1..5) {
        phone.makeCall("+1-555-000$i")
    }
    
    println("\nCharging phone:")
    phone.charge(30)
    
    println("\nLocking phone:")
    phone.lock()
    
    println("\nTurning screen off:")
    phone.pressButton()
    
    // ========================================
    // KEY TAKEAWAYS
    // ========================================
    println("\n╔════════════════════════════════════════════╗")
    println("║           KEY TAKEAWAYS                    ║")
    println("╚════════════════════════════════════════════╝")
    println("""
        1. 🔒 ENCAPSULATION = Data Hiding + Controlled Access
        
        2. ✅ Use 'private' for data you want to protect
        
        3. ✅ Use 'public' methods to interact with private data
        
        4. ✅ Add validation in public methods
        
        5. ✅ Think of it like a TV remote:
           - Simple buttons to press (public methods)
           - Complex circuit hidden inside (private data)
        
        6. 💡 BENEFITS:
           - Prevents invalid data
           - Makes code easier to use
           - You can change internal code without breaking other code
           - More secure and reliable
        
        7. 🎯 GOLDEN RULE:
           "Make everything private by default.
            Only make public what users need to access."
    """.trimIndent())
    
    println("\n╔════════════════════════════════════════════╗")
    println("║       END OF ENCAPSULATION TUTORIAL        ║")
    println("╚════════════════════════════════════════════╝")
}

