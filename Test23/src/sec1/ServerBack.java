package sec1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;



public class ServerBack extends Thread {
	Vector<ReceiveInfo> clientList = new Vector<ReceiveInfo>();
	List<String> nickNameList = new ArrayList<>();
	ServerSocket serverSocket;
	Socket socket;
	private ChatServerGUI serverChatGUI;


	
	public void setGUI(ChatServerGUI serverChatGui) {
		this.serverChatGUI = serverChatGui;
	}

	public void startServer(int port) {
		try {
			Collections.synchronizedList(clientList);
			serverSocket = new ServerSocket(port);
			System.out.println("현재 IP주소: [" + InetAddress.getLocalHost() + "]");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			nickNameList.add("Admin");
			while (true) {
				System.out.println("서버 접속 대기 중");
				socket = serverSocket.accept();
				System.out.println("[" + socket.getInetAddress() + "]에서 접속하셨습니다.");
				ReceiveInfo receive = new ReceiveInfo(socket);
				clientList.add(receive);
				receive.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeClient(ReceiveInfo client, String nickname) {
		clientList.removeElement(client);
		nickNameList.remove(nickname);
		System.out.println("목록에서 " + nickname + "을 제거 하였습니다.");
		serverChatGUI.userList.setText(null);
		serverChatGUI.appendUserList(nickNameList);
	}

	public void transmitAll(String message) {
		for(int i =0; i<clientList.size();i++) {
			try {
				ReceiveInfo ri = clientList.elementAt(i);
				ri.transmitAll(message);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	class ReceiveInfo extends Thread {
		private DataInputStream in;
		private DataOutputStream out;
		String nickname;
		String message;
		

		public ReceiveInfo(Socket socket) {
			try {
				out = new DataOutputStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());
				nickname = in.readUTF();
				nickNameList.add(nickname);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		@Override
		public void run() {
			try {
				serverChatGUI.userList.setText(null);
				serverChatGUI.appendUserList(nickNameList);
				transmitAll(nickname + "님이 입장하셨습니다.\n");
				for (int i = 0; i < nickNameList.size(); i++) {
					transmitAll("+++닉네임의시작+++" + nickNameList.get(i));
				}
				serverChatGUI.appendMessage(nickname + "님이 입장하셨습니다.\n");
				while (true) {
					message = in.readUTF();
					serverChatGUI.appendMessage(message);
				
					transmitAll(message);
				}
			} catch (Exception e) {
				System.out.println(nickname + "님이 퇴장하셨습니다.\n");
				removeClient(this, nickname);
				transmitAll(nickname + "님이 퇴장하셨습니다.\n");
				for (int i = 0; i < nickNameList.size(); i++) {
					transmitAll("+++닉네임의시작+++"+ nickNameList.get(i));
				}
				serverChatGUI.appendMessage(nickname + "님이 퇴장하셨습니다.\n");
			}

		}

		public void transmitAll(String message) {
			try {
				out.writeUTF(message);
				out.flush();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
