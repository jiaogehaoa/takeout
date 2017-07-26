package com.example.birth.myapplication.utils;

import android.text.TextUtils;

/**
 * Created by birth on 2017/7/24.
 */

public class URLCaseUtils {

    public static String caseURL(String url){
        if(!TextUtils.isEmpty(url)){
            if(url.startsWith("http://172.16.0.116:8080")){
               return url.replace("http://172.16.0.116:8080","http://47.94.91.212:8080");
            }
        }
        return url;
    }
}
