package com.example.slf_management.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.slf_management.R
import com.example.slf_management.adapter.PersonalAdapter
import com.example.slf_management.items.PersonalItem

/**
 * A simple [Fragment] subclass.
 */
class PersonalFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var personalAdapter: PersonalAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
    return view
    }

}