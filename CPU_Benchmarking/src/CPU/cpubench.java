package CPU;

import java.util.Random;

public class cpubench extends Thread {
	public static int thread_count;

	@Override
	public void run() {
		int thread_count = cpubench.thread_count;
		System.out.println("Thread #" + thread_count + " Start");
		long Flops_Time = Calculate_Flops();
		long Iops_Time = Calculate_Iops();
		System.out.println("Thread #" + thread_count + " Time for FLOPS: " + Flops_Time + "ms");
		System.out.println("Thread #" + thread_count + " Time for IOPS: " + Iops_Time + "ms");

		float Gflops = Calculate_G(Flops_Time);
		System.out.println("Thread #" + thread_count + " Number of GFLOPS: " + Gflops);
		float Giops = Calculate_G(Iops_Time);
		System.out.println("Thread #" + thread_count + " Number of GIOPS: " + Giops);
		System.out.println("Thread #" + thread_count + " End");
	}

	private static float Calculate_G(float v) {
		// TODO Auto-generated method stub
		v = v / 1000;
		float g = ((Integer.MAX_VALUE) / v) / 1000000000;
		return g;
	}

	private static long Calculate_Flops() {
		float a = (float) Random_Int();
		float b = (float) Random_Int();
		long start = System.currentTimeMillis();
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			float c = a + b;
		}
		long end = System.currentTimeMillis();
		return (end - start);
	}

	private static long Calculate_Iops() {
		int a = Random_Int();
		int b = Random_Int();
		long start = System.currentTimeMillis();
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			int c = a + b;
		}
		long end = System.currentTimeMillis();
		return (end - start);
	}

	private static int Random_Int() {
		Random rn = new Random();
		return rn.nextInt(100);
	}
}
