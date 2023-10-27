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
	private TextView textviewHorizontal; //声明TextView对象textviewHorizontal
	private TextView textviewLarge;  //声明TextView对象textviewLarge
	private TextView textviewSmall;   //声明TextView对象textviewSmall
	private Button button;    //声明Button对象button
	private ProgressBar progressBarStyleHorizontal;  //声明ProgressBar对象progressBarStyleHorizontal 
	private ProgressBar progressBarStyleLarge; //声明ProgressBar对象progressBarStyleLarge
	private ProgressBar progressBarStyleSmall;  //声明ProgressBar对象progressBarStyleSmall
	public int counter=0;        //声明计数器l
	public int loop = 10;      //声明变量loop。用于控制循环次数
	protected static final int StopHandlerHorizontal = 0x101;   
	protected static final int StopHandlerLarge = 0x102; 
	protected static final int StopHandlerSmall = 0x103;   
	protected static final int StartHandlerHorizontal = 0x104; 
	protected static final int StartHandlerLarge = 0x105;   
	protected static final int StartHandlerSmall = 0x106; 
	/* 定义Handler信息代码，用以作为标识事件处理 */         

	public void onCreate(Bundle savedInstanceState)    
	{  
		/** Called when the activity is first created. */    
		super.onCreate(savedInstanceState);      //调用父类的onCreate方法
		setContentView(R.layout.main);    //使用main.xml初始化程序UI       
		button = (Button)findViewById(R.id.button);   //根据XML定义创建 button  
		textviewHorizontal = (TextView)findViewById(R.id.textviewHorizontal);  //根据XML定义创建 textviewHorizontal
		textviewLarge = (TextView)findViewById(R.id.textviewLarge); //根据XML定义创建 textviewLarge
		textviewSmall = (TextView)findViewById(R.id.textviewSmall); //根据XML定义创建 textviewSmall
		/* 设置ProgressBar widget对象 */      
		progressBarStyleHorizontal = (ProgressBar)findViewById(R.id.progressBarStyleHorizontal); //根据XML定义创建ProgressBar对象progressBarStyleHorizontal    
		progressBarStyleLarge = (ProgressBar)findViewById(R.id.progressBarStyleLarge); //根据XML定义创建ProgressBar对象progressBarStyleLarge
		progressBarStyleSmall = (ProgressBar)findViewById(R.id.progressBarStyleSmall);  //根据XML定义创建ProgressBar对象progressBarStyleSmall
		progressBarStyleHorizontal.setIndeterminate(false);   // 设置progressBarStyleHorizontal的indeterminate模式为false         
		progressBarStyleLarge.setIndeterminate(false);   // 设置progressBarStyleHorizontal的indeterminate模式为false  
		progressBarStyleSmall.setIndeterminate(false);   // 设置progressBarStyleHorizontal的indeterminate模式为false 

		button.setOnClickListener(new Button.OnClickListener()    
		{        @Override       
			public void onClick(View v)      
		{         
			// TODO Auto-generated method stub                 

			textviewHorizontal.setText("水平进度条开始"); //设置textviewHorizontal的文本  
			textviewLarge.setText("大圆圈进度条开始");     //设置textviewLarge的文本   
			textviewSmall.setText("小圆圈进度条开始");     //设置textviewSmall的文本        
			progressBarStyleHorizontal.setVisibility(View.VISIBLE);    //将隐藏的progressBarStyleHorizontal显示出来                
			progressBarStyleLarge.setVisibility(View.VISIBLE);    //将隐藏的progressBarStyleLarge显示出来      
			progressBarStyleSmall.setVisibility(View.VISIBLE);    	//将隐藏的progressBarStyleSmall显示出来  
			progressBarStyleHorizontal.setMax(100); //指定Progress为最多100   
			progressBarStyleLarge.setMax(100); // 指定Progress为最多90  
			progressBarStyleSmall.setMax(100); // 指定Progress为最多80  

			progressBarStyleHorizontal.setProgress(0); //初始progressBarStyleHorizontal为0                   
			progressBarStyleLarge.setProgress(10); //初始progressBarStyleLarge为10 
			progressBarStyleSmall.setProgress(50); //初始progressBarStyleSmall为50 
			/* 开始一个进程 */          
			new Thread(new Runnable()    
			{           
				public void run()         
				{             
					for (int i=0;i<10;i++)          
					{              
						try             
						{              
							counter = (i+1)*20;   /* 成员变量，用以识别加载进度 */              
							Thread.sleep(1000);   /* 每运行一次循环，即暂停1秒 */                  
							/* 当Thread运行5秒后显示运行结束 */           
							if(i==3)                 
							{   
								Message messageHorizontal = new Message();    //新建信息，传递参数给  Handler  
								Message messageLarge = new Message();    //新建信息，传递参数给  Handler 
								Message messageSmall = new Message();    //新建信息，传递参数给  Handler
								messageHorizontal.what = Example_512.StopHandlerHorizontal; /* 以what属性指定消息为 StopHandlerHorizontal*/    
								messageLarge.what = Example_512.StopHandlerLarge; /* 以what属性指定StopHandlerLarge消息 */ 
								messageSmall.what = Example_512.StopHandlerSmall; /* 以what属性指定StopHandlerSmall消息 */ 
								
								Example_512.this.myMessageHandler.sendMessage(messageHorizontal);  //发送messageHorizontal消息
								Example_512.this.myMessageHandler.sendMessage(messageLarge);  //发送messageLarge消息
								Example_512.this.myMessageHandler.sendMessage(messageSmall);  //发送messageSmall消息
								break;                 
							}             
							else              
							{     
								Message messageHorizontal = new Message();    //新建信息，传递参数给  Handler  
								Message messageLarge = new Message();    //新建信息，传递参数给  Handler 
								Message messageSmall = new Message();    //新建信息，传递参数给  Handler    
								messageHorizontal.what = Example_512.StartHandlerHorizontal;  
								messageLarge.what = Example_512.StartHandlerLarge;
								messageSmall.what = Example_512.StartHandlerSmall; 
								Example_512.this.myMessageHandler.sendMessage(messageHorizontal);  //发送messageHorizontal消息
								Example_512.this.myMessageHandler.sendMessage(messageLarge);  //发送messageLarge消息
								Example_512.this.myMessageHandler.sendMessage(messageSmall);  //发送messageSmall消息  
							}
						}           
						catch(Exception e)             
						{                 
							e.printStackTrace();        
						}              
					}         
				}          
			}).start();    
		}      /* 默认0至9，共运行10次的循环语句 */ 
		});  
	} 
	/* 当单击按钮后，开始进程工作 */   
	/* Handler构建之后，会监听传来的信息代码 */  
	Handler myMessageHandler = new Handler()    
	{      // @Override       
		public void handleMessage(Message msg)   
		{         
			switch (msg.what)        {     
			/* 当取得标识为离开进程时所取得的信息 */         
			case Example_512.StopHandlerHorizontal:                
				         
				textviewHorizontal.setText("progressBarStyleHorizontal进度条结束");    /* 显示运行结束 */        
				textviewHorizontal.setVisibility(View.GONE);  /* 设置ProgressBar Widget为隐藏 */        
				Thread.currentThread().interrupt();         
				break;                   
				/* 当取得标识为持续在进程当中时所取得的信息 */
			case Example_512.StopHandlerLarge:                
		         
				textviewLarge.setText("progressBarStyleLarge进度条结束");    /* 显示运行结束 */        
				textviewLarge.setVisibility(View.GONE);  /* 设置ProgressBar Widget为隐藏 */        
				Thread.currentThread().interrupt();         
				break;                   
				/* 当取得标识为持续在进程当中时所取得的信息 */
			case Example_512.StopHandlerSmall:                
		         
				textviewSmall.setText("progressBarStyleSmall进度条结束");    /* 显示运行结束 */        
				textviewSmall.setVisibility(View.GONE);  /* 设置ProgressBar Widget为隐藏 */        
				Thread.currentThread().interrupt();         
				break;                   
				/* 当取得标识为持续在进程当中时所取得的信息 */
			case Example_512.StartHandlerHorizontal:         
				if(!Thread.currentThread().isInterrupted())    
				{            
					progressBarStyleHorizontal.setProgress(counter);      
					/* 将显示进度显示于TextView当中 */            
					textviewHorizontal.setText            
					(             
							getResources().getText(counter, "进度条开始")+  "("+Integer.toString(counter)+"%)\n"+          
							"Progress:"+              
							Integer.toString(progressBarStyleHorizontal.getProgress())+       
							"\n"+"Indeterminate:"+               
							Boolean.toString(progressBarStyleHorizontal.isIndeterminate())     
					);   
					//设置textviewHorizontal的文本

				}           
				break;
			case Example_512.StartHandlerLarge:         
				if(!Thread.currentThread().isInterrupted())    
				{            
					progressBarStyleLarge.setProgress(counter);      
					/* 将显示进度显示于TextView当中 */            
					textviewLarge.setText            
					(             
							getResources().getText(counter, "进度条开始")+  "("+Integer.toString(counter)+"%)\n"+          
							"Progress:"+              
							Integer.toString(progressBarStyleLarge.getProgress())+       
							"\n"+"Indeterminate:"+               
							Boolean.toString(progressBarStyleLarge.isIndeterminate())     
					); 
					//设置textviewLarge的文本

				}           
				break; 
			case Example_512.StartHandlerSmall:         
				if(!Thread.currentThread().isInterrupted())    
				{            
					progressBarStyleSmall.setProgress(counter);      
					/* 将显示进度显示于TextView当中 */            
					textviewSmall.setText            
					(             
							getResources().getText(counter, "进度条开始")+  "("+Integer.toString(counter)+"%)\n"+          
							"Progress:"+              
							Integer.toString(progressBarStyleSmall.getProgress())+       
							"\n"+"Indeterminate:"+               
							Boolean.toString(progressBarStyleSmall.isIndeterminate())     
					);   

				}           
				break; 
				//设置textviewSmall的文本
			}         
			super.handleMessage(msg);     
		}  
	};  
} 
