package com.example.slf_management.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.slf_management.R
import com.example.slf_management.items.PersonalItem
import kotlinx.android.synthetic.main.item_personal.view.*


class PersonalAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{

    private var personal: List<PersonalItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BlogViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_personal, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {

            is BlogViewHolder -> {
                holder.bind(personal.get(position))
            }

        }
    }

    override fun getItemCount(): Int {
        return personal.size
    }

    fun submitList(blogList: List<PersonalItem>){
        personal = blogList
    }

    class BlogViewHolder
    constructor(
            itemView: View
    ): RecyclerView.ViewHolder(itemView){

        val imagen = itemView.imagen
        val nombre = itemView.nombre


        fun bind(personalItem: PersonalItem){

            val requestOptions = RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                    .applyDefaultRequestOptions(requestOptions)
                    .load(personalItem.imagen)
                    .into(imagen)
            nombre.setText(personalItem.nombre)

        }

    }

}