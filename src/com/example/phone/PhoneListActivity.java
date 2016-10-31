package com.example.phone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.db.DBHandler;
import com.example.db.MyDatabaseHelper;

import android.R;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class PhoneListActivity extends  PhoneListActivity{
	EditText keyword;
	Button query;
	DBHandler dbHandler = new DBHandler();
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.phonelist);
		myHelper = new MyDatabaseHelper(this, "phone.db", null, 1);	
		db = myHelper.getReadableDatabase();
		String sql = "select distinct type from phone_tb";
		ArrayList<String> type = dbHandler.getType(db, sql);
		ArrayList<Map<String, String>> groups = new ArrayList<Map<String, String>>();
		ArrayList<List<Map<String, String>>> children = new ArrayList<List<Map<String, String>>>();
		for (String str : type) {
			Map<String, String> item = new HashMap<String, String>();
			item.put("group", str);
			groups.add(item);
			ArrayList<Map<String, String>> child = dbHandler.getData(db,
					"select name,phone from phone_tb where type=?", new String[]{str});
			System.out.println(child);
			children.add(child);
		}

    SimpleExpandableListAdapter(
		   this,groups,R.layout.group,new String[]{"group"},new int[]{R.id.group},children,R.layout.child,
		   new String[]{"name","phone"},new int[]{R.id.name,R.id.phone});
    setListAdapter(simpleExpandListAdapter);
    keyword=(EditText)findViewById(R.layout.keyword);
    query=(Button)findViewById(R.layout.query);
    query.setOnClickListener(new OnClickListener(){
    	String sql="select name,phone from phone_tb where keyword like?";
    	public void onClick(View v){
    		 ArrayList<Map<String,String>>phoneList=dbHandler.getData(db,sql,new String[]{"%"+keyword.getText().toString()+"%"});
    		 Intent intent=new Intent (PhoneListActivity.this,ResultActivity.class);
    		 Bundle bundle=new Bundle();   //创建Bundle对象，存放数据
    		 bundle.putSerializable("result",phoneList);    //想Bundle对象放入Intent中
    		 intent.putSerializable("result",phoneList);
    		 intent.putExtras(bundle);
    		 startActivity(intent);}
    });
	}
    
          public boolean onCreateOptionsMenu(Menu menu){
        	  getMenuInflater().inflate(R.menu.phone_manager,menu);  //添加菜单
              return true;    
          }
          public boolean onOptionsItemSelected(MenuItem item){
        	  switch(item.getItemId()){
        	  case R.id.addphone；
        	      Intent intent=new intent(PhoneListActivity.this,AddPhoneActivity.class);
        	      startActivity(intent);
        	      break;
        	  case R.id.exit:
        		  this.finish();
        		  break;
        	 default :
        		  break;
        	  }
        	  return super.onOptionsItemSelected(item);
        	  }
          }
}
