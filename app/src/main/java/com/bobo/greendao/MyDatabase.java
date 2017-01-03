package com.bobo.greendao;

import android.content.Context;

import com.bobo.greendao.utils.SQLiteAssetHelper;


public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "notes-db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}