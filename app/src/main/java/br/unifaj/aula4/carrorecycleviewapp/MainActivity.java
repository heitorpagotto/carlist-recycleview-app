package br.unifaj.aula4.carrorecycleviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecycleView();
    }

    public void initRecycleView() {
        RecyclerView carRecycleView = findViewById(R.id.car_list_recycleview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        carRecycleView.setLayoutManager(layoutManager);
        carRecycleView.setAdapter(new CarRecycleViewAdapter());
    }
}