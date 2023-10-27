package com.example.example9_3receiversms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;
//public class SMSBR extends BroadcastReceiver
//{
//    private static final String ACTION = "android.provider.Telephony.SMS_RECEIVED";
//    @Override
//    public void onReceive(Context context, Intent intent)
//    {
//        if(intent!=null && intent.getAction()!=null && ACTION.compareToIgnoreCase(intent.getAction())==0)
//        {
//            Object[]pduArray= (Object[]) intent.getExtras().get("pdus");
//            SmsMessage[] messages = new SmsMessage[pduArray.length];
//            for (int i = 0; i<pduArray.length; i++) {
//                    messages[i] = SmsMessage.createFromPdu ((byte[])pduArray [i]);
//            }
//            StringBuilder sb = new StringBuilder();
//            for (SmsMessage cur:messages)
//            {
//             sb.append("from：");
//             sb.append(cur.getDisplayOriginatingAddress());
//             sb.append(" body：");
//             sb.append(cur.getDisplayMessageBody());
//            }
//            Log.d("MySMSMonitor","SMS Message Received."+sb.toString());
//        }
//    }
//}
public class SMSBR extends BroadcastReceiver{
	 public static final String ACTION = "android.provider.Telephony.SMS_RECEIVED";  
	    public void onReceive(Context context, Intent intent) {  
	        // TODO Auto-generated method stub  
	        if (ACTION.equals(intent.getAction())) {  
	            Intent i = new Intent(context, MainActivity.class);  
	            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
	            SmsMessage[] msgs = getMessageFromIntent(intent);  
	              
	            StringBuilder sBuilder = new StringBuilder();  
	            if (msgs != null && msgs.length > 0 ) {  
	                for (SmsMessage msg : msgs) {  
	                    sBuilder.append("接收到了短信：\n发件人是：");  
	                    sBuilder.append(msg.getDisplayOriginatingAddress());  
	                    sBuilder.append("\n------短信内容-------\n");  
	                    sBuilder.append(msg.getDisplayMessageBody());  
	                    i.putExtra("sms_address", msg.getDisplayOriginatingAddress());  
	                    i.putExtra("sms_body", msg.getDisplayMessageBody());  
	                }  
	            } 
	            Toast.makeText(context, sBuilder.toString(), 1000).show();  
	            context.startActivity(i);  
	        }  
	          
	    }  
	      
	    public static SmsMessage[] getMessageFromIntent(Intent intent) {  
	        SmsMessage retmeMessage[] = null;  
	        Bundle bundle = intent.getExtras();  
	        Object pdus[] = (Object[]) bundle.get("pdus");  
	        retmeMessage = new SmsMessage[pdus.length];  
	        for (int i = 0; i < pdus.length; i++) {  
	            byte[] bytedata = (byte[]) pdus[i];  
	            retmeMessage[i]  = SmsMessage.createFromPdu(bytedata);  
	        }  
	        return retmeMessage;  
	    }  
}
