package nl.spijkerman.ivo.week7app.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import nl.spijkerman.ivo.week7app.R;

public class VolleyActivity extends AppCompatActivity {

    private TextView jsonDump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        jsonDump = findViewById(R.id.jsonDumpTextView);
        jsonDump.setText(getString(R.string.loading));

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(getString(R.string.api_path),
                response -> jsonDump.setText(response),
                error -> jsonDump.setText(error.toString()));
        requestQueue.add(stringRequest);
    }
}
