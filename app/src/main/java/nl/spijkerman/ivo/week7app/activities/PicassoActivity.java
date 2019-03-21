package nl.spijkerman.ivo.week7app.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import nl.spijkerman.ivo.week7app.R;

public class PicassoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);

        ImageView picasso = findViewById(R.id.imageViewPicasso);

        Picasso.get().load(getString(R.string.image_url)).into(picasso);
    }
}
