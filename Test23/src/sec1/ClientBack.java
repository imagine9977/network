package sec1;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientBack extends Thread {
	private String nickName, IPAddress;
	private int Port;
	private Socket socket;
	private String message;
	private DataInputStream in;
	private DataOutputStream out;
	private ChatClientGUI chatgui;
	ArrayList<String> NickNameList = new ArrayList<String>();
	public void getUserInfo(String nickName, String IPAddress, int port) {
		this.nickName = nickName;
		this.IPAddress = IPAddress;
		this.Port = port;
		
	}
	
	public void setGui(ChatClientGUI chatgui) {
		this.chatgui = chatgui;
	}
	
	@Override
	public void run() {
		try {
			socket = new Socket(IPAddress, Port);
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			out.writeUTF(nickName);
			while(in !=null) {
				message = in.readUTF();
				if(message.contains("+++닉네임의시작+++")) {
					chatgui.UserList.setText(null);
					NickNameList.add(message.substring(12));
					chatgui.AppendUserList(NickNameList);
				} else if (message.contains("님이 입장하셨습니다.\n")) {
					NickNameList.clear();
					chatgui.UserList.setText(null);
					chatgui.AppendMessage(message);
				} else if (message.contains("님이 퇴장하셨습니다.\n")) {
					NickNameList.clear();
					chatgui.UserList.setText(null);
					chatgui.AppendMessage(message);
				} else {
					chatgui.AppendMessage(message);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void Transmit(String message) {
		try {
			out.writeUTF(message);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}