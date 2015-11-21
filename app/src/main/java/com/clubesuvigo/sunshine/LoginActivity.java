package com.clubesuvigo.sunshine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private static final int DATOS_OK = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

                if(result==DATOS_OK){
                    Toast.makeText(LoginActivity.this, nombre_string, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private int validarDatos(String nombre_string, String contraseña_string, String repitecontraseña_string) {

        return DATOS_OK;
    }

}
