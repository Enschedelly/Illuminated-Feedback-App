package nl.utwente.illuminatedfeedbackapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    private static final String LOGIN_URL = "https://api.roelink.eu/illuminated-feedback/session";

    private TextView passwordView;
    private TextView errorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.passwordView = findViewById(R.id.passwordView);
        this.errorView = findViewById(R.id.errorView);
    }

    public void onClickLogin(View v) {
        this.errorView.setVisibility(View.INVISIBLE);
        String password = this.passwordView.getText().toString();
        if (password.equals("")) {
            // No password
            this.errorView.setVisibility(View.VISIBLE);
            return;
        }

        (new LoginTask(password, errorView)).execute(LOGIN_URL);
    }

    private class LoginTask extends AsyncTask<String, Integer, String> {

        private String password;
        private TextView errorView;

        public LoginTask(String password, TextView errorView) {
            this.password = password;
            this.errorView = errorView;
        }

        @Override
        protected String doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept","application/json");
                conn.setRequestProperty("X-Authorization", password);

                InputStream in = new BufferedInputStream(conn.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                StringBuilder result = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                boolean success = conn.getResponseCode() == 200;
                conn.disconnect();
                return success ? result.toString() : null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            if (result == null) {
                // Wrong password
                this.errorView.setVisibility(View.VISIBLE);
                return;
            }

            // Good to go
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            intent.putExtra("password", password);
            intent.putExtra("session", result);
            startActivity(intent);
        }
    }
}
