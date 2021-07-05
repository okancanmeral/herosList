@file:JvmName("RecyclerAdapterKt")

package com.okancanmeral.superkahramankitabi

import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


private val View.recyclerViewTextView: Any
    get() {}

class RecyclerAdapter(val kahramanListesi : ArrayList<String>, val kahramanGorselleri : ArrayList<Int>) : RecyclerView.Adapter<RecyclerAdapter.SuperKahramanVH>() {
    class SuperKahramanVH(itemView : View) : RecyclerView.ViewHolder (itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperKahramanVH {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,false)
        return SuperKahramanVH(itemView)

    }

    override fun getItemCount(): Int {
        return kahramanListesi.size

    }
    override fun onBindViewHolder(holder: SuperKahramanVH, position: Int) {
        holder.itemView.recyclerViewTextView.text = kahramanListesi.get(position)
        holder.itemView.setOnClickListener {
            val intent  = Intent(holder.itemView.context,TanitimActivity::class.java)
            intent.putExtra("superKahramanIsmi",kahramanListesi.get(position))
            intent.putExtra("superKahramanGorseli",kahramanGorselleri.get(position))

            /* val singleton = SingletonClass.SecilenKahraman
            singleton.gorsel = kahramanGorselleri.get(position)
            */
            holder.itemView.context.startActivity(intent)
        }

    }
}

private fun LayoutInflater.inflate(recyclerRow: Int, b: Boolean): View {


}
