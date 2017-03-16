package com.facer.client;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.message.BasicHeader;
import com.facer.client.models.Application;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getApplications();
    }

    private void getApplications(){

        String BASE_URL = "http://10.88.26.16:8080/FacerServerApp/webapi/applications";
        List<Header> headers = new ArrayList<Header>();
        headers.add(new BasicHeader("Accept", "application/json"));

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(this,BASE_URL,headers.toArray(new Header[headers.size()]),null, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response){
                ArrayList<Application> applicationList = new ArrayList<Application>();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        applicationList.add(new Application(response.getJSONObject(i)));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                LinearLayout linearLayout = (LinearLayout)findViewById(R.id.button_layout);
                for(Application application:applicationList){
                    Button dynamicButton = new Button(MainActivity.this);
                    dynamicButton.setText(application.getApplication());
                    linearLayout.addView(dynamicButton);
                }
            }
        });
    }
}
