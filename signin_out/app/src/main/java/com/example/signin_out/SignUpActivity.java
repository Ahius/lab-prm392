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

public class SignUpActivity extends AppCompatActivity {

    EditText username, password, confirm;
    Button buttonSignup;

    TextView haveAcc;
    private final String REQUIRE = "Require";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirm = findViewById(R.id.confirm);
        haveAcc = findViewById(R.id.haveAcc);
        buttonSignup = findViewById(R.id.btnSignUp);

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign("signUp");
            }
        });

        haveAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign("signIn");
            }
        });

    }

    private boolean checkSignup() {

        if(TextUtils.isEmpty(username.getText().toString())) {
            username.setError(REQUIRE);
            return false;
        }
        if(TextUtils.isEmpty(password.getText().toString())) {
            password.setError(REQUIRE);
            return false;
        }
        if(TextUtils.isEmpty(confirm.getText().toString())) {
            confirm.setError(REQUIRE);
            return false;
        }

        if(!TextUtils.equals(password.getText().toString(), confirm.getText().toString())) {
            Toast.makeText(this, "Password and confirm password are not match!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void signUp() {
        if(!checkSignup()) {
            return;
        }

        Toast.makeText(this, "Sign Up successfully!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }
    private void signIn() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }



    private void sign(String sign) {

        switch (sign) {
            case "signUp":
                signUp();
                break;
            case "signIn":
                signIn();
                break;
        }
    }
}