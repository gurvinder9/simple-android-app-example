package com.example.basic

/*
 * ============================================
 * INHERITANCE IN KOTLIN - BEGINNER'S GUIDE
 * ============================================
 * 
 * WHAT IS INHERITANCE?
 * --------------------
 * Inheritance is like a family tree - children inherit traits from parents.
 * 
 * Think of it like this:
 * - Your parents have certain features (eye color, height, etc.)
 * - You INHERIT some of these features from them
 * - But you also have your own UNIQUE features
 * 
 * In programming:
 * - Parent Class (also called Super Class or Base Class)
 * - Child Class (also called Sub Class or Derived Class)
 * - Child inherits properties and methods from Parent
 * - Child can have its own additional properties and methods
 * 
 * REAL-WORLD ANALOGY:
 * -------------------
 * Think of ANIMALS:
 * - All animals eat, sleep, breathe (COMMON features)
 * - But DOG barks, CAT meows, BIRD flies (SPECIFIC features)
 * - So we create an ANIMAL parent class
 * - Then DOG, CAT, BIRD inherit from ANIMAL
 * 
 * WHY USE INHERITANCE?
 * --------------------
 * 1. CODE REUSE: Write common code once, use it in many classes
 * 2. ORGANIZATION: Group related classes together
 * 3. EASY TO MAINTAIN: Change parent class, all children get the change
 * 4. LOGICAL: Represents real-world relationships
 * 
 * KOTLIN RULES:
 * -------------
 * 1. Use 'open' keyword to make a class inheritable
 * 2. By default, classes are 'final' (cannot be inherited)
 * 3. Use ':' symbol to inherit from a parent class
 * 4. Use 'override' keyword to change parent's methods
 * 5. Use 'super' to call parent's methods or constructor
 */

// ============================================
// EXAMPLE 1: BASIC INHERITANCE (Animal Family)
// ============================================

/*
 * PARENT CLASS (Base Class)
 * This is the 'open' class that other classes can inherit from
 */
open class Animal(val name: String, val age: Int) {
    /*
     * Common properties that ALL animals have
     * These will be inherited by all child classes
     */
    
    // Method that all animals can do
    fun eat() {
        println("🍽️  $name is eating...")
    }
    
    fun sleep() {
        println("😴 $name is sleeping... Zzz")
    }
    
    // This method can be overridden by child classes
    open fun makeSound() {
        println("🔊 $name makes a generic animal sound")
    }
    
    // Display basic info
    open fun displayInfo() {
        println("═══════════════════════════")
        println("Animal: $name")
        println("Age: $age years")
        println("═══════════════════════════")
    }
}

/*
 * CHILD CLASS 1: Dog
 * Dog INHERITS from Animal
 * Notice: Dog has everything Animal has, PLUS its own features
 */
class Dog(name: String, age: Int, val breed: String) : Animal(name, age) {
    /*
     * Dog has:
     * - name, age (inherited from Animal)
     * - breed (its own property)
     * - eat(), sleep() (inherited from Animal)
     * - makeSound() (overridden - changed to bark)
     * - bark() (its own method)
     */
    
    // Override parent's method with Dog-specific behavior
    override fun makeSound() {
        println("🐕 $name barks: Woof! Woof!")
    }
    
    // Dog's own special method
    fun bark() {
        println("🐕 $name: Woof Woof!")
    }
    
    fun wagTail() {
        println("🐕 $name is wagging tail happily!")
    }
    
    // Override displayInfo to add breed information
    override fun displayInfo() {
        println("═══════════════════════════")
        println("Animal: Dog 🐕")
        println("Name: $name")
        println("Age: $age years")
        println("Breed: $breed")
        println("═══════════════════════════")
    }
}

/*
 * CHILD CLASS 2: Cat
 * Cat also INHERITS from Animal but has different behavior
 */
class Cat(name: String, age: Int, val color: String) : Animal(name, age) {
    
    override fun makeSound() {
        println("🐱 $name meows: Meow! Meow!")
    }
    
    fun meow() {
        println("🐱 $name: Meow Meow!")
    }
    
    fun purr() {
        println("🐱 $name is purring... purrr~")
    }
    
    fun scratch() {
        println("🐱 $name scratches the furniture!")
    }
    
    override fun displayInfo() {
        println("═══════════════════════════")
        println("Animal: Cat 🐱")
        println("Name: $name")
        println("Age: $age years")
        println("Color: $color")
        println("═══════════════════════════")
    }
}

/*
 * CHILD CLASS 3: Bird
 * Bird inherits from Animal and adds flying capability
 */
class Bird(name: String, age: Int, val canFly: Boolean) : Animal(name, age) {
    
    override fun makeSound() {
        println("🐦 $name chirps: Tweet! Tweet!")
    }
    
    fun fly() {
        if (canFly) {
            println("🐦 $name is flying high in the sky!")
        } else {
            println("🐦 $name cannot fly (maybe it's a penguin!)")
        }
    }
    
    override fun displayInfo() {
        println("═══════════════════════════")
        println("Animal: Bird 🐦")
        println("Name: $name")
        println("Age: $age years")
        println("Can fly: ${if (canFly) "Yes" else "No"}")
        println("═══════════════════════════")
    }
}

// ============================================
// EXAMPLE 2: VEHICLE HIERARCHY
// ============================================

/*
 * Another example: Vehicles
 * All vehicles have common features, but specific types work differently
 */
open class Vehicle(
    val brand: String,
    val model: String,
    val year: Int
) {
    protected var speed: Int = 0  // protected = accessible in child classes
    
    open fun start() {
        println("🔑 Starting $brand $model...")
    }
    
    open fun stop() {
        speed = 0
        println("🛑 $brand $model stopped")
    }
    
    fun accelerate(amount: Int) {
        speed += amount
        println("⚡ Accelerating... Current speed: $speed km/h")
    }
    
    open fun displayInfo() {
        println("Vehicle: $brand $model ($year)")
        println("Current speed: $speed km/h")
    }
}

/*
 * Child class: InheritedCar
 */
class InheritedCar(
    brand: String,
    model: String,
    year: Int,
    val numberOfDoors: Int
) : Vehicle(brand, model, year) {
    
    private var isAirConditionerOn = false
    
    override fun start() {
        println("🚗 $brand $model: Vroom vroom! Car started!")
        println("🚗 Engine running smoothly...")
    }
    
    fun openTrunk() {
        println("🚗 Trunk opened!")
    }
    
    fun turnOnAC() {
        isAirConditionerOn = true
        println("❄️  Air conditioner turned ON - Cool breeze~")
    }
    
    override fun displayInfo() {
        println("╔════════════════════════════╗")
        println("   🚗 CAR INFORMATION")
        println("╚════════════════════════════╝")
        println("Brand: $brand")
        println("Model: $model")
        println("Year: $year")
        println("Doors: $numberOfDoors")
        println("Speed: $speed km/h")
        println("AC: ${if (isAirConditionerOn) "ON" else "OFF"}")
    }
}

/*
 * Child class: Motorcycle
 */
class Motorcycle(
    brand: String,
    model: String,
    year: Int,
    val hasCarrier: Boolean
) : Vehicle(brand, model, year) {
    
    override fun start() {
        println("🏍️  $brand $model: Vroooom! Motorcycle started!")
    }
    
    fun wheelie() {
        if (speed > 30) {
            println("🏍️  Performing a wheelie! 🤘")
        } else {
            println("🏍️  Speed too low for wheelie. Need more speed!")
        }
    }
    
    override fun displayInfo() {
        println("╔════════════════════════════╗")
        println("   🏍️  MOTORCYCLE INFORMATION")
        println("╚════════════════════════════╝")
        println("Brand: $brand")
        println("Model: $model")
        println("Year: $year")
        println("Has Carrier: ${if (hasCarrier) "Yes" else "No"}")
        println("Speed: $speed km/h")
    }
}

// ============================================
// EXAMPLE 3: EMPLOYEE HIERARCHY
// ============================================

/*
 * Company employees example
 * All employees have common properties, but different roles have different responsibilities
 */
open class Employee(
    val employeeId: String,
    val name: String,
    protected var salary: Double
) {
    
    open fun work() {
        println("👨‍💼 $name is working...")
    }
    
    fun takeBreak() {
        println("☕ $name is taking a break")
    }
    
    open fun displayInfo() {
        println("Employee: $name (ID: $employeeId)")
        println("Salary: $$salary")
    }
    
    // Protected method - only accessible in this class and child classes
    protected fun calculateBonus(percentage: Double): Double {
        return salary * (percentage / 100)
    }
}

/*
 * Child class: Developer
 */
class Developer(
    employeeId: String,
    name: String,
    salary: Double,
    val programmingLanguage: String
) : Employee(employeeId, name, salary) {
    
    override fun work() {
        println("💻 $name is coding in $programmingLanguage...")
    }
    
    fun writeCode() {
        println("💻 $name is writing code: println(\"Hello World!\")")
    }
    
    fun debugCode() {
        println("🐛 $name is debugging code... Finding bugs!")
    }
    
    fun getYearEndBonus(): Double {
        // Using protected method from parent class
        val bonus = calculateBonus(15.0)
        println("🎁 $name receives year-end bonus: $$bonus")
        return bonus
    }
    
    override fun displayInfo() {
        println("╔═══════════════════════════════╗")
        println("   💻 DEVELOPER")
        println("╚═══════════════════════════════╝")
        println("Name: $name")
        println("ID: $employeeId")
        println("Language: $programmingLanguage")
        println("Salary: $$salary")
    }
}

/*
 * Child class: Manager
 */
class Manager(
    employeeId: String,
    name: String,
    salary: Double,
    val teamSize: Int
) : Employee(employeeId, name, salary) {
    
    override fun work() {
        println("👔 $name is managing the team of $teamSize people...")
    }
    
    fun conductMeeting() {
        println("👔 $name is conducting a team meeting")
    }
    
    fun reviewPerformance() {
        println("👔 $name is reviewing team performance")
    }
    
    fun getYearEndBonus(): Double {
        // Managers get higher bonus
        val bonus = calculateBonus(20.0)
        println("🎁 $name receives year-end bonus: $$bonus")
        return bonus
    }
    
    override fun displayInfo() {
        println("╔═══════════════════════════════╗")
        println("   👔 MANAGER")
        println("╚═══════════════════════════════╝")
        println("Name: $name")
        println("ID: $employeeId")
        println("Team Size: $teamSize")
        println("Salary: $$salary")
    }
}

// ============================================
// EXAMPLE 4: USING 'super' KEYWORD
// ============================================

/*
 * The 'super' keyword is used to call parent class methods
 * Useful when you want to extend (not replace) parent behavior
 */
open class InheritedShape(val name: String) {
    
    open fun draw() {
        println("✏️  Drawing a $name...")
    }
    
    open fun describe() {
        println("This is a $name")
    }
}

class ColoredShape(
    name: String,
    val color: String
) : InheritedShape(name) {
    
    override fun draw() {
        // Call parent's draw method first
        super.draw()
        // Then add our own behavior
        println("✏️  Using $color color")
    }
    
    override fun describe() {
        // Call parent's describe
        super.describe()
        // Add additional info
        println("It is colored in $color")
    }
}

// ============================================
// EXAMPLE 5: MULTI-LEVEL INHERITANCE
// ============================================

/*
 * Multi-level inheritance: GrandParent -> Parent -> Child
 * Like: Animal -> Mammal -> Dog
 */

// Level 1: GrandParent
open class LivingBeing {
    open fun breathe() {
        println("💨 Breathing...")
    }
}

// Level 2: Parent (inherits from LivingBeing)
open class Mammal : LivingBeing() {
    open fun feedMilk() {
        println("🍼 Feeding milk to babies")
    }
}

// Level 3: Child (inherits from Mammal, which inherits from LivingBeing)
class Human(val name: String) : Mammal() {
    fun speak() {
        println("🗣️  $name is speaking: Hello!")
    }
    
    fun showInheritedCapabilities() {
        println("\n$name can do:")
        breathe()        // From LivingBeing (grandparent)
        feedMilk()       // From Mammal (parent)
        speak()          // Own method
    }
}

// ============================================
// MAIN FUNCTION - DEMONSTRATION
// ============================================
fun main() {
    println("╔════════════════════════════════════════════╗")
    println("║      INHERITANCE - BEGINNER'S GUIDE       ║")
    println("╚════════════════════════════════════════════╝\n")
    
    // ========================================
    // EXAMPLE 1: Animal Hierarchy
    // ========================================
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 1: Animal Family 🐾")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
    
    // Create a generic animal
    val animal = Animal("Generic Animal", 5)
    animal.displayInfo()
    animal.makeSound()
    animal.eat()
    animal.sleep()
    
    println("\n--- Creating a Dog ---")
    val dog = Dog("Buddy", 3, "Golden Retriever")
    dog.displayInfo()
    dog.makeSound()     // Overridden - will bark
    dog.eat()           // Inherited from Animal
    dog.sleep()         // Inherited from Animal
    dog.bark()          // Dog's own method
    dog.wagTail()       // Dog's own method
    
    println("\n--- Creating a Cat ---")
    val cat = Cat("Whiskers", 2, "Orange")
    cat.displayInfo()
    cat.makeSound()     // Overridden - will meow
    cat.eat()           // Inherited from Animal
    cat.meow()          // Cat's own method
    cat.purr()          // Cat's own method
    cat.scratch()       // Cat's own method
    
    println("\n--- Creating a Bird ---")
    val bird = Bird("Tweety", 1, true)
    bird.displayInfo()
    bird.makeSound()    // Overridden - will chirp
    bird.eat()          // Inherited from Animal
    bird.fly()          // Bird's own method
    
    val penguin = Bird("Pingu", 4, false)
    println()
    penguin.displayInfo()
    penguin.fly()       // Penguin can't fly!
    
    // ========================================
    // EXAMPLE 2: Vehicle Hierarchy
    // ========================================
    println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 2: Vehicle Hierarchy 🚗")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
    
    val car = InheritedCar("Toyota", "Camry", 2023, 4)
    car.displayInfo()
    println()
    car.start()         // Overridden
    car.accelerate(50)  // Inherited from Vehicle
    car.accelerate(30)  // Inherited from Vehicle
    car.turnOnAC()      // Car's own method
    car.openTrunk()     // Car's own method
    println()
    car.displayInfo()
    println()
    car.stop()          // Inherited from Vehicle
    
    println("\n--- Motorcycle ---")
    val motorcycle = Motorcycle("Harley Davidson", "Iron 883", 2022, true)
    motorcycle.displayInfo()
    println()
    motorcycle.start()      // Overridden
    motorcycle.accelerate(20)
    motorcycle.wheelie()    // Too slow!
    motorcycle.accelerate(20)
    motorcycle.wheelie()    // Now it works!
    println()
    motorcycle.displayInfo()
    
    // ========================================
    // EXAMPLE 3: Employee Hierarchy
    // ========================================
    println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 3: Employee Hierarchy 👨‍💼")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
    
    val developer = Developer("DEV001", "Alice", 80000.0, "Kotlin")
    developer.displayInfo()
    println()
    developer.work()        // Overridden
    developer.writeCode()   // Developer's own method
    developer.debugCode()   // Developer's own method
    developer.takeBreak()   // Inherited from Employee
    developer.getYearEndBonus()
    
    println("\n--- Manager ---")
    val manager = Manager("MGR001", "Bob", 120000.0, 10)
    manager.displayInfo()
    println()
    manager.work()              // Overridden
    manager.conductMeeting()    // Manager's own method
    manager.reviewPerformance() // Manager's own method
    manager.takeBreak()         // Inherited from Employee
    manager.getYearEndBonus()
    
    // ========================================
    // EXAMPLE 4: Using 'super' Keyword
    // ========================================
    println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 4: Using 'super' Keyword")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
    
    val shape = InheritedShape("Circle")
    shape.draw()
    shape.describe()
    
    println("\n--- Colored Shape ---")
    val coloredShape = ColoredShape("Rectangle", "Blue")
    coloredShape.draw()      // Calls super.draw() PLUS own behavior
    println()
    coloredShape.describe()  // Calls super.describe() PLUS own behavior
    
    // ========================================
    // EXAMPLE 5: Multi-Level Inheritance
    // ========================================
    println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("EXAMPLE 5: Multi-Level Inheritance")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    
    val human = Human("John")
    human.showInheritedCapabilities()
    
    // ========================================
    // DEMONSTRATING POLYMORPHISM
    // ========================================
    println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    println("BONUS: Polymorphism (Using Parent Type)")
    println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
    
    // You can store child objects in parent type variables
    // This is called POLYMORPHISM
    val animals: List<Animal> = listOf(
        Dog("Max", 4, "Labrador"),
        Cat("Luna", 3, "Black"),
        Bird("Rio", 2, true)
    )
    
    println("All animals making sounds:")
    for (animal in animals) {
        animal.makeSound()  // Each will use their own overridden method!
    }
    
    println("\nAll animals eating:")
    for (animal in animals) {
        animal.eat()  // All use the same inherited method
    }
    
    // ========================================
    // KEY TAKEAWAYS
    // ========================================
    println("\n╔════════════════════════════════════════════╗")
    println("║           KEY TAKEAWAYS                    ║")
    println("╚════════════════════════════════════════════╝")
    println("""
        1. 🌳 INHERITANCE = Parent-Child Relationship
           - Child inherits properties and methods from Parent
           - Child can have its own additional features
        
        2. ✅ KEYWORDS TO REMEMBER:
           - 'open' = Makes class inheritable (parent must be open)
           - ':' = Symbol for inheritance (class Child : Parent())
           - 'override' = Change parent's method in child class
           - 'super' = Call parent's method from child class
        
        3. 💡 BENEFITS:
           - CODE REUSE: Write once, use in many classes
           - ORGANIZATION: Group similar classes
           - EASY MAINTENANCE: Change parent, all children updated
        
        4. 🎯 SIMPLE RULE:
           "If you have multiple classes with COMMON features,
            create a PARENT class with those features,
            and let children INHERIT from it."
        
        5. 📝 EXAMPLE:
           Animal (parent)
             ├── Dog (child) - has eat(), sleep() + bark()
             ├── Cat (child) - has eat(), sleep() + meow()
             └── Bird (child) - has eat(), sleep() + fly()
        
        6. 🔑 ACCESS LEVELS:
           - public: Everyone can access
           - protected: Only class and children can access
           - private: Only the class itself can access
        
        7. 🎨 POLYMORPHISM:
           You can treat child objects as parent type
           Example: val animal: Animal = Dog("Rex", 5, "Husky")
    """.trimIndent())
    
    println("\n╔════════════════════════════════════════════╗")
    println("║       END OF INHERITANCE TUTORIAL          ║")
    println("╚════════════════════════════════════════════╝")
}

