package com.android.shabalin.exchangerates;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class CurrencyDTO {


    @SerializedName("Valute")
    private Map<String, Valute> valute;
    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("NumCode")
    @Expose
    private String numCode;

    @SerializedName("CharCode")
    @Expose
    private String charCode;

    @SerializedName("Nominal")
    @Expose
    private int nominal;

    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("Value")
    @Expose
    private double value;
    @SerializedName("Previous")
    @Expose
    private double previous;


    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getPrevious() {
        return previous;
    }

    public void setPrevious(double previous) {
        this.previous = previous;
    }

    public Map<String, Valute> getValute() {
        return valute;
    }

    public void setValute(Map<String, Valute> valute) {
        this.valute = valute;
    }
}

