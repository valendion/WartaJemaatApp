package com.example.wartajemaatapp.utils

import android.content.Context
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.core.widget.TextViewCompat
import com.example.wartajemaatapp.R


object ColorScheduleService {

    fun changeColor(
        context: Context,
        worship: LinearLayoutCompat,
        Leader: LinearLayoutCompat,
        Singer: LinearLayoutCompat,
        Music: LinearLayoutCompat,
        Tamborin: LinearLayoutCompat,
        Mixer: LinearLayoutCompat,
        Banners: LinearLayoutCompat,
        LCD: LinearLayoutCompat,
        Usher: LinearLayoutCompat,
        Pujian: LinearLayoutCompat,
        Parkir: LinearLayoutCompat
    ) {
        worship.setBackgroundColor(ContextCompat.getColor(context, R.color.bluePrimary))
        Leader.setBackgroundColor(ContextCompat.getColor(context, R.color.ancient))
        Singer.setBackgroundColor(ContextCompat.getColor(context, R.color.orange))
        Music.setBackgroundColor(ContextCompat.getColor(context, R.color.red))
        Tamborin.setBackgroundColor(ContextCompat.getColor(context, R.color.pink))
        Mixer.setBackgroundColor(ContextCompat.getColor(context, R.color.youngGreen))
        Banners.setBackgroundColor(ContextCompat.getColor(context, R.color.yellow))
        LCD.setBackgroundColor(ContextCompat.getColor(context, R.color.darkGreen))
        Usher.setBackgroundColor(ContextCompat.getColor(context, R.color.darkBlue))
        Pujian.setBackgroundColor(ContextCompat.getColor(context, R.color.black))
        Parkir.setBackgroundColor(ContextCompat.getColor(context, R.color.blueDark))
    }

    fun changeDuty(
        worship: TextView,
        Leader: TextView,
        Singer: TextView,
        Music: TextView,
        Tamborin: TextView,
        Mixer: TextView,
        Banners: TextView,
        LCD: TextView,
        Usher: TextView,
        praise: TextView,
        worshipWord: String,
        LeaderWord: String,
        SingerWord: String,
        MusicWord: String,
        TamborinWord: String,
        MixerWord: String,
        BannersWord: String,
        LCDWord: String,
        UsherWord: String,
        praiseWord: String
    ) {

        worship.text = worshipWord
        Leader.text = LeaderWord
        Singer.text = SingerWord
        Music.text = MusicWord
        Tamborin.text = TamborinWord
        Mixer.text = MixerWord
        Banners.text = BannersWord
        LCD.text = LCDWord
        Usher.text = UsherWord
        praise.text = praiseWord
    }

    fun changeTitle(
        worshipTitle: TextView,
        worshipWord: String,
    ) {
        worshipTitle.text = worshipWord
    }

}