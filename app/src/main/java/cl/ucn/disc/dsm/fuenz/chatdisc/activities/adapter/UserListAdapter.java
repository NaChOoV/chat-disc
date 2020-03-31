/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.activities.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cl.ucn.disc.dsm.fuenz.chatdisc.R;
import cl.ucn.disc.dsm.fuenz.chatdisc.room.entity.User;
import cl.ucn.disc.dsm.fuenz.chatdisc.viewmodel.UserViewModel;

public class UserListAdapter extends RecyclerView
        .Adapter<UserListAdapter.UserViewHolder> {

    class UserViewHolder extends RecyclerView.ViewHolder{

        private final TextView userItemView;

        private UserViewHolder(View itemView){
            super(itemView);
            userItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater userInflater;
    private List<User> users;

    public UserListAdapter(Context context){
        userInflater = LayoutInflater.from(context);
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int position){
        View itemView = userInflater.inflate(R.layout.rv_user,parent,false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        if (users != null) {
            User current = users.get(position);
            holder.userItemView.setText(current.getUsername());
        } else {
            // Covers the case of data not being ready yet.
            holder.userItemView.setText("No users");
        }
    }

    @Override
    public int getItemCount() {
        if (users != null)
            return users.size();
        else return 0;
    }

}
