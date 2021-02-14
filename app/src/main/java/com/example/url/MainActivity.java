package com.example.url;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button bStart;
    TextView text;
    EditText urll;
    ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bStart = (Button) findViewById(R.id.btStart);
        text = (TextView) findViewById(R.id.text);
        urll = (EditText) findViewById(R.id.edit);
        photo = (ImageView) findViewById(R.id.pic);

        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new LoadImage().execute();
            }
        });
    }
    private class LoadImage extends AsyncTask<Void, Integer, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected Bitmap doInBackground(Void... args) {
            try {
                URL url = new URL(urll.getText().toString());
                InputStream image = (InputStream) url.getContent();
                return BitmapFactory.decodeStream(image);
            }
            catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        protected void onPostExecute(Bitmap image) {
            photo.setImageBitmap(image);
        }

    }
}