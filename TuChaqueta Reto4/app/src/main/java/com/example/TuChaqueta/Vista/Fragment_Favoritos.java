package com.example.TuChaqueta.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.TuChaqueta.Modelo.Favoritos.AdaptadorFavoritos;
import com.example.TuChaqueta.Modelo.Favoritos.EntidadFavoritos;
import com.example.TuChaqueta.Modelo.DataBaseSQLController;
import com.example.tuChaqueta.R;

import java.util.ArrayList;

public class Fragment_Favoritos extends Fragment {

    private View view;
    private Cursor cursor;
    private ArrayList<EntidadFavoritos> listaFavoritos = new ArrayList<>();
    private ListView listViewComp;
    private int[] listafav = {R.drawable.check};
    private AdaptadorFavoritos adaptadorFavoritos;




    public Fragment_Favoritos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment__favoritos, container, false);
        //----------------------------------------------------------------------------------

        listViewComp = (ListView) view.findViewById(R.id.viewShopping);
        adaptadorFavoritos = new AdaptadorFavoritos(getProdComp(),getActivity());
        listViewComp.setAdapter(adaptadorFavoritos);

        return view;
    }

    private ArrayList<EntidadFavoritos> getProdComp(){
        DataBaseSQLController conector = new DataBaseSQLController(this.getActivity(), "AppChaqueta", null, 1);

        SQLiteDatabase db_read = conector.getReadableDatabase();

        cursor = db_read.rawQuery("SELECT * FROM favoritos", null);

        //Escritura de elementos de la Base de Datos a la parte visual
        while(cursor.moveToNext()){
            listaFavoritos.add(new EntidadFavoritos(listafav[cursor.getInt(0)], cursor.getString(1)));
        }

        return listaFavoritos;
    }
}