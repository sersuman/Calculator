package com.example.calculator;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int[] idArray = {R.id.btnOne, R.id.btnTwo, R.id.btnThree, R.id.btnFour, R.id.btnFive, R.id.btnSix, R.id.btnSeven, R.id.btnEight, R.id.btnNine, R.id.btnZero};
    private Button btnCalculate, btnSum, btnMinus, btnMultiply, btnDivide, btnEdit;
    private Button[] bt = new Button[idArray.length];
    private EditText etValues;
    private int firstInt, secondInt, result;
    private TextView tvProcess;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvProcess = findViewById(R.id.tvProcess);
        etValues = findViewById(R.id.etValues);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnSum = findViewById(R.id.btnSum);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnEdit = findViewById(R.id.btnEdit);


        for (int i = 0; i < idArray.length; i++) {
            final int b = i;
            bt[b] = findViewById(idArray[b]); // Fetch the view id from array
            bt[b].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String a = bt[b].getText().toString();
                    etValues.append(a);
                }
            });
            btnCalculate.setOnClickListener(this);
            btnSum.setOnClickListener(this);
            btnMinus.setOnClickListener(this);
            btnMultiply.setOnClickListener(this);
            btnDivide.setOnClickListener(this);
            btnEdit.setOnClickListener(this);

        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnEdit){
            etValues.setText("");
            tvProcess.setText("");
        }
        if (v.getId() == R.id.btnSum){
            operator = "+";
            firstInt = Integer.parseInt(etValues.getText().toString());
            tvProcess.setText(Integer.toString(firstInt)+"+");
            etValues.setText("");
        }else if (v.getId() == R.id.btnMinus){
            operator = "-";
            firstInt = Integer.parseInt(etValues.getText().toString());
            tvProcess.setText(Integer.toString(firstInt)+"-");
            etValues.setText("");
        }if (v.getId() == R.id.btnMultiply){
            operator = "*";
            firstInt = Integer.parseInt(etValues.getText().toString());
            tvProcess.setText(Integer.toString(firstInt)+"*");
            etValues.setText("");
        }if (v.getId() == R.id.btnDivide){
            operator = "/";
            firstInt = Integer.parseInt(etValues.getText().toString());
            tvProcess.setText(Integer.toString(firstInt)+"/");
            etValues.setText("");
        }else if (v.getId() == R.id.btnCalculate){
            secondInt = Integer.parseInt(etValues.getText().toString());
            int result = calculate(secondInt,operator);
//            result = firstInt + secondInt;
            tvProcess.append(Integer.toString(secondInt));
            etValues.setText(String.format("%d",result));
        }

    }

    public int calculate(int secondInt, String operator) {
        if (operator.equals("+")){
             result = firstInt + secondInt;
        }else if (operator.equals("-")){
            result = firstInt - secondInt;
        }else if (operator.equals("*")){
            result = firstInt * secondInt;
        }else if (operator.equals("/")){
            result = firstInt / secondInt;
        }
        return result;
    }

}