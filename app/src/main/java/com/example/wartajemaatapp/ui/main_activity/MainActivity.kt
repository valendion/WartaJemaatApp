package com.example.wartajemaatapp.ui.main_activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wartajemaatapp.R
import com.example.wartajemaatapp.databinding.ActivityMainBinding
import com.example.wartajemaatapp.ui.DevotionalDetailsActivity
import com.example.wartajemaatapp.ui.FinancialReportActivity
import com.example.wartajemaatapp.ui.SectorWorshipScheduleActivity
import com.example.wartajemaatapp.ui.ServiceScheduleActivity
import com.example.wartajemaatapp.utils.FormatDate
import com.example.wartajemaatapp.utils.NetworkConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapterBirthday = AdapterMainBirthday()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initRecylerviewBirthday()
        initView()

        navigationButton()
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


//            btnWaiterScheduleSundaySchool.setOnClickListener {
//                startActivity(
//                    Intent(
//                        this@MainActivity,
//                        DevotionalDetailsActivity::class.java
//                    )
//                )
//            }

        }
    }

    @SuppressLint("SetTextI18n")
    private fun initView() {
        CoroutineScope(Dispatchers.IO).launch {
            //List Birthday
            val dataBirthday = NetworkConfig.apiServiceMain.getBirthday()

            //Thanks Giving
            val dataThanksGiving = NetworkConfig.apiServiceMain.getThanksGiving()

            CoroutineScope(Dispatchers.Main).launch {
                dataBirthday.data[0]?.let {
                    binding.bodyInfoBirthday.apply {
                        textSubtitle.text = resources.getString(
                            R.string.dummy_week,
                            it.start_of_week,
                            it.end_of_week
                        )
                    }

                    adapterBirthday.updateDataBirthday(it.birthdayData)
                }

                binding.bodyInfo.apply {

                    dataThanksGiving.data?.get(0)?.apply {
                        textSubTitle.text = keterangan

                        FormatDate.apply {
                            tanggal?.let {
                                textContentInfo.text =
                                    resources.getString(
                                        R.string.when_where_thanks_giving,
                                        getDayInDate(it, binding.root.context),
                                        changeFormatStringDate(it),
                                        waktu?.let { it1 -> changeFormatTime(it1) },
                                        alamat
                                    )
                            }
                        }
                    }
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
}