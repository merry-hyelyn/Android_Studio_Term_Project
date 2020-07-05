package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

// 컴퓨터 소프트웨어 공학과 20174016 김혜린

public class MainActivity extends AppCompatActivity {
    EditText display;   // 계산기 결과값 출력
    Button add, sub, mul, div;  // 사칙연산 버튼

    // 피연산자, 연산자, 연산결과, 비트 계산기로 바꿨는지 여부 체크
    boolean isNum1 = false;
    boolean isNum2 = false;
    boolean isOperator = false;
    boolean isResult = false;
    boolean isChange = false;

    DecimalFormat df = new DecimalFormat("#.#####");

    String operator = "";   // 연산자를 저장하기 위한 변수
    String show = "";   // EditText에 출력할 값을 저장
    String num1, num2;  // 피 연산자

    double result, n1, n2;
    int bit1, bit2, binaryNum;

    // 실수형 계산결과에서 불필요한 소수점을 제거하고 소수점 5번째 자리까지 출력력
    // ex) 10.0 -> 10, 3.333333333 -> 3.33333, 4.56 -> 4.56
    public String formatD(double num){
        return df.format(num);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("20174016 김혜린 Calculator");

        // button과 EditText id값 가져오기
        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        mul = (Button) findViewById(R.id.mul);
        div = (Button) findViewById(R.id.div);

        display = (EditText) findViewById(R.id.display);
    }

    // button 클릭 시 실행
    public void buttonClick(View v) {
        // isChange == false일 때 -> 사칙연산 계산기
        if(!isChange) {

            // 클릭 시 버튼의 id값 가져오기
            switch (v.getId()) {
                case R.id.change:   // 비트 연산 계산기로 바꾸기
                    setTitle("20174016 김혜린 BIT Calculator");
                    isChange = true;
                    add.setText("AND"); // +버튼 -> AND
                    sub.setText("OR");  // -버튼 -> OR
                    mul.setText("NOT"); // x버튼 -> NOT
                    div.setText("XOR"); // /버튼 -> XOR
                    display.setText("0");   // 계산기 화면 초기화
                    show = "";      // 계산 값 저장 변수 초기화
                    isNum1 = false;     // 피연산자 출력
                    isNum2 = false;
                    break;

                // 초기화 버튼 클릭 시
                // 계산기 화면 초기화
                // 계산 결과 및 피연산자 초기화
                case R.id.clear:
                    display.setText("0");
                    show = "";
                    isNum1 = false;
                    isNum2 = false;
                    break;

                // 숫자 버튼 클릭 시 해당 숫자 화면에 띄우기
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

                // 연산자 클릭 시 연산자 정보 저장
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

                // '='버튼 클릭 시 결과 값 존재 하므로 isResult -> true
                case R.id.result:
                    isOperator = true;
                    isResult = true;
                    break;
            }
        }

        // isChange == True일 때 -> 비트 연산 계산기
        else{
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

                // 비트 연산 클릭 시 연산 저장
                case R.id.add:
                    isOperator = true;
                    operator = "&";
                    break;

                case R.id.sub:
                    isOperator = true;
                    operator = "|";
                    break;

                // NOT 연산자 클릭 시
                // NOT 연산자는 두 개의 숫자가 필요하지 않기 때문에 바로 계산
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

                // 비트 계산기에서 '.'은 이진수로 바꿔줌
                case R.id.dot:
                    num1 = display.getText().toString();
                    binaryNum = Integer.parseInt(num1);
                    show = Integer.toBinaryString(binaryNum);
                    display.setText(show);
                    break;
            }
        }

        // 연산자가 클릭되어 있다면
        if (isOperator) {
            // 첫 번쨰 숫자가 저장되어 있다면
            if(isNum1){
                num2 = display.getText().toString();    // 현재 출력되어 있는 숫자 가져오기
                // 숫자 두 개 모두 실수형으로 변경
                n1 = Double.parseDouble(num1);
                n2 = Double.parseDouble(num2);
                isNum2 = true;  // 두번째 숫자 저장되어 있으므로 true
            }

            // 첫 번째 숫자가 저장되어 있지 않다면
            else{
                num1 = display.getText().toString();    // 현재 출력되어 있는 숫자 가져오기
                show = "";
                isOperator = false;
                isNum1 = true;  // 첫번째 숫자 저장되어 있으므로 true
            }

            // 두개의 숫자가 모두 저장되어 있다면
            if(isNum1 && isNum2){
                // 앞서 저장한 연산자에 따라 연산 진행
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

                    // 비트 연산자는 정수형으로 다시 바꿔서 계산
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

                // '='버튼이 눌려있다면
                if(isResult){
                    // 피연산자 존재 여부 초기화 -> false
                    isNum1 = false;
                    isResult = false;
                }

                // 다음 계산에서 현재 결과 값을 사용할 수 있으므로 num1 저장
                // ex) 1 + 1 = 2(num1으로 저장) + 1 =3
                // 위의 조건절을 거치지 않았다면, isNum1 == true
                num1 = Double.toString(result);

                // 연산이 끝났으므로 두번째 숫자와 연산자 여부는 초기화 -> false
                isNum2 = false;
                isOperator = false;
                // 결과 값 소수점 정리 및 출력
                show = formatD(result);
                display.setText(show);
                // 출력 후 다음 숫자 저장을 위해 초기화
                show = "";
            }
        }
    }
}