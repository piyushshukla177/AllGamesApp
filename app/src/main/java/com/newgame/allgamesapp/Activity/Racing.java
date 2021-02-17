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
public class Racing extends AppCompatActivity implements GameitemAdapter.GameClickListener{
 private static final String TAG = Racing.class.getSimpleName();

 private NativeAdLayout nativeAdLayout;
 private LinearLayout adView;
 private NativeBannerAd nativeBannerAd;
 InterstitialAd interstitialAd;
    RecyclerView recyclerView;
    ArrayList Gamelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.racing_a);


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
       Racing.this.onBackPressed();
      }
     });

     findViewById(R.id.favaa).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
       Intent intent = new Intent(Racing.this, SearchActivity.class);
       intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
       Racing.this.startActivity(intent);
      }
     });


     setTitle("       Racing & Car Games");


        Gamelist = new ArrayList();

        //Game zop

     Gamelist.add(new Games("Rodeo Rider ",      "https://www.gamezop.com/g/BJIlCtBbdE?id=jRmYUNF6z","619","619", R.drawable.s22));

     Gamelist.add(new Games("Rafting Adventure ",     "https://www.gamezop.com/g/4JcZiV3XWql?id=jRmYUNF6z","620","620",R.drawable.s23));


     //atm


     Gamelist.add(new Games(" Cars",     "https://games.atmegame.com/gamesworld/games/cars/?utm_source=Gamesworld&utm_medium=Gamesworld","65","65", R.drawable.a16));

     Gamelist.add(new Games(" Crazy Runner",  "https://games.atmegame.com/gamesworld/games/crazy-runner/?utm_source=Gamesworld&utm_medium=Gamesworld","66","66", R.drawable.a17));
     Gamelist.add(new Games("Cube Ninja ",     "https://games.atmegame.com/gamesworld/games/cube-ninja/?utm_source=Gamesworld&utm_medium=Gamesworld","95","95", R.drawable.a20));
     Gamelist.add(new Games("Road Racer ",     "https://games.atmegame.com/gamesworld/games/road-racer/?utm_source=Gamesworld&utm_medium=Gamesworld","67","67", R.drawable.a66));
     Gamelist.add(new Games(" Santa Run",  "https://games.atmegame.com/gamesworld/games/santa-run/?utm_source=Gamesworld&utm_medium=Gamesworld", "68","68",R.drawable.a68));

     Gamelist.add(new Games("Scary Run ",     "https://games.atmegame.com/gamesworld/games/scary-run/?utm_source=Gamesworld&utm_medium=Gamesworld","69","69", R.drawable.a69));
     Gamelist.add(new Games("Speed Racer ",  "https://games.atmegame.com/gamesworld/games/speed-racer/?utm_source=Gamesworld&utm_medium=Gamesworld","70","70", R.drawable.a72));
     Gamelist.add(new Games(" Speedy Driving",  "https://games.atmegame.com/gamesworld/games/speedy-driving/?utm_source=Gamesworld&utm_medium=Gamesworld","71","71", R.drawable.a73));


     Gamelist.add(new Games("Traffic ",  "https://games.atmegame.com/gamesworld/games/traffic/?utm_source=Gamesworld&utm_medium=Gamesworld","72","72", R.drawable.a85));

     Gamelist.add(new Games("Traffic Command ",     "https://games.atmegame.com/gamesworld/games/traffic-command/?utm_source=Gamesworld&utm_medium=Gamesworld","73","73", R.drawable.a86));

     Gamelist.add(new Games("Truck-Parking Pro ",  "https://games.atmegame.com/gamesworld/games/truck-parking-pro/?utm_source=Gamesworld&utm_medium=Gamesworld","74","74", R.drawable.a87));

     Gamelist.add(new Games("Dark Ninja ",  "https://games.atmegame.com/gamesworld/games/dark-ninja/?utm_source=Gamesworld&utm_medium=Gamesworld", "75","75",R.drawable.a23));

     Gamelist.add(new Games(" Creepy Day",     "https://games.atmegame.com/gamesworld/games/creepy-day/?utm_source=Gamesworld&utm_medium=Gamesworld","76","76", R.drawable.a18));

     Gamelist.add(new Games(" Cube Dash",  "https://games.atmegame.com/gamesworld/games/cube-dash/?utm_source=Gamesworld&utm_medium=Gamesworld","77","77", R.drawable.a19));

     recyclerView = (RecyclerView) findViewById(R.id.recyclerview_Racing);
     GameitemAdapter adapter = new GameitemAdapter(Gamelist,this,this);
     recyclerView.setAdapter(adapter);
     GridLayoutManager manager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
     recyclerView.setLayoutManager(manager);
     recyclerView.setHasFixedSize(true);


        }

 @Override
 public void onGamegClick(Games Gamelist) {
  Intent intent = new Intent(Racing.this, MWebActivity.class);
  intent.putExtra("url", Gamelist.getUrl());
  Racing.this.startActivity(intent);
 }
 private void inflateAd(NativeBannerAd nativeBannerAd) {
  // Unregister last ad
  nativeBannerAd.unregisterView();

  // Add the Ad view into the ad container.
  nativeAdLayout = findViewById(R.id.native_banner_ad_container);
  LayoutInflater inflater = LayoutInflater.from(Racing.this);
  // Inflate the Ad view.  The layout referenced is the one you created in the last step.
  adView = (LinearLayout) inflater.inflate(R.layout.native_banner_ad_unit, nativeAdLayout, false);
  nativeAdLayout.addView(adView);

  // Add the AdChoices icon
  RelativeLayout adChoicesContainer = adView.findViewById(R.id.ad_choices_container);
  AdOptionsView adOptionsView = new AdOptionsView(Racing.this, nativeBannerAd, nativeAdLayout);
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