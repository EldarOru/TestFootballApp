package com.example.testapp.domain

import com.example.testapp.domain.models.Matches
import okhttp3.Response
import retrofit2.http.GET

interface Repository {
    suspend fun getAllMatches(): retrofit2.Response<Matches>
}