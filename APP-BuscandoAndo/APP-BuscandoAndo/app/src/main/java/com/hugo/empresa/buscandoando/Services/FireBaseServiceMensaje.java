package com.hugo.empresa.buscandoando.Services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.content.LocalBroadcastManager;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Random;

import com.hugo.empresa.buscandoando.R;
import com.hugo.empresa.buscandoando.configuracion.registronegocio;
import com.hugo.empresa.buscandoando.empresas.perfilempresa;

public class FireBaseServiceMensaje extends FirebaseMessagingService {
    public String id="";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String mensaje=remoteMessage.getData().get("mensaje");
        String hora=remoteMessage.getData().get("hora");
        String cabezera=remoteMessage.getData().get("cabezera");
        String cuerpo=remoteMessage.getData().get("cuerpo");
        id=remoteMessage.getData().get("id");
        //Mensaje(mensaje,hora);
        crearEstiloNotificaciones(cabezera,cuerpo);

    }
    //private void Mensaje(String mensaje,String hora){
      //  Intent i = new Intent(registronegocio.MENSAJE);
        //i.putExtra("key_mensaje",mensaje);
        //i.putExtra("key_hora",hora);
        //LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(i);
    //}

    public void crearEstiloNotificaciones(String cabezera,String cuerpo){
        Intent i=new Intent(this,perfilempresa.class);
        i.putExtra("key_idNegocio",id);
        //startActivity(i);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_ONE_SHOT);
        Uri soUri=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Builder builder=new Builder(this);
        builder.setAutoCancel(true);
        builder.setContentTitle(cabezera);
        builder.setContentText(cuerpo);
        builder.setSound(soUri);
        builder.setSmallIcon(R.drawable.logo);
        builder.setTicker(cuerpo);
        builder.setContentIntent(pendingIntent);
        NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        Random random =new Random();
        notificationManager.notify(random.nextInt(),builder.build());
    }
}
