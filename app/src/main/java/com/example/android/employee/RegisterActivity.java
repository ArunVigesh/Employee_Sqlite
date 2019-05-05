package com.example.android.employee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper dbh;
    input inp ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Button log = findViewById(R.id.button3);


                postData();
                Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();

    }
    public void postData() {
        EditText Id, Name, Phone, Password, Email;

        /*Id = findViewById(R.id.editText5);
        int i = Integer.parseInt(Id.getText().toString());
        inp.setId(i);*/
        Name = findViewById(R.id.editText);
        inp.setName(Name.getText().toString());
        Email = findViewById(R.id.editText3);
        inp.setEmail(Email.getText().toString());
        Phone = findViewById(R.id.editText4);
        int p = Integer.parseInt(Phone.getText().toString());
        inp.setPhone(p);
        boolean c = checkpass();
        if (c) {
            Password = findViewById(R.id.editText6);
            inp.setPassword(Password.getText().toString());
            dbh.addEmp(inp);
        }else {
            Toast.makeText(getApplicationContext(), "Passwords Don't Match", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean checkpass()
    {
        EditText p1,p2;
        p1=findViewById(R.id.editText2);
        p2=findViewById(R.id.editText6);
        if(p1.getText().toString().equals(p2.getText().toString()))
            return true;
        else
            return false;
    }

}
