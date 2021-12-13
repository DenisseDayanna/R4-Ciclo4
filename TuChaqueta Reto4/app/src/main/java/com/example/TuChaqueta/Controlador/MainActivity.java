package com.example.TuChaqueta.Controlador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.tuChaqueta.R;
import com.example.TuChaqueta.Vista.FragmentInicio;
import com.example.TuChaqueta.Vista.Fragment_Productos;
import com.example.TuChaqueta.Vista.Fragment_Servicios;
import com.example.TuChaqueta.Vista.Fragment_Favoritos;
import com.example.TuChaqueta.Vista.Fragment_Sucursales;

public class MainActivity extends AppCompatActivity {

    /**
     * Declaracion de variables.
     */
    private Fragment pantalla;
    private Fragment pantallaprod;
    private Fragment pantallaserv;
    private Fragment pantallasuc;
    private Fragment pantallafav;
    private FragmentTransaction cambioPantalla;

    /**
     * inicialización de la pantalla Activity Main.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantalla = new FragmentInicio();
        pantallaprod = new Fragment_Productos();
        pantallaserv = new Fragment_Servicios();
        pantallasuc = new Fragment_Sucursales();
        pantallafav = new Fragment_Favoritos();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragments, pantalla).commit();

    }
    //--------------------------MENU OPCIONES-------------------------------

    /**
     * creación del menu desplegable en la barra superior.
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuoptions,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.productos) {
            cambioPantalla = getSupportFragmentManager().beginTransaction();
            cambioPantalla.replace(R.id.contenedor_fragments, pantallaprod).commit();
            Toast.makeText(getApplicationContext(), "Estos son nuestros productos", Toast.LENGTH_LONG).show();
        }
        if (id == R.id.servicios) {
            cambioPantalla = getSupportFragmentManager().beginTransaction();
            cambioPantalla.replace(R.id.contenedor_fragments, pantallaserv).commit();
            Toast.makeText(getApplicationContext(), "Conoce nuestros servicios", Toast.LENGTH_LONG).show();
        }
        if (id == R.id.sucursales) {
            cambioPantalla = getSupportFragmentManager().beginTransaction();
            cambioPantalla.replace(R.id.contenedor_fragments, pantallasuc).commit();
            Toast.makeText(getApplicationContext(), "¡Visítanos!", Toast.LENGTH_LONG).show();
        }
        if (id == R.id.home) {
            cambioPantalla = getSupportFragmentManager().beginTransaction();
            cambioPantalla.replace(R.id.contenedor_fragments, pantalla).commit();
            Toast.makeText(getApplicationContext(), "Comencemos", Toast.LENGTH_LONG).show();
        }
        if (id == R.id.favoritos) {
            cambioPantalla = getSupportFragmentManager().beginTransaction();
            cambioPantalla.replace(R.id.contenedor_fragments, pantallafav).commit();
            Toast.makeText(getApplicationContext(), "Tus favoritos", Toast.LENGTH_LONG).show();
        }
        if (id == R.id.compartir) {
            Intent compartir = new Intent(Intent.ACTION_SEND);
            compartir.setType("text/plain");
            String mensaje = "Te recomiendo esta App para comprar TuChaqueta.";
            compartir.putExtra(Intent.EXTRA_SUBJECT, "TuChaqueta App");
            compartir.putExtra(Intent.EXTRA_TEXT, mensaje);
            startActivity(Intent.createChooser(compartir, "Compartir vía"));
            return super.onOptionsItemSelected(item);
        }
        //*****************************************************************************************************************
        return false;
    }
}