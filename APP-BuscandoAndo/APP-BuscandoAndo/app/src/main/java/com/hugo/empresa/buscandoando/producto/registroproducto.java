package com.hugo.empresa.buscandoando.producto;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
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
import com.hugo.empresa.buscandoando.menu;
import com.hugo.empresa.buscandoando.modelo.buscadornegocioAtributos;
import com.hugo.empresa.buscandoando.modelo.categoria;
import com.hugo.empresa.buscandoando.modelo.ciudad;
import com.hugo.empresa.buscandoando.modelo.provincia;
import com.hugo.empresa.buscandoando.preferences;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class registroproducto extends AppCompatActivity {
    private VolleyRP volley;
    private RequestQueue mresq;
    private Button btnRegistra,btnCancela;
    private ImageButton btnRetrocede;
    private EditText neg_nombre;
    private EditText neg_descripcion;
    private  EditText neg_direccion;
    private EditText neg_telefono;
    private EditText neg_celular;
    private Spinner spProvincia;
    private Spinner spCiudad;
    private Spinner spCategoria;
    private RadioButton rbtEmpresa;
    private RadioButton rbtServicio;
    private String id_usuario;
    private static final String IP_IDUSUARIO=dominio.dominio+"BuscandoAndo/Controlador/consultaUsuarioXCorreo.php?id=";
    private static  final  String IP_REGISTRA_NEGOCIO=dominio.dominio+"BuscandoAndo/Controlador/registraNegocio.php";
    private static final String IP_CIUDAD=dominio.dominio+"BuscandoAndo/Controlador/consultaCiudad.php?id=";
    private static final String IP_PROVINCIA =dominio.dominio+"BuscandoAndo/Controlador/consultaProvincia.php";
    private static final String IP_CATEGORIA =dominio.dominio+"BuscandoAndo/Controlador/buscarCategoria.php";
    public String Mi_provincia;
    public String Mi_ciudad;
    public String Mi_categoria;
    private List<buscadornegocioAtributos> atributosList;//conectada con nuestro adaptor nueva variable
    private EventBus bus=EventBus.getDefault();
    private ProgressDialog dialog = null;
    //public static final String MENSAJE = "MENSAJE";
    //private BroadcastReceiver bR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registroproducto);
        volley=VolleyRP.getInstance(this);
        mresq=volley.getRequestQueue();
        neg_nombre=(EditText)findViewById(R.id.txtnombrenegocio);
        neg_descripcion=(EditText)findViewById(R.id.txtdescripcion);
        neg_direccion=(EditText)findViewById(R.id.txtdireccion);
        neg_telefono=(EditText)findViewById(R.id.txttelefono);
        neg_celular=(EditText)findViewById(R.id.txtcelular);
        spProvincia=(Spinner)findViewById(R.id.spprovincia);
        spCiudad=(Spinner)findViewById(R.id.spciudad);
        spCategoria=(Spinner)findViewById(R.id.spcategoria);
        rbtEmpresa=(RadioButton)findViewById(R.id.rbtEmpresas);
        rbtServicio=(RadioButton)findViewById(R.id.rbtServicios);
        btnRegistra=(Button)findViewById(R.id.btnGuardar);
        btnCancela=(Button)findViewById(R.id.btnCancelar);
        btnRetrocede=(ImageButton) findViewById(R.id.imageButton);
        dialog = new ProgressDialog(this);
        dialog.setMessage("\n" +"Enviando datos...");
        dialog.setCancelable(false);
        //variable para agregar datos a los objetos
        atributosList = new ArrayList<>();
        //******
        String id=preferences.obtenerPreferenceString(registroproducto.this,preferences.PREFERENCE_USUARIO_LOGIN);
        //SolicitaUsuario(IP_IDUSUARIO+id);
        SolicitarProvincia(IP_PROVINCIA);
        SolicitarCategoria(IP_CATEGORIA);
        rbtEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbtServicio.setChecked(false);
            }
        });
        rbtServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbtEmpresa.setChecked(false);
            }
        });
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
        //ciudad
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
        spCategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String categoria=spCategoria.getItemAtPosition(spCategoria.getSelectedItemPosition()).toString();
                Mi_categoria=categoria;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //actualizo los datos del negocio
        btnRegistra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=preferences.obtenerPreferenceString(registroproducto.this,preferences.PREFERENCE_USUARIO_LOGIN);
                SolicitaUsuario(IP_IDUSUARIO+id);
            }
        });
        btnCancela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
       // bR = new BroadcastReceiver() {
         //   @Override
           // public void onReceive(Context context, Intent intent) {
             //   String mensaje = intent.getStringExtra("key_mensaje");
               // String hora = intent.getStringExtra("key_hora");
                //CreateMensaje(mensaje,hora);
            //}
        //};
        btnRetrocede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registroproducto.this, menu.class);
                startActivity(intent);
                finish();
            }
        });
 }

   //metodo para cargar los objetos
    public void insertarUsuario(String fotoPerfil,String nombre,String descripcion,String id,String categoria){
        buscadornegocioAtributos buscadorAtributos = new buscadornegocioAtributos();
        buscadorAtributos.setNeg_imagen(fotoPerfil);
        buscadorAtributos.setNeg_nombre(nombre);
        buscadorAtributos.setNeg_descripcion(descripcion);
        buscadorAtributos.setNeg_codigo(id);
        buscadorAtributos.setNeg_categoria(categoria);
        atributosList.add(buscadorAtributos);

    }
    public void insertarUsuario(buscadornegocioAtributos b){
        atributosList.add(b);
    }
    @Subscribe
    public void ejecutarLLamada(buscadornegocioAtributos b){
        insertarUsuario(b);
    }
    @Override
    public void onPause() {
        super.onPause();
        bus.unregister(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        bus.register(this);
    }
    ///************************************
    public void SolicitarProvincia(String URL){
        StringRequest solicitud=new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {

            public void onResponse(String datos) {
                cargaProvincia(datos);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(registroproducto.this,"No se logro conectar con el servidor",Toast.LENGTH_SHORT).show();
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
                Toast.makeText(registroproducto.this,"No se logro conectar con el servidor",Toast.LENGTH_SHORT).show();
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
//ciclo de la vida de android ******************

/////////****************************************

    public void SolicitaUsuario(String URL){
        JsonObjectRequest solicitud=new JsonObjectRequest(URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject datos) {
                cargaUsuario(datos);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(registroproducto.this,"No se logro conectar con el servidor",Toast.LENGTH_SHORT).show();
            }
        });
        VolleyRP.addToQueue(solicitud,mresq,this,volley);
    }
    public void cargaUsuario(JSONObject datos){
        try {
            JSONObject jsondatos=new JSONObject(datos.getString("id"));
            id_usuario=jsondatos.getString("usu_codigo");
            String nombreUsuario=jsondatos.getString("usu_nombre");
            //neg_celular.setText(jsondatos.getString("usu_telefono"));

            Toast.makeText(this,id_usuario,Toast.LENGTH_SHORT).show();
            if(id_usuario != null){
                String tipo = "Producto";
                GuardarNegocio(neg_nombre.getText().toString(),neg_descripcion.getText().toString(),neg_direccion.getText().toString(),Mi_provincia,Mi_ciudad,neg_telefono.getText().toString(),neg_celular.getText().toString(),id_usuario,tipo,nombreUsuario,Mi_categoria);
            }else{
                Toast.makeText(this,"Se necesita un codigo.",Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    private void GuardarNegocio(String nombre,String descripcion,String direccion,String provincia,String ciudad,String telefono,String celular,String id_usuarioFinal,String tipo,String usuario,String categoria){
     HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("neg_nombre",nombre);
        hashMap.put("neg_descripcion",descripcion);
        hashMap.put("neg_direccion",direccion);
        hashMap.put("neg_provincia",provincia);
        hashMap.put("neg_ciudad",ciudad);
        hashMap.put("neg_telefono",telefono);
        hashMap.put("neg_celular",celular);
        hashMap.put("usu_codigo",id_usuarioFinal);
        hashMap.put("neg_tipo",tipo);
        hashMap.put("neg_usuario",usuario);
        hashMap.put("neg_categoria",categoria);
        dialog.show();
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, IP_REGISTRA_NEGOCIO, new JSONObject(hashMap), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String resultado=response.getString("respuesta");
                    if(resultado.equals("200")) {
                        dialog.dismiss();
                        Toast.makeText(registroproducto.this, "Datos publicados correctamente", Toast.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent=new Intent(registroproducto.this,com.hugo.empresa.buscandoando.menu.class);
                                startActivity(intent);
                            }
                        },3000);
                        finish();
                    }else if(resultado.equals("-1")){
                        dialog.dismiss();
                        Toast.makeText(registroproducto.this, "Problemas al publicar los datos", Toast.LENGTH_SHORT).show();
                    }

                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(registroproducto.this,"No se conecto con el servidor.",Toast.LENGTH_SHORT).show();
            }
        });
        volley.addToQueue(jsonObjectRequest,mresq,this,volley);
    }

    public void SolicitarCategoria(String URL){
        StringRequest solicitud=new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {

            public void onResponse(String datos) {
                cargaCategoria(datos);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(registroproducto.this,"No se logro conectar con el servidor",Toast.LENGTH_SHORT).show();
            }
        });

        VolleyRP.addToQueue(solicitud,mresq,this,volley);
    }
    private void cargaCategoria(String datos){
        ArrayList<categoria> pr=new ArrayList<categoria>();
        try {
            JSONObject json=new JSONObject(datos);
            JSONArray jsonArray=json.getJSONArray("categoria");
            for (int i=0;i<jsonArray.length();i++){
                categoria p=new categoria();
                p.setCat_nombre(jsonArray.getJSONObject(i).getString("cat_nombre"));
                pr.add(p);
            }
            ArrayAdapter<categoria> a=new ArrayAdapter<categoria>(this,R.layout.support_simple_spinner_dropdown_item,pr);
            spCategoria.setAdapter(a);



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
