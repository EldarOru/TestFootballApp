package com.example.testapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testapp.domain.Repository
import com.example.testapp.domain.internet.RetrofitServices
import com.example.testapp.domain.models.Matches
import retrofit2.Response

object RepositoryImpl: Repository {
    private val retrofitServices = RetrofitServices.getInstance()
    private val matchesLiveData = MutableLiveData<Matches>()
    override suspend fun getAllMatches(): Response<Matches> = retrofitServices.getMatches()

    override fun returnMatches(): MutableLiveData<Matches> {
        return matchesLiveData
    }
}