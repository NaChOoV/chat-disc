/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cl.ucn.disc.dsm.fuenz.chatdisc.R;
import cl.ucn.disc.dsm.fuenz.chatdisc.activity.adapter.MessageListAdapter;
import cl.ucn.disc.dsm.fuenz.chatdisc.activity.session.UserSession;
import cl.ucn.disc.dsm.fuenz.chatdisc.room.entity.Message;
import cl.ucn.disc.dsm.fuenz.chatdisc.room.entity.User;
import cl.ucn.disc.dsm.fuenz.chatdisc.viewmodel.MessageViewModel;
import cl.ucn.disc.dsm.fuenz.chatdisc.viewmodel.factory.MessageViewModelFactory;
import es.dmoral.toasty.Toasty;

public class ConversationActivity extends AppCompatActivity {

    private MessageViewModel messageViewModel;

    private TextView messageTextView;

    private Button sendButton;

    private UserSession userSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        Intent i = getIntent();
        this.userSession = (UserSession) i.getSerializableExtra("userSession");

        TextView welcomeText = findViewById(R.id.toolbar_text);
        messageTextView = findViewById(R.id.edittext_chatbox);
        sendButton = findViewById(R.id.button_chatbox_send);
        welcomeText.setText(userSession.getSecondUsername());

        //The toolbar
        Toolbar toolbar = findViewById(R.id.conversation_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        final MessageListAdapter adapter = new MessageListAdapter(this,userSession.getUserId());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        // The factory viewmodel to pass two values
        MessageViewModelFactory factory = new MessageViewModelFactory(this.getApplication(),
                userSession.getUserId(),
                userSession.getSecondUserId());
        messageViewModel = new ViewModelProvider(this,factory).get(MessageViewModel.class);
        messageViewModel.getAllMessage().observe(this, new Observer<List<Message>>() {
            @Override
            public void onChanged(@Nullable List<Message> messages) {
                adapter.setMessage(messages);
            }
        });


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = messageTextView.getText().toString();

                if(message.isEmpty())
                    return;

                int userOne = userSession.getUserId();
                int userTwo = userSession.getSecondUserId();

                messageViewModel.insert(userOne,userTwo,message);
                messageTextView.setText("");

            }
        });



        //The backbutton
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}