package com.pedro.applistaveiculos.ui.details

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.pedro.applistaveiculos.R
import com.pedro.applistaveiculos.data.DTOs.Veiculo

class DetalhesVeiculoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_veiculo)




        val toolbar = findViewById<Toolbar>(R.id.toolbar)  // Note: androidx.appcompat.widget.Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val veiculo = intent.getParcelableExtra<Veiculo>("veiculo")

        if (veiculo != null) {
            findViewById<TextView>(R.id.textPlaca).text = "Placa: ${veiculo.placa}"
            findViewById<TextView>(R.id.textMarca).text = "Marca: ${veiculo.marca}"
            findViewById<TextView>(R.id.textModelo).text = "Modelo: ${veiculo.modelo}"
            findViewById<TextView>(R.id.textAno).text = "Ano: ${veiculo.ano}"
            findViewById<TextView>(R.id.textCor).text = "Cor: ${veiculo.cor}"
            findViewById<TextView>(R.id.textRenavam).text = "Renavam: ${veiculo.renavam}"
            findViewById<TextView>(R.id.textChassi).text = "Chassi: ${veiculo.chassi}"
        } else {
            Toast.makeText(this, "Erro ao carregar dados do veículo", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}