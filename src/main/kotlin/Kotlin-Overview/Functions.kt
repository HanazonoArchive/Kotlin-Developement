package org.hanazono

import javax.annotation.processing.Messager

fun main(){
    // Functions

    //= You can declare your own functions in kotlin using the fun keyword
    // References: fun hello()
    hello()
    // OUTPUT: Hello World!

    //= Function parameters are written within parentheses '()'
    //= Each parameter must have a type, and multiple parameters must be separated by commas '.'
    //= The return type is written after the function's parentheses '()', separated by colon ':'
    //= The body of a function is written within curly braces '{}'
    //= The 'return' keyword is used to exit or return something from a function.

    //= ! If a function doesn't return anything useful, the return type and 'return' keyword can be omitted.

    //= In the following example:
    //= 'x' and 'y' are function parameters.
    //= 'x' and 'y' have type 'Int'.
    //= The function's return type is 'Int'
    //= The function returns a sum of 'x' and 'y' when called.

    //= References: fun sum (x: Int, y: Int): Int
    println(sum1(1,2))
    // OUTPUT: 3

    //= ! We recommend in your coding conventions that name functions starting with a lowercase and
    // use camel case with no underscore


    //================================================================================//


    // Named arguments - Functions
    //= For concise code, when calling your function, you don't have to include parameter names. However,
    // including parameter names does make your code easier to read. This is called using 'named arguments'.
    // If you do include parameter names, then you can write the parameters in any order.

    //= In the following example, string templates ('$') are used to access the parameter values, convert them
    // to 'String' type, and then concatenate them into a string for printing.

    //= References: fun printMessageWithPrefix(message: String, prefix: String)
    printMessageWithPrefix(prefix = "Log", message = "Hello")
    // OUTPUT: [Log] Hello


    //================================================================================//


    // Default Parameter Values - Functions
    //= You can define default values for your function parameters. Any parameter with a default value can be
    // omitted when calling your function. To declare a default value, use the assignment operator '=' after the type:

    // Function called with both parameters
    printMessageWithPrefix("Hello","Log")
    // OUTPUT: [Log] Hello

    // Function called only with message parameter
    printMessageWithPrefix("Hello", "Info")
    // OUTPUT: [Info] Hello

    //= ! You can skip specific parameters with default values, rather than omitting them all. However,
    // after the first skipped parameter, you must name all subsequent parameters.


    //================================================================================//


    // Functions without return - Functions
    //= If your function doesn't return a useful value then it's return type is 'Unit'. 'Unit' is a type with only
    // one value - 'Unit'. You don't have to declare that 'Unit' is returned explicitly in your function body. This
    // means that you don't have to use the 'return' keyword or declare a return type:

    // References: fun printMessage(message: String)
    printMessage("Hello")
    // OUTPUT: Hello


    //================================================================================//


    // Single-Expression Functions - Functions
    //= To make your code more concise, you can use single-expression functions. For example, the 'sum()' function can
    // be shortened:

    // References: fun sum2 (x: Int, y: Int): Int
    sum2(1,2)
    // OUTPUT: 3

    //= You can remove the curly braces '{}' and declare the function body using the assignment operator '=', Kotlin uses
    // type inference, so you can also omit the return type. The 'sum()' function then becomes one line:

    // References: fun sum3 (x: Int, y: Int) = x + y
    println(sum3(1,2))
    // OUTPUT: 3

    //= However, if you want your code to be quickly understood by other developers, it's a good idea to explicitly define
    // the return type even when using the assignment operator '='.

    //= ! If you use '{}' curly braces to declare your function body, you must declare the return type unless it is the
    // 'Unit' type.

    //================================================================================//


    // Continue LINK: (https://kotlinlang.org/docs/kotlin-tour-functions.html#early-returns-in-functions

}
// References: Line 8
fun hello(){
    println("Hello World!")
}
// References: Line 26
fun sum1 (x: Int, y: Int): Int {
    return x + y
}
// References: Line 47
fun printMessageWithPrefix(message: String, prefix: String){
    println("[$prefix] $message")
}
// References: Line 79
fun printMessage(message: String){
    println(message)
}
// References: Line 91
fun sum2 (x: Int, y: Int): Int {
    return x + y
}
// References: Line 98
fun sum3 (x: Int, y: Int) = x + y