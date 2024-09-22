package org.hanazono
import kotlin.random.Random

fun main(){
    val trafficLightState = "Red" // This can be "Green", "Yellow", or "Red"

    val trafficAction = when {
        trafficLightState == "Green" -> "Go"
        trafficLightState == "Yellow" -> "Slow down"
        trafficLightState == "Red" -> "Stop"
        else -> "Malfunction"
    }

    println(trafficAction)
    // OUTPUT: Stop

    // However, you can have the same code but with 'trafficLightState' as the subject:

    val trafficAction1 = when (trafficLightState){
        "Green" -> "Go"
        "Yellow" -> "Slow down"
        "Red" -> "Stop"
        else -> "Malfunction"
    }
    println(trafficAction1)
    // OUTPUT: Stop


    // Exercise #1 - if Statement
    val firstResult = Random.nextInt(6)
    val secondResult = Random.nextInt(6)

    if (firstResult == secondResult)
        println("You win :) $firstResult = $secondResult")
    else
        println("You lose :( $firstResult != $secondResult")


    // Exercise #2 - When Expression
    val button = "A"

    println(
        when (button){
            "A" -> "Yes"
            "B" -> "No"
            "X" -> "Menu"
            "Y" -> "Nothing"
            else -> "There is no such button"
        }
    )
}