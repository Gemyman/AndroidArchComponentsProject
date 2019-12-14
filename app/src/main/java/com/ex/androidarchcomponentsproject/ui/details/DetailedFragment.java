package com.ex.androidarchcomponentsproject.ui.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.ex.androidarchcomponentsproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailedFragment extends Fragment {

    @BindView(R.id.item_img)
    ImageView img;

    @BindView(R.id.item_desc)
    TextView desc;

    private static final String ARG_PARAM1 = "imgURL_param";
    private static final String ARG_PARAM2 = "itemDesc_param";

    private String imgURL;
    private String itemDesc;


    public DetailedFragment() {
        // Required empty public constructor
    }

    public static DetailedFragment newInstance(String param1, String param2) {
        DetailedFragment fragment = new DetailedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imgURL = getArguments().getString(ARG_PARAM1);
            itemDesc = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detailed, container, false);
        ButterKnife.bind(this, rootView);
        Glide.with(getContext())
                .load(imgURL)
                .into(img);
        desc.setText(itemDesc);
        return rootView;
    }

}
