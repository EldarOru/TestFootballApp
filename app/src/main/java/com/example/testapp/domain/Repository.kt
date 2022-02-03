package com.example.testapp.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testapp.domain.models.Matches
import okhttp3.Response
import retrofit2.http.GET

interface Repository {
    suspend fun getAllMatches(): retrofit2.Response<Matches>
    fun returnMatches(): MutableLiveData<Matches>
}