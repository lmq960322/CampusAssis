package com.example.Campuslife;


import com.example.campusassist.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class CampusBuildActivity extends  Activity{
	private Spinner spinner;
	private ImageView myImage;
	private Button goBack;
	private float mx,my;
	int[]imageIds=new int[]{R.drawable.jiaotong,R.drawable.jiaoqiaoxiaoqu,R.drawable.mailuxiaoqu,R.drawable.fenglinxiaoqu};
	String[]xiaoqu=new String[]
			{"交通示意图","蛟桥校区","麦庐校区","枫林校区"};
	protected void onCreate(Bundle savaInstanceState){
		super.onCreate(savaInstanceState);
		setContentView(R.layout.campusbuild);
		
	    spinner= (Spinner) findViewById(R.id.spinner);
		myImage= (ImageView) findViewById(R.id.myImage);
		ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,xiaoqu);
		//设置样式和内容
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener(){
        	public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long id){
       		 myImage.setImageResource(imageIds[position]);
       		 //根据选择显示图片
            }
        	public void onNothingSelected(AdapterView<?>arg0){
        		myImage.setImageResource(imageIds[0]);
        	}
	   });
        myImage.setOnTouchListener(new OnTouchListener(){
       
               public boolean onTouch(View v, MotionEvent event) {
            	   
				// TODO Auto-generated method stub
				float curX,curY;  
				// 
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					mx=event.getX();
					my=event.getY();
					break;
				case MotionEvent.ACTION_MOVE:
					curX=event.getX();
					curY=event.getY();
					myImage.scrollBy((int)(mx-curX),(int)(my-curY));
					mx=curX;
					my=curY;
					break;
				case MotionEvent.ACTION_UP:
					curX=event.getX();
					curY=event.getY();
					myImage.scrollBy((int)(mx=curX), (int)(my-curY));
					break;
				default:
					break;
				}
            	   return false;
			}
        });
        
		
		
	}
}
