package kr.co.company.bmiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var edtHeight : EditText
    lateinit var edtWeight : EditText
    lateinit var edtName : EditText
    lateinit var buttonResult : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        edtHeight = findViewById(R.id.edtHeight)
        edtWeight = findViewById(R.id.edtWeight)
        edtName = findViewById(R.id.edtName)
        buttonResult = findViewById(R.id.buttonResult)

        loadData()

        buttonResult.setOnClickListener {
            saveData(edtHeight.text.toString().toInt(), edtWeight.text.toString().toInt())

            var intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height", edtHeight.text.toString())
            intent.putExtra("weight", edtWeight.text.toString())
            intent.putExtra("name", edtName.text.toString())
            startActivity(intent)

        }
    }

    private fun saveData(height: Int, weight: Int) {
        var pref = this.getPreferences(0)
        var editor = pref.edit()

        editor.putInt("KEY_HEIGHT", edtHeight.text.toString().toInt()).apply()
        editor.putInt("KEY_WEIGHT", edtWeight.text.toString().toInt()).apply()
        editor.putString("KEY_NAME", edtName.text.toString()).apply()
    }

    private fun loadData() {
        var pref = this.getPreferences(0)
        var height = pref.getInt("KEY_HEIGHT",0)
        var weight = pref.getInt("KEY_WEIGHT",0)
        var name = pref.getString("KEY_NAME","")

        if(height !=0 && weight != 0 && name != "") {
            edtHeight.setText(height.toString())
            edtWeight.setText(weight.toString())
            edtName.setText(name.toString())
        }
    }
}