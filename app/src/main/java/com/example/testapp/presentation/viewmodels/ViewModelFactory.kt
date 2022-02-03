package com.example.testapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testapp.domain.Repository

class ViewModelFactory (private val repository: Repository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MatchesListViewModel::class.java)){
            return MatchesListViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(SplashScreenViewModel::class.java)){
            return SplashScreenViewModel(repository) as T
        }
            throw IllegalAccessException("ViewModel class is not found")
    }
}