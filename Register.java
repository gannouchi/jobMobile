package com.example.mhammed.gan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    EditText ET_NAME,ET_MAIL,ET_PASS;
    String nom,mail,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ET_NAME =(EditText)findViewById(R.id.editText3);
        ET_MAIL =(EditText)findViewById(R.id.editText4);
        ET_PASS =(EditText)findViewById(R.id.editText5);
    }
    public void userreg(View view){
        nom = ET_NAME.getText().toString();
        mail = ET_MAIL.getText().toString();
        pass = ET_PASS.getText().toString();
        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,nom,mail,pass);
        finish();



    }
    public void delete(View view){

        nom = ET_NAME.getText().toString();
        mail = ET_MAIL.getText().toString();
        pass = ET_PASS.getText().toString();
        String method = "supprimer";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,nom,mail,pass);
        finish();



    }
}
