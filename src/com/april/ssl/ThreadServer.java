package com.april.ssl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.net.ssl.SSLSocket;

public class ThreadServer extends Thread{
	private SSLSocket socket;
	private InputStream inputStrem;
	private BufferedReader br;
	
	public ThreadServer(SSLSocket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		
		try {
			String fromClient = null;
			inputStrem = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(inputStrem));
			
			while((fromClient = br.readLine()) != null) {
				System.out.println(fromClient);
				System.out.flush();
			}
			
		} catch (IOException e) {
			System.out.println(getClass() + " : " + e);
			e.printStackTrace();
		}
	}
}
