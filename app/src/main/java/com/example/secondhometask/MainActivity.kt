package com.example.secondhometask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var ru2EnButton: Button
    lateinit var en2RuButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ru2EnButton = findViewById(R.id.ru_to_en_button)
        en2RuButton = findViewById(R.id.en_to_ru_button)

        ru2EnButton.setOnClickListener(listener)
        en2RuButton.setOnClickListener(listener)
    }

    val listener = View.OnClickListener { view ->
        when(view.id){
            R.id.ru_to_en_button -> {
                val ruTextInput =findViewById<TextInputEditText>(R.id.rus_input_et)
                val enTextInput =findViewById<TextInputEditText>(R.id.en_input_et)
                enTextInput.setText(translitRu2En(ruTextInput.text.toString()))
            }
            R.id.en_to_ru_button -> {
                val ruTextInput =findViewById<TextInputEditText>(R.id.rus_input_et)
                val enTextInput = findViewById<TextInputEditText>(R.id.en_input_et)
                ruTextInput.setText(translitEn2Ru(enTextInput.text.toString()))

            }
        }
    }
}

var engArr = arrayListOf<String>("shch","kh","ie","ch", "sh", "ts", "zh",
    "iu", "ia", "a", "b", "v", "g", "d", "e", "z", "i", "k", "l", "m", "n", "o", "p",
    "r", "s", "t", "u", "f", "y", "e", "e", "i")

var ruArr = arrayListOf<String>("щ","х","ъ","ч", "ш", "ц", "ж", "ю",
    "я", "а", "б", "в", "г", "д", "е", "з", "и", "к", "л", "м", "н", "о", "п",
    "р", "с", "т", "у", "ф", "ы", "э", "ё", "й")

fun translitRu2En(str: String):String{
    var res = str.lowercase().replace("ь", "")

    for (i in 0 until ruArr.size){
        if (res.indexOf(ruArr[i]) >= 0){
            res = res.replace(ruArr[i], engArr[i])
        }
    }
    return res.replaceFirstChar { it.uppercase() }
}

fun translitEn2Ru(str: String):String{
    var res = str.lowercase()

    for (i in 0 until engArr.size){
        if (res.indexOf(engArr[i]) >= 0){
            res = res.replace(engArr[i], ruArr[i])
        }
    }
    return res.replaceFirstChar { it.uppercase() }
}