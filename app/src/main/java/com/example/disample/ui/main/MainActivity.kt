package com.example.disample.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.disample.databinding.MainActivityBinding
import com.example.disample.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var binding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mainViewModel.getResult().observe(this, Observer { result ->
            binding.textView.text = result.title
        })

        binding.textView.text = "ここが切り替わる"
        binding.button.apply {
            text = "Call Api"
            setOnClickListener {
                mainViewModel.request()
            }
        }
    }
}