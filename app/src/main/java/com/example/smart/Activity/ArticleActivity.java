package com.example.smart.Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smart.R;

public class ArticleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article1_layout);

        String name = getIntent().getStringExtra("NAME");
        String description = getIntent().getStringExtra("DESCRIPTION");
        int image = getIntent().getIntExtra("IMAGE",0);

        TextView nameTextView = findViewById(R.id.articleName);
        TextView descriptionTextView = findViewById(R.id.description);
        ImageView articleImage = findViewById(R.id.articleImage);

        nameTextView.setText(name);
        descriptionTextView.setText(description);
        articleImage.setImageResource(image);


    }
}
