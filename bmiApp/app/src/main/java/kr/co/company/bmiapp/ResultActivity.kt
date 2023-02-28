package kr.co.company.bmiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ResultActivity : AppCompatActivity() {

    lateinit var editText : TextView
    lateinit var imageView : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        editText = findViewById(R.id.editText)
        imageView = findViewById(R.id.imageView)

        var height = intent.getStringExtra("height")!!.toInt()
        var weight = intent.getStringExtra("weight")!!.toInt()
        var name = intent.getStringExtra("name")!!

        val bmi = weight / Math.pow(height/100.0, 2.0)
        when{
            bmi >= 23  -> imageView.setImageResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_24)
            bmi > 18.5  -> imageView.setImageResource(R.drawable.ic_baseline_sentiment_satisfied_alt_24)
            else  -> imageView.setImageResource(R.drawable.ic_baseline_mood_bad_24)

        }

        when{
            bmi >= 35  -> editText.text = "고도 비만"
            bmi >= 30 -> editText.text = "2단계 비만"
            bmi >= 25  -> editText.text = "1단계 비만"
            bmi >= 23  -> editText.text = "과제충"
            bmi >= 18.5  -> editText.text = "정상"
            else -> editText.text = "저체중"
        }

        Toast.makeText(this, "$name" + " : " + "$bmi", Toast.LENGTH_SHORT).show()

    }
}