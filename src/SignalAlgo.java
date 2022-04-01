import org.math.plot.PlotPanel;
import plotting.StickPlot;
import plotting.Plotting;

/**
 * MTD129 Digitale Medientechnik 2
 * Übung 1
 * @author Florian Rakos
 */
public class SignalAlgo {

	static double[] makeSin(int n) {
		double[] A = new double[n];
		for (int i = 0; i<n;i++) {
			A[i] = Math.sin(i);
			System.out.println("a: " + A[i] + " n: " + n);
		}
		return A;
	}
	static double[] makeSin(int n, double t) {
		double[] A = new double[n];
		for (int i = 0; i<n;i++) {
			A[i] = Math.sin(i*2*Math.PI/t);
			System.out.println("a: " + A[i] + " n: " + n);
		}
		return A;
	}

	static double[] makeCos(int n) {
		double[] A = new double[n];
		for (int i = 0; i<n;i++) {
			A[i] = Math.cos(i);
			System.out.println("a: " + A[i] + " n: " + n);
		}

		return A;
	}

	static double[] makeCos(int n, double t) {
		double[] A = new double[n];
		for (int i = 0; i<n;i++) {
			A[i] = Math.cos(i*2*Math.PI/t);
			System.out.println("a: " + A[i] + " n: " + n);
		}

		return A;
	}

	static double[] add(double[] a, double[] b) {

		double[] res = new double[a.length];

		for (int i=0;i<a.length;i++) {
			res[i] = a[i] + b[i];
		}
		return res;
	}
}
