package me.dio.imc_app

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }
    private fun setListeners(){
        alturaEDT?.doAfterTextChanged { text ->
           // Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        }
        pesoEDT?.doOnTextChanged { text, start, before, count ->
           // titleTXT?.text = text
        }
        calcularbtn.setOnClickListener {
            CalcularIMC(pesoEDT.text.toString(), alturaEDT.text.toString())
        }
    }
    private fun CalcularIMC(peso: String, altura: String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if (peso != null && altura != null){
            val imc = peso/(altura*altura)
            titleTXT.text = "O seu IMC é de %.2f".format(imc)
        } else {
            titleTXT.text = "Dados incompletos"
        }

    }
}