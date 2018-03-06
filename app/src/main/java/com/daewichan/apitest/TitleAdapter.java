package com.daewichan.apitest;

import android.content.ClipData;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daewichan.apitest.data.vo.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daewichan on 3/2/18.
 */

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.ItemViewHolder> {
    private List<Item> itemList = new ArrayList<>();
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title,parent,false);
        ItemViewHolder itemViewHolder=new ItemViewHolder(itemView);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.showView(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        if(itemList.size()>0){

            return itemList.size();
        }else {
            return 0;
        }
    }

    public void addAll(List<Item> mItemList){
        this.itemList=mItemList;
        notifyDataSetChanged();

    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;

        public ItemViewHolder(View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.tv_title);

        }

        public void showView(Item item){

            textView.setText(item.getOwner().getDisplayName());
        }

    }
}
