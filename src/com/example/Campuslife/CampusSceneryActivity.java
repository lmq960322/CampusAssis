package com.example.Campuslife;


import iet.jxufe.cn.campuslife.CampusSceneryActivity;

import com.example.campusassist.R;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class CampusSceneryActivity  extends Activity{
	int[] images=new int[]{
			
	};
	private Button goBack;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.campusscenery);
		goBack=(Button)findViewById(R.id.goBack);
		goBack.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				Intent intent=new Intent(CampusSceneryActivity.this,CampusLifeActivity.class);
				startActivity(intent);
				finish();				
			}
		});
	final Gallery gallery = (Gallery) findViewById(R.id.gallery);	
	final ImageSwitcher switcher = (ImageSwitcher)findViewById(R.id.switcher2);
	switcher.setFactory(new ViewFactory(){ //ΪSwitcher����ͼƬ��������Ч��
		public View makeView(){
			ImageView imageView=new ImageView(CampusSceneryActivity.this);
			imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
			imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
					       LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
			return imageView;
		}
	  });
   switcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));//����ͼƬ�л��Ķ���Ϊ���뵭��
   switcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
   BaseAdapter adapter=new BaseAdapter(){
	    public int getCount(){   //��ȡ�����б�
	    	return Integer.MAX_VALUE;
	    	}
	    public Object getItem(int position){
	    	return position;  //����ѡ������Ӧ��λ��
	    }
	    public long getItemId(int position){
	    	return position;
	    }
	    public View getView(int position,View convertView,ViewGroup parent){
	    	
	    	                                                                    
	    	ImageView imageView=new ImageView(CampusSceneryActivity.this);
	    	imageView.setImageResource(images[position % images.length]);
	    	imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	    	imageView.setLayoutParams(new Gallery.LayoutParams(75,100));
	    	TypedArray typeArray=pbtainStyleAttributes(R.styleable.Gallery);
	    	imageView.setBackgroundResource(typeArray.getResourceId()R.styleable.Gallery_android_galleryItemBackground,0));
	    	return imageView;
	    }
   };
   gallery.setAdapter(adapter);
   gallery.setOnItemSelectedListener(new OnItemSelectedListener(){
	   public void onItemSelected(AdapterView<?>arg0,View arg1,int pposition,long id){
		   switcher.setImageResource(images[pposition % images.length]);  //ѡ���¼�����
	   }
	   public void onNithingSelected(AdapterView<?>arg0){
		   
	   }
   });
   
   
}
}
