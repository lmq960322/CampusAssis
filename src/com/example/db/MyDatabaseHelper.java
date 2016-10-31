package com.example.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper{
	final String CREATE_TABLE_SQL="create table pone_tb(_id integer primary"+"key autoincrement,name,phone,type,keyword)";

	public MyDatabaseHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);  //���췽��
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {  //��һ�δ���ʱ����
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE_SQL);  //ִ�н������
		init(db);   //��ʼ�����ݿ�
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub   //�汾����ʱ���Զ�����
		System.out.println("--------"+oldVersion+"--------->"+ newVersion);
		
	}
	public void init (SQLiteDatabase db){
		db.execSQL("insert into phone_tb values(null,'���̹���ѧԺ','83816813','ѧԺ����','���̹���ѧԺ83816813')");
		
	}

}
