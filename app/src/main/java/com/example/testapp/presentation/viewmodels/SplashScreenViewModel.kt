package com.example.testapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.testapp.domain.Repository
import kotlinx.coroutines.*

class SplashScreenViewModel(private val repository: Repository): ViewModel() {

    val matchesLiveData = repository.returnMatches()
    private var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        ("Exception handled: ${throwable.localizedMessage}")
    }

    fun getAllMatches(){
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = repository.getAllMatches()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    matchesLiveData.postValue(response.body())
                    Log.d("KEK", response.body().toString())
                    //loading.value = false
                } else {
                    //onError("Error : ${response.message()} ")
                }
            }
        }
    }
}