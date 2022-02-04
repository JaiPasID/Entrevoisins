package com.openclassrooms.entrevoisins.ui.neighbour_list;

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


       setSupportActionBar(mToolbar);

       getSupportActionBar().setDisplayHomeAsUpEnabled(true);


       Intent intent = getIntent();
       Neighbour id = intent.getParcelableExtra("Neighbourg");

        String name = id.getName();
        String adresse = id.getAddress();
        String tel = id.getPhoneNumber();
        String site = id.getSiteInternet();
        String aPropos = id.getAboutMe();


        Glide.with(mPhotoProfile.getContext())
                .load(id.getAvatarUrl())
                .override(400,250) // le syteme ne veut rien savoir
                .into(mPhotoProfile);



        mNom.setText(name);
        mAdress.setText(adresse);
        mTelephone.setText(tel);
        mSiteInternet.setText(site);
        mAPropos.setText(aPropos);
        mIdProfile.setText(name);

    }
}