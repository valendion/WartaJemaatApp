package com.example.wartajemaatapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wartajemaatapp.R
import com.example.wartajemaatapp.databinding.ActivityFinancialReportBinding

class FinancialReportActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFinancialReportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinancialReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            headerFinancialReport.textInfo.text
        }

    }


}