package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import net.snkey.millionaire.Rounds

class MainActivity : AppCompatActivity() {
    private lateinit var tvQ: TextView
    private lateinit var tvQV: TextView
    private lateinit var B1: Button
    private lateinit var B2: Button
    private lateinit var B3: Button
    private lateinit var B4: Button
    private var CR = 0
    private val rounds = mutableListOf<Rounds>()

    private fun fillRounds() {
        rounds.run {
            add(Rounds("Что такое Луна?", "Звезда", "Планета", "Спутник", "Круг сыра", 3, 100))
            add(Rounds("В каком году запущен первый спутник?", "1957", "1961", "1965", "1969", 1, 1_000))
            add(Rounds("Сколько спутников у Марса?", "0", "1", "2", "4", 3, 10_000))
            add(Rounds("Как называется спутник Плутона?", "Нет спутников", "Харон", "Энцелад", "Ио", 2, 100_000))
            add(Rounds("Какой крупнейший спутник у Юпитера?", "Европа", "Каллисто", "Титан", "Ганимед", 4, 1_000_000))
        }
        tvQ.text = rounds[CR].question
        tvQV.text = rounds[CR].value.toString()
        B1.text = rounds[CR].answer1
        B2.text = rounds[CR].answer2
        B3.text = rounds[CR].answer3
        B4.text = rounds[CR].answer4
    }

        private fun checkAnswer (givenId: Int) =
        (givenId == rounds[CR].rightId)

        private fun goNextRound() : Boolean {
            if (CR >= rounds.size - 1){
                return false
            }
            else {
                CR++
                fillRounds()
                return true
                }
            }


    private fun processRound (givenId: Int) {
        if (checkAnswer (givenId)) {
            if (!goNextRound()) {
                Toast.makeText(this, "YOU WIN! :)", Toast.LENGTH_SHORT).show()
                finish()
            }
        } else {
            Toast.makeText(this, "YOU LOOSE (", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            tvQ = findViewById(R.id.textView)
            tvQV = findViewById(R.id.textView2)
            B1 = findViewById(R.id.button)
            B2 = findViewById(R.id.button2)
            B3 = findViewById(R.id.button3)
            B4 = findViewById(R.id.button4)

            fillRounds()

            B1.setOnClickListener { processRound(1) }
            B2.setOnClickListener { processRound(2) }
            B3.setOnClickListener { processRound(3) }
            B4.setOnClickListener { processRound(4) }
        }


    }
