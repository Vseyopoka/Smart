package com.example.smart.Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smart.R;

public class VebinarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vebinar1_layout);

        String name = getIntent().getStringExtra("NAME");
        String description = getIntent().getStringExtra("DESCRIPTION");
        int image = getIntent().getIntExtra("IMAGE",0);

        TextView nameTextView = findViewById(R.id.vebinar_name);
        TextView descriptionTextView = findViewById(R.id.description);
        ImageView articleImage = findViewById(R.id.vebinar_pic);

        nameTextView.setText(name);
        descriptionTextView.setText(description);
        articleImage.setImageResource(image);


    }
}
