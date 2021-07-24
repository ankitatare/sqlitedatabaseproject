package com.example.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SqliteDatabaseHelper extends SQLiteOpenHelper {
    public static final int Data_Base_Version = 1;
    public static final String DatabaseName = "StudentDatabase";
    public static final String TABLE_NAME = "student";

    public final String id = "id";
    public final String name = "name";
    public final String email = "email";

    public SqliteDatabaseHelper(@Nullable Context context) {
        super(context, DatabaseName, null,Data_Base_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String table_create = "CREATE TABLE " + TABLE_NAME + " (" + id + " Varchar(100), " + name + " Varchar(100), " + email + " Varchar(100)" + ")";
        sqLiteDatabase.execSQL(table_create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // String drop_table="DROP TABLE" +TABLE_NAME;
        // db.execSQL(drop_table);

    }

    public void addStudent(Student student) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(id, student.getId());
        contentValues.put(name, student.getName());
        contentValues.put(email, student.getEmail());

        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
    }

    public List<Student> viewAllStudent()
    {
        List<Student> studentList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String sqlquery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(sqlquery, null);

        if (cursor.moveToFirst()) {
            do {

                    Student student = new Student();

                    student.setId(cursor.getInt(0));
                    student.setName(cursor.getString(1));
                    student.setEmail(cursor.getString(2));

                    studentList.add(student);

                }
                while (cursor.moveToNext()) ;
            }


            return studentList;

        }
    }


