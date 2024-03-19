package sec3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
	public static void main(String[] args) {
		BufferedReader in = null;
		PrintWriter out = null;
		ServerSocket server = null; // 서버 소켓
		Socket socket =null; //소켓 
		Scanner sc = new Scanner(System.in); //키보드 입력
		try {
			 server =new ServerSocket(6412); //192.168.20.212
			 System.out.println("서버 실행 중");
			 socket = server.accept(); //서버에 대하여 실행시
			 System.out.println("서버 연결");
			 in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			 out = new PrintWriter(socket.getOutputStream());
			 while(true) {
				 String inmsg = in.readLine();
				 if("quit".equalsIgnoreCase(inmsg)) break;
				 System.out.println("[From client: ]"+inmsg);
				 System.out.println("전송 >>>");
				 
				 String outMsg = sc.nextLine();
				 out.println(outMsg);
				 out.flush();
				 if("quit".equalsIgnoreCase(outMsg)) break;
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				sc.close();
				socket.close();
				server.close();
				System.out.println("연결 종료");
			} catch(IOException e) {
				System.out.println("소켓 종료 오류");
				e.printStackTrace();
			}
		
		}
	}
}
