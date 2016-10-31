package com.example.Campuslife;

import com.example.android.MainActivity;
import com.example.campusassist.R;
import com.example.phone.AddPhoneActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CampusLifeActivity extends Activity{
    private Button campusBuild ,campusScenery,freshAssist,goBack;
   
   protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.campuslife);
	    campusBuild = (Button) findViewById(R.id.campusBuild);
		campusScenery = (Button) findViewById(R.id.campusScenery);
		freshAssist = (Button) findViewById(R.id.freshAssist);
		goBack = (Button) findViewById(R.id.goBack);
		myOnClickListener myListener=new myOnClickListener();
		campusBuild.setOnClickListener(myListener);
		campusScenery.setOnClickListener(myListener);
		freshAssist.setOnClickListener(myListener);
		goBack.setOnClickListener(myListener);
	}

	private class myOnClickListener implements OnClickListener {
		Intent intent=null;
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.campusBuild:
				intent=new Intent(CampusLifeActivity.this,AddPhoneActivity.class);
				break;
			case R.id.campusScenery:
				intent=new Intent(CampusLifeActivity.this,CampusSceneryActivity.class);
				break;
			case R.id.freshAssist:
				intent=new Intent(CampusLifeActivity.this,FreshAssistActivity.class);
				break;
			case R.id.goBack:
				intent=new Intent(CampusLifeActivity.this,MainActivity.class);
				break;

			default:
				break;
			}
			startActivity(intent);
		}

	}

   }

