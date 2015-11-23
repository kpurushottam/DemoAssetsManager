package com.krp.android.demoassetsmanager;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainActivity extends AppCompatActivity {

    private ImageView ivFlower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivFlower = (ImageView) findViewById(R.id.iv_flower);
    }

    public void addFlower(View v) {
        AssetManager mn = getAssets();
        try {
            ivFlower.setImageBitmap(BitmapFactory.decodeStream(mn.open("images/flower.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
            ivFlower.setBackgroundColor(Color.BLUE);
        }
    }

    public void loadDriver(View v) {
        TextView tvDriver = (TextView) findViewById(R.id.tv_driver);
        String driver, user, password;

        ResourceBundle bd = ResourceBundle.getBundle("assets/properties/db", Locale.US);
        driver = bd.getString("driver");
        user = bd.getString("user");
        password = bd.getString("password");
        tvDriver.setText("Driver: "+driver+"\nUser: "+user+"\nPassword: "+password);
    }
}
