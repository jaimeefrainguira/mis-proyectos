package com.hugo.empresa.buscandoando.configuracion;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.hugo.empresa.buscandoando.R;
import com.hugo.empresa.buscandoando.VolleyRP;
import com.hugo.empresa.buscandoando.dominio;
import com.hugo.empresa.buscandoando.login;
import com.hugo.empresa.buscandoando.loginmenbrecia;
import com.hugo.empresa.buscandoando.menu;
import com.hugo.empresa.buscandoando.modelo.ciudad;
import com.hugo.empresa.buscandoando.modelo.provincia;
import com.hugo.empresa.buscandoando.preferences;
import com.hugo.empresa.buscandoando.registro;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class crudnegocio extends AppCompatActivity {
    private VolleyRP volley;
    private RequestQueue mresq;
    private Button btnActualizar,btnEliminar;
    private EditText neg_nombre;
    private EditText neg_descripcion;
    private  EditText neg_direccion;
    private EditText neg_telefono;
    private EditText neg_celular;
    private Spinner spProvincia;
    private Spinner spCiudad;
    private static  final  String IP_REGISTRA_NEGOCIO=dominio.dominio+"BuscandoAndo/Controlador/registraNegocio.php";
    private static  final  String IP_ELIMINA_NEGOCIO=dominio.dominio+"BuscandoAndo/Controlador/eliminaDatosNegocio.php";
    private static  final  String IP_ACTUALIZA_DATOS_NEGOCIO=dominio.dominio+"BuscandoAndo/Controlador/actualizaDatosNegocio.php";
    private static final String IP_CIUDAD=dominio.dominio+"BuscandoAndo/Controlador/consultaCiudad.php?id=";
    private static final String IP_PROVINCIA =dominio.dominio+"BuscandoAndo/Controlador/consultaProvincia.php";
    private static final String IP_CONSULTA_NEGOCIO=dominio.dominio+"BuscandoAndo/Controlador/consultaNegocioXId.php?id=";
    public String Mi_provincia;
    public String Mi_ciudad;
    public String neg_provincia;
    public String neg_ciudad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudnegocio);
        volley=VolleyRP.getInstance(this);
        mresq=volley.getRequestQueue();
        neg_nombre=(EditText)findViewById(R.id.txtnombrenegocio);
        neg_descripcion=(EditText)findViewById(R.id.txtdescripcion);
        neg_direccion=(EditText)findViewById(R.id.txtdireccion);
        neg_telefono=(EditText)findViewById(R.id.txttelefono);
        neg_celular=(EditText)findViewById(R.id.txtcelular);
        spProvincia=(Spinner)findViewById(R.id.spprovincia);
        spCiudad=(Spinner)findViewById(R.id.spciudad);
        btnActualizar=(Button)findViewById(R.id.btnActualizar);
        btnEliminar=(Button)findViewById(R.id.btnEliminar);
        Intent i=getIntent();
        final Bundle bundle=i.getExtras();
        if(bundle != null){
           Toast.makeText(crudnegocio.this,bundle.getString("key_idNegocio"),Toast.LENGTH_SHORT).show();
            String id=bundle.getString("key_idNegocio");
            SolicitaNegocio(IP_CONSULTA_NEGOCIO+id);
        }
        //actualizo los datos del negocio
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder=new AlertDialog.Builder(crudnegocio.this);
                builder.setIcon(R.drawable.logo);
                builder.setTitle("Mensaje de confirmación");
                builder.setMessage("Deseas actualizar este registro.");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent dato=getIntent();
                        Bundle bundledato=dato.getExtras();
                        if(bundledato != null){
                            String id_actualizaNegocio=bundledato.getString("key_idNegocio");
                            if(id_actualizaNegocio != null) {
                                Toast.makeText(crudnegocio.this, bundle.getString("key_idNegocio"), Toast.LENGTH_SHORT).show();
                                actualizaDatosNegocio(id_actualizaNegocio, neg_nombre.getText().toString(), neg_descripcion.getText().toString(), Mi_provincia, Mi_ciudad, neg_direccion.getText().toString(), neg_telefono.getText().toString(), neg_celular.getText().toString());
                            }else{
                                Toast.makeText(crudnegocio.this,"Se necesita un codigo.",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(crudnegocio.this,"No se encuentra el dato.",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();

            }
        });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        AlertDialog.Builder builder=new AlertDialog.Builder(crudnegocio.this);
                        builder.setIcon(R.drawable.logo);
                        builder.setTitle("Mensaje de confirmación");
                        builder.setMessage("Deseas eliminar este registro.");
                        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent datosElimina=getIntent();
                                Bundle bundleElimina=datosElimina.getExtras();
                                if(bundleElimina != null){
                                String id_EliminaNegocio=bundleElimina.getString("key_idNegocio");
                                if(id_EliminaNegocio != null){
                                EliminaDatosNegocio(id_EliminaNegocio);
                                }else{
                                    Toast.makeText(crudnegocio.this,"Se necesita un codigo.",Toast.LENGTH_SHORT).show();
                                }
                                }else{
                                    Toast.makeText(crudnegocio.this,"No se encuentra el dato.",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        AlertDialog alertDialog=builder.create();
                        alertDialog.show();
            }
        });
 }
    public void SolicitaNegocio(String URL){
        JsonObjectRequest solicitud=new JsonObjectRequest(URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject datos) {
                cargaNegocio(datos);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(crudnegocio.this,"No se logro conectar con el servidor",Toast.LENGTH_SHORT).show();
            }
        });
        VolleyRP.addToQueue(solicitud,mresq,this,volley);
    }
    public void cargaNegocio(JSONObject datos){
        try {
            JSONObject jsondatos=new JSONObject(datos.getString("id"));
            neg_nombre.setText(jsondatos.getString("neg_nombre"));
            neg_descripcion.setText(jsondatos.getString("neg_descripcion"));
            neg_direccion.setText(jsondatos.getString("neg_direccion"));
            neg_provincia=jsondatos.getString("neg_provincia");
            neg_ciudad=jsondatos.getString("neg_ciudad");
            neg_telefono.setText(jsondatos.getString("neg_telefono"));
            neg_celular.setText(jsondatos.getString("neg_celular"));
            //solicito provincia
            SolicitarProvincia(IP_PROVINCIA);
            Toast.makeText(this,neg_provincia,Toast.LENGTH_SHORT).show();
            spProvincia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String provincia=spProvincia.getItemAtPosition(spProvincia.getSelectedItemPosition()).toString();
                    Mi_provincia=provincia;
                    SolicitaCiudad(IP_CIUDAD+Mi_provincia);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            spCiudad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String ciudad=spCiudad.getItemAtPosition(spCiudad.getSelectedItemPosition()).toString();
                    Mi_ciudad=ciudad;

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            //if(id_usuario != null){

            //}else{
                //Toast.makeText(this,"Se necesita un codigo.",Toast.LENGTH_SHORT).show();
            //}
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    //Método para obtener la posición de un ítem del spinner
    public static int obtenerPosicionItem(Spinner spinner, String item) {
        //Creamos la variable posicion y lo inicializamos en 0
        int posicion = 0;
        //Recorre el spinner en busca del ítem que coincida con el parametro `String fruta`
        //que lo pasaremos posteriormente
        for (int i = 0; i < spinner.getCount(); i++) {
            //Almacena la posición del ítem que coincida con la búsqueda
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(item)) {
                posicion = i;
            }
        }
        //Devuelve un valor entero (si encontro una coincidencia devuelve la
        // posición 0 o N, de lo contrario devuelve 0 = posición inicial)
        return posicion;
    }
    public void SolicitarProvincia(String URL){
        StringRequest solicitud=new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {

            public void onResponse(String datos) {
                cargaProvincia(datos);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(crudnegocio.this,"No se logro conectar con el servidor",Toast.LENGTH_SHORT).show();
            }
        });

        VolleyRP.addToQueue(solicitud,mresq,this,volley);
    }
    private void cargaProvincia(String datos){
        ArrayList<provincia> pr=new ArrayList<provincia>();
        try {
            JSONObject json=new JSONObject(datos);
            JSONArray jsonArray=json.getJSONArray("provincia");
            for (int i=0;i<jsonArray.length();i++){
                provincia p=new provincia();
                p.setNombre(jsonArray.getJSONObject(i).getString("nombre"));
                pr.add(p);
            }
            ArrayAdapter<provincia> a=new ArrayAdapter<provincia>(this,R.layout.support_simple_spinner_dropdown_item,pr);
            spProvincia.setAdapter(a);

            spProvincia.setSelection(obtenerPosicionItem(spProvincia,neg_provincia));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void SolicitaCiudad(String URL){
        StringRequest solicitud=new StringRequest(Request.Method.POST,URL,new Response.Listener<String>(){
            public void onResponse(String datos){
                cargaCiudad(datos);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(crudnegocio.this,"No se logro conectar con el servidor",Toast.LENGTH_SHORT).show();
            }
        });
        VolleyRP.addToQueue(solicitud,mresq,this,volley);
    }
    public void cargaCiudad(String datos){
        ArrayList<ciudad> ciudad=new ArrayList<ciudad>();
        try {
            JSONObject json =new JSONObject(datos);
            JSONArray array=json.getJSONArray("ciudad");
            for (int i=0;i<array.length();i++){
                ciudad ciu=new ciudad();
                ciu.setCiudad(array.getJSONObject(i).getString("nombre"));
                ciudad.add(ciu);
            }
            ArrayAdapter<ciudad> adapter=new ArrayAdapter<ciudad>(this,R.layout.support_simple_spinner_dropdown_item,ciudad);
            spCiudad.setAdapter(adapter);
            spCiudad.setSelection(obtenerPosicionItem(spCiudad,neg_ciudad));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    //actualiza datos negocio
    private void actualizaDatosNegocio(String id,String nombre,String descripcion,String provincia,String ciudad,String direccion,String telefono,String celular){
        HashMap<String,String> hashMapToken = new HashMap<>();

        hashMapToken.put("neg_codigo",id);
        hashMapToken.put("neg_nombre",nombre);
        hashMapToken.put("neg_descripcion",descripcion);
        hashMapToken.put("neg_provincia",provincia);
        hashMapToken.put("neg_ciudad",ciudad);
        hashMapToken.put("neg_direccion",direccion);
        hashMapToken.put("neg_telefono",telefono);
        hashMapToken.put("neg_celular",celular);

        JsonObjectRequest solicitud = new JsonObjectRequest(Request.Method.POST,IP_ACTUALIZA_DATOS_NEGOCIO,new JSONObject(hashMapToken), new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject datos) {

                try {
                    Toast.makeText(crudnegocio.this,datos.getString("resultado"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(crudnegocio.this,"No se conecto con el servidor.",Toast.LENGTH_SHORT).show();
            }
        });
        VolleyRP.addToQueue(solicitud,mresq,this,volley);
    }
    private void EliminaDatosNegocio(String id){
        HashMap<String,String>hashMap=new HashMap<>();
        hashMap.put("id",id);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, IP_ELIMINA_NEGOCIO, new JSONObject(hashMap), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Toast.makeText(crudnegocio.this,response.getString("resultado"),Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(crudnegocio.this,"No se conecto con el servidor.",Toast.LENGTH_SHORT).show();
            }
        });
        VolleyRP.addToQueue(jsonObjectRequest,mresq,this,volley);
    }

    private void GuardarNegocio(String nombre,String descripcion,String direccion,String provincia,String ciudad,String telefono,String celular,String id_usuario){
     HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("neg_nombre",nombre);
        hashMap.put("neg_descripcion",descripcion);
        hashMap.put("neg_direccion",direccion);
        hashMap.put("neg_provincia",provincia);
        hashMap.put("neg_ciudad",ciudad);
        hashMap.put("neg_telefono",telefono);
        hashMap.put("neg_celular",celular);
        hashMap.put("cod_usuario",id_usuario);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, IP_REGISTRA_NEGOCIO, new JSONObject(hashMap), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        volley.addToQueue(jsonObjectRequest,mresq,this,volley);
    }
}
