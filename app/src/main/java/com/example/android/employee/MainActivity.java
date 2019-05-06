package com.example.android.employee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHelper db=new DatabaseHelper(this);
        input inp =db.dispEmp(1);
        TextView id,name,email,phone;
        id=findViewById(R.id.textView6);
        id.setText(String.valueOf(inp.getId()));
        name=findViewById(R.id.textView8);
        name.setText(String.valueOf(inp.getName()));
        email=findViewById(R.id.textView10);
        email.setText(String.valueOf(inp.getEmail()));
        phone=findViewById(R.id.textView12);
        phone.setText(String.valueOf(inp.getPhone()));

    }
}