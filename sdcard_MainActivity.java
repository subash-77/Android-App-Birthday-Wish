package com.example.sdcard;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private EditText editText1;
    private EditText editText2;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();

                saveToExternalStorage("data.txt", text1 + "\n" + text2);
            }
        });
    }

    private void saveToExternalStorage(String fileName, String data) {
        File file;
        FileOutputStream outputStream;

        try {
            // Get the directory for the external public storage
            File externalStorageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);

            // Create the desired directory if it doesn't exist
            File dir = new File(externalStorageDir, "MyAppDirectory");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Create a new file in the directory
            file = new File(dir, fileName);

            // Open the file for writing
            outputStream = new FileOutputStream(file);

            // Write the data to the file
            outputStream.write(data.getBytes());

            // Close the file
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
