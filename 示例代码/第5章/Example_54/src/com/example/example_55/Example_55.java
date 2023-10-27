package com.example.example_55;

import com.example.example_55.R;

import android.app.Activity;
import android.graphics.ColorMatrixColorFilter; //ColorMatrixColorFilter�ṩ��ɫ�������
import android.os.Bundle;
import android.view.MotionEvent;//�����ƶ��¼��������ඨ���˶��ַḻ������¼�
import android.view.View;
import android.widget.ImageButton;//����ͼ��ť��

public class Example_55 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ImageButton btn = (ImageButton) findViewById(R.id.imagebutton);   
        /*����ʱ����ɫ���� */  
        final float[] CLICKED=new float[] {       
        	 2, 0, 0, 0, 2,       
        	 0, 2, 0, 0, 2,       
        	 0, 0, 2, 0, 2,       
        	 0, 0, 0, 1, 0 };      
        	       
         /*��������ʱ����ɫ���� */     
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
                	//ȡ�ñ�����ɫ���˾���
                	view.setBackgroundDrawable(view.getBackground());
                	//���ñ���Ϊָ���Ĺ�����ɫ
                } 
                /*������ʱ�����ñ�����ɫΪCLICKED�Ĺ�����ɫ*/
                else if(event.getAction() == MotionEvent.ACTION_UP){   
                	view.setBackgroundResource(R.drawable.touch_up);
                	view.getBackground().setColorFilter(new ColorMatrixColorFilter(CLICKED_OVER));
                	//ȡ�ñ�����ɫ���˾���
                	view.setBackgroundDrawable(view.getBackground());
                	//���ñ���Ϊָ���Ĺ�����ɫ
                }
                /*����������ʱ�����ñ�����ɫΪCLICKED_OVER�Ĺ�����ɫ*/
                   
                return false;   
            }   
               
        }); 
        //ʵ��ImageButton����굥���¼�����

    }
}