package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val calc = CalcFragment()
        val fragmentManager = supportFragmentManager

        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView, calc)
        transaction.commit()

    }
}