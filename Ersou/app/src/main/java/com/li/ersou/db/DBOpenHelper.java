package com.li.ersou.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {
    final static String DB_name = "waa.db";
    final static int VERSION = 1;
    public DBOpenHelper(Context context){
        super(context,DB_name,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //用户表
        db.execSQL("CREATE TABLE `user`("+
                "`user_id` INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "`user_account` varchar(20) not null,"+
                "`user_password` varchar(20) not null,"+
                "`user_name` varchar(20) not null,"+
                "`user_money` int(20) not null,"+
                "`user_address` varchar(100) not null,"+
                "`user_tel` int(12) not null,"+
                "`user_picth` varchar(200))"
        );
        //预存数据
        db.execSQL("insert into `user` values (1,'u_101','123','用户_No.1',10000,'成职1616',15351397223,'')");

        //配送员表
        db.execSQL("CREATE TABLE `diliveryman`(" +
                "`dilivery_id` INTEGER PRIMARY KEY AUTOINCREMENT," +
                "`dilivery_account` varchar(20) not null," +
                "`dilivery_password` varchar(20) not null," +
                "`dilivery_name` varchar(20) not null," +
                "`dilivery_money` int(20) not null," +
                "`dilivery_tel` int(12) not null," +
                "`dilivery_picth` varchar(200))"
        );
        //预存数据
        db.execSQL("insert into `diliveryman` values (1,'d_101','123','配送员_No.1',10000,15351397223,'')");

        //商品类型表
        db.execSQL("CREATE TABLE `producttype`("+
                "`ptid` INTEGER PRIMARY KEY AUTOINCREMENT," +
                "`ptname` varchar(20) not null)"
        );
        //预存数据
        db.execSQL("insert into `producttype` values (1,'电子商品')");
        db.execSQL("insert into `producttype` values (2,'服装')");
        db.execSQL("insert into `producttype` values (3,'鞋子')");
        db.execSQL("insert into `producttype` values (4,'日用品')");

        //商品表
        db.execSQL("CREATE TABLE `commodity`("+
                "`commodity_id` INTEGER PRIMARY KEY AUTOINCREMENT," +
                "`commodity_name` varchar(50) not null," +
                "`commodity_number` int(5) not null," +
                "`commodity_picth` varchar(200)," +
                "`commodity_new` varchar(10) not null," +
                "`commodity_bz` varchar(150)," +
                "`commodity_price` double(20,0) not null," +
                "`ptid` int(2) not null," +
                "`user_id` int(16) not null)"
        );
        db.execSQL("insert into `commodity` values (1,'戴尔E9356',1,'','8.5层新','欲求速购奥里给！',1500.0,1,1)");
        db.execSQL("insert into `commodity` values (2,'外星人高配',1,'','7.5层新','毕业不需要给学弟',3000.0,1,1)");
        db.execSQL("insert into `commodity` values (3,'跆拳道服',1,'','8.5层新','选跆拳道的学弟来看看呀',15.0,2,1)");
        db.execSQL("insert into `commodity` values (4,'海贼王正义披风',1,'','9.5层新','超帅！',150.0,2,1)");
        db.execSQL("insert into `commodity` values (5,'勾勾鞋限量版',1,'','10层新','买了没穿',2900.0,3,1)");
        db.execSQL("insert into `commodity` values (6,'洗头液',1,'','10层新','买多了',10.0,4,1)");

        //订单表
        db.execSQL("CREATE TABLE `trade`(" +
                "`trade_id` INTEGER PRIMARY KEY AUTOINCREMENT," +
                "`trade_state` int(2) not null," +
                "`user_id` int(16)," +
                "`commodity_id` int(16)," +
                "`dilivery_id` int(16))"
        );
        db.execSQL("insert into `trade` values (1,0,1,3,null)");

        //收藏表
        db.execSQL("CREATE TABLE `collection`(" +
                "`collection_id` INTEGER PRIMARY KEY AUTOINCREMENT," +
                "`user_id` int(16) not null," +
                "`commodity_id` int(16) not null)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
