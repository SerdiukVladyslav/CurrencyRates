package com.example.currencyrates;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements DataLoader.Listener {

    private EditText txtFilter;
    private ListView listRates;

    private ArrayList<String> allItems = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFilter = findViewById(R.id.txtFilter);
        listRates = findViewById(R.id.listRates);

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, allItems);

        listRates.setAdapter(adapter);
        
        new DataLoader(this).execute();

        txtFilter.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(Editable s) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterList(s.toString());
            }
        });
    }

    @Override
    public void onDataLoaded(String xml) {
        HashMap<String, Double> map = Parser.parseRates(xml);

        allItems.clear();
        for (String code : map.keySet()) {
            allItems.add(code + " - " + map.get(code));
        }

        adapter.notifyDataSetChanged();
    }

    private void filterList(String text) {
        ArrayList<String> filtered = new ArrayList<>();

        for (String item : allItems) {
            if (item.toLowerCase().contains(text.toLowerCase())) {
                filtered.add(item);
            }
        }

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, filtered);

        listRates.setAdapter(adapter);
    }
}
