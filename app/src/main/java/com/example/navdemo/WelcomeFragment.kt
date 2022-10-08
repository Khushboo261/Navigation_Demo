package com.example.navdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.navdemo.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeBinding.inflate(inflater,container,false)
        val name = requireArguments().getString("name_input")
        val email = requireArguments().getString("email_input")
        binding.apply {
            tvName.text = name
            tvEmail.text = email
            btnTerms2.setOnClickListener {
                it.findNavController().navigate(R.id.action_welcomeFragment_to_termsFragment2)
            }
        }
        return binding.root
    }
}