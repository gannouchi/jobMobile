package com.example.mhammed.gan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mhammed on 12/04/2016.
 */
public class ContactAdapter extends ArrayAdapter {
    List list = new ArrayList();
    public ContactAdapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(Contacts object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        ContactHolder contactHolder;
        row = convertView;
        if (row == null){
            LayoutInflater layoutInflater =(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            contactHolder = new ContactHolder();
            contactHolder.tx_name = (TextView)row.findViewById(R.id.tx_name);
            contactHolder.tx_poste = (TextView)row.findViewById(R.id.tx_poste);
            contactHolder.tx_adresse = (TextView)row.findViewById(R.id.tx_adresse);
            contactHolder.tx_email = (TextView)row.findViewById(R.id.tx_email);
        }
        else {
            contactHolder = (ContactHolder)row.getTag();
        }
        Contacts contacts = (Contacts)this.getItem(position);
        contactHolder.tx_name.setText(contacts.getName());
        contactHolder.tx_poste.setText(contacts.getPoste());
        contactHolder.tx_adresse.setText(contacts.getAdresse());
        contactHolder.tx_email.setText(contacts.getEmail());







        return row;
    }

static class ContactHolder{
    TextView tx_name,tx_poste,tx_adresse,tx_email;


}



}
