package com.vachan.vachan.adaptors;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vachan.vachan.R;
import com.vachan.vachan.activity.MainActivity;
import com.vachan.vachan.fragments.PricingPhotography1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prasanna on 4/19/16.
 */
public class CandidateExpandableListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int HEADER = 0;
    public static final int CHILD = 1;

    private List<Item> data;
    private Context context;

    public CandidateExpandableListAdapter(Context context,List<Item> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View view = null;
        Context context = parent.getContext();
        float dp = context.getResources().getDisplayMetrics().density;
        int subItemPaddingLeft = (int) (18 * dp);
        int subItemPaddingTopAndBottom = (int) (5 * dp);
        switch (type) {
            case HEADER:
                LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.pricing_tab_group_layout,null);
                ListHeaderViewHolder header = new ListHeaderViewHolder(view);
                return header;
            case CHILD:
                LayoutInflater inflaters = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflaters.inflate(R.layout.pricing_tab_chiled_layout,null);
                return new ListChiledViewHolder(view);
        }
        return null;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Item item = data.get(position);
        switch (item.type) {
            case HEADER:
                final ListHeaderViewHolder itemController = (ListHeaderViewHolder) holder;
                itemController.refferalItem = item;
                /*if (item.invisibleChildren == null) {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.circle_minus);
                } else {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.circle_plus);
                }*/
                itemController.btn_expand_toggle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (item.invisibleChildren == null) {
                            item.invisibleChildren = new ArrayList<Item>();
                            int count = 0;
                            int pos = data.indexOf(itemController.refferalItem);
                            while (data.size() > pos + 1 && data.get(pos + 1).type == CHILD) {
                                item.invisibleChildren.add(data.remove(pos + 1));
                                count++;
                            }
                            notifyItemRangeRemoved(pos + 1, count);
                            //itemController.btn_expand_toggle.setImageResource(R.drawable.circle_plus);
                        } else {
                            int pos = data.indexOf(itemController.refferalItem);
                            int index = pos + 1;
                            for (Item i : item.invisibleChildren) {
                                data.add(index, i);
                                index++;
                            }
                            notifyItemRangeInserted(pos + 1, index - pos - 1);
                           // itemController.btn_expand_toggle.setImageResource(R.drawable.circle_minus);
                            item.invisibleChildren = null;
                        }
                    }
                });
                break;
            case CHILD:
                 final ListChiledViewHolder itemControllers = (ListChiledViewHolder) holder;

                itemControllers.tabLayout.post(new Runnable() {
                    @Override
                    public void run() {
                        setupViewPager(itemControllers.viewPager);
                        itemControllers.tabLayout.setupWithViewPager(itemControllers.viewPager);
                    }
                });
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).type;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private static class ListHeaderViewHolder extends RecyclerView.ViewHolder {
        public ImageView btn_expand_toggle;
        public Item refferalItem;
        public ListHeaderViewHolder(View itemView) {
            super(itemView);
            btn_expand_toggle = (ImageView) itemView.findViewById(R.id.parent_list_item_expand_arrow);
        }
    }

    private static class ListChiledViewHolder extends RecyclerView.ViewHolder {
        TabLayout tabLayout;
        ViewPager viewPager;
        public ListChiledViewHolder(View view) {
            super(view);
            tabLayout = (TabLayout)view.findViewById(R.id.tabs_pricing);
            viewPager = (ViewPager)view.findViewById(R.id.viewpager_pricing);
        }
    }

    public static class Item {
        public int type;
        public String text;
        public List<Item> invisibleChildren;

        public Item() {
        }

        public Item(int type) {
            this.type = type;
        }
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
