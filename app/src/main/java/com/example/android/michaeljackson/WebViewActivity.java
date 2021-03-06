package com.example.android.michaeljackson;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.android.michaeljackson.R;


public class WebViewActivity extends AppCompatActivity {

    WebView webViewurl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.webview);

        String trackUrl = getIntent().getStringExtra("trackUrl");

        webViewurl = (WebView) findViewById(R.id.webview);

        startWebView(trackUrl);
    }

    private void startWebView(String url) {

        WebSettings settings = webViewurl.getSettings();

        settings.setJavaScriptEnabled(true);
        webViewurl.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);

        webViewurl.getSettings().setBuiltInZoomControls(true);
        webViewurl.getSettings().setUseWideViewPort(true);
        webViewurl.getSettings().setLoadWithOverviewMode(true);

        final ProgressDialog progressDialog = new ProgressDialog(WebViewActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        webViewurl.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(WebViewActivity.this, "Error:" + description, Toast.LENGTH_SHORT).show();

            }
        });
        webViewurl.loadUrl(url);
    }
}
