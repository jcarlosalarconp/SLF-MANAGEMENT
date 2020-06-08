package com.example.slf_management

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.slf_management.adapter.FragmentAdapter
import com.example.slf_management.fragments.EventosFragment
import com.example.slf_management.fragments.MaterialFragment
import com.example.slf_management.fragments.PersonalFragment
import com.gauravk.bubblenavigation.BubbleNavigationLinearView
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private val viewPagerFragment by lazy { findViewById<ViewPager>(R.id.view_pager)}
    private val navigation by lazy { findViewById<BubbleNavigationLinearView> (R.id.bottom_navigation_view_linear)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentAdapter=FragmentAdapter(supportFragmentManager)
        val materialTab = MaterialFragment()
        val eventosTab = EventosFragment()

        val personalTab = PersonalFragment()
        fragmentAdapter.addFragments(materialTab)
        fragmentAdapter.addFragments(eventosTab)
        fragmentAdapter.addFragments(personalTab)

        viewPagerFragment.adapter=fragmentAdapter
        viewPagerFragment.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                navigation.setCurrentActiveItem(position)
                Toast.makeText(this@MainActivity,position.toString(),Toast.LENGTH_SHORT).show()
            }
        })
        viewPagerFragment.setCurrentItem(1)

        navigation.setNavigationChangeListener(object : BubbleNavigationChangeListener{
            override fun onNavigationChanged(view: View?, position: Int) {
                viewPagerFragment.setCurrentItem(position, true)
            }
        })
    }
}
