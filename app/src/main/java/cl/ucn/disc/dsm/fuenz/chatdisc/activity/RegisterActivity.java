/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.activity;

import androidx.appcompat.app.AppCompatActivity;
import cl.ucn.disc.dsm.fuenz.chatdisc.R;
import cl.ucn.disc.dsm.fuenz.chatdisc.viewmodel.service.ConnectionHandler;
import cl.ucn.disc.dsm.fuenz.chatdisc.viewmodel.service.IConnectionHandler;
import es.dmoral.toasty.Toasty;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    /*
        Username, Password, Email input container
    */
    EditText editTextEmail, editTextPassword, editTextUsername;
    /*
    Register and Return to login button
     */
    Button btnRegister, btnReturn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextUsername = findViewById(R.id.editTextTextPersonName);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        btnRegister = findViewById(R.id.button);
        btnReturn = findViewById(R.id.btnReturn);


        //En caso de hacer click
        btnRegister.setOnClickListener(view -> {

            String email = editTextEmail.getText().toString();
            String username = editTextUsername.getText().toString();
            String password = editTextUsername.getText().toString();

            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(username)  ){
                Toasty.error(this,"Please fill all fields correctly",Toast.LENGTH_SHORT,false).show();
                return;
            }

            // Peticion al servidor
            ConnectionHandler connectionHandler = new ConnectionHandler();

            final int code = connectionHandler.registerHandler(email,username,password);

            switch (code){
                case 0:
                    // Usuario registrado correctamente
                    Toasty.success(this,"You have successfully registered",Toast.LENGTH_SHORT,true).show();
                    returnToLogin();
                    break;
                case 1:
                    // Email ya registrado
                    Toasty.warning(this,"This email is already registered",Toast.LENGTH_SHORT,true).show();
                    break;
                case 2:
                    // Username ya registrado
                    Toasty.warning(this,"Username alredy taken",Toast.LENGTH_SHORT,true).show();
                    break;
                case 3:
                    //Error en la conexion
                    Toasty.error(this,"Connection error",Toast.LENGTH_SHORT,true).show();
                    break;
                default:
                    // Codigo desconocido
                    Toasty.error(this,"Unknown status code",Toast.LENGTH_SHORT,true).show();
                    break;

            }


        });


        /*
        Se retornara a la actividad de login y se eliminara la de registro.
         */
        btnReturn.setOnClickListener(view -> {
            returnToLogin();

        });
    }

    private void returnToLogin(){
        Intent intent = new Intent(this,LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}