package com.example.lab02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText u_min;
    EditText u_max;
    Button btn;
    TextView u_output;

    Random r;
    int min, max, output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        r = new Random();
        u_min = (EditText) findViewById(R.id.u_min);
        u_max = (EditText) findViewById(R.id.u_max);
        btn = (Button) findViewById(R.id.btn);
        u_output = (TextView) findViewById(R.id.u_output);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            String tMin, tMax;
            tMin = u_min.getText().toString();
            tMax = u_max.getText().toString();
            if(!tMin.equals("") && !tMax.equals("")){
                min = Integer.parseInt(tMin);
                max = Integer.parseInt(tMax);
                if( max > min) {
                    output = r.nextInt((max - min) +1) + min;
                    u_output.setText("" + output);
                }
            }
            }
        });
     }
}