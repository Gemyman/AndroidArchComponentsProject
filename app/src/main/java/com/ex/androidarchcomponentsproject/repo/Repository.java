package com.ex.androidarchcomponentsproject.repo;

import androidx.lifecycle.MutableLiveData;

import com.ex.androidarchcomponentsproject.models.DataModel;
import com.ex.androidarchcomponentsproject.network.APiMomkn;
import com.ex.androidarchcomponentsproject.network.Serverconnection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Repository {


    MutableLiveData<DataModel> data = new MutableLiveData<DataModel>();

    public MutableLiveData<DataModel> getData (){
        try {
            APiMomkn aPiMomkn = Serverconnection.getApiClien().create(APiMomkn.class);
            Call<DataModel> call = aPiMomkn.getData();
            call.enqueue(new Callback<DataModel>(){
                @Override
                public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                    data.postValue(response.body());
                }

                @Override
                public void onFailure(Call<DataModel> call, Throwable t) {

                }
            });
        } catch (Exception e) {

        }

        return data;
    }

   }