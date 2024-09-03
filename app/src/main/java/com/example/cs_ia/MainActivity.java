package com.example.cs_ia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView newreminder = findViewById(R.id.newreminder);
        newreminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reminderpage = new Intent(MainActivity.this,reminder_page.class);
                startActivity(reminderpage);
            }
        });
        TextView addlist1 = findViewById(R.id.addlist);
        addlist1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addlistpage = new Intent(MainActivity.this,addlist_page.class);
                startActivity(addlistpage);

            }
        });

        TextView listdirect = findViewById(R.id.todolist);
        listdirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listspage = new Intent(MainActivity.this,listsview_page.class);
                startActivity(listspage);

            }
        });

        //HOME PAGE DISPLAY OF NUMBER OF LISTS
        dataBaseHelper dataBase = new dataBaseHelper(MainActivity.this);
        List<listName_model> everyone = dataBase.getEveryone();
        String last = String.valueOf(everyone.size());
        TextView todolistnum = findViewById(R.id.todolistnum);
        todolistnum.setText(last);


    }
}