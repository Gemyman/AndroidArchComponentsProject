package com.ex.androidarchcomponentsproject.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.ex.androidarchcomponentsproject.models.DataModel;
import com.ex.androidarchcomponentsproject.models.Items;
import com.ex.androidarchcomponentsproject.network.APiMomkn;
import com.ex.androidarchcomponentsproject.network.Serverconnection;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Repository {


    MutableLiveData<ArrayList<Items>> data = new MutableLiveData<>();
    Realm realm = Realm.getDefaultInstance();

    public MutableLiveData<ArrayList<Items>> getData (boolean isOnline){
        if(isOnline) {
            try {
                APiMomkn aPiMomkn = Serverconnection.getApiClien().create(APiMomkn.class);
                Call<DataModel> call = aPiMomkn.getData();
                call.enqueue(new Callback<DataModel>() {
                    @Override
                    public void onResponse(Call<DataModel> call, Response<DataModel> response) {

                        DataModel dataModel = response.body();
                        ArrayList<Items> items = dataModel.getItems();
                        data.postValue(items);
                        for (Items item: items) {
                            realm.beginTransaction();
                            realm.copyToRealmOrUpdate(item);
                            realm.commitTransaction();
                        }
                    }

                    @Override
                    public void onFailure(Call<DataModel> call, Throwable t) {
                        Log.i("",t.getMessage());
                    }
                });
            } catch (Exception e) {

            }

        }else{
            RealmResults<Items> realmResults = realm.where(Items.class).findAll();
            ArrayList<Items> items = new ArrayList<>();
            for (Items realmResult:realmResults) {
                items.add(realmResult);
            }
            data.setValue(items);
        }
        return data;
    }

    public void clearRealm(){
        realm.close();
    }
   }