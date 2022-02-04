package com.openclassrooms.entrevoisins.ui.neighbour_list;

import static com.openclassrooms.entrevoisins.ui.neighbour_list.MyNeighbourRecyclerViewAdapter.NEIGBOURG_KEYS;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

import java.lang.annotation.Target;

public class Activity_detail_voisin extends AppCompatActivity {

    Toolbar mToolbar;

    TextView mNom, mAdress, mTelephone, mSiteInternet, mAPropos, mIdProfile;

    ImageView mPhotoProfile;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_voisin);

       mToolbar = findViewById(R.id.nameToolbar);
       mNom = findViewById(R.id.nom);
       mAdress = findViewById(R.id.adress);
       mTelephone = findViewById(R.id.telephone);
       mSiteInternet = findViewById(R.id.site_internet);
       mAPropos = findViewById(R.id.a_propos_de_moi);
       mPhotoProfile = findViewById(R.id.photoProfil);
       mIdProfile = findViewById(R.id.id_profile);



        ConfigureToolbar();

       Initview();




    }

    private void ConfigureToolbar(){

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void Initview(){

        Intent intent = getIntent();
        Neighbour neighbour = intent.getParcelableExtra(NEIGBOURG_KEYS);

        String name = neighbour.getName();
        String adresse = neighbour.getAddress();
        String tel = neighbour.getPhoneNumber();
        String site = neighbour.getSiteInternet();
        String aPropos = neighbour.getAboutMe();


        Glide.with(mPhotoProfile.getContext())
                .load(neighbour.getAvatarUrl())
                .into(mPhotoProfile);

        mNom.setText(name);
        mAdress.setText(adresse);
        mTelephone.setText(tel);
        mSiteInternet.setText(site);
        mAPropos.setText(aPropos);
        mIdProfile.setText(name);

    }
}