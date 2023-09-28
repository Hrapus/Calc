package com.example.calc

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.calc.databinding.FragmentCalcFragmentBinding

class CalcFragment :
    Fragment(),
    View.OnClickListener {

    private lateinit var binding: FragmentCalcFragmentBinding
    var inputUser = ""

    companion object {
        fun newInstance() = CalcFragment()
    }

    private lateinit var viewModel: CalcFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalcFragmentBinding.inflate(inflater, container, false)
        binding.root.setOnClickListener {
            onClick(it)
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CalcFragmentViewModel::class.java]

        setClickListenerOnBottom()
        // TODO: Use the ViewModel
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv0 -> inputUser = inputUser + "0"
            R.id.tv1 -> inputUser = inputUser + "1"
            R.id.tv2 -> inputUser = inputUser + "2"
            R.id.tv3 -> inputUser = inputUser + "3"
            R.id.tv4 -> inputUser = inputUser + "4"
            R.id.tv5 -> inputUser = inputUser + "5"
            R.id.tv6 -> inputUser = inputUser + "6"
            R.id.tv7 -> inputUser = inputUser + "7"
            R.id.tv8 -> inputUser = inputUser + "8"
            R.id.tv9 -> inputUser = inputUser + "9"
            R.id.tvDot -> inputUser = inputUser + "."
        }
        binding.tvScreen.text = inputUser
    }

    private fun setClickListenerOnBottom() {
        binding.tv0.setOnClickListener(this)
        binding.tv1.setOnClickListener(this)
        binding.tv2.setOnClickListener(this)
        binding.tv3.setOnClickListener(this)
        binding.tv4.setOnClickListener(this)
        binding.tv5.setOnClickListener(this)
        binding.tv6.setOnClickListener(this)
        binding.tv7.setOnClickListener(this)
        binding.tv8.setOnClickListener(this)
        binding.tv9.setOnClickListener(this)
        binding.tvDot.setOnClickListener(this)
        binding.tvRes.setOnClickListener(this)
        binding.tvPlus.setOnClickListener(this)
        binding.tvMinus.setOnClickListener(this)
        binding.tvMult.setOnClickListener(this)
        binding.tvDiv.setOnClickListener(this)

    }

}