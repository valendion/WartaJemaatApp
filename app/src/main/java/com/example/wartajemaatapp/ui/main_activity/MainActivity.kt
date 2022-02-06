package com.example.wartajemaatapp.ui.main_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wartajemaatapp.databinding.ActivityMainBinding
import com.example.wartajemaatapp.utils.NetworkConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  var adapterBirthday = AdapterMainBirthday()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initRecylerviewBirthday()
        initView()

    }

    private fun initView(){
        CoroutineScope(Dispatchers.IO).launch {
            val listener = NetworkConfig.apiServiceMain.getBirthday()

            CoroutineScope(Dispatchers.Main).launch {
                adapterBirthday.updateDataBirthday(listener.data)
            }
        }
    }

    private fun initRecylerviewBirthday(){
            binding.bodyInfoBirthday.rvBirthday.apply {
                layoutManager = LinearLayoutManager(binding.root.context)
                adapter = adapterBirthday
            }
    }
}