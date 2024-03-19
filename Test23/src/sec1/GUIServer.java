package sec1;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.InetAddress;
import java.rmi.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

class ManagerLogin extends JFrame implements ActionListener, KeyListener {
	JPanel port_log = new JPanel();
	JLabel port_label = new JLabel("입력을 허용할 포트번호를 입력하세요");
	JLabel port_warn = new JLabel("(단, 포트번호는 0~65536)");
	JTextField port_num = new JTextField(20);
	JButton port_btn = new JButton("접속!");
	JButton enter = new JButton("전송");
	ChatServerGUI serverChat;
	
	
	public ManagerLogin() {
		setTitle("GUI 관리자 창");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		setSize(600, 100); // 창크기
		setVisible(true);
		setResizable(false); // 창크기 조절 가능
		port_btn.addActionListener(this);
		port_num.addKeyListener(this);
		port_log.add(port_label);
		port_log.add(port_warn);
		port_log.add(port_num);
		port_log.setBackground(Color.getHSBColor(56, 100, 94));
		port_log.add(port_btn);
		add(port_log);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		try {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				int port = Integer.parseInt(port_num.getText().trim());
				serverChat = new ChatServerGUI(port);
				setVisible(false);

			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "올바르지 않은 메시지입니다.");
			// TODO: handle exception
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {

			int port = Integer.parseInt(port_num.getText().trim());
			if (e.getSource() == port_btn) {
				serverChat = new ChatServerGUI(port);
				setVisible(false);
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "올바르지 않은 메시지입니다.");
			// TODO: handle exception
		}
	}

}

public class GUIServer {
	public static void main(String[] args) {
		new ManagerLogin();
	}
}

class ChatServerGUI extends JFrame implements ActionListener, KeyListener {
	JPanel serverGUI_Panel = new JPanel();
	JLabel serverLabel = new JLabel("메인 서버");
	JLabel userLabel = new JLabel("사용자 목록");
	JTextField chat = new JTextField(45);
	JTextField portLabel = new JTextField(30);
	JButton enter = new JButton("전송");
	TextArea serverChatList = new TextArea(30, 50);
	TextArea userList = new TextArea(30, 15);
	ServerBack sb = new ServerBack();
	String ip;
	
	public ChatServerGUI(int port)  {
		setTitle("메인서버");
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(750, 700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		serverLabel.setForeground(Color.BLUE);
		try {
			InetAddress host = InetAddress.getLocalHost();
			ip = host.getHostAddress();
		
		} catch (java.net.UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel currentLabel = new JLabel("서버 IP 주소: "+ip+", 현재 포트: "+port);
		portLabel.setText("서버 IP 주소: "+ip+", 현재 포트: "+port);
		serverChatList.setEditable(false);
		userList.setEditable(false);
		chat.addKeyListener(this);
		enter.addActionListener(this);

		serverGUI_Panel.add(serverLabel);
		serverGUI_Panel.add(serverChatList);
		serverGUI_Panel.add(userLabel);
		serverGUI_Panel.add(userList);
		serverGUI_Panel.add(chat);
		serverGUI_Panel.add(enter);
		serverGUI_Panel.add(portLabel);
		serverGUI_Panel.setBackground(Color.getHSBColor(56, 100, 94));
		serverGUI_Panel.add(currentLabel);
		add(serverGUI_Panel);

		userList.append("Admin\n");
		sb.setGUI(this);
		sb.startServer(port);
		sb.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		String message = chat.getText().trim();
		if(e.getKeyCode() == KeyEvent.VK_ENTER && message.length() > 0) {
			appendMessage("서버 : "+message+"\n");
			sb.transmitAll("서버 : "+message+"\n");
			chat.setText(null);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String message = chat.getText().trim();
		if(e.getSource() == enter && message.length()>0) {
			appendMessage("서버 : " +message+"\n");
			sb.transmitAll(message);
			chat.setText(null);
		}
	}
	
	public void appendMessage(String message) {
		serverChatList.append(message);
	}
	public void appendUserList(List<String> nickNameList) {
		String name;
		for(int i = 0 ; i<nickNameList.size();i++) {
			name = (String) nickNameList.get(i);
			userList.append(name+"\n");
		}
	}

}
