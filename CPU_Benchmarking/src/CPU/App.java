package CPU;

import java.util.Scanner;

public class App {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		int count;
		cpubench[] cb = new cpubench[8];
		System.out.println("\nEnter the number of Threads: (1,2,4,8)");
		Scanner in = new Scanner(System.in);
		count = in.nextInt();
		for (int i = 1; i <= count; i++) {
			cpubench.thread_count = i;
			cb[i - 1] = new cpubench();
			cb[i - 1].start();
			Thread.sleep(100);
		}

	}
}
