package kr.manamana.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. 서버 생성
			serverSocket = new ServerSocket(10004); // 10004포트를 열어 서버 시작
			while(true) {
				// 2. 접속 대기
				Socket socket = serverSocket.accept();
				// 3. 접속이 완료되면 현재시간을 클라이언트로 보내고 닫는다.
				SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss.S");
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				pw.write(sdf.format(new Date()) + "\n");
				pw.flush();
				pw.close();
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
