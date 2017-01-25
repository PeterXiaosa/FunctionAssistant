package com.example.peter.functionassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class TwoAndOne extends AppCompatActivity {
    TextView tv_x,tv_y;
    EditText et_a,et_b,et_c,et_d,et_m,et_n;
    ImageView iv_back;
    Button btnSolve;
    Double parameter_a,parameter_b,parameter_c,parameter_d,parameter_m,parameter_n,x,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_and_one);

        tv_x = (TextView)findViewById(R.id.tv_x);
        tv_y = (TextView)findViewById(R.id.tv_y);
        et_a = (EditText)findViewById(R.id.et_a);
        et_b = (EditText)findViewById(R.id.et_b);
        et_c = (EditText)findViewById(R.id.et_c);
        et_d = (EditText)findViewById(R.id.et_d);
        et_m = (EditText)findViewById(R.id.et_m);
        et_n = (EditText)findViewById(R.id.et_n);
        iv_back = (ImageView)findViewById(R.id.iv_backtwoandone);
        btnSolve = (Button)findViewById(R.id.btnSolveTwoOne);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_x.setText(" ?");
                tv_y.setText(" ?");
                if(!IsInputParametersIn()){
                    return;
                }
                if(!IsInputParametersCorrect()){
                    return;
                }
                if(IsInputParametersZero()){
                    return;
                }
                IsFunctionHaveSolve();

            }
        });
    }

    private void IsFunctionHaveSolve() {
        DecimalFormat df   =new DecimalFormat("######0.000000");
        // ad - bc != 0 only have one answer
        // ad - bc == 0 and an - mc == 0 have infinite answers
        // ad - bc == 0 and an - mc !=0 no answer
        if(Math.abs(parameter_a * parameter_d - parameter_b * parameter_c - 0) < 0.000001
                && Math.abs(parameter_a * parameter_n - parameter_m * parameter_c - 0 ) > 0.0001){
            Toast.makeText(getApplicationContext(),"该二元一次方程组无解",Toast.LENGTH_SHORT).show();
        }
        else if (Math.abs(parameter_a * parameter_d - parameter_b * parameter_c - 0) < 0.000001
                && Math.abs(parameter_a * parameter_n - parameter_m * parameter_c - 0 ) < 0.000001){
            Toast.makeText(getApplicationContext(),"该二元一次方程有无穷解",Toast.LENGTH_SHORT).show();
        }
        else if (Math.abs(parameter_a * parameter_d - parameter_b * parameter_c - 0) > 0.0001){
            y = (parameter_m * parameter_c - parameter_n * parameter_a) / (parameter_b * parameter_c - parameter_a * parameter_d);
            x = (parameter_m - parameter_b * y) / parameter_a;
            tv_x.setText(df.format(x).toString());
            tv_y.setText(df.format(y).toString());
        }
    }

    private Boolean IsInputParametersCorrect() {
        try {
            parameter_a = Double.parseDouble(et_a.getText().toString());
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"输入参数a格式有误，请重新输入",Toast.LENGTH_SHORT).show();
            return false;
        }
        try {
            parameter_b = Double.parseDouble(et_b.getText().toString());
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"输入参数b格式有误，请重新输入",Toast.LENGTH_SHORT).show();
            return false;
        }
        try {
            parameter_c = Double.parseDouble(et_c.getText().toString());
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"输入参数c格式有误，请重新输入",Toast.LENGTH_SHORT).show();
            return false;
        }
        try {
            parameter_d = Double.parseDouble(et_d.getText().toString());
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"输入参数d格式有误，请重新输入",Toast.LENGTH_SHORT).show();
            return false;
        }
        try {
            parameter_m = Double.parseDouble(et_m.getText().toString());
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"输入参数m格式有误，请重新输入",Toast.LENGTH_SHORT).show();
            return false;
        }
        try {
            parameter_n = Double.parseDouble(et_n.getText().toString());
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"输入参数n格式有误，请重新输入",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private Boolean IsInputParametersIn(){
        if (et_a.getText().toString().trim().equals("")){
            Toast.makeText(getApplicationContext(),"请输入参数a",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (et_b.getText().toString().trim().equals("")){
            Toast.makeText(getApplicationContext(),"请输入参数b",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (et_c.getText().toString().trim().equals("")){
            Toast.makeText(getApplicationContext(),"请输入参数c",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (et_d.getText().toString().trim().equals("")){
            Toast.makeText(getApplicationContext(),"请输入参数d",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (et_m.getText().toString().trim().equals("")){
            Toast.makeText(getApplicationContext(),"请输入参数m",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (et_n.getText().toString().trim().equals("")){
            Toast.makeText(getApplicationContext(),"请输入参数n",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private Boolean IsInputParametersZero(){
        if (Math.abs(parameter_a - 0) < 0.000001){
            Toast.makeText(getApplicationContext(),"参数a不能为0，请重新输入",Toast.LENGTH_SHORT).show();
            return true;
        }
        if (Math.abs(parameter_b - 0) < 0.000001){
            Toast.makeText(getApplicationContext(),"参数b不能为0，请重新输入",Toast.LENGTH_SHORT).show();
            return true;
        }
        if (Math.abs(parameter_c - 0) < 0.000001){
            Toast.makeText(getApplicationContext(),"参数c不能为0，请重新输入",Toast.LENGTH_SHORT).show();
            return true;
        }
        if (Math.abs(parameter_d - 0) < 0.000001){
            Toast.makeText(getApplicationContext(),"参数d不能为0，请重新输入",Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
