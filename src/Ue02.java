import org.math.plot.PlotPanel;
import plotting.Plotting;
import plotting.StickPlot;
import audio.AudioPlayer;

public class Ue02 {
    public static void main (String[] args) {
        {
            double[] A = SignalAlgo.makeSin(100, 100.0);

            int[] K = new int[]{2, 3, 4, 6};

            // Draw Plots for K
            for (int j : K) {
                double[] B = SignalAlgo.quantize(A, j);
                double[] C = SignalAlgo.sub(B, A);

                PlotPanel panel = Plotting.create("Aufgabe 2.1" + j);
                panel.setAxisLabels("i", "g(i)");
                panel.addPlot(new StickPlot("Sinus n=100", A));
                panel.addPlot(new StickPlot("QSinus n=100", B));
                panel.addPlot(new StickPlot("Noise", C));

                Plotting.show(panel, -1, 1);
            }
        }

        {
            //Abtast Freq / Sample Rate
            long Fa = 10000;
            // Signal Freq
            double Fs = 220.0;
            double Ts = 2;

            int N = (int) (Fa * Ts);
            double T = Fa / Fs;
            double[] A = SignalAlgo.makeSin(N, T);

            AudioPlayer player = new AudioPlayer(Fa);
            player.play(A);
            player.close();

        }


    }


}
