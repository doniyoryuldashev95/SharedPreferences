package com.example.admin.sharedpreference;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private EditText editText1, editText2;
    private Button logInButton,button2;
    private CheckBox checkBox;
    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.firstText);
        editText2 = (EditText) findViewById(R.id.secondText);
        logInButton = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        checkBox = (CheckBox) findViewById(R.id.box1);


        sharedPreferences = getSharedPreferences("sharedPreference",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        checkSharedPreferences();


        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (checkBox.isChecked()){

                    //set a check box when the application starts
                editor.putString(getString(R.string.checkbox),"True");
                editor.apply();

                //save the name
                String nameN = editText1.getText().toString();
                editor.putString(getString(R.string.name),nameN);
                editor.apply();

                // save the password
                String passwordP = editText2.getText().toString();
                editor.putString(getString(R.string.password),passwordP);
                editor.apply();
            } else{

                editor.putString(getString(R.string.checkbox),"False");
                editor.apply();

                //save the name
                editor.putString(getString(R.string.name),"");
                editor.apply();

                // save the password
                editor.putString(getString(R.string.password),"");
                editor.apply();
            }
            }
        });

    }
    private void checkSharedPreferences(){

        String checkbox = sharedPreferences.getString(getString(R.string.checkbox),"False");
        String name = sharedPreferences.getString(getString(R.string.name),"");
        String password = sharedPreferences.getString(getString(R.string.password),"");

        editText1.setText(name);
        editText2.setText(password);

        if (checkbox.equals("True")) {
            checkBox.setChecked(true);
            Toast.makeText(MainActivity.this,"Fulled",Toast.LENGTH_SHORT).show();

        } else
            checkBox.setChecked(false);


    }

}
