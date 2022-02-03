package com.example.testapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testapp.domain.Repository
import com.example.testapp.domain.usecases.GetAllMatchesUseCase
import com.example.testapp.domain.usecases.ReturnMatchesUseCase

class ViewModelFactory (private val repository: Repository): ViewModelProvider.Factory {
    private val getAllMatchesUseCase = GetAllMatchesUseCase(repository)
    private val returnMatchesUseCase = ReturnMatchesUseCase(repository)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MatchesListViewModel::class.java)){
            return MatchesListViewModel(returnMatchesUseCase = returnMatchesUseCase) as T
        }
        if (modelClass.isAssignableFrom(SplashScreenViewModel::class.java)){
            return SplashScreenViewModel(getAllMatchesUseCase = getAllMatchesUseCase,
                                        returnMatchesUseCase = returnMatchesUseCase) as T
        }
            throw IllegalAccessException("ViewModel class is not found")
    }
}