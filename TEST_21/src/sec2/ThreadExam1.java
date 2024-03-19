package sec2;

//Thread = Process = 현재 컴퓨터에서 실행중인 프로그램(작업)
//발생 => 실행 대기:Runnable =>  점유 (실행:run)=> 대기sleep => 기동wake up (run) =>종료
public class ThreadExam1 {
	public static void firstThread(){
		System.out.println("첫번째 쓰레드");
	}
	public static void secondaryThread() {
		//Toolkit toolkit = Toolkit.getDefaultToolkit(); //시스템 마다 이 줄이 오류 날 수도 있고 안 날 수 있음.
		for(int i = 0;i<10;i++) {
			System.out.println(i);
			try {
				Thread.sleep(2000); //sleep -> 실행 대기로 빠지게 하는거 , 단위: ms 
				
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				firstThread();
			}
		});
		thread1.run();
		thread1.start();
		System.out.println(thread1.getName());
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				secondaryThread();
			}
		});
		
	thread2.run();
	thread2.start();
	System.out.println(thread2.getName());
	}
}
