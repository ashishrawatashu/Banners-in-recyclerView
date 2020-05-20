package com.example.cynoteck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    TextInputEditText emailET,passwordET;
    String user_email="",user_password="",user_name="";
    Button login_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailET=findViewById(R.id.emailET);
        passwordET=findViewById(R.id.passwordET);
        login_button=findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_email=emailET.getText().toString();
                user_password=passwordET.getText().toString();

                if(emailET.getText().toString().trim().length()==0)
                {
                    emailET.setError("Enter email id");
                    emailET.requestFocus();
                }
                else if(passwordET.getText().toString().trim().length()==0)
                {
                    passwordET.setError("Enter Password ");
                    passwordET.requestFocus();
                }
                else {
                    SharedPreferences sharedPreferences = Login.this.getSharedPreferences("userdetails", 0);
                    SharedPreferences.Editor login_editor = sharedPreferences.edit();
                    login_editor.putString("user_id", user_email);
                    login_editor.commit();
                    Toast.makeText(Login.this, "Login Sucessfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
