package com.vachan.vachan.adaptors;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vachan.vachan.R;
import com.vachan.vachan.activity.MainActivity;
import com.vachan.vachan.fragments.PricingPhotography1;

import java.util.List;

/**
 * Created by prasanna on 17/4/16.
 */
public class PricingTabPageAdapter extends RecyclerView.Adapter<PricingTabPageAdapter.ViewHolder> {

    private final TypedValue mTypedValue = new TypedValue();

    private int mBackground;
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

    public PricingTabPageAdapter(Context context) {
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mBackground = mTypedValue.resourceId;
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
        return 1;
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
        viewPager.setOffscreenPageLimit(adapter.getCount());
    }
}
