package com.idea.rentbaaz

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient

class MapViewActivity : AppCompatActivity() {
    lateinit var mapView : WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_view)
        mapView = findViewById(R.id.map_view)
        mapView.webViewClient = WebViewClient()
        mapView.settings.javaScriptEnabled = true
        val uri = Uri.parse("https://www.google.co.in/maps/dir/" + "kormangala" + "/indiranagar")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.setPackage("com.google.android.apps.maps")
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        mapView.loadUrl(uri.toString())
    }

    fun back(view: View) {
        finish()
    }
}