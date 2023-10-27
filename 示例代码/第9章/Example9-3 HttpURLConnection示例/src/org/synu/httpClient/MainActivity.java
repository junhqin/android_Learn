package org.synu.httpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author freund_xia
 * 
 */
public class MainActivity extends Activity {
	Button btnGet, btnPost;
	TextView tvGet, tvPost;
	private Thread thread = null;
	String reGet = "";
	String returnMsg = "";
	String result = "";
	String uriGet = "http://192.168.100.102:8080/androidweb/test.jsp?str=I+am+get+String";
	String uriPost = "http://192.168.100.102:8080/androidweb/test.jsp";// Post方式没有参数在这里
	String rePost = "";
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnGet = (Button) findViewById(R.id.btnGet);
		btnPost = (Button) findViewById(R.id.btnPost);
		tvGet = (TextView) findViewById(R.id.tvGet);
		tvPost = (TextView) findViewById(R.id.tvPost);
	}
	public void clickGet(View view) {
		thread = new Thread(new Runnable() {
			public void run() {
				HttpGet httpRequst = new HttpGet(uriGet);
				try {
					// 使用DefaultHttpClient类的execute方法发送HTTP
					// GET请求，并返回HttpResponse对象。
					HttpResponse httpResponse = new DefaultHttpClient()
							.execute(httpRequst);// 其中HttpGet是HttpUriRequst的子类
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						HttpEntity httpEntity = httpResponse.getEntity();
						result = EntityUtils.toString(httpEntity);// 取出应答字符串
						// 一般来说都要删除多余的字符
						//result.replaceAll("\r", "");// 去掉返回结果中的"\r"字符，否则会在结果字符串后面显示一个小方格
					} else
						httpRequst.abort();
				} catch (ClientProtocolException e) {
					e.printStackTrace();
					result = e.getMessage().toString();
				} catch (IOException e) {
					e.printStackTrace();
					result = e.getMessage().toString();
				}
				Message message = new Message();
				Bundle bundle = new Bundle();
				bundle.putString("msg", result);
				message.setData(bundle);
				handler.sendMessage(message);
			}
		});
		thread.start();
	};
	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			Bundle bundle = msg.getData();
			returnMsg = bundle.get("msg").toString();
			tvGet.setText(returnMsg);
		};
	};
	public void clickPost(View view) {
		thread = new Thread(new Runnable() {
			public void run() {

				HttpPost httpRequst = new HttpPost(uriPost);// 创建HttpPost对象
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("str", "I am Post String"));

				try {
					httpRequst.setEntity(new UrlEncodedFormEntity(params,
							HTTP.UTF_8));
					HttpResponse httpResponse = new DefaultHttpClient()
							.execute(httpRequst);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						HttpEntity httpEntity = httpResponse.getEntity();
						result = EntityUtils.toString(httpEntity);// 取出应答字符串
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					result = e.getMessage().toString();
				} catch (ClientProtocolException e) {
					e.printStackTrace();
					result = e.getMessage().toString();
				} catch (IOException e) {
					e.printStackTrace();
					result = e.getMessage().toString();
				}
				Message message = new Message();
				Bundle bundle = new Bundle();
				bundle.putString("msg", result);
				message.setData(bundle);
				handler1.sendMessage(message);
			}
		});
		thread.start();
	};
	Handler handler1 = new Handler() {
		public void handleMessage(Message msg) {
			Bundle bundle = msg.getData();
			rePost = bundle.get("msg").toString();
			tvPost.setText(rePost);
		};
	};
}
