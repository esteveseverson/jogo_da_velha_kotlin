package com.example.jogo_da_velha

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var jogador_atual = "X"
    private val tabuleiro = Array(3) { arrayOfNulls<String>(3) }
    private lateinit var buttons: Array<Array<Button>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttons = arrayOf(
            arrayOf(findViewById(R.id.button1), findViewById(R.id.button2), findViewById(R.id.button3)),
            arrayOf(findViewById(R.id.button4), findViewById(R.id.button5), findViewById(R.id.button6)),
            arrayOf(findViewById(R.id.button7), findViewById(R.id.button8), findViewById(R.id.button9))
        )

        for (i in buttons.indices) {
            for (j in buttons[i].indices) {
                buttons[i][j].setOnClickListener {
                    onCellClicked(it as Button, i, j)
                }
            }
        }
    }

    private fun onCellClicked(button: Button, row: Int, col: Int) {
        if (button.text.isNotEmpty()) {
            return
        }

        button.text = jogador_atual
        tabuleiro[row][col] = jogador_atual

        if (checkWin()) {
            Toast.makeText(this, "Player $jogador_atual wins!", Toast.LENGTH_LONG).show()
            resetBoard()
        } else {
            jogador_atual = if (jogador_atual == "X") "O" else "X"
        }
    }

    private fun checkWin(): Boolean {
        // Check rows and columns
        for (i in 0..2) {
            if (tabuleiro[i][0] == jogador_atual && tabuleiro[i][1] == jogador_atual && tabuleiro[i][2] == jogador_atual) return true
            if (tabuleiro[0][i] == jogador_atual && tabuleiro[1][i] == jogador_atual && tabuleiro[2][i] == jogador_atual) return true
        }

        // Check diagonals
        if (tabuleiro[0][0] == jogador_atual && tabuleiro[1][1] == jogador_atual && tabuleiro[2][2] == jogador_atual) return true
        if (tabuleiro[0][2] == jogador_atual && tabuleiro[1][1] == jogador_atual && tabuleiro[2][0] == jogador_atual) return true

        return false
    }

    private fun resetBoard() {
        for (i in tabuleiro.indices) {
            for (j in tabuleiro[i].indices) {
                tabuleiro[i][j] = null
                buttons[i][j].text = ""
            }
        }
        jogador_atual = "X"
    }
}