package com.openclassrooms.entrevoisins.ui.neighbour_list;

import static com.openclassrooms.entrevoisins.ui.neighbour_list.MyNeighbourRecyclerViewAdapter.NEIGBOURG_KEYS;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import java.lang.annotation.Target;

public class Activity_detail_voisin extends AppCompatActivity {

    Toolbar mToolbar;

    TextView mNom, mAdress, mTelephone, mSiteInternet, mAPropos, mIdProfile;

    ImageView mPhotoProfile;

    FloatingActionButton mFavoritBouton;

    private NeighbourApiService mApiService ;

    Neighbour neighbour;





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
       mFavoritBouton = findViewById(R.id.bouton_flottan);

        mApiService = DI.getNeighbourApiService();

        configureToolbar();

       initview();

        clikFavoris ();
        changeFavoris();


    }

    private void configureToolbar(){

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void initview(){

        Intent intent = getIntent();
        neighbour = intent.getParcelableExtra(NEIGBOURG_KEYS);

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

    private void clikFavoris (){

        mFavoritBouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mApiService.IsFavoris(neighbour)){

                    mApiService.removeFromeFavoris(neighbour);
                    changeFavoris();

                }else {

                    mApiService.addVoisinFavoris(neighbour);
                    changeFavoris();
                }
            }
        });

    }

    private void changeFavoris(){

        if (mApiService.IsFavoris(neighbour)){

            mFavoritBouton.setImageResource(R.drawable.start_full);

        }else {

            mFavoritBouton.setImageResource(R.drawable.star_yellow_free);
        }

    }

}