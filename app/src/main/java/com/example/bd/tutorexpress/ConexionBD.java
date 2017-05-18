package com.example.bd.tutorexpress;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bd on 17/05/2017.
 */

public class ConexionBD extends SQLiteOpenHelper {

    String cadenaCreate= "create table if not exists usuario(cu integer primary key, contrasena text, nombre text, materia text)";

    public ConexionBD(Context context) {
        super(context, "usuario", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(cadenaCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String cadenaUpdate= "drop table if exists usuario";
        db.execSQL(cadenaUpdate);
        onCreate(db);
    }

}
