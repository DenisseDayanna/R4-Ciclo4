package com.example.TuChaqueta.Modelo.Favoritos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tuChaqueta.R;

import java.util.ArrayList;

public class AdaptadorFavoritos extends BaseAdapter {

    private ArrayList<EntidadFavoritos> listaCompra;
    private Context context;


    public AdaptadorFavoritos(ArrayList<EntidadFavoritos> listaCompra, Context context) {
        this.listaCompra = listaCompra;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaCompra.size();
    }

    @Override
    public Object getItem(int pos) {
        return listaCompra.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
    }

    /**
     * Se ponen los enlaces correspondientes a cada item
     * @param pos
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        EntidadFavoritos item = (EntidadFavoritos) getItem(pos);
        view = LayoutInflater.from(context).inflate(R.layout.item_favoritos, null);
        //-------------------------------------------------------------------
        ImageView img1 = (ImageView) view.findViewById(R.id.imgBuy);
        TextView titulo = (TextView) view.findViewById(R.id.tituloComp);
        ImageButton borrar = (ImageButton) view.findViewById(R.id.delete);

        //

        //------------------- ENLAZAR ELEMENTOS -----------------------------
        img1.setImageResource(item.getImagen());
        titulo.setText(item.getTitulo());

        //-------------------- OBTENER DATOS -----------------------------



        return view;
    }
}
