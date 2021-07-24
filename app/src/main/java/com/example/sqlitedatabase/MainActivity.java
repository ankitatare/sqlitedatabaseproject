package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SqliteDatabaseHelper sqliteDatabaseHelper;
    EditText ed1,ed2,ed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqliteDatabaseHelper=new SqliteDatabaseHelper(this);
    }

    public void addstudent(View view)
    {
        ed1=findViewById(R.id.edtid);
        ed2=findViewById(R.id.edtname);
        ed3=findViewById(R.id.editemail);

        String id=ed1.getText().toString();
        String name=ed2.getText().toString();
        String email=ed3.getText().toString();

        Student student=new Student();
        student.setId(Integer.parseInt("1"));
        student.setName(name);
        student.setEmail(email);

        sqliteDatabaseHelper.addStudent(student);
        Toast.makeText(this,"new student added successfully....",Toast.LENGTH_LONG).show();

        ed1.setText("");
        ed2.setText("");
        ed3.setText("");
    }
    public void viewAllStudent(View view)
    {
        startActivity(new Intent(MainActivity.this,ViewAllStudentData.class));
    }
}

