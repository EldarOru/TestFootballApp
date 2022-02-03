package com.example.testapp.domain.usecases

import androidx.lifecycle.MutableLiveData
import com.example.testapp.domain.Repository
import com.example.testapp.domain.models.Matches

class ReturnMatchesUseCase(private val repository: Repository) {
    fun returnMatches(): MutableLiveData<Matches>{
        return repository.returnMatches()
    }
}