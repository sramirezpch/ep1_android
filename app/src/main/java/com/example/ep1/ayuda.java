package com.example.ep1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

public class ayuda extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ArrayList arrayList = new ArrayList<HashMap<String,String>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        leerDatos();
    }

    private void leerDatos() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://servicios.campus.pe/servicioempleados.php";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("DATOS:", response);
                        Log.i("ONRESPONSE: ", "Entrando al response");
                        llenarLista(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("DATOS:", error.getMessage());
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private void llenarLista(String response) {
        try {
            Log.i("ONLIST: ", "Entrando a la función llenarLista()");
            Log.i("", "llenarLista()");
            JSONArray jsonArray = new JSONArray(response);
            for(int i= 0; i<jsonArray.length();i++){
                String idEmpleado = jsonArray.getJSONObject(i).getString("idempleado");
                String apellidos = jsonArray.getJSONObject(i).getString("apellidos");
                String nombre = jsonArray.getJSONObject(i).getString("nombres");
                String telefono = jsonArray.getJSONObject(i).getString("telefono");
                HashMap<String,String> map = new HashMap<>();
                map.put("idEmpleado", idEmpleado);
                map.put("apellidos", apellidos);
                map.put("nombres", nombre);
                map.put("telefono", telefono);
                arrayList.add(map);
            }

            ListView lvEmpleados = findViewById(R.id.lvEmpleados);
            String[] datos = {"idEmpleado","apellidos","nombres", "telefono"};
            int[] ids = {R.id.txvIdEmpleado,  R.id.txvApellido, R.id.txvNombreEmpleado, R.id.txvTelefono};

            ListAdapter listAdapter = new SimpleAdapter(
                    this,
                    arrayList,
                    R.layout.item_empleados,
                    datos,
                    ids
            );

            lvEmpleados.setAdapter(listAdapter);
            lvEmpleados.setOnItemClickListener(this);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        HashMap<String,String> map = (HashMap<String, String>) arrayList.get(position);
        String nombres = map.get("nombres");
        String apellidos = map.get("apellidos");

        Toast.makeText(this,"Enviar un email a " + nombres + " " + apellidos,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}