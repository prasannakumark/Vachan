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

    TabLayout tabLayout;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView rv = (RecyclerView) inflater.inflate(R.layout.fragment_cheese_list, container, false);
        setupRecyclerView(rv);
        return rv;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(getActivity(),
                getRandomSublist()));
    }

    private List<String> getRandomSublist() {
        ArrayList<String> list = new ArrayList<>(1);
        list.add("1");
        return list;
    }

    public static class SimpleStringRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {

        private final TypedValue mTypedValue = new TypedValue();

        private int mBackground;
        private List<String> mValues;
        private Context context;

        public static class ViewHolder extends RecyclerView.ViewHolder {

            TabLayout tabLayout;
            ViewPager viewPager;
            RecyclerView recyclerView;

            public ViewHolder(View view) {
                super(view);
                tabLayout = (TabLayout)view.findViewById(R.id.tabs_pricing);
                viewPager = (ViewPager)view.findViewById(R.id.viewpager_pricing);
                recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview_couple_shoot);

            }

            @Override
            public String toString() {
                return super.toString();
            }
        }

        public String getValueAt(int position) {
            return mValues.get(position);
        }

        public SimpleStringRecyclerViewAdapter(Context context, List<String> items) {
            context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
            mBackground = mTypedValue.resourceId;
            mValues = items;
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.pricing, parent, false);
            view.setBackgroundResource(mBackground);
            return new ViewHolder(view);

        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            LinearLayoutManager layoutManager
                    = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            holder.recyclerView.setLayoutManager(layoutManager);
            holder.recyclerView.setAdapter(new RecyclerViewAdapter(context));



            setupViewPager(holder.viewPager);
            holder.tabLayout.setupWithViewPager(holder.viewPager);

        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        private void setupViewPager(ViewPager viewPager) {
            TabLayoutAdaptor adapter = new TabLayoutAdaptor(((MainActivity)context).getSupportFragmentManager());
            adapter.addFragment(new PricingPhotography1(), "1.PHOTOGRAPY");
            adapter.addFragment(new PricingPhotography1(), "2.PHOTOGRAPY");
            adapter.addFragment(new PricingPhotography1(), "3.PHOTOGRAPY");
            adapter.addFragment(new PricingPhotography1(), "4.PHOTOGRAPY");
            adapter.addFragment(new PricingPhotography1(), "5.PHOTOGRAPY");
            adapter.addFragment(new PricingPhotography1(), "6.PHOTOGRAPY");

            viewPager.setAdapter(adapter);
        }
    }

}
