package com.example.conversordemedidas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import java.lang.Double

class ConverterDados : AppCompatActivity() {
    var unidades = arrayOf("Byte (b)", "Quilobyte (Kb)", "Megabyte (Mb)", "Gigabyte (Gb)")
    var selecao = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter_dados)

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
                if (selecao == 0){//Byte
                    var texto = "Quilobyte = "
                    texto += Double.parseDouble(valor)/1000f
                    texto += " Kb \n\n"
                    texto += "Megabyte = "
                    texto += Double.parseDouble(valor)/1000000f
                    texto += " Mb \n\n"
                    texto += "Gigabyte = "
                    texto += Double.parseDouble(valor)/1000000000f
                    texto += " Gb"

                    tvResult.text = texto
                }else if (selecao == 1){//Quilobyte
                    var texto = "Byte = "
                    texto += Double.parseDouble(valor)*1000f
                    texto += " b \n\n"
                    texto += "Megabyte = "
                    texto += Double.parseDouble(valor)/1000f
                    texto += " Mb \n\n"
                    texto += "Gigabyte = "
                    texto += Double.parseDouble(valor)/1000000f
                    texto += " Gb"

                    tvResult.text = texto
                }else if (selecao == 2){//Megabyte
                    var texto = "Byte = "
                    texto += Double.parseDouble(valor)*1000000f
                    texto += " b \n\n"
                    texto += "Quilobyte = "
                    texto += Double.parseDouble(valor)*1000f
                    texto += " Kb \n\n"
                    texto += "Gigabyte = "
                    texto += Double.parseDouble(valor)/1000f
                    texto += " Gb"

                    tvResult.text = texto
                }else if (selecao ==3) {//Gigabyte
                    var texto = "Byte = "
                    texto += Double.parseDouble(valor) * 1000000000f
                    texto += " b \n\n"
                    texto += "Quilobyte = "
                    texto += Double.parseDouble(valor) * 1000000f
                    texto += " Kb \n\n"
                    texto += "Megabyte = "
                    texto += Double.parseDouble(valor) * 1000f
                    texto += " Mb"

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