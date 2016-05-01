package com.example.mhammed.gan;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.android.volley.Request;

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

/**
 * Created by mhammed on 09/04/2016.
 */
public class BackgroundTask extends AsyncTask<String,Void,String> {
    Context ctx;
    AlertDialog alertDialog;
    BackgroundTask(Context ctx){this.ctx = ctx;}

    protected void onPreExecute(){
        super.onPreExecute();
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("login information...");

    }

    protected void onProgressUpdate(Void... values){super.onProgressUpdate(values);}

    protected void onPostExecute(String result){
       if (result.equals("afficher")){
            //Toast.makeText(ctx,"delete success...",Toast.LENGTH_SHORT).show();


        }
        else if (result.equals("registration successs...")){
           Toast.makeText(ctx,"bienvenue",Toast.LENGTH_SHORT).show();
           Intent intent = new Intent(ctx,recherche.class);
           ctx.startActivity(intent);
       }
        else {
            //alertDialog.setMessage(result);
            //alertDialog.show();
            if (result.equals("login failed...try again..")){
                Toast.makeText(ctx,"erreur nom ou mot de passe",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(ctx,"bienvenue",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ctx,recherche.class);
                ctx.startActivity(intent);
            }
        }

    }

    protected String doInBackground(String... params) {
        String method = params[0];
        String reg_url = "http://10.0.2.2/webapp/register.php";
        String login_url = "http://10.0.2.2/webapp/login.php";
        String del_url = "http://10.0.2.2/webapp/suppression.php";
        if (method.equals("register")){
            String name = params[1];
            String mail = params[2];
            String pass = params[3];
            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedwriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("user","UTF-8") +"="+URLEncoder.encode(name,"UTF-8") +"&"+
                              URLEncoder.encode("user_mail","UTF-8") +"="+URLEncoder.encode(mail,"UTF-8") +"&"+
                              URLEncoder.encode("user_pass","UTF-8") +"="+URLEncoder.encode(pass,"UTF-8");
                bufferedwriter.write(data);
                bufferedwriter.flush();
                bufferedwriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "registration successs...";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if (method.equals("login")){
            String login_name = params[1];
            String login_pass = params[2];
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("login_name","UTF-8")+"="+URLEncoder.encode(login_name,"UTF-8")+"&"+
                              URLEncoder.encode("login_pass","UTF-8")+"="+URLEncoder.encode(login_pass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null){
                    response+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        else if (method.equals("supprimer")){
            String name = params[1];
            String mail = params[2];
            String pass = params[3];
            try {
                URL url = new URL(del_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("user","UTF-8") +"="+URLEncoder.encode(name,"UTF-8") +"&"+
                        URLEncoder.encode("user_mail","UTF-8") +"="+URLEncoder.encode(mail,"UTF-8") +"&"+
                        URLEncoder.encode("user_pass","UTF-8") +"="+URLEncoder.encode(pass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null){
                    response+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return "afficher";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
      return null;
    }

}
