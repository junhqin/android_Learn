package com.example.example_512;

import com.example.example_512.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class Example_512 extends Activity  
{    
	private TextView textviewHorizontal; //����TextView����textviewHorizontal
	private TextView textviewLarge;  //����TextView����textviewLarge
	private TextView textviewSmall;   //����TextView����textviewSmall
	private Button button;    //����Button����button
	private ProgressBar progressBarStyleHorizontal;  //����ProgressBar����progressBarStyleHorizontal 
	private ProgressBar progressBarStyleLarge; //����ProgressBar����progressBarStyleLarge
	private ProgressBar progressBarStyleSmall;  //����ProgressBar����progressBarStyleSmall
	public int counter=0;        //����������l
	public int loop = 10;      //��������loop�����ڿ���ѭ������
	protected static final int StopHandlerHorizontal = 0x101;   
	protected static final int StopHandlerLarge = 0x102; 
	protected static final int StopHandlerSmall = 0x103;   
	protected static final int StartHandlerHorizontal = 0x104; 
	protected static final int StartHandlerLarge = 0x105;   
	protected static final int StartHandlerSmall = 0x106; 
	/* ����Handler��Ϣ���룬������Ϊ��ʶ�¼����� */         

	public void onCreate(Bundle savedInstanceState)    
	{  
		/** Called when the activity is first created. */    
		super.onCreate(savedInstanceState);      //���ø����onCreate����
		setContentView(R.layout.main);    //ʹ��main.xml��ʼ������UI       
		button = (Button)findViewById(R.id.button);   //����XML���崴�� button  
		textviewHorizontal = (TextView)findViewById(R.id.textviewHorizontal);  //����XML���崴�� textviewHorizontal
		textviewLarge = (TextView)findViewById(R.id.textviewLarge); //����XML���崴�� textviewLarge
		textviewSmall = (TextView)findViewById(R.id.textviewSmall); //����XML���崴�� textviewSmall
		/* ����ProgressBar widget���� */      
		progressBarStyleHorizontal = (ProgressBar)findViewById(R.id.progressBarStyleHorizontal); //����XML���崴��ProgressBar����progressBarStyleHorizontal    
		progressBarStyleLarge = (ProgressBar)findViewById(R.id.progressBarStyleLarge); //����XML���崴��ProgressBar����progressBarStyleLarge
		progressBarStyleSmall = (ProgressBar)findViewById(R.id.progressBarStyleSmall);  //����XML���崴��ProgressBar����progressBarStyleSmall
		progressBarStyleHorizontal.setIndeterminate(false);   // ����progressBarStyleHorizontal��indeterminateģʽΪfalse         
		progressBarStyleLarge.setIndeterminate(false);   // ����progressBarStyleHorizontal��indeterminateģʽΪfalse  
		progressBarStyleSmall.setIndeterminate(false);   // ����progressBarStyleHorizontal��indeterminateģʽΪfalse 

		button.setOnClickListener(new Button.OnClickListener()    
		{        @Override       
			public void onClick(View v)      
		{         
			// TODO Auto-generated method stub                 

			textviewHorizontal.setText("ˮƽ��������ʼ"); //����textviewHorizontal���ı�  
			textviewLarge.setText("��ԲȦ��������ʼ");     //����textviewLarge���ı�   
			textviewSmall.setText("СԲȦ��������ʼ");     //����textviewSmall���ı�        
			progressBarStyleHorizontal.setVisibility(View.VISIBLE);    //�����ص�progressBarStyleHorizontal��ʾ����                
			progressBarStyleLarge.setVisibility(View.VISIBLE);    //�����ص�progressBarStyleLarge��ʾ����      
			progressBarStyleSmall.setVisibility(View.VISIBLE);    	//�����ص�progressBarStyleSmall��ʾ����  
			progressBarStyleHorizontal.setMax(100); //ָ��ProgressΪ���100   
			progressBarStyleLarge.setMax(100); // ָ��ProgressΪ���90  
			progressBarStyleSmall.setMax(100); // ָ��ProgressΪ���80  

			progressBarStyleHorizontal.setProgress(0); //��ʼprogressBarStyleHorizontalΪ0                   
			progressBarStyleLarge.setProgress(10); //��ʼprogressBarStyleLargeΪ10 
			progressBarStyleSmall.setProgress(50); //��ʼprogressBarStyleSmallΪ50 
			/* ��ʼһ������ */          
			new Thread(new Runnable()    
			{           
				public void run()         
				{             
					for (int i=0;i<10;i++)          
					{              
						try             
						{              
							counter = (i+1)*20;   /* ��Ա����������ʶ����ؽ��� */              
							Thread.sleep(1000);   /* ÿ����һ��ѭ��������ͣ1�� */                  
							/* ��Thread����5�����ʾ���н��� */           
							if(i==3)                 
							{   
								Message messageHorizontal = new Message();    //�½���Ϣ�����ݲ�����  Handler  
								Message messageLarge = new Message();    //�½���Ϣ�����ݲ�����  Handler 
								Message messageSmall = new Message();    //�½���Ϣ�����ݲ�����  Handler
								messageHorizontal.what = Example_512.StopHandlerHorizontal; /* ��what����ָ����ϢΪ StopHandlerHorizontal*/    
								messageLarge.what = Example_512.StopHandlerLarge; /* ��what����ָ��StopHandlerLarge��Ϣ */ 
								messageSmall.what = Example_512.StopHandlerSmall; /* ��what����ָ��StopHandlerSmall��Ϣ */ 
								
								Example_512.this.myMessageHandler.sendMessage(messageHorizontal);  //����messageHorizontal��Ϣ
								Example_512.this.myMessageHandler.sendMessage(messageLarge);  //����messageLarge��Ϣ
								Example_512.this.myMessageHandler.sendMessage(messageSmall);  //����messageSmall��Ϣ
								break;                 
							}             
							else              
							{     
								Message messageHorizontal = new Message();    //�½���Ϣ�����ݲ�����  Handler  
								Message messageLarge = new Message();    //�½���Ϣ�����ݲ�����  Handler 
								Message messageSmall = new Message();    //�½���Ϣ�����ݲ�����  Handler    
								messageHorizontal.what = Example_512.StartHandlerHorizontal;  
								messageLarge.what = Example_512.StartHandlerLarge;
								messageSmall.what = Example_512.StartHandlerSmall; 
								Example_512.this.myMessageHandler.sendMessage(messageHorizontal);  //����messageHorizontal��Ϣ
								Example_512.this.myMessageHandler.sendMessage(messageLarge);  //����messageLarge��Ϣ
								Example_512.this.myMessageHandler.sendMessage(messageSmall);  //����messageSmall��Ϣ  
							}
						}           
						catch(Exception e)             
						{                 
							e.printStackTrace();        
						}              
					}         
				}          
			}).start();    
		}      /* Ĭ��0��9��������10�ε�ѭ����� */ 
		});  
	} 
	/* ��������ť�󣬿�ʼ���̹��� */   
	/* Handler����֮�󣬻������������Ϣ���� */  
	Handler myMessageHandler = new Handler()    
	{      // @Override       
		public void handleMessage(Message msg)   
		{         
			switch (msg.what)        {     
			/* ��ȡ�ñ�ʶΪ�뿪����ʱ��ȡ�õ���Ϣ */         
			case Example_512.StopHandlerHorizontal:                
				         
				textviewHorizontal.setText("progressBarStyleHorizontal����������");    /* ��ʾ���н��� */        
				textviewHorizontal.setVisibility(View.GONE);  /* ����ProgressBar WidgetΪ���� */        
				Thread.currentThread().interrupt();         
				break;                   
				/* ��ȡ�ñ�ʶΪ�����ڽ��̵���ʱ��ȡ�õ���Ϣ */
			case Example_512.StopHandlerLarge:                
		         
				textviewLarge.setText("progressBarStyleLarge����������");    /* ��ʾ���н��� */        
				textviewLarge.setVisibility(View.GONE);  /* ����ProgressBar WidgetΪ���� */        
				Thread.currentThread().interrupt();         
				break;                   
				/* ��ȡ�ñ�ʶΪ�����ڽ��̵���ʱ��ȡ�õ���Ϣ */
			case Example_512.StopHandlerSmall:                
		         
				textviewSmall.setText("progressBarStyleSmall����������");    /* ��ʾ���н��� */        
				textviewSmall.setVisibility(View.GONE);  /* ����ProgressBar WidgetΪ���� */        
				Thread.currentThread().interrupt();         
				break;                   
				/* ��ȡ�ñ�ʶΪ�����ڽ��̵���ʱ��ȡ�õ���Ϣ */
			case Example_512.StartHandlerHorizontal:         
				if(!Thread.currentThread().isInterrupted())    
				{            
					progressBarStyleHorizontal.setProgress(counter);      
					/* ����ʾ������ʾ��TextView���� */            
					textviewHorizontal.setText            
					(             
							getResources().getText(counter, "��������ʼ")+  "("+Integer.toString(counter)+"%)\n"+          
							"Progress:"+              
							Integer.toString(progressBarStyleHorizontal.getProgress())+       
							"\n"+"Indeterminate:"+               
							Boolean.toString(progressBarStyleHorizontal.isIndeterminate())     
					);   
					//����textviewHorizontal���ı�

				}           
				break;
			case Example_512.StartHandlerLarge:         
				if(!Thread.currentThread().isInterrupted())    
				{            
					progressBarStyleLarge.setProgress(counter);      
					/* ����ʾ������ʾ��TextView���� */            
					textviewLarge.setText            
					(             
							getResources().getText(counter, "��������ʼ")+  "("+Integer.toString(counter)+"%)\n"+          
							"Progress:"+              
							Integer.toString(progressBarStyleLarge.getProgress())+       
							"\n"+"Indeterminate:"+               
							Boolean.toString(progressBarStyleLarge.isIndeterminate())     
					); 
					//����textviewLarge���ı�

				}           
				break; 
			case Example_512.StartHandlerSmall:         
				if(!Thread.currentThread().isInterrupted())    
				{            
					progressBarStyleSmall.setProgress(counter);      
					/* ����ʾ������ʾ��TextView���� */            
					textviewSmall.setText            
					(             
							getResources().getText(counter, "��������ʼ")+  "("+Integer.toString(counter)+"%)\n"+          
							"Progress:"+              
							Integer.toString(progressBarStyleSmall.getProgress())+       
							"\n"+"Indeterminate:"+               
							Boolean.toString(progressBarStyleSmall.isIndeterminate())     
					);   

				}           
				break; 
				//����textviewSmall���ı�
			}         
			super.handleMessage(msg);     
		}  
	};  
} 
