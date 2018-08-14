package com.example.user_pc.tbcrudsql;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView; // memasukan class WebView
import android.webkit.WebViewClient; //memasukan class WebViewClient
import android.widget.Toast;

public class Pendaftaran extends AppCompatActivity {
    private WebView view;
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);

        WebView webView = (WebView) findViewById(R.id.webPendaftaran);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);

        // Tiga baris di bawah ini agar laman yang dimuat dapat
        // melakukan zoom.
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        // Baris di bawah untuk menambahkan scrollbar di dalam WebView-nya
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://form.poltekpos.ac.id");

    }

    private Boolean exit = false;
    @Override
// Detect when the back button is pressed

    public void onBackPressed() {
        mWebView = (WebView) findViewById(R.id.webPendaftaran);
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        }
        else {
            if (exit)
                this.finish();
            else {
                Toast.makeText(this, "PRESS AGAIN TO HOME !!!",
                        Toast.LENGTH_SHORT).show();
                exit = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        exit = false;
                    }
                }, 3 * 1000);
            }

            // Let the system handle the back button

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.utama, menu);
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

            Toast.makeText(this, "Created by : "+ "\n Imron Sumadireja"+ "\n Yusniar Nur Syarif Sidiq"+ "\n Andri Fajar Sunandhar", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
