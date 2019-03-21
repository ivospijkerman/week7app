package nl.spijkerman.ivo.week7app.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import nl.spijkerman.ivo.week7app.R;

public class AsyncTaskActivity extends AppCompatActivity {

    private TextView jsonDump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        jsonDump = findViewById(R.id.jsonDumpTextView);
        jsonDump.setText(getString(R.string.loading));

        new MyAsyncTask().execute(getString(R.string.api_path));
    }

    private class MyAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... args) {
            if (args == null || args.length == 0 || args[0] == null)
                throw new IllegalArgumentException();

            try {
                URL url = new URL(args[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.connect();

                int responseCode = connection.getResponseCode();
                if (responseCode >= 200 && responseCode < 300) {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                        StringBuilder sb = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            sb.append(line);
                        }
                        return sb.toString();
                    }
                } else {
                    throw new IOException();
                }


            } catch (IOException e) {
                e.printStackTrace();
                return e.getClass().getSimpleName() + "\n" + e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            jsonDump.setText(result);
        }
    }
}
