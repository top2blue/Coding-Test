package kr.manamana.server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TimeClient {
	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			// 서버에 접속
			socket = new Socket("192.168.0.29",10004);
			// 시간 읽기
			Scanner sc = new Scanner(socket.getInputStream(),"UTF-8");
			System.out.println("읽은 시간 : " + sc.nextLine());
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
