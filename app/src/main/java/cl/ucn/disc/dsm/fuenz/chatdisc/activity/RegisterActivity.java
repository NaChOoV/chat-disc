/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.activity;

import androidx.appcompat.app.AppCompatActivity;
import cl.ucn.disc.dsm.fuenz.chatdisc.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword, editTextUsername;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        /*
        Email container
         */
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        /*
        Username container
         */
        editTextUsername = findViewById(R.id.editTextTextPersonName);
        /*
        Password container
         */
        editTextPassword = findViewById(R.id.editTextTextPassword);

        /*
        Button who will send a post to create a new user
         */
        btnRegister = findViewById(R.id.button);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Aca se debe agregar el registro de usuarios cuando se de el click


            }
        });
    }
}