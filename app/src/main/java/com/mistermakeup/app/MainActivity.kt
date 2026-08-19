
package com.mistermakeup.app

import android.app.Activity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebSettings
import android.webkit.WebChromeClient

class MainActivity : Activity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        webView = WebView(this)

        val settings: WebSettings = webView.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        settings.allowFileAccess = true

        webView.webChromeClient = WebChromeClient()

        webView.loadUrl("file:///android_asset/index.html")

        setContentView(webView)
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
