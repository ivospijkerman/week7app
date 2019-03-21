package nl.spijkerman.ivo.week7app.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import nl.spijkerman.ivo.week7app.R;

public class VolleyActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        TextView jsonDump = findViewById(R.id.textViewJson);
        jsonDump.setText(getString(R.string.loading));

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(getString(R.string.api_path),
                jsonDump::setText,
                error -> jsonDump.setText(error.toString()));
        requestQueue.add(stringRequest);
    }
}
