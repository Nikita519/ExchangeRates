package com.android.shabalin.exchangerates;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

public class ValuteAdapter extends ArrayAdapter<CurrencyDTO> {

    Map<String, CurrencyDTO> valuteList;
    Context context;
    LayoutInflater inflater;

    public ValuteAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    /*public ValuteAdapter(Context context, Map<String, CurrencyDTO> objects) {
        super(context, 0, objects);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        valuteList = objects;
    }*/



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = inflater.inflate(R.layout.valute_item, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        CurrencyDTO valute = getItem(position);

        String textValute = String.format("1 %s (%s)", valute.getCharCode(), valute.getName());
        vh.textViewValute.setText(textValute);

        String valuteVal = String.format("%.2f", valute.getValue()/valute.getNominal());
        String textRub = String.format("%s \u20BD", valuteVal);
        vh.textViewRub.setText(textRub);

        return vh.rootView;
    }

    public static class ViewHolder {
        public RelativeLayout rootView;
        public TextView textViewValute;
        public TextView textViewRub;

        public ViewHolder(RelativeLayout rootView, TextView textViewValute, TextView textViewRub) {
            this.rootView = rootView;
            this.textViewValute = textViewValute;
            this.textViewRub = textViewRub;
        }

        public static ViewHolder create(RelativeLayout rootView){
            TextView textViewValute = rootView.findViewById(R.id.textViewValute);
            TextView textViewRub = rootView.findViewById(R.id.textViewRub);
            return new ViewHolder(rootView, textViewValute, textViewRub);
        }
    }
}
