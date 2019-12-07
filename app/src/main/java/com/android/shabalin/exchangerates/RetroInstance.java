package com.android.shabalin.exchangerates;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {

    private  static Retrofit retrofit;
    private static final String BASE_URL = "http://www.cbr-xml-daily.ru/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            // create a retrofit instance, only if it has not been created yet.
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

}
