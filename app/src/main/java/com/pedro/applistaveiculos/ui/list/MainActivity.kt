package com.pedro.applistaveiculos.ui.list

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pedro.applistaveiculos.R
import com.pedro.applistaveiculos.data.DTOs.Veiculo
import com.pedro.applistaveiculos.ui.details.DetalhesVeiculoActivity
import com.pedro.applistaveiculos.viewmode.VeiculoViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: VeiculoViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: VehicleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recyclerView)
        adapter = VehicleAdapter(emptyList()) { vehicle ->
            // Aqui futuramente vai pra tela de detalhes
            openUserDetails(vehicle)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.vehicles.observe(this) { list ->
            adapter.updateList(list)
        }
    }
    private fun openUserDetails(vehicle: Veiculo) {
        val intent = Intent(this, DetalhesVeiculoActivity::class.java)
        intent.putExtra("veiculo", vehicle)
        startActivity(intent)
    }
}