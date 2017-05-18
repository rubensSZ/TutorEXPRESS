package com.example.bd.tutorexpress;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

/**
 * Created by bd on 17/05/2017.
 */

public class InterfazBD {

    ConexionBD con;
    SQLiteDatabase db;

    public InterfazBD(Context context){
        con = new ConexionBD(context);
    }

    public void open()throws SQLiteException {
        db= con.getWritableDatabase();
    }

    public void close()throws SQLiteException{
        con.close();
    }

    public long insertarDatos(String dato){
        ContentValues valores;
        open();
        valores= new ContentValues();
        valores.put("datos", dato);
        long clave= db.insert("usuario",null,valores);
        close();
        return clave;
    }

    public void insertarDatosPrueba(){
        ContentValues val;
        open();
        val= new ContentValues();
        val.put("datos", "Hola");
        db.insert("tablaprueba", null, val);
        val.put("datos", "como");
        db.insert("tablaprueba", null, val);
        val.put("datos", "estas");
        db.insert("tablaprueba", null, val);

    }

    public String traerDato(long clave){
        open();
        String cla= Long.toString(clave);
        String query= "select * from usuario where cu= " +cla + ";";
        Cursor c= db.rawQuery(query,null);
        c.moveToNext();
        String res= c.getString(1);
        c.close();
        close();
        return res;
    }

    public Cursor traerTodaInfo(){
        Cursor res= null;
        open();
        String query="select * from usuario";
        res = db.rawQuery(query,null);
        if (res.getCount() ==0) {
            insertarDatosPrueba();
            res=db.rawQuery(query,null);
        }
        return res;
    }

    public Cursor listaTutores(){
        Cursor res= null;
        open();
        String query= "select cu from usuario";
        res = db.rawQuery(query,null);

        return res;
    }



}
