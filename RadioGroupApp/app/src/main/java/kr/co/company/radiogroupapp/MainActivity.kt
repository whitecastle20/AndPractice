package kr.co.company.radiogroupapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {

    lateinit var radioGroup : RadioGroup
    lateinit var radioApple : RadioButton
    lateinit var radioBanana : RadioButton
    lateinit var radioOrange : RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup = findViewById(R.id.radioGroup)
        radioApple = findViewById(R.id.radioApple)
        radioBanana = findViewById(R.id.radioBanana)
        radioOrange = findViewById(R.id.radioOrange)

    }
}