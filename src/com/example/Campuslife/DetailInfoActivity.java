package com.example.Campuslife;

import com.example.campusassist.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DetailInfoActivity extends Activity {
	private TextView info;
	private Button goBack;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detailinfo);
		String detail=getIntent().getStringExtra("info");
		info=(TextView)findViewById(R.id.info);
		goBack=(Button)findViewById(R.id.goBack);
		info.setText(detail);
		goBack.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent=new Intent(DetailInfoActivity.this,FreshAssistActivity.class);
				startActivity(intent);
				finish();				
			}
		});
	}
}