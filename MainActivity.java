package com.example.mhammed.gan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ET_NAME,ET_PASS;
    String login_name,login_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ET_NAME =(EditText)findViewById(R.id.editText);
        ET_PASS =(EditText)findViewById(R.id.editText2);
    }
    public void userreg(View view){
        Intent intent = new Intent(getApplicationContext(),Register.class);
        startActivity(intent);
    }
    public void userlogin(View view){
        login_name = ET_NAME.getText().toString();
        login_pass = ET_PASS.getText().toString();
        String method = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,login_name,login_pass);


    }
}
