package com.example.avikishairy.Api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("getshairy.php")
    Call<Getshairyresponse> getpoetry();

}
