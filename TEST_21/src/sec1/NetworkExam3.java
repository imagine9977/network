package sec1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkExam3 {
	public static void main(String[] args) {
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println(local.getHostAddress());
			System.out.println(local.getHostName());
			InetAddress[] iArr = InetAddress.getAllByName("www.google.com");
			for (InetAddress addr : iArr) {
				System.out.println(addr.getHostAddress());
			}
		} catch (UnknownHostException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
