package com.example.inventario

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class Adaptador(var arr: ArrayList<Carta>): RecyclerView.Adapter<Adaptador.ViewHolder>(){



    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        var holi = LayoutInflater.from(p0.context).inflate(R.layout.item,p0,false)
        return ViewHolder(holi)
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(p0: Adaptador.ViewHolder, p1: Int) {
        p0.bindItem(arr[p1])
    }



    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bindItem(data:Carta){


            val Menos: Button = itemView.findViewById(R.id.quitar)
            val Mas: Button = itemView.findViewById(R.id.agregar)
            val cantidad: TextView = itemView.findViewById(R.id.cantidad)
            val nombre: TextView = itemView.findViewById(R.id.NombreN)
            cantidad.text = data.cantidad.toString()
            nombre.text = data.producto.nombre





            Menos.setOnClickListener(){
                if(data.cantidad!=0){
                    var num = data.cantidad-1
                    data.cantidad = num
                    cantidad.text=num.toString()
                }
            }


            Mas.setOnClickListener(){
                var num = data.cantidad+1
                data.cantidad = num
                cantidad.text=num.toString()
            }



        }
    }
}