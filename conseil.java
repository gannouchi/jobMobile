package com.example.mhammed.gan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class conseil extends AppCompatActivity {
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conseil2);
        t= (TextView)findViewById(R.id.textView2);
        t.setText("ecrire un bon cv");


    }
}
