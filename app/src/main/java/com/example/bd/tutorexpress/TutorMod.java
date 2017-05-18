package com.example.bd.tutorexpress;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TutorMod extends AppCompatActivity {

    private EditText et1, et2, et3, et4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_mod);

        et1 = (EditText) findViewById(R.id.etCambioPwd);
        et2 = (EditText) findViewById(R.id.etConfirmacionCambioPwd);
        et3 = (EditText) findViewById(R.id.etCambioMat);
        et4 = (EditText) findViewById(R.id.etCLAVE);

    }
    public void modificar (View v) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this , "admin", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String contra = et1.getText().toString();
        String confirmaContra = et2.getText().toString();
        String materia = et3.getText().toString();
        String clave = et4.getText().toString();

        ContentValues registro = new ContentValues();

        if(contra.equals(confirmaContra)) {
            registro.put("contrasena", contra);
            registro.put("materia", materia);
            }

        int cant = db.update("usuarios", registro, "cu="+clave, null);
        if(cant ==1){
            Toast.makeText(this, "Los cambios se han realizado correctamente", Toast.LENGTH_LONG).show();
        }else

            Toast.makeText(this, "Las contraseñas son diferentes", Toast.LENGTH_LONG).show();
        db.close();
    }
}
