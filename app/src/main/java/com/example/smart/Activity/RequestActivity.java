package com.example.smart.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smart.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class RequestActivity extends AppCompatActivity {
    Button saveButton;
    EditText fullname, group, chin, dolgnost, region, city, education, mobilephone, link, email, progress, expirience, talkskills, collectiveskills;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        fullname = findViewById(R.id.fullname);
        group = findViewById(R.id.group);
        chin = findViewById(R.id.chin);
        dolgnost = findViewById(R.id.dolgnost);
        region = findViewById(R.id.region);
        city = findViewById(R.id.city);
        education = findViewById(R.id.education);
        mobilephone = findViewById(R.id.mobilephone);
        link = findViewById(R.id.link_social_media);
        email = findViewById(R.id.email);
        progress = findViewById(R.id.progress);
        expirience = findViewById(R.id.expirience);
        talkskills = findViewById(R.id.talkskills);
        collectiveskills = findViewById(R.id.collectiveskills);
        saveButton = findViewById(R.id.savebtn);

        saveButton.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
               database = FirebaseDatabase.getInstance();
               reference = database.getReference("users");


                String name = fullname.getText().toString();
                String groups = group.getText().toString();
               String chins = chin.getText().toString();
                String dolgnosts = dolgnost.getText().toString();
                String regions = region.getText().toString();
               String cities = city.getText().toString();
               String educations = education.getText().toString();
               String mobilephones = mobilephone.getText().toString();
              String links = link.getText().toString();
              String emails = email.getText().toString();
              String progresses = progress.getText().toString();
               String expiriences = expirience.getText().toString();
                String talkskill = talkskills.getText().toString();
               String collectiveskill = collectiveskills.getText().toString();

               DataClass dataClass = new DataClass(name, groups, chins, dolgnosts, regions, cities, educations, mobilephones, links, emails, progresses, expiriences, talkskill, collectiveskill);
                reference.child(name).setValue(dataClass);
               Toast.makeText(RequestActivity.this, "Успешно!", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(RequestActivity.this, MainActivity.class);
               startActivity(intent);

          }
        });
    }
}