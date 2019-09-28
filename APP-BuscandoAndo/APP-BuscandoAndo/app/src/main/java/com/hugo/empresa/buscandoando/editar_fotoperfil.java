package com.hugo.empresa.buscandoando;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.hugo.empresa.buscandoando.JSon.SolicitudJson;
import com.squareup.picasso.Picasso;

import net.gotev.uploadservice.ServerResponse;
import net.gotev.uploadservice.UploadInfo;


public class editar_fotoperfil extends AppCompatActivity {
    //creamos el objeto para subir fotos
    private FotoManagerGotev fotoManagerGotev;
    private ImageView txtimagenfoto;
    public String foto=dominio.dominio+"BuscandoAndo/Controlador/FotoUsuario/error.png";
    public String EMISOR;
    public Button btncamara;
    public Button btngaleria;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_fotousuario);
        btncamara=(Button)findViewById(R.id.btnCamara);
        btngaleria=(Button)findViewById(R.id.btnGaleria);
        txtimagenfoto=(ImageView)findViewById(R.id.txtimagenfoto);
        EMISOR=preferences.obtenerPreferenceString(this,preferences.PREFERENCE_USUARIO_LOGIN);
        Intent i=getIntent();
        Bundle bundle=i.getExtras();
        if(bundle != null){
            foto=bundle.getString("fotoUsuario");
        }
        Picasso.with(this).load(foto).error(R.drawable.icono_perfil).into(txtimagenfoto);
        fotoManagerGotev=new FotoManagerGotev(this,SolicitudJson.URL_SUBIR_FOTO) {
            @Override
            public void onProgress(UploadInfo uploadInfo) {

            }

            @Override
            public void onError(UploadInfo uploadInfo, Exception exception) {
                Log.e(null, "Error in upload with ID: "  + ". "
                        + exception.getLocalizedMessage(), exception);
            }

            @Override
            public void onCompleted(UploadInfo uploadInfo, ServerResponse serverResponse) {

            }

            @Override
            public void onCancelled(UploadInfo uploadInfo) {

            }
        };
       fotoManagerGotev.setParameterNamePhoto("file");
       fotoManagerGotev.setEliminarFoto(false);
       fotoManagerGotev.setCorreoUsuario(EMISOR);
       btncamara.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               fotoManagerGotev.subirFotoCamara();
           }
       });
       btngaleria.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               fotoManagerGotev.subirFotoGaleria();
           }
       });
       FotoManagerGotev.verifyStoragePermissions(this);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //despues de la pausa
        fotoManagerGotev.onActivityResult(requestCode,resultCode,data);
    }
}
