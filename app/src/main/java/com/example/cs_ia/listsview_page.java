package com.example.cs_ia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.List;

public class listsview_page extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    RecyclerView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listsview_page);

        //FETCHING DATA AND STORING IT INTO LIST
        dataBaseHelper dataBase = new dataBaseHelper(listsview_page.this);
        List<listName_model> everyone = dataBase.getEveryone();
        String last = String.valueOf(everyone.size());

        //RecyclerView
        listview = findViewById(R.id.listview_rv);

        listview.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        listview.setLayoutManager(layoutManager);

        mAdapter = new RecycleViewAdapter(everyone, this);
        listview.setAdapter(mAdapter);


    }


    // GO TO HOME PAGE WHEN BACK BUTTON IS PRESSED
    public void onBackPressed(){
        super.onBackPressed();
        Intent mainpage = new Intent(listsview_page.this,MainActivity.class);
        startActivity(mainpage);
    }
}