package com.example.navdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.navdemo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container,false)
        binding.btnSignUp.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_nameFragment)
        }
        binding.btnTerms.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_termsFragment2)
        }
        return binding.root
    }
}