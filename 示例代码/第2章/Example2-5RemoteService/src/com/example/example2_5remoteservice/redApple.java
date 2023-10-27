package com.example.example2_5remoteservice;

import android.os.RemoteException;

import com.example.example2_5remoteservice.Apple.Stub;

public class redApple extends Stub {

	@Override
	public String getName() throws RemoteException {
		return "成功调用远程服务！";
	}

}