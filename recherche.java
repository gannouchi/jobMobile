package com.example.mhammed.gan;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

public class recherche extends AppCompatActivity {
    public final static String EXTRA_MESSAGE="com.example.mhammed.projjet.MESSAGE";
    String url = "http://192.168.129.1/webapp/json_get_data.php";
    String json_uurl = "http://192.168.129.1/webapp/recherche.php";
    String uurl = "http://192.168.129.1/webapp/search.php";
    String JSON_STRING,json_string;
    Button b;
    TextView t;
    EditText e;
    Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);
        b = (Button)findViewById(R.id.button13);
        t = (TextView)findViewById(R.id.textView);
        e = (EditText)findViewById(R.id.editText6);
      // final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
       // b.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View v) {
             //   JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,uurl, new Response.Listener<JSONObject>() {
               //     String domaine = e.getText().toString();
                 //   @Override
                   // public void onResponse(JSONObject response) {
                     //   try {

//                            JSONArray students = response.getJSONArray("server_response");
  //                          for (int i=0;i<students.length();i++){
    //                            JSONObject student = students.getJSONObject(i);
      //                          String name = student.getString("name");
        //                        String poste = student.getString("poste");
          //                      String adresse = student.getString("adresse");
            //                    String email = student.getString("email");
              //                  t.append(name + "  " + poste + "  " + adresse + "  " + email + "\n\n");

                                //String off = name+" "+poste+" "+adresse+" "+email+"\n";
                                //Intent intent = new Intent(getApplicationContext(),offre.class);
                                //intent.putExtra("nom", name);
                                //intent.putExtra("post", poste);
                                //intent.putExtra("adres", adresse);
                                //intent.putExtra("mail", email);
                                //intent.putExtra("off", offre);
                                //startActivity(intent);
                                //String [] offre = {off};
                                //ListView listView = (ListView) findViewById(android.R.id.list);
                                //ArrayAdapter<String> ada = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item,offre);
                                //listView.setAdapter(ada);
                                //i++;
                                //Connection con = DriverManager.getConnection(url);
                                //Statement st =con.createStatement();
                                //String sql = "select * from employeur";
                                //final ResultSet rs = st.executeQuery(sql);
                                //rs.next();
                                //String nom = rs.getString(1);
                                //String pos = rs.getString(2);
                                //t.append(nom+pos);

//                         }
  //                      } catch (JSONException e) {
    //                        e.printStackTrace();
      //                }
         //           }
        //        }, new Response.ErrorListener() {
          //          @Override
            //        public void onErrorResponse(VolleyError error) {

//                    }
  //              });
    //            requestQueue.add(jsonObjectRequest);

                //HashMap postdata = new HashMap();
                //postdata.put("domaine",domaine);


           // }
       //});































    }
    public void quitter(View view){
          //finish();

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void juridique(View view){

         new Backgrounddd().execute();

    }

    public void finance(View view){

        new Backgroundddd().execute();

    }
    public void informatique(View view){

        new Backgrounddddd().execute();

    }
    public void restauration(View view){

        new Backgrounddda().execute();

    }
    public void securite(View view){

        new Backgroundddaa().execute();

    }
    public void toutes(View view){

        new Backgroundddaaa().execute();

    }



    public void getj(View view){
        //if (json_string==null){
          //  Toast.makeText(getApplicationContext(), "first get json...", Toast.LENGTH_SHORT).show();
        //}
        //else{
            new Background().execute();
            //Intent intent = new Intent(this,DisplayListView.class);
            //intent.putExtra("json_data",json_string);
            //startActivity(intent);


        //}



    }
    public void educ(View view){
        new Backgroundd().execute();

    }


    //public void getjson(View view) {
      //  String nom = e.getText().toString();
        //String method = "afficher";
        //BackgroundTask backgroundTask = new BackgroundTask(this);
        //backgroundTask.execute(method,nom);
        //finish();

      //   new Background().execute();



    //}

    class Background extends AsyncTask<Void, Void, String> {
       TextView textview;
        String json_url;
        @Override
        protected void onPreExecute() {
            json_url = "http://192.168.129.1/webapp/json_get_data.php";

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(Void... params) {
            String dom = e.getText().toString();
            try {

                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("user","UTF-8") +"="+URLEncoder.encode(dom,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_STRING = bufferedReader.readLine()) != null) {
                    stringBuilder.append(JSON_STRING + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
           return null;
        }

        @Override
        protected void onPostExecute(String result) {

            //textview =(TextView)findViewById(R.id.textView);
            //textview.setText(result);
            json_string = result;
            Intent intent = new Intent(getBaseContext(),DisplayListView.class);
            intent.putExtra("json_data",json_string);
            startActivity(intent);
        }


    }




    class Backgroundd extends AsyncTask<Void, Void, String> {
        TextView textview;
        String json_url;
        @Override
        protected void onPreExecute() {
            json_uurl = "http://192.168.129.1/webapp/recherche.php";

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(Void... params) {

            try {

                URL url = new URL(json_uurl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_STRING = bufferedReader.readLine()) != null) {
                    stringBuilder.append(JSON_STRING + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            //textview =(TextView)findViewById(R.id.textView);
            //textview.setText(result);
            json_string = result;
            Intent intent = new Intent(getBaseContext(),DisplayListView.class);
            intent.putExtra("json_data",json_string);
            startActivity(intent);
        }


    }
    class Backgrounddd extends AsyncTask<Void, Void, String> {
        TextView textview;
        String json_url;
        @Override
        protected void onPreExecute() {
            json_uurl = "http://192.168.129.1/webapp/juridique.php";

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(Void... params) {

            try {

                URL url = new URL(json_uurl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_STRING = bufferedReader.readLine()) != null) {
                    stringBuilder.append(JSON_STRING + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            //textview =(TextView)findViewById(R.id.textView);
            //textview.setText(result);
            json_string = result;
            Intent intent = new Intent(getBaseContext(),DisplayListView.class);
            intent.putExtra("json_data",json_string);
            startActivity(intent);
        }


    }
    class Backgroundddd extends AsyncTask<Void, Void, String> {
        TextView textview;
        String json_url;
        @Override
        protected void onPreExecute() {
            json_uurl = "http://192.168.129.1/webapp/finance.php";

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(Void... params) {

            try {

                URL url = new URL(json_uurl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_STRING = bufferedReader.readLine()) != null) {
                    stringBuilder.append(JSON_STRING + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            //textview =(TextView)findViewById(R.id.textView);
            //textview.setText(result);
            json_string = result;
            Intent intent = new Intent(getBaseContext(),DisplayListView.class);
            intent.putExtra("json_data",json_string);
            startActivity(intent);
        }


    }
    class Backgrounddddd extends AsyncTask<Void, Void, String> {
        TextView textview;
        String json_url;
        @Override
        protected void onPreExecute() {
            json_uurl = "http://192.168.129.1/webapp/informatique.php";

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(Void... params) {

            try {

                URL url = new URL(json_uurl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_STRING = bufferedReader.readLine()) != null) {
                    stringBuilder.append(JSON_STRING + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            //textview =(TextView)findViewById(R.id.textView);
            //textview.setText(result);
            json_string = result;
            Intent intent = new Intent(getBaseContext(),DisplayListView.class);
            intent.putExtra("json_data",json_string);
            startActivity(intent);
        }


    }
    class Backgrounddda extends AsyncTask<Void, Void, String> {
        TextView textview;
        String json_url;
        @Override
        protected void onPreExecute() {
            json_uurl = "http://192.168.129.1/webapp/restauration.php";

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(Void... params) {

            try {

                URL url = new URL(json_uurl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_STRING = bufferedReader.readLine()) != null) {
                    stringBuilder.append(JSON_STRING + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            //textview =(TextView)findViewById(R.id.textView);
            //textview.setText(result);
            json_string = result;
            Intent intent = new Intent(getBaseContext(),DisplayListView.class);
            intent.putExtra("json_data",json_string);
            startActivity(intent);
        }


    }
    class Backgroundddaa extends AsyncTask<Void, Void, String> {
        TextView textview;
        String json_url;
        @Override
        protected void onPreExecute() {
            json_uurl = "http://192.168.129.1/webapp/securite.php";

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(Void... params) {

            try {

                URL url = new URL(json_uurl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_STRING = bufferedReader.readLine()) != null) {
                    stringBuilder.append(JSON_STRING + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            //textview =(TextView)findViewById(R.id.textView);
            //textview.setText(result);
            json_string = result;
            Intent intent = new Intent(getBaseContext(),DisplayListView.class);
            intent.putExtra("json_data",json_string);
            startActivity(intent);
        }


    }
    class Backgroundddaaa extends AsyncTask<Void, Void, String> {
        TextView textview;
        String json_url;
        @Override
        protected void onPreExecute() {
            json_uurl = "http://192.168.129.1/webapp/toutes.php";

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(Void... params) {

            try {

                URL url = new URL(json_uurl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_STRING = bufferedReader.readLine()) != null) {
                    stringBuilder.append(JSON_STRING + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            //textview =(TextView)findViewById(R.id.textView);
            //textview.setText(result);
            json_string = result;
            Intent intent = new Intent(getBaseContext(),DisplayListView.class);
            intent.putExtra("json_data",json_string);
            startActivity(intent);
        }


    }
}