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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prasanna on 17/4/16.
 */
public class PricingTabPageAdapter extends RecyclerView.Adapter<PricingTabPageAdapter.ViewHolder> {

    private final TypedValue mTypedValue = new TypedValue();

    private int mBackground;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {


        RecyclerView recyclerView,recyclerViewCandidatePhotography;

        public ViewHolder(View view) {
            super(view);
            recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview_couple_shoot);
            recyclerViewCandidatePhotography = (RecyclerView)view.findViewById(R.id.recyclerview_candidatePhotography);

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

        holder.recyclerViewCandidatePhotography.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        List<CandidateExpandableListAdapter.Item> data = new ArrayList<>();

        for(int i=0;i<=7;i++){
            CandidateExpandableListAdapter.Item item;
            if(i%2 == 0)
                item = new CandidateExpandableListAdapter.Item(0);
            else
                item = new CandidateExpandableListAdapter.Item(1);

            data.add(item);
        }
        holder.recyclerViewCandidatePhotography.setAdapter(new CandidateExpandableListAdapter(context,data));
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
