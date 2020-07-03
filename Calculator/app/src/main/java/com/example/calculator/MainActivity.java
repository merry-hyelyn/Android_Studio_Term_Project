package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText display;
    Button add ,sub, mul, div, modular, result;
    Button[] numButton = new Button[10];
    Integer[] numBtnID = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5,
            R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};

    String num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("20174016 김혜린 Calculator");

        display = (EditText) findViewById(R.id.display);
        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        mul = (Button) findViewById(R.id.mul);
        div = (Button) findViewById(R.id.div);
        modular = (Button) findViewById(R.id.modular);
        result = (Button) findViewById(R.id.result);

        for(int i=0; i<10;i++){
            numButton[i] = (Button) findViewById(numBtnID[i]);
        }
    }
}