package com.example.conversordemedidas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import java.lang.Double

class ConversorPeso : AppCompatActivity() {
    var medidas = arrayOf("Miligrama (mg)", "Centigrama (cg)", "Grama (g)", "Quilograma (kg)")
    var selecao = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor_peso)

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
                if (selecao == 0){//Miligrama
                    var texto = "Centigrama = "
                    texto += Double.parseDouble(valor)/10f
                    texto += " cg \n\n"
                    texto += "Grama = "
                    texto += Double.parseDouble(valor)/1000f
                    texto += " g \n\n"
                    texto += "Quilograma = "
                    texto += Double.parseDouble(valor)/1000000f
                    texto += " kg"

                    tvResult.text = texto
                }else if (selecao == 1){//Centigrama
                    var texto = "Miligrama = "
                    texto += Double.parseDouble(valor)*10f
                    texto += " mg \n\n"
                    texto += "Grama = "
                    texto += Double.parseDouble(valor)/100f
                    texto += " g \n\n"
                    texto += "Quilograma = "
                    texto += Double.parseDouble(valor)/100000f
                    texto += " kg"

                    tvResult.text = texto
                }else if (selecao == 2){//metro
                    var texto = "Miligrama = "
                    texto += Double.parseDouble(valor)*1000f
                    texto += " cg \n\n"
                    texto += "Centigrama = "
                    texto += Double.parseDouble(valor)*100f
                    texto += " cg \n\n"
                    texto += "Quilograma = "
                    texto += Double.parseDouble(valor)/1000f
                    texto += " kg"

                    tvResult.text = texto
                }else if (selecao ==3) {//quilometro
                    var texto = "Miligrama = "
                    texto += Double.parseDouble(valor) * 1000000f
                    texto += " mg \n\n"
                    texto += "Centigrama = "
                    texto += Double.parseDouble(valor) * 100000f
                    texto += " cg \n\n"
                    texto += "Grama = "
                    texto += Double.parseDouble(valor) * 1000f
                    texto += " g"

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