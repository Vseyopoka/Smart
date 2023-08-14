package com.example.smart.Activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseUsers extends SQLiteOpenHelper {
    public static final String databaseName = "UserInf.db";
    public DataBaseUsers(@Nullable Context context) {
        super(context, "UserInf.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table usersInfo(fullname TEXT primary key," +
                " groups TEXT,chin TEXT,dolgnost TEXT,region TEXT, city TEXT, education TEXT, mobilephone TEXT, link TEXT,email TEXT," +
                "progress TEXT, expirience TEXT, talkskills TEXT, collectiveskills TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists usersInfo");
    }
    public Boolean insertData(String fullname, String groups,String chin, String dolgnost, String region, String city,
                              String education, String mobilephone,String link,String email,String progress,
                              String expirience,String talkskills, String collectiveskills){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ФИО", fullname);
        contentValues.put("Казачье общество", groups);
        contentValues.put("Чин", chin);
        contentValues.put("Должность", dolgnost);
        contentValues.put("Регион", region);
        contentValues.put("Город", city);
        contentValues.put("Образование", education);
        contentValues.put("Контактный телефон", mobilephone);
        contentValues.put("Ссылка на соцсети", link);
        contentValues.put("Email", email);
        contentValues.put("Достижения", progress);
        contentValues.put("Опыт", expirience);
        contentValues.put("Коммуникативные навыки", talkskills);
        contentValues.put("Коллективные навыки", collectiveskills);
        long result = sqLiteDatabase.insert("usersInfo", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Boolean checkFullname(String fullname){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where fullname = ?", new String[]{fullname});
        if(cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
    public Boolean checkGroup(String groups){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where groups = ?", new String[]{groups});
        if(cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
    public Boolean checkChin(String chin){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where chin = ?", new String[]{chin});
        if(cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
    public Boolean checkDolgnost(String dolgnost){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where dolgnost = ?", new String[]{dolgnost});
        if(cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
    public Boolean checkRegion(String region){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where region = ?", new String[]{region});
        if(cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
    public Boolean checkCity(String city){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where city = ? ", new String[]{city});
        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }

    public Boolean checkEducation(String education){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where education = ?", new String[]{education});
        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }

    public Boolean checkMobilePhone(String mobilephone){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where mobilephone = ? ", new String[]{mobilephone});
        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }

    public Boolean checkLink(String link){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where link = ? ", new String[]{link});
        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }

    public Boolean checkEmail(String email){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where email = ? ", new String[]{email});
        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }

    public Boolean checkProgress(String progress){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where progress = ?", new String[]{progress});
        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }

    public Boolean checkExpirience(String expirience){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where expirience = ?", new String[]{expirience});
        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }

    public Boolean checkCommunicationSkills(String communicationskills){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where communicationskills = ?", new String[]{communicationskills});
        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }

    public Boolean checkCollectiveSkills(String collectiveskills){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where collectiveskills = ? ", new String[]{collectiveskills});
        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
}
