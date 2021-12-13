package com.example.TuChaqueta.Modelo.Productos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.TuChaqueta.Modelo.DataBaseSQLController;
import com.example.tuChaqueta.R;

import java.util.ArrayList;

/**
 * Adaptar los datos de entidad para ser mostrados en la lista
 */
public class AdaptadorProducto extends BaseAdapter {

    private ArrayList<EntidadProducto> listaProd;
    private Context context;

    public AdaptadorProducto(ArrayList<EntidadProducto> listaProd, Context context) {
        this.listaProd = listaProd;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaProd.size(); //devuelve el tamaño de la lista.
    }

    @Override
    public Object getItem(int pos) {
        return listaProd.get(pos); // devuelve el item que se esta trabajando.
    }

    @Override
    public long getItemId(int pos) {
        return 0;
    }

    /**
     * Se ponen los valores que corresponden a cada item
     * @param pos
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {

        EntidadProducto item = (EntidadProducto) getItem(pos);

        view = LayoutInflater.from(context).inflate(R.layout.item_producto, null);
        //------------------------------------------------------------------------
        ImageView img1 = (ImageView) view.findViewById(R.id.img);
        TextView titulo = (TextView) view.findViewById(R.id.titulo);
        TextView descripcion = (TextView) view.findViewById(R.id.descripcion);
        Button compra = (Button) view.findViewById(R.id.agregar);




        //-------------Enlazar elementos------------------------

        img1.setImageResource(item.getImagen());
        titulo.setText(item.getTitulo());
        descripcion.setText(item.getDescripcion());

        //------------------------------------------------------------------------

        compra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String titulo;
                DataBaseSQLController conector = new DataBaseSQLController(context, "AppChaqueta", null, 1);
                SQLiteDatabase db_write = conector.getWritableDatabase();
                titulo = item.getTitulo();
                conector.onUpgrade(db_write,1,2);
                db_write.execSQL("INSERT INTO favoritos VALUES (0,'"+titulo+"')");
                Toast.makeText(context, "Agregado "+ item.getTitulo(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}