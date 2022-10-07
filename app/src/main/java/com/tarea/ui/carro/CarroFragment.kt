package com.tarea.ui.carro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tarea.R
import com.tarea.databinding.FragmentCarroBinding
import com.tarea.viewmodel.CarroViewModel

class CarroFragment : Fragment() {

    private var _binding: FragmentCarroBinding? = null
    private val binding get() = _binding!!
    private lateinit var carroViewModel: CarroViewModel
    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        carroViewModel = ViewModelProvider(this).get(CarroViewModel::class.java)

        _binding = FragmentCarroBinding.inflate(inflater, container, false)
        binding.fbAgregar.setOnClickListener {
            findNavController().navigate(R.id.action_nav_carro_to_addCarroFragment)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}