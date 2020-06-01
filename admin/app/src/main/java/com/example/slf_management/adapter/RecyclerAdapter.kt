package com.example.slf_management.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.slf_management.R
import com.example.slf_management.items.MenuComentario

class RecyclerAdapter(private var menuComentario : MenuComentario): RecyclerView.Adapter<RecyclerAdapter.MenuViewHolder>() {
    private lateinit var rvListener: MenuRecyclerViewListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_child, parent, false))
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(menuComentario, position, rvListener)
    }

    override fun getItemCount(): Int {
        return menuComentario.menu.size
    }

    fun setMenuRecyclerViewListener(listener: MenuRecyclerViewListener) {
        rvListener = listener
    }

    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nombre = itemView.findViewById<TextView>(R.id.tituloMenu)
        private val recyclerMenu = itemView.findViewById<RecyclerView>(R.id.recyclerMenu)


        fun bind(menuComentario: MenuComentario, position: Int, listener: MenuRecyclerViewListener) {
            nombre.text = menuComentario.menu[position].nombre
            setupRecyclerView(menuComentario, position, listener)

            itemView.setOnClickListener {
                menuComentario.menu[position].isExpanded = !menuComentario.menu[position].isExpanded
                if (menuComentario.menu[position].isExpanded) {
                    recyclerMenu.visibility = View.VISIBLE
                } else {
                    recyclerMenu.visibility = View.GONE
                }
            }
        }

        private fun setupRecyclerView(menuComentario: MenuComentario, position: Int, listener: MenuRecyclerViewListener) {
            val rvLayoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.VERTICAL, false)
            val rvAdapter = SectionRecyclerViewAdapter(menuComentario.menu[position].comentarios)

            rvListItems.layoutManager = rvLayoutManager
            rvListItems.adapter = rvAdapter
            rvAdapter.setSectionRecyclerViewListener(object : SectionRecyclerViewAdapter.SectionRecyclerViewListener {
                override fun onItemClick(itemPosition: Int) {
                    listener.onMenuItemClick(position, itemPosition)
                }

            })

        }

    }

    interface MenuRecyclerViewListener {
        fun onMenuItemClick(menuPosition: Int, itemPosition: Int)
    }
}