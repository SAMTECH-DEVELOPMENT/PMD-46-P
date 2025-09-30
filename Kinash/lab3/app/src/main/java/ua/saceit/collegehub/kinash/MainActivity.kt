package ua.saceit.collegehub.kinash

import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultText = findViewById(R.id.resultText)
        resultText.text = "Лабораторна №3 — введіть числа для обчислення суми"

        Log.d("MainActivity", "Лабораторна робота №3 — функції на Kotlin")
        Log.d("MainActivity", "Виконав студент групи 46-П — Кінаш Степан")
        Log.d("MainActivity", greet())

        promptNumbers()
    }

    fun sumArray(numbers: IntArray): Int {
        var sum = 0
        for (n in numbers) sum += n
        return sum
    }

    fun greet(name: String = "Guest"): String {
        return "Завдання: знайти суму чисел у масиві (введення з клавіатури)."
    }

    private fun promptNumbers() {
        val input = EditText(this).apply {
            inputType = InputType.TYPE_CLASS_TEXT
            hint = "Наприклад: 2, 5, 8, 10"
        }

        AlertDialog.Builder(this)
            .setTitle("Введення масиву чисел")
            .setMessage("Введіть числа через кому:")
            .setView(input)
            .setPositiveButton("Обчислити") { _, _ ->
                val text = input.text.toString().trim()
                if (text.isNotEmpty()) {
                    try {
                        val numbers = text.split(",").map { it.trim().toInt() }.toIntArray()
                        val result = sumArray(numbers)
                        val numbersStr = numbers.joinToString(", ")
                        Log.d("MainActivity", "Введений масив: $numbersStr")
                        Log.d("MainActivity", "Сума елементів масиву = $result")

                        resultText.text = "Масив: $numbersStr\nСума: $result"
                        Toast.makeText(this, "Сума: $result", Toast.LENGTH_SHORT).show()
                    } catch (e: Exception) {
                        resultText.text = "Помилка введення: перевірте формат чисел."
                        Toast.makeText(this, "Невірний формат. Приклад: 1, 2, 3", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    resultText.text = "Порожній ввід."
                }
            }
            .setNegativeButton("Скасувати", null)
            .show()
    }
}
