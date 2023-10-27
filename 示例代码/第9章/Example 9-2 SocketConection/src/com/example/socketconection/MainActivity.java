package com.example.socketconection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class MainActivity extends Activity {
	EditText et, etSERVER;
	private Thread thread = null;

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et = (EditText) findViewById(R.id.et);
		etSERVER = (EditText) findViewById(R.id.et1);
		Button btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				thread = new Thread(new Runnable() {
					public void run() {
						String ip = "192.168.100.100";
						int port = 55566;
						Socket so = null;
						try {
							so = new Socket(ip, port);
							String msg = et.getText().toString();
							// 将客户端的消息写入PrintWriter流中，通过out.println(msg)方法客户端将消息放入输出流中，以便服务器读取
							PrintWriter out = new PrintWriter(
									new BufferedWriter(new OutputStreamWriter(
											so.getOutputStream())), true);
							out.println(msg);
							out.flush();
							BufferedReader in = new BufferedReader(
									new InputStreamReader(so.getInputStream()));
							String str = in.readLine();
							Message message = new Message();
							Bundle bundle = new Bundle();
							bundle.putString("msg", str);
							message.setData(bundle);
							handler.sendMessage(message);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

				thread.start();
			}
		});

	}

	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			Bundle bundle = msg.getData();
			String returnMsg = bundle.get("msg").toString();
			etSERVER.setText(returnMsg);
		};
	};

}
