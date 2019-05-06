package com.example.android.employee;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper dbh=new DatabaseHelper(this);
    input inp =new input();
    EditText id,name, phone, password, email;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                postData();
                dbh.addEmp(inp);
                Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    public void postData() {

        id = findViewById(R.id.editText5);
        name = findViewById(R.id.editText);
        email = findViewById(R.id.editText3);
        phone = findViewById(R.id.editText4);
        password = findViewById(R.id.editText6);

        int i = Integer.parseInt(id.getText().toString());
        int ph = Integer.parseInt(phone.getText().toString());

        inp.setId(i);
        inp.setName(name.getText().toString());
        inp.setEmail(email.getText().toString());
        inp.setPhone(ph);

        boolean c = checkpass();
        if (c) {
            inp.setPassword(password.getText().toString());
        }else {
            Toast.makeText(getApplicationContext(), "Passwords Don't Match", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean checkpass()
    {
        EditText pass,cnfpass;
        pass=findViewById(R.id.editText2);
        cnfpass=findViewById(R.id.editText6);
        if(pass.getText().toString().equals(cnfpass.getText().toString()))
            return true;
        else
            return false;
    }

}
