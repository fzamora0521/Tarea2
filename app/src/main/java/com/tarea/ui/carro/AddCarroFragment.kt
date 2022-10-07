package com.tarea.ui.carro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tarea.R
import com.tarea.databinding.FragmentAddCarroBinding
import com.tarea.databinding.FragmentCarroBinding
import com.tarea.model.Carro
import com.tarea.viewmodel.CarroViewModel


class AddCarroFragment : Fragment() {
    private var _binding: FragmentAddCarroBinding? = null
    private val binding get() = _binding!!
    private lateinit var carroViewModel: CarroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        carroViewModel = ViewModelProvider(this).get(CarroViewModel::class.java)
        _binding = FragmentAddCarroBinding.inflate(inflater, container, false)

        binding.btAgregar.setOnClickListener{addCarro()}
        return binding.root
    }

    private fun addCarro() {
        val marca = binding.etMarca.text.toString()
        val modelo = binding.etModelo.text.toString()
        val anno = binding.etAnno.text.toString().toInt()
        val placa = binding.etPlaca.text.toString()
        val VIN = binding.etVIN.text.toString()
        if(marca.isNotEmpty()){
            val carro = Carro(0,marca,modelo,anno,placa,VIN,"")
            carroViewModel.saveCarro(carro)
            Toast.makeText(requireContext(),getString(R.string.msg_carro_added),
                Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addLugarFragment_to_nav_carro)
        }else{
            Toast.makeText(requireContext(),getString(R.string.msg_data),
                Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}