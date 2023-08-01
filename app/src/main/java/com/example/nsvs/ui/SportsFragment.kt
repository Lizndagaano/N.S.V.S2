package com.example.nsvs.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.nsvs.R
import com.example.nsvs.databinding.FragmentChapelBinding
import com.example.nsvs.databinding.FragmentSportsBinding


class SportsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sports, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val myWebView: WebView = view.findViewById(R.id.webView_sports)
        //webViewClient this is the objecct responsible for most actions inside webView
        myWebView.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                url:String
            ): Boolean {

                if (view != null) {
                    view.loadUrl(url)
                }

                return true
            }
        }
        myWebView.loadUrl("https://nsvsnamugongo.com/index.php/sports/")
        myWebView.settings.javaScriptEnabled = true
        myWebView.settings.allowContentAccess = true
        myWebView.settings.useWideViewPort = true
        myWebView.settings.domStorageEnabled = true
    }

}