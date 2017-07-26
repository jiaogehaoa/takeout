package com.example.birth.myapplication;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.birth.myapplication.ui.fragment.HomeFragment;
import com.example.birth.myapplication.ui.fragment.MeFragment;
import com.example.birth.myapplication.ui.fragment.MoreFragment;
import com.example.birth.myapplication.ui.fragment.OrderFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout view;
    private List<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragments = new ArrayList<>();

        fragments.add(new HomeFragment());
        fragments.add(new OrderFragment());
        fragments.add(new MeFragment());
        fragments.add(new MoreFragment());


        view = (LinearLayout) findViewById(R.id.ll_container);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = view.indexOfChild(v);
                updateUI(index);
                replaceFragment(index);
            }
        };

        listener.onClick(view.getChildAt(0));


        int childCount = view.getChildCount();
        for (int i = 0; i < childCount; i++) {
            view.getChildAt(i).setOnClickListener(listener);
        }

    }

    private void replaceFragment(int index) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_content,fragments.get(index)).commit();
    }


    private void updateUI(int index) {
        Toast.makeText(this, ""+index, Toast.LENGTH_SHORT).show();
        int childCount = view.getChildCount();
        for (int i = 0; i < childCount; i++) {
            setEnabled(view.getChildAt(i),i != index);

        }
    }

    private void setEnabled(View childAt, boolean b) {

        childAt.setEnabled(b);

        if(childAt instanceof ViewGroup){
            int childCount = ((ViewGroup) childAt).getChildCount();
            for (int i = 0; i < childCount; i++) {
                setEnabled(((ViewGroup) childAt).getChildAt(i),b);
            }
        }
    }
}
