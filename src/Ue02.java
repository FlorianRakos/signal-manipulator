import org.math.plot.PlotPanel;
import plotting.Plotting;
import plotting.StickPlot;
import audio.AudioPlayer;

public class Ue02 {
    public static void main (String[] args) {

        // Make Plots
        {
            double[] sineA = SignalAlgo.makeSin(100, 100.0);

            // K bits for Quantisation
            int[] K = new int[]{2, 4, 8, 16};

            // Draw Plots for K
            for (int j : K) {
                double[] quantA = SignalAlgo.quantize(sineA, j);
                double[] noiseA = SignalAlgo.sub(quantA, sineA);

                PlotPanel panel = Plotting.create("Aufgabe 2.1" + j);
                panel.setAxisLabels("i", "g(i)");
                panel.addPlot(new StickPlot("Sinus n=100", sineA));
                panel.addPlot(new StickPlot("QSinus n=100", quantA));
                panel.addPlot(new StickPlot("Noise", noiseA));

                Plotting.show(panel, -1, 1);

                // Signal to Noise Ratio
                System.out.println("SNR: " + SignalAlgo.signalNoiseRat(sineA, noiseA, false) + "  Quantization: " + j + " bit");
                System.out.println("SNR in db: " + SignalAlgo.signalNoiseRat(sineA, noiseA, true) + "  Quantization: " + j + " bit");
            }
        }

        // Produce Sound
        {
            // Sample Rate
            long Fa = 10000;
            // Signal Freq
            double Fs = 220.0;
            // Time to play in s
            double Ts = 0.1;
            // Sample Length
            int N = (int) (Fa * Ts);
            // Sine Period Length
            double T = Fa / Fs;

            // K bits for Quantisation
            int[] K = new int[]{16, 12, 8, 4, 2, 1};

            double[] A = SignalAlgo.makeSin(N, T);
            AudioPlayer player = new AudioPlayer(Fa);

            for (int j : K) {
                double[] quantA = SignalAlgo.quantize(A, j);
                System.out.println(j + " bit quantisation");
                player.play(quantA);
                }
            player.close();
        }
    }
}
