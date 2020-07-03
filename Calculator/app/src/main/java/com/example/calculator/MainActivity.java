package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView display;

    boolean isNum1 = false;
    boolean isNum2 = false;
    boolean isOperator = false;

    String operator = "";
    String show = "";
    String num1, num2;

    double result, n1, n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("20174016 김혜린 Calculator");

        display = (TextView) findViewById(R.id.display);
    }

    public void buttonClick(View v) {
        switch (v.getId()){
            case R.id.clear:
                display.setText("0");
                isNum1= false;
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
                if(isNum1 && isNum2){
                    show = Double.toString(result);
                    display.setText(show);
                }
                isNum1 = false;
                isNum2 = false;
                break;
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
                        num1 = Double.toString(result);
                        isNum2 = false;
                        break;
                    case "-":
                        result = n1 - n2;
                        num1 = Double.toString(result);
                        isNum2 = false;
                        break;

                    case "*":
                        result = n1 * n2;
                        num1 = Double.toString(result);
                        isNum2 = false;
                        break;

                    case "/":
                        result = n1 / n2;
                        num1 = Double.toString(result);
                        isNum2 = false;
                        break;

                    case "%":
                        result = n1 % n2;
                        num1 = Double.toString(result);
                        isNum2 = false;
                        break;
            }

        }
    }
}
}