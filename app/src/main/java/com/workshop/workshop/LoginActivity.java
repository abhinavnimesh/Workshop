package com.workshop.workshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText username;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username= (EditText) findViewById(R.id.name);
        btn= (Button) findViewById(R.id.button);
    }

    public void login(View view)
    {
        Intent i= new Intent(this,MainActivity.class);
        i.putExtra("username",username.getText().toString());
        startActivity(i);
    }
}
