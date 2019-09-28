package com.hugo.empresa.buscandoando;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.hugo.empresa.buscandoando.configuracion.menuconfiguracion;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class loginmenbrecia extends AppCompatActivity {
    private boolean activado;
    private RadioButton rbsecion;
    private EditText correo,password;
    private Button btnLogear,btnRegis;
    private VolleyRP volley;
    private RequestQueue mresq;
    public String EMISOR;
    public String PASSWORD;
    public String id_usuario;
    private static final String IP_IDUSUARIO=dominio.dominio+"BuscandoAndo/Controlador/consultaUsuarioXCorreo.php?id=";
    private static final String IP_CONSULTA_TOKEN=dominio.dominio+"BuscandoAndo/Controlador/buscaToken.php?id=";
    private static final String IP_SOLICITUDTOKEN=dominio.dominio+"BuscandoAndo/Controlador/actualizaSolicitud.php";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginmenbrecia);
        //if(preferences.obtenerPreferenceBoolean(this,preferences.PREFERENCE_ESTADO_BUTTON)){
          //  Intent i=new Intent(login.this,menu.class);
            //startActivity(i);
            //finish();
        //}
        //envio a membrecia
        if(preferences.obtenerPreferenceBooleanM(this,preferences.PREFERENCE_ESTADO_BUTTONM)){
            Intent i=new Intent(loginmenbrecia.this,menuconfiguracion.class);
            startActivity(i);
            finish();
        }
        volley=VolleyRP.getInstance(this);
        mresq=volley.getRequestQueue();
        correo=(EditText)findViewById(R.id.txtCorreo);
        password=(EditText)findViewById(R.id.txtPassword);
        btnLogear=(Button)findViewById(R.id.btn_ingresar);
        btnRegis=(Button)findViewById(R.id.btn_registrar);
        rbsecion=(RadioButton)findViewById(R.id.rdSecion);
        EMISOR=preferences.obtenerPreferenceString(this,preferences.PREFERENCE_USUARIO_LOGIN);
        activado=rbsecion.isChecked();
        rbsecion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(activado){
                    rbsecion.setChecked(false);
                }
                activado=rbsecion.isChecked();
            }
        });
        btnLogear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    verdatos(password.getText().toString().toUpperCase());


            }
        });


    }
    public void clikRegistrar(View v){
        AlertDialog.Builder builder=new AlertDialog.Builder(loginmenbrecia.this);
        builder.setIcon(R.drawable.logo);
        builder.setTitle("Mensaje de confirmación");
        builder.setMessage("Recibiras un correo electrónico con las instrucciones necesarias para obtener el código de membresía");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String id=preferences.obtenerPreferenceString(loginmenbrecia.this,preferences.PREFERENCE_USUARIO_LOGIN);
                SolicitaUsuario(IP_IDUSUARIO+id);
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
    public void verdatos(String password){
        PASSWORD=password;
        ConsultarToken(IP_CONSULTA_TOKEN+password);
    }
    public void ConsultarToken(String URL){
        JsonObjectRequest solicitud=new JsonObjectRequest(URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject datos) {
                VerificaToken(datos);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(loginmenbrecia.this,"No se logro conectar con el servidor",Toast.LENGTH_SHORT).show();
            }
        });

        VolleyRP.addToQueue(solicitud,mresq,this,volley);
    }
    public void VerificaToken(JSONObject datos){
        try {
            String resultado=datos.getString("resultado");
            if(resultado.equals("CCTOKEN")){
                JSONObject jsondatos=new JSONObject(datos.getString("datos"));
                String usuario=jsondatos.getString("tok_correo");
                String passwordS=jsondatos.getString("tok_codigo");
                if(usuario.equals(EMISOR) && passwordS.equals(PASSWORD)){
                    preferences.guardaPreferenciaStringM(loginmenbrecia.this,jsondatos.getString("tok_codigo"),preferences.PREFERENCE_USUARIO_LOGINM);
                    preferences.guardarPreferenceBooleanM(loginmenbrecia.this,rbsecion.isChecked(),preferences.PREFERENCE_ESTADO_BUTTONM);

                    Intent i=new Intent(loginmenbrecia.this,menuconfiguracion.class);
                    startActivity(i);

                    //Intent intent = new Intent(loginmenbrecia.this, ActivityUsuarios.class);
                    //startActivity(intent);
                    //finish();

                }else{
                    Toast.makeText(this,"Codigo incorrecto.",Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this,resultado,Toast.LENGTH_SHORT).show();
            }

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
                Toast.makeText(loginmenbrecia.this,"No se logro conectar con el servidor",Toast.LENGTH_SHORT).show();
            }
        });
        VolleyRP.addToQueue(solicitud,mresq,this,volley);
    }
    public void cargaUsuario(JSONObject datos){
        try {
            JSONObject jsondatos=new JSONObject(datos.getString("id"));
            String id_usuario=jsondatos.getString("usu_codigo");
            //Toast.makeText(this,id_usuario,Toast.LENGTH_SHORT).show();
            if(id_usuario != null){
                enviarSolicitudToken(id_usuario,"Generar Codigo para menbresia");
            }else{
                Toast.makeText(this,"Se necesita un codigo.",Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void enviarSolicitudToken(String id,String mensaje){
        HashMap<String,String> hashMapToken = new HashMap<>();

        hashMapToken.put("id",id);
        hashMapToken.put("mensaje",mensaje);

        JsonObjectRequest solicitud = new JsonObjectRequest(Request.Method.POST,IP_SOLICITUDTOKEN,new JSONObject(hashMapToken), new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject datos) {

                try {
                    Toast.makeText(loginmenbrecia.this,datos.getString("resultado"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //Intent intent = new Intent(m.this, menu.class);
                //startActivity(intent);
                //finish();
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(loginmenbrecia.this,"Error al registrar la llave.",Toast.LENGTH_SHORT).show();
            }
        });
        VolleyRP.addToQueue(solicitud,mresq,this,volley);
    }

    public boolean validardatos(){
        if(correo.getText().length()==0){
            Toast.makeText(loginmenbrecia.this,"Ingrese su correo.",Toast.LENGTH_SHORT).show();
            correo.requestFocus();
            return false;
        }else if(password.getText().length()==0){
            Toast.makeText(loginmenbrecia.this,"Ingrese su contraseña.",Toast.LENGTH_SHORT).show();
            password.requestFocus();
            return false;
        }

        else{
            return true;
        }

    }
}
