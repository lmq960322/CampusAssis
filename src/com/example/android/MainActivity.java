package com.example.android;



import com.example.Campuslife.CampusLifeActivity;
import com.example.Campuslife.CampusSceneryActivity;
import com.example.campusassist.R;
import com.example.phone.AddPhoneActivity;
import com.example.phone.PhoneListActivity;
import com.example.youwannanchang.SceneryActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button phoneAssist,trafficAssist,campusLife,scenery;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		phoneAssist=(Button)findViewById(R.id.phoneAssist);
		trafficAssist=(Button)findViewById(R.id.trafficAssist);
		campusLife=(Button)findViewById(R.id.campusLife);
		scenery=(Button)findViewById(R.id.scenery);
		MyOnClickListener myOnClickListener=new MyOnClickListener();
		//创建监听器对象
		phoneAssist.setOnClickListener(myOnClickListener);
		//为按钮添加事件监听器
		trafficAssist.setOnClickListener(myOnClickListener);
		campusLife.setOnClickListener(myOnClickListener);
		scenery.setOnClickListener(myOnClickListener);
		
	}
	public class MyOnClickListener implements OnClickListener{
		//内部类实现事件监听器
		Intent intent=null;
		public void onClick(View v){
			switch(v.getId()){
			case R.id.phoneAssist:
				intent=new Intent(MainActivity.this,PhoneListActivity.class);
				break;
            case R.id.campusLife:
				intent=new Intent(MainActivity.this,CampusLifeActivity.class);
				break;
			case R.id.scenery:
				intent=new Intent(MainActivity.this,SceneryActivity.class);
				break;
			default:
				break;
				
			}
			startActivity(intent);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
