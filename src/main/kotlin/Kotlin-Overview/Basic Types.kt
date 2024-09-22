package org.hanazono

fun main(){
    // Basic Types
    // +=, -=, *=, /=, and %= are augmented assignment operations.
    var customers1 = 8

    // Some customers leave the queue
    customers1 = 8

    customers1 = customers1 + 3 // Example of addition: 11
    customers1 += 7             // Example of addition: 18
    customers1 -= 3             // Example of subtraction: 15
    customers1 *= 2             // Example of multiplication: 30
    customers1 /= 3             // Example of division: 10

    println(customers1)
    // OUTPUT: 10

    //================================================================================//

    /*| Category              | Basic Types                | Example Code                                             |
    * |Integers               |Bytes, Short, Int, Long     |val year: Int = 2020                                      |
    * |Unsigned Integers      |UByte, UShort, UInt, ULong  |val score: UInt = 100u                                    |
    * |Floating-point numbers |Float, Double               |val currentTemp: Float = 24.5f, val price: Double = 19.99 |
    * |Booleans               |Boolean                     |val isEnabled: Boolean = true                             |
    * |Characters             |Char                        |val separator: Char = ' ,'                                |
    * |Strings                |String                      |val message: String = "Hello, World!"                     |*/

    // With this knowledge, you can declare variables and initialize them later. Kotlin can manage this as long as
    // variables are initialized before the first read.

    // To declare a variable without initializing it, specify its type with ':' For Example:

    //= Variable declared without initialization
    val d: Int
    //= Variable initialized
    d = 3

    //= Variable explicitly type and initialized
    val e: String = "Hello"

    //= Variables can be read because they have been initialized
    println(d) // OUTPUT: 3
    println(e) // OUTPUT: Hello

    // If you don't initialize a variable before it is read, you see an error:

    //= Variable declared without initialization
    val f: Int
    f = 1 // #PLACEHOLDER Remove this to see the ERROR

    //= Triggers an Error
    println(f)
    // OUTPUT: Variable 'f' must be initialized
}