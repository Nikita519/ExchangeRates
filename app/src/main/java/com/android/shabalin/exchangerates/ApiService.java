package com.android.shabalin.exchangerates;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("daily_json.js")
    Call<CurrencyList> getAllCurrencies();
}
