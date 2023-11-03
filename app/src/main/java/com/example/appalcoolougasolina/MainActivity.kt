package com.example.appalcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textIntputAlcool : TextInputLayout
    private lateinit var editAlcool : TextInputEditText


    private lateinit var textIntputGasolina : TextInputLayout
    private lateinit var editGasolina : TextInputEditText

    private lateinit var btnCalcular : Button
    private lateinit var textResultado : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializarComponetesInterface ()
            btnCalcular.setOnClickListener {
                calcularMelhorPreco()

        }

    }

    //Método que recuperar o preco do Alcool e Gasolina
    private fun calcularMelhorPreco() {

        val precoAlcool = editAlcool.text.toString()
        val precoGasolina = editGasolina.text.toString()

        val resultadoValidacao = validarCampos(precoAlcool, precoGasolina)

        if(resultadoValidacao){

            val precoAlcoolNumero = precoAlcool.toDouble()
            val precoGasolinaNumero = precoGasolina.toDouble()
            val resultado = precoAlcoolNumero / precoGasolinaNumero

            if(resultado >= 0.7){
                textResultado.text = "Melhor Utilizar Gasolina"
            } else {
                textResultado.text = "Melhor Utilizar Álcool"
            }

        }

    }

    private fun validarCampos(pAlcool: String, pGasolina: String): Boolean {

        textIntputAlcool.error = null
        textIntputGasolina.error = null

        if(pAlcool.isEmpty()){
            textIntputAlcool.error = "Digite o preço do Alcool"
            return false
        } else if(pGasolina.isEmpty()) {
            textIntputGasolina.error = "Digite o preço da Gasolina"
            return false
        }

    return true
    }

    private fun inicializarComponetesInterface() {

        textIntputAlcool = findViewById(R.id.text_input_alcool)
        editAlcool = findViewById(R.id.edit_alcool)

        textIntputGasolina = findViewById(R.id.text_input_gasolina)
        editGasolina = findViewById(R.id.edit_gasolina)

        btnCalcular = findViewById(R.id.btn_calcular)
        textResultado = findViewById(R.id.text_resultado)


    }
}