package com.example.mansopresk01.intentimages;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setTitleColor(R.color.colorAccent);
       // setTitle("IntentImages");
      //  setTitleColor(ContextCompat.getColor(this,R.color.colorAccent));
      getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>Intent Images</font>"));

    }
    public void process(View view){
        Intent intent = null, chooser = null;
        if (view.getId()==R.id.launchmaps){
            intent = new Intent(android.content.Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:19.076,72.8777"));
            chooser = Intent.createChooser(intent,"Launch Maps");
            startActivity(chooser);

        }
        if (view.getId()==R.id.launchmarket) {
            intent = new Intent(android.content.Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details/David_Kennedy_Metasploit?id=T9HKgEOCYZEC"));
            chooser = Intent.createChooser(intent,"Launch Market");
            startActivity(chooser);
        }
        if (view.getId()==R.id.sendiemail) {
            intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to = {"prathyu565@gmail.com", "sharmilaoleti4321@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT,
                    "hi, this was sent from my app");
            intent.putExtra(Intent.EXTRA_TEXT,"hey this is my first email message");
            intent.setType("message/rfc822");
            chooser = Intent.createChooser(intent,"Send Email");
            startActivity(chooser);

        }
        if (view.getId()==R.id.sendimage) {
            Uri imageUri = Uri.parse("android.resource://mansopresk01.intentimages/drawable"+R.drawable.ic_launcher_foreground);
            intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setType("images/*");
            intent.putExtra(Intent.EXTRA_STREAM,imageUri);
            intent.putExtra(Intent.EXTRA_TEXT,"Hey I have attached this image");
            chooser = Intent.createChooser(intent,"Send Image");
            startActivity(chooser);


        }

            if(view.getId()==R.id.sendimages){
           File images = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            String[] listOfImages = images.list();
            Uri uri = null;
            ArrayList<Uri> arrayList = new ArrayList<Uri>();
            for (String picture: listOfImages ){
                uri = Uri.parse("file://"+images.toString()+"/"+picture);
                arrayList.add(uri);
            }
            intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
            intent.setType("images/*");
            intent.putExtra(Intent.EXTRA_STREAM,arrayList);
            chooser = Intent.createChooser(intent,"Send Multiple Images");
            startActivity(chooser);
        }
        }
    }

