package org.hanazono

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class CardManagerDB(private val connection: Connection) {

    // Add a card to the database
    fun addCard(serial: String, grading: String, price: Float, cardName: String) {
        val query = "INSERT INTO cards (serial, grading, price, card_name) VALUES (?, ?, ?, ?)"
        val statement = connection.prepareStatement(query)
        statement.setString(1, serial)
        statement.setString(2, grading)
        statement.setFloat(3, price)
        statement.setString(4, cardName)
        statement.executeUpdate()
        println("Card added to the database successfully!")
    }

    // Search for a card by serial number
    fun searchCard(serial: String): Map<String, Any>? {
        val query = "SELECT * FROM cards WHERE serial = ?"
        val statement = connection.prepareStatement(query)
        statement.setString(1, serial)
        val resultSet = statement.executeQuery()

        return if (resultSet.next()) {
            mapOf(
                "serial" to resultSet.getString("serial"),
                "grading" to resultSet.getString("grading"),
                "price" to resultSet.getFloat("price"),
                "card_name" to resultSet.getString("card_name")
            )
        } else {
            println("Card not found!")
            null
        }
    }

    // Update a card's details
    fun updateCard(serial: String, newGrading: String, newPrice: Float, newCardName: String) {
        val query = "UPDATE cards SET grading = ?, price = ?, card_name = ? WHERE serial = ?"
        val statement = connection.prepareStatement(query)
        statement.setString(1, newGrading)
        statement.setFloat(2, newPrice)
        statement.setString(3, newCardName)
        statement.setString(4, serial)
        statement.executeUpdate()
        println("Card updated successfully!")
    }

    // Delete a card by serial number
    fun deleteCard(serial: String) {
        val query = "DELETE FROM cards WHERE serial = ?"
        val statement = connection.prepareStatement(query)
        statement.setString(1, serial)
        statement.executeUpdate()
        println("Card deleted successfully!")
    }
}

fun main() {
    val connection = initializeDatabase()  // Initialize DB connection
    val cardManagerDB = CardManagerDB(connection)

    println("Card Collection Inquiry")
    println("[0] - Add Card\n[1] - Search Card\n[2] - Remove Card\n[3] - Update Card")
    val options = readln().toInt()

    when (options) {
        0 -> {
            println("[0] - Adding Card")
            println("Enter Serial Number: ")
            val serial = readln()
            println("Enter Card Grading: ")
            val grading = readln().uppercase()
            println("Enter Card Price: ")
            val price = readln().toFloat()
            println("Enter Card Name: ")
            val cardName = readln()

            cardManagerDB.addCard(serial, grading, price, cardName)
        }
        1 -> {
            println("[1] - Searching Card")
            println("Enter Serial Number to search: ")
            val serial = readln()
            val card = cardManagerDB.searchCard(serial)
            card?.let {
                println("Card found: $it")
            }
        }
        2 -> {
            println("[2] - Removing Card")
            println("Enter Serial Number to remove: ")
            val serial = readln()
            cardManagerDB.deleteCard(serial)
        }
        3 -> {
            println("[3] - Updating Card")
            println("Enter Serial Number to update: ")
            val serial = readln()
            println("Enter New Grading: ")
            val newGrading = readln().uppercase()
            println("Enter New Price: ")
            val newPrice = readln().toFloat()
            println("Enter New Card Name: ")
            val newCardName = readln()

            cardManagerDB.updateCard(serial, newGrading, newPrice, newCardName)
        }
    }
}

// Initialize database connection
fun initializeDatabase(): Connection {
    val jdbcUrl = "jdbc:mysql://localhost:3306/card_collection_db"  // Ensure your DB name is correct
    val username = "root"  // Default MySQL username for XAMPP
    val password = ""  // Default password, typically empty for XAMPP

    return try {
        DriverManager.getConnection(jdbcUrl, username, password).also {
            println("Connected to the database successfully!")
        }
    } catch (ex: SQLException) {
        throw RuntimeException("Failed to connect to the database", ex)
    }
}

