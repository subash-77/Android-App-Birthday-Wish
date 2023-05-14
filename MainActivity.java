package com.example.sqldatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button insert,first,next,previous;
    EditText e1,e2;
    Cursor rs;
    TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        insert=findViewById(R.id.b1);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        first=findViewById(R.id.b2);
        next=findViewById(R.id.b3);
        previous=findViewById(R.id.b4);


        SQLiteDatabase db=openOrCreateDatabase("mydb",MODE_PRIVATE,null);
        db.execSQL("create table if not exists stud(name TEXT,rollno TEXT);");

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=e1.getText().toString();
                String rollno=e2.getText().toString();
                try{
                        db.execSQL("INSERT INTO stud VALUES('"+name+"','"+rollno+"');");
                    Toast.makeText(MainActivity.this, "Insert Sucessfully", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    rs=db.rawQuery("select * from stud",null);
                    rs.moveToFirst();
                    String name=rs.getString(0);
                    String rollno=rs.getString(1);
                    t1.setText(name);
                    t2.setText(rollno);
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{

                    rs.moveToNext();
                    String name=rs.getString(0);
                    String rollno=rs.getString(1);
                    t1.setText(name);
                    t2.setText(rollno);
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{

                    rs.moveToPrevious();
                    String name=rs.getString(0);
                    String rollno=rs.getString(1);
                    t1.setText(name);
                    t2.setText(rollno);
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}