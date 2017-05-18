package com.example.bd.tutorexpress;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CuentaTutor extends AppCompatActivity {

    Button bt1, bt2, bt3;
    EditText cu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta_tutor);

        bt1= (Button) findViewById(R.id.btMod);
        bt2= (Button) findViewById(R.id.btBaja);
        bt3= (Button) findViewById(R.id.btRegresar);
        cu = (EditText) findViewById(R.id.etT);
    }


    public void siguienteMod(View v){
        Intent intent = new Intent(CuentaTutor.this, TutorMod.class);
        startActivity(intent);
    }


    public void siguienteBaja(View v){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this, "administracion", null,1); //para bases de datos
        SQLiteDatabase db= admin.getWritableDatabase();
        String clave = cu.getText().toString();
        int cant= db.delete("alumnos", "cu=" + clave, null);
        if(cant==1)
            Toast.makeText(this,"Se borro existosamente al alumno " + clave, Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "No se borro el alumno", Toast.LENGTH_LONG).show();
        db.close();

        Intent intent = new Intent(CuentaTutor.this, MainTutor.class);
        startActivity(intent);
    }


    public void siguienteMenu(View v){
        Intent intent = new Intent(CuentaTutor.this, MainActivity.class);
        startActivity(intent);
    }

}
