package com.example.slf_management

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.slf_management.activitys.EventoActivity
import com.example.slf_management.activitys.NuevoEventoActivity
import com.example.slf_management.activitys.NuevoMaterialActivity
import com.example.slf_management.activitys.NuevoPersonalActivity
import com.example.slf_management.adapter.FragmentAdapter
import com.example.slf_management.fragments.EventosFragment
import com.example.slf_management.fragments.MaterialFragment
import com.example.slf_management.fragments.PersonalFragment
import com.gauravk.bubblenavigation.BubbleNavigationLinearView
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private val viewPagerFragment by lazy { findViewById<ViewPager>(R.id.view_pager)}
    private val navigation by lazy { findViewById<BubbleNavigationLinearView> (R.id.bottom_navigation_view_linear)}
    private var positionFragment = 1

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
                positionFragment = position
            }
        })
        viewPagerFragment.setCurrentItem(1)

        navigation.setNavigationChangeListener(object : BubbleNavigationChangeListener{
            override fun onNavigationChanged(view: View?, position: Int) {
                viewPagerFragment.setCurrentItem(position, true)
                positionFragment = position
            }
        })
        val fab: View = findViewById(R.id.fabAñadir)
        fab.setOnClickListener { view ->
            when(positionFragment){
                0 -> {
                    val intent = Intent(this, NuevoMaterialActivity::class.java)
                    startActivity(intent)
                }
                1 -> {
                    val intent = Intent(this, NuevoEventoActivity::class.java)
                    startActivity(intent)
                }
                2 -> {
                    val intent = Intent(this, NuevoPersonalActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
