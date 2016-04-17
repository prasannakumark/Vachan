package com.vachan.vachan.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vachan.vachan.R;

/**
 * Created by prasanna on 16/4/16.
 */
public class PricingPhotography1 extends Fragment {

    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.list_pricing,null);
        } else {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        return view;
    }
}

