package com.example.TuChaqueta.Modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseSQLController extends SQLiteOpenHelper {

    public DataBaseSQLController(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        //******************************* TABLA PRODUCTOS***************************
        //Creacion de la tabla
        database.execSQL("CREATE TABLE productos (img INT, titulo TEXT, descripcion TEXT)");

        //llenar la tabla con datos
        database.execSQL("INSERT INTO productos VALUES (0,'Chaqueta Deportiva hombre','Precio: $60.000')");
        database.execSQL("INSERT INTO productos VALUES (1,'Chaqueta Deportiva mujer con capota','Precio: $60.000')");
        database.execSQL("INSERT INTO productos VALUES (2,'Chaqueta Deportiva mujer sin capota','Precio: $50.000')");
        database.execSQL("INSERT INTO productos VALUES (3,'Chaqueta Infantil','Precio: $40.000')");

        //******************************* TABLA SERVICIOS***************************
        //Creacion de la tabla

        database.execSQL("CREATE TABLE servicios (img INT, titulo TEXT)");

        //llenar la tabla con datos
        database.execSQL("INSERT INTO servicios VALUES (0,'Trae tu diseño y nosotros nos encargamos de hacerlo realidad.')");
        database.execSQL("INSERT INTO servicios VALUES (1,'Elige uno de nuestros diseños y personalizalo.')");
        database.execSQL("INSERT INTO servicios VALUES (2,'Brindamos servicio de lavandería utilizando productos que cuidan todo tipo de tela. Tus prendas se verán como nuevas..')");

        //******************************* TABLA FAVORITOS ******************************
        database.execSQL("CREATE TABLE favoritos (img INT, titulo TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
       database.execSQL("DROP TABLE productos");
       database.execSQL("DROP TABLE servicios");
       database.execSQL("DROP TABLE favoritos");
       onCreate(database);

    }
}
