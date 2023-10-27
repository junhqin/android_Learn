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
	     * 保存文件  
	     * @param fileName 文件名称  
	     * @param content  文件内容  
	     * @throws IOException  
	     */  
	    public void save(String fileName, String content) throws IOException {  
	        //以私有方式读写数据，创建出来的文件只能被该应用访问  
	        FileOutputStream fileOutputStream = context.openFileOutput(fileName, Context.MODE_WORLD_READABLE);  
	        fileOutputStream.write(content.getBytes());  
	        fileOutputStream.close();  
	    }       
	    /**  
	     * 读取文件内容  
	     * @param fileName 文件名称  
	     * @return 文件内容  
	     * @throws IOException  
	     */  
	    public String read(String fileName) throws IOException {  
	        FileInputStream fileInputStream = context.openFileInput(fileName);  
	        //把每次读取的内容写入到内存中，然后从内存中获取  
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();  
	        byte[] buffer = new byte[1024];  
	        int len =0;  
	        //只要没读完，不断的读取  
	        while((len=fileInputStream.read(buffer))!=-1){  
	            outputStream.write(buffer, 0, len);  
	        }  
	        //得到内存中写入的所有数据  
	        byte[] data = outputStream.toByteArray();  
	        return new String(data);  
	    }  

	    /*
	     * 读取SD卡上内容
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

