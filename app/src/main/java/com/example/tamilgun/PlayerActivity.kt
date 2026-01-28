package com.example.tamilgun

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class PlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val webView = WebView(this)
        setContentView(webView)

        val videoUrl = intent.getStringExtra("VIDEO_URL") ?: ""

        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            mediaPlaybackRequiresUserGesture = false
            // Pretend to be a desktop browser
            userAgentString = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) Chrome/120.0.0.0 Safari/537.36"
        }

        // Bypassing the Domain Block
        val headers = HashMap<String, String>()
        headers["Referer"] = "https://tamilgun.now/"

        webView.loadUrl(videoUrl, headers)
    }
}