package org.synu.serverConn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConn implements Runnable {

	@Override
	public void run() {

		try {
			System.out.println("connected....");
			ServerSocket serverSocket = new ServerSocket(55566);
			while (true) {
				Socket client = serverSocket.accept();
				System.out.println("receiving......");
				String clientip = client.getInetAddress().toString();
				System.out.println("accept:" + clientip);
				try {
					// 服务器读取客户端发过来的消息
					BufferedReader in = new BufferedReader(
							new InputStreamReader(client.getInputStream()));
					String str = in.readLine();
					System.out.println("read:" + str);
					// 服务器写给客户端的消息
					PrintWriter out = new PrintWriter(new BufferedWriter(
							new OutputStreamWriter(client.getOutputStream())),
							true);
					out.println("连接OK！");
					out.close();
					in.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				} finally {
					client.close();
					System.out.println("close");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String a[]) {
		Thread desktopServerThread = new Thread(new ServerConn());
		desktopServerThread.start();
	}

}
