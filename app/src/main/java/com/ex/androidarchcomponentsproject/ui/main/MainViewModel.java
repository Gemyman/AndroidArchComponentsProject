package com.ex.androidarchcomponentsproject.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ex.androidarchcomponentsproject.models.DataModel;
import com.ex.androidarchcomponentsproject.models.Items;
import com.ex.androidarchcomponentsproject.repo.Repository;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private  Repository repository = new Repository();

    private  MutableLiveData<ArrayList<Items>> items;

    public MutableLiveData<ArrayList<Items>> getData(boolean isOnline){
        items = repository.getData(isOnline);
        return items;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        repository.clearRealm();
    }
}
