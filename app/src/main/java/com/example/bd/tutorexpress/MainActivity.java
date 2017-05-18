package com.example.bd.tutorexpress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bt1;
    private Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1= (Button) findViewById(R.id.btEstudiante);
        bt2= (Button) findViewById(R.id.btTutor);
    }

    public void siguienteEST(View v){
        Intent intent= new Intent(MainActivity.this, MainEstudiante.class);
        startActivity(intent);
    }

    public void siguienteTUTOR(View v){
        Intent intent= new Intent(MainActivity.this, MainTutor.class);
        startActivity(intent);
    }
}
