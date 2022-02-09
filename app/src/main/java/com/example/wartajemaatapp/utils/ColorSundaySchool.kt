package com.example.wartajemaatapp.utils

import android.content.Context
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.core.widget.TextViewCompat
import com.example.wartajemaatapp.R


object ColorSundaySchool {

    fun changeColor(
        context: Context,
        team: LinearLayoutCompat,
        kelasBesar: LinearLayoutCompat,
        kelasKecil: LinearLayoutCompat,
        music: LinearLayoutCompat,
    ) {
        team.setBackgroundColor(ContextCompat.getColor(context, R.color.bluePrimary))
        kelasBesar.setBackgroundColor(ContextCompat.getColor(context, R.color.ancient))
        kelasKecil.setBackgroundColor(ContextCompat.getColor(context, R.color.orange))
        music.setBackgroundColor(ContextCompat.getColor(context, R.color.red))
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