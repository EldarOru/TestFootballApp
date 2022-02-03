package com.example.testapp.presentation.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testapp.data.RepositoryImpl
import com.example.testapp.databinding.SplashScreenFragmentBinding
import com.example.testapp.presentation.viewmodels.MatchesListViewModel
import com.example.testapp.presentation.viewmodels.SplashScreenViewModel
import com.example.testapp.presentation.viewmodels.ViewModelFactory
import java.lang.RuntimeException

class SplashScreenFragment: Fragment() {
    private lateinit var viewModel: SplashScreenViewModel
    private lateinit var splashScreenFragmentBinding: SplashScreenFragmentBinding
    private lateinit var onFragmentsInteractionsListener: OnFragmentsInteractionsListener
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentsInteractionsListener){
            onFragmentsInteractionsListener = context
        }else{
            throw RuntimeException("Activity must implement OnFragmentsInteractionsListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        splashScreenFragmentBinding = SplashScreenFragmentBinding.inflate(inflater, container, false)
        return splashScreenFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this, ViewModelFactory(RepositoryImpl)).get(SplashScreenViewModel::class.java)
        viewModel.getAllMatches()

        viewModel.errorMessage.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            splashScreenFragmentBinding.progressBar.visibility = ProgressBar.INVISIBLE
            splashScreenFragmentBinding.restartButton.isEnabled = true
            splashScreenFragmentBinding.restartButton.visibility = Button.VISIBLE
        }

        viewModel.onSuccess.observe(viewLifecycleOwner){
            splashScreenFragmentBinding.progressBar.visibility = ProgressBar.INVISIBLE
            onFragmentsInteractionsListener.onChangeFragment(MatchesListFragment())
        }

        splashScreenFragmentBinding.restartButton.setOnClickListener {
            splashScreenFragmentBinding.progressBar.visibility = ProgressBar.VISIBLE
            it.isEnabled = false
            it.visibility = Button.INVISIBLE
            viewModel.getAllMatches()
        }
    }

}