package com.android.file.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

public class FileUtil {
	  private Context context;  
	    public FileUtil(Context context) {  
	        super();  
	        this.context = context;  
}
	    /**  
	     * �����ļ�  
	     * @param fileName �ļ�����  
	     * @param content  �ļ�����  
	     * @throws IOException  
	     */  
	    public void save(String fileName, String content) throws IOException {  
	        //��˽�з�ʽ��д���ݣ������������ļ�ֻ�ܱ���Ӧ�÷���  
	        FileOutputStream fileOutputStream = context.openFileOutput(fileName, Context.MODE_WORLD_READABLE);  
	        fileOutputStream.write(content.getBytes());  
	        fileOutputStream.close();  
	    }       
	    /**  
	     * ��ȡ�ļ�����  
	     * @param fileName �ļ�����  
	     * @return �ļ�����  
	     * @throws IOException  
	     */  
	    public String read(String fileName) throws IOException {  
	        FileInputStream fileInputStream = context.openFileInput(fileName);  
	        //��ÿ�ζ�ȡ������д�뵽�ڴ��У�Ȼ����ڴ��л�ȡ  
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();  
	        byte[] buffer = new byte[1024];  
	        int len =0;  
	        //ֻҪû���꣬���ϵĶ�ȡ  
	        while((len=fileInputStream.read(buffer))!=-1){  
	            outputStream.write(buffer, 0, len);  
	        }  
	        //�õ��ڴ���д�����������  
	        byte[] data = outputStream.toByteArray();  
	        return new String(data);  
	    }  

	    /*
	     * ��ȡSD��������
	     */	    
	    public String readSDcard()
	    {String readString ="";
	    	File sdCardPath=Environment.getExternalStorageDirectory();
	    	String path=sdCardPath+File.separator+"ddd.txt";
	    	try{
	            
	            FileInputStream fileIS = new FileInputStream(path);
	           BufferedReader buf = new BufferedReader(new InputStreamReader(fileIS));
	           while((readString = buf.readLine())!= null){
	        	   
	                Log.d("line: ", readString);
	             }
	            fileIS.close();
	       
	          } catch (FileNotFoundException e) {
	             e.printStackTrace();
	           } catch (IOException e){
	            e.printStackTrace();
	          }
			return readString;
	    }
	}  

