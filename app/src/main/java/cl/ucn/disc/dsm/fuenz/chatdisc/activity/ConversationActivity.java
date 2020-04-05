/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cl.ucn.disc.dsm.fuenz.chatdisc.R;
import cl.ucn.disc.dsm.fuenz.chatdisc.activity.session.UserSession;

public class ConversationActivity extends AppCompatActivity {

    private UserSession userSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        Intent i = getIntent();
        this.userSession = (UserSession) i.getSerializableExtra("userSession");

        TextView welcomeText = findViewById(R.id.toolbar_text);
        welcomeText.setText("Welcome " + userSession.getSecondUserId());


        //The toolbar
        Toolbar toolbar = findViewById(R.id.conversation_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);

        //The backbutton
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}