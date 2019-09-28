package com.hugo.empresa.buscandoando.configuracion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.hugo.empresa.buscandoando.modelo.ciudad;
import com.hugo.empresa.buscandoando.modelo.provincia;
import com.hugo.empresa.buscandoando.preferences;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class registroservicio extends AppCompatActivity {
    private VolleyRP volley;
    private RequestQueue mresq;
    private Button btnRegistra,btnCancela;
    private EditText neg_nombre;
    private EditText neg_descripcion;
    private  EditText neg_direccion;
    private EditText neg_telefono;
    private EditText neg_celular;
    private Spinner spProvincia;
    private Spinner spCiudad;
    private String id_usuario;
    private static final String IP_IDUSUARIO=dominio.dominio+"BuscandoAndo/Controlador/consultaUsuarioXCorreo.php?id=";
    private static  final  String IP_REGISTRA_SERVICIO=dominio.dominio+"BuscandoAndo/Controlador/registraServicio.php";
    private static final String IP_CIUDAD=dominio.dominio+"BuscandoAndo/Controlador/consultaCiudad.php?id=";
    private static final String IP_PROVINCIA =dominio.dominio+"BuscandoAndo/Controlador/consultaProvincia.php";
    public String Mi_provincia;
    public String Mi_ciudad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registroservicio);
        volley=VolleyRP.getInstance(this);
        mresq=volley.getRequestQueue();
        neg_nombre=(EditText)findViewById(R.id.txtnombrenegocio);
        neg_descripcion=(EditText)findViewById(R.id.txtdescripcion);
        neg_direccion=(EditText)findViewById(R.id.txtdireccion);
        neg_telefono=(EditText)findViewById(R.id.txttelefono);
        neg_celular=(EditText)findViewById(R.id.txtcelular);
        spProvincia=(Spinner)findViewById(R.id.spprovincia);
        spCiudad=(Spinner)findViewById(R.id.spciudad);
        btnRegistra=(Button)findViewById(R.id.btnGuardar);
        btnCancela=(Button)findViewById(R.id.btnCancelar);
        String id=preferences.obtenerPreferenceString(registroservicio.this,preferences.PREFERENCE_USUARIO_LOGIN);
        //SolicitaUsuario(IP_IDUSUARIO+id);
        SolicitarProvincia(IP_PROVINCIA);
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
        //actualizo los datos del negocio
        btnRegistra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=preferences.obtenerPreferenceString(registroservicio.this,preferences.PREFERENCE_USUARIO_LOGIN);
                SolicitaUsuario(IP_IDUSUARIO+id);
            }
        });
        btnCancela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
 }


    public void SolicitarProvincia(String URL){
        StringRequest solicitud=new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {

            public void onResponse(String datos) {
                cargaProvincia(datos);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(registroservicio.this,"No se logro conectar con el servidor",Toast.LENGTH_SHORT).show();
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
                Toast.makeText(registroservicio.this,"No se logro conectar con el servidor",Toast.LENGTH_SHORT).show();
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
            //spCiudad.setSelection(obtenerPosicionItem(spCiudad,neg_ciudad));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public void SolicitaUsuario(String URL){
        JsonObjectRequest solicitud=new JsonObjectRequest(URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject datos) {
                cargaUsuario(datos);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(registroservicio.this,"No se logro conectar con el servidor",Toast.LENGTH_SHORT).show();
            }
        });
        VolleyRP.addToQueue(solicitud,mresq,this,volley);
    }
    public void cargaUsuario(JSONObject datos){
        try {
            JSONObject jsondatos=new JSONObject(datos.getString("id"));
            id_usuario=jsondatos.getString("usu_codigo");
            Toast.makeText(this,id_usuario,Toast.LENGTH_SHORT).show();
            if(id_usuario != null){
                GuardarNegocio(neg_nombre.getText().toString(),neg_descripcion.getText().toString(),neg_direccion.getText().toString(),Mi_provincia,Mi_ciudad,neg_telefono.getText().toString(),neg_celular.getText().toString());
            }else{
                Toast.makeText(this,"Se necesita un codigo.",Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    private void GuardarNegocio(String nombre,String descripcion,String direccion,String provincia,String ciudad,String telefono,String celular){
     HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("ser_nombre",nombre);
        hashMap.put("ser_descripcion",descripcion);
        hashMap.put("ser_direccion",direccion);
        hashMap.put("ser_provincia",provincia);
        hashMap.put("ser_ciudad",ciudad);
        hashMap.put("ser_telefono",telefono);
        hashMap.put("ser_celular",celular);
        //hashMap.put("usu_codigo",id_usuario);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, IP_REGISTRA_SERVICIO, new JSONObject(hashMap), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Toast.makeText(registroservicio.this,response.getString("respuesta"),Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(registroservicio.this,"No se conecto con el servidor.",Toast.LENGTH_SHORT).show();
            }
        });
        volley.addToQueue(jsonObjectRequest,mresq,this,volley);
    }


}
