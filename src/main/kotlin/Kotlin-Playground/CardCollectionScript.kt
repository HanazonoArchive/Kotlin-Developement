package org.hanazono

import java.io.File
import java.util.*

private val Card: MutableList<String> = mutableListOf("")
private val cardCollection: MutableMap<Int, String> = mutableMapOf()

private var exist: Boolean = false

fun main() {

    println("How Many Cards do you want to input? ")
    val cardQTYString = readln()
    var cardQTY: Int = cardQTYString.toInt()

    var cardSerial: Int
    var cardGrading: String
    var cardPrice: Float

    while (cardQTY > 0) {
        println("Card #: $cardQTY")
        println("Enter Serial Number: ")
        val cardSerialString = readln()
        cardSerial = cardSerialString.toInt()

        println("Enter Card Grading: ")
        val cardGradingString = readln()
        cardGradingString.uppercase(Locale.getDefault())
        cardGrading = cardGradingString

        println("Enter Card Price: ")
        val cardPriceString = readln()
        cardPrice = cardPriceString.toFloat()

        addingAlgorithm(cardSerial, cardGrading, cardPrice)
        cardQTY--
    }

    println("$Card")

    // Save Card details and cardCollection to files
    saveToFile("cardDetails.txt", Card)
    saveCollectionToFile("cardCollection.txt", cardCollection)

    println("Data saved successfully!")
}

// Function to add card data to the list
fun addingAlgorithm(Serial: Int, Grading: String, Price: Float) {
    val checkifExist: String = checkCollection(Serial)
    if (exist) {
        Card.add("Serial: ${Serial} | Grade: ${Grading} | Price: ${Price} | Card Name: $checkifExist\n")
    } else {
        println("Card doesn't exist in the collection. Enter the name of the card: ")
        val newCardName = readln()
        cardCollection[Serial] = newCardName
        Card.add("Serial: ${Serial} | Grade: ${Grading} | Price: ${Price} | Card Name: $newCardName\n")
    }
}

// Function to check if the card exists in the collection
fun checkCollection(Serial: Int): String {
    return if (cardCollection.containsKey(Serial)) {
        exist = true
        cardCollection[Serial].toString()
    } else {
        exist = false
        "Card Doesn't Exist in Collection"
    }
}

// Function to append Card list to a file
fun saveToFile(fileName: String, data: List<String>) {
    val file = File(fileName)
    data.forEach { cardDetails ->
        file.appendText(cardDetails)  // Append each card detail to the file
    }
}

// Function to append cardCollection map to a file
fun saveCollectionToFile(fileName: String, collection: Map<Int, String>) {
    val file = File(fileName)
    collection.forEach { (serial, cardName) ->
        file.appendText("Serial: $serial | Card Name: $cardName\n")  // Append each entry to the file
    }
}

