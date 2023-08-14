package com.example.smart.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.smart.Activity.Adapter.ArticleAdapter;
import com.example.smart.Activity.Domain.ArticleModel;
import com.example.smart.R;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecycleViewInterface {
    ArrayList<ArticleModel> articleModels = new ArrayList<>();
    int[] articleImages = {R.drawable.dictionary,R.drawable.books,R.drawable.exam,R.drawable.onlinelearning,R.drawable.teach};
    private RecyclerView recyclerView2;
    ConstraintLayout requestBtn;
    private RecyclerView.Adapter adapter1;
    ImageSlider imageSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    return true;
                case R.id.bottom_search:
                    startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;

                case R.id.bottom_profile:
                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
            }
            return false;
        });

        requestBtn = findViewById(R.id.requestBtn1);
        requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RequestActivity.class);
                startActivity(intent);
            }
        });
        recyclerView2 = findViewById(R.id.recyclerView2);
        setUpArticleModels();
        ArticleAdapter adapter1 = new ArticleAdapter(this,articleModels,this);
        recyclerView2.setAdapter(adapter1);
        LinearLayoutManager horizontalLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(horizontalLayoutManager1);


        imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.media1, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.right1,ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.proekt,ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.media2,ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.right2,ScaleTypes.CENTER_CROP));
        imageSlider.setImageList(slideModels,ScaleTypes.CENTER_INSIDE);
    }
    private void setUpArticleModels(){
        String[] articleNames = getResources().getStringArray(R.array.article_view);
        String[] articleDescription = getResources().getStringArray(R.array.description_view);
        for(int j = 0; j<articleNames.length;j++) {
            articleModels.add(new ArticleModel(articleNames[j],articleImages[j],articleDescription[j]));
        }
    }
    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, ArticleActivity.class);
        intent.putExtra("NAME",articleModels.get(position).getArticleName());
        intent.putExtra("DESCRIPTION",articleModels.get(position).getDescription());
        intent.putExtra("IMAGE",articleModels.get(position).getImage());
        startActivity(intent);
    }
}