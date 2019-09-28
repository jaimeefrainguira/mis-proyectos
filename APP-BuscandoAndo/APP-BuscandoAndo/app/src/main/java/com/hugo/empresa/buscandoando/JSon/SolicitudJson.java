package com.hugo.empresa.buscandoando.JSon;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.hugo.empresa.buscandoando.VolleyRP;
import com.hugo.empresa.buscandoando.dominio;

import org.json.JSONObject;

import java.util.HashMap;

public abstract class SolicitudJson {
    public static final String URL_SUBIR_FOTO =dominio.dominio+"BuscandoAndo/Controlador/actualizaFotoPerfil.php";
    public static final String URL_GET_ULTIMA_EMPRESA_REGISTRADA =dominio.dominio+"BuscandoAndo/Controlador/consultaUltimaEmpresaRegistrada.php?datos=";
    public static  final  String IP_REGISTRA_NEGOCIO=dominio.dominio+"BuscandoAndo/Controlador/registraNegocio.php";
    public abstract void solicitudCompletada(JSONObject j);
    public abstract void solicitudErronea();

    public SolicitudJson(){}

    public void solicitudJsonGET(Context c, String URL){
        JsonObjectRequest solicitud = new JsonObjectRequest(URL,null, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject datos) {
                solicitudCompletada(datos);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                solicitudErronea();
            }
        });
        VolleyRP.addToQueue(solicitud,VolleyRP.getInstance(c).getRequestQueue(),c,VolleyRP.getInstance(c));
    }

    public void solicitudJsonPOST(Context c, String URL, HashMap h){
        JsonObjectRequest solicitud = new JsonObjectRequest(Request.Method.POST,URL,new JSONObject(h), new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject datos) {
                solicitudCompletada(datos);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                solicitudErronea();
            }
        });
        VolleyRP.addToQueue(solicitud,VolleyRP.getInstance(c).getRequestQueue(),c,VolleyRP.getInstance(c));
    }
}
