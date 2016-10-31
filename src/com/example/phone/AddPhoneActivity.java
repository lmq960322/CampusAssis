package com.example.phone;

import com.example.db.DBHandler;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPhoneActivity  extends Activity{
	

	private Button submit, reset;
	private EditText name, phone, type, keyword;
	private SQLiteDatabase db = PhoneListActivity.myHelper
			.getReadableDatabase();
     
	
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.addphone);
		
		submit= (Button) findViewById(R.id.submit);
		reset= (Button) findViewById(R.id.reset);
		name = (EditText) findViewById(R.id.name);
		phone= (EditText) findViewById(R.id.phone);
		type = (EditText) findViewById(R.id.type);
		keyword = (EditText) findViewById(R.id.keyword);
	}
	
	
	
	private class myOnclickListener implements OnClickListener{
		 public void onClick(View v){
			  switch(v.getId()){
			  case R.id.submit:
				  DBHandler dbhandler =new DBHandler();   //创建数据库操作类
				  String sql="insert into phone _tb values(null,?,?,?,?)";  //插入语句
				    String keywordStr=keyword.getText().toString();
				    if(keywordStr==null||"".equals(keywordStr)){
				    	keywordStr=name.getText().toString()+phone.getText().toString();}
				    dbhandler.insert(db,sql,new String[]{name.getText().toString(),phone.getText().toString(),
				    		                                  type.getText().toString(),keywordStr});
				    	Toast.makeText (AddPhoneActivity.this,"号码添加成功！",1000).show();
				    	Intent intent=new Intent(AddPhoneActivity.this,PhoneListActivity.class);
				    	startActivity(intent);
				    	finish();
				    	break;
			  case R.id.reset:
				     name.setText("");//姓名文本编辑框为空
				     phone.setText("");
				     type.setText("");
				     keyword.setText("");
				     break;
		       default:
		    	    break;
				    	}
				    }
			  }
		 
	}
	
	


