package com.example.navdemo

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.navdemo.databinding.FragmentEmailBinding

class EmailFragment : Fragment() {
    private lateinit var binding: FragmentEmailBinding
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEmailBinding.inflate(inflater,container,false)
        val name = requireArguments().getString("name_input")
        binding.btnNext2.setOnClickListener {
            if(!TextUtils.isEmpty(binding.etEmail.text.toString())){
                if(Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text).matches()){
                    val bundle = bundleOf(
                        "name_input" to name,
                        "email_input" to binding.etEmail.text.toString()
                    )
                    it.findNavController().navigate(R.id.action_emailFragment_to_welcomeFragment, bundle)
                }else{
                    Toast.makeText(activity,"Email format is incorrect", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(activity,"Please Enter Email",Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }
}