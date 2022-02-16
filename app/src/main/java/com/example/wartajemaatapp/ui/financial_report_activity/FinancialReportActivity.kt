package com.example.wartajemaatapp.ui.financial_report_activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wartajemaatapp.R
import com.example.wartajemaatapp.databinding.ActivityFinancialReportBinding
import com.example.wartajemaatapp.ui.financial_report_activity.building.AdapterBuildingEnter
import com.example.wartajemaatapp.ui.financial_report_activity.building.AdapterBuildingQuit
import com.example.wartajemaatapp.ui.financial_report_activity.building.AdapterBuildingResult
import com.example.wartajemaatapp.ui.financial_report_activity.church_treasury.AdapterChurchTreasuryEnter
import com.example.wartajemaatapp.ui.financial_report_activity.church_treasury.AdapterChurchTreasuryQuit
import com.example.wartajemaatapp.ui.financial_report_activity.church_treasury.AdapterChurchTreasuryResult
import com.example.wartajemaatapp.ui.financial_report_activity.facilities.AdapterFacilitiesEnter
import com.example.wartajemaatapp.ui.financial_report_activity.facilities.AdapterFacilitiesQuit
import com.example.wartajemaatapp.ui.financial_report_activity.facilities.AdapterFacilitiesResult
import com.example.wartajemaatapp.ui.main_activity.MainActivity
import com.example.wartajemaatapp.utils.FormatDate
import com.example.wartajemaatapp.utils.NetworkConfig
import com.example.wartajemaatapp.utils.SharePreference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FinancialReportActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFinancialReportBinding

    private var adapterCashEnter = AdapterChurchTreasuryEnter()
    private var adapterCashQuit = AdapterChurchTreasuryQuit()
    private var adapterResult = AdapterChurchTreasuryResult()

    private var adapterBuildingEnter = AdapterBuildingEnter()
    private var adapterBuildingQuit = AdapterBuildingQuit()
    private var adapterBuildingResult = AdapterBuildingResult()

    private var adapterFacilitiesEnter = AdapterFacilitiesEnter()
    private var adapterFacilitiesQuit = AdapterFacilitiesQuit()
    private var adapterFacilitiesResult = AdapterFacilitiesResult()

    lateinit var pref: SharePreference
    lateinit var date: String
    private lateinit var pastor: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinancialReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = SharePreference(this)

        getDateandName()
        initPastor()
        initDate()
        initRecylerviewCash()
        initViewChurchEnter()
        initViewChurchQuit()
        initViewChurchResult()
    }

    private fun initPastor() {
        binding.headerFinancialReport.textInfo.text = pastor
    }

    private fun initDate() {
        binding.toolbarFinancialReport.apply {
            textDate.text = date
            backArrow.setOnClickListener { backArrow() }
        }

    }

    private fun backArrow() {
        startActivity(Intent(this, MainActivity::class.java))
        finishAffinity()
    }

    private fun getDateandName() {
        pref.apply {
            val dateCurrent = getValueString(PREFS_DATE)
            val namePastor = getValueString(PREFS_NAME)
            date = resources.getString(
                R.string.current_date,
                dateCurrent?.let { FormatDate.getDayInDate(it, "dd MMMM yyyy") },
                dateCurrent
            )
            if (namePastor != null) {
                pastor = namePastor
            }
        }
    }

    private fun initViewChurchEnter() {
        CoroutineScope(Dispatchers.IO).launch {
            val dataEnter = NetworkConfig.apiServiceFinancialStatements.getJemaatMasuk()
            val dataBuildingEnter =
                NetworkConfig.apiServiceFinancialStatements.getPembangunanMasuk()
            val dataFacilitiesEnter = NetworkConfig.apiServiceFinancialStatements.getSaranaMasuk()

            CoroutineScope(Dispatchers.Main).launch {
                dataEnter.data.let {
                    adapterCashEnter.updateDataUang(it)
                }

                dataBuildingEnter.data.let {
                    adapterBuildingEnter.updateDataUang(it)
                }
                dataFacilitiesEnter.data.let {
                    adapterFacilitiesEnter.updateDataUang(it)
                }

            }
        }
    }

    private fun initViewChurchQuit() {
        CoroutineScope(Dispatchers.IO).launch {
            val dataQuit = NetworkConfig.apiServiceFinancialStatements.getJemaatKeluar()
            val dataBuildingQuit =
                NetworkConfig.apiServiceFinancialStatements.getPembangunanKeluar()
            val dataFacilitiesQuit = NetworkConfig.apiServiceFinancialStatements.getSaranaKeluar()

            CoroutineScope(Dispatchers.Main).launch {
                dataQuit.data.let {
                    adapterCashQuit.updateDataUang(it)
                }

                dataBuildingQuit.data.let {
                    adapterBuildingQuit.updateDataUang(it)
                }

                dataFacilitiesQuit.data.let {
                    adapterFacilitiesQuit.updateDataUang(it)
                }

            }
        }
    }

    private fun initViewChurchResult() {
        CoroutineScope(Dispatchers.IO).launch {
            val dataResult = NetworkConfig.apiServiceFinancialStatements.getJemaatSaldo()
            val dataBuildingResult =
                NetworkConfig.apiServiceFinancialStatements.getPembangunanSaldo()
            val dataFasilitiesResult = NetworkConfig.apiServiceFinancialStatements.getSaranaSaldo()

            CoroutineScope(Dispatchers.Main).launch {
                dataResult.data.let {
                    adapterResult.updateDataUang(it)
                }

                dataBuildingResult.data.let {
                    adapterBuildingResult.updateDataUang(it)
                }

                dataFasilitiesResult.data.let {
                    adapterFacilitiesResult.updateDataUang(it)
                }

            }
        }
    }

    private fun initRecylerviewCash() {
        binding.apply {
            listChurchTreasuryEnter.recyclerChurchTreasury.apply {
                layoutManager = LinearLayoutManager(binding.root.context)
                isNestedScrollingEnabled = false
                adapter = adapterCashEnter
            }

            listChurchTreasuryQuit.recyclerChurchTreasury.apply {
                layoutManager = LinearLayoutManager(binding.root.context)
                isNestedScrollingEnabled = false
                adapter = adapterCashQuit
            }
            listChurchTreasuryResult.recyclerChurchTreasury.apply {
                layoutManager = LinearLayoutManager(binding.root.context)
                isNestedScrollingEnabled = false
                adapter = adapterResult
            }

            textChurchBuilding.textContent.text = resources.getString(R.string.building_church)

            listChurchBuildingEnter.recyclerChurchTreasury.apply {
                layoutManager = LinearLayoutManager(binding.root.context)
                isNestedScrollingEnabled = false
                adapter = adapterBuildingEnter
            }

            listChurchBuildingQuit.recyclerChurchTreasury.apply {
                layoutManager = LinearLayoutManager(binding.root.context)
                isNestedScrollingEnabled = false
                adapter = adapterBuildingQuit
            }
            listChurchBuildingResult.recyclerChurchTreasury.apply {
                layoutManager = LinearLayoutManager(binding.root.context)
                isNestedScrollingEnabled = false
                adapter = adapterBuildingResult
            }

            textChurchFacilities.textContent.text = resources.getString(R.string.field_facilities)

            listChurchFacilitiesEnter.recyclerChurchTreasury.apply {
                layoutManager = LinearLayoutManager(binding.root.context)
                isNestedScrollingEnabled = false
                adapter = adapterFacilitiesEnter
            }

            listChurchFacilitiesQuit.recyclerChurchTreasury.apply {
                layoutManager = LinearLayoutManager(binding.root.context)
                isNestedScrollingEnabled = false
                adapter = adapterFacilitiesQuit
            }
            listChurchFacilitiesResult.recyclerChurchTreasury.apply {
                layoutManager = LinearLayoutManager(binding.root.context)
                isNestedScrollingEnabled = false
                adapter = adapterFacilitiesResult
            }
        }
    }
}