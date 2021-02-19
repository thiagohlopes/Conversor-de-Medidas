package com.example.conversordemedidas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlin.Double as Double1

class ConversorComprimento : AppCompatActivity() {
    var medidas = arrayOf("Milimetro (mm)", "Centimetro (cm)", "Metro (m)", "Quilometro (km)")
    var selecao = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor_comprimento)

        //carregar componentes
        val spinner = findViewById<Spinner>(R.id.sp_select)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val etValor = findViewById<EditText>(R.id.et_valor)
        val btConverter = findViewById<Button>(R.id.bt_converter)

        //Cria  Array Adapter
        val adapter = ArrayAdapter (this, android.R.layout.simple_spinner_dropdown_item, medidas)
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
                if (selecao == 0){//milimetro
                    var texto = "Centimetro = "
                    texto += Double.parseDouble(valor)/10f
                    texto += " cm \n\n"
                    texto += "Metro = "
                    texto += Double.parseDouble(valor)/1000f
                    texto += " m \n\n"
                    texto += "Quilometro = "
                    texto += Double.parseDouble(valor)/1000000f
                    texto += " km"

                    tvResult.text = texto
                }else if (selecao == 1){//centimetro
                    var texto = "Milimetro = "
                    texto += Double.parseDouble(valor)*10f
                    texto += " mm \n\n"
                    texto += "Metro = "
                    texto += Double.parseDouble(valor)/100f
                    texto += " m \n\n"
                    texto += "Quilometro = "
                    texto += Double.parseDouble(valor)/100000f
                    texto += " km"

                    tvResult.text = texto
                }else if (selecao == 2){//metro
                    var texto = "Milimetro = "
                    texto += Double.parseDouble(valor)*1000f
                    texto += " cm \n\n"
                    texto += "Centimetro = "
                    texto += Double.parseDouble(valor)*100f
                    texto += " cm \n\n"
                    texto += "Quilometro = "
                    texto += Double.parseDouble(valor)/1000f
                    texto += " km"

                    tvResult.text = texto
                }else if (selecao ==3) {//quilometro
                    var texto = "Milimetro = "
                    texto += Double.parseDouble(valor) * 1000000f
                    texto += " mm \n\n"
                    texto += "Centimetro = "
                    texto += Double.parseDouble(valor) * 100000f
                    texto += " cm \n\n"
                    texto += "Metro = "
                    texto += Double.parseDouble(valor) * 1000f
                    texto += " m"

                    tvResult.text = texto
                }
            }else{
                tvResult.text = "Adicione valor  para ser convertido."
            }
        }

        //ativar "up navegation" na action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item?.itemId == android.R.id.home){
            finish()
            return true
        }

        
        return super.onOptionsItemSelected(item)
    }
}