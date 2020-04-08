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
import cl.ucn.disc.dsm.fuenz.chatdisc.activity.session.UserSession;
import cl.ucn.disc.dsm.fuenz.chatdisc.viewmodel.service.ConnectionHandler;
import es.dmoral.toasty.Toasty;
import kotlin.Triple;

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



            ConnectionHandler connectionHandler = new ConnectionHandler();


            final Triple<Integer,Integer,String> response
                    = connectionHandler.loginHandler(email,password);


            switch (response.getFirst()){
                case 0:
                    Toasty.success(this, "Login succesful", Toast.LENGTH_SHORT, true).show();
                    Intent intent = new Intent(this,UserActivity.class);
                    // Get the username and userId form database and is pass to the other activity
                    UserSession userSession = new UserSession(response.getThird(),response.getSecond());
                    intent.putExtra("userSession",userSession);
                    startActivity(intent);
                    break;
                case 1:
                    //Credenciales incorrectas
                    Toasty.warning(this,"Unknown login credential ",Toast.LENGTH_SHORT,true).show();
                case 2:
                    //ERROR de conexion
                    Toasty.error(this,"Connection error",Toast.LENGTH_SHORT,true).show();
                    break;
                default:
                    //Codigo desconocido
                    Toasty.error(this,"Unknown status code",Toast.LENGTH_SHORT,true).show();
                    break;
            }

        });


        btnRegister.setOnClickListener(view -> {
            Intent intent = new Intent(this,RegisterActivity.class);
            startActivity(intent);
        });

    }


}