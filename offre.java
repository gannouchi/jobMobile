package com.example.mhammed.gan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class offre extends AppCompatActivity {
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offre);
        //t = (TextView)findViewById(R.id.textView2);
        Intent intent = getIntent();
        String name = intent.getStringExtra("nom");
        String poste = intent.getStringExtra("post");
        String adresse = intent.getStringExtra("adres");
        String email = intent.getStringExtra("mail");
        String [] offre = {name,poste,adresse,email};
        //t.append(name+"  "+poste+"  "+adresse+"  "+email+"\n\n");
        ListView listView = (ListView) findViewById(android.R.id.list);
        ArrayAdapter<String> ada = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,offre);
        listView.setAdapter(ada);



    }
}
