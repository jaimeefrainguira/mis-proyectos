package com.hugo.empresa.buscandoando;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.hugo.empresa.buscandoando.modelo.ciudad;
import com.hugo.empresa.buscandoando.modelo.provincia;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class registro extends AppCompatActivity {

    private static final String IP_CIUDAD=dominio.dominio+"BuscandoAndo/Controlador/consultaCiudad.php?id=";
    private static final String IP_PROVINCIA =dominio.dominio+"BuscandoAndo/Controlador/consultaProvincia.php";
    private static final String IP_REGISTRAR =dominio.dominio+"BuscandoAndo/Controlador/guardarUsuario.php";
    private RadioButton rbtHombre;
    private RadioButton rbtMujer;
    private CheckBox chbTerminos;
    private EditText nombre;
    private EditText apellidos;
    private  EditText correo;
    private EditText telefono;
    private EditText password;
    private EditText passwordConfirme;
    private Button registro;
    private Spinner spProvincia;
    private Spinner spCiudad;
    private VolleyRP volley;
    private RequestQueue mRequest;
    public String Mi_provincia;
    public String Mi_ciudad;
    public ImageButton btnRetrocede;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        volley = VolleyRP.getInstance(this);
        mRequest = volley.getRequestQueue();
        btnRetrocede=(ImageButton)findViewById(R.id.btnRetrocede);
        nombre = (EditText) findViewById(R.id.txtNombres);
        apellidos = (EditText) findViewById(R.id.txtApellidos);
        telefono = (EditText) findViewById(R.id.txtCelular);
        correo=(EditText) findViewById(R.id.txtCorreo);
        password=(EditText)findViewById(R.id.txtPassword);
        passwordConfirme=(EditText)findViewById(R.id.txtRepPassword);
        spProvincia=(Spinner)findViewById(R.id.spnProvincia);
        spCiudad=(Spinner)findViewById(R.id.spnCiudad);
        rbtHombre=(RadioButton)findViewById(R.id.rbtHombre);
        rbtMujer=(RadioButton)findViewById(R.id.rbtMujer);
        rbtHombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbtMujer.setChecked(false);
            }
        });

        rbtMujer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbtHombre.setChecked(false);
            }
        });
        chbTerminos=(CheckBox)findViewById(R.id.chbTerminos);
        registro = (Button) findViewById(R.id.btn_Guardar);
        nombre.requestFocus();
        SolicitarJSON(IP_PROVINCIA);
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
        //METODO PARA INGRESAR LOS DATOS DEL USUARIO
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validardatos()==true){
                    String genero = "";
                    String termino="";
                    if (rbtHombre.isChecked()) {
                        genero = "hombre";
                    }else if (rbtMujer.isChecked()) {
                        genero = "mujer";
                    }
                    if(chbTerminos.isChecked()==true){
                        termino="Aceptado";
                    }
                    registrarWebService(

                            getStringET(nombre).trim(),
                            getStringET(apellidos).trim(),
                            getStringET(correo).trim(),
                            Mi_provincia,
                            Mi_ciudad,
                            getStringET(telefono).trim(),
                            getStringET(password).trim(),genero,
                            termino

                    );
                    //Toast.makeText(ec.com.ingetec.buscandoando.controlador.registro.this,Mi_provincia,Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnRetrocede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registro.this,login.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void registrarWebService(String nombre,String apellido,String correo,String provincia,String ciudad,String telefono,String password,String genero,String terminos){
        HashMap<String,String> hashMapToken = new HashMap<>();
        hashMapToken.put("nombre",nombre);
        hashMapToken.put("apellido",apellido);
        hashMapToken.put("correo",correo);
        hashMapToken.put("provincia",provincia);
        hashMapToken.put("ciudad",ciudad);
        hashMapToken.put("telefono",telefono);
        hashMapToken.put("password",password);
        hashMapToken.put("sexo",genero);
        hashMapToken.put("terminos",terminos);


        JsonObjectRequest solicitud = new JsonObjectRequest(Request.Method.POST,IP_REGISTRAR,new JSONObject(hashMapToken), new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject datos) {
                try {
                    String estado = datos.getString("resultado");
                    if(estado.equalsIgnoreCase("Has ingresado tus datos correctamente.")){
                        Toast.makeText(registro.this,estado, Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(registro.this,estado, Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    Toast.makeText(registro.this,"Error al conectarse con el servidor.",Toast.LENGTH_SHORT).show();
                }
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(registro.this,"Error al conectarse con el servidor.",Toast.LENGTH_SHORT).show();
            }
        });
        VolleyRP.addToQueue(solicitud,mRequest,this,volley);
    }


    private String getStringET(EditText e){
        return e.getText().toString();
    }
    public void SolicitarJSON(String URL){
        StringRequest solicitud=new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {

            public void onResponse(String datos) {
                cargaProvincia(datos);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(registro.this,"Error al conectarse con el servidor.",Toast.LENGTH_SHORT).show();
            }
        });

        VolleyRP.addToQueue(solicitud,mRequest,this,volley);
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
                Toast.makeText(registro.this,"Error al conectarse con el servidor.",Toast.LENGTH_SHORT).show();
            }
        });
        VolleyRP.addToQueue(solicitud,mRequest,this,volley);
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
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public boolean validardatos(){
        if(nombre.getText().length()==0){
            Toast.makeText(registro.this,"Ingrese su nombre.",Toast.LENGTH_SHORT).show();
            nombre.requestFocus();
            return false;
        }else if(apellidos.getText().length()==0){
            Toast.makeText(registro.this,"Ingrese su apellido.",Toast.LENGTH_SHORT).show();
            apellidos.requestFocus();
            return false;
        }
        else if(correo.getText().length()==0){
            Toast.makeText(registro.this,"Ingrese su correo electronico.",Toast.LENGTH_SHORT).show();
            correo.requestFocus();
            return false;
        }else if(password.getText().length()==0){
            Toast.makeText(registro.this,"Digite su password.",Toast.LENGTH_SHORT).show();
            password.requestFocus();
            return false;
        }else if(passwordConfirme.getText().length()==0){
            Toast.makeText(registro.this,"Confirme su password.",Toast.LENGTH_SHORT).show();
            passwordConfirme.requestFocus();
            return false;
        }
        else if(!chbTerminos.isChecked()){
            Toast.makeText(registro.this,"Debes aceptar terminos y condiciones",Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(!isValidEmailId(correo.getText().toString().trim())){
            Toast.makeText(registro.this,"Correo ingresado no es valido",Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(passwordConfirme.getText().length() != password.getText().length()){
            Toast.makeText(registro.this,"No coiside las dos contraseñas.",Toast.LENGTH_SHORT).show();
            password.setText("");
            passwordConfirme.setText("");
            password.requestFocus();
            return false;
        }
        else{
            return true;
        }

    }
    //valido correo electronico
    private boolean isValidEmailId(String email){

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }
}