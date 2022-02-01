package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

public class Activity_detail_voisin extends AppCompatActivity {

    Toolbar mToolbar;
    Intent intent =  getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_voisin);

       mToolbar = findViewById(R.id.nameToolbar);

       setSupportActionBar(mToolbar);

       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       mToolbar.setTitle("Caroline");



       if (intent != null){
           Neighbour neighbour = intent.getParcelableExtra("Neighbourg");
           if (neighbour != null){
               neighbour.getName();
               neighbour.getAvatarUrl();
               neighbour.getAddress();
               neighbour.getPhoneNumber();
               neighbour.getPhoneNumber();
               neighbour.getSiteInternet();
           }
       }

    }
}