public class A1 {
	static volatile int loser;
	static volatile int[] interested  = {0, 0};
	static int counter = 0;
	public static void main(String[] args) {
//		new Thread(new Patient(0)).start();
//		new Thread(new Patient(1)).start();
		int i=0;
		while(i<10){
			new Thread(new Patient(i%2)).start();
			i++;
		}
		System.out.println("The final counter is :"+ counter);
	}

	public static void mutEx(int me){
		int other = 1 - me;
		interested[me] = 1;
		loser = me;

		while (loser == me && loser == interested[other]);
//	Critical block starts here
		System.out.println("Critical block from thread " + me+(counter++));
		emulateWork();
//	Critical block ends here
		interested[me] = 0;
	}

	private static void emulateWork(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();  //Exception here
		}
	}

}

class Patient implements Runnable{
	private int id;

	Patient(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		A1.mutEx(id);
	}
}

