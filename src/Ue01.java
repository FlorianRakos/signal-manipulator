import org.math.plot.PlotPanel;
import plotting.Plotting;
import plotting.StickPlot;

/**
 * MTD129 Digitale Medientechnik 2
 * Übung 2
 * @author Florian Rakos
 */
public class Ue01 {

	public static void main(String[] args) {

		// Aufgabe 1.1
		{
			double[] A = SignalAlgo.makeSin(30);
			double[] B = SignalAlgo.makeCos(30);
			PlotPanel panel = Plotting.create("Aufgabe 1.1");
			panel.setAxisLabels("i", "g(i)");
			panel.addPlot(new StickPlot("Sinus n=30", A));
			Plotting.show(panel, -1, 1);
		}

		// Aufgabe 1.2
		{
			double[] A = SignalAlgo.makeCos(100,50);
			double[] B = SignalAlgo.makeSin(100,50);
			PlotPanel panel = Plotting.create("Aufgabe 1.2");
			panel.setAxisLabels("i", "g(i)");
			panel.addPlot(new StickPlot("Cosinus n = 100", A));
			panel.addPlot(new StickPlot("Sinus n = 100", B));
			Plotting.show(panel, -1, 1);
		}

		{
			double[] A = SignalAlgo.makeSin(100,30);
			double[] B = SignalAlgo.makeCos(100,30);
			double[] funcSum = SignalAlgo.add(A,B);
			PlotPanel panel = Plotting.create("Aufgabe 1.3");
			panel.setAxisLabels("i", "g(i)");
			panel.addPlot(new StickPlot("Sinus n=100", A));
			panel.addPlot(new StickPlot("Cosinus n=100", B));
			panel.addPlot(new StickPlot("Sum n=100", funcSum));
			Plotting.show(panel, -2, 2);
		}

	}


}
