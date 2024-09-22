package org.hanazono

fun main() {
    // Printing "Hello World"
    println("Hello World!")

    //================================================================================//

    // Variables
    //= 'val' is a read-only variables, you can think of this as 'final' on java
    //= 'var' is a mutable variables, means you can change the value of the variables

    val popcorn = 5 //We have 5 Popcorn in our inventory - can't replenish
    val hotdog = 7 //We have 7 Hotdog in our inventory - can't replenish
    var customer1 = 10 //We have 10 Customer in a queue - customer decrease or increase

    //= Some customers leave the queue
    customer1 = 8
    println(customer1)
    // OUTPUT: 8

    //================================================================================//

    // String Templates
    //= '$' is a string template, you can think of this as when we trying to print string var in println
    //= "something $variable something" as you can see 'something' is a normal text, '$variable' is variable

    val customer2 = 10
    println("There are $customer2 customers")
    // OUTPUT: There are 10 customers

    println("There are ${customer2 + 1} customers")
    // OUTPUT: There are 11 Customers
}