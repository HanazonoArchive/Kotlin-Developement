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

}