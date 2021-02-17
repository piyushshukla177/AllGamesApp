package com.newgame.allgamesapp.Activity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import com.newgame.allgamesapp.R;
import com.newgame.allgamesapp.model.Faverouite;
import com.newgame.allgamesapp.util.FaverouiteDatabase;
import java.util.List;

public class FaveroiteActivity extends AppCompatActivity {

    static FaverouiteDatabase db;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faveroite);
        db = FaverouiteDatabase.getInstance(FaveroiteActivity.this);
        AsyncTaskRunner myTask = new AsyncTaskRunner();
        myTask.execute();
    }
    private class AsyncTaskRunner extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {
            db.favDao().insert(new Faverouite("Ludo With Friends", "https://www.gamezop.com/g/SkhljT2fdgb?id=jRmYUNF6z", "623"));
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
