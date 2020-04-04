/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.activity.adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cl.ucn.disc.dsm.fuenz.chatdisc.R;
import cl.ucn.disc.dsm.fuenz.chatdisc.room.entity.User;
import cl.ucn.disc.dsm.fuenz.chatdisc.viewmodel.UserViewModel;

public class UserListAdapter extends RecyclerView
        .Adapter<UserListAdapter.UserViewHolder> {

    class UserViewHolder extends RecyclerView.ViewHolder{
        private final TextView username;
        private final TextView email;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.username_text);
            email = itemView.findViewById(R.id.email_text);
        }
    }

    private LayoutInflater mInflater;
    private List<User> allUser;

    public UserListAdapter(Context context){
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View itemView = mInflater.inflate(R.layout.rv_user,parent,false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position){
        if(allUser != null){
            User current = allUser.get(position);
            holder.username.setText(current.getUsername());
            holder.email.setText(current.getEmail());
        }else{
            holder.username.setText("No username");
            holder.email.setText("No email");
        }
    }

    public void setAllUser(List<User> users){
        allUser = users;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (allUser != null)
            return allUser.size();
        else return 0;
    }
}
