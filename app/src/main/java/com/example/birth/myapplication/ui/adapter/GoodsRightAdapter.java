package com.example.birth.myapplication.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.birth.myapplication.base.MyApplication;
import com.example.birth.myapplication.model.net.bean.GoodsItemBean;

import java.util.List;

/**
 * Created by birth on 2017/7/26.
 */

public class GoodsRightAdapter extends RecyclerView.Adapter {

    private List<GoodsItemBean> lists;

    public void setAdapterData(List<GoodsItemBean> lists){
        this.lists = lists;
        notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView tv = new TextView(MyApplication.getContext());
        tv.setText("asdasd");
        return new MyViewHolder(tv);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return lists == null ? 0 : lists.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
