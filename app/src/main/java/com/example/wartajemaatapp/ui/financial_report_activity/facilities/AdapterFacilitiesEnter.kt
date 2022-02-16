package com.example.wartajemaatapp.ui.financial_report_activity.facilities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wartajemaatapp.R
import com.example.wartajemaatapp.databinding.ListItemFinancialReportBinding
import com.example.wartajemaatapp.model.response.ModelUangMasukKeluar
import com.example.wartajemaatapp.utils.FormatDate

class AdapterFacilitiesEnter : RecyclerView.Adapter<AdapterFacilitiesEnter.EnterHolder>() {

    var dataFacilitiesChurchEnter: MutableList<ModelUangMasukKeluar?> = mutableListOf()

    fun updateDataUang(modelUangMasukKeluar: MutableList<ModelUangMasukKeluar?>) {

        modelUangMasukKeluar.forEach { model ->
            if (model != null) {
                add(model)
            }
        }
    }

    private fun add(modelUangMasukKeluar: ModelUangMasukKeluar) {
        dataFacilitiesChurchEnter.add(modelUangMasukKeluar)
        notifyItemInserted(dataFacilitiesChurchEnter.size)
    }

    inner class EnterHolder(private val itemBinding: ListItemFinancialReportBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(modelEnter: ModelUangMasukKeluar?) {
            itemBinding.apply {
                if (modelEnter != null) {
                    textYear.text = modelEnter.tanggal?.let {
                        FormatDate.changeFormatStringDate(
                            it
                        )
                    }
                    textDay.text = modelEnter.tanggal?.let { FormatDate.getDayInDate(it, "yyyy-MM-dd") }
                    textFamily.text = modelEnter.jumlah?.let {
                        itemBinding.root.resources.getString(R.string.masuk, it)
                    }
                    textAddess.text = modelEnter.keterangan?.let {
                        itemBinding.root.resources.getString(R.string.ket, it)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EnterHolder {
        val itemBinding = ListItemFinancialReportBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EnterHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: EnterHolder, position: Int) {
        holder.bind(dataFacilitiesChurchEnter[position])
    }

    override fun getItemCount(): Int = dataFacilitiesChurchEnter.size

}