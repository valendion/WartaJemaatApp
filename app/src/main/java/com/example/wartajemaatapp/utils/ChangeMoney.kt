package com.example.wartajemaatapp.utils

import java.text.DecimalFormat
import java.text.NumberFormat

object ChangeMoney {

    fun moneyToRupiah(price: Int): String{

//        val kursIndonesia = DecimalFormat.getCurrencyInstance()
//        val formatRp = DecimalFormatSymbols();
//
//        formatRp.setCurrencySymbol("Rp. ");
//        formatRp.setMonetaryDecimalSeparator(',');
//        formatRp.setGroupingSeparator('.');
//
//         kursIndonesia.setDecimalFormatSymbols(formatRp)
//        return "Harga Rupiah: %s %n ${kursIndonesia.format(price)}"

        val formatter: NumberFormat = DecimalFormat("#,###")
        val formattedNumber: String = formatter.format(price)
        return "Harga Rupiah: %s %n $formattedNumber"
    }

}