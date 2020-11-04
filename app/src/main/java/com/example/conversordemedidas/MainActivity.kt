package com.example.conversordemedidas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //carregar componentes
        val btComprimento = findViewById<ImageButton>(R.id.bt_comprimento)
        val btDados = findViewById<ImageButton>(R.id.bt_dados)
        val btTemperatura = findViewById<ImageButton>(R.id.bt_temperatura)
        val btPeso = findViewById<ImageButton>(R.id.bt_peso)

        //Listener
        btComprimento.setOnClickListener {
            val intent = Intent(this, ConversorComprimento::class.java)
            startActivity(intent)
        }

        btDados.setOnClickListener {
            val intent = Intent(this, ConverterDados::class.java)
            startActivity(intent)
        }

        btTemperatura.setOnClickListener {
            val intent = Intent(this, ConversorTemperatura::class.java)
            startActivity(intent)
        }

        btPeso.setOnClickListener {
            val intent = Intent(this, ConversorPeso::class.java)
            startActivity(intent)
        }
    }
}