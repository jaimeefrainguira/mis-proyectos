package com.hugo.empresa.buscandoando.configuracion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.hugo.empresa.buscandoando.R;
import com.hugo.empresa.buscandoando.VolleyRP;
import com.hugo.empresa.buscandoando.dominio;
import com.hugo.empresa.buscandoando.login;
import com.hugo.empresa.buscandoando.loginmenbrecia;
import com.hugo.empresa.buscandoando.modelo.negocio;
import com.hugo.empresa.buscandoando.preferences;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 8/05/2017.
 */

public class ActivityConfiguracion extends AppCompatActivity {

    private RecyclerView rv;
    private List<negocio> atributosList;
    private ConfiguracionAdapter adapter;

    private VolleyRP volley;
    private RequestQueue mRequest;
    public String EMISOR;
    private static final String URL_GET_ALL_NEGOCIOS =dominio.dominio+"BuscandoAndo/Controlador/consultarNSXUsuario.php?id=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        setTitle("Configuración");

        volley = VolleyRP.getInstance(this);
        mRequest = volley.getRequestQueue();
        EMISOR=preferences.obtenerPreferenceString(this,preferences.PREFERENCE_USUARIO_LOGIN);
        atributosList = new ArrayList<>();

        rv = (RecyclerView) findViewById(R.id.amigosRecyclerView);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        adapter = new ConfiguracionAdapter(atributosList,this);
        rv.setAdapter(adapter);

        ConsultaNegocios(URL_GET_ALL_NEGOCIOS+EMISOR);
    }


    public void agregarNegocio(String fotoDePerfil, String nombre, String ultimoMensaje, String hora,String id){
        negocio Atributos = new negocio();
        Atributos.setNeg_imagen(fotoDePerfil);
        Atributos.setNeg_nombre(nombre);
        Atributos.setNeg_descripcion(ultimoMensaje);
        Atributos.setNeg_direccion(hora);
        Atributos.setNeg_codigo(id);
        atributosList.add(Atributos);
        adapter.notifyDataSetChanged();
    }

    public void ConsultaNegocios(String URL){
        JsonObjectRequest solicitud = new JsonObjectRequest(URL,null, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject datos) {
                try {
                    String TodosLosDatos = datos.getString("resultado");
                    JSONArray jsonArray = new JSONArray(TodosLosDatos);
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject js = jsonArray.getJSONObject(i);
                        agregarNegocio(js.getString("neg_imagen"),js.getString("neg_nombre"),js.getString("neg_descripcion"),"00:00",js.getString("neg_codigo"));
                    }
                } catch (JSONException e) {
                    Toast.makeText(ActivityConfiguracion.this,"Ocurrio un error en el archivo de configuración.",Toast.LENGTH_SHORT).show();
                }
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ActivityConfiguracion.this,"Ocurrio un error al conectarse con el servidor",Toast.LENGTH_SHORT).show();
            }
        });
        VolleyRP.addToQueue(solicitud,mRequest,this,volley);
    }

}
