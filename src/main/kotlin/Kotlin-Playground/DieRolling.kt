package org.hanazono

import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.application.Application
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.control.Button
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.Text
import javafx.stage.Stage
import javafx.util.Duration
import kotlin.random.Random

class DiceRollerApp : Application() {

    private val players: MutableMap<String, Int?> = mutableMapOf(
        "Abas" to 11, "Agsoy" to 12, "Andong" to 13, "Asan" to 14,
        "Baguio" to 21, "Bardago" to 22, "Barnido" to 23, "Bravo" to 24,
        "Cabarde" to 31, "Cahilig" to 32, "Ching" to 33, "Coyoca" to 34,
        "Dingal" to 41, "Dionaldo" to 42, "Duhaylungsod" to 43, "Ednilan" to 44,
        "Estorosos" to 51, "Ferrer" to 52, "Gellica" to 53, "Gerardo" to 54,
        "Gerarman" to 61, "Hingpit" to 62, "Libres" to 63, "Lozano" to 64,
        "Lusica" to 71, "Macabenta" to 72, "Mayugba" to 73, "Miano" to 74,
        "Montejo" to 81, "Nanding" to 82, "Nerosa" to 83, "Palma" to 84,
        "Pechayco" to 91, "Pintor" to 92, "Sarmiento" to 93, "Talib" to 94,
        "Tosorero" to 101, "Travilla" to 102, "Villaneva" to 103, "Ycong" to 104
    )

    // Remove reporters
    init {
        players.remove("Agsoy")
        players.remove("Palma")
        players.remove("Pechayco")
        players.remove("Dingal")
    }

    override fun start(primaryStage: Stage) {
        val canvas = Canvas(300.0, 300.0)
        val gc: GraphicsContext = canvas.graphicsContext2D
        drawDice(gc, 0, 0)

        val resultText = Text("")
        resultText.font = Font(20.0)
        resultText.fill = Color.BLACK

        val rollButton = Button("Roll Dice")

        rollButton.setOnAction {
            rollDice(gc, resultText)
        }

        val root = StackPane(canvas, rollButton, resultText)
        StackPane.setAlignment(rollButton, Pos.BOTTOM_CENTER)
        StackPane.setAlignment(resultText, Pos.TOP_CENTER)

        val scene = Scene(root, 300.0, 350.0)
        primaryStage.title = "Dice Roller"
        primaryStage.scene = scene
        primaryStage.show()
    }

    private var lastRollD10: Int = 0
    private var lastRollD4: Int = 0

    private fun rollDice(gc: GraphicsContext, resultText: Text) {
        val timeline = Timeline(KeyFrame(Duration.seconds(0.1), {
            // Roll the dice
            lastRollD10 = Random.nextInt(1, 11)
            lastRollD4 = Random.nextInt(1, 5)
            drawDice(gc, lastRollD10, lastRollD4)

            resultText.text = "Rolling... (Roll: $lastRollD10$lastRollD4)"
        }))

        timeline.cycleCount = 20

        timeline.setOnFinished {
            val combineDice = "$lastRollD10$lastRollD4"
            val matchingPlayers = players.filter { (_, value) ->
                value.toString() == combineDice
            }

            if (matchingPlayers.isNotEmpty()) {
                val selectedPlayer = matchingPlayers.keys.random()
                resultText.text = "Matched: $selectedPlayer (Roll: $combineDice)"
                players.remove(selectedPlayer)
            } else {
                resultText.text = "No matches found for roll: $combineDice"
            }
        }

        timeline.play()
    }

    private fun drawDice(gc: GraphicsContext, d10: Int, d4: Int) {
        gc.clearRect(0.0, 0.0, 300.0, 300.0)

        gc.fill = Color.BLUE
        gc.fillRoundRect(50.0, 50.0, 100.0, 100.0, 20.0, 20.0)
        gc.fill = Color.WHITE
        gc.font = Font(40.0)
        gc.fillText(d10.toString(), 90.0, 120.0)

        gc.fill = Color.RED
        gc.fillRoundRect(150.0, 150.0, 100.0, 100.0, 20.0, 20.0)
        gc.fill = Color.WHITE
        gc.font = Font(40.0)
        gc.fillText(d4.toString(), 190.0, 220.0)
    }
}

fun main() {
    Application.launch(DiceRollerApp::class.java)
}
