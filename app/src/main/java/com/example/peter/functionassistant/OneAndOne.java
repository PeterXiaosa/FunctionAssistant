package com.example.peter.functionassistant;

import android.content.Intent;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class OneAndOne extends AppCompatActivity {
    TextView tv_x;
    EditText editText_a;
    EditText editText_b;
    Button btnSolve;
    Double parameter_a;
    Double parameter_b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_and_one);

        editText_a = (EditText) findViewById(R.id.editTexta);
        editText_b = (EditText) findViewById(R.id.editTextb);
        btnSolve = (Button) findViewById(R.id.btnoneandonesolve);
        tv_x = (TextView)findViewById(R.id.functionanswer);
        ImageView imageView = (ImageView) findViewById(R.id.iv_back);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btnSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat df   =new DecimalFormat("######0.000000");
                tv_x.setText(" ?");


                // 检验参数a,b是否输入
                if (!IsInputParametersIn()){
                    return;
                }
                // 检验参数a,b是否正确
                if(!IsInputParametersCorrect()){
                    return;
                }

                if (Math.abs(parameter_a - 0) < 0.000001){
                    Toast.makeText(getApplicationContext(),"参数a不能为0，请重新输入",Toast.LENGTH_SHORT).show();
                }
                else {
                    Double x;
                    x = parameter_b / parameter_a;
                    tv_x.setText(df.format(x).toString());
                }
            }
        });
    }

    private Boolean IsInputParametersCorrect() {
        try {
            parameter_a = Double.parseDouble(editText_a.getText().toString());
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"输入参数a格式有误，请重新输入",Toast.LENGTH_SHORT).show();
            return false;
        }
        try {
            parameter_b = Double.parseDouble(editText_b.getText().toString());
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"输入参数b格式有误，请重新输入",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private Boolean IsInputParametersIn(){
        if (editText_a.getText().toString().trim().equals("")){
            Toast.makeText(getApplicationContext(),"请输入参数a",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (editText_b.getText().toString().trim().equals("")){
            Toast.makeText(getApplicationContext(),"请输入参数b",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
