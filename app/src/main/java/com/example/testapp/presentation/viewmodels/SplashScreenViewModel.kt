package com.example.testapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapp.domain.Repository
import com.example.testapp.domain.usecases.GetAllMatchesUseCase
import com.example.testapp.domain.usecases.ReturnMatchesUseCase
import kotlinx.coroutines.*

class SplashScreenViewModel(private val getAllMatchesUseCase: GetAllMatchesUseCase,
                            private val returnMatchesUseCase: ReturnMatchesUseCase): ViewModel() {

    val onSuccess = MutableLiveData<Unit>()
    val errorMessage = MutableLiveData<String>()
    private val matchesLiveData = returnMatchesUseCase.returnMatches()
    private var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        ("Exception handled: ${throwable.localizedMessage}")
    }


    fun getAllMatches(){
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = getAllMatchesUseCase.getAllMatches()
            Log.d("CHECK", response.errorBody().toString())
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    matchesLiveData.postValue(response.body())
                    Log.d("KEK", response.body().toString())
                    onSuccess.value = Unit
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}