package com.example.testapp.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.testapp.data.RepositoryImpl
import com.example.testapp.databinding.ActivityMainBinding
import com.example.testapp.domain.internet.RetrofitServices
import com.example.testapp.presentation.fragments.MatchesListFragment
import com.example.testapp.presentation.viewmodels.MatchesListViewModel
import com.example.testapp.presentation.viewmodels.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportFragmentManager.beginTransaction()
            .replace(binding!!.mainContainer.id, MatchesListFragment())
            .commit()



    }
}