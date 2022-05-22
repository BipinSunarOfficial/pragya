package com.example.meroarkoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;


public class CategoryActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        initToolbar();
        getSupportFragmentManager().beginTransaction().add(R.id.frmContainer, new DashboardFragment()).commit();
    }


    private void initToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Category");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()== android.R.id.home){    //id of toolbar is home by default
            getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer, new HomeFragment()).commit();
        }
        return super.onOptionsItemSelected(item);
    }
}