package com.example.testapp.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.testapp.databinding.WebFragmentBinding

class WebFragment: Fragment() {
    private lateinit var webFragmentBinding: WebFragmentBinding
    private var teamName: String = "UNDEFINED_NAME"

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        webFragmentBinding = WebFragmentBinding.inflate(inflater, container, false)
        return webFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        teamName = requireArguments().getString(TEAM_NAME) as String
        webFragmentBinding.webView.webViewClient = WebViewClient()
        webFragmentBinding.webView.apply {
            loadUrl("${BASE_GOOGLE_URL}${teamName}")
            settings.javaScriptEnabled = true
            settings.setSupportZoom(true)
        }

    }

    companion object{
        fun newInstanceWebFragment(teamName: String): WebFragment{
            return WebFragment().apply {
                arguments = Bundle().apply {
                    putString(TEAM_NAME, teamName)
                }
            }
        }
        private const val BASE_GOOGLE_URL = "https://www.google.com/search?q="
        private const val TEAM_NAME = "team_name"
    }

}