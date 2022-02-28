package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    Button reg_login;
    Button reg_btn_register;
    EditText reg_userName;
    EditText reg_fullName;
    EditText reg_email;
    EditText reg_password;
    EditText reg_confirmPassword;
    boolean isValid2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        reg_userName = findViewById(R.id.reg_userName);
        reg_fullName = findViewById(R.id.reg_fullName);
        reg_email = findViewById(R.id.reg_email);
        reg_password = findViewById(R.id.reg_password);
        reg_confirmPassword = findViewById(R.id.reg_confirmPassword);
        reg_login = findViewById(R.id.reg_login);
        reg_btn_register = findViewById(R.id.reg_btn_register);

        reg_btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String inputUserName = reg_userName.getText().toString();
                String inputFullName = reg_fullName.getText().toString();
                String inputEmail = reg_email.getText().toString();
                String inputPassword = reg_password.getText().toString();
                String inputConfirmPassword = reg_confirmPassword.getText().toString();
//                validatePassword();

                if (inputUserName.isEmpty() || inputFullName.isEmpty() || inputEmail.isEmpty() || inputPassword.isEmpty() || inputConfirmPassword.isEmpty()) {
                    if (inputPassword.equals(inputConfirmPassword))
                    {
//                        Toast.makeText(getApplicationContext(), "Password matched", Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_SHORT).show();
                    }
        Toast.makeText(getApplicationContext(), "Please Enter All The Information Currently", Toast.LENGTH_SHORT).show();
         }else{
                    Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                }

            }
        });

        reg_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Back to login page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
//    public void validatePassword() {
//
//        if (reg_password==reg_confirmPassword)
//                   {
//                        Toast.makeText(getApplicationContext(), "Password matched", Toast.LENGTH_SHORT).show();
//                    }else{
//            Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_SHORT).show();
//        }
//
//
//
//    }
}