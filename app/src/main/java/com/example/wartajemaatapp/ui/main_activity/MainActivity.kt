package com.example.wartajemaatapp.ui.main_activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wartajemaatapp.R
import com.example.wartajemaatapp.databinding.ActivityMainBinding
import com.example.wartajemaatapp.ui.SundaySchoolActivity
import com.example.wartajemaatapp.ui.devotional_detail_activity.DevotionalDetailsActivity
import com.example.wartajemaatapp.ui.financial_report_activity.FinancialReportActivity
import com.example.wartajemaatapp.ui.sector_worship_schedule_activity.SectorWorshipScheduleActivity
import com.example.wartajemaatapp.ui.service_schedule_activity.ServiceScheduleActivity
import com.example.wartajemaatapp.utils.FormatDate
import com.example.wartajemaatapp.utils.GetCurrentDate
import com.example.wartajemaatapp.utils.NetworkConfig
import com.example.wartajemaatapp.utils.SharePreference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapterBirthday = AdapterMainBirthday()
    lateinit var pref: SharePreference
    lateinit var nameShepherd: String
    lateinit var originShepherd: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = SharePreference(this)


        //Memanggil tampilan list birthday
        initRecylerviewBirthday()

        getCurrentDate()

        getshSpherd()

        navigationButton()

        showReflection()

        //Memanggil data birthday
        initViewBirthday()

        //Memanggil tampilan ibadah
        initViewThanksGiving()


    }

    private fun showReflection() {
        CoroutineScope(Dispatchers.IO).launch {
            //List Birthday
            val dataReflection = NetworkConfig.apiServiceMain.getReflection()

            CoroutineScope(Dispatchers.Main).launch {
                binding.apply {
                    pbLoading.visibility = View.VISIBLE
                    dataReflection.data.let {
                        bodyDevotional.apply {
                            textNumberChapter.text = it?.ayat ?: ""
                            textTitle.text = it?.judul ?: ""
                            textBibleContent.text = it?.deskripsi_1 ?: ""
                            textPastor.text =
                                resources.getString(R.string.by_shepher, it?.pengarang)

                            btnNext.setOnClickListener { view ->
                                startActivity(
                                    Intent(this@MainActivity, DevotionalDetailsActivity::class.java)
                                        .putExtra("ayat", it?.ayat)
                                        .putExtra("judul", it?.judul)
                                        .putExtra("deskripsi_1", it?.deskripsi_1)
                                        .putExtra("deskripsi_2", it?.deskripsi_2)
                                        .putExtra("pengarang", it?.pengarang)
                                )
                            }
                        }
                    }
                    pbLoading.visibility = View.INVISIBLE
                    grupReflection.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun getCurrentDate() {

        pref.apply {
            save(PREFS_DATE, GetCurrentDate.getDate())

            binding.apply {
                pbLoading.visibility = View.VISIBLE
                toolbarMain.apply {
                    val dateCurrent = getValueString(PREFS_DATE)
                    textCurrentDate.text = resources.getString(
                        R.string.current_date,
                        dateCurrent?.let { FormatDate.getDayInDate(it, "dd MMMM yyyy") },
                        dateCurrent
                    )
                }
                pbLoading.visibility = View.INVISIBLE
                grupNews.visibility = View.VISIBLE
            }
        }
    }

    private fun getshSpherd() {
        CoroutineScope(Dispatchers.IO).launch {

            val datShepherd = NetworkConfig.apiServiceMain.getShepherd()

            datShepherd.data?.apply {
                this.nama?.let {
                    nameShepherd = it
                }

                this.asal?.let {
                    originShepherd = it
                }
            }

            pref.apply {
                save(PREFS_NAME, nameShepherd)
//                save( PREFS_ORIGIN, originShepherd)

                CoroutineScope(Dispatchers.Main).launch {
                    binding.apply {
                        pbLoading.visibility = View.VISIBLE
                        headerMain.apply {
                            textInfo.text =
                                resources.getString(R.string.shepherd, getValueString(PREFS_NAME))
                        }
                        pbLoading.visibility = View.INVISIBLE
                        grupDatePastor.visibility = View.VISIBLE
                        grupNews.visibility = View.VISIBLE
                    }

                }
            }
        }
    }

    private fun navigationButton() {
        binding.bodyCongregationalNews.apply {
            btnReportFinance.setOnClickListener {
                startActivity(
                    Intent(
                        this@MainActivity,
                        FinancialReportActivity::class.java
                    )
                )
            }

            btnScheduleServices.setOnClickListener {
                startActivity(
                    Intent(
                        this@MainActivity,
                        ServiceScheduleActivity::class.java
                    )
                )
            }


            btnSectorWorshipSchedule.setOnClickListener {
                startActivity(
                    Intent(
                        this@MainActivity,
                        SectorWorshipScheduleActivity::class.java
                    )
                )
            }


            btnWaiterScheduleSundaySchool.setOnClickListener {
                startActivity(
                    Intent(
                        this@MainActivity,
                        SundaySchoolActivity::class.java
                    )
                )
            }

        }
    }

    @SuppressLint("SetTextI18n")
    private fun initViewBirthday() {
        CoroutineScope(Dispatchers.IO).launch {

            val dataBirthday = NetworkConfig.apiServiceMain.getBirthday()

            CoroutineScope(Dispatchers.Main).launch {
                binding.apply {
                    pbLoading.visibility = View.VISIBLE

                    dataBirthday.data[0]?.let {
                        bodyInfoBirthday.apply {
                            textSubtitle.text = resources.getString(
                                R.string.dummy_week,
                                it.start_of_week,
                                it.end_of_week
                            )
                        }
                        adapterBirthday.updateDataBirthday(it.birthdayData)
                    }
                    pbLoading.visibility = View.INVISIBLE
                    grupInfoOther.visibility = View.VISIBLE
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initViewThanksGiving() {
        CoroutineScope(Dispatchers.IO).launch {

            val dataThanksGiving = NetworkConfig.apiServiceMain.getThanksGiving()

            CoroutineScope(Dispatchers.Main).launch {

                binding.apply {
                    pbLoading.visibility = View.VISIBLE

                    bodyInfo.apply {

                        dataThanksGiving.data?.get(0)?.apply {
                            textSubTitle.text = keterangan

                            FormatDate.apply {
                                tanggal?.let {
                                    textContentInfo.text =
                                        resources.getString(
                                            R.string.when_where_thanks_giving,
                                            getDayInDate(it, "dd-MM-yyyy"),
                                            changeFormatStringDate(it),
                                            waktu?.let { it1 -> changeFormatTime(it1) },
                                            alamat
                                        )
                                }
                            }
                        }
                    }

                    pbLoading.visibility = View.INVISIBLE
                    grupInfoOther.visibility = View.VISIBLE
                }
            }
        }

    }

    private fun initRecylerviewBirthday() {
        binding.bodyInfoBirthday.rvBirthday.apply {
            layoutManager = LinearLayoutManager(binding.root.context)
            adapter = adapterBirthday
        }
    }

    override fun onPause() {
        super.onPause()
        binding.apply {
            pref.apply {
                toolbarMain.apply {
                    val dateCurrent = getValueString(PREFS_DATE)
                    textCurrentDate.text = resources.getString(
                        R.string.current_date,
                        dateCurrent?.let { FormatDate.getDayInDate(it, "dd MMMM yyyy") },
                        dateCurrent
                    )
                }

                headerMain.apply {
                    textInfo.text =
                        resources.getString(R.string.shepherd, getValueString(PREFS_NAME))
                }

            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        pref.clearSharedPreference()
    }
}