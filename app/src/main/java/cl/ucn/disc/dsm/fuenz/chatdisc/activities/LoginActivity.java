/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cl.ucn.disc.dsm.fuenz.chatdisc.R;

public class LoginActivity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*
        Email container
         */
        editTextEmail = findViewById(R.id.editEmail);
        /*
        Password container
         */
        editTextPassword = findViewById(R.id.editPassword);
        /*
        Button who send the request to login
         */
        btnLogin = findViewById(R.id.btnLogin);
        /*
        Button who will open a new activity to register
         */
        btnRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                TODO: Aca se debe enviar la peticion de usuario y contraseña para iniciar session
                 */

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Aca se debe agregar el registro de usuarios cuando se de el click


            }
        });

    }


}