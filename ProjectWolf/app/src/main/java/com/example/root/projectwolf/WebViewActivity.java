package com.example.root.projectwolf;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.CookieManager;


public class WebViewActivity extends Activity {

    private WebView myWebView;
    private CookieManager cookieManager = CookieManager.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
//        webSettings.setAllowContentAccess(true);
//        webSettings.setDomStorageEnabled(true);
//        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
//        webSettings.setAllowFileAccess(true);
//        webSettings.setAllowFileAccessFromFileURLs(true);
//        webSettings.setAppCacheEnabled(true);
//        webSettings.setDatabaseEnabled(true);
//        webSettings.setLoadsImagesAutomatically(true);
//        cookieManager.setAcceptCookie(true);
//        cookieManager.setAcceptThirdPartyCookies(myWebView, true);

        myWebView.loadUrl("http://128.61.54.81:8080");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_web_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
