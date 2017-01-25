package com.example.peter.functionassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class OneAndTwo extends AppCompatActivity {
    EditText editText_a,editText_b,editText_c;
    TextView tv_answer;
    TextView tv_answer2;
    Button btnSolve;
    ImageView iv_back2;
    Double parameter_a;
    Double parameter_b;
    Double parameter_c;
    Double delta;
    Double x1,x2;
    private LinearLayout ll_answer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_and_two);

        editText_a = (EditText)findViewById(R.id.et_a);
        editText_b = (EditText)findViewById(R.id.et_b);
        editText_c = (EditText)findViewById(R.id.et_c);
        tv_answer = (TextView)findViewById(R.id.oneAndTwoAnswser);
        tv_answer2 = (TextView)findViewById(R.id.oneAndTwoAnswser2);
        ll_answer1 = (LinearLayout) findViewById(R.id.ll_answer1);
        btnSolve = (Button)findViewById(R.id.btnSolveOneTwo);
        iv_back2 = (ImageView)findViewById(R.id.iv_back2);

        btnSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll_answer1.setVisibility(View.VISIBLE);
                DecimalFormat df   =new DecimalFormat("######0.000000");
                tv_answer.setText(" ?");
                tv_answer2.setText(" ?");
                // 检验参数a,b,c是否输入
                if (!IsInputParametersIn()) {
                    return;
                }
                // 检验参数a,b,c是否正确
                if (!IsInputParametersCorrect()) {
                    return;
                }

                if (Math.abs(parameter_a - 0) < 0.000001) {
                    Toast.makeText(getApplicationContext(), "参数a不能为0，请重新输入", Toast.LENGTH_SHORT).show();
                } else {
                    // a不为0时
                    delta = parameter_b * parameter_b - 4 * parameter_a * parameter_c;

                    if(Math.abs(delta - 0) > 0.000001 && delta < 0) {
                        tv_answer.setText("无解");
                        tv_answer2.setText("无解");
                        Toast.makeText(getApplicationContext(), "△小于0，方程无解", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    // delta == 0
                    else if(Math.abs(delta - 0) < 0.000001) {
                        Toast.makeText(getApplicationContext(), "△等于0，方程有2个相同解", Toast.LENGTH_SHORT).show();
                        ll_answer1.setVisibility(View.INVISIBLE);
                        x1 = -parameter_b / (2 * parameter_a);
                        tv_answer.setText(df.format(x1).toString());
                    }
                    else if(Math.abs(delta - 0) > 0.000001 && delta > 0){
                        x1 = (-parameter_b + Math.sqrt(delta)) / (2 * parameter_a);
                        x2 = (-parameter_b - Math.sqrt(delta)) / (2 * parameter_a);
                        tv_answer.setText(df.format(x1).toString());
                        tv_answer2.setText(df.format(x2).toString());
                    }
                }
            }
        });

        iv_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
        try {
            parameter_c = Double.parseDouble(editText_c.getText().toString());
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"输入参数c格式有误，请重新输入",Toast.LENGTH_SHORT).show();
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
        if (editText_c.getText().toString().trim().equals("")){
            Toast.makeText(getApplicationContext(),"请输入参数c",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
