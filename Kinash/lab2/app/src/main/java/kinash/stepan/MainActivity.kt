package kinash.stepan

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputX: EditText = findViewById(R.id.inputX)
        val inputY: EditText = findViewById(R.id.inputY)
        val inputB: EditText = findViewById(R.id.inputB)
        val button: Button = findViewById(R.id.calcButton)
        val resultText: TextView = findViewById(R.id.resultText)

        button.setOnClickListener {
            try {
                val x = inputX.text.toString().toFloat()
                val y = inputY.text.toString().toFloat()
                val b = inputB.text.toString().toFloat()

                val denom = 2f * x - y
                if (denom == 0f) {
                    resultText.text = "Помилка: ділення на нуль!"
                } else {
                    val result = (((x + y) / denom) * (x + b) * sin(x.toDouble())).toFloat()
                    resultText.text = "Результат: $result"
                }
            } catch (e: Exception) {
                resultText.text = "Помилка: введіть правильні числа"
            }
        }
    }
}