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
public class Zombie extends AppCompatActivity implements GameitemAdapter.GameClickListener{
 private static final String TAG = Zombie.class.getSimpleName();

 private NativeAdLayout nativeAdLayout;
 private LinearLayout adView;
 private NativeBannerAd nativeBannerAd;
 InterstitialAd interstitialAd;
    RecyclerView recyclerView;
    ArrayList Gamelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zombie_a);


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
       Zombie.this.onBackPressed();
      }
     });

     findViewById(R.id.favaa).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
       Intent intent = new Intent(Zombie.this, SearchActivity.class);
       intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
       Zombie.this.startActivity(intent);
      }
     });



     setTitle("         Zombie Games");


        Gamelist = new ArrayList();


     Gamelist.add(new Games(" Viking Attack",  "https://games.atmegame.com/gamesworld/games/viking-attack/?utm_source=Gamesworld&utm_medium=Gamesworld","20","20", R.drawable.a88));

     Gamelist.add(new Games("Viking Escape ",     "https://games.atmegame.com/gamesworld/games/viking-escape/?utm_source=Gamesworld&utm_medium=Gamesworld","21","21", R.drawable.a89));
     Gamelist.add(new Games(" Vikings-Vs Skeletons",  "https://games.atmegame.com/gamesworld/games/vikings-vs-skeletons/?utm_source=Gamesworld&utm_medium=Gamesworld","22","22", R.drawable.a90));

     Gamelist.add(new Games("Wothan Escape ",     "https://games.atmegame.com/gamesworld/games/wothan-escape/?utm_source=Gamesworld&utm_medium=Gamesworld","23","23", R.drawable.a91));

     Gamelist.add(new Games(" Zombie Buster",  "https://games.atmegame.com/gamesworld/games/zombie-buster/?utm_source=Gamesworld&utm_medium=Gamesworld","24","24", R.drawable.a92));

     Gamelist.add(new Games("Zombie Shooter ",     "https://games.atmegame.com/gamesworld/games/zombie-shooter/?utm_source=Gamesworld&utm_medium=Gamesworld","25","25", R.drawable.a93));

     Gamelist.add(new Games("Super-Cowboy Run ",  "https://games.atmegame.com/gamesworld/games/super-cowboy-run/?utm_source=Gamesworld&utm_medium=Gamesworld", "26","26",R.drawable.a80));

     Gamelist.add(new Games("Ranger-Vs Zombies ",   "https://games.atmegame.com/gamesworld/games/ranger-vs-zombies/?utm_source=Gamesworld&utm_medium=Gamesworld", "28","28",R.drawable.a65));

     Gamelist.add(new Games("Knife-Vs Zombies	 ",  "https://games.atmegame.com/gamesworld/games/knife-vs-zombies/?utm_source=Gamesworld&utm_medium=Gamesworld","27","27", R.drawable.a51));


     Gamelist.add(new Games("Mad Scientist ",     "https://games.atmegame.com/gamesworld/games/mad-scientist/?utm_source=Gamesworld&utm_medium=Gamesworld", "29","29",R.drawable.a52));

     Gamelist.add(new Games("Swat-Vs Zombies ",  "https://games.atmegame.com/gamesworld/games/swat-vs-zombies/?utm_source=Gamesworld&utm_medium=Gamesworld", "30","30",R.drawable.a81));



     Gamelist.add(new Games("The-Bandit Hunter ",     "https://games.atmegame.com/gamesworld/games/the-bandit-hunter/?utm_source=Gamesworld&utm_medium=Gamesworld", "31","31",R.drawable.a84));


     recyclerView = (RecyclerView) findViewById(R.id.recyclerview_Zombie);
     GameitemAdapter adapter = new GameitemAdapter(Gamelist,this,this);
     recyclerView.setAdapter(adapter);
     GridLayoutManager manager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
     recyclerView.setLayoutManager(manager);
     recyclerView.setHasFixedSize(true);

        }
 @Override
 public void onGamegClick(Games Gamelist) {
  Intent intent = new Intent(Zombie.this, MWebActivity.class);
  intent.putExtra("url", Gamelist.getUrl());
  Zombie.this.startActivity(intent);
 }

 private void inflateAd(NativeBannerAd nativeBannerAd) {
  // Unregister last ad
  nativeBannerAd.unregisterView();

  // Add the Ad view into the ad container.
  nativeAdLayout = findViewById(R.id.native_banner_ad_container);
  LayoutInflater inflater = LayoutInflater.from(Zombie.this);
  // Inflate the Ad view.  The layout referenced is the one you created in the last step.
  adView = (LinearLayout) inflater.inflate(R.layout.native_banner_ad_unit, nativeAdLayout, false);
  nativeAdLayout.addView(adView);

  // Add the AdChoices icon
  RelativeLayout adChoicesContainer = adView.findViewById(R.id.ad_choices_container);
  AdOptionsView adOptionsView = new AdOptionsView(Zombie.this, nativeBannerAd, nativeAdLayout);
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