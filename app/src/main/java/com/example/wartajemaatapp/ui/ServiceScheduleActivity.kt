package com.example.wartajemaatapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wartajemaatapp.R
import com.example.wartajemaatapp.databinding.ActivityServiceScheduleBinding
import com.example.wartajemaatapp.utils.ColorScheduleService

class ServiceScheduleActivity : AppCompatActivity() {

    lateinit var binding: ActivityServiceScheduleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            worshipMorningSunday.apply {
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