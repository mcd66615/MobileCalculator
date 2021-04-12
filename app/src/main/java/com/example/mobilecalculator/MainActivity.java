package com.example.mobilecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView Screen;
    private Button Backspace,Cancel, Div, Mul, Add, Sub, Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Equals, Btndecimal;
    private String input, Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen = findViewById(R.id.screen);
        One = findViewById(R.id.btnone);
        Two = findViewById(R.id.btntwo);
        Three = findViewById(R.id.btnthree);
        Four = findViewById(R.id.btnfour);
        Five = findViewById(R.id.btnfive);
        Six = findViewById(R.id.btnsix);
        Seven = findViewById(R.id.btnseven);
        Eight = findViewById(R.id.btneight);
        Nine = findViewById(R.id.btnnine);
        Zero = findViewById(R.id.btnzero);
        Btndecimal = findViewById(R.id.btnpoint);
        Cancel = findViewById(R.id.btnclear);
        Add = findViewById(R.id.btnadd);
        Sub = findViewById(R.id.btnsubtract);
        Mul = findViewById(R.id.btnmultiply);
        Div = findViewById(R.id.btndivide);
        Equals = findViewById(R.id.btnequals);
        Backspace = findViewById(R.id.btnbackspace);
    }

    public void ButtonClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {
            case "C":
                input = "";
                break;
            case "*":
                Solve();
                input += "*";
                break;
            case "^":
                Solve();
                input += "^";
                break;
            case "=":
                Solve();
                Answer = input;
                break;
            case "Back":
                    String newText=input.substring(0,input.length()-1);
                    input=newText;
                    break;
            default:
                if (input == null) {
                    input = "";

                }
                if (data.equals("+") || data.equals("-") || data.equals("/")) {
                    Solve();
                }
                input += data;
        }
        Screen.setText(input);
    }

    private void Solve() {
        if (input.split("\\*").length == 2) {
            String number[] = input.split("\\*");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = mul+"";
            } catch (Exception e) {
                //error
            }
        } else if (input.split("/").length == 2) {
            String number[] = input.split("/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div+"";
            } catch (Exception e) {
                //error
            }
        } else if (input.split("\\^").length == 2) {
            String number[] = input.split("\\^");
            try {
                double pow = Math.pow(Double.parseDouble(number[0]), Double.parseDouble(number[1]));
                input = pow+"";
            } catch (Exception e) {
                //error
            }
        } else if (input.split("\\+").length == 2) {
            String number[] = input.split("\\+");
            try {
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = sum+"";
            } catch (Exception e) {
                //error
            }
        } else if (input.split("-").length>1) {
            String number[] = input.split("-");

            if (number[0] == "" && number.length == 2) {
                number[0] = 0 + "";
            }
            try {
                double sub=0;
                if(number.length==2) {
                    sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                }
                else if(number.length==3){
                    sub = -Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }
                input = sub+"";
            }
            catch (Exception e) {
                //error
            }
        }
        String n[]=input.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                input=n[0];
            }
        }
        Screen.setText(input);
    }
}