package com.bobo.greendao;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.maoqis.greendao.gen.DaoMaster;
import com.maoqis.greendao.gen.DaoSession;
import com.maoqis.greendao.gen.ItemDao;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import org.greenrobot.greendao.query.Query;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteAssetHelper sqLiteAssetHelper = new MyDatabase(this);
        SQLiteDatabase writableDatabase = sqLiteAssetHelper.getWritableDatabase();
//        DaoMaster.DevOpenHelper mHelper = new DaoMaster.DevOpenHelper(this, "databases/notes-db", null);
//        SQLiteDatabase writableDatabase = mHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        DaoSession daoSession = daoMaster.newSession();
        ItemDao itemDao = daoSession.getItemDao();
        Query<Item> query = itemDao.queryBuilder()
                .where(ItemDao.Properties.Des.like("%%"))
                .build();
        List<Item> list = query.list();
        Log.d(TAG, "onCreate: "+list);

    }
}
