package sec3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class MultiClient {
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		MultiClient client = new MultiClient();
		client.start();
	}

	private void start() {
		Socket socket = null;
		BufferedReader in = null;
		
		
		try {
			socket = new Socket("127.0.0.1", 8443);
			//socket = new Socket("192.168.20.222", 8003);
			System.out.println("서버연결 ok");
			
			System.out.print("사용자명 입력: ");
			String name = sc.next();
			
			Thread sendThread = new SendThread(socket, name);
			sendThread.start();
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(in != null) {
				String inMsg = in.readLine();
				if(("["+name+"]님이 나가셨습니다.").equals(inMsg)) break;
				System.out.println("From: "+inMsg);
				
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try { 
				sc.close();
				socket.close();
				System.out.println("[서버 연결 종료]");
			} catch (IOException e) {
				System.out.println("소켓통신 종료 오류");
				e.printStackTrace();
			}
		}
		
	}
	
	
}