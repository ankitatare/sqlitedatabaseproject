package com.example.sqlitedatabase;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewAllStudentData extends AppCompatActivity
{

    SqliteDatabaseHelper sqliteDatabaseHelper;
    RecyclerView recyclerView;
    StudentAdapter studentAdapter;
    List<Student> studentList;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_all_student_data);
        recyclerView=findViewById(R.id.recyclerview);
        sqliteDatabaseHelper= new SqliteDatabaseHelper(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        studentList=new ArrayList<>();
        studentList=sqliteDatabaseHelper.viewAllStudent();
        for(Student s:studentList)
        {
            Log.d("student","Id:"+s.getId()+"Name:"+s.getName()+"Email:"+s.getEmail());
        }

        studentAdapter=new StudentAdapter(this,studentList);

        recyclerView.setAdapter(studentAdapter);

        studentAdapter.notifyDataSetChanged();
    }
}
