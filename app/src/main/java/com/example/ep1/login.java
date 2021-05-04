package com.example.ep1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class login extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnIngresar = findViewById(R.id.btnLogin);
        TextView textRegistrar = findViewById(R.id.textViewSignUp);
        TextView textForgotPassword = findViewById(R.id.textViewForgotPassword);

        btnIngresar.setOnClickListener(this);
        textRegistrar.setOnClickListener(this);
        textForgotPassword.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnLogin:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            case R.id.textViewSignUp:
                startActivity(new Intent(this, signup.class));
                break;
            case R.id.textViewForgotPassword:
                startActivity(new Intent(this, forgotPassword.class));
                break;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.nav_sobre_nosotros:
                mostrarSobreNosotros();
                return true;
            case R.id.nav_ayuda:
                mostrarAyuda();
                return true;
            case R.id.nav_acerca_de:
                mostrarAcercaDe();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void mostrarSobreNosotros() {
        startActivity(new Intent(this, sobre_nosotros.class));
    }
    private void mostrarAyuda() {
        startActivity(new Intent(this, ayuda.class));
    }
    private void mostrarAcercaDe() {
        startActivity(new Intent(this, acerca_de.class));
    }
}