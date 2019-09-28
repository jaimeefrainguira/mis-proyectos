package com.hugo.empresa.buscandoando;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.hugo.empresa.buscandoando.configuracion.registronegocio;
import com.hugo.empresa.buscandoando.empresas.fragmento_empresa;
import com.hugo.empresa.buscandoando.producto.fragmento_producto;
import com.hugo.empresa.buscandoando.producto.registroproducto;
import com.hugo.empresa.buscandoando.servicios.fragmento_servicios;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;


public class menu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, fragmento_producto.OnFragmentInteractionListener,fragmento_empresa.OnFragmentInteractionListener,fragmento_servicios.OnFragmentInteractionListener
         {
             private VolleyRP volley;
             private RequestQueue mresq;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private String EMISOR;
    private TextView txtnombreusuario;
    private TextView txtcorreo;
    //private  TextView txtingresoperfil;
    private ImageView fotoUsuario;
    private String id_usuario;
    public String stringFotoUsuario;
    public String foto=dominio.dominio+"BuscandoAndo/Controlador/FotoUsuario/error.png";
    private static final String IP_IDUSUARIO=dominio.dominio+"BuscandoAndo/Controlador/consultaUsuarioXCorreo.php?id=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        volley=VolleyRP.getInstance(this);
        mresq=volley.getRequestQueue();

        EMISOR=preferences.obtenerPreferenceString(this,preferences.PREFERENCE_USUARIO_LOGIN);

        //Toast.makeText(this,EMISOR,Toast.LENGTH_SHORT).show();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //manipulo los elementos del nav_menu mas informacion https://es.stackoverflow.com/questions/45032/cambiar-la-informacion-del-navigation-drawer-a-partir-de-su-activity-padre
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View hView = navigationView.getHeaderView(0);
        fotoUsuario=(ImageView)hView.findViewById(R.id.fotodePerfil);
        txtnombreusuario=(TextView)hView.findViewById(R.id.txtnombreusuario);
        //txtingresoperfil=(TextView)hView.findViewById(R.id.txtingresoperfil);
        txtcorreo=(TextView)hView.findViewById(R.id.txtcorreo);
        SolicitaUsuario(IP_IDUSUARIO+EMISOR);
        //txtcorreo.setText(EMISOR);

        navigationView.setNavigationItemSelectedListener(this);


    }
             @Override
             public void onFragmentInteraction(Uri uri) {

             }

             /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_submenu, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public static class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment selectedFragment = null;
            switch (position) {
                case 0:
                    selectedFragment = new fragmento_empresa();
                    break;
                case 1:
                    selectedFragment = new fragmento_servicios();
                    break;
                case 2:
                    selectedFragment = new fragmento_producto();
                    break;
            }
            return selectedFragment;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }

             @Override
             public void onBackPressed() {
                 DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                 if (drawer.isDrawerOpen(GravityCompat.START)) {
                     drawer.closeDrawer(GravityCompat.START);
                 } else {
                     super.onBackPressed();
                 }
             }
             @SuppressWarnings("StatementWithEmptyBody")
             @Override
             public boolean onNavigationItemSelected(MenuItem item) {
                 // Handle navigation view item clicks here.
                 Fragment mifragment=null;
                 boolean fragmentselecciondo=false;

                 int id = item.getItemId();

                 if (id == R.id.nav_inicio) {
                     // Handle the camera action

                     Intent intent = new Intent(this, login.class);
                     startActivityForResult(intent, 0);
                     finish();

                 } else if (id == R.id.nav_perfil) {
                     Intent intent = new Intent(this, editar_perfil.class);
                     startActivityForResult(intent, 0);

                 } else if (id == R.id.nav_menbrecias) {
                     Intent intent = new Intent(this, loginmenbrecia.class);
                     startActivity(intent);
                     //Intent intent = new Intent(this, com.hugo.empresa.buscandoando.pruebas.MainActivity.class);
                     //startActivity(intent);
                 }else if (id == R.id.nav_PublicaGratis) {
                     //para publicar producto gratis
                     Intent intent = new Intent(this, registroproducto.class);
                     startActivity(intent);
                     //Intent intent = new Intent(this, com.hugo.empresa.buscandoando.pruebas.MainActivity.class);
                     //startActivity(intent);
                 }
                 else if (id == R.id.nav_FOTO) {
                     //para publicar producto gratis
                     Intent intent = new Intent(this, uploadImagen.class);
                     startActivity(intent);
                     //Intent intent = new Intent(this, com.hugo.empresa.buscandoando.pruebas.MainActivity.class);
                     //startActivity(intent);
                 }
                 else if (id == R.id.nav_salir) {
                    preferences.guardarPreferenceBoolean(menu.this,false,preferences.PREFERENCE_ESTADO_BUTTON);
                    Intent i=new Intent(menu.this,login.class);
                    startActivity(i);
                    finish();
                 }

                 if (fragmentselecciondo==true){
                     getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, mifragment).commit();
                 }

                 DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                 drawer.closeDrawer(GravityCompat.START);
                 return true;
             }
//codigo agregado por hugo sacaquirin
public void SolicitaUsuario(String URL){
    JsonObjectRequest solicitud=new JsonObjectRequest(URL, null, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject datos) {
            cargaUsuario(datos);
        }
    },new Response.ErrorListener(){
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(menu.this,"No se logro conectar con el servidor",Toast.LENGTH_SHORT).show();
        }
    });
    VolleyRP.addToQueue(solicitud,mresq,this,volley);
}
             public void cargaUsuario(JSONObject datos){
                 try {
                     JSONObject jsondatos=new JSONObject(datos.getString("id"));
                     id_usuario=jsondatos.getString("usu_codigo");
                     if(id_usuario != null) {
                         txtcorreo.setText(jsondatos.getString("usu_nombre") + " " + jsondatos.getString("usu_apellido"));
                         //fotoUsuario.setImageURI(Uri.parse(jsondatos.getString("usu_imagen")));
                         Picasso.with(menu.this).load(jsondatos.getString("usu_imagen")).error(R.drawable.icono_perfil).into(fotoUsuario);
                         stringFotoUsuario=jsondatos.getString("usu_imagen");
                         foto=stringFotoUsuario;
                     }
                 } catch (JSONException e) {
                     e.printStackTrace();
                 }

             }
             public void clicIditaFoto(View v){
                 Intent i=new Intent(menu.this,editar_fotoperfil.class);
                 i.putExtra("fotoUsuario",foto);
                 startActivity(i);
             }

}
