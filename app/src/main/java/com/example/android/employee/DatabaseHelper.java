package com.example.android.employee;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

    public abstract class DatabaseHelper extends SQLiteOpenHelper {
        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "employee.db";
        private static final String TABLE_USER = "employee";

        private static final String COLUMN_ID = "id";
        private static final String COLUMN_NAME = "name";
        private static final String COLUMN_PHONE = "phone";
        private static final String COLUMN_EMAIL = "email";
        private static final String COLUMN_PASSWORD = "password";

        private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY ," + COLUMN_NAME + " TEXT,"
                +COLUMN_PHONE+"INTEGER" + COLUMN_EMAIL + " TEXT," + COLUMN_PASSWORD + " TEXT" + ")";

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
           db.execSQL(CREATE_USER_TABLE);
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
            onCreate(db);
        }

        public void addEmp(input inp) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_ID, inp.getId());
            values.put(COLUMN_NAME, inp.getName());
            values.put(COLUMN_PHONE, inp.getPhone());
            values.put(COLUMN_EMAIL, inp.getEmail());
            values.put(COLUMN_PASSWORD, inp.getPassword());

            db.insert(TABLE_USER, null, values);
            db.close();
        }

    }
