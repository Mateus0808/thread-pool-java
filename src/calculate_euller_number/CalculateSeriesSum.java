package calculate_euller_number;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CalculateSeriesSum {
	/**
	 * @param terms
	 * @return
	 */
	public static double calculate(List<Future<Double>> terms) {
		double serieSum = 0;
		
		try {
			for(Future<Double> term: terms) {
				serieSum += term.get();
			}
		} catch(ExecutionException | InterruptedException e) {
			e.printStackTrace();
		}
		
		return serieSum;
	}
}
