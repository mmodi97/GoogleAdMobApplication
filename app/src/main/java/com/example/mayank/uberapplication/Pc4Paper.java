package com.example.mayank.uberapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class Pc4Paper extends AppCompatActivity {
WebView webView;
    InterstitialAd bigadd;
    AdView add1,add2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pc4_paper);
        webView=(WebView)findViewById(R.id.pcpaperweb);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webView.loadUrl("https://thailotterytips001.blogspot.com/search/label/4pc%20magazine%20papers");
        add1=(AdView)findViewById(R.id.adViewpcpaper1);
        add2=(AdView)findViewById(R.id.adViewpcpaper2);
        //Banner Add
        AdRequest adRequest = new AdRequest.Builder().build();
        add1.loadAd(adRequest);
        add2.loadAd(adRequest);

        //InterstitialAdd
        bigadd=new InterstitialAd(this);
        bigadd.setAdUnitId("ca-app-pub-7715421588999908/5096210015");
        bigadd.loadAd(new AdRequest.Builder().build());
        bigadd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {

                showInterstitial();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.

            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                showInterstitial();
            }
        });

    }
    private void showInterstitial() {
        if (bigadd.isLoaded()) {
            bigadd.show();
        }
    }
}