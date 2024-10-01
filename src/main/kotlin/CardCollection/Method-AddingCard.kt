package org.hanazono

import java.io.File
import java.util.*

class CardManager {
    private val cardList: MutableList<String> = mutableListOf("")
    private val cardCollection: MutableMap<String, String> = mutableMapOf()

    private var exist: Boolean = false

    // Method to start the card input process
    fun addCards() {
        println("How many cards do you want to input? ")
        val cardQTYString = readln()
        var cardQTY: Int = cardQTYString.toInt()

        while (cardQTY > 0) {
            println("Card #: $cardQTY")
            println("Enter Serial Number: ")
            val cardSerial = readln()

            println("Enter Card Grading: ")
            val cardGrading = readln().uppercase(Locale.getDefault())

            println("Enter Card Price: ")
            val cardPrice = readln().toFloat()

            addingAlgorithm(cardSerial, cardGrading, cardPrice)
            cardQTY--
        }

        println("$cardList")

        // Save Card details and cardCollection to files
        saveToFile("cardDetails.txt", cardList)
        saveCollectionToFile("cardCollection.txt", cardCollection)

        println("Data saved successfully!")
    }

    // Method to add card data to the list
    private fun addingAlgorithm(serial: String, grading: String, price: Float) {
        val checkifExist: String = checkCollection(serial)
        if (exist) {
            cardList.add("Serial: $serial | Grade: $grading | Price: $price | Card Name: $checkifExist\n")
        } else {
            println("Card doesn't exist in the collection. Enter the name of the card: ")
            val newCardName = readln()
            cardCollection[serial] = newCardName
            cardList.add("Serial: $serial | Grade: $grading | Price: $price | Card Name: $newCardName\n")
        }
    }

    // Method to check if the card exists in the collection
    private fun checkCollection(serial: String): String {
        return if (cardCollection.containsKey(serial)) {
            exist = true
            cardCollection[serial].toString()
        } else {
            exist = false
            "Card Doesn't Exist in Collection"
        }
    }

    // Method to append Card list to a file
    private fun saveToFile(fileName: String, data: List<String>) {
        val file = File(fileName)
        data.forEach { cardDetails ->
            file.appendText(cardDetails)  // Append each card detail to the file
        }
    }

    // Method to append cardCollection map to a file
    private fun saveCollectionToFile(fileName: String, collection: Map<String, String>) {
        val file = File(fileName)
        collection.forEach { (serial, cardName) ->
            file.appendText("Serial: $serial | Card Name: $cardName\n")  // Append each entry to the file
        }
    }
}
