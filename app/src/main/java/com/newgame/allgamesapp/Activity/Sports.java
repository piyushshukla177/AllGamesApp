package com.newgame.allgamesapp.Activity;

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

@SuppressWarnings("unchecked")
public class Sports extends AppCompatActivity  implements GameitemAdapter.GameClickListener{
 private static final String TAG = Sports.class.getSimpleName();

 private NativeAdLayout nativeAdLayout;
 private LinearLayout adView;
 private NativeBannerAd nativeBannerAd;
 InterstitialAd interstitialAd;
    RecyclerView recyclerView;
    ArrayList<Games> Gamelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sports_a);


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

     interstitialAd = new InterstitialAd(this, getString(R.string.fb_in));
     // Create listeners for the Interstitial Ad
     InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
      @Override
      public void onInterstitialDisplayed(Ad ad) {
       // Interstitial ad displayed callback
       Log.e(TAG, "Interstitial ad displayed.");
      }

      @Override
      public void onInterstitialDismissed(Ad ad) {
       // Interstitial dismissed callback
       Log.e(TAG, "Interstitial ad dismissed.");
      }

      @Override
      public void onError(Ad ad, AdError adError) {
       // Ad error callback
       Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());
      }

      @Override
      public void onAdLoaded(Ad ad) {
       // Interstitial ad is loaded and ready to be displayed
       Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");
       // Show the ad
      }

      @Override
      public void onAdClicked(Ad ad) {
       // Ad clicked callback
       Log.d(TAG, "Interstitial ad clicked!");
      }

      @Override
      public void onLoggingImpression(Ad ad) {
       // Ad impression logged callback
       Log.d(TAG, "Interstitial ad impression logged!");
      }
     };

     // For auto play video ads, it's recommended to load the ad
     // at least 30 seconds before it is shown
     interstitialAd.loadAd(
             interstitialAd.buildLoadAdConfig()
                     .withAdListener(interstitialAdListener)
                     .build());

     findViewById(R.id.backimage).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
       Sports.this.onBackPressed();
      }
     });

     findViewById(R.id.favaa).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
       Intent intent = new Intent(Sports.this, SearchActivity.class);
       intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
       Sports.this.startActivity(intent);
      }
     });



     setTitle("         Sports Games");


        Gamelist = new ArrayList();

        //gamezop
     Gamelist.add(new Games(" Basket Champs",   "https://www.gamezop.com/g/S1_V6GyP5ym?id=jRmYUNF6z"," 598"," 598", R.drawable.s1));

     Gamelist.add(new Games(" Flappy Foot Chinko",    "https://www.gamezop.com/g/r1z13aXqAB?id=jRmYUNF6z"," 599"," 599", R.drawable.s2));

     Gamelist.add(new Games("Let's Go Fishing ",     "https://www.gamezop.com/g/B1hCYSbdN?id=jRmYUNF6z","600","600", R.drawable.s3));

     Gamelist.add(new Games(" Groovy Ski",    "https://www.gamezop.com/g/EJaG_JfW9l?id=jRmYUNF6z","601","601", R.drawable.s7));

     Gamelist.add(new Games(" Dribble Kings",    "https://www.gamezop.com/g/SkJf58Ouf0?id=jRmYUNF6z","602","602", R.drawable.s5));


     Gamelist.add(new Games(" Homerun Hit",    "https://www.gamezop.com/g/B1H5NfCXa?id=jRmYUNF6z","603","603", R.drawable.s6));

     Gamelist.add(new Games("Quack Hunt ",     "https://www.gamezop.com/g/SJXbW8smUUx?id=jRmYUNF6z","604","604", R.drawable.s4));

     Gamelist.add(new Games("Super Goalie Auditions ",    "https://www.gamezop.com/g/SyO94GA7p?id=jRmYUNF6z","605","605", R.drawable.s8));

     Gamelist.add(new Games(" Furious Speed",   "https://www.gamezop.com/g/rkwCYBZuV?id=jRmYUNF6z","606","606", R.drawable.s9));

     Gamelist.add(new Games(" Skater Dude",   "https://www.gamezop.com/g/BJuxCtrWdN?id=jRmYUNF6z","607","607",R.drawable.s10));

     Gamelist.add(new Games("Basketball Master ",     "https://www.gamezop.com/g/HyCKrWd4?id=jRmYUNF6z","608","608", R.drawable.s11));

     Gamelist.add(new Games("Foot Chinko ",     "https://www.gamezop.com/g/r1z13aXqAB?id=jRmYUNF6z","609","609", R.drawable.s12));

     Gamelist.add(new Games("Lane Battles ",     "https://www.gamezop.com/g/4kZgf_1z-9l?id=jRmYUNF6z","610","610", R.drawable.s13));

     Gamelist.add(new Games(" Table Tennis Shots",     "https://www.gamezop.com/g/HJY4pfJP9JQ?id=jRmYUNF6z","611","611",R.drawable.s14));

     Gamelist.add(new Games("Kickin It ",      "https://www.gamezop.com/g/r1ozpMkD5Jm?id=jRmYUNF6z","612","612",R.drawable.s15));


     Gamelist.add(new Games("Hats Off ",    "https://www.gamezop.com/g/HyIM86VXAe?id=jRmYUNF6z","613","613", R.drawable.s16));

     Gamelist.add(new Games("Bowling Stars ",     "https://www.gamezop.com/g/BkdJhTX50B?id=jRmYUNF6z","614","614", R.drawable.s17));

     Gamelist.add(new Games(" City Cricket Battles",    "https://www.gamezop.com/g/HJP4afkvqJQ?id=jRmYUNF6z","615","615", R.drawable.s18));

     Gamelist.add(new Games(" Minigolf Kingdom",      "https://www.gamezop.com/g/S1A0FBWuE?id=jRmYUNF6z","616","616", R.drawable.s19));

     Gamelist.add(new Games(" Soccer Jerks",     "https://www.gamezop.com/g/BJ8Wb8j7ILx?id=jRmYUNF6z","617","617", R.drawable.s20));

     Gamelist.add(new Games("Cricket Gunda ",     "https://www.gamezop.com/g/BkzmafyPqJm?id=jRmYUNF6z","618","618",R.drawable.s21));


     Gamelist.add(new Games(" Mafia Billiard Tricks",      "https://www.gamezop.com/g/SkkV6MJD51Q?id=jRmYUNF6z","621","621",R.drawable.s24));

     Gamelist.add(new Games("Clay Pigeon: Tap and Shoot ",     "https://www.gamezop.com/g/HJKWbUj788l?id=jRmYUNF6z","622","622", R.drawable.s25));


     //atm
     Gamelist.add(new Games("Basketball ",     "https://games.atmegame.com/gamesworld/games/basketball/?utm_source=Gamesworld&utm_medium=Gamesworld","52","52", R.drawable.a8));

     Gamelist.add(new Games("Billiards ",  "https://games.atmegame.com/gamesworld/games/billiards/?utm_source=Gamesworld&utm_medium=Gamesworld","53","53", R.drawable.a9));
     Gamelist.add(new Games("Air Hockeyir ",  "https://games.atmegame.com/gamesworld/games/air-hockey/?utm_source=Gamesworld&utm_medium=Gamesworld", "54","54",R.drawable.a1));
     Gamelist.add(new Games("Monster-Truck Football	 ",  "https://games.atmegame.com/gamesworld/games/monster-truck-football/?utm_source=Gamesworld&utm_medium=Gamesworld","55","55", R.drawable.a55));
     Gamelist.add(new Games("Pool-8 Ball ",  "https://games.atmegame.com/gamesworld/games/pool-8-ball/?utm_source=Gamesworld&utm_medium=Gamesworld", "56","56",R.drawable.a62));

     Gamelist.add(new Games("Stickman-Table Tennis ",  "https://games.atmegame.com/gamesworld/games/stickman-table-tennis/?utm_source=Gamesworld&utm_medium=Gamesworld","57","57", R.drawable.a77));
     Gamelist.add(new Games(" Pops Billiards",  "https://games.atmegame.com/gamesworld/games/pops-billiards/?utm_source=Gamesworld&utm_medium=Gamesworld","58","58", R.drawable.a63));

     Gamelist.add(new Games("Supe-Pon Goal ",     "https://games.atmegame.com/gamesworld/games/supe-pon-goal/?utm_source=Gamesworld&utm_medium=Gamesworld","59","59", R.drawable.a79));
     Gamelist.add(new Games("Penalty Challenge ",  "https://games.atmegame.com/gamesworld/games/penalty-challenge/?utm_source=Gamesworld&utm_medium=Gamesworld", "60","60",R.drawable.a58));


     Gamelist.add(new Games("Space Purge",     "https://games.atmegame.com/gamesworld/games/space-purge/?utm_source=Gamesworld&utm_medium=Gamesworld", "61","61",R.drawable.a71));


     Gamelist.add(new Games(" Barn Dash",  "https://games.atmegame.com/gamesworld/games/barn-dash/?utm_source=Gamesworld&utm_medium=Gamesworld","62","62", R.drawable.a7));
     Gamelist.add(new Games("Jumpers Jumpers ",  "https://games.atmegame.com/gamesworld/games/jumpers/?utm_source=Gamesworld&utm_medium=Gamesworld", "63","63",R.drawable.a49));
     Gamelist.add(new Games("Jungle Treasure",  "https://games.atmegame.com/gamesworld/games/jungle-treasure/?utm_source=Gamesworld&utm_medium=Gamesworld","64","64", R.drawable.a50));


     recyclerView = (RecyclerView) findViewById(R.id.recyclerview_Sports);
     GameitemAdapter adapter = new GameitemAdapter(Gamelist,this,this);
     recyclerView.setAdapter(adapter);
     GridLayoutManager manager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
     recyclerView.setLayoutManager(manager);
     recyclerView.setHasFixedSize(true);

        }
 @Override
 public void onGamegClick(Games Gamelist) {
  Intent intent = new Intent(Sports.this, MWebActivity.class);
  intent.putExtra("url", Gamelist.getUrl());
  Sports.this.startActivity(intent);
 }
 private void inflateAd(NativeBannerAd nativeBannerAd) {
  // Unregister last ad
  nativeBannerAd.unregisterView();

  // Add the Ad view into the ad container.
  nativeAdLayout = findViewById(R.id.native_banner_ad_container);
  LayoutInflater inflater = LayoutInflater.from(Sports.this);
  // Inflate the Ad view.  The layout referenced is the one you created in the last step.
  adView = (LinearLayout) inflater.inflate(R.layout.native_banner_ad_unit, nativeAdLayout, false);
  nativeAdLayout.addView(adView);

  // Add the AdChoices icon
  RelativeLayout adChoicesContainer = adView.findViewById(R.id.ad_choices_container);
  AdOptionsView adOptionsView = new AdOptionsView(Sports.this, nativeBannerAd, nativeAdLayout);
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