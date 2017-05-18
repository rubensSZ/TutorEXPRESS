package com.example.bd.tutorexpress;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by bd on 16/05/2017.
 */

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    ConexionBD con;
    SQLiteDatabase db;

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super (context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuario (cu text primary key, contrasena text, nombre text, materia text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists usuario");
        db.execSQL("create table usuario (cu text primary key, contrasena text, nombre text, materia text)");

    }

    public void open()throws SQLiteException {
        db= con.getWritableDatabase();

    }


    public ArrayList llenar_lv(){
        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase db  = this.getWritableDatabase();
        String query = "select * from ususario";
        Cursor registro = db.rawQuery(query, null);
        if(registro.moveToFirst()){
            do{
                lista.add(registro.getString(2));
            }while(registro.moveToNext());
        }
        return lista;

    }

    public ArrayList llenarLv(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Ruben");
        lista.add("Economia");
        lista.add("");
        lista.add("Ricardo");
        lista.add("DAI");
        lista.add("");
        lista.add("Yago");
        lista.add("Psicologia");
        lista.add("");
        lista.add("Jose Chuy");
        lista.add("Sistemas Empresariales");
        lista.add("");

        return lista;

    }
}
