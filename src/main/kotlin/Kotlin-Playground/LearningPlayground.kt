package org.hanazono

import kotlin.random.Random

// Make guessing game
fun main(){
    println("Welcome to Guessing Game 100 \nChoose Your Difficulty: \n[0] - Easy | [1] - Difficult | [2] - Hardest")
    print(":")

    val chooseDifficult = readLine()?.toIntOrNull()
    var setDifficulty = 0

    val randomNumber = Random.nextInt(100)

    var guessedNumber: Int

    when (chooseDifficult){
        0 -> setDifficulty = 10
        1 -> setDifficulty = 7
        2 -> setDifficulty = 5
    }

    for (i in setDifficulty downTo 0) {
        print("You're Guess is: ")
        guessedNumber = readLine()?.toIntOrNull() ?: continue

        if (guessedNumber == randomNumber) {
            println("You Win! You guess the Right Number! $randomNumber = $guessedNumber");
            break
        } else {
            if (guessedNumber > randomNumber) {
                println("Lower!")
                println("You have: $i guesses left")
            } else {
                println("Higher!")
                println("You have: $i guesses left")
            }
        }
    }
}
