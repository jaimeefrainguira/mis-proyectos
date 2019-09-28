package com.hugo.empresa.buscandoando.servicios;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
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
import com.hugo.empresa.buscandoando.modelo.servicio;
import com.hugo.empresa.buscandoando.servicios.ServicioAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class fragmento_servicios extends Fragment {
    private VolleyRP volley;
    private RequestQueue mRequest;
    private static final String IP_CIUDAD_PUBLICADA=dominio.dominio+"BuscandoAndo/Controlador/consultaCiudadNegocio.php";
    private static final String URL_GET_ALL_SERVICIOXCIUDAD =dominio.dominio+"BuscandoAndo/Controlador/consultaServicio.php?ciudad=";
    private RecyclerView rv;
    private List<servicio> atributosList;
    private List<servicio> listaauxiliar;
    private ServicioAdapter adapter;
    private EditText buscar;
    private Spinner spCiudad;
    public String Mi_ciudad;
    private LinearLayout layoutSinSolicitudes;
    private OnFragmentInteractionListener mListener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_servicios,container,false);
        buscar=(EditText)v.findViewById(R.id.txtbuscaNegocio);
        spCiudad=(Spinner)v.findViewById(R.id.spnCiudad);
        layoutSinSolicitudes = (LinearLayout) v.findViewById(R.id.layoutVacioSolicitudes);
        volley = VolleyRP.getInstance(getContext());
        mRequest = volley.getRequestQueue();
        atributosList = new ArrayList<>();
        listaauxiliar=new ArrayList<>();
        rv = (RecyclerView) v.findViewById(R.id.serRecyclerView);
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(lm);
        adapter = new ServicioAdapter(atributosList,getContext());
        rv.setAdapter(adapter);
        //actualiza tarjeta se comenta la notify
        //adapter.notifyDataSetChanged();
        SolicitaCiudad(IP_CIUDAD_PUBLICADA);
        spCiudad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String ciudad=spCiudad.getItemAtPosition(spCiudad.getSelectedItemPosition()).toString();
                atributosList.clear();
                Mi_ciudad=ciudad;
                ConsultaNegocios(URL_GET_ALL_SERVICIOXCIUDAD+Mi_ciudad);
                verificarSiTenemosSolicitudes();
                //se comenta la noty 19-12-2018
                //adapter.notifyDataSetChanged();
                listaauxiliar.clear();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        buscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                atributosList.clear();
                //String dato= ""+s;
                //ConsultaNegociosBusqueda(URL_GET_ALL_NEGOCIOSXPARAMETROS+Mi_ciudad+"&"+dato);
                BuscarNegocio(""+s);
                //se comenta la nity
                verificarSiTenemosSolicitudes();
                //adapter.notifyDataSetChanged();
                //ConsultaNegocios(URL_GET_ALL_NEGOCIOSXCIUDAD+dato);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //se verifica las tarjetas si estan vacias
        verificarSiTenemosSolicitudes();
        return v;

    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
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
                        agregarNegocio(js.getString("neg_imagen"),js.getString("neg_nombre"),js.getString("neg_descripcion"),js.getString("neg_codigo"),js.getString("neg_categoria"));
                    }
                } catch (JSONException e) {
                    Toast.makeText(getContext(),"Ocurrio un error en el archivo de configuración.",Toast.LENGTH_SHORT).show();
                }
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"Ocurrio un error al conectarse con el servidor",Toast.LENGTH_SHORT).show();
            }
        });
        VolleyRP.addToQueue(solicitud,mRequest,getContext(),volley);
    }
    public void agregarNegocio(String fotoDePerfil, String nombre, String descripcion,String id,String categoria){
        servicio Atributos = new servicio();
        Atributos.setNeg_imagen(fotoDePerfil);
        Atributos.setNeg_nombre(nombre);
        Atributos.setNeg_descripcion(descripcion);
        //Atributos.setNeg_direccion(hora);
        Atributos.setNeg_codigo(id);
        Atributos.setNeg_categoria(categoria);
        atributosList.add(Atributos);
        //esto mantiene la lista statica
        listaauxiliar.add(Atributos);
        //actualizo la tarjeta se comenta la notifi
        //adapter.notifyDataSetChanged();
        actualizarTarjetas();
    }
    public void actualizarTarjetas(){
        adapter.notifyDataSetChanged();
        verificarSiTenemosSolicitudes();
    }
    private void BuscarNegocio(String busca){
        //limpio la lista principal
        atributosList.clear();
        //recorro la lista auxiliar esta almacena temporalmente los registros de negocios
        for(int i=0;i<listaauxiliar.size();i++){
            //primero comparamos las palabras con las letras
            if(listaauxiliar.get(i).getNeg_nombre().toLowerCase().contains(busca.toLowerCase()) || listaauxiliar.get(i).getNeg_categoria().toLowerCase().contains(busca.toLowerCase())) {
                //la lista principal  llega vacia entonces le agregamos la lista auxiliar en su pocision inicial
                atributosList.add(listaauxiliar.get(i));
            }

        }
        adapter.notifyDataSetChanged();
    }
    public void SolicitaCiudad(String URL){
        StringRequest solicitud=new StringRequest(Request.Method.POST,URL,new Response.Listener<String>(){
            public void onResponse(String datos){
                cargaCiudad(datos);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"Error al conectarse con el servidor.",Toast.LENGTH_SHORT).show();
            }
        });
        VolleyRP.addToQueue(solicitud,mRequest,getContext(),volley);
    }
    public void cargaCiudad(String datos){
        ArrayList<ciudad> ciudad=new ArrayList<ciudad>();
        try {
            JSONObject json =new JSONObject(datos);
            JSONArray array=json.getJSONArray("respuesta");
            for (int i=0;i<array.length();i++){
                ciudad ciu=new ciudad();
                ciu.setCiudad(array.getJSONObject(i).getString("neg_ciudad"));
                ciudad.add(ciu);
            }
            ArrayAdapter<ciudad> adapter=new ArrayAdapter<ciudad>(getContext(),R.layout.support_simple_spinner_dropdown_item,ciudad);
            spCiudad.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public void verificarSiTenemosSolicitudes(){
        if(atributosList.isEmpty()){
            layoutSinSolicitudes.setVisibility(View.VISIBLE);
            rv.setVisibility(View.GONE);
        }else{
            layoutSinSolicitudes.setVisibility(View.GONE);
            rv.setVisibility(View.VISIBLE);
        }
    }

}
