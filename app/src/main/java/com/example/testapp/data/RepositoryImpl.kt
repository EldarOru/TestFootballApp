package com.example.testapp.data

import androidx.lifecycle.MutableLiveData
import com.example.testapp.domain.Repository
import com.example.testapp.domain.internet.RetrofitServices
import com.example.testapp.domain.models.Matches
import retrofit2.Response

class RepositoryImpl(private val retrofitServices: RetrofitServices): Repository {


    override suspend fun getAllMatches(): Response<Matches> = retrofitServices.getMatches()


    /*
    fun getLeague() {
        GlobalScope.launch(Dispatchers.IO) {
            val response: Response<League> = try {
                RetrofitClient.retrofitServices.getLeague()
            } catch (ex: IOException){
                Log.e("ERROR", ex.localizedMessage)
                return@launch
            }
            if (response.isSuccessful && response.body() != null) {
                Log.d("ONE", response.message())
                val league = response.body() as League
                //Log.e("KEK", quotesList.toString())
                //Log.e("KEK", Thread.currentThread().name)
                withContext(Dispatchers.Main){
                    mutableLeague.value = league
                    Log.e("TWO", response.body().toString())
                }
            }
        }

}
     */

}