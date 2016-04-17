package com.vachan.vachan.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.AlertDialog;

import com.roomorama.caldroid.CaldroidFragment;
import com.vachan.vachan.R;
import com.vachan.vachan.activity.MainActivity;
import com.vachan.vachan.adaptors.PricingTabPageAdapter;
import com.vachan.vachan.adaptors.RecyclerViewAdapter;
import com.vachan.vachan.adaptors.TabLayoutAdaptor;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

;

/**
 * Created by leela on 15/4/16.
 */
public class PricingFragment extends Fragment {

    private RecyclerView rv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rv == null) {
            rv = (RecyclerView) inflater.inflate(R.layout.fragment_cheese_list, container, false);
            setupRecyclerView(rv);
        } else {
            ((ViewGroup) rv.getParent()).removeView(rv);
        }
        return rv;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new PricingTabPageAdapter(getActivity()));
    }


}
