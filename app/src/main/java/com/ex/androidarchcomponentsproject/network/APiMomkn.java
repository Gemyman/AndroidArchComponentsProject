package com.ex.androidarchcomponentsproject.network;

import com.ex.androidarchcomponentsproject.models.DataModel;
import com.ex.androidarchcomponentsproject.models.Items;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface APiMomkn {

    @GET ("bins/kvdzh")
    Call<DataModel>getData();
   }