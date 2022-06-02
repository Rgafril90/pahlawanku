package com.if4b.pahlawanku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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

    // Tambahan Grid
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top_right, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_card:
                tampilDataCard();
                break;
            case R.id.menu_grid:
                tampilDataGrid();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void tampilDataGrid(){
        rvpahlawan.setLayoutManager(new GridLayoutManager(this, 2));
        AdapterGrid colokanGrid = new AdapterGrid(data);
        rvpahlawan.setAdapter(colokanGrid);

        colokanGrid.setOnItemClickCallBack(new AdapterGrid.OnItemClickCallBack() {
            @Override
            public void onItemClicked(ModelPahlawan data) {
                Toast.makeText(MainActivity.this, "Nama Pahlawan" + data.getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    // End Tambahan Grid

    private void tampilDataCard() {
        rvpahlawan.setLayoutManager(new LinearLayoutManager(this));
        AdapterCard colokanCard = new AdapterCard(data);
        rvpahlawan.setAdapter(colokanCard);

        colokanCard.setOnItemClickCallBack(new AdapterGrid.OnItemClickCallBack() {
            @Override
            public void onItemClicked(ModelPahlawan data) {
                Intent pindah = new Intent(MainActivity.this, detailactivity.class);
                pindah.putExtra("xNama", data.getNama());
                pindah.putExtra("xTentang", data.getTentang());
                pindah.putExtra("xFoto", data.getFoto());
                startActivity(pindah);
            }
        });
    }
}