package com.example.birth.myapplication.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.birth.myapplication.R;
import com.example.birth.myapplication.base.MyApplication;
import com.example.birth.myapplication.model.net.bean.GoodsItemBean;

import java.util.List;

/**
 * Created by birth on 2017/7/26.
 */

public class GoodsLeftAdapter extends RecyclerView.Adapter {
    private List<GoodsItemBean> lists;

    public void setAdapterData(List<GoodsItemBean> lists){
        this.lists = lists;

        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.item_classify,parent,false);
      return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tv.setText(lists.get(position).name);
    }

    @Override
    public int getItemCount() {
        return lists == null ? 0 : lists.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
