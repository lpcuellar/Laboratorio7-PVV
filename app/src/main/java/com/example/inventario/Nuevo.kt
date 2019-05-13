package com.example.inventario

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation



private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Nuevo : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {



        val binding: com.example.inventario.databinding.FragmentNuevoBinding= DataBindingUtil.inflate(
            inflater, R.layout.fragment_nuevo, container, false
        )
        binding.add.setOnClickListener(){ view:View->

            var lista = Inventario.globalInventario

            val codigo = binding.IngresarCodigo.text.toString()
            val nombre = binding.IngresarNombre.text.toString()

            val productofinal = Producto(nombre,codigo)
            var cartita = Carta(productofinal,0)
            lista.add(cartita)
            Navigation.findNavController(view).navigate(R.id.action_nuevo_to_fragmentoRegistro)
        }
        return binding.root
    }
}
