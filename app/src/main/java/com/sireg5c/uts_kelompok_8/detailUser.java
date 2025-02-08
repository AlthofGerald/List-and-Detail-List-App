package com.sireg5c.uts_kelompok_8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class detailUser extends AppCompatActivity {
    public static final String DETAIL_USER = "DETAIL_USER";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Detail User");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_detail_user);
        ImageView profilPic = findViewById(R.id.picdett);
        TextView usernamedet = findViewById(R.id.usernamedett);
        TextView namedet = findViewById(R.id.nameDett);
        TextView role = findViewById(R.id.roleDett);
        TextView desc = findViewById(R.id.descDett);

        dataUser takeData = getIntent().getParcelableExtra(DETAIL_USER);
        if (takeData != null){
            profilPic.setImageResource(takeData.getProfilePhoto());
            usernamedet.setText(takeData.getUsername());
            namedet.setText(takeData.getName());
            role.setText(takeData.getRole());
            desc.setText(takeData.getDescc());
        }
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}