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
	        //    ����Ҫ��ProgressDialog
	        progressDialog = new ProgressDialog(MainActivity.this);
	        progressDialog.setTitle("��ʾ��Ϣ");
	        progressDialog.setMessage("���������У����Ժ�......");
	        //    ����setCancelable(false); ��ʾ���ǲ���ȡ����������򣬵��������֮�����õ�������ʧ
	        progressDialog.setCancelable(false);
	        //    ����ProgressDialog��ʽΪˮƽ����ʽ
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
	     * ����һ���࣬����̳�AsyncTask�����
	     * Params: String���ͣ���ʾ���ݸ��첽����Ĳ���������String��ͨ��ָ������URL·��
	     * Progress: Integer���ͣ��������ĵ�λͨ������Integer����
	     * Result��byte[]���ͣ���ʾ�������غõ�ͼƬ���ֽ����鷵��
	     * @author xiaoluo
	     *
	     */
	    public class MyAsyncTask extends AsyncTask<String, Integer, byte[]>
	    {
	        @Override
	        protected void onPreExecute()
	        {
	            super.onPreExecute();
	            //    ��onPreExecute()��������ProgressDialog��ʾ����
	            progressDialog.show();
	        }
	        @Override
	        protected byte[] doInBackground(String... params)
	        {
	            //    ͨ��Apache��HttpClient���������������е�һ��ͼƬ
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
	                    //    �õ��ļ����ܳ���
	                    long file_length = httpEntity.getContentLength();
	                    //    ÿ�ζ�ȡ���ۼӵĳ���
	                    long total_length = 0;
	                    int length = 0;
	                    //    ÿ�ζ�ȡ1024���ֽ�
	                    byte[] data = new byte[1024];
	                    inputStream = httpEntity.getContent();
	                    while(-1 != (length = inputStream.read(data)))
	                    {
	                        //    ÿ��һ�Σ��ͽ�total_length�ۼ�����
	                        total_length += length;
	                        //    �߶���д��ByteArrayOutputStream����
	                        byteArrayOutputStream.write(data, 0, length);
	                        //    �õ���ǰͼƬ���صĽ���
	                        int progress = ((int)(total_length/(float)file_length) * 100);
	                        //    ʱ�̽���ǰ���ȸ��¸�onProgressUpdate����
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
	            //    ����ProgressDialog�Ľ�����
	            progressDialog.setProgress(values[0]);
	        }
	        @Override
	        protected void onPostExecute(byte[] result)
	        {
	            super.onPostExecute(result);
	            //    ��doInBackground�������ص�byte[]�����Ҫ��Bitmap
	            Bitmap bitmap = BitmapFactory.decodeByteArray(result, 0, result.length);
	            //    �������ǵ�ImageView�ؼ�
	            imageView.setImageBitmap(bitmap);
	            //    ʹProgressDialog����ʧ
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
