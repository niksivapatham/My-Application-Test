package com.example.aditya.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainActivity extends ActionBarActivity {
    public WebView objwebview ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        WebView webView1 = new WebView(this);
        setContentView(webView1);
        objwebview = (WebView)findViewById(R.id.webView1);
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://www.google.com");
        try {
            HttpResponse response = client.execute(request);
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            StringBuilder str = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                str.append(line);
            }
            objwebview.loadData(str.toString(), "text/html", "UTF-8");
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            objwebview.loadData(e.toString(), "text/html", "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            objwebview.loadData(e.toString(), "text/html", "UTF-8");
        } catch (IllegalStateException e) {
            e.printStackTrace();
            objwebview.loadData(e.toString(), "text/html", "UTF-8");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
