package com.april.ssl;

import java.io.IOException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class DeerServer {

	public static void main(String[] args) {
		try {
			//만들어 둔 server keyStore 파일을 임의의 폴더로 옮긴다
			System.setProperty("javax.net.ssl.keyStore", "D:\\");
			
			//password는 keyStore를 만들 떼의 저장소 비밀번호
			System.setProperty("javax.net/ssl.keyStorePassword", "dkssud123");
			
			//디버깅을 위한 설정
			System.setProperty("javax.net.debug", "ssl");
			
			System.out.println("*****keyStore : " + System.getProperty("javax.net.ssl.keyStore"));
			System.out.println("*****trustStore : " + System.getProperty("javax.net.ssl.trustStore"));
			
			//서버 소켓 팩토리 생성
			SSLServerSocketFactory sslserversocketfactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
			
			//서버 소켓 생성  (포트번호 : 1115)
			SSLServerSocket sslserversocket = (SSLServerSocket) sslserversocketfactory.createServerSocket(1115);
			
			System.out.println("Wating SSL Connection");
			
			//클라이언트가 접속하기를 기다리며 항상 대기
			while(true) {
				SSLSocket socket = (SSLSocket) sslserversocket.accept();
				//데이터 읽는 부분은 쓰레드로 처리
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
