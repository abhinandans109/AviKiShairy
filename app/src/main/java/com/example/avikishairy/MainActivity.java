package com.example.avikishairy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.avikishairy.Api.ApiInterface;
import com.example.avikishairy.Api.Apiclient;
import com.example.avikishairy.Api.Getshairyresponse;
import com.example.avikishairy.Models.shairyapimodels;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    List<shairyapimodels> list=new ArrayList<>();
    TextView shairy,shair;
    int i=0;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        i=0;
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Retrofit retrofit= Apiclient.getclient();
        shairy=findViewById(R.id.shairy);
        shair=findViewById(R.id.shair);
        apiInterface=retrofit.create(ApiInterface.class);
            shairyapimodels s1=new shairyapimodels(5,"this is shairy","avi","10001");
            list.add(s1);
        apiInterface.getpoetry().enqueue(new Callback<Getshairyresponse>() {
            @Override
            public void onResponse(Call<Getshairyresponse> call, Response<Getshairyresponse> response) {

                try {
                    if(response!=null) {
                        if (response.body().getStatus().equals("1")) {
                            list.addAll(response.body().getData());
                            setpoetry();
                        } else
                            Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }         }catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<Getshairyresponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "THIS"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void setpoetry(){
        list=getRandomElement(list,list.size());
        Toast.makeText(this, String.valueOf(list.size()), Toast.LENGTH_SHORT).show();

    }

    public void next(View view) {
            if(i==list.size()-1){
                Toast.makeText(this, "No more Shairies", Toast.LENGTH_SHORT).show();
                return;
            }
         shairyapimodels s=list.get(i);
        shairy.setText(s.getShairy_data());
        shair.setText(s.getPoet_name());
        i++;
    }
    public List<shairyapimodels>
    getRandomElement(List<shairyapimodels> list, int totalItems)
    {
        Random rand = new Random();

        // create a temporary list for storing
        // selected element
        List<shairyapimodels> newList = new ArrayList<>();
        for (int i = 0; i < totalItems; i++) {

            // take a raundom index between 0 to size
            // of given List
            int randomIndex = rand.nextInt(list.size());

            // add element in temporary list
            newList.add(list.get(randomIndex));

            // Remove selected element from orginal list
            list.remove(randomIndex);
        }
        return newList;
    }
}