package com.clubesuvigo.sunshine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public String error_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        final EditText nombre_editText = (EditText) findViewById(R.id.nombre_login);
        final EditText contraseña_editText = (EditText) findViewById(R.id.contraseña_login);
        final EditText repite_contraseña = (EditText) findViewById(R.id.repetir_contraseña_login);
        Button enviar_button = (Button) findViewById(R.id.button_enviar);
        enviar_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre_string = nombre_editText.getText().toString();
                String contraseña_string = contraseña_editText.getText().toString();
                String repitecontraseña_string = repite_contraseña.getText().toString();

                int result = validarDatos(nombre_string,contraseña_string,repitecontraseña_string);

                if(result==1){
                    Toast.makeText(LoginActivity.this, "Conectado con exito", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, getString(error_login),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private String getString(String error_login) {
        return error_login;
    }

    public int validarDatos(String nombre_string, String contraseña_string, String repitecontraseña_string) {
        int DATOS_OK = 0;
        if(nombre_string.isEmpty() == false) {
            if (nombre_string.length() > 3) {
                if (contraseña_string.isEmpty() == false) {
                    if (contraseña_string.length() > 6) {
                        if (contraseña_string.contentEquals(repitecontraseña_string)) {
                            DATOS_OK = 1;
                        } else {
                            error_login = "Las contraseñas no son iguales.";
                            DATOS_OK = 0;
                        }
                    } else {
                        error_login = "La contraseña debe contener al menos 7 caracteres.";
                        DATOS_OK = 0;
                    }
                } else {
                    error_login = "Debes escribir una contraseña.";
                    DATOS_OK = 0;
                }
            } else {
                error_login = "El nombre de usuario debe contener al menos 4 caracteres.";
                DATOS_OK = 0;
            }
        }else{
            error_login = "Debes escribir un nombre de usuario";
            DATOS_OK = 0;
        }
        return DATOS_OK;
    }

}
