package org.hanazono

fun main(){

    // Conditional Expressions

    //= Kotlin provides 'if' and 'when' checking conditional expressions.

    //=! if you have to choose between 'if' and 'when', we recommend using 'when'
    //= because it:
    //= * Makes your code easier to read
    //= * Makes it easier to add another branch
    //= * Leads to fewer mistakes in your code

    // If - Conditional Statement

    // To use 'if', add the conditional expressions within the parentheses '()' and the
    // action to take if the result is true within curly braces '{}':
    val d: Int
    val check = true

    if (check) {
        d = 1
    } else {
        d = 2
    }

    println(d)
    // OUTPUT: 1

    // There is no ternary operator 'condition ? then : else' in Kotlin. Instead, if can be used
    // as an expression. If there is only one line of code per action, then curly braces '{}' are
    // optional:
    val a = 1
    val b = 2

    println(if(a > b) a else b) // Returns a value: 2
    // OUTPUT: 2


    //================================================================================//


    // When - Conditional Statement

    // Use 'when' when you have a conditional expression with multiple branches.
    // To use 'when:'
    // * Place the value you want to evaluate with in parentheses '()'
    // * Place the branches within curly braces '{}'
    // * Use '->' in each branch to separate each check from the action to take if the check is successful.

    // 'when' can be used either as a statement or as an expression. A 'statement' doesn't return anything
    // but performs actions instead.

    // Here is example of using 'when' as a statement:
    val obj = "Hello"

    when (obj) {
        // Checks whether obj equals to 1
        "1" -> println("one")
        "Hello" -> println("Greeting")
        else -> println("Unknown")
    }
    // OUTPUT: Greeting

    //= ! Note that all branch conditions are checked sequentially until one of them is satisfied.
    //= So only the first suitable branch is executed.

    // An 'expression' returns a value that can be used later in your code.
    // Here is an example of using 'when' as an expression. The 'when' expression is assigned
    // immediately to a variable which is later used with the 'println()' function

    val result = when (obj) {
        // If obj equals "1", sets result to "one"
        "1" -> "One"
        // If obj equals "Hello", sets result to "Greeting"
        "Hello" -> "Greeting"
        // Sets result to "Unknown" if no previous condition is satisfied
        else -> "Unknown"
    }

    println(result)
    // OUTPUT: Greeting

    //The examples of 'when' that you've seen so far both had a subject: 'obj'. But when can also used without
    // a subject.

    //This example uses a 'when' expression 'without' a subject to check a chain of boolean expressions:

    //REFER TO (Kotlin-Playground/ControlFlowPlayground1.kt)


    //================================================================================//


    // Loops

    //= The two most common loop structures in programming are 'for' and 'while'. Use for to iterate over a
    // range of values and perform an action. Use 'while' to continue an action until a particular condition
    // is satisfied.

    // For - Loops
    //= Using you new knowledge of ranges, you can create 'for' loop that iterates over numbers 1 to 5
    // and prints the number each time.
    //= Place the iterator and range within parentheses '()' with keyword 'in'. Add the action you want
    // to complete within curly braces '[]:'

    for (number in 1..5){
        // number is the iterator and 1..5 is the range
        println(number)
    }
    // OUTPUT: 1 2 3 4 5

    //= Collections can also be iterated over by loops:

    val cakes = listOf("carrot", "cheese", "chocolate")

    for (cake in cakes) {
        println("Yummy, it's a $cake cake!")
    }
    /* OUTPUT:
    * Yummy, it's a carrot cake!
    * Yummy, it's a cheese cake!
    * Yummy, it's a chocolate cake!*/


    //================================================================================//


    // While - Loops

    // 'while' can be used in 2 ways:

    //= To execute a code block while a conditional expression is true. ('while')
    //= To execute the code block first then check the conditional expressions. ('do-while')

    // In the first use case ('while'):

    //= Declare the conditional expression for your while loop to continue within parentheses '()'
    //= Add the action you want to complete within curly braces '{}'

    var cakesEaten = 0

    while (cakesEaten < 3){
        println("Eat a cake")
        cakesEaten++
    }
    // OUTPUT:
    // Eat a cake
    // Eat a cake
    // Eat a cake

    // In the second use case (do-while):

    //= Declare the conditional expression for your while loop to continue within parentheses '()'
    //= Define the action you want to complete within curly braces '{}' with the keyword do

    cakesEaten = 0
    var cakesBaked = 0

    while (cakesEaten < 3){
        println("Eat a cake")
        cakesEaten++
    }
    do {
        println("Bake a cake")
        cakesBaked++
    } while (cakesBaked < cakesEaten)
    /* OUTPUT:
    * Eat a cake
    * Eat a cake
    * Eat a cake
    * Bake a cake
    * Bake a cake
    * Bake a cake */

    //REFER TO (Kotlin-Playground/ControlFlowPlayground2.kt) - for Exercise
    // Continue LINK: (https://kotlinlang.org/docs/kotlin-tour-functions.html#named-arguments)


}