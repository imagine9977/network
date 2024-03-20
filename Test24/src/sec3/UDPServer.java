package sec3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class UDPServer {
	public static void main(String[] args) {
		DatagramSocket socket = null;
		DatagramPacket packet = null;
		int port = 7400;
		try {
			socket = new DatagramSocket(port);
			while(true) {
				byte[] buffer = new byte[512];
				packet = new DatagramPacket(buffer, buffer.length);
				System.out.println("ready");
				socket.receive(packet);
				String rData = new String(packet.getData());
				System.out.println("Rdata: " + rData);
				
				InetAddress ip = packet.getAddress();
				port = packet.getPort();
				System.out.println("[Client IP Address] : "+ip);
				System.out.println("[Client Port] : "+port);
				//송신(발신)
				packet = new DatagramPacket(packet.getData(), packet.getData().length, ip, port);
				socket.send(packet);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
