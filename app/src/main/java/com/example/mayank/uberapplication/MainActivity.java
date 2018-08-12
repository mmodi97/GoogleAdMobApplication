package com.example.mayank.uberapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
Button b1,b2,b3,b4,b5,b6,b7;
AdView mybanneradd,mybanneradd2;
InterstitialAd bigadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.home);
        b2=(Button)findViewById(R.id.lotterytips);
        b3=(Button)findViewById(R.id.loteryresult);
        b4=(Button)findViewById(R.id.magazine);
        b5=(Button)findViewById(R.id.lotterypaper);
        b6=(Button)findViewById(R.id.thailottery3up);
        b7=(Button)findViewById(R.id.pcpaper);
        mybanneradd=(AdView)findViewById(R.id.adView);
        mybanneradd2=(AdView)findViewById(R.id.adView1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent=new Intent(MainActivity.this,Home.class);
              startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LotteryTips.class);
                startActivity(intent);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,LotteryResult.class);
                startActivity(intent);

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,Magazine.class);
                startActivity(intent);

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,LotteryPaper.class);
                startActivity(intent);

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,ThaiLottery3up.class);
                startActivity(intent);

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,Pc4Paper.class);
                startActivity(intent);

            }
        });
//Banner Add
        AdRequest adRequest = new AdRequest.Builder().build();
        mybanneradd.loadAd(adRequest);
        mybanneradd2.loadAd(adRequest);
        //Interstitialad
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
