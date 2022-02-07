package com.example.wartajemaatapp.ui.main_activity

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wartajemaatapp.R
import com.example.wartajemaatapp.databinding.ItemBirthdayBinding
import com.example.wartajemaatapp.model.response.ModelBirthday
import com.example.wartajemaatapp.utils.FormatDate

class AdapterMainBirthday: RecyclerView.Adapter<AdapterMainBirthday.BirthdayHolder>(){

    var dataBirthday:MutableList<ModelBirthday?> = mutableListOf()

    fun updateDataBirthday(modelBirthdayList: MutableList<ModelBirthday?>){
        modelBirthdayList.forEach {  model ->
            if (model != null){
                add(model)
            }
        }
    }

    private fun add(modelBirthday: ModelBirthday) {
        dataBirthday.add(modelBirthday)
        notifyItemInserted(dataBirthday.size)
    }

    inner class BirthdayHolder(private val itemBinding: ItemBirthdayBinding): RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(modelBirthday: ModelBirthday?, position: Int){
            itemBinding.apply {
                if (modelBirthday != null) {
                    textName.text = itemBinding.root.resources.getString(R.string.birthdy_item, position,modelBirthday.nama)
                }
                if (modelBirthday != null) {
                    textBirthday.text = modelBirthday.tanggal?.let {
                        FormatDate.changeFormatIndonesianDate(
                            it
                        )
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirthdayHolder {
        val itemBinding = ItemBirthdayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BirthdayHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BirthdayHolder, position: Int) {
        holder.bind(dataBirthday[position], position + 1)
    }

    override fun getItemCount(): Int = dataBirthday.size


}