package com.example.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper{
	final String CREATE_TABLE_SQL="create table pone_tb(_id integer primary"+"key autoincrement,name,phone,type,keyword)";

	public MyDatabaseHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);  //构造方法
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {  //第一次创建时调用
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE_SQL);  //执行建表语句
		init(db);   //初始化数据库
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub   //版本更新时，自动调用
		System.out.println("--------"+oldVersion+"--------->"+ newVersion);
		
	}
	public void init (SQLiteDatabase db){
		db.execSQL("insert into phone_tb values(null,'工商管理学院','83816813','学院号码','工商管理学院83816813')");
		
	}

}
