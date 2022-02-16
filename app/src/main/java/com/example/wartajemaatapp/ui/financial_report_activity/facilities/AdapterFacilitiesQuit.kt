package com.example.wartajemaatapp.ui.financial_report_activity.facilities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wartajemaatapp.R
import com.example.wartajemaatapp.databinding.ListItemFinancialReport2Binding
import com.example.wartajemaatapp.model.response.ModelUangMasukKeluar
import com.example.wartajemaatapp.utils.FormatDate

class AdapterFacilitiesQuit : RecyclerView.Adapter<AdapterFacilitiesQuit.QuitHolder>() {

    var dataFacilitiesChurchQuit: MutableList<ModelUangMasukKeluar?> = mutableListOf()

    fun updateDataUang(modelUangMasukKeluar: MutableList<ModelUangMasukKeluar?>) {

        modelUangMasukKeluar.forEach { model ->
            if (model != null) {
                add(model)
            }
        }
    }

    private fun add(modelUangMasukKeluar: ModelUangMasukKeluar) {
        dataFacilitiesChurchQuit.add(modelUangMasukKeluar)
        notifyItemInserted(dataFacilitiesChurchQuit.size)
    }

    inner class QuitHolder(private val itemBinding: ListItemFinancialReport2Binding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(modelQuit: ModelUangMasukKeluar?) {
            itemBinding.apply {
                if (modelQuit != null) {
                    textYear.text = modelQuit.tanggal?.let {
                        FormatDate.changeFormatStringDate(
                            it
                        )
                    }
                    textDay.text = modelQuit.tanggal?.let { FormatDate.getDayInDate(it, "yyyy-MM-dd") }
                    textFamily.text = modelQuit.jumlah?.let {
                        itemBinding.root.resources.getString(R.string.keluar, it)
                    }
                    textAddess.text = modelQuit.keterangan?.let {
                        itemBinding.root.resources.getString(R.string.ket, it)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuitHolder {
        val itemBinding = ListItemFinancialReport2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuitHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: QuitHolder, position: Int) {
        holder.bind(dataFacilitiesChurchQuit[position])
    }

    override fun getItemCount(): Int = dataFacilitiesChurchQuit.size

}