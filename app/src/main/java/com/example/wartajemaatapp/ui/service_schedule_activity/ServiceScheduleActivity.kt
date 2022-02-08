package com.example.wartajemaatapp.ui.service_schedule_activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wartajemaatapp.R
import com.example.wartajemaatapp.databinding.ActivityServiceScheduleBinding
import com.example.wartajemaatapp.ui.main_activity.MainActivity
import com.example.wartajemaatapp.utils.ColorScheduleService
import com.example.wartajemaatapp.utils.FormatDate
import com.example.wartajemaatapp.utils.NetworkConfig
import com.example.wartajemaatapp.utils.SharePreference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ServiceScheduleActivity : AppCompatActivity() {

    lateinit var binding: ActivityServiceScheduleBinding
    lateinit var pref: SharePreference
    private lateinit var date: String
    private lateinit var pastor: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = SharePreference(this)

        getDateandName()

        initViewSchedule()

        getDataWorshipSundayMorning()

        getDataWorshipSundayNight()

        getDataWorshipSaturday()

        initPastor()

        initDate()
    }

    private fun initPastor(){
        binding.headerWorship.textInfo.text = pastor
    }

    private fun initDate(){
        binding.toolbarServiceSchedule.apply {
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

    private fun backArrow(){
        startActivity(Intent(this, MainActivity::class.java))
        finishAffinity()
    }

    private fun getDataWorshipSundayMorning(){
        CoroutineScope(Dispatchers.IO).launch {
            //Thanks Giving
            val dataSundayMorning = NetworkConfig.apiServiceWorship.getSundayMorning()

            CoroutineScope(Dispatchers.Main).launch {

                binding.worshipMorningSunday.apply {

                    dataSundayMorning.data[0]?.apply {
                        itemWorship.textFamily.text = worship
                        itemLeader.textFamily.text = leader
                        itemSinger.textFamily.text = singer
                        itemMusic.textFamily.text = musik
                        itemTamborin.textFamily.text = tambourine
                        itemMixer.textFamily.text = mixer
                        itemBanners.textFamily.text = banner
                        itemLCD.textFamily.text = lcd
                        itemUsher.textFamily.text = usher
                        itemPraise.textFamily.text = pujian
                    }
                }
            }
        }
    }

    private fun getDataWorshipSundayNight(){
        CoroutineScope(Dispatchers.IO).launch {
            //Thanks Giving
            val dataSundayNight = NetworkConfig.apiServiceWorship.getSundayNight()

            CoroutineScope(Dispatchers.Main).launch {

                binding.worshipNightSunday.apply {

                    dataSundayNight.data[0]?.apply {
                        itemWorship.textFamily.text = worship
                        itemLeader.textFamily.text = leader
                        itemSinger.textFamily.text = singer
                        itemMusic.textFamily.text = musik
                        itemTamborin.textFamily.text = tambourine
                        itemMixer.textFamily.text = mixer
                        itemBanners.textFamily.text = banner
                        itemLCD.textFamily.text = lcd
                        itemUsher.textFamily.text = usher
                        itemPraise.textFamily.text = pujian
                    }
                }
            }
        }
    }

    private fun getDataWorshipSaturday(){
        CoroutineScope(Dispatchers.IO).launch {
            //Thanks Giving
            val dataSaturdy = NetworkConfig.apiServiceWorship.getSaturday()

            CoroutineScope(Dispatchers.Main).launch {

                binding.worshipNightSaturday.apply {

                    dataSaturdy.data[0]?.apply {
                        itemWorship.textFamily.text = worship
                        itemLeader.textFamily.text = leader
                        itemSinger.textFamily.text = singer
                        itemMusic.textFamily.text = musik
                        itemTamborin.textFamily.text = tambourine
                        itemMixer.textFamily.text = mixer
                        itemBanners.textFamily.text = banner
                        itemLCD.textFamily.text = lcd
                        itemUsher.textFamily.text = usher
                        itemPraise.textFamily.text = pujian
                    }
                }
            }
        }
    }

    private fun initViewSchedule(){
        binding.apply {

            worshipMorningSunday.apply {
                itemLeader.textDay.text = resources.getString(R.string.Leader)
                itemSinger.textDay.text = resources.getString(R.string.Singer)
                itemMusic.textDay.text = resources.getString(R.string.Music)
                itemTamborin.textDay.text = resources.getString(R.string.Tamborin)
                itemMixer.textDay.text = resources.getString(R.string.Mixer)
                itemBanners.textDay.text = resources.getString(R.string.Banners)
                itemLCD.textDay.text = resources.getString(R.string.LCD)
                itemUsher.textDay.text = resources.getString(R.string.Usher)
                itemPraise.textDay.text = resources.getString(R.string.Pujian)

                ColorScheduleService.changeTitle(
                    textWorshipTitle,
                    resources.getString(R.string.ibadah_minggu_pagi)
                )

                ColorScheduleService.changeColor(
                    applicationContext,
                    itemWorship.sectorLeft,
                    itemLeader.sectorLeft,
                    itemSinger.sectorLeft,
                    itemMusic.sectorLeft,
                    itemTamborin.sectorLeft,
                    itemMixer.sectorLeft,
                    itemBanners.sectorLeft,
                    itemLCD.sectorLeft,
                    itemUsher.sectorLeft,
                    itemPraise.sectorLeft,
                )
            }

            worshipNightSunday.apply {

                itemLeader.textDay.text = resources.getString(R.string.Leader)
                itemSinger.textDay.text = resources.getString(R.string.Singer)
                itemMusic.textDay.text = resources.getString(R.string.Music)
                itemTamborin.textDay.text = resources.getString(R.string.Tamborin)
                itemMixer.textDay.text = resources.getString(R.string.Mixer)
                itemBanners.textDay.text = resources.getString(R.string.Banners)
                itemLCD.textDay.text = resources.getString(R.string.LCD)
                itemUsher.textDay.text = resources.getString(R.string.Usher)
                itemPraise.textDay.text = resources.getString(R.string.Pujian)

                ColorScheduleService.changeTitle(
                    textWorshipTitle,
                    resources.getString(R.string.ibadah_minggu_malam)
                )

                ColorScheduleService.changeColor(
                    applicationContext,
                    itemWorship.sectorLeft,
                    itemLeader.sectorLeft,
                    itemSinger.sectorLeft,
                    itemMusic.sectorLeft,
                    itemTamborin.sectorLeft,
                    itemMixer.sectorLeft,
                    itemBanners.sectorLeft,
                    itemLCD.sectorLeft,
                    itemUsher.sectorLeft,
                    itemPraise.sectorLeft,
                )
            }

            worshipNightSaturday.apply {

                itemLeader.textDay.text = resources.getString(R.string.Leader)
                itemSinger.textDay.text = resources.getString(R.string.Singer)
                itemMusic.textDay.text = resources.getString(R.string.Music)
                itemTamborin.textDay.text = resources.getString(R.string.Tamborin)
                itemMixer.textDay.text = resources.getString(R.string.Mixer)
                itemBanners.textDay.text = resources.getString(R.string.Banners)
                itemLCD.textDay.text = resources.getString(R.string.LCD)
                itemUsher.textDay.text = resources.getString(R.string.Usher)
                itemPraise.textDay.text = resources.getString(R.string.Pujian)

                ColorScheduleService.changeTitle(
                    textWorshipTitle,
                    resources.getString(R.string.ibadah_sabtu_malam)
                )

                ColorScheduleService.changeColor(
                    applicationContext,
                    itemWorship.sectorLeft,
                    itemLeader.sectorLeft,
                    itemSinger.sectorLeft,
                    itemMusic.sectorLeft,
                    itemTamborin.sectorLeft,
                    itemMixer.sectorLeft,
                    itemBanners.sectorLeft,
                    itemLCD.sectorLeft,
                    itemUsher.sectorLeft,
                    itemPraise.sectorLeft,
                )
            }

        }
    }

}