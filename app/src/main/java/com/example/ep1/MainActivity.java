package com.example.ep1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imagenUsuario = findViewById(R.id.imgUsuario);
        TextView verProductos = findViewById(R.id.txtSeeAll);

        imagenUsuario.setOnClickListener(this);
        verProductos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.imgUsuario:
                startActivity(new Intent(this, cuenta_rl.class));
                break;
            case R.id.txtSeeAll:
                startActivity(new Intent(this, Producto2Activity.class));
                break;
            case R.id.layoutBeats:
                break;
            case R.id.layoutBandO:
                break;
        }
    }
}