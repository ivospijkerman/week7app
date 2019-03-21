package nl.spijkerman.ivo.week7app.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import nl.spijkerman.ivo.week7app.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivityOnClick(R.id.buttonAsyncTask, AsyncTaskActivity.class);
        startActivityOnClick(R.id.buttonVolley, VolleyActivity.class);
        startActivityOnClick(R.id.buttonPicasso, PicassoActivity.class);
    }

    private void startActivityOnClick(int buttonId, Class<? extends AppCompatActivity> activityClass) {
        Button button = findViewById(buttonId);
        button.setOnClickListener($ -> startActivity(new Intent(this, activityClass)));
    }
}
