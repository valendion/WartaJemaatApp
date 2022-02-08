package com.example.wartajemaatapp.ui.devotional_detail_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wartajemaatapp.R
import com.example.wartajemaatapp.databinding.ActivityDevotionalDetailsBinding
import com.example.wartajemaatapp.ui.main_activity.MainActivity
import com.example.wartajemaatapp.utils.FormatDate
import com.example.wartajemaatapp.utils.SharePreference

class DevotionalDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDevotionalDetailsBinding

    private lateinit var date: String
    private lateinit var pastor: String

    private lateinit var ayatText: String
    private lateinit var judulText: String
    private lateinit var deskripsi_1Text: String
    private lateinit var deskripsi_2Text: String
    private lateinit var pengarangText: String

    lateinit var pref: SharePreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityDevotionalDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = SharePreference(this)

        getData()

        initDate()

        initPastor()

        initViewDetail()

    }

    private fun backArrow(){
        startActivity(Intent(this, MainActivity::class.java))
        finishAffinity()
    }

    private fun getData(){
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

        intent.apply {
            ayatText = getStringExtra("ayat").toString()
            judulText = getStringExtra("judul").toString()
            deskripsi_1Text = getStringExtra("deskripsi_1").toString()
            deskripsi_2Text = getStringExtra("deskripsi_2").toString()
            pengarangText = getStringExtra("pengarang").toString()
        }
    }

    private fun initPastor(){
        binding.headline.textInfo.text = pastor
    }

    private fun initDate(){
        binding.toolbarDEvotionDetail.apply {
            textDate.text = date
            backArrow.setOnClickListener { backArrow() }
        }
    }

    private fun initViewDetail(){
        binding.bodyDevotionalDetail.apply {
            textNumberChapter.text = ayatText
            textTitle.text = judulText
            textPastor.text = resources.getString(R.string.by_shepher,pengarangText)
            textBibleContent.text = resources.getString(R.string.text_bible,deskripsi_1Text, deskripsi_2Text)
        }
    }
}