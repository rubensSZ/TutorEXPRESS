package com.example.bd.tutorexpress;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainEstudiante extends AppCompatActivity {

    private InterfazBD ibd;
    private ArrayList<String> tutores;
    private Button bt1;
    private ListView lv;
    ArrayAdapter adptr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_estudiante);

        bt1= (Button) findViewById(R.id.btTut);
        lv= (ListView) findViewById(R.id.lvTutores);

        AdminSQLiteOpenHelper db= new AdminSQLiteOpenHelper(getApplicationContext(),null,null,1);

        tutores = db.llenarLv();
        adptr = new ArrayAdapter(this,android.R.layout.simple_list_item_1, tutores);
        lv.setAdapter(adptr);
    }

    public void siguienteSalir(View v){
        Intent intent= new Intent(MainEstudiante.this, MainActivity.class);
        startActivity(intent);
    }
}
