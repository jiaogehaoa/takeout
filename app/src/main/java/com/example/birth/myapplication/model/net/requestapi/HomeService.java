package com.example.birth.myapplication.model.net.requestapi;
import com.example.birth.myapplication.base.Constant;
import com.example.birth.myapplication.model.net.bean.HomeBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by birth on 2017/7/24.
 */

public interface HomeService {
    @GET(Constant.URL_HOME)
   Call<HomeBean> home();
}
