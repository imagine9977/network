package sec1;

public class SystemExam1 {
	public static void main(String[] args) {
		String vendor = System.getProperty("java.vendor");
		System.out.println("자바공급자의 정뵈: "+vendor);
				
		String version = System.getProperty("java.version");
		System.out.println("자바 version의 정뵈: "+version);
		
	}
}
