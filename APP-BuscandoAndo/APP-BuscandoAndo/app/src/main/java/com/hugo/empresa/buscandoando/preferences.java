package com.hugo.empresa.buscandoando;

import android.content.Context;
import android.content.SharedPreferences;

public class preferences {
    //PARA EL LOGIN QUE NO PIDA RECORDAR EL USUARIO Y CONTRASEÑA
    public static String STRING_PREFERENCIA="hugo.sistema";
    public static  String PREFERENCE_ESTADO_BUTTON="estado.boton_sesion";
    public  static  String PREFERENCE_USUARIO_LOGIN="id_usuario";
    //***********************************
    public static String STRING_PREFERENCIAM="hugo.m";
    public static  String PREFERENCE_ESTADO_BUTTONM="estado.boton_m";
    public  static  String PREFERENCE_USUARIO_LOGINM="id_m";
    public static void guardarPreferenceBoolean(Context contecto, boolean bandera, String llave){
        //modo privado porque solo esta aplicacion utilizara estos para metros no se puede compartir con otros datos
        SharedPreferences preferences = contecto.getSharedPreferences(STRING_PREFERENCIA,contecto.MODE_PRIVATE);
        preferences.edit().putBoolean(llave,bandera).apply();
    }
    public  static  void guardaPreferenciaString(Context context,String cadena,String llave){
        SharedPreferences preferences=context.getSharedPreferences(STRING_PREFERENCIA,context.MODE_PRIVATE);
        preferences.edit().putString(llave,cadena).apply();
    }
    public  static boolean obtenerPreferenceBoolean(Context context,String llave){
        SharedPreferences preferences=context.getSharedPreferences(STRING_PREFERENCIA,context.MODE_PRIVATE);
        return preferences.getBoolean(llave,false);
    }
    public  static  String obtenerPreferenceString(Context context,String llave){
        SharedPreferences preferences=context.getSharedPreferences(STRING_PREFERENCIA,context.MODE_PRIVATE);
        return preferences.getString(llave,"");
    }

    //menbrecia
    public static void guardarPreferenceBooleanM(Context contecto, boolean bandera, String llave){
        //modo privado porque solo esta aplicacion utilizara estos para metros no se puede compartir con otros datos
        SharedPreferences preferences = contecto.getSharedPreferences(STRING_PREFERENCIAM,contecto.MODE_PRIVATE);
        preferences.edit().putBoolean(llave,bandera).apply();
    }
    public  static  void guardaPreferenciaStringM(Context context,String cadena,String llave){
        SharedPreferences preferences=context.getSharedPreferences(STRING_PREFERENCIAM,context.MODE_PRIVATE);
        preferences.edit().putString(llave,cadena).apply();
    }
    public  static boolean obtenerPreferenceBooleanM(Context context,String llave){
        SharedPreferences preferences=context.getSharedPreferences(STRING_PREFERENCIAM,context.MODE_PRIVATE);
        return preferences.getBoolean(llave,false);
    }
    public  static  String obtenerPreferenceStringM(Context context,String llave){
        SharedPreferences preferences=context.getSharedPreferences(STRING_PREFERENCIAM,context.MODE_PRIVATE);
        return preferences.getString(llave,"");
    }
}
