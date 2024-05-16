package com.example.signin_out;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class MainActivity extends AppCompatActivity  {

    EditText username, password;
    TextView notAccount;
    Button buttonSignin;
    private final String REQUIRE = "Require";


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

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        notAccount = findViewById(R.id.notAcc);
        buttonSignin = findViewById(R.id.btnSignIn);

//        notAccount.setOnClickListener(this);
//        buttonSignin.setOnClickListener(this);

        buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign("signIn");
            }
        });

        notAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign("signUp");
            }
        });
    }

    private boolean checkSignIn() {
        if (TextUtils.isEmpty(username.getText().toString())) {
            username.setError(REQUIRE);
            return false;
        }

        if(TextUtils.isEmpty(password.getText().toString())) {
            password.setError(REQUIRE);
            return false;
        }

        return true;
    }

    private void signIn() {
        if(!checkSignIn()) {
            return;
        }

        Toast.makeText(this, "Login Successfully!", Toast.LENGTH_SHORT).show();


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    private void signUp() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }

    private void sign(String sign) {

        switch (sign) {
            case "signIn":
                signIn();
                break;

            case "signUp":
                signUp();
                break;
        }
    }


//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btnSignIn:
//                signIn();
//                break;
//        }
//    }
}