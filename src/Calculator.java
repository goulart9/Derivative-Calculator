import java.io.*;
import java.text.*;
import java.util.*;

public class Calculator {
	
	public static void main(String[] args) {
		
		int start, stop, size = 1000, size2 = 999;
		double[] x = new double[size];
		double[] fx = new double[size];
		double[] f1x = new double[size2];
		String path;
		DecimalFormat df = new DecimalFormat("0.##");
		Scanner in = new Scanner(System.in);
		
		//Enter the name you want for the output file
		//Find the text file named as such in your src folder for this project
		System.out.print("Enter file name: ");
		path = in.nextLine();
		
		System.out.print("Enter a start value for x: ");
		start = in.nextInt();
		
		System.out.print("Enter a stop value for x: ");
		stop = in.nextInt();
		
		for (int i = 0; i < x.length; i++) {
			x[i] = start + (((double) (stop - start) / size)) * (i);
		}
		
		for (int i = 0; i < fx.length; i++) {
			fx[i] = f(x[i]);
		}
		
		for (int i = 0; i < f1x.length; i++) {
			f1x[i] = (fx[i + 1] - fx[i]) / (x[i + 1] - x[i]);
		}
		
		try (PrintStream out = new PrintStream(new FileOutputStream("src\\" + path + ".txt"))) {
			System.setOut(out);
			out.println("x\tf(x)\tf'(x)");
			out.println(df.format(x[0]) + "\t" + df.format(fx[0]) + "\t" + df.format(f1x[0]));
			
			for (int i = 0; i < f1x.length; i++) {
				out.println(df.format(x[i + 1]) + "\t" + df.format(fx[i + 1]) + "\t" + df.format(f1x[i]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		in.close();
	}

	public static double f(double x) {
		//return x;
		return 3 * (Math.pow(x, 2)) + 4;
		//return 3 * (Math.pow(x, 2)) + 4 * x + 10;
	}
}