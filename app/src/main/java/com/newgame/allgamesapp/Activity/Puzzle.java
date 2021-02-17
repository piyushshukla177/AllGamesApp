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
public class Puzzle extends AppCompatActivity implements GameitemAdapter.GameClickListener{
 private static final String TAG = Puzzle.class.getSimpleName();

 private NativeAdLayout nativeAdLayout;
 private LinearLayout adView;
 private NativeBannerAd nativeBannerAd;
 InterstitialAd interstitialAd;
    RecyclerView recyclerView;
    ArrayList Gamelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle_a);


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
       Puzzle.this.onBackPressed();
      }
     });

     findViewById(R.id.favaa).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
       Intent intent = new Intent(Puzzle.this, SearchActivity.class);
       intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
       Puzzle.this.startActivity(intent);
      }
     });



     setTitle("         Puzzle Games");


        Gamelist = new ArrayList();


     Gamelist.add(new Games("Angry-Cat Shot ",     "https://games.atmegame.com/gamesworld/games/angry-cat-shot/?utm_source=Gamesworld&utm_medium=Gamesworld", "32","32",R.drawable.a4));
     Gamelist.add(new Games("Animals-Crush Match3	",  "https://games.atmegame.com/gamesworld/games/animals-crush-match3/?utm_source=Gamesworld&utm_medium=Gamesworld", "33","33",R.drawable.a5));


     Gamelist.add(new Games("Block Pile ",     "https://games.atmegame.com/gamesworld/games/block-pile/?utm_source=Gamesworld&utm_medium=Gamesworld","34","34", R.drawable.a10));

     Gamelist.add(new Games("Block Snake ",  "https://games.atmegame.com/gamesworld/games/block-snake/?utm_source=Gamesworld&utm_medium=Gamesworld","35","35", R.drawable.a11));

     Gamelist.add(new Games(" Breakfast Time",     "https://games.atmegame.com/gamesworld/games/breakfast-time/?utm_source=Gamesworld&utm_medium=Gamesworld","36","36", R.drawable.a12));
     Gamelist.add(new Games("Brickout ",  "https://games.atmegame.com/gamesworld/games/brickout/?utm_source=Gamesworld&utm_medium=Gamesworld","37","37", R.drawable.a13));

     Gamelist.add(new Games("Bubblegum Balloon ",     "https://games.atmegame.com/gamesworld/games/bubblegum-balloon/?utm_source=Gamesworld&utm_medium=Gamesworld","38","38", R.drawable.a14));

     Gamelist.add(new Games("Burger Time ",  "https://games.atmegame.com/gamesworld/games/burger-time/?utm_source=Gamesworld&utm_medium=Gamesworld","39","39", R.drawable.a15));







     Gamelist.add(new Games(" Frog-Super Bubbles",  "https://games.atmegame.com/gamesworld/games/frog-super-bubbles/?utm_source=Gamesworld&utm_medium=Gamesworld", "40","40",R.drawable.a34));



     Gamelist.add(new Games("Funny-Animals Match3	 ",     "https://games.atmegame.com/gamesworld/games/funny-animals-match3/?utm_source=Gamesworld&utm_medium=Gamesworld", "41","41",R.drawable.a37));


     Gamelist.add(new Games(" Girl-Dress Up	",  "https://games.atmegame.com/gamesworld/games/girl-dress-up/?utm_source=Gamesworld&utm_medium=Gamesworld","42","42", R.drawable.a38));

     Gamelist.add(new Games("Going Nuts ",  "https://games.atmegame.com/gamesworld/games/going-nuts/?utm_source=Gamesworld&utm_medium=Gamesworld","43","43", R.drawable.a39));



     Gamelist.add(new Games("Halloween-Bubble Shooter ",  "https://games.atmegame.com/gamesworld/games/halloween-bubble-shooter/?utm_source=Gamesworld&utm_medium=Gamesworld", "44","44",R.drawable.a43));

     Gamelist.add(new Games("Handless Millionaire ",     "https://games.atmegame.com/gamesworld/games/handless-millionaire/?utm_source=Gamesworld&utm_medium=Gamesworld", "45","45",R.drawable.a44));

     Gamelist.add(new Games("Happy Halloween",  "https://games.atmegame.com/gamesworld/games/happy-halloween/?utm_source=Gamesworld&utm_medium=Gamesworld", "46","46",R.drawable.a45));

     Gamelist.add(new Games("Hexa Puzzle ",     "https://games.atmegame.com/gamesworld/games/hexa-puzzle/?utm_source=Gamesworld&utm_medium=Gamesworld", "47","47",R.drawable.a46));




     Gamelist.add(new Games("Monster Rush ",     "https://games.atmegame.com/gamesworld/games/monster-rush/?utm_source=Gamesworld&utm_medium=Gamesworld", "48","48",R.drawable.a54));


     Gamelist.add(new Games(" Mummy Candies",     "https://games.atmegame.com/gamesworld/games/mummy-candies/?utm_source=Gamesworld&utm_medium=Gamesworld", "49","49",R.drawable.a56));



     Gamelist.add(new Games(" Popstar-Dress Up",  "https://games.atmegame.com/gamesworld/games/popstar-dress-up/?utm_source=Gamesworld&utm_medium=Gamesworld", "50","50",R.drawable.a64));



     Gamelist.add(new Games(" Rocky Jetpack	",  "https://games.atmegame.com/gamesworld/games/rocky-jetpack/?utm_source=Gamesworld&utm_medium=Gamesworld", "51","51",R.drawable.a67));


// gamezp

     Gamelist.add(new Games("2048 ",   "https://www.gamezop.com/g/NyM_JGWcx?id=jRmYUNF6z","559  ","559  ", R.drawable.p37));

     Gamelist.add(new Games("Jelly Slice ",  "https://www.gamezop.com/g/SJ3-ELT8p-x?id=jRmYUNF6z","560  ","560  ", R.drawable.p38));

     Gamelist.add(new Games(" Cyberfusion",   "https://www.gamezop.com/g/SJ3-ELT8p-x?id=jRmYUNF6z","561  ","561  ", R.drawable.p7));
     Gamelist.add(new Games("Slit Sight ",  "https://www.gamezop.com/g/Bk25EzR7T?id=jRmYUNF6z","562  ","562  ", R.drawable.p29));


     Gamelist.add(new Games("Cowboy vs. Martians ",  "https://www.gamezop.com/g/SyTeia3fOeZ?id=jRmYUNF6z","563  ","563  ", R.drawable.p1));

     Gamelist.add(new Games("Memory Match Up ",  "https://www.gamezop.com/g/HkmMITNQ0l?id=jRmYUNF6z","564 ","564 ", R.drawable.p2));


     Gamelist.add(new Games("Happy Kittens Puzzle ",   "https://www.gamezop.com/g/BJsmaGJw91m?id=jRmYUNF6z","566 ","566 ", R.drawable.p4));

     Gamelist.add(new Games("Oh Yes",    "https://www.gamezop.com/g/SkyRBO1b?id=jRmYUNF6z","567","567",R.drawable.p5));


     Gamelist.add(new Games("Mirror Me ",   "https://www.gamezop.com/g/HJE-oa2z_l-?id=jRmYUNF6z","568","568",R.drawable.p6));



     Gamelist.add(new Games("Robotion ",    "https://www.gamezop.com/g/B1SlRFrWuN?id=jRmYUNF6z","569","569", R.drawable.p8));

     Gamelist.add(new Games(" Loco Motive",  "https://www.gamezop.com/g/HkxcskEs5?id=jRmYUNF6z","570","570",



             R.drawable.p9));

     Gamelist.add(new Games("Salazar ",   "https://www.gamezop.com/g/rJWX-kadu?id=jRmYUNF6z","571","571",R.drawable.p10));

     Gamelist.add(new Games(" Fancy Diver",  "https://www.gamezop.com/g/rkWemI2q?id=jRmYUNF6z","572","572",R.drawable.p11));

     Gamelist.add(new Games("Blackbeard's Island",   "https://www.gamezop.com/g/rk-Rtrb_V?id=jRmYUNF6z","573","573", R.drawable.p12));

     Gamelist.add(new Games(" Veggi Rabbit",    "https://www.gamezop.com/g/BkpeAKrW_E?id=jRmYUNF6z","574","574", R.drawable.p13));

     Gamelist.add(new Games("Tower Loot ",    "https://www.gamezop.com/g/B1MXhUFQke?id=jRmYUNF6z","575","575",  R.drawable.p14));

     Gamelist.add(new Games("Swipe Art Puzzle",     "https://www.gamezop.com/g/rJsl0KSbuN?id=jRmYUNF6z","576","576",  R.drawable.p15));


     Gamelist.add(new Games("Laser Locked ",   "https://www.gamezop.com/g/Hk3bj6nMdgb?id=jRmYUNF6z","577","577", R.drawable.p16));

     Gamelist.add(new Games("Pixel Slime ",     "https://www.gamezop.com/g/Sk728YXJx?id=jRmYUNF6z","578","578",R.drawable.p17));

     Gamelist.add(new Games(" Attention Span",     "https://www.gamezop.com/g/HyBw2v2-F?id=jRmYUNF6z","579","579", R.drawable.p18));

     Gamelist.add(new Games("Alien Kindergarten ",   "https://www.gamezop.com/g/r1Xm38FQkl?id=jRmYUNF6z","580","580", R.drawable.p19));

     Gamelist.add(new Games("Box Crush ",    "https://www.gamezop.com/g/S1Wrpf1v5ym?id=jRmYUNF6z","581","581",R.drawable.p20));

     Gamelist.add(new Games("Pop Soap ",    "https://www.gamezop.com/g/SJX7TGkDq1X?id=jRmYUNF6z","582","582", R.drawable.p21));

     Gamelist.add(new Games("Jello Go Round ",    "https://www.gamezop.com/g/SkRZZUoXI8g?id=jRmYUNF6z","583","583", R.drawable.p22));

     Gamelist.add(new Games(" Rescue Juliet",    "https://www.gamezop.com/g/4ykgM_yzbcg?id=jRmYUNF6z","584","584",R.drawable.p23));

     Gamelist.add(new Games("1212 ",    "https://www.gamezop.com/g/41FZfdyG-5x?id=jRmYUNF6z","585","585",R.drawable.p24));

     Gamelist.add(new Games(" Quiz Champions",    "https://www.gamezop.com/g/Sy8y2aQ9CB?id=jRmYUNF6z","586","586", R.drawable.p25));


     Gamelist.add(new Games("Jelly Doods ",    "https://www.gamezop.com/g/rJsWV8aIa-l?id=jRmYUNF6z","587","587",R.drawable.p26));

     Gamelist.add(new Games(" Teleporting Kittens",    "https://www.gamezop.com/g/SyJfiahGdlW?id=jRmYUNF6z","588","588", R.drawable.p27));

     Gamelist.add(new Games(" Countdown Calculator",    "https://www.gamezop.com/g/By5syVo5?id=jRmYUNF6z","589","589",  R.drawable.p28));


     Gamelist.add(new Games("Oh No",     "https://www.gamezop.com/g/BkqTS_1b?id=jRmYUNF6z","590","590",  R.drawable.p30));


     Gamelist.add(new Games("Drop Me ",     "https://www.gamezop.com/g/SJghvtd2_?id=jRmYUNF6z","591","591",  R.drawable.p31));

     Gamelist.add(new Games("High or Low ",   "https://www.gamezop.com/g/H1eGU64XRg?id=jRmYUNF6z","592","592",  R.drawable.p32));

     Gamelist.add(new Games("Cubes Got Moves ",   "https://www.gamezop.com/g/S1JXaMJDqJX?id=jRmYUNF6z","593","593", R.drawable.p33));

     Gamelist.add(new Games("Sudoku Classic ",    "https://www.gamezop.com/g/SJgx126Qc0H?id=jRmYUNF6z","594","594",  R.drawable.p34));

     Gamelist.add(new Games(" Nut Physics",   "https://www.gamezop.com/g/BJdZ-8iXULl?id=jRmYUNF6z","595","595",  R.drawable.p35));


     Gamelist.add(new Games(" Aquatic Rescue",     "https://www.gamezop.com/g/r1xZj62MOe-?id=jRmYUNF6z","596","596",  R.drawable.p36));


     Gamelist.add(new Games("Juicy Dash",    "https://www.gamezop.com/g/H1lZem8hq?id=jRmYUNF6z","597","597", R.drawable.p39));



     recyclerView = (RecyclerView) findViewById(R.id.recyclerview_puzz);
     GameitemAdapter adapter = new GameitemAdapter(Gamelist,this,this);
     recyclerView.setAdapter(adapter);
     GridLayoutManager manager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
     recyclerView.setLayoutManager(manager);
     recyclerView.setHasFixedSize(true);

        }
 @Override
 public void onGamegClick(Games Gamelist) {
  Intent intent = new Intent(Puzzle.this, MWebActivity.class);
  intent.putExtra("url", Gamelist.getUrl());
  Puzzle.this.startActivity(intent);
 }

 private void inflateAd(NativeBannerAd nativeBannerAd) {
  // Unregister last ad
  nativeBannerAd.unregisterView();

  // Add the Ad view into the ad container.
  nativeAdLayout = findViewById(R.id.native_banner_ad_container);
  LayoutInflater inflater = LayoutInflater.from(Puzzle.this);
  // Inflate the Ad view.  The layout referenced is the one you created in the last step.
  adView = (LinearLayout) inflater.inflate(R.layout.native_banner_ad_unit, nativeAdLayout, false);
  nativeAdLayout.addView(adView);

  // Add the AdChoices icon
  RelativeLayout adChoicesContainer = adView.findViewById(R.id.ad_choices_container);
  AdOptionsView adOptionsView = new AdOptionsView(Puzzle.this, nativeBannerAd, nativeAdLayout);
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
