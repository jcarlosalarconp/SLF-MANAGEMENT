package com.example.slf_management.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager){
    private val listFragments = arrayListOf<Fragment>()

    override fun getItem(position: Int): Fragment {
        return listFragments[position]
    }

    override fun getCount(): Int {
        return listFragments.size
    }

    fun addFragments (frag: Fragment){
        listFragments.add(frag)
    }
}