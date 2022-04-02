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
	static double[] sub(double[] a, double[] b) {

		double[] res = new double[a.length];

		for (int i=0;i<a.length;i++) {
			res[i] = a[i] - b[i];
		}
		return res;
	}

	// Quantize to k bits
	static double[] quantize(double[] g, int k) {
		int M = 1 << (k-1);
		double[] gBar = mul(g,M);
		gBar = round(gBar);
		gBar = div(gBar,M);

		return gBar;
	}

	static double[] mul (double[] g, int m) {
		double[] gBar = new double[g.length];
		for (int i = 0; i < g.length; i++) {
			gBar[i] = g[i] * m;
		}
		return gBar;
	}

	static double[] div (double[] g, int d) {
		double[] gBar = new double[g.length];
		for (int i = 0; i < g.length; i++) {
			gBar[i] = g[i] / d;
		}
		return gBar;
	}

	static double[] round(double[] g) {
		double[] gBar = new double[g.length];
		for (int i = 0; i < g.length; i ++) {
			gBar[i] = Math.round(g[i]);
		}
		return gBar;
	}
}
