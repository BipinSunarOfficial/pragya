package com.example.meroarkoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText selectdate;

    private EditText FirstName , LastName,Password,Birthday,Username;
    private AppCompatButton signup_btn;

    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
//        initToolbar();
        findViews();

        selectdate = findViewById(R.id.edtDate);
        selectdate.setOnClickListener(this);
    }


    private void findViews(){

        FirstName = findViewById(R.id.firstname);
        LastName = findViewById(R.id.lastname);
        Username = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        Birthday = findViewById(R.id.edtDate);
        signup_btn = findViewById(R.id.signup_btn);


//      below function gives the activity in signup btn click

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(error())
                {
                    Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

    }




    private boolean error(){

       if(FirstName.getText().toString().isEmpty())
        {
            Toast.makeText(SignUpActivity.this, "Please Provide your First Name.", Toast.LENGTH_LONG).show();
            return false;
        }
        else if(LastName.getText().toString().isEmpty())
        {
            Toast.makeText(SignUpActivity.this, "Please Provide your Last Name.", Toast.LENGTH_LONG).show();
            return false;
        }
        else if(Username.getText().toString().isEmpty())
        {
            Toast.makeText(SignUpActivity.this, "Please Provide your desired Username.", Toast.LENGTH_LONG).show();
            return false;
        }

        else if(Password.getText().toString().isEmpty()){
            Toast.makeText(SignUpActivity.this, "Please set Password.", Toast.LENGTH_LONG).show();
            return false;
        }
        else if(Birthday.getText().toString().length()<8){
            Toast.makeText(SignUpActivity.this, "Please provide your Birthday.", Toast.LENGTH_LONG).show();
            return false;
        }
       else
        {
            Toast.makeText(SignUpActivity.this, "New User Registered Successfully.", Toast.LENGTH_LONG).show();

        }


        return true;
    }


    // code to display datepicker when clicked edittext of date section
    @Override
    public void onClick(View v) {
        if (v == selectdate) {
            final Calendar calendar = Calendar.getInstance ();
            mYear = calendar.get ( Calendar.YEAR );
            mMonth = calendar.get ( Calendar.MONTH );
            mDay = calendar.get ( Calendar.DAY_OF_MONTH );

            //show dialog
            DatePickerDialog datePickerDialog = new DatePickerDialog ( this, new DatePickerDialog.OnDateSetListener () {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    selectdate.setText ( dayOfMonth + "/" + (month + 1) + "/" + year );
                }
            }, mYear, mMonth, mDay );
            datePickerDialog.show ();
        }
    }


}