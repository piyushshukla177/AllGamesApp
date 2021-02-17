package com.newgame.allgamesapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
@SuppressWarnings("unchecked")
public class Stragery extends AppCompatActivity implements GameitemAdapter.GameClickListener {
    private static final String TAG = Stragery.class.getSimpleName();

    private NativeAdLayout nativeAdLayout;
    private LinearLayout adView;
    private NativeBannerAd nativeBannerAd;
    InterstitialAd interstitialAd;
    RecyclerView recyclerView;
    ArrayList Gamelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stragery);


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
                Stragery.this.onBackPressed();
            }
        });

        findViewById(R.id.favaa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Stragery.this, SearchActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Stragery.this.startActivity(intent);
            }
        });



        setTitle("         Strategy Games");


        Gamelist = new ArrayList();

        Gamelist.add(new Games("Ludo With Friends ",     "https://www.gamezop.com/g/SkhljT2fdgb?id=jRmYUNF6z", "623","623", R.drawable.t8));

        Gamelist.add(new Games("Bubble Wipeout ",     "https://www.gamezop.com/g/H1AN6fkwqJ7?id=jRmYUNF6z", "624","624",R.drawable.t9));

        Gamelist.add(new Games("Yummy Taco ",     "https://www.gamezop.com/g/rJyWCKHbON?id=jRmYUNF6z",  "625","625",R.drawable.t18));
        Gamelist.add(new Games("Hex Burst ",    "https://www.gamezop.com/g/H1abja2M_eb?id=jRmYUNF6z","626","626",R.drawable.t39));


        Gamelist.add(new Games(" Save Your Pinky",      "https://www.gamezop.com/g/H1pbZUoXIUl?id=jRmYUNF6z", "627","627",  R.drawable.t17));
        Gamelist.add(new Games("Ship It Up! ",     "https://www.gamezop.com/g/rJybo6nfdgb?id=jRmYUNF6z",  "628","628", R.drawable.t12));
        Gamelist.add(new Games("Kingdom Fight ",      "https://www.gamezop.com/g/SyfxJ3a75Cr?id=jRmYUNF6z",  "629","629", R.drawable.t1));

        Gamelist.add(new Games("Tic Tac Toe ",     "https://www.gamezop.com/g/H1WmafkP9JQ?id=jRmYUNF6z",  "630","630", R.drawable.t3));


        Gamelist.add(new Games("Snack Time ",      "https://www.gamezop.com/g/SkKlAYSbuE?id=jRmYUNF6z",  "638","638", R.drawable.t2));


        Gamelist.add(new Games("Craigen Stones ",     "https://www.gamezop.com/g/Bk7RYrZO4?id=jRmYUNF6z", "639","639", R.drawable.t4));

        Gamelist.add(new Games(" Cute Towers 2",      "https://www.gamezop.com/g/ByZ3DF_hd?id=jRmYUNF6z", "631","631", R.drawable.t5));


        Gamelist.add(new Games(" Monsterjong",      "https://www.gamezop.com/g/S1-bxXI39?id=jRmYUNF6z", "632","632",  R.drawable.t6));

        Gamelist.add(new Games("Chess Grandmaster ",    "https://www.gamezop.com/g/rkAXTzkD5kX?id=jRmYUNF6z",  "632","633", R.drawable.t7));



        Gamelist.add(new Games("Spider Solitaire ",     "https://www.gamezop.com/g/B1MfIa4QCg?id=jRmYUNF6z",  "634","634",R.drawable.t10));

        Gamelist.add(new Games("Omit Orange 2",     "https://www.gamezop.com/g/Bypb6MJvqJQ?id=jRmYUNF6z",  "635","635",R.drawable.t11));



        Gamelist.add(new Games("Brick Plunge ",    "https://www.gamezop.com/g/BJ9bvzIKdJl?id=jRmYUNF6z",  "636","636", R.drawable.t13));

        Gamelist.add(new Games("Crazy Pizza ",    "https://www.gamezop.com/g/SyN0KSWuV?id=jRmYUNF6z",  "637","637", R.drawable.t14));

        Gamelist.add(new Games("Illuminate ",    "https://www.gamezop.com/g/rkHuVQ-1K?id=jRmYUNF6z",  "641","641", R.drawable.t16));

        Gamelist.add(new Games(" Save Your Pinky",    "https://www.gamezop.com/g/H1pbZUoXIUl?id=jRmYUNF6z",  "642","642", R.drawable.t17));



        Gamelist.add(new Games(" Zigzag Clash",     "https://www.gamezop.com/g/BJlg94zA76?id=jRmYUNF6z",  "643","643", R.drawable.t19));

        Gamelist.add(new Games(" Where's the Ace?",     "https://www.gamezop.com/g/HyZMUTVQRe?id=jRmYUNF6z",  "644","644", R.drawable.t20));

        Gamelist.add(new Games("Time Warp ",     "https://www.gamezop.com/g/Sk728YXJx?id=jRmYUNF6z", "645","645", R.drawable.t21));

        Gamelist.add(new Games(" Battleships Armada",  "https://www.gamezop.com/g/rkt7TzJv9k7?id=jRmYUNF6z", "646","646", R.drawable.t22));

        Gamelist.add(new Games("Jelly Bears ",    "https://www.gamezop.com/g/SJcRYSbu4?id=jRmYUNF6z", "647","647", R.drawable.t23));
        Gamelist.add(new Games("Hansel & Gretel ",     "https://www.gamezop.com/g/HyKCFB-dV?id=jRmYUNF6z", "648","648", R.drawable.t24));
        Gamelist.add(new Games("Little Bouncing Guys ",    "https://www.gamezop.com/g/Sy6RYB-u4?id=jRmYUNF6z",  "649","649",R.drawable.t25));

        Gamelist.add(new Games(" Tiny Tripper",    "https://www.gamezop.com/g/rkb--Io78Ux?id=jRmYUNF6z",  "650","650", R.drawable.t26));


        Gamelist.add(new Games("Pirate's Pillage! Aye! Aye! ",   "https://www.gamezop.com/g/r1fl9VzRX6?id=jRmYUNF6z",  "651","651",  R.drawable.t27));

        Gamelist.add(new Games("Pixel Brothers ",   "https://www.gamezop.com/g/41rGO1Gbqe?id=jRmYUNF6z",  "653","653",R.drawable.t29));

        Gamelist.add(new Games(" Let Me Grow",    "https://www.gamezop.com/g/SklmW1ad_?id=jRmYUNF6z", "654","654", R.drawable.t30));


        Gamelist.add(new Games("Junior Chess ",     "https://www.gamezop.com/g/Hkh7azyv9km?id=jRmYUNF6z",  "655","655", R.drawable.t31));

        Gamelist.add(new Games("Traffic Command",    "https://www.gamezop.com/g/SykGDfUKOkg?id=jRmYUNF6z",  "656","656", R.drawable.t32));

        Gamelist.add(new Games(" Road Safety",     "https://www.gamezop.com/g/r1z-eQ8nq?id=jRmYUNF6z",  "658","658",R.drawable.t34));

        Gamelist.add(new Games("Greedy Gnomes ",     "https://www.gamezop.com/g/BydCYS-ON?id=jRmYUNF6z",  "659","659", R.drawable.t35));


        Gamelist.add(new Games("Coin Grab ",   "https://www.gamezop.com/g/HkSWia3f_g-?id=jRmYUNF6z",  "660","660", R.drawable.t36));

        Gamelist.add(new Games("Pebble Boy ",    "https://www.gamezop.com/g/H1TbVUa8aWe?id=jRmYUNF6z", "661","661",R.drawable.t37));

        Gamelist.add(new Games("Cheat Spidy ",     "https://www.gamezop.com/g/BkuNQbJt?id=jRmYUNF6z", "662","662", R.drawable.t38));



        Gamelist.add(new Games(" Feed The Figures 2",    "https://www.gamezop.com/g/BkR-TMJP5kQ?id=jRmYUNF6z",  "663","663", R.drawable.t40));

        Gamelist.add(new Games(" Hex Burst",    "https://www.gamezop.com/g/H1abja2M_eb?id=jRmYUNF6z", "664","664", R.drawable.t41));




        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_stra);
        GameitemAdapter adapter = new GameitemAdapter(Gamelist,this,this);
        recyclerView.setAdapter(adapter);
        GridLayoutManager manager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

    }
    @Override
    public void onGamegClick(Games Gamelist) {
        Intent intent = new Intent(Stragery.this, MWebActivity.class);
        intent.putExtra("url", Gamelist.getUrl());
        Stragery.this.startActivity(intent);
    }

    private void inflateAd(NativeBannerAd nativeBannerAd) {
        // Unregister last ad
        nativeBannerAd.unregisterView();

        // Add the Ad view into the ad container.
        nativeAdLayout = findViewById(R.id.native_banner_ad_container);
        LayoutInflater inflater = LayoutInflater.from(Stragery.this);
        // Inflate the Ad view.  The layout referenced is the one you created in the last step.
        adView = (LinearLayout) inflater.inflate(R.layout.native_banner_ad_unit, nativeAdLayout, false);
        nativeAdLayout.addView(adView);

        // Add the AdChoices icon
        RelativeLayout adChoicesContainer = adView.findViewById(R.id.ad_choices_container);
        AdOptionsView adOptionsView = new AdOptionsView(Stragery.this, nativeBannerAd, nativeAdLayout);
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