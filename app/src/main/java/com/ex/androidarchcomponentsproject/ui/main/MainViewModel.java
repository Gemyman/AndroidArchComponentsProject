package com.ex.androidarchcomponentsproject.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ex.androidarchcomponentsproject.models.DataModel;
import com.ex.androidarchcomponentsproject.repo.Repository;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private  Repository repository = new Repository();

    private  MutableLiveData<DataModel> items;

    public MutableLiveData<DataModel> getData(){
        items = repository.getData();
        return items;
    }
}
