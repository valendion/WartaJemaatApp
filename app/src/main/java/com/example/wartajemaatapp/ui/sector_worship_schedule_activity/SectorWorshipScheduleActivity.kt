package com.example.wartajemaatapp.ui.sector_worship_schedule_activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wartajemaatapp.R
import com.example.wartajemaatapp.databinding.ActivitySectorWorshipScheduleBinding
import com.example.wartajemaatapp.ui.main_activity.MainActivity
import com.example.wartajemaatapp.utils.FormatDate
import com.example.wartajemaatapp.utils.NetworkConfig
import com.example.wartajemaatapp.utils.SharePreference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SectorWorshipScheduleActivity : AppCompatActivity() {

    lateinit var binding: ActivitySectorWorshipScheduleBinding
    lateinit var pref: SharePreference
    private lateinit var date: String
    private lateinit var pastor: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySectorWorshipScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = SharePreference(this)

        initTitle()

        getDateandName()

        initDate()

        initPastor()

        initViewSector1()
        initViewSector2()
        initViewSector3()
        initViewSector4()

    }

    private fun initPastor() {
        binding.headline.textInfo.text = pastor
    }

    private fun initDate() {
        binding.toolbarSector.apply {
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

    private fun initTitle(){
        binding.bodyScheduleSector2.textSector.text = resources.getString(R.string.ibadah_torsina)
        binding.bodyScheduleSector3.textSector.text = resources.getString(R.string.ibadah_pisga)
        binding.bodyScheduleSector4.textSector.text = resources.getString(R.string.ibadah_hermon)
    }


    private fun initViewSector1() {
        CoroutineScope(Dispatchers.IO).launch {
            val dataSector1 = NetworkConfig.apiServiceSector.getSectorSion()

            CoroutineScope(Dispatchers.Main).launch {

                binding.bodyScheduleSector1.apply {

                    dataSector1.data?.apply {
                        textDay.text = tanggal?.let {
                            FormatDate.getDayInDate(
                                it,
                                resources.getString(R.string.formaat_date_internasional)
                            )
                        }
                        textYear.text = tanggal?.let { FormatDate.changeFormatStringDate(it) }
                        textSchedule.text = resources.getString(R.string.wita,
                            waktu?.let { FormatDate.changeFormatTime(it) })
                        textAddess.text = alamat
                        textFamily.text = nama_keluarga
                    }
                }
            }
        }
    }

    private fun initViewSector2() {
        CoroutineScope(Dispatchers.IO).launch {
            //Thanks Giving
            val dataSector2 = NetworkConfig.apiServiceSector.getSectorTorsina()

            CoroutineScope(Dispatchers.Main).launch {

                binding.bodyScheduleSector2.apply {

                    dataSector2.data?.apply {
                        textDay.text = tanggal?.let {
                            FormatDate.getDayInDate(
                                it,
                                resources.getString(R.string.formaat_date_internasional)
                            )
                        }
                        textYear.text = tanggal?.let { FormatDate.changeFormatStringDate(it) }
                        textSchedule.text = resources.getString(R.string.wita,
                            waktu?.let { FormatDate.changeFormatTime(it) })
                        textAddess.text = alamat
                        textFamily.text = nama_keluarga
                    }
                }
            }
        }
    }

    private fun initViewSector3() {
        CoroutineScope(Dispatchers.IO).launch {
            val dataSector3 = NetworkConfig.apiServiceSector.getSectorPisga()

            CoroutineScope(Dispatchers.Main).launch {

                binding.bodyScheduleSector3.apply {

                    dataSector3.data?.apply {
                        textDay.text = tanggal?.let {
                            FormatDate.getDayInDate(
                                it,
                                resources.getString(R.string.formaat_date_internasional)
                            )
                        }
                        textYear.text = tanggal?.let { FormatDate.changeFormatStringDate(it) }
                        textSchedule.text = resources.getString(R.string.wita,
                            waktu?.let { FormatDate.changeFormatTime(it) })
                        textAddess.text = alamat
                        textFamily.text = nama_keluarga
                    }
                }
            }
        }
    }

    private fun initViewSector4() {
        CoroutineScope(Dispatchers.IO).launch {
            val dataSector4 = NetworkConfig.apiServiceSector.getSectorHermon()

            CoroutineScope(Dispatchers.Main).launch {

                binding.bodyScheduleSector4.apply {

                    dataSector4.data?.apply {
                        textDay.text = tanggal?.let {
                            FormatDate.getDayInDate(
                                it,
                                resources.getString(R.string.formaat_date_internasional)
                            )
                        }
                        textYear.text = tanggal?.let { FormatDate.changeFormatStringDate(it) }
                        textSchedule.text = resources.getString(R.string.wita,
                            waktu?.let { FormatDate.changeFormatTime(it) })
                        textAddess.text = alamat
                        textFamily.text = nama_keluarga
                    }
                }
            }
        }
    }
}