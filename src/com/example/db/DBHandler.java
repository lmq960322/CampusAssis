package com.example.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBHandler {
  public ArrayList<String>getType(SQLiteDatabase db,String sql){
	  ArrayList<String>type=new ArrayList<String>();
	  Cursor cursor=db.rawQuery(sql, null);
	  while(cursor.moveToNext()){
		  type.add(cursor.getString(0));
		  
	  }
	  return type;
  }
  public ArrayList<Map<String,String>>getData(SQLiteDatabase db,String sql,String[]str){
	  ArrayList<Map<String,String>>children=new ArrayList<Map<String,String>>();
	  Cursor cursor=db.rawQuery(sql, str);
	  while(cursor.moveToNext()){
		  Map<String,String>item=new HashMap<String,String>();
		  item.put("name", cursor.getString(0));// ��ÿ����Ϣ����Map��
		  item.put("phone", cursor.getString(1)); 
		  children.add(item);   //��ÿ���¼��ӵ�������
	  }
	  return children;
  }
public void insert(SQLiteDatabase db, String sql, String[] strings) {
	// TODO Auto-generated method stub
	
}
}
