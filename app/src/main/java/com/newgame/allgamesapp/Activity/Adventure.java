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
public class Adventure extends AppCompatActivity implements GameitemAdapter.GameClickListener{
 private static final String TAG = Adventure.class.getSimpleName();

 private NativeAdLayout nativeAdLayout;
 private LinearLayout adView;
 private NativeBannerAd nativeBannerAd;
 InterstitialAd interstitialAd;
    RecyclerView recyclerView;
    ArrayList Gamelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adventure_a);


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
       Adventure.this.onBackPressed();
      }
     });

     findViewById(R.id.favaa).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
       Intent intent = new Intent(Adventure.this, SearchActivity.class);
       intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
       Adventure.this.startActivity(intent);
      }
     });


     setTitle("         Adventure Games");


        Gamelist = new ArrayList();

        //Gamezop
     Gamelist.add(new Games("Rollout ",    "https://www.gamezop.com/g/HkRMTzJDck7?id=jRmYUNF6z","518","518", R.drawable.v9));
     Gamelist.add(new Games("Rope Ninja ",    "https://www.gamezop.com/g/r10-NLT86bx?id=jRmYUNF6z ","519","519", R.drawable.v28));

     Gamelist.add(new Games("Escape Run",   "https://www.gamezop.com/g/Skz4pzkDqyX?id=jRmYUNF6z" ,"520","520", R.drawable.v29));
     Gamelist.add(new Games(" Sway Bay",    "https://www.gamezop.com/g/B1PMIp4XCe?id=jRmYUNF6z" ,"521","521", R.drawable.v27));
     Gamelist.add(new Games("Jimbo Jump ",   "https://www.gamezop.com/g/BkXW1a__?id=jRmYUNF6z" ,"522","522",R.drawable.v20));
     Gamelist.add(new Games("Sticky Goo ",    "https://www.gamezop.com/g/rJJMVIa8p-x?id=jRmYUNF6z", "523","523",R.drawable.v6));
     Gamelist.add(new Games("Knife Flip ",     "https://www.gamezop.com/g/H1PJn6mqAr?id=jRmYUNF6z" ,"524","524",R.drawable.v21));


     Gamelist.add(new Games("Knight Ride ",   "https://www.gamezop.com/g/rkYbNLTIT-x?id=jRmYUNF6z" ,"525","525", R.drawable.v30));




     Gamelist.add(new Games("Pigeon Bomber ",   "https://www.gamezop.com/g/B1bxAYHZO4?id=jRmYUNF6z" ,"526","526", R.drawable.v2));

     Gamelist.add(new Games("Battle Fish ",    "https://www.gamezop.com/g/ry3vtunu?id=jRmYUNF6z" ,"527","527", R.drawable.v3));

     Gamelist.add(new Games(" Marshmallow Dash",    "https://www.gamezop.com/g/S1gGrw64wY?id=jRmYUNF6z" ,"528","528", R.drawable.v4));

     Gamelist.add(new Games("Holiday Cheer",    "https://www.gamezop.com/g/B1SmafkP5kQ?id=jRmYUNF6z", "529","529", R.drawable.v5));
     Gamelist.add(new Games("Saucer Dodge ",    "https://www.gamezop.com/g/B1Gbjphf_gZ?id=jRmYUNF6z" ,"530","530",R.drawable.v1));


     Gamelist.add(new Games("Submarine Dash",   "https://www.gamezop.com/g/SJz7-kTud?id=jRmYUNF6z" ,"531","531", R.drawable.v7));

     Gamelist.add(new Games("Mouse Jump  ",     "https://www.gamezop.com/g/BkemftJ_I?id=jRmYUNF6z" ,"532","532", R.drawable.v8));



     Gamelist.add(new Games(" Colour Chase",    "https://www.gamezop.com/g/B1JBaM1D9y7?id=jRmYUNF6z" ,"533","533", R.drawable.v10));

     Gamelist.add(new Games("Cosmo Spin ",    "https://www.gamezop.com/g/rkUcEM076?id=jRmYUNF6z" ,"534","534", R.drawable.v11));

     Gamelist.add(new Games(" Space Cowboy",    "https://www.gamezop.com/g/HycgCtSWuE?id=jRmYUNF6z" ,"535","535", R.drawable.v12));

     Gamelist.add(new Games(" Sir Bottomtight",   "https://www.gamezop.com/g/rJDlAKHbdV?id=jRmYUNF6z" ,"536","536", R.drawable.v13));



     Gamelist.add(new Games(" Monster Wants Candy",    "https://www.gamezop.com/g/rkXGK1_L?id=jRmYUNF6z" ,"537","537", R.drawable.v14));

     Gamelist.add(new Games("Snappy Spy ",    "https://www.gamezop.com/g/SysZvGUt_ye?id=jRmYUNF6z" ,"538","538", R.drawable.v15));


     Gamelist.add(new Games(" Pirate Kid",    "https://www.gamezop.com/g/SyMlRtBbON?id=jRmYUNF6z","539","539", R.drawable.v16));

     Gamelist.add(new Games("Aqua Thief ",     "https://www.gamezop.com/g/BJ9ZE86I6Wg?id=jRmYUNF6z" ,"540","540",R.drawable.v17));

     Gamelist.add(new Games(" Catch-a-pult",    "https://www.gamezop.com/g/SkRWoanGOx?id=jRmYUNF6z" ,"541","541",R.drawable.v18));

     Gamelist.add(new Games("One More Flight ",    "https://www.gamezop.com/g/BJ-ZsT2zOeZ?id=jRmYUNF6z" ,"542","542", R.drawable.v19));
     Gamelist.add(new Games("Twin Hop ",     "https://www.gamezop.com/g/BJrMI6E7Rl?id=jRmYUNF6z" ,"543","543",R.drawable.v40));

     Gamelist.add(new Games(" Alfy",     "https://www.gamezop.com/g/BJAqNMC7T?id=jRmYUNF6z" ,"544","544",R.drawable.v41));

     Gamelist.add(new Games("Nosedive ",    "https://www.gamezop.com/g/SJXVafJP51Q?id=jRmYUNF6z" ,"545","545", R.drawable.v22));

     Gamelist.add(new Games("Jumpy: The First Jumper ",    "https://www.gamezop.com/g/HkO-wf8F_Jx?id=jRmYUNF6z" ,"546","546", R.drawable.v23));

     Gamelist.add(new Games("Dodge Bot ",    "https://www.gamezop.com/g/SJ2OGpIn?id=jRmYUNF6z" ,"547","547", R.drawable.v24));

     Gamelist.add(new Games(" Penguin Skip",    "https://www.gamezop.com/g/HJee0YHZ_E?id=jRmYUNF6z" ,"548","548", R.drawable.v25));


     Gamelist.add(new Games("Sneaky Snack ",    "https://www.gamezop.com/g/41DxMOkGZ5g?id=jRmYUNF6z" ,"549","549", R.drawable.v26));



     Gamelist.add(new Games(" Odd One Out",     "https://www.gamezop.com/g/Bk4ML6470x?id=jRmYUNF6z" ,"550","550", R.drawable.v31));
     Gamelist.add(new Games("The Sea Lion Act ",    "https://www.gamezop.com/g/SyQZs6nzueW?id=jRmYUNF6z" ,"551","551", R.drawable.v32));

     Gamelist.add(new Games("Go Chicken Go ",    "https://www.gamezop.com/g/rJ57aMJDcJm?id=jRmYUNF6z" ,"552","552",R.drawable.v33));


     Gamelist.add(new Games(" Snakes & Ladders",    "https://www.gamezop.com/g/rJWyhp79RS?id=jRmYUNF6z" ,"553","553", R.drawable.v34));

     Gamelist.add(new Games(" Jumpy Ape Joe",     "https://www.gamezop.com/g/rJWyhp79RS?id=jRmYUNF6z" ,"554","554", R.drawable.v35));


     Gamelist.add(new Games("Panda Love ",    "https://www.gamezop.com/g/HyarrY8S?id=jRmYUNF6z" ,"555","555",R.drawable.v36));

     Gamelist.add(new Games(" Terra Infirma",    "https://www.gamezop.com/g/HkBWwMUFOye?id=jRmYUNF6z" ,"556","556", R.drawable.v37));


     Gamelist.add(new Games(" Flying School",      "https://www.gamezop.com/g/VJOGOyGb9l?id=jRmYUNF6z" ,"557","557", R.drawable.v38));


     Gamelist.add(new Games(" Astro Knot",    "https://www.gamezop.com/g/HJD9VMRQa?id=jRmYUNF6z" ,"558","558", R.drawable.v39));



///atm


     Gamelist.add(new Games(" Gold-Miner Jack",  "https://games.atmegame.com/gamesworld/games/gold-miner-jack/?utm_source=Gamesworld&utm_medium=Gamesworld", "78","78",R.drawable.a41));
     Gamelist.add(new Games("Fruitslasher",  "https://games.atmegame.com/gamesworld/games/fruitslasher/?utm_source=Gamesworld&utm_medium=Gamesworld", "96","96",R.drawable.a36));

     Gamelist.add(new Games("Fruit Snake ",     "https://games.atmegame.com/gamesworld/games/fruit-snake/?utm_source=Gamesworld&utm_medium=Gamesworld","79","79", R.drawable.a35));

     Gamelist.add(new Games("Dead-Land-Adventure 2 ",  "https://games.atmegame.com/gamesworld/games/dead-land-adventure-2/?utm_source=Gamesworld&utm_medium=Gamesworld","80","80", R.drawable.a25));

     Gamelist.add(new Games("Defence Champion ",     "https://games.atmegame.com/gamesworld/games/defence-champion/?utm_source=Gamesworld&utm_medium=Gamesworld", "81","81",R.drawable.a26));

     Gamelist.add(new Games("Joee Adventure ",  "https://games.atmegame.com/gamesworld/games/joee-adventure/?utm_source=Gamesworld&utm_medium=Gamesworld","82","82", R.drawable.a47));

     Gamelist.add(new Games("Jump Jump ",  "https://games.atmegame.com/gamesworld/games/jump-jump/?utm_source=Gamesworld&utm_medium=Gamesworld", "83","83",R.drawable.a48));
     Gamelist.add(new Games("Playful Kitty ",  "https://games.atmegame.com/gamesworld/games/playful-kitty/?utm_source=Gamesworld&utm_medium=Gamesworld","84","84", R.drawable.a60));

     Gamelist.add(new Games(" Plumber",     "https://games.atmegame.com/gamesworld/games/plumber/?utm_source=Gamesworld&utm_medium=Gamesworld","85","85", R.drawable.a61));

     Gamelist.add(new Games("Piggybank Adventure ",     "https://games.atmegame.com/gamesworld/games/piggybank-adventure/?utm_source=Gamesworld&utm_medium=Gamesworld","86","86", R.drawable.a59));

     Gamelist.add(new Games("Flappy Pig",     "https://games.atmegame.com/gamesworld/games/flappy-pig/?utm_source=Gamesworld&utm_medium=Gamesworld","87","87", R.drawable.a32));

     Gamelist.add(new Games("Ninja Run ",  "https://games.atmegame.com/gamesworld/games/ninja-run/?utm_source=Gamesworld&utm_medium=Gamesworld","88","88", R.drawable.a57));

     Gamelist.add(new Games("Floor-Jumper Escape ",     "https://games.atmegame.com/gamesworld/games/floor-jumper-escape/?utm_source=Gamesworld&utm_medium=Gamesworld","89","89", R.drawable.a33));
     Gamelist.add(new Games("Stack Jump ",     "https://games.atmegame.com/gamesworld/games/stack-jump/?utm_source=Gamesworld&utm_medium=Gamesworld","90","90", R.drawable.a74));

     Gamelist.add(new Games("Stick Monkey ",  "https://games.atmegame.com/gamesworld/games/stick-monkey/?utm_source=Gamesworld&utm_medium=Gamesworld","91","91", R.drawable.a75));
     Gamelist.add(new Games("Dashers ",     "https://games.atmegame.com/gamesworld/games/dashers/?utm_source=Gamesworld&utm_medium=Gamesworld","92","92", R.drawable.a24));



     Gamelist.add(new Games(" Stick Panda",     "https://games.atmegame.com/gamesworld/games/stick-panda/?utm_source=Gamesworld&utm_medium=Gamesworld", "93","93",R.drawable.a76));
     Gamelist.add(new Games(" Zoo Run",  "https://games.atmegame.com/gamesworld/games/zoo-run/?utm_source=Gamesworld&utm_medium=Gamesworld","94","94", R.drawable.a94));




     recyclerView = (RecyclerView) findViewById(R.id.recyclerview_Adventure);
     GameitemAdapter adapter = new GameitemAdapter(Gamelist,this,this);
     recyclerView.setAdapter(adapter);
     GridLayoutManager manager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
     recyclerView.setLayoutManager(manager);
     recyclerView.setHasFixedSize(true);

        }
 @Override
 public void onGamegClick(Games Gamelist) {
  Intent intent = new Intent(Adventure.this, MWebActivity.class);
  intent.putExtra("url", Gamelist.getUrl());
  Adventure.this.startActivity(intent);
 }
 private void inflateAd(NativeBannerAd nativeBannerAd) {
  // Unregister last ad
  nativeBannerAd.unregisterView();

  // Add the Ad view into the ad container.
  nativeAdLayout = findViewById(R.id.native_banner_ad_container);
  LayoutInflater inflater = LayoutInflater.from(Adventure.this);
  // Inflate the Ad view.  The layout referenced is the one you created in the last step.
  adView = (LinearLayout) inflater.inflate(R.layout.native_banner_ad_unit, nativeAdLayout, false);
  nativeAdLayout.addView(adView);

  // Add the AdChoices icon
  RelativeLayout adChoicesContainer = adView.findViewById(R.id.ad_choices_container);
  AdOptionsView adOptionsView = new AdOptionsView(Adventure.this, nativeBannerAd, nativeAdLayout);
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