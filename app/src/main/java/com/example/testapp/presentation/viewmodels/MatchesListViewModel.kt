package com.example.testapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapp.domain.Repository
import com.example.testapp.domain.models.Matches
import com.example.testapp.domain.usecases.ReturnMatchesUseCase
import kotlinx.coroutines.*

class MatchesListViewModel(private val returnMatchesUseCase: ReturnMatchesUseCase): ViewModel() {

    val matchesLiveData = returnMatchesUseCase.returnMatches()


}
