package com.hugo.empresa.buscandoando;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
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
import com.google.firebase.iid.FirebaseInstanceId;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.regex.Pattern;

public class login extends AppCompatActivity {
    private boolean activado;
    private RadioButton rbsecion;
    private EditText correo, password;
    private Button btnLogear, btnRegis;
    private VolleyRP volley;
    private RequestQueue mresq;
    public String CORREO;
    public String PASSWORD;
    private ProgressDialog progressDialog;

    private static final String IP = dominio.dominio + "BuscandoAndo/Controlador/consultaLogin_WV.php?id=";
    private static final String IP_CREARLLAVE = dominio.dominio + "BuscandoAndo/Controlador/CrearLlaveUsuario.php";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressDialog = new ProgressDialog(this);
        if (preferences.obtenerPreferenceBoolean(this, preferences.PREFERENCE_ESTADO_BUTTON)) {
            Intent i = new Intent(login.this, menu.class);
            startActivity(i);
            finish();
        }
        volley = VolleyRP.getInstance(this);
        mresq = volley.getRequestQueue();
        correo = (EditText) findViewById(R.id.txtCorreo);
        password = (EditText) findViewById(R.id.txtPassword);
        btnLogear = (Button) findViewById(R.id.btn_ingresar);
        btnRegis = (Button) findViewById(R.id.btn_registrar);
        rbsecion = (RadioButton) findViewById(R.id.rdSecion);
        activado = rbsecion.isChecked();
        correo.requestFocus();
        rbsecion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activado) {
                    rbsecion.setChecked(false);
                }
                activado = rbsecion.isChecked();
                //preferences.guardarPreferenceBoolean(login.this,false,preferences.PREFERENCE_ESTADO_BUTTON);

                //Intent i=new Intent(login.this,menu.class);
                //startActivity(i);
                //finish();
            }
        });
        btnLogear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validardatos() == true) {
                    progressDialog.setMessage("Iniciado sesión");
                    progressDialog.show();
                    verdatos(correo.getText().toString().toLowerCase(), password.getText().toString().toLowerCase());
                }
            }
        });

    }

    public void clikRegistrar(View v) {

        Intent intent = new Intent(this, registro.class);
        startActivity(intent);
    }

    public void verdatos(String correo, String password) {
        CORREO = correo;
        PASSWORD = password;
        SolicitarJSON(IP + correo);
    }

    public void SolicitarJSON(String URL) {
        JsonObjectRequest solicitud = new JsonObjectRequest(URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject datos) {
                VerificaLoginDesdeWV(datos);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(login.this, "No se logro conectar con el servidor", Toast.LENGTH_SHORT).show();
            }
        });

        VolleyRP.addToQueue(solicitud, mresq, this, volley);
    }

    public void VerificaLoginDesdeWV(JSONObject datos) {
        try {
            String resultado = datos.getString("resultado");
            if (resultado.equals("CC")) {

                JSONObject jsondatos = new JSONObject(datos.getString("datos"));
                String usuario = jsondatos.getString("usu_correo").toLowerCase();
                String passwordS = jsondatos.getString("usu_password").toLowerCase();
                if (usuario.equals(CORREO) && passwordS.equals(PASSWORD)) {
                    preferences.guardaPreferenciaString(login.this, jsondatos.getString("usu_correo"), preferences.PREFERENCE_USUARIO_LOGIN);
                    String llave = FirebaseInstanceId.getInstance().getToken();
                    progressDialog.dismiss();
                    if (llave != null) {

                        registrarLLaveUsuario(CORREO, llave);
                    } else {
                        Toast.makeText(this, "La llave esta vacia", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(this, "Correo o password incorrecto", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void registrarLLaveUsuario(String usuario, String llave) {
        HashMap<String, String> hashMapToken = new HashMap<>();

        hashMapToken.put("usuario", usuario);
        hashMapToken.put("llave", llave);

        JsonObjectRequest solicitud = new JsonObjectRequest(Request.Method.POST, IP_CREARLLAVE, new JSONObject(hashMapToken), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject datos) {
                preferences.guardarPreferenceBoolean(login.this, rbsecion.isChecked(), preferences.PREFERENCE_ESTADO_BUTTON);

                try {
                    Toast.makeText(login.this, datos.getString("resultado"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(login.this, menu.class);
                startActivity(intent);
                finish();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(login.this, "Error al registrar la llave.", Toast.LENGTH_SHORT).show();
            }
        });
        VolleyRP.addToQueue(solicitud, mresq, this, volley);
    }

    public boolean validardatos() {
        if (correo.getText().length() == 0) {
            Toast.makeText(login.this, "Ingrese su correo.", Toast.LENGTH_SHORT).show();
            correo.requestFocus();
            return false;
        } else if (password.getText().length() == 0) {
            Toast.makeText(login.this, "Ingrese su contraseña.", Toast.LENGTH_SHORT).show();
            password.requestFocus();
            return false;
        } else if (!isValidEmailId(correo.getText().toString().trim())) {
            Toast.makeText(login.this, "Correo ingresado no es valido", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }

    }

    //valido correo electronico
    private boolean isValidEmailId(String email) {

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }
}
