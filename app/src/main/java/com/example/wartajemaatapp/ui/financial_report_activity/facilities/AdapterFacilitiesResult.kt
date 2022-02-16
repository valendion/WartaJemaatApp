package com.example.wartajemaatapp.ui.financial_report_activity.facilities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wartajemaatapp.R
import com.example.wartajemaatapp.databinding.ListItemFinancialReport3Binding
import com.example.wartajemaatapp.model.response.ModelResult

class AdapterFacilitiesResult :
    RecyclerView.Adapter<AdapterFacilitiesResult.ResultHolder>() {

    var dataFacilitiesChurchResult: MutableList<ModelResult?> = mutableListOf()

    fun updateDataUang(modelUangResult: MutableList<ModelResult?>) {

        modelUangResult.forEach { model ->
            if (model != null) {
                add(model)
            }
        }
    }

    private fun add(modelUangResult: ModelResult) {
        dataFacilitiesChurchResult.add(modelUangResult)
        notifyItemInserted(dataFacilitiesChurchResult.size)
    }

    inner class ResultHolder(private val itemBinding: ListItemFinancialReport3Binding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(modelResult: ModelResult?) {
            itemBinding.apply {
                if (modelResult != null) {
                    textFamily.text =
                        itemBinding.root.resources.getString(R.string.saldo, modelResult.jumlah)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultHolder {
        val itemBinding = ListItemFinancialReport3Binding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ResultHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ResultHolder, position: Int) {
        holder.bind(dataFacilitiesChurchResult[position])
    }

    override fun getItemCount(): Int = dataFacilitiesChurchResult.size

}