package com.example.calc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.calc.databinding.FragmentCalcFragmentBinding

class CalcFragment :
    Fragment(),
    View.OnClickListener {

    private lateinit var viewModel: CalcFragmentViewModel

    //private  val viewModel: CalcFragmentViewModel by activityViewModels()
    lateinit var binding: FragmentCalcFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity()).get(CalcFragmentViewModel::class.java)
        //viewModel = ViewModelProvider(this)[CalcFragmentViewModel::class.java]
        binding = FragmentCalcFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.inputUser.observe(viewLifecycleOwner) {
            binding.tvScreen.text = it
        }
        binding.root.setOnClickListener {
            onClick(it)
        }
        setClickListenerOnBottom()
    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv0 -> viewModel.setInputUser("0")
            R.id.tv1 -> viewModel.setInputUser("1")
            R.id.tv2 -> viewModel.setInputUser("2")
            R.id.tv3 -> viewModel.setInputUser("3")
            R.id.tv4 -> viewModel.setInputUser("4")
            R.id.tv5 -> viewModel.setInputUser("5")
            R.id.tv6 -> viewModel.setInputUser("6")
            R.id.tv7 -> viewModel.setInputUser("7")
            R.id.tv8 -> viewModel.setInputUser("8")
            R.id.tv9 -> viewModel.setInputUser("9")
            R.id.tvRes -> viewModel.setInputUser("=")
            R.id.tvPlus -> viewModel.setInputUser("+")
            R.id.tvMinus -> viewModel.setInputUser("-")
            R.id.tvMult -> viewModel.setInputUser("*")
            R.id.tvDiv -> viewModel.setInputUser("/")
            R.id.tvScreen -> viewModel.setInputUser("s")
            R.id.tvDot -> viewModel.setInputUser(".")
        }

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
        binding.tvScreen.setOnClickListener(this)
    }

    companion object {
        fun newInstance() = CalcFragment()
    }

}