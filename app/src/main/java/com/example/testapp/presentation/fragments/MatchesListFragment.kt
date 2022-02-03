package com.example.testapp.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.data.RepositoryImpl
import com.example.testapp.databinding.MatchesListFragmentBinding
import com.example.testapp.domain.internet.RetrofitServices
import com.example.testapp.presentation.adapters.MatchesListAdapter
import com.example.testapp.presentation.viewmodels.MatchesListViewModel
import com.example.testapp.presentation.viewmodels.ViewModelFactory

class MatchesListFragment: Fragment() {
    private lateinit var matchesListFragmentBinding:MatchesListFragmentBinding
    private lateinit var matchesListAdapter: MatchesListAdapter
    private lateinit var viewModel: MatchesListViewModel
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        matchesListFragmentBinding = MatchesListFragmentBinding.inflate(inflater,container,false)
        return matchesListFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, ViewModelFactory(RepositoryImpl)).get(MatchesListViewModel::class.java)
        //viewModel.getAllMatches()
        setRecyclerView()
        /*
        viewModel.matchesLiveData.observe(viewLifecycleOwner){
            matchesListAdapter.list = it.data
        }

         */
    }

    private fun setRecyclerView(){
        val recyclerView = matchesListFragmentBinding.matchesRv
        recyclerView.layoutManager = LinearLayoutManager(context)
        matchesListAdapter = MatchesListAdapter(requireContext())
        recyclerView.adapter = matchesListAdapter
        matchesListAdapter.list = viewModel.matchesLiveData.value!!.data

    }
}