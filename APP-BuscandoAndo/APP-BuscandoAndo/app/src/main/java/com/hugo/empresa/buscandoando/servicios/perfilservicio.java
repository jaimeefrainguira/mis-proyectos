package com.hugo.empresa.buscandoando.servicios;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.hugo.empresa.buscandoando.R;
import com.hugo.empresa.buscandoando.VolleyRP;
import com.hugo.empresa.buscandoando.dominio;

import org.json.JSONException;
import org.json.JSONObject;

public class perfilservicio extends AppCompatActivity {
    private VolleyRP volley;
    private RequestQueue mresq;
    private TextView neg_nombre;
    private TextView neg_descripcion;
    private TextView neg_ciudad;
    private TextView neg_direccion;
    private TextView neg_telefono;
    private TextView neg_celular;
    private EditText neg_mensaje;
    private Button btnLlamar;
    private static final String IP_CONSULTA_NEGOCIO=dominio.dominio+"BuscandoAndo/Controlador/consultaNegocioXId.php?id=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio);
        volley=VolleyRP.getInstance(this);
        mresq=volley.getRequestQueue();
        btnLlamar=(Button)findViewById(R.id.btnLlamar);
        neg_ciudad=(TextView)findViewById(R.id.txtciudad);
        neg_nombre=(TextView)findViewById(R.id.txtnombre);
        neg_descripcion=(TextView)findViewById(R.id.txtdescripcion);
        neg_direccion=(TextView)findViewById(R.id.txtdireccion);
        neg_telefono=(TextView)findViewById(R.id.txttelefono);
        neg_celular=(TextView)findViewById(R.id.txtcelular);
        neg_mensaje=(EditText)findViewById(R.id.txtmensaje);
        Intent i=getIntent();
        final Bundle bundle=i.getExtras();
        if(bundle != null){
            Toast.makeText(perfilservicio.this,bundle.getString("key_idServicio"),Toast.LENGTH_SHORT).show();
            String id=bundle.getString("key_idServicio");
            SolicitaNegocio(IP_CONSULTA_NEGOCIO+id);
        }
        btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(validardatos()==true) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        String uri = "whatsapp://send?phone=593" + neg_celular.getText().toString() + "&text=" + neg_mensaje.getText().toString() + "";
                        intent.setData(Uri.parse(uri));
                        startActivity(intent);
                        neg_mensaje.setText("");
                    }
                    }catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(getApplicationContext(), "Whatsapp no esta instalado en este telefono", Toast.LENGTH_LONG).show();
                    }

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
                Toast.makeText(perfilservicio.this,"No se logro conectar con el servidor",Toast.LENGTH_SHORT).show();
            }
        });
        VolleyRP.addToQueue(solicitud,mresq,this,volley);
    }
    public void cargaNegocio(JSONObject datos){
        try {
            JSONObject jsondatos=new JSONObject(datos.getString("id"));
            neg_nombre.setText(jsondatos.getString("neg_nombre"));
            neg_descripcion.setText(jsondatos.getString("neg_descripcion"));
            neg_ciudad.setText(jsondatos.getString("neg_ciudad"));
            neg_direccion.setText(jsondatos.getString("neg_direccion"));
            neg_telefono.setText(jsondatos.getString("neg_telefono"));
            neg_celular.setText(jsondatos.getString("neg_celular"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public boolean validardatos(){
        if(neg_telefono.getText().length()==0){
            Toast.makeText(perfilservicio.this,"Se necesita un numero telefonico para enviar el mensaje.",Toast.LENGTH_SHORT).show();
            neg_telefono.requestFocus();
            return false;
        }else if(neg_mensaje.getText().length()==0){
            Toast.makeText(perfilservicio.this,"Ingrese un mensaje.",Toast.LENGTH_SHORT).show();
            neg_mensaje.requestFocus();
            return false;
        }
        else{
            return true;
        }

    }
}
