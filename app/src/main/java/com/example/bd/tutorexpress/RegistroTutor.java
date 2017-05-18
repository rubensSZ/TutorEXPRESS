package com.example.bd.tutorexpress;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroTutor extends AppCompatActivity {

    private EditText rCU, rContra, rNom, rMat;
    private Button btR, btContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_tutor);

        rCU= (EditText) findViewById(R.id.etRcu);
        rContra= (EditText) findViewById(R.id.etRcontra);
        rNom= (EditText) findViewById(R.id.etRnombre);
        rMat= (EditText) findViewById(R.id.etRmateria);
        btR= (Button) findViewById(R.id.btAgregar);
        btContinuar = (Button) findViewById(R.id.btContinuar);
    }

    public void altaTutor(View v){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this, "alta", null,1);
        SQLiteDatabase db= admin.getWritableDatabase();

        String cu= rCU.getText().toString();
        String contra= rContra.getText().toString();
        String nombre= rNom.getText().toString();
        String materia= rMat.getText().toString();

        ContentValues registro = new ContentValues();

        registro.put("cu", cu);
        registro.put("contraseña", contra);
        registro.put("nombre", nombre);
        registro.put("materia", materia);

        db.insert("usuario", null, registro);
        db.close();

        Toast.makeText(this,"Agregado exitosamente", Toast.LENGTH_LONG).show();


    }

    public void siguienteContinuar(View v){
        Intent intent = new Intent(RegistroTutor.this, MainTutor.class);
        Bundle b = new Bundle();
        b.putString("cu", rCU.getText().toString());
        intent.putExtras(b);
        startActivity(intent);
    }
}
