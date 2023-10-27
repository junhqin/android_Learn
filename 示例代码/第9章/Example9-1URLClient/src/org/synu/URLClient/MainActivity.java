package org.synu.URLClient;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EncodingUtils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity extends Activity {
	protected static final String TAG = null;
	String txturl = "http://192.168.100.100:8080/URLResouce/info_url.txt";
	String txthttp = "http://192.168.100.100:8080/URLResouce/info_http.txt";
	String bitmapurl = "http://192.168.100.100:8080/URLResouce/p1.jpg";

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		Button btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				getUrlTXTResources();
				getUrlPICResources();
				getHttpTXTResources();

			}
		});
	}

	public void getUrlTXTResources() {
		URL myUrl;
		try {
			myUrl = new URL(txturl);
			URLConnection MyCon = myUrl.openConnection();
			MyCon.setDoOutput(false);
			InputStream in = MyCon.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(in);
			ByteArrayBuffer baf = new ByteArrayBuffer(bis.available());
			int data = 0;
			while ((data = bis.read()) != -1) {
				baf.append((byte) data);
			}
			String msg = EncodingUtils.getString(baf.toByteArray(), "UTF-8");
			TextView tv = (TextView) findViewById(R.id.tvUrl);
			tv.setText(msg);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getUrlPICResources() {
		URL myUrl;
		try {
			myUrl = new URL(bitmapurl);
			URLConnection myCon = myUrl.openConnection();
			InputStream in = myCon.getInputStream();
			Bitmap bmp = BitmapFactory.decodeStream(in);
			ImageView im = (ImageView) findViewById(R.id.iv);
			im.setImageBitmap(bmp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getHttpTXTResources() {
		StringBuffer sb = new StringBuffer();
		String line = null;
		URL myUrl;
		try {
			myUrl = new URL(txthttp);
			HttpURLConnection MyCon = (HttpURLConnection) myUrl
					.openConnection();
			InputStream in = MyCon.getInputStream();
			InputStreamReader isr = new InputStreamReader(in, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		TextView tv = (TextView) findViewById(R.id.tvHttp);
		tv.setText(sb.toString());
	}
}
