package com.sireg5c.uts_kelompok_8;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class createListuser extends RecyclerView.Adapter<createListuser.ListViewHolder> {
    private ArrayList<dataUser> listdataUser;

    //interface agar rv dapat di klik
    private OnItemClickCallback onItemClickCallback;
    public interface OnItemClickCallback {
        void onItemClicked(dataUser data);
    }
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }


    public createListuser(ArrayList<dataUser> list) {
        this.listdataUser = list;
    }

    //layout/template item recycler view
    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvRole, tvUserName;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.photo);
            tvName = itemView.findViewById(R.id.name);
            tvUserName = itemView.findViewById(R.id.userName);
            tvRole = itemView.findViewById(R.id.roleUser);

        }
    }

    //set recycler view
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_create_listuser, parent, false);
        return new ListViewHolder(view);
    }

    //memasukan data ke item recycler view
    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        dataUser createlist = listdataUser.get(position);
        holder.imgPhoto.setImageResource(createlist.getProfilePhoto());
        holder.tvName.setText(createlist.getName());
        holder.tvRole.setText(createlist.getRole());
        holder.tvUserName.setText(createlist.getUsername());



        //perintah agar item recycler view dapat diklik
        //holder.itemView -> seluruh item dapat diklik, holder.imgPhoto hanya photo yang dapat diklik dst.
        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(listdataUser.get(holder.getAdapterPosition())));

    }

    @Override
    public int getItemCount() {
        return listdataUser.size();
    }
}