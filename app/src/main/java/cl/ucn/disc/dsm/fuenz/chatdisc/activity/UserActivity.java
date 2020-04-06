/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cl.ucn.disc.dsm.fuenz.chatdisc.R;
import cl.ucn.disc.dsm.fuenz.chatdisc.activity.adapter.UserListAdapter;
import cl.ucn.disc.dsm.fuenz.chatdisc.activity.session.UserSession;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.model.Conversation;
import cl.ucn.disc.dsm.fuenz.chatdisc.room.entity.User;
import cl.ucn.disc.dsm.fuenz.chatdisc.viewmodel.UserViewModel;
import es.dmoral.toasty.Toasty;

public class UserActivity extends AppCompatActivity {

    private UserViewModel userViewModel;

    private UserSession userSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        // Get the username and put on the toolbar
        Intent i = getIntent();
        userSession = (UserSession) i.getSerializableExtra("userSession");

        TextView welcomeText = findViewById(R.id.welcomeTextview);
        welcomeText.setText("Welcome " + userSession.getUsername());


        //The recyclerView of users
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        final UserListAdapter adapter = new UserListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getAllUser().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                adapter.setAllUser(users);
            }
        });

        adapter.setOnUserClickListener(new UserListAdapter.OnUserClickListener() {
            @Override
            public void onUserClick(User user) {
                startConversation(user);
            }
        });

    }

    private void startConversation(User user){
        Intent intent = new Intent(this,ConversationActivity.class);
        this.userSession.setSecondUserId(user.getUserId());
        this.userSession.setSecondUsername(user.getUsername());
        intent.putExtra("userSession",this.userSession);
        startActivity(intent);
    }
}