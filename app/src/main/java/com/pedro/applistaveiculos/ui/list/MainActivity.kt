package com.pedro.applistaveiculos.ui.list

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.pedro.applistaveiculos.R
import com.pedro.applistaveiculos.data.DTOs.Veiculo
import com.pedro.applistaveiculos.data.local.VeiculoDatabase
import com.pedro.applistaveiculos.data.repository.VeiculoRepository
import com.pedro.applistaveiculos.ui.details.DetalhesVeiculoActivity
import com.pedro.applistaveiculos.viewmode.VeiculoViewModel
import com.pedro.applistaveiculos.viewmode.VeiculoViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: VeiculoViewModel // tiramos o 'by viewModels'
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: VehicleAdapter
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)

        val dao = VeiculoDatabase.getDatabase(applicationContext).veiculoDao()
        val repository = VeiculoRepository(dao)
        val viewModelFactory = VeiculoViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(VeiculoViewModel::class.java)

        // Splash de carregamento enquanto baixa os dados
        viewModel.vehicles.observe(this) { list ->
            if (list != null && list.isNotEmpty()) {
                progressBar.visibility = View.GONE
            } else {
                progressBar.visibility = View.VISIBLE
            }
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawerLayout)
        val navView = findViewById<NavigationView>(R.id.navigationView)

        toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_sobre -> {
                    Toast.makeText(
                        this,
                        "APP de Lista de Veículos, desenvolvido por: Pedro Sena.",
                        Toast.LENGTH_LONG
                    ).show()
                    true
                }
                else -> false
            }
        }

        recyclerView = findViewById(R.id.recyclerView)
        adapter = VehicleAdapter(emptyList()) { vehicle ->
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
