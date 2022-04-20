package com.if4b.pahlawanku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvpahlawan;
    private ArrayList<ModelPahlawan> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvpahlawan = findViewById(R.id.rv_pahlawanku);
        rvpahlawan.setHasFixedSize(true);

        data.addAll(DataPahlawan.ambilDataPahlawan());
        tampilDataCard();
    }

    private void tampilDataCard() {
        rvpahlawan.setLayoutManager(new LinearLayoutManager(this));
        AdapterCard colokanCard = new AdapterCard(data);
        rvpahlawan.setAdapter(colokanCard);
    }
}