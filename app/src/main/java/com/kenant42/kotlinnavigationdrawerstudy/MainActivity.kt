package com.kenant42.kotlinnavigationdrawerstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.kenant42.kotlinnavigationdrawerstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        NavigationUI.setupWithNavController(binding.navigationView,navHostFragment.navController)

        binding.toolbar.title = "kenant42"
        val toggle = ActionBarDrawerToggle(this,binding.drawer,binding.toolbar,0,0)
        binding.drawer.addDrawerListener(toggle)
        toggle.syncState()

        val baslik = binding.navigationView.inflateHeaderView(R.layout.navigation_baslik)
        val textViewBaslik = baslik.findViewById(R.id.textViewBaslik) as TextView
        textViewBaslik.text = "Merhaba"
    }

    override fun onBackPressed() {

        if(binding.drawer.isDrawerOpen(GravityCompat.START)){
            binding.drawer.closeDrawer(GravityCompat.START)
        }else{
            onBackPressedDispatcher.onBackPressed()
        }

        super.onBackPressed()
    }
}