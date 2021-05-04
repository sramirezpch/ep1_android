package com.example.ep1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

public class cuenta_rl extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta_rl);

        RadioButton mrbEditar = findViewById(R.id.rbEditar);
        ImageView imgIrSeguimiento = findViewById(R.id.imgIrSeguimiento);
        ImageView imgRegresar = findViewById(R.id.imgRegresar);

        mrbEditar.setOnClickListener(this);//para ir de cuenta_rl a PerfilFragment
        imgIrSeguimiento.setOnClickListener(this);//Para ir de cuenta_rl a Tracking_rl
        imgRegresar.setOnClickListener(this);//para regresar de PerfilFragment a cuenta_rl
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.rbEditar:
                startActivity(new Intent(this, PerfilFragment.class));
                finish();
                break;
            case R.id.imgIrSeguimiento:
                startActivity(new Intent(this, Tracking_rl.class));
                break;
            case R.id.imgRegresar:
                startActivity(new Intent(this, cuenta_rl.class));
                finish();
                break;
            case R.id.imgIrTarjetas:
                startActivity(new Intent(this, TarjetaActivity2.class));
                break;
        }
    }
}