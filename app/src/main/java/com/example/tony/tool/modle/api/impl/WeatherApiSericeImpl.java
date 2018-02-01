package com.example.tony.tool.modle.api.impl;

import android.util.ArrayMap;

import com.example.tony.tool.modle.api.WeatherApiBean;
import com.example.tony.tool.modle.api.WeatherApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.QueryMap;

/**
 * Created by tony on 2017/8/8.
 */

public class WeatherApiSericeImpl implements WeatherApiService {

    private Retrofit retrofit;

    public WeatherApiSericeImpl() {

    }

    @Override
    public Call<WeatherApiBean> queryWeather(@QueryMap ArrayMap<String, String> queryMap,Call<WeatherApiBean> callback) {
        String url = "https://ali-weather.showapi.com";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherApiService weatherApiSerice = retrofit.create(WeatherApiService.class);
        Call<WeatherApiBean> weatherApiBeanCall = weatherApiSerice.queryWeather(queryMap,callback);
        weatherApiBeanCall.enqueue(new Callback<WeatherApiBean>() {
            @Override
            public void onResponse(Call<WeatherApiBean> call, Response<WeatherApiBean> response) {

            }

            @Override
            public void onFailure(Call<WeatherApiBean> call, Throwable t) {

            }
        });
        return weatherApiBeanCall;
    }
}
