package com.example.example_55;

import com.example.example_55.R;

import android.app.Activity;
import android.graphics.ColorMatrixColorFilter; //ColorMatrixColorFilter提供颜色矩阵过滤
import android.os.Bundle;
import android.view.MotionEvent;//导入移动事件包，该类定义了多种丰富的鼠标事件
import android.view.View;
import android.widget.ImageButton;//导入图像按钮包

public class Example_55 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ImageButton btn = (ImageButton) findViewById(R.id.imagebutton);   
        /*单击时的颜色过滤 */  
        final float[] CLICKED=new float[] {       
        	 2, 0, 0, 0, 2,       
        	 0, 2, 0, 0, 2,       
        	 0, 0, 2, 0, 2,       
        	 0, 0, 0, 1, 0 };      
        	       
         /*单击结束时的颜色过滤 */     
        final float[] CLICKED_OVER=new float[] {       
        	 1, 0, 0, 0, 0,       
        	 0, 1, 0, 0, 0,       
        	 0, 0, 1, 0, 0,       
        	 0, 0, 0, 1, 0 };           

        btn.setBackgroundResource(R.drawable.touch_up);   
        btn.setOnTouchListener(new ImageButton.OnTouchListener(){   
            @SuppressWarnings("deprecation")
			@Override  
            public boolean onTouch(View view, MotionEvent event) { 
                if(event.getAction() == MotionEvent.ACTION_DOWN){   
                	view.setBackgroundResource(R.drawable.touch_down);
                	view.getBackground().setColorFilter(new ColorMatrixColorFilter(CLICKED));
                	//取得背景颜色过滤矩阵
                	view.setBackgroundDrawable(view.getBackground());
                	//设置背景为指定的过滤颜色
                } 
                /*当单击时，设置背景颜色为CLICKED的过滤颜色*/
                else if(event.getAction() == MotionEvent.ACTION_UP){   
                	view.setBackgroundResource(R.drawable.touch_up);
                	view.getBackground().setColorFilter(new ColorMatrixColorFilter(CLICKED_OVER));
                	//取得背景颜色过滤矩阵
                	view.setBackgroundDrawable(view.getBackground());
                	//设置背景为指定的过滤颜色
                }
                /*当单击结束时，设置背景颜色为CLICKED_OVER的过滤颜色*/
                   
                return false;   
            }   
               
        }); 
        //实现ImageButton的鼠标单击事件监听

    }
}