package com.example.and01webview;

import android.os.Build;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        WebView webViewVariable = findViewById(R.id.webView);
        webViewSetUp(webViewVariable);
    }

    // 👇 Ye function tumhe banana hai
    private void webViewSetUp(WebView webView) {

        // Same app me open ho links (browser me na jaye)
        webView.setWebViewClient(new WebViewClient());

        // Settings enable karo
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);  // JS enable

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            webSettings.getSafeBrowsingEnabled();
        }

        // Optional but useful
        webSettings.setDomStorageEnabled(true);

        // Website load karo
        webView.loadUrl("https://www.google.com");
    }
}