package com.android.shabalin.exchangerates;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private View parentView;

    private Map<String, CurrencyDTO> valutes;
    private ValuteAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        parentView = findViewById(R.id.parentLayout);

        listView = findViewById(R.id.listView);

        apiCall();



        Log.i("MyMeta", "created");


        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiCall();
            }
        });




    }


    public void apiCall(){
        ApiService service = RetroInstance.getRetrofitInstance().create(ApiService.class);
        Call<CurrencyList> call = service.getAllCurrencies();
        call.enqueue(new Callback<CurrencyList>() {
            @Override
            public void onResponse(Call<CurrencyList> call, Response<CurrencyList> response) {

                CurrencyList body = response.body();
                //body.getCurrencies().get(0);
                Log.i("MyMeta", body.getValute().get("USD").getName());

                valutes = body.getValute();

                MyAdapter adapter = new MyAdapter(valutes);
                listView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<CurrencyList> call, Throwable t) {

                Log.i("MyMeta", "wtf  " + t.getMessage());
            }
        });
    }




}
