package com.example.journalUIN.recycleviewAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("index.php")
    Call<List<Buah>> getBuah(
            @Query("item_type") String item_type
    );
}
