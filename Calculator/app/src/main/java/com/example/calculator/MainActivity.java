package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText display;
    Button add, sub, mul, div;

    boolean isNum1 = false;
    boolean isNum2 = false;
    boolean isOperator = false;
    boolean isResult = false;
    boolean isChange = false;

    DecimalFormat df = new DecimalFormat("#.#####");
    String operator = "";
    String show = "";
    String num1, num2;

    double result, n1, n2;
    int bit1, bit2, binaryNum;

    public String formatD(double num){
        return df.format(num);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("20174016 김혜린 Calculator");

        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        mul = (Button) findViewById(R.id.mul);
        div = (Button) findViewById(R.id.div);

        display = (EditText) findViewById(R.id.display);
    }

    public void buttonClick(View v) {
        if(!isChange) {

            switch (v.getId()) {
                case R.id.change:
                    setTitle("20174016 김혜린 BIT Calculator");
                    isChange = true;
                    add.setText("AND");
                    sub.setText("OR");
                    mul.setText("NOT");
                    div.setText("XOR");
                    display.setText("0");
                    show = "";
                    isNum1 = false;
                    isNum2 = false;
                    break;
                case R.id.clear:
                    display.setText("0");
                    show = "";
                    isNum1 = false;
                    isNum2 = false;
                    break;

                case R.id.btn1:
                    show = show + "1";
                    display.setText(show);
                    break;
                case R.id.btn2:
                    show = show + "2";
                    display.setText(show);
                    break;
                case R.id.btn3:
                    show = show + "3";
                    display.setText(show);
                    break;
                case R.id.btn4:
                    show = show + "4";
                    display.setText(show);
                    break;
                case R.id.btn5:
                    show = show + "5";
                    display.setText(show);
                    break;
                case R.id.btn6:
                    show = show + "6";
                    display.setText(show);
                    break;
                case R.id.btn7:
                    show = show + "7";
                    display.setText(show);
                    break;
                case R.id.btn8:
                    show = show + "8";
                    display.setText(show);
                    break;
                case R.id.btn9:
                    show = show + "9";
                    display.setText(show);
                    break;
                case R.id.btn0:
                    show = show + "0";
                    display.setText(show);
                    break;

                case R.id.dot:
                    show = show + ".";
                    display.setText(show);
                    break;

                case R.id.add:
                    isOperator = true;
                    operator = "+";
                    break;

                case R.id.sub:
                    isOperator = true;
                    operator = "-";
                    break;

                case R.id.mul:
                    isOperator = true;
                    operator = "*";
                    break;

                case R.id.div:
                    isOperator = true;
                    operator = "/";
                    break;

                case R.id.modular:
                    isOperator = true;
                    operator = "%";
                    break;

                case R.id.result:
                    isOperator = true;
                    isResult = true;
                    break;
            }
        }

        else{   // 비트 연산자 계산기
            switch (v.getId()){
                case R.id.change:
                    setTitle("20174016 김혜린 Calculator");
                    isChange = false;
                    add.setText("+");
                    sub.setText("ㅡ");
                    mul.setText("X");
                    div.setText("/");
                    display.setText("0");
                    show = "";
                    isNum1 = false;
                    isNum2 = false;
                    break;
                case R.id.clear:
                    display.setText("0");
                    show = "";
                    isNum1 = false;
                    isNum2 = false;
                    break;
                case R.id.btn1:
                    show = show + "1";
                    display.setText(show);
                    break;

                case R.id.btn2:
                    show = show + "2";
                    display.setText(show);
                    break;

                case R.id.btn3:
                    show = show + "3";
                    display.setText(show);
                    break;

                case R.id.btn4:
                    show = show + "4";
                    display.setText(show);
                    break;

                case R.id.btn5:
                    show = show + "5";
                    display.setText(show);
                    break;

                case R.id.btn6:
                    show = show + "6";
                    display.setText(show);
                    break;

                case R.id.btn7:
                    show = show + "7";
                    display.setText(show);
                    break;

                case R.id.btn8:
                    show = show + "8";
                    display.setText(show);
                    break;

                case R.id.btn9:
                    show = show + "9";
                    display.setText(show);
                    break;

                case R.id.btn0:
                    show = show + "0";
                    display.setText(show);
                    break;

//************************연산자************************//
                case R.id.add:
                    isOperator = true;
                    operator = "&";
                    break;

                case R.id.sub:
                    isOperator = true;
                    operator = "|";
                    break;

                case R.id.mul:
                    num1 = display.getText().toString();
                    bit1 = Integer.parseInt(num1);
                    bit1 = ~bit1;
                    show = Integer.toString(bit1);
                    display.setText(show);
                    show = "";
                    break;

                case R.id.div:
                    isOperator = true;
                    operator = "^";
                    break;

                case R.id.result:
                    isOperator = true;
                    isResult = true;
                    break;

                case R.id.dot:
                    num1 = display.getText().toString();
                    binaryNum = Integer.parseInt(num1);
                    show = Integer.toBinaryString(binaryNum);
                    display.setText(show);
                    break;
            }
        }

        if (isOperator) {   // 연산자가 클릭되어 있다면
            if(isNum1){
                num2 = display.getText().toString();
                n1 = Double.parseDouble(num1);
                n2 = Double.parseDouble(num2);
                isNum2 = true;
            }

            else{
                num1 = display.getText().toString();
                show = "";
                isOperator = false;
                isNum1 = true;
            }

            if(isNum1 && isNum2){
                switch(operator){
                    case "+":
                        result = n1 + n2;
                        break;
                    case "-":
                        result = n1 - n2;
                        break;

                    case "*":
                        result = n1 * n2;
                        break;

                    case "/":
                        result = n1 / n2;
                        break;

                    case "%":
                        result = n1 % n2;
                        break;

                    case "&":
                        bit1 = (int)n1;
                        bit2 = (int)n2;
                        result = bit1 & bit2;
                        break;
                    case "|":
                        bit1 = (int)n1;
                        bit2 = (int)n2;
                        result = bit1 | bit2;
                        break;

                    case "^":
                        bit1 = (int)n1;
                        bit2 = (int)n2;
                        result = bit1 ^ bit2;
                        break;
            }

                if(isResult){
                    isNum1 = false;
                    isResult = false;
                }
                num1 = Double.toString(result);

                isNum2 = false;
                isOperator = false;
                show = formatD(result);
                display.setText(show);
                show = "";
            }
        }
    }
}