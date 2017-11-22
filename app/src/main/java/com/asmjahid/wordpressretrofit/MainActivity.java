package com.asmjahid.wordpressretrofit;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import com.asmjahid.wordpressretrofit.api.RestCountriesAPI;
import com.asmjahid.wordpressretrofit.model.Country;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new DownloadFilesTask().execute("");
    }

    //private method for this tutorial

    private class DownloadFilesTask extends AsyncTask<String, Integer, List<Country>> {

        protected List<Country> doInBackground(String... urls) {

            RestCountriesAPI api = new RestCountriesAPI();
            return api.GetAllCountries();
        }

        protected void onProgressUpdate(Integer... progress) {

        }

        protected void onPostExecute(List<Country> results) {

            StringBuilder sb = new StringBuilder();
            for(Country country : results)
            {
                Log.d("Countries Output: ", country.getName());
                sb.append(country.getName() + "\n");
            }

            ((TextView) findViewById(R.id.txt_log)).setText(sb.toString());

        }
    }
}