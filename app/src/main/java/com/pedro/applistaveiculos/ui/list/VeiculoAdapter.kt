package com.pedro.applistaveiculos.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pedro.applistaveiculos.R
    import com.pedro.applistaveiculos.data.DTOs.Veiculo

/**
 * funções do adapter para popular os dados no recycleView
 *
 */
class VehicleAdapter(
    private var vehicles: List<Veiculo>,
    private val onItemClick: (Veiculo) -> Unit
) : RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder>() {

    inner class VehicleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val placa: TextView = view.findViewById(R.id.txtPlaca)
        private val renavam: TextView = view.findViewById(R.id.txtRenavam)

        fun bind(vehicle: Veiculo) {
            placa.text = vehicle.placa
            renavam.text = "Renavam: ${vehicle.renavam}"

            itemView.setOnClickListener {
                onItemClick(vehicle)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_veiculo, parent, false)
        return VehicleViewHolder(view)
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        holder.bind(vehicles[position])
    }

    override fun getItemCount(): Int = vehicles.size

    fun updateList(newList: List<Veiculo>) {
        vehicles = newList
        notifyDataSetChanged()
    }
}
