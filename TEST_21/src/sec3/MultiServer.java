package sec3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
	public static void main(String[] args) {
		MultiServer multi = new MultiServer();
		multi.start();
	}

	public void start() {

		InetAddress local;
		String addr = "";
		try {
			local = InetAddress.getLocalHost();
			addr = local.getHostAddress();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ServerSocket server = null;
		Socket socket = null;

		try {
			server = new ServerSocket(8443);
			while (true) {
				System.out.println(addr + "서버 실행 중: Client 연결 대기 중");
				socket = server.accept(); // 서버에 대하여 실행시
				System.out.println("서버 연결");
				ReceiveThread receiveThread = new ReceiveThread(socket);
				receiveThread.start(); // 쓰레드 형식이니 이렇게 실행해야 함
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (server != null) {
				try {
					server.close();
					System.out.println("[서버종료]");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					System.out.println("[서버소켓 통신 오류]");
				}
			}
		}
	}
}