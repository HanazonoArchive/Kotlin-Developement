package org.hanazono

fun main() {
    println("Card Collection Inquiry")
    println("[0] - Add Card\n[1] - Search Card\n[2] - Remove Card\n[3] - Update Card")
    val options = readln().toInt()

    when (options) {
        0 -> {
            println("[0] - Adding Card")
            val cardManager = CardManager()
            cardManager.addCards()
        }
        1 -> {
            println("[1] - Searching Card")
        }
        2 -> {
            println("[2] - Removing Card")
        }
        3 -> {
            println("[3] - Updating Card")
        }
    }
}