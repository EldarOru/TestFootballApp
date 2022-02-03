package com.example.testapp.domain.internet

import com.example.testapp.domain.models.Matches
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitServices {
    /*
    @GET("soccer/leagues/1?apikey=a5b72db0-8408-11ec-b4c9-396970b32d9a")
    suspend fun getLeague(): Response<League>
     */

    @GET("soccer/matches?apikey=a5b72db0-8408-11ec-b4c9-396970b32d9a&season_id=496&date_from=2020-09-19")
    suspend fun getMatches(): Response<Matches>

    companion object{
        var retrofitService: RetrofitServices? = null
        fun getInstance() : RetrofitServices {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitServices::class.java)
            }
            return retrofitService!!
        }

        const val BASE_URL = "https://app.sportdataapi.com/api/v1/"
        private const val API_KEY = "a5b72db0-8408-11ec-b4c9-396970b32d9a"
    }
}