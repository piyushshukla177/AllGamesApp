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
public class Action extends AppCompatActivity implements GameitemAdapter.GameClickListener{
 private static final String TAG = Action.class.getSimpleName();

 private NativeAdLayout nativeAdLayout;
 private LinearLayout adView;
 private NativeBannerAd nativeBannerAd;
 InterstitialAd interstitialAd;
    RecyclerView recyclerView;
 ArrayList<Games> Gamelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_a);
     findViewById(R.id.favaa).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
       Intent intent = new Intent(Action.this, SearchActivity.class);
       intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
       Action.this.startActivity(intent);
      }
     });
     findViewById(R.id.backimage).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
       Action.this.onBackPressed();
      }
     });


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





     setTitle("       Action Games");

        Gamelist = new ArrayList();

        ///Gamezop
     Gamelist.add(new Games(" Bottle Shoot",    "https://www.gamezop.com/g/B1fSpMkP51m?id=jRmYUNF6z","492","492", R.drawable.a24));

     Gamelist.add(new Games("Slap Fest ",    "https://www.gamezop.com/g/ryN9EGAQa?id=jRmYUNF6z", "493","493", R.drawable.a14a));
     Gamelist.add(new Games("Pumpkin Smasher ",    "https://www.gamezop.com/g/rJXlRtBWd4?id=jRmYUNF6z  ","494","494",  R.drawable.t3));

     Gamelist.add(new Games("Zombies Can't Jump 2",    "https://www.gamezop.com/g/rkxMV8TI6Wg?id=jRmYUNF6z ","495","495", R.drawable.t4));

     Gamelist.add(new Games(" Savage Revenge",    "https://www.gamezop.com/g/ry6bwfUt_Jg?id=jRmYUNF6z ","496","496",  R.drawable.t5));

     Gamelist.add(new Games(" Plane Fight"," https://www.gamezop.com/g/H1IEpMJP917?id=jRmYUNF6z ", "497","497", R.drawable.t19));

     Gamelist.add(new Games("Evil Wyrm ",    "https://www.gamezop.com/g/ry8RYrWu4?id=jRmYUNF6z","498","498", R.drawable.a1a));

     Gamelist.add(new Games("Defense of Karmax 3 ",    "https://www.gamezop.com/g/r1zCFBZdV?id=jRmYUNF6z  ", "499","499",  R.drawable.a2a));

     Gamelist.add(new Games("Pixel Zombies ",    "https://www.gamezop.com/g/S14VrK8B?id=jRmYUNF6z ", "500","500", R.drawable.a3a));

     Gamelist.add(new Games("Cuby Zap ",    "https://www.gamezop.com/g/HJeM-LsQI8x?id=jRmYUNF6z","501","501", R.drawable.a4a));

     Gamelist.add(new Games(" Rabbit Punch",    "https://www.gamezop.com/g/HkxQnLtmJe?id=jRmYUNF6z", "502","502", R.drawable.a5a));


     Gamelist.add(new Games("Monsteroid",    "https://www.gamezop.com/g/Skke0Kr-O4?id=jRmYUNF6z ", "503","503", R.drawable.a6a));

     Gamelist.add(new Games(" Shadow Run",    "https://www.gamezop.com/g/S1kGWUim8Ux?id=jRmYUNF6z ","504","504",  R.drawable.a7a));

     Gamelist.add(new Games("Troll Boxing ",    "https://www.gamezop.com/g/Hy2xAKHb_V?id=jRmYUNF6z ", "505","505",  R.drawable.a8a));

     Gamelist.add(new Games("Ooltaa ",    "https://www.gamezop.com/g/SJMB7qTb?id=jRmYUNF6z","506","506",  R.drawable.a9a));

     Gamelist.add(new Games(" Sheriff's Wrath",    "https://www.gamezop.com/g/BJlMwGUY_yl?id=jRmYUNF6z ","507","507",  R.drawable.t10));


     Gamelist.add(new Games(" Rapunzel Tower ",    "https://www.gamezop.com/g/SJVxAtrW_N?id=jRmYUNF6z", "508","508",  R.drawable.a12a));

     Gamelist.add(new Games(" Pie Attack",    "https://www.gamezop.com/g/NJ8gGuyMZ5e?id=jRmYUNF6z", "509","509",  R.drawable.a13a));



     Gamelist.add(new Games(" Crunching Ninjas",    "https://www.gamezop.com/g/EJnzu1fb9g?id=jRmYUNF6z ", "510","510",  R.drawable.a15a));


     Gamelist.add(new Games(" Dead End",    "https://www.gamezop.com/g/VJQzukG-qx?id=jRmYUNF6z ", "511","511", R.drawable.a16a));

     Gamelist.add(new Games("Rocket Man ",    "https://www.gamezop.com/g/SyXuN7W1F?id=jRmYUNF6z ", "512","512", R.drawable.a18a));

     Gamelist.add(new Games("Pirate Hunt ",    "https://www.gamezop.com/g/B1gBpzJwqJQ?id=jRmYUNF6z ", "513","513", R.drawable.a19a));

     Gamelist.add(new Games(" Valley of Terror",    "https://www.gamezop.com/g/B1jZWUoXUIe?id=jRmYUNF6z ","514","514", R.drawable.t20));

     Gamelist.add(new Games("Aliens Attack ",    "https://www.gamezop.com/g/N1tgz_kzW5x?id=jRmYUNF6z ","515","515", R.drawable.a21a));

     Gamelist.add(new Games(" Gerbil Jump",    "https://www.gamezop.com/g/BJzGTMJv91Q?id=jRmYUNF6z","516","516",  R.drawable.a22a));

     Gamelist.add(new Games(" Animals Air Fight",    "https://www.gamezop.com/g/Hy0ZqIO_fA?id=jRmYUNF6z ", "517","517", R.drawable.a23a));

//Atm gamw
     Gamelist.add(new Games("Air Hockeyir ",  "https://games.atmegame.com/gamesworld/games/air-hockey/?utm_source=Gamesworld&utm_medium=Gamesworld", "1","1",R.drawable.a1));
     Gamelist.add(new Games("Air Warfare ",     "https://games.atmegame.com/gamesworld/games/air-warfare/?utm_source=Gamesworld&utm_medium=Gamesworld", "2","2",R.drawable.a2));


     Gamelist.add(new Games("Assassin Knight ",     "https://games.atmegame.com/gamesworld/games/assassin-knight/?utm_source=Gamesworld&utm_medium=Gamesworld","3","3", R.drawable.a6));
     Gamelist.add(new Games("Mad Shark ",  "https://games.atmegame.com/gamesworld/games/mad-shark/?utm_source=Gamesworld&utm_medium=Gamesworld", "4","4",R.drawable.a53));

     Gamelist.add(new Games("Cyber Slashman ",   "https://games.atmegame.com/gamesworld/games/cyber-slashman/?utm_source=Gamesworld&utm_medium=Gamesworld  ", "5","5",R.drawable.a21));

     Gamelist.add(new Games("Cyber Soldier ",     "https://games.atmegame.com/gamesworld/games/cyber-soldier/?utm_source=Gamesworld&utm_medium=Gamesworld", "6","6",R.drawable.a22));

     Gamelist.add(new Games("Defence Champion ",     "https://games.atmegame.com/gamesworld/games/defence-champion/?utm_source=Gamesworld&utm_medium=Gamesworld","7","7", R.drawable.a26));
     Gamelist.add(new Games("Shoot Robbers ",  " https://games.atmegame.com/gamesworld/games/shoot-robbers/?utm_source=Gamesworld&utm_medium=Gamesworld","8","8", R.drawable.a70));

     Gamelist.add(new Games("Fishing Frenzy ",  "https://games.atmegame.com/gamesworld/games/fishing-frenzy/?utm_source=Gamesworld&utm_medium=Gamesworld", "9","9",R.drawable.a31));

     Gamelist.add(new Games(" Great-Air Battles",     "https://games.atmegame.com/gamesworld/games/great-air-battles/?utm_source=Gamesworld&utm_medium=Gamesworld","10","10", R.drawable.a42));

     Gamelist.add(new Games("Tank Defender ",     "https://games.atmegame.com/gamesworld/games/tank-defender/?utm_source=Gamesworld&utm_medium=Gamesworld","11","11", R.drawable.a82));
     Gamelist.add(new Games("Tank Wars ",  "https://games.atmegame.com/gamesworld/games/tank-wars/?utm_source=Gamesworld&utm_medium=Gamesworld", "12","12",R.drawable.a83));

     Gamelist.add(new Games("Duck Shooter ",     "https://games.atmegame.com/gamesworld/games/duck-shooter/?utm_source=Gamesworld&utm_medium=Gamesworld","13","13", R.drawable.a28));

     Gamelist.add(new Games("Duosometric Jump ",  "https://games.atmegame.com/gamesworld/games/duosometric-jump/?utm_source=Gamesworld&utm_medium=Gamesworld","14","14", R.drawable.a29));

     Gamelist.add(new Games("Duck Hunter ",  "https://games.atmegame.com/gamesworld/games/duck-hunter/?utm_source=Gamesworld&utm_medium=Gamesworld","15","15", R.drawable.a27));


     Gamelist.add(new Games("Alien-Hunter 2 ",  "https://games.atmegame.com/gamesworld/games/alien-hunter-2/?utm_source=Gamesworld&utm_medium=Gamesworld","16","16", R.drawable.a3));

     Gamelist.add(new Games(" Strike Expert",  "https://games.atmegame.com/gamesworld/games/strike-expert/?utm_source=Gamesworld&utm_medium=Gamesworld", "17","17",R.drawable.a78));
     Gamelist.add(new Games("Gold Miner ",  "https://games.atmegame.com/gamesworld/games/gold-miner/?utm_source=Gamesworld&utm_medium=Gamesworld","18","18", R.drawable.a40));
     Gamelist.add(new Games("Fire Soldier ",     "https://games.atmegame.com/gamesworld/games/fire-soldier/?utm_source=Gamesworld&utm_medium=Gamesworld", "19","19",R.drawable.a30));


     recyclerView = (RecyclerView) findViewById(R.id.recyclerview_action);
        GameitemAdapter adapter = new GameitemAdapter(Gamelist,this,this);
        recyclerView.setAdapter(adapter);
        GridLayoutManager manager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
     recyclerView.setHasFixedSize(true);

        }


 private void inflateAd(NativeBannerAd nativeBannerAd) {
  // Unregister last ad
  nativeBannerAd.unregisterView();

  // Add the Ad view into the ad container.
  nativeAdLayout = findViewById(R.id.native_banner_ad_container);
  LayoutInflater inflater = LayoutInflater.from(Action.this);
  // Inflate the Ad view.  The layout referenced is the one you created in the last step.
  adView = (LinearLayout) inflater.inflate(R.layout.native_banner_ad_unit, nativeAdLayout, false);
  nativeAdLayout.addView(adView);

  // Add the AdChoices icon
  RelativeLayout adChoicesContainer = adView.findViewById(R.id.ad_choices_container);
  AdOptionsView adOptionsView = new AdOptionsView(Action.this, nativeBannerAd, nativeAdLayout);
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

 @Override
 public void onGamegClick(Games Gamelist) {
  Intent intent = new Intent(Action.this, MWebActivity.class);
  intent.putExtra("url", Gamelist.getUrl());
  Action.this.startActivity(intent);
 }
}