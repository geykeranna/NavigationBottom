package ru.test.navigationbottom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.test.navigationbottom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null)
            replaceFragment(HomeFragment())

        binding.bottomNavView.background = null
        binding.bottomNavView.menu.getItem(2).isEnabled = false
        binding.bottomNavView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.nav_home -> replaceFragment(HomeFragment())
                R.id.nav_info -> replaceFragment(InfoFragment())
                R.id.nav_setting -> replaceFragment(SettingFragment())
                R.id.nav_login -> replaceFragment(AuthFragment())
            }

            return@setOnItemSelectedListener true
        }

        binding.floatingActionBar.setOnClickListener {
            replaceFragment(InterestingFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) =
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()


}