package sec1;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncoderExam {
	public URLEncoderExam() {
		String sg = "1234agf가나다라";	
		String enc_data;
		try {
			enc_data = URLEncoder.encode(sg, "UTF-8");
			System.out.println(enc_data);
			
			String dec_data = URLDecoder.decode(enc_data, "UTF-8");
			System.out.println(dec_data);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new URLEncoderExam();
	}
}
