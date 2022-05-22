package com.example.meroarkoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class LoginActivity extends AppCompatActivity {


    private EditText Username, Password;
    private AppCompatButton login_btn;
    private TextView RegisterNew;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        findViews();
    }


    private void findViews(){
        Username = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        login_btn = findViewById(R.id.login);
        RegisterNew = findViewById(R.id.register_new);



            login_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (error()) {
                        Intent intent1 = new Intent(LoginActivity.this, DashboardActivity.class);
                        startActivity(intent1);
                    }
                }
            });


        RegisterNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent2);
            }
        });

    }




    private boolean error(){
        if(Username.getText().toString().isEmpty())
        {
            Toast.makeText(LoginActivity.this, "Please Provide your Username.", Toast.LENGTH_LONG).show();
            return false;
        }

        else if(Password.getText().toString().isEmpty())
        {
            Toast.makeText(LoginActivity.this, "Please Provide your Password.", Toast.LENGTH_LONG).show();
            return false;
        }
        else{
            Toast.makeText(LoginActivity.this,"Login Successful.", Toast.LENGTH_SHORT).show();
        }

        return true;
    }


    }

