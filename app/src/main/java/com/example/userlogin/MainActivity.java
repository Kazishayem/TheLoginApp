package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText userName;
    private EditText Password;
    private Button login;
    private TextView textView;
    private Button register;

    private String username = "admin";
    private String userpassword = "1234";
    private int Counter = 5;
    boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.userName);
        Password = findViewById(R.id.Password);
        login = findViewById(R.id.login);
        textView = findViewById(R.id.textView);
        register = findViewById(R.id.register);

        textView.setText("No of attempts remaining: 5");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputUserName = userName.getText().toString();
                String inputPassword = Password.getText().toString();

                if (inputUserName.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Enter All The Information Currently", Toast.LENGTH_SHORT).show();

                } else {
                    isValid = validate(inputUserName,inputPassword);

                    if(!isValid){
                        Counter --;
                        Toast.makeText(getApplicationContext(), "invalid Information", Toast.LENGTH_SHORT).show();

                 textView.setText("No of attempts remaining:"+String.valueOf(Counter));

                        if(Counter == 0){
                            login.setEnabled(false);

          }

                    }else{
                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                         startActivity(intent);
                    }

                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "This is the Registration Page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });


    }

    public boolean validate(String userName, String Password) {

        if ((userName.equals(username)) && (Password.equals(userpassword))) {

            return true;

        }
        return false;

    }


}