package com.ex.androidarchcomponentsproject.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

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

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragment extends Fragment implements MenuListAdapter.ItemClickListener{

    @BindView(R.id.mRecycler)
    RecyclerView recyclerView;
    private MainViewModel mViewModel;
    private MenuListAdapter menuListAdapter;

    public static MainFragment newInstance() {
        return new MainFragment();
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
        mViewModel.getData().observe(this, new Observer<DataModel>() {
            @Override
            public void onChanged(DataModel dataModel) {
                initRecyclerData(dataModel.getItems());
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
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
