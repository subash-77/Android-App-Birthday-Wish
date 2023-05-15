package com.example.eamil_sending;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText e1,e2,e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.edit1);
        e2=findViewById(R.id.edit2);
        e3=findViewById(R.id.edit3);

        b1=findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=e1.getText().toString();
                String subject=e2.getText().toString();
                String content=e3.getText().toString();

                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("plain/text");
                i.putExtra(i.EXTRA_EMAIL,new String[]{id});
                i.putExtra(i.EXTRA_SUBJECT,subject);
                i.putExtra(i.EXTRA_TEXT,content);
                startActivity(Intent.createChooser(i,"send mail"));
                finish();

            }
        });
    }
}