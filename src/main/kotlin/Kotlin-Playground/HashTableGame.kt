package org.hanazono

fun main(){
    val players: MutableMap<String, Int?> = mutableMapOf("Abas" to 11, "Agsoy" to 12, "Andong" to 13, "Asan" to 14,
                                                        "Baguio" to 21, "Bardago" to 22, "Barnido" to 23, "Bravo" to 24,
                                                        "Cabarde" to 31, "Cahilig" to 32, "Ching" to 33, "Coyoca" to 34,
                                                        "Dingal" to 41, "Dionaldo" to 42, "Duhaylungsod" to 43, "Ednilan" to 44,
                                                        "Estorosos" to 51, "Ferrer" to 52, "Gellica" to 53, "Gerardo" to 54,
                                                        "Gerarman" to 61, "Hingpit" to 62, "Libres" to 63, "Lozano" to 64,
                                                        "Lusica" to 71, "Macabenta" to 72, "Mayugba" to 73,"Miano" to 74,
                                                        "Montejo" to 81, "Nanding" to 82, "Nerosa" to 83, "Palma" to 84,
                                                        "Pechayco" to 91, "Pintor" to 92, "Sarmiento" to 93, "Talib" to 94,
                                                        "Tosorero" to 101, "Travilla" to 102, "Villaneva" to 103, "Ycong" to 104)

    //Reporters
    players.remove("Agsoy")
    players.remove("Palma")
    players.remove("Pechayco")
    players.remove("Dingal")

    var questionsAvailable = 10

    while (questionsAvailable != 0){
        val die1 = (1..10).random()
        val die2 = (1..4).random()

        val combineDice = "$die1$die2"

        val matchingPlayers = players.filter { (key, value) ->
            value.toString() == combineDice
        }

        println("First roll is: $die1")
        println("Second roll is: $die2")

        if (matchingPlayers.isNotEmpty()) {
            println("\nMatching players: ${matchingPlayers.keys} with $combineDice")

            val selectedPlayer = matchingPlayers.keys.random()
            println("Selected player: $selectedPlayer")

            players[selectedPlayer] = null
            println("$selectedPlayer has been skipped.\n")
        } else {
            println("No Matches found.\n")
            questionsAvailable += 1
        }
        questionsAvailable -= 1
    }
}