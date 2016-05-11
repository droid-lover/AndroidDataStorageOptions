package com.myjarvis.datastorageoptions;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPrefrencesActivity extends AppCompatActivity {


    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    public static final String SurName = "surnameKey";

    SharedPreferences sharedPreferences;

    SharedPreferences.Editor sharedPrefrencesEditor;

    EditText editTextName, editTextPhone, editTextEmail, editTextSurname;

    Button saveButton, showButton, clearPrefrencesButton;

    String name, phone, emailId, surname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefrences);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextSurname = (EditText) findViewById(R.id.editTextSurname);

        saveButton = (Button) findViewById(R.id.saveBtn);
        showButton = (Button) findViewById(R.id.showBtn);
        clearPrefrencesButton = (Button) findViewById(R.id.clearPrefrencesButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = editTextName.getText().toString();
                phone = editTextPhone.getText().toString();
                emailId = editTextEmail.getText().toString();
                surname = editTextSurname.getText().toString();

                /*----*/

                sharedPrefrencesEditor = sharedPreferences.edit();

                sharedPrefrencesEditor.putString(Name, name);
                sharedPrefrencesEditor.putString(Phone, phone);
                sharedPrefrencesEditor.putString(Email, emailId);
                sharedPrefrencesEditor.putString(SurName, surname);
                sharedPrefrencesEditor.commit();

                Toast.makeText(SharedPrefrencesActivity.this, "For Result pls see the logs", Toast.LENGTH_SHORT).show();

            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("your name is :", "" + sharedPreferences.getString(Name, "name"));
                Log.d("your phone is :", "" + sharedPreferences.getString(Phone, "phone"));
                Log.d("your email is :", "" + sharedPreferences.getString(Email, "email"));
                Log.d("your surname is :", "" + sharedPreferences.getString(SurName, "surname"));
                Toast.makeText(SharedPrefrencesActivity.this, "For Result pls see the logs", Toast.LENGTH_SHORT).show();

            }
        });

        clearPrefrencesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPrefrencesEditor.clear();
                sharedPrefrencesEditor.commit();
                Log.d("after del name is :", "" + sharedPreferences.getString(Name, "name"));
                Log.d("after del phone is :", "" + sharedPreferences.getString(Phone, "phone"));
                Log.d("after del email is :", "" + sharedPreferences.getString(Email, "email"));
                Log.d("after del surname is :", "" + sharedPreferences.getString(SurName, "surname"));
            }
        });
    }
}
