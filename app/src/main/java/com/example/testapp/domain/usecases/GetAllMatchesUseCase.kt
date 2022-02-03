package com.example.testapp.domain.usecases

import com.example.testapp.domain.Repository
import com.example.testapp.domain.models.Matches
import retrofit2.Response

class GetAllMatchesUseCase(private val repository: Repository) {
    suspend fun getAllMatches(): Response<Matches>{
        return repository.getAllMatches()
    }
}