package com.example.bd.tutorexpress;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainTutor extends AppCompatActivity {

    private Button btSI, btR;
    private EditText CU, contra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tutor);
        CU = (EditText) findViewById(R.id.etCU);
        contra = (EditText) findViewById(R.id.etContra);
        btSI = (Button) findViewById(R.id.btSignIn);
        btR = (Button) findViewById(R.id.btRegistrar);

    }

    public void siguienteRegistro(View v){
        Intent intent= new Intent(MainTutor.this, RegistroTutor.class);
        startActivity(intent);
    }

   public void signIn(View v){
       AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this, "admin", null,1);
       SQLiteDatabase db= admin.getWritableDatabase();

       String clave= CU.getText().toString();
       String cont= contra.getText().toString();

       Cursor fila = db.rawQuery("select * from usuario where cu='"+clave+"'", null);

       if(fila.moveToFirst()){
           String pwd= fila.getString(1);

           if(pwd.equals(cont)){
               Intent intent= new Intent(MainTutor.this, CuentaTutor.class);
               startActivity(intent);

           }

       }
       else
           Toast.makeText(this, "CU o contraseña incorrecta", Toast.LENGTH_LONG).show();

       db.close();
   }

}
