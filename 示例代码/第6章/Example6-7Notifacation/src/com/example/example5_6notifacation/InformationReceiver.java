package com.example.example5_6notifacation;

import android.content.BroadcastReceiver;  
import android.content.Context;  
import android.content.Intent;  
 
public class InformationReceiver extends BroadcastReceiver{  
    @Override 
    public void onReceive(Context context, Intent intent) {  
        // ʵ����Intent  
        Intent i = new Intent();  
        // ���µ�����������Activity  
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
        // ����Intent�������������  
        i.setClass(context, SecondActivity.class);  
        // ����Activity��ʾ֪ͨ  
        context.startActivity(i);  
    }  
}  
