import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc;
		MTimer timer = new MTimer();
		while (true) {
			System.out.println("Input 0 to start timer, 1 to stop.");
			sc = new Scanner(System.in);
			if (sc.nextInt() == 0) {
				timer.start();
			} else if (sc.nextInt() == 1) {
				System.out.println("Do stop.");
				timer.stop();
			}
		}
	}
}


class MTimer implements Runnable {
	
	/**
	*  Count time by second.
	*/
	private int countTime;
	
	/**
	*  This thread is main thread.
	*/
	private Thread thread;
	
	
	public MTimer() {
		thread = new Thread(this);
		countTime = 0;
	}
	
	public void start() {
		if (thread == null) return;
		thread.start();
	}
	
	public void stop() {
		if (thread == null) return;
		thread.stop();
		reflash();
	}
	
	public void reflash() {
		thread = new Thread(this);
		countTime = 0;
	}
	
	public void print() {
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
		return "Count: " + countTime;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				countTime ++;
				print();
			} catch (Exception ex) {
				System.out.println(ex.toString());
			}
		}
	}
}

