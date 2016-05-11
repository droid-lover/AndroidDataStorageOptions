package com.myjarvis.datastorageoptions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class InternalStorageActivity extends AppCompatActivity {


    EditText editText;

    Button button, button2;
    TextView tv;
    String data;

    private String file = "mydata";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);

        editText = (EditText) findViewById(R.id.editText);
        tv = (TextView) findViewById(R.id.showTextView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                data = editText.getText().toString();
                try {
                    FileOutputStream fOut = openFileOutput(file, MODE_WORLD_READABLE);
                    fOut.write(data.getBytes());
                    fOut.close();
                    Toast.makeText(getBaseContext(), "file saved", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                button2.setVisibility(View.VISIBLE);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fin = openFileInput(file);
                    int c;
                    String temp = "";

                    while ((c = fin.read()) != -1) {
                        temp = temp + Character.toString((char) c);
                    }
                    tv.setVisibility(View.VISIBLE);
                    tv.setText(temp);
                    Toast.makeText(getBaseContext(), "file read" + new File(getFilesDir() + "/" + file), Toast.LENGTH_SHORT).show();
                    Log.d("file read", "" + new File(getFilesDir() + "/" + file));
                } catch (Exception e) {
                }
            }
        });
    }


}
