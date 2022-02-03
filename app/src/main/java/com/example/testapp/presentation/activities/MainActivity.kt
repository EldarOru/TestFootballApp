package com.example.testapp.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.testapp.R
import com.example.testapp.databinding.ActivityMainBinding
import com.example.testapp.presentation.fragments.OnFragmentsInteractionsListener
import com.example.testapp.presentation.fragments.SplashScreenFragment

class MainActivity : AppCompatActivity(), OnFragmentsInteractionsListener {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportFragmentManager.beginTransaction()
            .replace(binding!!.mainContainer.id, SplashScreenFragment())
            .commit()
    }

    override fun onChangeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.animator.slide_in_up, R.animator.fade_out)
            .replace(binding?.mainContainer!!.id, fragment)
            .commit()
    }

    override fun onAddBackStack(name: String, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(name)
            .replace(binding?.mainContainer!!.id, fragment)
            .commit()
    }

    override fun onPopBackStack() {
        for(i in 0..supportFragmentManager.backStackEntryCount) {
            supportFragmentManager.popBackStack()
        }
    }
}