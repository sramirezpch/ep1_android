package com.example.ep1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imagenUsuario = findViewById(R.id.imgUsuario);
        SearchView buscarProductos = findViewById(R.id.searchProductos);
        LinearLayout beatsLayout = findViewById(R.id.layoutBeats);

        imagenUsuario.setOnClickListener(this);
        buscarProductos.setOnClickListener(this);
        beatsLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.imgUsuario:
                startActivity(new Intent(this, cuenta_rl.class));
                break;
            case R.id.layoutBeats:
                startActivity(new Intent(this, ProductoActivity.class));
                break;
            case R.id.searchProductos:
                startActivity(new Intent(this, Producto2Activity.class));
                break;
        }
    }
}