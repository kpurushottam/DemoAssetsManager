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

import java.io.IOException;

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
}
