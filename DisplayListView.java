package com.example.mhammed.gan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends AppCompatActivity {
    ListView listView;
    JSONArray jsonArray;
    JSONObject jsonObject;
    String json_string;
    ContactAdapter contactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_listview_layout);
        json_string = getIntent().getExtras().getString("json_data");
        listView = (ListView)findViewById(R.id.listView);
        contactAdapter = new ContactAdapter(this,R.layout.row_layout);
        listView.setAdapter(contactAdapter);

        try {
            jsonObject = new JSONObject(json_string);
            int count = 0;
            String name,poste,adresse,email;
            jsonArray = jsonObject.getJSONArray("server_response");
            while (count<jsonArray.length()){
                JSONObject JO = jsonArray.getJSONObject(count);
                name = JO.getString("name");
                poste = JO.getString("poste");
                adresse = JO.getString("adresse");
                email = JO.getString("email");
                Contacts contacts = new Contacts(name,poste,adresse,email);
                contactAdapter.add(contacts);
                count++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
