package com.example.tony.tool.modle.api;

import android.util.ArrayMap;
import android.util.SparseArray;

import com.example.tony.tool.modle.bean.WeatherBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/**
 * Created by tony on 2017/8/8.
 */

public interface WeatherApiService {
    @GET("/phone-post-code-weeather")
    @Headers("Authorization:APPCODE 3433d7b0945e4c93a438f6e6d4cbc96d")
    Call<WeatherApiBean> queryWeather(@QueryMap ArrayMap<String,String> queryMap,Call<WeatherApiBean> call);
}
