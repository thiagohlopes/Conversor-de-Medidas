package com.example.conversordemedidas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import java.lang.Double
import java.util.*

class ConversorTemperatura : AppCompatActivity() {
    var unidades = arrayOf("Celsius (°C)", "Kelvin (k)", "Fahrenheit (°F)")
    var selecao = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor_temperatura)

        //carregar componentes
        val spinner = findViewById<Spinner>(R.id.sp_select)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val etValor = findViewById<EditText>(R.id.et_valor)
        val btConverter = findViewById<Button>(R.id.bt_converter)

        //Cria  Array Adapter
        val adapter = ArrayAdapter (this, android.R.layout.simple_spinner_dropdown_item, unidades)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selecao = p2
            }

        }

        btConverter.setOnClickListener {
            val valor = etValor.text.toString()
            if(valor !=""){
                if (selecao == 0){//Celsius
                    var texto = "Kelvin = "
                    texto += formataValor( Double.parseDouble(valor) + 273.15)
                    texto += " k \n\n"
                    texto += "Fahrenheit = "
                    texto += formataValor( (Double.parseDouble(valor) * 9/5)+ 32f)
                    texto += " °F"

                    tvResult.text = texto
                }else if (selecao == 1){//kelvin
                    var texto = "Celsius = "
                    texto += formataValor( Double.parseDouble(valor) - 273.15)
                    texto += " °C \n\n"
                    texto += "Fahrenheit = "
                    texto += formataValor( (Double.parseDouble(valor) +273.15)* 9/5 + 32f)
                    texto += " °F"

                    tvResult.text = texto
                }else if (selecao == 2){//Fahrenheit
                    var texto = "Celsius = "
                    texto += formataValor( (Double.parseDouble(valor) - 32) *5/9 )
                    texto += " °C \n\n"
                    texto += "Kelvin = "
                    texto += formataValor( (Double.parseDouble(valor) - 32) *5/9 + 273.15)
                    texto += " k"

                    tvResult.text = texto
                }
            }else{
                tvResult.text = "Adicione valor  para ser convertido."
            }
        }

        //ativar "up navegation" na action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun formataValor(valor: kotlin.Double): Any? {
        return String.format(Locale.FRANCE, "%.2f", valor)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item?.itemId == android.R.id.home){
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}