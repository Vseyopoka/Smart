package com.example.smart.Activity;

import static android.graphics.BitmapFactory.decodeByteArray;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smart.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {
    private Button logout;
    LinearLayout fab;
    ImageView alarmImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_profile);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_search:
                    startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;

                case R.id.bottom_profile:
                    return true;
            }
            return false;
        });
        ImageView navImage = findViewById(R.id.navImage);
        TextView navName = findViewById(R.id.navName);
        TextView navEmail = findViewById(R.id.navEmail);
        LinearLayout fab = findViewById(R.id.fab);
        DBHelper dbHelper = new DBHelper((this));
        Cursor cursor = dbHelper.getUser();
        alarmImage = findViewById(R.id.alarm);
        alarmImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,AlarmActivity.class);
                startActivity(intent);
            }
        });
        logout = findViewById(R.id.logout_button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, SignupActivity.class));
            }
        });
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Введите данные пользователя!", Toast.LENGTH_SHORT);
        } else {
            while (cursor.moveToNext()) {
                navName.setText("" + cursor.getString(0));
                navEmail.setText("" + cursor.getString(1));
                byte[] imageByte = cursor.getBlob(2);
                Bitmap bitmap = decodeByteArray(imageByte, 0, imageByte.length);
                navImage.setImageBitmap(bitmap);
            }
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, UploadActivity.class);
                startActivity(intent);
            }
        });



    }
//        binding = ActivityProfileBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//        createNotificationChannel();
//        binding.selectTime.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                timePicker = new MaterialTimePicker.Builder()
//                        .setTimeFormat(TimeFormat.CLOCK_12H)
//                        .setHour(12)
//                        .setMinute(0)
//                        .setTitleText("Select Alarm Time")
//                        .build();
//                timePicker.show(getSupportFragmentManager(), "androidknowledge");
//                timePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (timePicker.getHour() > 12){
//                            binding.selectTime.setText(
//                                    String.format("%02d",(timePicker.getHour()-12)) +":"+ String.format("%02d", timePicker.getMinute())+"PM"
//                            );
//                        } else {
//                            binding.selectTime.setText(timePicker.getHour()+":" + timePicker.getMinute()+ "AM");
//                        }
//                        calendar = Calendar.getInstance();
//                        calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
//                        calendar.set(Calendar.MINUTE, timePicker.getMinute());
//                        calendar.set(Calendar.SECOND, 0);
//                        calendar.set(Calendar.MILLISECOND, 0);
//                    }
//                });
//            }
//
//    });
//        binding.setAlarm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//                Intent intent = new Intent(ProfileActivity.this, AlarmReceiver.class);
//                pendingIntent = PendingIntent.getBroadcast(ProfileActivity.this, 0, intent, 0);
//                alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
//                        AlarmManager.INTERVAL_DAY, pendingIntent);
//                Toast.makeText(ProfileActivity.this, "Alarm Set", Toast.LENGTH_SHORT).show();
//            }
//        });
//        binding.cancelAlarm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ProfileActivity.this, AlarmReceiver.class);
//                pendingIntent = PendingIntent.getBroadcast(ProfileActivity.this, 0, intent, 0);
//                if (alarmManager == null){
//                    alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//                }
//                alarmManager.cancel(pendingIntent);
//                Toast.makeText(ProfileActivity.this, "Alarm Canceled", Toast.LENGTH_SHORT).show();
//            }
//        });
//}
//
//    private void createNotificationChannel() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//            CharSequence name = "Smart";
//            String desc = "Channel for Alarm Manager";
//            int imp = NotificationManager.IMPORTANCE_HIGH;
//            NotificationChannel channel = new NotificationChannel("Smart", name, imp);
//            channel.setDescription(desc);
//            NotificationManager notificationManager = getSystemService(NotificationManager.class);
//            notificationManager.createNotificationChannel(channel);
//        }
//    }
}