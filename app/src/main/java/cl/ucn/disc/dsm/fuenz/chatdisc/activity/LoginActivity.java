/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cl.ucn.disc.dsm.fuenz.chatdisc.R;
import es.dmoral.toasty.Toasty;

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


        btnLogin.setOnClickListener(view -> {
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();


            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password) ){
                Toasty.error(this,"Please fill all fields correctly",Toast.LENGTH_SHORT,false).show();
                return;
            }


            Toasty.success(this, "Confirm", Toast.LENGTH_SHORT, true).show();
            // Get the username and is pass to the other activity
            String username = "Test";
            Intent intent = new Intent(this,UserActivity.class);
            intent.putExtra("username",username);
            startActivity(intent);
            /*
            TODO: Envio de peticion

            if(true)
            Intent intent = new Intent(this,UserActivity.class);
            startActivity(intent);
            else
                toast: email o password incorrecto

             */
        });


        /*
        En caso de hacer click en registrar, se eliminara la actividad Login y se creara la de registro.
         */
        btnRegister.setOnClickListener(view -> {
            Intent intent = new Intent(this,RegisterActivity.class);
            startActivity(intent);
        });

    }


}