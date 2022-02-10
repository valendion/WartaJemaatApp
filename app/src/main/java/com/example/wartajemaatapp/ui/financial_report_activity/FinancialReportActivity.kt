package com.example.wartajemaatapp.ui.financial_report_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wartajemaatapp.databinding.ActivityFinancialReportBinding
import com.example.wartajemaatapp.ui.financial_report_activity.church_treasury.AdapterChurchTreasuryEnter
import com.example.wartajemaatapp.ui.financial_report_activity.church_treasury.AdapterChurchTreasuryQuit
import com.example.wartajemaatapp.ui.financial_report_activity.church_treasury.AdapterChurchTreasuryResult
import com.example.wartajemaatapp.utils.NetworkConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FinancialReportActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFinancialReportBinding
    private var adapterCashEnter = AdapterChurchTreasuryEnter()
    private var adapterCashQuit = AdapterChurchTreasuryQuit()
    private var adapterResult = AdapterChurchTreasuryResult()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinancialReportBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.apply {
            headerFinancialReport.textInfo.text
        }

        initRecylerviewCash()
        initViewChurchEnter()
        initViewChurchQuit()
        initViewChurchResult()
    }

    private fun initViewChurchEnter() {
        CoroutineScope(Dispatchers.IO).launch {
            val dataEnter = NetworkConfig.apiServiceFinancialStatements.getJemaatMasuk()

            CoroutineScope(Dispatchers.Main).launch {
                dataEnter.data.let {
                    adapterCashEnter.updateDataUang(it)
                }

            }
        }
    }

    private fun initViewChurchQuit() {
        CoroutineScope(Dispatchers.IO).launch {
            val dataQuit = NetworkConfig.apiServiceFinancialStatements.getJemaatKeluar()

            CoroutineScope(Dispatchers.Main).launch {
                dataQuit.data.let {
                    adapterCashQuit.updateDataUang(it)
                }

            }
        }
    }

    private fun initViewChurchResult() {
        CoroutineScope(Dispatchers.IO).launch {
            val dataResult = NetworkConfig.apiServiceFinancialStatements.getJemaatSaldo()

            CoroutineScope(Dispatchers.Main).launch {
                dataResult.data.let {
                    adapterResult.updateDataUang(it)
                }

            }
        }
    }

    private fun initRecylerviewCash() {
        binding.apply {
            listChurchTreasuryEnter.recyclerChurchTreasury.apply {
                layoutManager = LinearLayoutManager(binding.root.context)
                adapter = adapterCashEnter
            }

            listChurchTreasuryQuit.recyclerChurchTreasury.apply {
                layoutManager = LinearLayoutManager(binding.root.context)
                adapter = adapterCashQuit
            }
            listChurchTreasuryResult.recyclerChurchTreasury.apply {
                layoutManager = LinearLayoutManager(binding.root.context)
                adapter = adapterResult
            }
        }


    }


}