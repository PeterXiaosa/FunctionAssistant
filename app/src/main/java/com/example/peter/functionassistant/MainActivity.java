package com.example.peter.functionassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnoneandonesolve = (Button) findViewById(R.id.btnoneandonesolve);
        Button btnoneandtwosolve = (Button) findViewById(R.id.btnoneandtwosolve2);
        Button btntwoandonesolve = (Button) findViewById(R.id.btntwoandonesolve);

        //点击求解一元一次方程按钮
        btnoneandonesolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OneAndOne.class);
                startActivity(intent);
            }
        });

        btnoneandtwosolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OneAndTwo.class);
                startActivity(intent);
            }
        });

        btntwoandonesolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,TwoAndOne.class));
            }
        });
    }
}
