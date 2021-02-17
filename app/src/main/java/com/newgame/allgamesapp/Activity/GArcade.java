package com.newgame.allgamesapp.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;

import com.newgame.allgamesapp.Adapter.GameitemAdapter;
import com.newgame.allgamesapp.R;
import com.newgame.allgamesapp.model.Games;

import java.util.ArrayList;
import java.util.List;

public class GArcade extends AppCompatActivity implements GameitemAdapter.GameClickListener{

    private ArrayList<Games> Gamelist = new ArrayList<>();
    private Adapter myAdapter;
    private static final String TAG = GArcade.class.getSimpleName();

    private NativeAdLayout nativeAdLayout;
    private LinearLayout adView;
    private NativeBannerAd nativeBannerAd;
    InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_arcade);



        AudienceNetworkAds.initialize(this);
        nativeBannerAd = new NativeBannerAd(this, getString(R.string.fb_native_banner_ads));
        NativeAdListener nativeAdListener = new NativeAdListener() {

            @Override
            public void onMediaDownloaded(Ad ad) {
                // Native ad finished downloading all assets
                Log.e(TAG, "Native ad finished downloading all assets.");
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Native ad failed to load
                Log.e(TAG, "Native ad failed to load: " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Race condition, load() called again before last ad was displayed
                if (nativeBannerAd == null || nativeBannerAd != ad) {
                    return;
                }
                // Inflate Native Banner Ad into Container
                inflateAd(nativeBannerAd);
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Native ad clicked
                Log.d(TAG, "Native ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Native ad impression
                Log.d(TAG, "Native ad impression logged!");
            }
        };
        // load the ad
        nativeBannerAd.loadAd(
                nativeBannerAd.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build());




        findViewById(R.id.backimage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              GArcade.this.onBackPressed();
            }
        });
        findViewById(R.id.fav).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GArcade.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        Gamelist = new ArrayList<>();

        Gamelist.add(new Games("Red Rush ",     "https://www.gamezop.com/g/H16cNf0X6?id=jRmYUNF6z", "449","449", R.drawable.r17));

        Gamelist.add(new Games("Tower Twist ",      "https://www.gamezop.com/g/HJT46GkPcy7?id=jRmYUNF6z", "450","450", R.drawable.r18));
        Gamelist.add(new Games(" Falling Through",    "https://www.gamezop.com/g/ByGqEfCXa?id=jRmYUNF6z", "451","451", R.drawable.r12));
        Gamelist.add(new Games(" Flexi Snake",      "https://www.gamezop.com/g/SkQwnwnbK?id=jRmYUNF6z", "452  ","452  ", R.drawable.r15));

        Gamelist.add(new Games("Bouncy ",    "https://www.gamezop.com/g/H1Tz6z1Dqym?id=jRmYUNF6z", "453  ","453  ", R.drawable.r25));

        Gamelist.add(new Games(" Vegetables vs. Chef",   "https://www.gamezop.com/g/H1be5Ef0Qp?id=jRmYUNF6z", "454  ","454  ", R.drawable.r2));

        Gamelist.add(new Games("Watch The Walls ",    "https://www.gamezop.com/g/BJm9VfCmp?id=jRmYUNF6z", "455  ","455  ", R.drawable.r3));

        Gamelist.add(new Games(" Stay On The Road",   "https://www.gamezop.com/g/HJ-72IFXyg?id=jRmYUNF6z", "456 ","456 ", R.drawable.r4));

        Gamelist.add(new Games(" Whirly Chick",    "https://www.gamezop.com/g/rJWwrYIB?id=jRmYUNF6z", "457","457", R.drawable.r5));


        Gamelist.add(new Games("Spikes Don't ",      "https://www.gamezop.com/g/ry55EG0mp?id=jRmYUNF6z", "458","458", R.drawable.r6));

        Gamelist.add(new Games(" Sheepop",     "https://www.gamezop.com/g/NytfOJMW5e?id=jRmYUNF6z", "459","459",R.drawable.r7));

        Gamelist.add(new Games("Fly Safe ",     "https://www.gamezop.com/g/Hkww3v3-F?id=jRmYUNF6z", "460","460", R.drawable.r8));

        Gamelist.add(new Games(" Car Flip",     "https://www.gamezop.com/g/ByRkh6XcAB?id=jRmYUNF6z", "461","461", R.drawable.r9));

        Gamelist.add(new Games("Cuby Dash ",     "https://www.gamezop.com/g/Sy6b98udz0?id=jRmYUNF6z", "462","462", R.drawable.r10));

        Gamelist.add(new Games(" Don't Eat Trash",  "https://www.gamezop.com/g/r1HAtSWO4?id=jRmYUNF6z", "463","463", R.drawable.r11));

        Gamelist.add(new Games(" Falling Through",    "https://www.gamezop.com/g/ByGqEfCXa?id=jRmYUNF6z", "464","464", R.drawable.r12));


        Gamelist.add(new Games("Super Sprint ",     "https://www.gamezop.com/g/HyV_Nm-kK?id=jRmYUNF6z", "465","465", R.drawable.r13));

        Gamelist.add(new Games("Where's Tom? ",      "https://www.gamezop.com/g/HJ0eRFSWuV?id=jRmYUNF6z", "466","466", R.drawable.r14));

        Gamelist.add(new Games(" Flexi Snake",      "https://www.gamezop.com/g/SkQwnwnbK?id=jRmYUNF6z", "467","467", R.drawable.r15));


        Gamelist.add(new Games("Zoo Pinball ",     "https://www.gamezop.com/g/Ske-CtBbdV?id=jRmYUNF6z", "468","468",  R.drawable.r16));



        Gamelist.add(new Games("Drift Control ",   "https://www.gamezop.com/g/BkxuV7ZkK?id=jRmYUNF6z", "469","469", R.drawable.r19));

        Gamelist.add(new Games("Hoop Loop ",      "https://www.gamezop.com/g/SJJl94z0m6?id=jRmYUNF6z", "470","470",  R.drawable.r20));

        Gamelist.add(new Games("Skill Shot ",   "https://www.gamezop.com/g/ByvOVQZkK?id=jRmYUNF6z", "471","471", R.drawable.r21));

        Gamelist.add(new Games(" Exoplanet Express",    "https://www.gamezop.com/g/SyEQTzyw91X?id=jRmYUNF6z", "472","472",  R.drawable.r22));

        Gamelist.add(new Games(" Bouncing Beasts",     "https://www.gamezop.com/g/4y6efOyf-5g?id=jRmYUNF6z", "473","473",  R.drawable.r23));

        Gamelist.add(new Games("Dodgy ",      "https://www.gamezop.com/g/ryRWrDaNPF?id=jRmYUNF6z", "474","474", R.drawable.r24));

        Gamelist.add(new Games("Bouncy ",     "https://www.gamezop.com/g/H1Tz6z1Dqym?id=jRmYUNF6z", "475","475", R.drawable.r25));


        Gamelist.add(new Games("Spinning Shooter ",   "https://www.gamezop.com/g/B19EafJP9JX?id=jRmYUNF6z", "476","476", R.drawable.r26));

        Gamelist.add(new Games("5 Jumps ",     "https://www.gamezop.com/g/BJL_Vm-yF?id=jRmYUNF6z", "477","477",  R.drawable.r27));

        Gamelist.add(new Games("Rock the Dock ",     "https://www.gamezop.com/g/EJoezu1MWqg?id=jRmYUNF6z", "478","478",  R.drawable.r28));

        Gamelist.add(new Games("Light Tower ",      "https://www.gamezop.com/g/SJsqNMAmp?id=jRmYUNF6z", "479","479",  R.drawable.r29));

        Gamelist.add(new Games(" Sheep Stacking",    "https://www.gamezop.com/g/V1IZG_1f-qg?id=jRmYUNF6z", "480","480", R.drawable.r30));


        Gamelist.add(new Games("Tricky Trip ",      "https://www.gamezop.com/g/NJ3xGOyfb5l?id=jRmYUNF6z", "482","482",  R.drawable.r31));

        Gamelist.add(new Games("Shade Shuffle ",      "https://www.gamezop.com/g/SyFcNzAX6?id=jRmYUNF6z", "483","483", R.drawable.r32));

        Gamelist.add(new Games(" Melon Pinch",    "https://www.gamezop.com/g/E1szd1fW9e?id=jRmYUNF6z", "484","484", R.drawable.r33));

        Gamelist.add(new Games("Grumpy Gorilla",   "https://www.gamezop.com/g/N1sZfO1fWqg?id=jRmYUNF6z", "485","485", R.drawable.r34));

        Gamelist.add(new Games("Quick Slip ",     "https://www.gamezop.com/g/rklv3w2bt?id=jRmYUNF6z", "486","486", R.drawable.r35));


        Gamelist.add(new Games(" Fidgety Frog",      "https://www.gamezop.com/g/NkxfOJM-qg?id=jRmYUNF6z", "487","487", R.drawable.r36));

        Gamelist.add(new Games(" Focus Locus",      "https://www.gamezop.com/g/HkE7nLFQkx?id=jRmYUNF6z", "488","488", R.drawable.r37));

        Gamelist.add(new Games("Jom Jom Jump ",      "https://www.gamezop.com/g/SyjAFr-dE?id=jRmYUNF6z", "489","489", R.drawable.r38));

        Gamelist.add(new Games(" Fizz Fuss",     "https://www.gamezop.com/g/S1VZ-LjQUUl?id=jRmYUNF6z", "490","490",  R.drawable.r39));

        Gamelist.add(new Games("Rains of Fire ",     "https://www.gamezop.com/g/NyVM_yG-qe?id=jRmYUNF6z", "491","491",  R.drawable.r40));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.garc);
        GameitemAdapter newsitemAdapter = new GameitemAdapter(Gamelist, this,this);
        myrv.setLayoutManager(new GridLayoutManager(getApplication(), 3));
        myrv.setAdapter(newsitemAdapter);


    }



    @Override
    public void onGamegClick(Games Gamelist) {
        Intent intent = new Intent(GArcade.this, MWebActivity.class);
        intent.putExtra("url", Gamelist.getUrl());
        GArcade.this.startActivity(intent);
    }

    private void inflateAd(NativeBannerAd nativeBannerAd) {
        // Unregister last ad
        nativeBannerAd.unregisterView();

        // Add the GAd view into the ad container.
        nativeAdLayout = findViewById(R.id.native_banner_ad_container);
        LayoutInflater inflater = LayoutInflater.from(GArcade.this);
        // Inflate the GAd view.  The layout referenced is the one you created in the last step.
        adView = (LinearLayout) inflater.inflate(R.layout.native_banner_ad_unit, nativeAdLayout, false);
        nativeAdLayout.addView(adView);

        // Add the AdChoices icon
        RelativeLayout adChoicesContainer = adView.findViewById(R.id.ad_choices_container);
        AdOptionsView adOptionsView = new AdOptionsView(GArcade.this, nativeBannerAd, nativeAdLayout);
        adChoicesContainer.removeAllViews();
        adChoicesContainer.addView(adOptionsView, 0);

        // Create native UI using the ad metadata.
        TextView nativeAdTitle = adView.findViewById(R.id.native_ad_title);
        TextView nativeAdSocialContext = adView.findViewById(R.id.native_ad_social_context);
        TextView sponsoredLabel = adView.findViewById(R.id.native_ad_sponsored_label);
        MediaView nativeAdIconView = adView.findViewById(R.id.native_icon_view);
        Button nativeAdCallToAction = adView.findViewById(R.id.native_ad_call_to_action);

        // Set the Text.
        nativeAdCallToAction.setText(nativeBannerAd.getAdCallToAction());
        nativeAdCallToAction.setVisibility(
                nativeBannerAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        nativeAdTitle.setText(nativeBannerAd.getAdvertiserName());
        nativeAdSocialContext.setText(nativeBannerAd.getAdSocialContext());
        sponsoredLabel.setText(nativeBannerAd.getSponsoredTranslation());

        // Register the Title and CTA button to listen for clicks.
        List<View> clickableViews = new ArrayList<>();
        clickableViews.add(nativeAdTitle);
        clickableViews.add(nativeAdCallToAction);
        nativeBannerAd.registerViewForInteraction(adView, nativeAdIconView, clickableViews);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy () {
        super.onDestroy();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }

}