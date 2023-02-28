package kr.co.company.timeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    private var time = 0
    private var timerTask : Timer? = null

    private var isRunning = false

    lateinit var setButton : Button
    lateinit var timeEditText : EditText
    lateinit var secTextView : TextView
    lateinit var milliTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setButton = findViewById<Button>(R.id.setButton)
        timeEditText = findViewById<EditText>(R.id.timeEditText)

        secTextView = findViewById<TextView>(R.id.secTextView)
        milliTextView = findViewById<TextView>(R.id.milliTextView)

        setButton.setOnClickListener {
            if(timeEditText.text.toString().toInt() != 0){
                time = timeEditText.text.toString().toInt()*100
            }
            timerTask = timer(period=10){
                time--
                val sec = time/100
                val milli = time%100
                runOnUiThread {
                    secTextView.text = "$sec"
                    milliTextView.text = "$milli"
                }
                if(time==0){
                    runOnUiThread {
                        secTextView.text = "0"
                        milliTextView.text = "0"
                        timerTask?.cancel()
                    }
                }
            }


        }

    }



}