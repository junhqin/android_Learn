package com.example.example7_3asynctask;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	 private Button button;
	    private ImageView imageView;
	    private ProgressDialog progressDialog;
	    private final String IMAGE_PATH = "http://www.baidu.com/img/bdlogo.png";
	    @Override
	    protected void onCreate(Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        
	        button = (Button)findViewById(R.id.button);
	        imageView = (ImageView)findViewById(R.id.imageView);
	        //    弹出要给ProgressDialog
	        progressDialog = new ProgressDialog(MainActivity.this);
	        progressDialog.setTitle("提示信息");
	        progressDialog.setMessage("正在下载中，请稍后......");
	        //    设置setCancelable(false); 表示我们不能取消这个弹出框，等下载完成之后再让弹出框消失
	        progressDialog.setCancelable(false);
	        //    设置ProgressDialog样式为水平的样式
	        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
	        
	        button.setOnClickListener(new View.OnClickListener()
	        {
	            @Override
	            public void onClick(View v)
	            {
	                new MyAsyncTask().execute(IMAGE_PATH);
	            }
	        });
	    }
	    
	    /**
	     * 定义一个类，让其继承AsyncTask这个类
	     * Params: String类型，表示传递给异步任务的参数类型是String，通常指定的是URL路径
	     * Progress: Integer类型，进度条的单位通常都是Integer类型
	     * Result：byte[]类型，表示我们下载好的图片以字节数组返回
	     * @author xiaoluo
	     *
	     */
	    public class MyAsyncTask extends AsyncTask<String, Integer, byte[]>
	    {
	        @Override
	        protected void onPreExecute()
	        {
	            super.onPreExecute();
	            //    在onPreExecute()中我们让ProgressDialog显示出来
	            progressDialog.show();
	        }
	        @Override
	        protected byte[] doInBackground(String... params)
	        {
	            //    通过Apache的HttpClient来访问请求网络中的一张图片
	            HttpClient httpClient = new DefaultHttpClient();
	            HttpGet httpGet = new HttpGet(params[0]);
	            byte[] image = new byte[]{};
	            try
	            {
	                HttpResponse httpResponse = httpClient.execute(httpGet);
	                HttpEntity httpEntity = httpResponse.getEntity();
	                InputStream inputStream = null;
	                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	                if(httpEntity != null && httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
	                {
	                    //    得到文件的总长度
	                    long file_length = httpEntity.getContentLength();
	                    //    每次读取后累加的长度
	                    long total_length = 0;
	                    int length = 0;
	                    //    每次读取1024个字节
	                    byte[] data = new byte[1024];
	                    inputStream = httpEntity.getContent();
	                    while(-1 != (length = inputStream.read(data)))
	                    {
	                        //    每读一次，就将total_length累加起来
	                        total_length += length;
	                        //    边读边写到ByteArrayOutputStream当中
	                        byteArrayOutputStream.write(data, 0, length);
	                        //    得到当前图片下载的进度
	                        int progress = ((int)(total_length/(float)file_length) * 100);
	                        //    时刻将当前进度更新给onProgressUpdate方法
	                        publishProgress(progress);
	                    }
	                }
	                image = byteArrayOutputStream.toByteArray();
	                inputStream.close();
	                byteArrayOutputStream.close();
	            }
	            catch (Exception e)
	            {
	                e.printStackTrace();
	            }
	            finally
	            {
	                httpClient.getConnectionManager().shutdown();
	            }
	            return image;
	        }
	        @Override
	        protected void onProgressUpdate(Integer... values)
	        {
	            super.onProgressUpdate(values);
	            //    更新ProgressDialog的进度条
	            progressDialog.setProgress(values[0]);
	        }
	        @Override
	        protected void onPostExecute(byte[] result)
	        {
	            super.onPostExecute(result);
	            //    将doInBackground方法返回的byte[]解码成要给Bitmap
	            Bitmap bitmap = BitmapFactory.decodeByteArray(result, 0, result.length);
	            //    更新我们的ImageView控件
	            imageView.setImageBitmap(bitmap);
	            //    使ProgressDialog框消失
	            progressDialog.dismiss();
	        }
	    }
	    
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu)
	    {
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
}
