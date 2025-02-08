package com.sireg5c.uts_kelompok_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView listRV;
    private ArrayList<dataUser> listdataUser = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listRV = findViewById(R.id.rvUser);
        listRV.setHasFixedSize(true);

        listdataUser.addAll(getListUser());
        showRecyclerList();
    }

    public ArrayList<dataUser> getListUser() {
        //mengambil data dari file res/values/strings.xml
        String[] dataName = getResources().getStringArray(R.array.dataname);
        String[] dataUsername = getResources().getStringArray(R.array.datausername);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.profilePhoto);
        String[] roleInfo = getResources().getStringArray(R.array.dataRoles);
        String[] descUserr = getResources().getStringArray(R.array.dataDes);

        //memasukan data ke tiap recycler view ke kelas dataUser, var createData digunakan untuk memanggil method kelas
        ArrayList<dataUser> listRVuser = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            dataUser createData = new dataUser();
            createData.setName(dataName[i]);
            createData.setUsername(dataUsername[i]);
            createData.setRole(roleInfo[i]);
            createData.setDescc(descUserr[i]);
            createData.setProfilePhoto(dataPhoto.getResourceId(i, -1));
            listRVuser.add(createData);
        }
        return listRVuser;
    }

    private void showRecyclerList(){
        //menampilkan Recycler view
        listRV.setLayoutManager(new LinearLayoutManager(this));
        createListuser listuser = new createListuser(listdataUser);
        listRV.setAdapter(listuser);

        //kode saat item di recycler view di klik, yang menuju ke kelas detailUser menggunakan intent
        listuser.setOnItemClickCallback(new createListuser.OnItemClickCallback() {
            @Override
            public void onItemClicked(dataUser data) {
                Intent intent =new Intent(MainActivity.this,detailUser.class);
                intent.putExtra(detailUser.DETAIL_USER,data);
                startActivity(intent);
            }
        });
    }

}