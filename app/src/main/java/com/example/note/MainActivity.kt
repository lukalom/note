package com.example.note

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.jar.Pack200

class MainActivity : AppCompatActivity() {


    private lateinit var editTextNote: EditText
    private lateinit var addButton: Button
    private lateinit var textView2: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        editTextNote=findViewById(R.id.editTextNote)
        addButton=findViewById(R.id.addButton)
        textView2=findViewById(R.id.textView2)

        val sharedPref = getSharedPreferences("MyNoteSharedPref", Context.MODE_PRIVATE)
        val savedText = sharedPref.getString("NOTE","")

        textView2.text = savedText 

        addButton.setOnClickListener {
            val input=editTextNote.text.toString()
            if (!TextUtils.isEmpty(input)){
                val text = textView2.text.toString()
                val resultText=input+ "\n" + text

                textView2.text = resultText
                editTextNote.setText("")
                sharedPref.edit().putString("NOTE", resultText).apply()





            }



        }


    }
}