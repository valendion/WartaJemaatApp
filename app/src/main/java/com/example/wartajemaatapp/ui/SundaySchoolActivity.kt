package com.example.wartajemaatapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.wartajemaatapp.R
import com.example.wartajemaatapp.databinding.ActivitySundaySchoolBinding
import com.example.wartajemaatapp.ui.main_activity.MainActivity
import com.example.wartajemaatapp.utils.ColorSundaySchool
import com.example.wartajemaatapp.utils.FormatDate
import com.example.wartajemaatapp.utils.NetworkConfig
import com.example.wartajemaatapp.utils.SharePreference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SundaySchoolActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySundaySchoolBinding
    lateinit var pref: SharePreference
    private lateinit var date: String
    private lateinit var pastor: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySundaySchoolBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = SharePreference(this)

        getDateandName()

        initViewSundaySchool()

        initPastor()

        initDate()

        getDataSunday()
    }

    private fun initPastor(){
        binding.headline.textInfo.text = pastor
    }

    private fun initDate(){
        binding.toolbarSector.apply {
            textDate.text = date
            backArrow.setOnClickListener { backArrow() }
        }

    }

    private fun getDateandName(){
        pref.apply {
            val dateCurrent = getValueString(PREFS_DATE)
            val namePastor = getValueString(PREFS_NAME)
            date =  resources.getString(
                R.string.current_date,
                dateCurrent?.let { FormatDate.getDayInDate(it, "dd MMMM yyyy") },
                dateCurrent
            )
            if (namePastor != null) {
                pastor = namePastor
            }
        }
    }

    private fun backArrow() {
        startActivity(Intent(this, MainActivity::class.java))
        finishAffinity()
    }

    private fun getDataSunday(){
        CoroutineScope(Dispatchers.IO).launch {

            val dataSundaySchool = NetworkConfig.apiServiceMain.getSundaySchool()

            CoroutineScope(Dispatchers.Main).launch {
                binding.apply {
                    pbLoading.visibility = View.VISIBLE
                    bodySundaySchool.apply {

                        dataSundaySchool.data?.apply {
                            itemTeam.textFamily.text = team
                            itemBesar.textFamily.text = cerita_fa_kls_besar
                            itemKecil.textFamily.text = cerita_fa_kls_kecil
                            itemMusic.textFamily.text = pujian
                            textWorshipSubTitle.text = tanggal?.let {
                                FormatDate.changeFormatStringDate(
                                    it
                                )
                            }

                        }
                    }
                    grupSundaySchool.visibility = View.VISIBLE
                    pbLoading.visibility = View.INVISIBLE
                }
            }
        }
    }

    private fun initViewSundaySchool() {
        binding.bodySundaySchool.apply {

            itemTeam.textDay.text = resources.getString(R.string.team)
            itemBesar.textDay.text = resources.getString(R.string.kelas_beaar)
            itemMusic.textDay.text = resources.getString(R.string.service)
            itemKecil.textDay.text = resources.getString(R.string.kelas_kecil)

            ColorSundaySchool.changeColor(
                applicationContext,
                itemTeam.sectorLeft,
                itemBesar.sectorLeft,
                itemKecil.sectorLeft,
                itemMusic.sectorLeft,
            )

            ColorSundaySchool.changeTitle(
                textWorshipTitle,
                resources.getString(R.string.service_suanday_school)
            )
        }
    }

}