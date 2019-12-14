package com.ex.androidarchcomponentsproject.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ex.androidarchcomponentsproject.R;
import com.ex.androidarchcomponentsproject.models.DataModel;
import com.ex.androidarchcomponentsproject.models.Items;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

public class MainFragment extends Fragment implements MenuListAdapter.ItemClickListener{

    @BindView(R.id.mRecycler)
    RecyclerView recyclerView;
    private MainViewModel mViewModel;
    private MenuListAdapter menuListAdapter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_fragment, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.getData(isOnline(getContext())).observe(this, new Observer<ArrayList<Items>>() {
            @Override
            public void onChanged(ArrayList<Items> dataModel) {
                initRecyclerData(dataModel);
            }
        });
    }

    private void initRecyclerData(ArrayList<Items> items){

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        menuListAdapter = new MenuListAdapter(getContext(),items);
        menuListAdapter.setClickListener(this);
        recyclerView.setAdapter(menuListAdapter);
        menuListAdapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(View view, int position) {

    }

    public boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return (netInfo != null && netInfo.isConnected());
    }
}
