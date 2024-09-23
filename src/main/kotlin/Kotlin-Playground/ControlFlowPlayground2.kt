package org.hanazono

fun main(){
    // Exercise 1
    var pizzaSlices2 = 0
    var pizzaSlices1 = 0

    while (pizzaSlices1 < 8){
        println("There's only $pizzaSlices1 slice/s of a pizza :(")
        pizzaSlices1++

        if (pizzaSlices1 == 8){
            println("There's are $pizzaSlices1 slices of pizza. Hooray! We have the whole pizza! :D\n")
            break;
        }
    }

    do {println("There's only $pizzaSlices2 slice/s of a pizza :(")
        pizzaSlices2++

        if (pizzaSlices2 == 8){
            println("There's are $pizzaSlices2 slices of pizza. Hooray! We have the whole pizza! :D\n")
            break;
        }
    } while (pizzaSlices2 < 8)

    // Exercise 2
    for (number in 1..100){
        println(
            when {
                number % 15 == 0 -> "fizzbuzz"
                number % 3 == 0 -> "buzz"
                number % 5 == 0 -> "fizz"
                else -> "$number"
            }
        )
    }

    // Exercise 3
    var words = listOf("dinosaur", "1imousine", "magazine", "1anguage")

    for (word in words){
        if (word.startsWith("1")){
            println(word)
        }
    }
}