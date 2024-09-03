package com.example.cs_ia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class addlist_page extends AppCompatActivity {

    private EditText addlist;
    private TextView cancelbtn, donebtn;
    private ImageView listicon, iconaddlist;
    private ImageView backpack;
    private ImageView book;
    private ImageView listicon2;
    private ImageView coding;
    private ImageView football;
    private ImageView music;
    private ImageView shopping;
    private ImageView location;
    private ImageView medicine;
    private ImageView repair;
    private ImageView dining;
    private ImageView stationary;
    private ImageView tent;
    private ImageView tv;
    private ImageView umbrella;
    int [] images={R.drawable.addlistimageback,R.drawable.listimage,R.drawable.backpackicon,R.drawable.bookicon,R.drawable.footballicon,R.drawable.musicicon,R.drawable.shoppingicon,R.drawable.locationicon,R.drawable.medicineicon,R.drawable.codingicon,R.drawable.repairicon,R.drawable.diningicon,R.drawable.stationaryicon,R.drawable.tenticon,R.drawable.tvicon,R.drawable.umbrellaicon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlist_page);
        cancelbtn=findViewById(R.id.cancel);
        donebtn=findViewById(R.id.donebtn);
        addlist = findViewById(R.id.listname);
        iconaddlist = findViewById(R.id.iconaddlist);
        addlist.addTextChangedListener(addlistnamewatcher);

        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainpage = new Intent(addlist_page.this,MainActivity.class);
                startActivity(mainpage);
            }
        });


        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listview = new Intent(addlist_page.this, listsview_page.class);

                listName_model listNameModel;
                try {
                    String list_name = addlist.getText().toString();
                    listNameModel = new listName_model(-1, list_name);
                    Toast.makeText(addlist_page.this, "Success", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(addlist_page.this, "Unsuccessful", Toast.LENGTH_SHORT).show();
                    listNameModel = new listName_model(-1, "error");
                }

                dataBaseHelper dataBaseHelper = new dataBaseHelper(addlist_page.this);
                boolean success = dataBaseHelper.addone(listNameModel);
                Toast.makeText(addlist_page.this, "Data Entered", Toast.LENGTH_SHORT).show();

                startActivity(listview);
            }

        });

        iconclick();
    }

    //ICON SELECTER
    public void iconclick(){
        listicon=(ImageView)findViewById(R.id.iconaddlist);
        backpack=(ImageView)findViewById(R.id.backpackicon);
        book=(ImageView)findViewById(R.id.bookicon);
        listicon2=(ImageView)findViewById(R.id.listicon);
        football=(ImageView)findViewById(R.id.footballicon);
        music=(ImageView)findViewById(R.id.musicicon);
        shopping=(ImageView)findViewById(R.id.shoppingicon);
        location=(ImageView)findViewById(R.id.locationicon);
        medicine=(ImageView)findViewById(R.id.medicineicon);
        coding=(ImageView)findViewById(R.id.codingicon);
        repair=(ImageView)findViewById(R.id.repairicon);
        dining=(ImageView)findViewById(R.id.diningicon);
        stationary=(ImageView)findViewById(R.id.stationaryicon);
        tent=(ImageView)findViewById(R.id.tenticon);
        tv=(ImageView)findViewById(R.id.tvicon);
        umbrella=(ImageView)findViewById(R.id.umbrellaicon);


        listicon2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listicon.setImageResource(images[1]);
                    }
                }
        );
        backpack.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listicon.setImageResource(images[2]);

                    }
                }
        );
        book.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listicon.setImageResource(images[3]);
                    }
                }
        );
        football.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listicon.setImageResource(images[4]);
                    }
                }
        );
        music.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listicon.setImageResource(images[5]);
                    }
                }
        );
        shopping.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listicon.setImageResource(images[6]);
                    }
                }
        );
        location.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listicon.setImageResource(images[7]);
                    }
                }
        );
        medicine.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listicon.setImageResource(images[8]);
                    }
                }
        );
        coding.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listicon.setImageResource(images[9]);
                    }
                }
        );
        repair.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listicon.setImageResource(images[10]);
                    }
                }
        );
        dining.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listicon.setImageResource(images[11]);
                    }
                }
        );
        stationary.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listicon.setImageResource(images[12]);
                    }
                }
        );
        tent.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listicon.setImageResource(images[13]);
                    }
                }
        );
        tv.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listicon.setImageResource(images[14]);
                    }
                }
        );
        umbrella.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listicon.setImageResource(images[15]);
                    }
                }
        );

    }

    //TEXT WATCHER
    private final TextWatcher addlistnamewatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(s.toString().trim().length() == 0){
                donebtn.setVisibility(View.INVISIBLE);
            }
            else {
                donebtn.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void afterTextChanged(Editable s) {


        }
    };
}