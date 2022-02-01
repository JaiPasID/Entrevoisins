package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.openclassrooms.entrevoisins.R;

public class Activity_detail_voisin extends AppCompatActivity {

    ImageButton mRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_voisin);

        mRetour = findViewById(R.id.bouton_retour);

        mRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_detail_voisin.this, MyNeighbourRecyclerViewAdapter.class);
                startActivity(intent);
            }
        });

    }
}