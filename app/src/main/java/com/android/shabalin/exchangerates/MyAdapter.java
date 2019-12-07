package com.android.shabalin.exchangerates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Map;



    public class MyAdapter extends BaseAdapter {
        private final ArrayList mData;

        public MyAdapter(Map<String, CurrencyDTO> map) {
            mData = new ArrayList();
            mData.addAll(map.entrySet());
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Map.Entry<String, CurrencyDTO> getItem(int position) {
            return (Map.Entry) mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO implement you own logic with ID
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final View result;

            if (convertView == null) {
                result = LayoutInflater.from(parent.getContext()).inflate(R.layout.valute_item, parent, false);
            } else {
                result = convertView;
            }

            Map.Entry<String, CurrencyDTO> item = getItem(position);

            // TODO replace findViewById by ViewHolder
            String textValute = String.format("1 %s (%s)", item.getValue().getCharCode(), item.getValue().getName());
            TextView textViewValute = result.findViewById(R.id.textViewValute);
            textViewValute.setText(textValute);

            String valuteVal = String.format("%.2f", item.getValue().getValue()/item.getValue().getNominal());
            String textRub = String.format("%s \u20BD", valuteVal);
            TextView textViewRub = result.findViewById(R.id.textViewRub);
            textViewRub.setText(textRub);

            return result;
        }
    }

