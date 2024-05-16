package com.example.lab02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Caculator extends AppCompatActivity {

    EditText number1, number2;
    Button buttonSum, buttonSubt, buttonMult, buttonDivi;
    TextView u_output;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_caculator);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//
//
//        });
        buttonSum =  findViewById(R.id.btnAdd);
        buttonSubt = findViewById(R.id.btnSub);
        buttonMult = findViewById(R.id.btnMul);
        buttonDivi = findViewById(R.id.btnDiv);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        u_output = findViewById(R.id.result);

        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation('+');
            }
        });
        buttonSubt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation('-');
            }
        });
        buttonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation('*');
            }
        });
        buttonDivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation('/');
            }
        });
    }

private void operation(char operator) {
        if(number1.getText().toString().equals("") || number2.getText().toString().equals("")) {
            Toast.makeText(this, "Please enter a number!",Toast.LENGTH_SHORT).show();
            return;
        }
        num1 = Integer.parseInt(number1.getText().toString());
        num2 = Integer.parseInt(number2.getText().toString());

        switch (operator) {
            case '+':
                u_output.setText(" " + (double)(num1+num2));
                break;
            case '-':
                u_output.setText(" " + (double)(num1 - num2));
                break;
            case '*':
                u_output.setText(" " + (double)(num1 * num2));
                break;
            case '/':

                if(num2 != 0 ) {
                    u_output.setText(" " + (double)(num1 / num2));
                } else {
                    Toast.makeText(this, "number 2 is not zero!", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }


}






}
