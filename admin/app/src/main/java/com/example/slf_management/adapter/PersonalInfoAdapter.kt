package com.example.slf_management.adapter


import android.content.Context
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.slf_management.R
import com.example.slf_management.items.PersonalInfoItem

class PersonalInfoAdapter(var context: Context, var arrayList: ArrayList<PersonalInfoItem>) :
        RecyclerView.Adapter<PersonalInfoAdapter.ItemHolder>(), ListAdapter {

    private lateinit var mListener: PersonalInfoListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_infopersonal, parent, false)
        return ItemHolder(itemHolder)

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    fun setPersonalInfoListener(listener: PersonalInfoListener){
        mListener = listener
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val personalInfoItem: PersonalInfoItem = arrayList.get(position)

        holder.tituloInfo.text = personalInfoItem.tituloInfo
        holder.informacion.text = personalInfoItem.informacion

        holder.itemView.setOnClickListener() {
            mListener.onClick(position)
        }
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var tituloInfo = itemView.findViewById<TextView>(R.id.tituloInfo)
        var informacion = itemView.findViewById<TextView>(R.id.informacion)
        
    }

    interface PersonalInfoListener{
        fun onClick(position: Int)
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("Not yet implemented")
    }

    override fun registerDataSetObserver(observer: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getViewTypeCount(): Int {
        TODO("Not yet implemented")
    }

    override fun isEnabled(position: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun areAllItemsEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun unregisterDataSetObserver(observer: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

}