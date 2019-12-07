package com.android.shabalin.exchangerates;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class CurrencyList {

    @SerializedName("Valute")
    @Expose
    private Map<String, CurrencyDTO> valute;


    public Map<String, CurrencyDTO> getValute() {
        return valute;
    }

    public void setValute(Map<String, CurrencyDTO> valute) {
        this.valute = valute;
    }
}


