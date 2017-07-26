package com.example.birth.myapplication.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.birth.myapplication.R;
import com.example.birth.myapplication.base.MyApplication;
import com.example.birth.myapplication.model.net.bean.BodyItem;
import com.example.birth.myapplication.model.net.bean.HeadItem;
import com.example.birth.myapplication.model.net.bean.HomeItem;
import com.example.birth.myapplication.model.net.bean.PromotionInfo;
import com.example.birth.myapplication.utils.URLCaseUtils;

import java.util.List;

/**
 * Created by birth on 2017/7/24.
 */

public class HomtAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<BodyItem> body;
    private HeadItem head;
    private boolean isHeaded;

    public HomtAdapter() {
        this.context = MyApplication.getContext();
    }

    public void setHomeItem(HomeItem homeItem) {
        this.body = homeItem.body;
        this.head = homeItem.head;
        Log.i("##", body.size() + "asd");
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (body.get(position - 1).type == 0) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_title, parent, false);
            return new HeadHolder(view);
        } else if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_seller, parent, false);
            return new BodyItemHolder(view);

        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_division, parent, false);
            return new MyHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case 0:
                if(!isHeaded){
                    Log.i("###","HeadHolder....");
                    isHeaded = true;
                    HeadHolder headHolder = (HeadHolder) holder;
                    for (int i = 0; i < head.promotionList.size(); i++) {
                        PromotionInfo promotionInfo = head.promotionList.get(i);
                        String img_url = URLCaseUtils.caseURL(promotionInfo.pic);

                        TextSliderView textSliderView=new TextSliderView(context);
                        textSliderView.description(promotionInfo.info);//设置标题
                        textSliderView.image(img_url);//设置图片的网络地址
                        textSliderView.setScaleType(BaseSliderView.ScaleType.CenterCrop);//设置图片的缩放效果;
                        //添加到布局中显示
                        headHolder.sliderLayout.addSlider(textSliderView);
                    }
                }
                break;
            case 1:
                BodyItemHolder bodyItemHolder = (BodyItemHolder) holder;
                bodyItemHolder.tv.setText(body.get(position - 1).seller.name);
                bodyItemHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,body.get(position - 1).seller.name, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case 2:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return body == null ? 0 : body.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {

        public MyHolder(View itemView) {
            super(itemView);

        }
    }


    class HeadHolder extends RecyclerView.ViewHolder {
        SliderLayout sliderLayout;
        public HeadHolder(View itemView) {
            super(itemView);
             sliderLayout = (SliderLayout) itemView.findViewById(R.id.slider);
        }
    }


    class BodyItemHolder extends RecyclerView.ViewHolder {
        TextView tv;
        public BodyItemHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
