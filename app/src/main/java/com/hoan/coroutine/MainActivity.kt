package com.hoan.coroutine

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.hoan.coroutine.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val myViewModel:MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding!!.btnAdd.setOnClickListener {
            val a = binding!!.etNumber1.text.toString().toIntOrNull()?:0
            val b = binding!!.etNumber2.text.toString().toIntOrNull()?:0
            myViewModel.cong(a,b)
        }

        binding!!.btnSubtract.setOnClickListener {
            val a = binding!!.etNumber1.text.toString().toIntOrNull()?:0
            val b = binding!!.etNumber2.text.toString().toIntOrNull()?:0
            myViewModel.tru(a,b)
        }
        myViewModel.message.observe(this@MainActivity, Observer {message->
            lifecycleScope.launch(Dispatchers.Main) {
                binding!!.tvResult.text = message.toString()
            }
        })

    }
}