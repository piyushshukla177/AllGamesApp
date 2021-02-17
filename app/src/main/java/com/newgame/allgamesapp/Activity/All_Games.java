package com.newgame.allgamesapp.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.AsyncTask;
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
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.newgame.allgamesapp.Adapter.GameitemAdapter;
import com.newgame.allgamesapp.R;
import com.newgame.allgamesapp.model.Faverouite;
import com.newgame.allgamesapp.model.Games;
import com.newgame.allgamesapp.util.FaverouiteDatabase;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class All_Games extends AppCompatActivity implements GameitemAdapter.GameClickListener {
    private static final String TAG = All_Games.class.getSimpleName();

    public static All_Games gmm;
    private NativeAdLayout nativeAdLayout;
    private LinearLayout adView;
    private NativeBannerAd nativeBannerAd;
    InterstitialAd interstitialAd;
    RecyclerView recyclerView;
    ArrayList Gamelist;
    static FaverouiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__games);
        gmm=this;
        AudienceNetworkAds.initialize(this);
        nativeBannerAd = new NativeBannerAd(this, getString(R.string.fb_native_banner_ads));
        db = FaverouiteDatabase.getInstance(All_Games.this);
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
                All_Games.this.onBackPressed();
            }
        });

        findViewById(R.id.favaa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(All_Games.this, SearchActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                All_Games.this.startActivity(intent);
            }
        });
        setTitle("          All Games");
        Gamelist = new ArrayList();
     ///Gamezop
        Gamelist.add(new Games("Ludo With Friends ", "https://www.gamezop.com/g/SkhljT2fdgb?id=jRmYUNF6z", "623", "623", R.drawable.t8));

        Gamelist.add(new Games(" Bottle Shoot", "https://www.gamezop.com/g/B1fSpMkP51m?id=jRmYUNF6z", "492", "492", R.drawable.a24));

        Gamelist.add(new Games("Slap Fest ", "https://www.gamezop.com/g/ryN9EGAQa?id=jRmYUNF6z", "493", "493", R.drawable.a14a));
        Gamelist.add(new Games("Pumpkin Smasher ", "https://www.gamezop.com/g/rJXlRtBWd4?id=jRmYUNF6z  ", "494", "494", R.drawable.t3));

        Gamelist.add(new Games("Zombies Can't Jump 2", "https://www.gamezop.com/g/rkxMV8TI6Wg?id=jRmYUNF6z ", "495", "495", R.drawable.t4));

        Gamelist.add(new Games(" Savage Revenge", "https://www.gamezop.com/g/ry6bwfUt_Jg?id=jRmYUNF6z ", "496", "496", R.drawable.t5));

        Gamelist.add(new Games(" Plane Fight", " https://www.gamezop.com/g/H1IEpMJP917?id=jRmYUNF6z ", "497", "497", R.drawable.t19));

        Gamelist.add(new Games("Evil Wyrm ", "https://www.gamezop.com/g/ry8RYrWu4?id=jRmYUNF6z", "498", "498", R.drawable.a1a));

        Gamelist.add(new Games("Defense of Karmax 3 ", "https://www.gamezop.com/g/r1zCFBZdV?id=jRmYUNF6z  ", "499", "499", R.drawable.a2a));

        Gamelist.add(new Games("Pixel Zombies ", "https://www.gamezop.com/g/S14VrK8B?id=jRmYUNF6z ", "500", "500", R.drawable.a3a));

        Gamelist.add(new Games("Cuby Zap ", "https://www.gamezop.com/g/HJeM-LsQI8x?id=jRmYUNF6z", "501", "501", R.drawable.a4a));

        Gamelist.add(new Games(" Rabbit Punch", "https://www.gamezop.com/g/HkxQnLtmJe?id=jRmYUNF6z", "502", "502", R.drawable.a5a));


        Gamelist.add(new Games("Monsteroid", "https://www.gamezop.com/g/Skke0Kr-O4?id=jRmYUNF6z ", "503", "503", R.drawable.a6a));

        Gamelist.add(new Games(" Shadow Run", "https://www.gamezop.com/g/S1kGWUim8Ux?id=jRmYUNF6z ", "504", "504", R.drawable.a7a));

        Gamelist.add(new Games("Troll Boxing ", "https://www.gamezop.com/g/Hy2xAKHb_V?id=jRmYUNF6z ", "505", "505", R.drawable.a8a));

        Gamelist.add(new Games("Ooltaa ", "https://www.gamezop.com/g/SJMB7qTb?id=jRmYUNF6z", "506", "506", R.drawable.a9a));

        Gamelist.add(new Games(" Sheriff's Wrath", "https://www.gamezop.com/g/BJlMwGUY_yl?id=jRmYUNF6z ", "507", "507", R.drawable.t10));


        Gamelist.add(new Games(" Rapunzel Tower ", "https://www.gamezop.com/g/SJVxAtrW_N?id=jRmYUNF6z", "508", "508", R.drawable.a12a));

        Gamelist.add(new Games(" Pie Attack", "https://www.gamezop.com/g/NJ8gGuyMZ5e?id=jRmYUNF6z", "509", "509", R.drawable.a13a));


        Gamelist.add(new Games(" Crunching Ninjas", "https://www.gamezop.com/g/EJnzu1fb9g?id=jRmYUNF6z ", "510", "510", R.drawable.a15a));


        Gamelist.add(new Games(" Dead End", "https://www.gamezop.com/g/VJQzukG-qx?id=jRmYUNF6z ", "511", "511", R.drawable.a16a));

        Gamelist.add(new Games("Rocket Man ", "https://www.gamezop.com/g/SyXuN7W1F?id=jRmYUNF6z ", "512", "512", R.drawable.a18a));

        Gamelist.add(new Games("Pirate Hunt ", "https://www.gamezop.com/g/B1gBpzJwqJQ?id=jRmYUNF6z ", "513", "513", R.drawable.a19a));

        Gamelist.add(new Games(" Valley of Terror", "https://www.gamezop.com/g/B1jZWUoXUIe?id=jRmYUNF6z ", "514", "514", R.drawable.t20));

        Gamelist.add(new Games("Aliens Attack ", "https://www.gamezop.com/g/N1tgz_kzW5x?id=jRmYUNF6z ", "515", "515", R.drawable.a21a));

        Gamelist.add(new Games(" Gerbil Jump", "https://www.gamezop.com/g/BJzGTMJv91Q?id=jRmYUNF6z", "516", "516", R.drawable.a22a));

        Gamelist.add(new Games(" Animals Air Fight", "https://www.gamezop.com/g/Hy0ZqIO_fA?id=jRmYUNF6z ", "517", "517", R.drawable.a23a));

//Atm gamw
        Gamelist.add(new Games("Air Hockeyir ", "https://games.atmegame.com/gamesworld/games/air-hockey/?utm_source=Gamesworld&utm_medium=Gamesworld", "1", "1", R.drawable.a1));
        Gamelist.add(new Games("Air Warfare ", "https://games.atmegame.com/gamesworld/games/air-warfare/?utm_source=Gamesworld&utm_medium=Gamesworld", "2", "2", R.drawable.a2));


        Gamelist.add(new Games("Assassin Knight ", "https://games.atmegame.com/gamesworld/games/assassin-knight/?utm_source=Gamesworld&utm_medium=Gamesworld", "3", "3", R.drawable.a6));
        Gamelist.add(new Games("Mad Shark ", "https://games.atmegame.com/gamesworld/games/mad-shark/?utm_source=Gamesworld&utm_medium=Gamesworld", "4", "4", R.drawable.a53));

        Gamelist.add(new Games("Cyber Slashman ", "https://games.atmegame.com/gamesworld/games/cyber-slashman/?utm_source=Gamesworld&utm_medium=Gamesworld  ", "5", "5", R.drawable.a21));

        Gamelist.add(new Games("Cyber Soldier ", "https://games.atmegame.com/gamesworld/games/cyber-soldier/?utm_source=Gamesworld&utm_medium=Gamesworld", "6", "6", R.drawable.a22));

        Gamelist.add(new Games("Defence Champion ", "https://games.atmegame.com/gamesworld/games/defence-champion/?utm_source=Gamesworld&utm_medium=Gamesworld", "7", "7", R.drawable.a26));
        Gamelist.add(new Games("Shoot Robbers ", " https://games.atmegame.com/gamesworld/games/shoot-robbers/?utm_source=Gamesworld&utm_medium=Gamesworld", "8", "8", R.drawable.a70));

        Gamelist.add(new Games("Fishing Frenzy ", "https://games.atmegame.com/gamesworld/games/fishing-frenzy/?utm_source=Gamesworld&utm_medium=Gamesworld", "9", "9", R.drawable.a31));

        Gamelist.add(new Games(" Great-Air Battles", "https://games.atmegame.com/gamesworld/games/great-air-battles/?utm_source=Gamesworld&utm_medium=Gamesworld", "10", "10", R.drawable.a42));

        Gamelist.add(new Games("Tank Defender ", "https://games.atmegame.com/gamesworld/games/tank-defender/?utm_source=Gamesworld&utm_medium=Gamesworld", "11", "11", R.drawable.a82));
        Gamelist.add(new Games("Tank Wars ", "https://games.atmegame.com/gamesworld/games/tank-wars/?utm_source=Gamesworld&utm_medium=Gamesworld", "12", "12", R.drawable.a83));

        Gamelist.add(new Games("Duck Shooter ", "https://games.atmegame.com/gamesworld/games/duck-shooter/?utm_source=Gamesworld&utm_medium=Gamesworld", "13", "13", R.drawable.a28));

        Gamelist.add(new Games("Duosometric Jump ", "https://games.atmegame.com/gamesworld/games/duosometric-jump/?utm_source=Gamesworld&utm_medium=Gamesworld", "14", "14", R.drawable.a29));

        Gamelist.add(new Games("Duck Hunter ", "https://games.atmegame.com/gamesworld/games/duck-hunter/?utm_source=Gamesworld&utm_medium=Gamesworld", "15", "15", R.drawable.a27));


        Gamelist.add(new Games("Alien-Hunter 2 ", "https://games.atmegame.com/gamesworld/games/alien-hunter-2/?utm_source=Gamesworld&utm_medium=Gamesworld", "16", "16", R.drawable.a3));

        Gamelist.add(new Games(" Strike Expert", "https://games.atmegame.com/gamesworld/games/strike-expert/?utm_source=Gamesworld&utm_medium=Gamesworld", "17", "17", R.drawable.a78));
        Gamelist.add(new Games("Gold Miner ", "https://games.atmegame.com/gamesworld/games/gold-miner/?utm_source=Gamesworld&utm_medium=Gamesworld", "18", "18", R.drawable.a40));
        Gamelist.add(new Games("Fire Soldier ", "https://games.atmegame.com/gamesworld/games/fire-soldier/?utm_source=Gamesworld&utm_medium=Gamesworld", "19", "19", R.drawable.a30));

        //aveb
        //Gamezop
        Gamelist.add(new Games("Rollout ", "https://www.gamezop.com/g/HkRMTzJDck7?id=jRmYUNF6z", "518", "518", R.drawable.v9));
        Gamelist.add(new Games("Rope Ninja ", "https://www.gamezop.com/g/r10-NLT86bx?id=jRmYUNF6z ", "519", "519", R.drawable.v28));

        Gamelist.add(new Games("Escape Run", "https://www.gamezop.com/g/Skz4pzkDqyX?id=jRmYUNF6z", "520", "520", R.drawable.v29));
        Gamelist.add(new Games(" Sway Bay", "https://www.gamezop.com/g/B1PMIp4XCe?id=jRmYUNF6z", "521", "521", R.drawable.v27));
        Gamelist.add(new Games("Jimbo Jump ", "https://www.gamezop.com/g/BkXW1a__?id=jRmYUNF6z", "522", "522", R.drawable.v20));
        Gamelist.add(new Games("Sticky Goo ", "https://www.gamezop.com/g/rJJMVIa8p-x?id=jRmYUNF6z", "523", "523", R.drawable.v6));
        Gamelist.add(new Games("Knife Flip ", "https://www.gamezop.com/g/H1PJn6mqAr?id=jRmYUNF6z", "524", "524", R.drawable.v21));


        Gamelist.add(new Games("Knight Ride ", "https://www.gamezop.com/g/rkYbNLTIT-x?id=jRmYUNF6z", "525", "525", R.drawable.v30));


        Gamelist.add(new Games("Pigeon Bomber ", "https://www.gamezop.com/g/B1bxAYHZO4?id=jRmYUNF6z", "526", "526", R.drawable.v2));

        Gamelist.add(new Games("Battle Fish ", "https://www.gamezop.com/g/ry3vtunu?id=jRmYUNF6z", "527", "527", R.drawable.v3));

        Gamelist.add(new Games(" Marshmallow Dash", "https://www.gamezop.com/g/S1gGrw64wY?id=jRmYUNF6z", "528", "528", R.drawable.v4));

        Gamelist.add(new Games("Holiday Cheer", "https://www.gamezop.com/g/B1SmafkP5kQ?id=jRmYUNF6z", "529", "529", R.drawable.v5));
        Gamelist.add(new Games("Saucer Dodge ", "https://www.gamezop.com/g/B1Gbjphf_gZ?id=jRmYUNF6z", "530", "530", R.drawable.v1));


        Gamelist.add(new Games("Submarine Dash", "https://www.gamezop.com/g/SJz7-kTud?id=jRmYUNF6z", "531", "531", R.drawable.v7));

        Gamelist.add(new Games("Mouse Jump  ", "https://www.gamezop.com/g/BkemftJ_I?id=jRmYUNF6z", "532", "532", R.drawable.v8));


        Gamelist.add(new Games(" Colour Chase", "https://www.gamezop.com/g/B1JBaM1D9y7?id=jRmYUNF6z", "533", "533", R.drawable.v10));

        Gamelist.add(new Games("Cosmo Spin ", "https://www.gamezop.com/g/rkUcEM076?id=jRmYUNF6z", "534", "534", R.drawable.v11));

        Gamelist.add(new Games(" Space Cowboy", "https://www.gamezop.com/g/HycgCtSWuE?id=jRmYUNF6z", "535", "535", R.drawable.v12));

        Gamelist.add(new Games(" Sir Bottomtight", "https://www.gamezop.com/g/rJDlAKHbdV?id=jRmYUNF6z", "536", "536", R.drawable.v13));


        Gamelist.add(new Games(" Monster Wants Candy", "https://www.gamezop.com/g/rkXGK1_L?id=jRmYUNF6z", "537", "537", R.drawable.v14));

        Gamelist.add(new Games("Snappy Spy ", "https://www.gamezop.com/g/SysZvGUt_ye?id=jRmYUNF6z", "538", "538", R.drawable.v15));


        Gamelist.add(new Games(" Pirate Kid", "https://www.gamezop.com/g/SyMlRtBbON?id=jRmYUNF6z", "539", "539", R.drawable.v16));

        Gamelist.add(new Games("Aqua Thief ", "https://www.gamezop.com/g/BJ9ZE86I6Wg?id=jRmYUNF6z", "540", "540", R.drawable.v17));

        Gamelist.add(new Games(" Catch-a-pult", "https://www.gamezop.com/g/SkRWoanGOx?id=jRmYUNF6z", "541", "541", R.drawable.v18));

        Gamelist.add(new Games("One More Flight ", "https://www.gamezop.com/g/BJ-ZsT2zOeZ?id=jRmYUNF6z", "542", "542", R.drawable.v19));
        Gamelist.add(new Games("Twin Hop ", "https://www.gamezop.com/g/BJrMI6E7Rl?id=jRmYUNF6z", "543", "543", R.drawable.v40));

        Gamelist.add(new Games(" Alfy", "https://www.gamezop.com/g/BJAqNMC7T?id=jRmYUNF6z", "544", "544", R.drawable.v41));

        Gamelist.add(new Games("Nosedive ", "https://www.gamezop.com/g/SJXVafJP51Q?id=jRmYUNF6z", "545", "545", R.drawable.v22));

        Gamelist.add(new Games("Jumpy: The First Jumper ", "https://www.gamezop.com/g/HkO-wf8F_Jx?id=jRmYUNF6z", "546", "546", R.drawable.v23));

        Gamelist.add(new Games("Dodge Bot ", "https://www.gamezop.com/g/SJ2OGpIn?id=jRmYUNF6z", "547", "547", R.drawable.v24));

        Gamelist.add(new Games(" Penguin Skip", "https://www.gamezop.com/g/HJee0YHZ_E?id=jRmYUNF6z", "548", "548", R.drawable.v25));


        Gamelist.add(new Games("Sneaky Snack ", "https://www.gamezop.com/g/41DxMOkGZ5g?id=jRmYUNF6z", "549", "549", R.drawable.v26));


        Gamelist.add(new Games(" Odd One Out", "https://www.gamezop.com/g/Bk4ML6470x?id=jRmYUNF6z", "550", "550", R.drawable.v31));
        Gamelist.add(new Games("The Sea Lion Act ", "https://www.gamezop.com/g/SyQZs6nzueW?id=jRmYUNF6z", "551", "551", R.drawable.v32));

        Gamelist.add(new Games("Go Chicken Go ", "https://www.gamezop.com/g/rJ57aMJDcJm?id=jRmYUNF6z", "552", "552", R.drawable.v33));


        Gamelist.add(new Games(" Snakes & Ladders", "https://www.gamezop.com/g/rJWyhp79RS?id=jRmYUNF6z", "553", "553", R.drawable.v34));

        Gamelist.add(new Games(" Jumpy Ape Joe", "https://www.gamezop.com/g/rJWyhp79RS?id=jRmYUNF6z", "554", "554", R.drawable.v35));


        Gamelist.add(new Games("Panda Love ", "https://www.gamezop.com/g/HyarrY8S?id=jRmYUNF6z", "555", "555", R.drawable.v36));

        Gamelist.add(new Games(" Terra Infirma", "https://www.gamezop.com/g/HkBWwMUFOye?id=jRmYUNF6z", "556", "556", R.drawable.v37));


        Gamelist.add(new Games(" Flying School", "https://www.gamezop.com/g/VJOGOyGb9l?id=jRmYUNF6z", "557", "557", R.drawable.v38));


        Gamelist.add(new Games(" Astro Knot", "https://www.gamezop.com/g/HJD9VMRQa?id=jRmYUNF6z", "558", "558", R.drawable.v39));


///atm


        Gamelist.add(new Games(" Gold-Miner Jack", "https://games.atmegame.com/gamesworld/games/gold-miner-jack/?utm_source=Gamesworld&utm_medium=Gamesworld", "78", "78", R.drawable.a41));
        Gamelist.add(new Games("Fruitslasher", "https://games.atmegame.com/gamesworld/games/fruitslasher/?utm_source=Gamesworld&utm_medium=Gamesworld", "96", "96", R.drawable.a36));

        Gamelist.add(new Games("Fruit Snake ", "https://games.atmegame.com/gamesworld/games/fruit-snake/?utm_source=Gamesworld&utm_medium=Gamesworld", "79", "79", R.drawable.a35));

        Gamelist.add(new Games("Dead-Land-Adventure 2 ", "https://games.atmegame.com/gamesworld/games/dead-land-adventure-2/?utm_source=Gamesworld&utm_medium=Gamesworld", "80", "80", R.drawable.a25));

        Gamelist.add(new Games("Defence Champion ", "https://games.atmegame.com/gamesworld/games/defence-champion/?utm_source=Gamesworld&utm_medium=Gamesworld", "81", "81", R.drawable.a26));

        Gamelist.add(new Games("Joee Adventure ", "https://games.atmegame.com/gamesworld/games/joee-adventure/?utm_source=Gamesworld&utm_medium=Gamesworld", "82", "82", R.drawable.a47));

        Gamelist.add(new Games("Jump Jump ", "https://games.atmegame.com/gamesworld/games/jump-jump/?utm_source=Gamesworld&utm_medium=Gamesworld", "83", "83", R.drawable.a48));
        Gamelist.add(new Games("Playful Kitty ", "https://games.atmegame.com/gamesworld/games/playful-kitty/?utm_source=Gamesworld&utm_medium=Gamesworld", "84", "84", R.drawable.a60));

        Gamelist.add(new Games(" Plumber", "https://games.atmegame.com/gamesworld/games/plumber/?utm_source=Gamesworld&utm_medium=Gamesworld", "85", "85", R.drawable.a61));

        Gamelist.add(new Games("Piggybank Adventure ", "https://games.atmegame.com/gamesworld/games/piggybank-adventure/?utm_source=Gamesworld&utm_medium=Gamesworld", "86", "86", R.drawable.a59));

        Gamelist.add(new Games("Flappy Pig", "https://games.atmegame.com/gamesworld/games/flappy-pig/?utm_source=Gamesworld&utm_medium=Gamesworld", "87", "87", R.drawable.a32));

        Gamelist.add(new Games("Ninja Run ", "https://games.atmegame.com/gamesworld/games/ninja-run/?utm_source=Gamesworld&utm_medium=Gamesworld", "88", "88", R.drawable.a57));

        Gamelist.add(new Games("Floor-Jumper Escape ", "https://games.atmegame.com/gamesworld/games/floor-jumper-escape/?utm_source=Gamesworld&utm_medium=Gamesworld", "89", "89", R.drawable.a33));
        Gamelist.add(new Games("Stack Jump ", "https://games.atmegame.com/gamesworld/games/stack-jump/?utm_source=Gamesworld&utm_medium=Gamesworld", "90", "90", R.drawable.a74));

        Gamelist.add(new Games("Stick Monkey ", "https://games.atmegame.com/gamesworld/games/stick-monkey/?utm_source=Gamesworld&utm_medium=Gamesworld", "91", "91", R.drawable.a75));
        Gamelist.add(new Games("Dashers ", "https://games.atmegame.com/gamesworld/games/dashers/?utm_source=Gamesworld&utm_medium=Gamesworld", "92", "92", R.drawable.a24));


        Gamelist.add(new Games(" Stick Panda", "https://games.atmegame.com/gamesworld/games/stick-panda/?utm_source=Gamesworld&utm_medium=Gamesworld", "93", "93", R.drawable.a76));
        Gamelist.add(new Games(" Zoo Run", "https://games.atmegame.com/gamesworld/games/zoo-run/?utm_source=Gamesworld&utm_medium=Gamesworld", "94", "94", R.drawable.a94));

//arc
        Gamelist.add(new Games("Red Rush ", "https://www.gamezop.com/g/H16cNf0X6?id=jRmYUNF6z", "449", "449", R.drawable.r17));

        Gamelist.add(new Games("Tower Twist ", "https://www.gamezop.com/g/HJT46GkPcy7?id=jRmYUNF6z", "450", "450", R.drawable.r18));
        Gamelist.add(new Games(" Falling Through", "https://www.gamezop.com/g/ByGqEfCXa?id=jRmYUNF6z", "451", "451", R.drawable.r12));
        Gamelist.add(new Games(" Flexi Snake", "https://www.gamezop.com/g/SkQwnwnbK?id=jRmYUNF6z", "452  ", "452  ", R.drawable.r15));

        Gamelist.add(new Games("Bouncy ", "https://www.gamezop.com/g/H1Tz6z1Dqym?id=jRmYUNF6z", "453  ", "453  ", R.drawable.r25));

        Gamelist.add(new Games(" Vegetables vs. Chef", "https://www.gamezop.com/g/H1be5Ef0Qp?id=jRmYUNF6z", "454  ", "454  ", R.drawable.r2));

        Gamelist.add(new Games("Watch The Walls ", "https://www.gamezop.com/g/BJm9VfCmp?id=jRmYUNF6z", "455  ", "455  ", R.drawable.r3));

        Gamelist.add(new Games(" Stay On The Road", "https://www.gamezop.com/g/HJ-72IFXyg?id=jRmYUNF6z", "456 ", "456 ", R.drawable.r4));

        Gamelist.add(new Games(" Whirly Chick", "https://www.gamezop.com/g/rJWwrYIB?id=jRmYUNF6z", "457", "457", R.drawable.r5));


        Gamelist.add(new Games("Spikes Don't ", "https://www.gamezop.com/g/ry55EG0mp?id=jRmYUNF6z", "458", "458", R.drawable.r6));

        Gamelist.add(new Games(" Sheepop", "https://www.gamezop.com/g/NytfOJMW5e?id=jRmYUNF6z", "459", "459", R.drawable.r7));

        Gamelist.add(new Games("Fly Safe ", "https://www.gamezop.com/g/Hkww3v3-F?id=jRmYUNF6z", "460", "460", R.drawable.r8));

        Gamelist.add(new Games(" Car Flip", "https://www.gamezop.com/g/ByRkh6XcAB?id=jRmYUNF6z", "461", "461", R.drawable.r9));

        Gamelist.add(new Games("Cuby Dash ", "https://www.gamezop.com/g/Sy6b98udz0?id=jRmYUNF6z", "462", "462", R.drawable.r10));

        Gamelist.add(new Games(" Don't Eat Trash", "https://www.gamezop.com/g/r1HAtSWO4?id=jRmYUNF6z", "463", "463", R.drawable.r11));

        Gamelist.add(new Games(" Falling Through", "https://www.gamezop.com/g/ByGqEfCXa?id=jRmYUNF6z", "464", "464", R.drawable.r12));


        Gamelist.add(new Games("Super Sprint ", "https://www.gamezop.com/g/HyV_Nm-kK?id=jRmYUNF6z", "465", "465", R.drawable.r13));

        Gamelist.add(new Games("Where's Tom? ", "https://www.gamezop.com/g/HJ0eRFSWuV?id=jRmYUNF6z", "466", "466", R.drawable.r14));

        Gamelist.add(new Games(" Flexi Snake", "https://www.gamezop.com/g/SkQwnwnbK?id=jRmYUNF6z", "467", "467", R.drawable.r15));


        Gamelist.add(new Games("Zoo Pinball ", "https://www.gamezop.com/g/Ske-CtBbdV?id=jRmYUNF6z", "468", "468", R.drawable.r16));


        Gamelist.add(new Games("Drift Control ", "https://www.gamezop.com/g/BkxuV7ZkK?id=jRmYUNF6z", "469", "469", R.drawable.r19));

        Gamelist.add(new Games("Hoop Loop ", "https://www.gamezop.com/g/SJJl94z0m6?id=jRmYUNF6z", "470", "470", R.drawable.r20));

        Gamelist.add(new Games("Skill Shot ", "https://www.gamezop.com/g/ByvOVQZkK?id=jRmYUNF6z", "471", "471", R.drawable.r21));

        Gamelist.add(new Games(" Exoplanet Express", "https://www.gamezop.com/g/SyEQTzyw91X?id=jRmYUNF6z", "472", "472", R.drawable.r22));

        Gamelist.add(new Games(" Bouncing Beasts", "https://www.gamezop.com/g/4y6efOyf-5g?id=jRmYUNF6z", "473", "473", R.drawable.r23));

        Gamelist.add(new Games("Dodgy ", "https://www.gamezop.com/g/ryRWrDaNPF?id=jRmYUNF6z", "474", "474", R.drawable.r24));

        Gamelist.add(new Games("Bouncy ", "https://www.gamezop.com/g/H1Tz6z1Dqym?id=jRmYUNF6z", "475", "475", R.drawable.r25));


        Gamelist.add(new Games("Spinning Shooter ", "https://www.gamezop.com/g/B19EafJP9JX?id=jRmYUNF6z", "476", "476", R.drawable.r26));

        Gamelist.add(new Games("5 Jumps ", "https://www.gamezop.com/g/BJL_Vm-yF?id=jRmYUNF6z", "477", "477", R.drawable.r27));

        Gamelist.add(new Games("Rock the Dock ", "https://www.gamezop.com/g/EJoezu1MWqg?id=jRmYUNF6z", "478", "478", R.drawable.r28));

        Gamelist.add(new Games("Light Tower ", "https://www.gamezop.com/g/SJsqNMAmp?id=jRmYUNF6z", "479", "479", R.drawable.r29));

        Gamelist.add(new Games(" Sheep Stacking", "https://www.gamezop.com/g/V1IZG_1f-qg?id=jRmYUNF6z", "480", "480", R.drawable.r30));


        Gamelist.add(new Games("Tricky Trip ", "https://www.gamezop.com/g/NJ3xGOyfb5l?id=jRmYUNF6z", "482", "482", R.drawable.r31));

        Gamelist.add(new Games("Shade Shuffle ", "https://www.gamezop.com/g/SyFcNzAX6?id=jRmYUNF6z", "483", "483", R.drawable.r32));

        Gamelist.add(new Games(" Melon Pinch", "https://www.gamezop.com/g/E1szd1fW9e?id=jRmYUNF6z", "484", "484", R.drawable.r33));

        Gamelist.add(new Games("Grumpy Gorilla", "https://www.gamezop.com/g/N1sZfO1fWqg?id=jRmYUNF6z", "485", "485", R.drawable.r34));

        Gamelist.add(new Games("Quick Slip ", "https://www.gamezop.com/g/rklv3w2bt?id=jRmYUNF6z", "486", "486", R.drawable.r35));


        Gamelist.add(new Games(" Fidgety Frog", "https://www.gamezop.com/g/NkxfOJM-qg?id=jRmYUNF6z", "487", "487", R.drawable.r36));

        Gamelist.add(new Games(" Focus Locus", "https://www.gamezop.com/g/HkE7nLFQkx?id=jRmYUNF6z", "488", "488", R.drawable.r37));

        Gamelist.add(new Games("Jom Jom Jump ", "https://www.gamezop.com/g/SyjAFr-dE?id=jRmYUNF6z", "489", "489", R.drawable.r38));

        Gamelist.add(new Games(" Fizz Fuss", "https://www.gamezop.com/g/S1VZ-LjQUUl?id=jRmYUNF6z", "490", "490", R.drawable.r39));

        Gamelist.add(new Games("Rains of Fire ", "https://www.gamezop.com/g/NyVM_yG-qe?id=jRmYUNF6z", "491", "491", R.drawable.r40));


        //puzz


        Gamelist.add(new Games("Angry-Cat Shot ", "https://games.atmegame.com/gamesworld/games/angry-cat-shot/?utm_source=Gamesworld&utm_medium=Gamesworld", "32", "32", R.drawable.a4));
        Gamelist.add(new Games("Animals-Crush Match3	", "https://games.atmegame.com/gamesworld/games/animals-crush-match3/?utm_source=Gamesworld&utm_medium=Gamesworld", "33", "33", R.drawable.a5));


        Gamelist.add(new Games("Block Pile ", "https://games.atmegame.com/gamesworld/games/block-pile/?utm_source=Gamesworld&utm_medium=Gamesworld", "34", "34", R.drawable.a10));

        Gamelist.add(new Games("Block Snake ", "https://games.atmegame.com/gamesworld/games/block-snake/?utm_source=Gamesworld&utm_medium=Gamesworld", "35", "35", R.drawable.a11));

        Gamelist.add(new Games(" Breakfast Time", "https://games.atmegame.com/gamesworld/games/breakfast-time/?utm_source=Gamesworld&utm_medium=Gamesworld", "36", "36", R.drawable.a12));
        Gamelist.add(new Games("Brickout ", "https://games.atmegame.com/gamesworld/games/brickout/?utm_source=Gamesworld&utm_medium=Gamesworld", "37", "37", R.drawable.a13));

        Gamelist.add(new Games("Bubblegum Balloon ", "https://games.atmegame.com/gamesworld/games/bubblegum-balloon/?utm_source=Gamesworld&utm_medium=Gamesworld", "38", "38", R.drawable.a14));

        Gamelist.add(new Games("Burger Time ", "https://games.atmegame.com/gamesworld/games/burger-time/?utm_source=Gamesworld&utm_medium=Gamesworld", "39", "39", R.drawable.a15));
        Gamelist.add(new Games(" Frog-Super Bubbles", "https://games.atmegame.com/gamesworld/games/frog-super-bubbles/?utm_source=Gamesworld&utm_medium=Gamesworld", "40", "40", R.drawable.a34));


        Gamelist.add(new Games("Funny-Animals Match3	 ", "https://games.atmegame.com/gamesworld/games/funny-animals-match3/?utm_source=Gamesworld&utm_medium=Gamesworld", "41", "41", R.drawable.a37));


        Gamelist.add(new Games(" Girl-Dress Up	", "https://games.atmegame.com/gamesworld/games/girl-dress-up/?utm_source=Gamesworld&utm_medium=Gamesworld", "42", "42", R.drawable.a38));

        Gamelist.add(new Games("Going Nuts ", "https://games.atmegame.com/gamesworld/games/going-nuts/?utm_source=Gamesworld&utm_medium=Gamesworld", "43", "43", R.drawable.a39));


        Gamelist.add(new Games("Halloween-Bubble Shooter ", "https://games.atmegame.com/gamesworld/games/halloween-bubble-shooter/?utm_source=Gamesworld&utm_medium=Gamesworld", "44", "44", R.drawable.a43));

        Gamelist.add(new Games("Handless Millionaire ", "https://games.atmegame.com/gamesworld/games/handless-millionaire/?utm_source=Gamesworld&utm_medium=Gamesworld", "45", "45", R.drawable.a44));

        Gamelist.add(new Games("Happy Halloween", "https://games.atmegame.com/gamesworld/games/happy-halloween/?utm_source=Gamesworld&utm_medium=Gamesworld", "46", "46", R.drawable.a45));

        Gamelist.add(new Games("Hexa Puzzle ", "https://games.atmegame.com/gamesworld/games/hexa-puzzle/?utm_source=Gamesworld&utm_medium=Gamesworld", "47", "47", R.drawable.a46));


        Gamelist.add(new Games("Monster Rush ", "https://games.atmegame.com/gamesworld/games/monster-rush/?utm_source=Gamesworld&utm_medium=Gamesworld", "48", "48", R.drawable.a54));


        Gamelist.add(new Games(" Mummy Candies", "https://games.atmegame.com/gamesworld/games/mummy-candies/?utm_source=Gamesworld&utm_medium=Gamesworld", "49", "49", R.drawable.a56));


        Gamelist.add(new Games(" Popstar-Dress Up", "https://games.atmegame.com/gamesworld/games/popstar-dress-up/?utm_source=Gamesworld&utm_medium=Gamesworld", "50", "50", R.drawable.a64));


        Gamelist.add(new Games(" Rocky Jetpack	", "https://games.atmegame.com/gamesworld/games/rocky-jetpack/?utm_source=Gamesworld&utm_medium=Gamesworld", "51", "51", R.drawable.a67));


// gamezp

        Gamelist.add(new Games("2048 ", "https://www.gamezop.com/g/NyM_JGWcx?id=jRmYUNF6z", "559  ", "559  ", R.drawable.p37));

        Gamelist.add(new Games("Jelly Slice ", "https://www.gamezop.com/g/SJ3-ELT8p-x?id=jRmYUNF6z", "560  ", "560  ", R.drawable.p38));

        Gamelist.add(new Games(" Cyberfusion", "https://www.gamezop.com/g/SJ3-ELT8p-x?id=jRmYUNF6z", "561  ", "561  ", R.drawable.p7));
        Gamelist.add(new Games("Slit Sight ", "https://www.gamezop.com/g/Bk25EzR7T?id=jRmYUNF6z", "562  ", "562  ", R.drawable.p29));


        Gamelist.add(new Games("Cowboy vs. Martians ", "https://www.gamezop.com/g/SyTeia3fOeZ?id=jRmYUNF6z", "563  ", "563  ", R.drawable.p1));

        Gamelist.add(new Games("Memory Match Up ", "https://www.gamezop.com/g/HkmMITNQ0l?id=jRmYUNF6z", "564 ", "564 ", R.drawable.p2));


        Gamelist.add(new Games("Happy Kittens Puzzle ", "https://www.gamezop.com/g/BJsmaGJw91m?id=jRmYUNF6z", "566 ", "566 ", R.drawable.p4));

        Gamelist.add(new Games("Oh Yes", "https://www.gamezop.com/g/SkyRBO1b?id=jRmYUNF6z", "567", "567", R.drawable.p5));


        Gamelist.add(new Games("Mirror Me ", "https://www.gamezop.com/g/HJE-oa2z_l-?id=jRmYUNF6z", "568", "568", R.drawable.p6));


        Gamelist.add(new Games("Robotion ", "https://www.gamezop.com/g/B1SlRFrWuN?id=jRmYUNF6z", "569", "569", R.drawable.p8));

        Gamelist.add(new Games(" Loco Motive", "https://www.gamezop.com/g/HkxcskEs5?id=jRmYUNF6z", "570", "570", R.drawable.p9));

        Gamelist.add(new Games("Salazar ", "https://www.gamezop.com/g/rJWX-kadu?id=jRmYUNF6z", "571", "571", R.drawable.p10));

        Gamelist.add(new Games(" Fancy Diver", "https://www.gamezop.com/g/rkWemI2q?id=jRmYUNF6z", "572", "572", R.drawable.p11));

        Gamelist.add(new Games("Blackbeard's Island", "https://www.gamezop.com/g/rk-Rtrb_V?id=jRmYUNF6z", "573", "573", R.drawable.p12));

        Gamelist.add(new Games(" Veggi Rabbit", "https://www.gamezop.com/g/BkpeAKrW_E?id=jRmYUNF6z", "574", "574", R.drawable.p13));

        Gamelist.add(new Games("Tower Loot ", "https://www.gamezop.com/g/B1MXhUFQke?id=jRmYUNF6z", "575", "575", R.drawable.p14));

        Gamelist.add(new Games("Swipe Art Puzzle", "https://www.gamezop.com/g/rJsl0KSbuN?id=jRmYUNF6z", "576", "576", R.drawable.p15));


        Gamelist.add(new Games("Laser Locked ", "https://www.gamezop.com/g/Hk3bj6nMdgb?id=jRmYUNF6z", "577", "577", R.drawable.p16));

        Gamelist.add(new Games("Pixel Slime ", "https://www.gamezop.com/g/Sk728YXJx?id=jRmYUNF6z", "578", "578", R.drawable.p17));

        Gamelist.add(new Games(" Attention Span", "https://www.gamezop.com/g/HyBw2v2-F?id=jRmYUNF6z", "579", "579", R.drawable.p18));

        Gamelist.add(new Games("Alien Kindergarten ", "https://www.gamezop.com/g/r1Xm38FQkl?id=jRmYUNF6z", "580", "580", R.drawable.p19));

        Gamelist.add(new Games("Box Crush ", "https://www.gamezop.com/g/S1Wrpf1v5ym?id=jRmYUNF6z", "581", "581", R.drawable.p20));

        Gamelist.add(new Games("Pop Soap ", "https://www.gamezop.com/g/SJX7TGkDq1X?id=jRmYUNF6z", "582", "582", R.drawable.p21));

        Gamelist.add(new Games("Jello Go Round ", "https://www.gamezop.com/g/SkRZZUoXI8g?id=jRmYUNF6z", "583", "583", R.drawable.p22));

        Gamelist.add(new Games(" Rescue Juliet", "https://www.gamezop.com/g/4ykgM_yzbcg?id=jRmYUNF6z", "584", "584", R.drawable.p23));

        Gamelist.add(new Games("1212 ", "https://www.gamezop.com/g/41FZfdyG-5x?id=jRmYUNF6z", "585", "585", R.drawable.p24));

        Gamelist.add(new Games(" Quiz Champions", "https://www.gamezop.com/g/Sy8y2aQ9CB?id=jRmYUNF6z", "586", "586", R.drawable.p25));


        Gamelist.add(new Games("Jelly Doods ", "https://www.gamezop.com/g/rJsWV8aIa-l?id=jRmYUNF6z", "587", "587", R.drawable.p26));

        Gamelist.add(new Games(" Teleporting Kittens", "https://www.gamezop.com/g/SyJfiahGdlW?id=jRmYUNF6z", "588", "588", R.drawable.p27));

        Gamelist.add(new Games(" Countdown Calculator", "https://www.gamezop.com/g/By5syVo5?id=jRmYUNF6z", "589", "589", R.drawable.p28));


        Gamelist.add(new Games("Oh No", "https://www.gamezop.com/g/BkqTS_1b?id=jRmYUNF6z", "590", "590", R.drawable.p30));


        Gamelist.add(new Games("Drop Me ", "https://www.gamezop.com/g/SJghvtd2_?id=jRmYUNF6z", "591", "591", R.drawable.p31));

        Gamelist.add(new Games("High or Low ", "https://www.gamezop.com/g/H1eGU64XRg?id=jRmYUNF6z", "592", "592", R.drawable.p32));

        Gamelist.add(new Games("Cubes Got Moves ", "https://www.gamezop.com/g/S1JXaMJDqJX?id=jRmYUNF6z", "593", "593", R.drawable.p33));

        Gamelist.add(new Games("Sudoku Classic ", "https://www.gamezop.com/g/SJgx126Qc0H?id=jRmYUNF6z", "594", "594", R.drawable.p34));

        Gamelist.add(new Games(" Nut Physics", "https://www.gamezop.com/g/BJdZ-8iXULl?id=jRmYUNF6z", "595", "595", R.drawable.p35));


        Gamelist.add(new Games(" Aquatic Rescue", "https://www.gamezop.com/g/r1xZj62MOe-?id=jRmYUNF6z", "596", "596", R.drawable.p36));


        Gamelist.add(new Games("Juicy Dash", "https://www.gamezop.com/g/H1lZem8hq?id=jRmYUNF6z", "597", "597", R.drawable.p39));


        //rac

        //Game zop

        Gamelist.add(new Games("Rodeo Rider ", "https://www.gamezop.com/g/BJIlCtBbdE?id=jRmYUNF6z", "619", "619", R.drawable.s22));

        Gamelist.add(new Games("Rafting Adventure ", "https://www.gamezop.com/g/4JcZiV3XWql?id=jRmYUNF6z", "620", "620", R.drawable.s23));


        //atm


        Gamelist.add(new Games(" Cars", "https://games.atmegame.com/gamesworld/games/cars/?utm_source=Gamesworld&utm_medium=Gamesworld", "65", "65", R.drawable.a16));

        Gamelist.add(new Games(" Crazy Runner", "https://games.atmegame.com/gamesworld/games/crazy-runner/?utm_source=Gamesworld&utm_medium=Gamesworld", "66", "66", R.drawable.a17));
        Gamelist.add(new Games("Cube Ninja ", "https://games.atmegame.com/gamesworld/games/cube-ninja/?utm_source=Gamesworld&utm_medium=Gamesworld", "95", "95", R.drawable.a20));
        Gamelist.add(new Games("Road Racer ", "https://games.atmegame.com/gamesworld/games/road-racer/?utm_source=Gamesworld&utm_medium=Gamesworld", "67", "67", R.drawable.a66));
        Gamelist.add(new Games(" Santa Run", "https://games.atmegame.com/gamesworld/games/santa-run/?utm_source=Gamesworld&utm_medium=Gamesworld", "68", "68", R.drawable.a68));

        Gamelist.add(new Games("Scary Run ", "https://games.atmegame.com/gamesworld/games/scary-run/?utm_source=Gamesworld&utm_medium=Gamesworld", "69", "69", R.drawable.a69));
        Gamelist.add(new Games("Speed Racer ", "https://games.atmegame.com/gamesworld/games/speed-racer/?utm_source=Gamesworld&utm_medium=Gamesworld", "70", "70", R.drawable.a72));
        Gamelist.add(new Games(" Speedy Driving", "https://games.atmegame.com/gamesworld/games/speedy-driving/?utm_source=Gamesworld&utm_medium=Gamesworld", "71", "71", R.drawable.a73));


        Gamelist.add(new Games("Traffic ", "https://games.atmegame.com/gamesworld/games/traffic/?utm_source=Gamesworld&utm_medium=Gamesworld", "72", "72", R.drawable.a85));

        Gamelist.add(new Games("Traffic Command ", "https://games.atmegame.com/gamesworld/games/traffic-command/?utm_source=Gamesworld&utm_medium=Gamesworld", "73", "73", R.drawable.a86));

        Gamelist.add(new Games("Truck-Parking Pro ", "https://games.atmegame.com/gamesworld/games/truck-parking-pro/?utm_source=Gamesworld&utm_medium=Gamesworld", "74", "74", R.drawable.a87));

        Gamelist.add(new Games("Dark Ninja ", "https://games.atmegame.com/gamesworld/games/dark-ninja/?utm_source=Gamesworld&utm_medium=Gamesworld", "75", "75", R.drawable.a23));

        Gamelist.add(new Games(" Creepy Day", "https://games.atmegame.com/gamesworld/games/creepy-day/?utm_source=Gamesworld&utm_medium=Gamesworld", "76", "76", R.drawable.a18));

        Gamelist.add(new Games(" Cube Dash", "https://games.atmegame.com/gamesworld/games/cube-dash/?utm_source=Gamesworld&utm_medium=Gamesworld", "77", "77", R.drawable.a19));


/// sp
        //gamezop
        Gamelist.add(new Games(" Basket Champs", "https://www.gamezop.com/g/S1_V6GyP5ym?id=jRmYUNF6z", " 598", " 598", R.drawable.s1));

        Gamelist.add(new Games(" Flappy Foot Chinko", "https://www.gamezop.com/g/r1z13aXqAB?id=jRmYUNF6z", " 599", " 599", R.drawable.s2));

        Gamelist.add(new Games("Let's Go Fishing ", "https://www.gamezop.com/g/B1hCYSbdN?id=jRmYUNF6z", "600", "600", R.drawable.s3));

        Gamelist.add(new Games(" Groovy Ski", "https://www.gamezop.com/g/EJaG_JfW9l?id=jRmYUNF6z", "601", "601", R.drawable.s7));

        Gamelist.add(new Games(" Dribble Kings", "https://www.gamezop.com/g/SkJf58Ouf0?id=jRmYUNF6z", "602", "602", R.drawable.s5));


        Gamelist.add(new Games(" Homerun Hit", "https://www.gamezop.com/g/B1H5NfCXa?id=jRmYUNF6z", "603", "603", R.drawable.s6));

        Gamelist.add(new Games("Quack Hunt ", "https://www.gamezop.com/g/SJXbW8smUUx?id=jRmYUNF6z", "604", "604", R.drawable.s4));

        Gamelist.add(new Games("Super Goalie Auditions ", "https://www.gamezop.com/g/SyO94GA7p?id=jRmYUNF6z", "605", "605", R.drawable.s8));

        Gamelist.add(new Games(" Furious Speed", "https://www.gamezop.com/g/rkwCYBZuV?id=jRmYUNF6z", "606", "606", R.drawable.s9));

        Gamelist.add(new Games(" Skater Dude", "https://www.gamezop.com/g/BJuxCtrWdN?id=jRmYUNF6z", "607", "607", R.drawable.s10));

        Gamelist.add(new Games("Basketball Master ", "https://www.gamezop.com/g/HyCKrWd4?id=jRmYUNF6z", "608", "608", R.drawable.s11));

        Gamelist.add(new Games("Foot Chinko ", "https://www.gamezop.com/g/r1z13aXqAB?id=jRmYUNF6z", "609", "609", R.drawable.s12));

        Gamelist.add(new Games("Lane Battles ", "https://www.gamezop.com/g/4kZgf_1z-9l?id=jRmYUNF6z", "610", "610", R.drawable.s13));

        Gamelist.add(new Games(" Table Tennis Shots", "https://www.gamezop.com/g/HJY4pfJP9JQ?id=jRmYUNF6z", "611", "611", R.drawable.s14));

        Gamelist.add(new Games("Kickin It ", "https://www.gamezop.com/g/r1ozpMkD5Jm?id=jRmYUNF6z", "612", "612", R.drawable.s15));


        Gamelist.add(new Games("Hats Off ", "https://www.gamezop.com/g/HyIM86VXAe?id=jRmYUNF6z", "613", "613", R.drawable.s16));

        Gamelist.add(new Games("Bowling Stars ", "https://www.gamezop.com/g/BkdJhTX50B?id=jRmYUNF6z", "614", "614", R.drawable.s17));

        Gamelist.add(new Games(" City Cricket Battles", "https://www.gamezop.com/g/HJP4afkvqJQ?id=jRmYUNF6z", "615", "615", R.drawable.s18));

        Gamelist.add(new Games(" Minigolf Kingdom", "https://www.gamezop.com/g/S1A0FBWuE?id=jRmYUNF6z", "616", "616", R.drawable.s19));

        Gamelist.add(new Games(" Soccer Jerks", "https://www.gamezop.com/g/BJ8Wb8j7ILx?id=jRmYUNF6z", "617", "617", R.drawable.s20));

        Gamelist.add(new Games("Cricket Gunda ", "https://www.gamezop.com/g/BkzmafyPqJm?id=jRmYUNF6z", "618", "618", R.drawable.s21));


        Gamelist.add(new Games(" Mafia Billiard Tricks", "https://www.gamezop.com/g/SkkV6MJD51Q?id=jRmYUNF6z", "621", "621", R.drawable.s24));

        Gamelist.add(new Games("Clay Pigeon: Tap and Shoot ", "https://www.gamezop.com/g/HJKWbUj788l?id=jRmYUNF6z", "622", "622", R.drawable.s25));


        //atm
        Gamelist.add(new Games("Basketball ", "https://games.atmegame.com/gamesworld/games/basketball/?utm_source=Gamesworld&utm_medium=Gamesworld", "52", "52", R.drawable.a8));

        Gamelist.add(new Games("Billiards ", "https://games.atmegame.com/gamesworld/games/billiards/?utm_source=Gamesworld&utm_medium=Gamesworld", "53", "53", R.drawable.a9));
        Gamelist.add(new Games("Air Hockeyir ", "https://games.atmegame.com/gamesworld/games/air-hockey/?utm_source=Gamesworld&utm_medium=Gamesworld", "54", "54", R.drawable.a1));
        Gamelist.add(new Games("Monster-Truck Football	 ", "https://games.atmegame.com/gamesworld/games/monster-truck-football/?utm_source=Gamesworld&utm_medium=Gamesworld", "55", "55", R.drawable.a55));
        Gamelist.add(new Games("Pool-8 Ball ", "https://games.atmegame.com/gamesworld/games/pool-8-ball/?utm_source=Gamesworld&utm_medium=Gamesworld", "56", "56", R.drawable.a62));

        Gamelist.add(new Games("Stickman-Table Tennis ", "https://games.atmegame.com/gamesworld/games/stickman-table-tennis/?utm_source=Gamesworld&utm_medium=Gamesworld", "57", "57", R.drawable.a77));
        Gamelist.add(new Games(" Pops Billiards", "https://games.atmegame.com/gamesworld/games/pops-billiards/?utm_source=Gamesworld&utm_medium=Gamesworld", "58", "58", R.drawable.a63));

        Gamelist.add(new Games("Supe-Pon Goal ", "https://games.atmegame.com/gamesworld/games/supe-pon-goal/?utm_source=Gamesworld&utm_medium=Gamesworld", "59", "59", R.drawable.a79));
        Gamelist.add(new Games("Penalty Challenge ", "https://games.atmegame.com/gamesworld/games/penalty-challenge/?utm_source=Gamesworld&utm_medium=Gamesworld", "60", "60", R.drawable.a58));


        Gamelist.add(new Games("Space Purge", "https://games.atmegame.com/gamesworld/games/space-purge/?utm_source=Gamesworld&utm_medium=Gamesworld", "61", "61", R.drawable.a71));


        Gamelist.add(new Games(" Barn Dash", "https://games.atmegame.com/gamesworld/games/barn-dash/?utm_source=Gamesworld&utm_medium=Gamesworld", "62", "62", R.drawable.a7));
        Gamelist.add(new Games("Jumpers Jumpers ", "https://games.atmegame.com/gamesworld/games/jumpers/?utm_source=Gamesworld&utm_medium=Gamesworld", "63", "63", R.drawable.a49));
        Gamelist.add(new Games("Jungle Treasure", "https://games.atmegame.com/gamesworld/games/jungle-treasure/?utm_source=Gamesworld&utm_medium=Gamesworld", "64", "64", R.drawable.a50));


        //strea

        Gamelist.add(new Games("Ludo With Friends ", "https://www.gamezop.com/g/SkhljT2fdgb?id=jRmYUNF6z", "623", "623", R.drawable.t8));

        Gamelist.add(new Games("Bubble Wipeout ", "https://www.gamezop.com/g/H1AN6fkwqJ7?id=jRmYUNF6z", "624", "624", R.drawable.t9));

        Gamelist.add(new Games("Yummy Taco ", "https://www.gamezop.com/g/rJyWCKHbON?id=jRmYUNF6z", "625", "625", R.drawable.t18));
        Gamelist.add(new Games("Hex Burst ", "https://www.gamezop.com/g/H1abja2M_eb?id=jRmYUNF6z", "626", "626", R.drawable.t39));


        Gamelist.add(new Games(" Save Your Pinky", "https://www.gamezop.com/g/H1pbZUoXIUl?id=jRmYUNF6z", "627", "627", R.drawable.t17));
        Gamelist.add(new Games("Ship It Up! ", "https://www.gamezop.com/g/rJybo6nfdgb?id=jRmYUNF6z", "628", "628", R.drawable.t12));
        Gamelist.add(new Games("Kingdom Fight ", "https://www.gamezop.com/g/SyfxJ3a75Cr?id=jRmYUNF6z", "629", "629", R.drawable.t1));

        Gamelist.add(new Games("Tic Tac Toe ", "https://www.gamezop.com/g/H1WmafkP9JQ?id=jRmYUNF6z", "630", "630", R.drawable.t3));


        Gamelist.add(new Games("Snack Time ", "https://www.gamezop.com/g/SkKlAYSbuE?id=jRmYUNF6z", "638", "638", R.drawable.t2));


        Gamelist.add(new Games("Craigen Stones ", "https://www.gamezop.com/g/Bk7RYrZO4?id=jRmYUNF6z", "639", "639", R.drawable.t4));

        Gamelist.add(new Games(" Cute Towers 2", "https://www.gamezop.com/g/ByZ3DF_hd?id=jRmYUNF6z", "631", "631", R.drawable.t5));


        Gamelist.add(new Games(" Monsterjong", "https://www.gamezop.com/g/S1-bxXI39?id=jRmYUNF6z", "632", "632", R.drawable.t6));

        Gamelist.add(new Games("Chess Grandmaster ", "https://www.gamezop.com/g/rkAXTzkD5kX?id=jRmYUNF6z", "632", "633", R.drawable.t7));


        Gamelist.add(new Games("Spider Solitaire ", "https://www.gamezop.com/g/B1MfIa4QCg?id=jRmYUNF6z", "634", "634", R.drawable.t10));

        Gamelist.add(new Games("Omit Orange 2", "https://www.gamezop.com/g/Bypb6MJvqJQ?id=jRmYUNF6z", "635", "635", R.drawable.t11));


        Gamelist.add(new Games("Brick Plunge ", "https://www.gamezop.com/g/BJ9bvzIKdJl?id=jRmYUNF6z", "636", "636", R.drawable.t13));

        Gamelist.add(new Games("Crazy Pizza ", "https://www.gamezop.com/g/SyN0KSWuV?id=jRmYUNF6z", "637", "637", R.drawable.t14));

        Gamelist.add(new Games("Illuminate ", "https://www.gamezop.com/g/rkHuVQ-1K?id=jRmYUNF6z", "641", "641", R.drawable.t16));

        Gamelist.add(new Games(" Save Your Pinky", "https://www.gamezop.com/g/H1pbZUoXIUl?id=jRmYUNF6z", "642", "642", R.drawable.t17));


        Gamelist.add(new Games(" Zigzag Clash", "https://www.gamezop.com/g/BJlg94zA76?id=jRmYUNF6z", "643", "643", R.drawable.t19));

        Gamelist.add(new Games(" Where's the Ace?", "https://www.gamezop.com/g/HyZMUTVQRe?id=jRmYUNF6z", "644", "644", R.drawable.t20));

        Gamelist.add(new Games("Time Warp ", "https://www.gamezop.com/g/Sk728YXJx?id=jRmYUNF6z", "645", "645", R.drawable.t21));

        Gamelist.add(new Games(" Battleships Armada", "https://www.gamezop.com/g/rkt7TzJv9k7?id=jRmYUNF6z", "646", "646", R.drawable.t22));

        Gamelist.add(new Games("Jelly Bears ", "https://www.gamezop.com/g/SJcRYSbu4?id=jRmYUNF6z", "647", "647", R.drawable.t23));
        Gamelist.add(new Games("Hansel & Gretel ", "https://www.gamezop.com/g/HyKCFB-dV?id=jRmYUNF6z", "648", "648", R.drawable.t24));
        Gamelist.add(new Games("Little Bouncing Guys ", "https://www.gamezop.com/g/Sy6RYB-u4?id=jRmYUNF6z", "649", "649", R.drawable.t25));

        Gamelist.add(new Games(" Tiny Tripper", "https://www.gamezop.com/g/rkb--Io78Ux?id=jRmYUNF6z", "650", "650", R.drawable.t26));


        Gamelist.add(new Games("Pirate's Pillage! Aye! Aye! ", "https://www.gamezop.com/g/r1fl9VzRX6?id=jRmYUNF6z", "651", "651", R.drawable.t27));

        Gamelist.add(new Games("Pixel Brothers ", "https://www.gamezop.com/g/41rGO1Gbqe?id=jRmYUNF6z", "653", "653", R.drawable.t29));

        Gamelist.add(new Games(" Let Me Grow", "https://www.gamezop.com/g/SklmW1ad_?id=jRmYUNF6z", "654", "654", R.drawable.t30));


        Gamelist.add(new Games("Junior Chess ", "https://www.gamezop.com/g/Hkh7azyv9km?id=jRmYUNF6z", "655", "655", R.drawable.t31));

        Gamelist.add(new Games("Traffic Command", "https://www.gamezop.com/g/SykGDfUKOkg?id=jRmYUNF6z", "656", "656", R.drawable.t32));

        Gamelist.add(new Games(" Road Safety", "https://www.gamezop.com/g/r1z-eQ8nq?id=jRmYUNF6z", "658", "658", R.drawable.t34));

        Gamelist.add(new Games("Greedy Gnomes ", "https://www.gamezop.com/g/BydCYS-ON?id=jRmYUNF6z", "659", "659", R.drawable.t35));


        Gamelist.add(new Games("Coin Grab ", "https://www.gamezop.com/g/HkSWia3f_g-?id=jRmYUNF6z", "660", "660", R.drawable.t36));

        Gamelist.add(new Games("Pebble Boy ", "https://www.gamezop.com/g/H1TbVUa8aWe?id=jRmYUNF6z", "661", "661", R.drawable.t37));

        Gamelist.add(new Games("Cheat Spidy ", "https://www.gamezop.com/g/BkuNQbJt?id=jRmYUNF6z", "662", "662", R.drawable.t38));


        Gamelist.add(new Games(" Feed The Figures 2", "https://www.gamezop.com/g/BkR-TMJP5kQ?id=jRmYUNF6z", "663", "663", R.drawable.t40));

        Gamelist.add(new Games(" Hex Burst", "https://www.gamezop.com/g/H1abja2M_eb?id=jRmYUNF6z", "664", "664", R.drawable.t41));


        // zom


        Gamelist.add(new Games(" Viking Attack", "https://games.atmegame.com/gamesworld/games/viking-attack/?utm_source=Gamesworld&utm_medium=Gamesworld", "20", "20", R.drawable.a88));

        Gamelist.add(new Games("Viking Escape ", "https://games.atmegame.com/gamesworld/games/viking-escape/?utm_source=Gamesworld&utm_medium=Gamesworld", "21", "21", R.drawable.a89));
        Gamelist.add(new Games(" Vikings-Vs Skeletons", "https://games.atmegame.com/gamesworld/games/vikings-vs-skeletons/?utm_source=Gamesworld&utm_medium=Gamesworld", "22", "22", R.drawable.a90));

        Gamelist.add(new Games("Wothan Escape ", "https://games.atmegame.com/gamesworld/games/wothan-escape/?utm_source=Gamesworld&utm_medium=Gamesworld", "23", "23", R.drawable.a91));

        Gamelist.add(new Games(" Zombie Buster", "https://games.atmegame.com/gamesworld/games/zombie-buster/?utm_source=Gamesworld&utm_medium=Gamesworld", "24", "24", R.drawable.a92));

        Gamelist.add(new Games("Zombie Shooter ", "https://games.atmegame.com/gamesworld/games/zombie-shooter/?utm_source=Gamesworld&utm_medium=Gamesworld", "25", "25", R.drawable.a93));

        Gamelist.add(new Games("Super-Cowboy Run ", "https://games.atmegame.com/gamesworld/games/super-cowboy-run/?utm_source=Gamesworld&utm_medium=Gamesworld", "26", "26", R.drawable.a80));

        Gamelist.add(new Games("Ranger-Vs Zombies ", "https://games.atmegame.com/gamesworld/games/ranger-vs-zombies/?utm_source=Gamesworld&utm_medium=Gamesworld", "28", "28", R.drawable.a65));

        Gamelist.add(new Games("Knife-Vs Zombies	 ", "https://games.atmegame.com/gamesworld/games/knife-vs-zombies/?utm_source=Gamesworld&utm_medium=Gamesworld", "27", "27", R.drawable.a51));


        Gamelist.add(new Games("Mad Scientist ", "https://games.atmegame.com/gamesworld/games/mad-scientist/?utm_source=Gamesworld&utm_medium=Gamesworld", "29", "29", R.drawable.a52));

        Gamelist.add(new Games("Swat-Vs Zombies ", "https://games.atmegame.com/gamesworld/games/swat-vs-zombies/?utm_source=Gamesworld&utm_medium=Gamesworld", "30", "30", R.drawable.a81));


        Gamelist.add(new Games("The-Bandit Hunter ", "https://games.atmegame.com/gamesworld/games/the-bandit-hunter/?utm_source=Gamesworld&utm_medium=Gamesworld", "31", "31", R.drawable.a84));


        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_all);
        GameitemAdapter adapter = new GameitemAdapter(Gamelist, this, this);
        recyclerView.setAdapter(adapter);
        GridLayoutManager manager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

    }

    @Override
    public void onGamegClick(Games Gamelist) {
        Intent intent = new Intent(All_Games.this, MWebActivity.class);
        intent.putExtra("url", Gamelist.getUrl());
        All_Games.this.startActivity(intent);
    }

    private void inflateAd(NativeBannerAd nativeBannerAd) {
        // Unregister last ad
        nativeBannerAd.unregisterView();

        // Add the Ad view into the ad container.
        nativeAdLayout = findViewById(R.id.native_banner_ad_container);
        LayoutInflater inflater = LayoutInflater.from(All_Games.this);
        // Inflate the Ad view.  The layout referenced is the one you created in the last step.
        adView = (LinearLayout) inflater.inflate(R.layout.native_banner_ad_unit, nativeAdLayout, false);
        nativeAdLayout.addView(adView);

        // Add the AdChoices icon
        RelativeLayout adChoicesContainer = adView.findViewById(R.id.ad_choices_container);
        AdOptionsView adOptionsView = new AdOptionsView(All_Games.this, nativeBannerAd, nativeAdLayout);
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

    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    public void AddtoFav(Games game)
    {
        db = FaverouiteDatabase.getInstance(All_Games.this);
        All_Games.AsyncTaskRunner myTask = new All_Games.AsyncTaskRunner();
        myTask.execute();
    }

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {
            List<Faverouite> list = db.favDao().getAllFavertouite();
            Faverouite x = list.get(0);
            String name = x.getGame_name();

            return name;
        }
        @Override
        protected void onPostExecute(String result) {
            // execution of result of Long time consuming operation
        }
        @Override
        protected void onPreExecute() {

        }
        @Override
        protected void onProgressUpdate(String... text) {

        }
    }
}