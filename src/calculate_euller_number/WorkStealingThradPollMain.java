package calculate_euller_number;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WorkStealingThradPollMain {

	public static void main(String[] args) throws Exception {
		int numberOfTerms = ValidateArguments.getNumberOfTerms(args);
		
		ExecutorService executor = Executors.newWorkStealingPool();
		
		List<Future<Double>> terms = new ArrayList<Future<Double>>();
		
		for(int i = 0; i <= numberOfTerms; i++) {
			Callable<Double> factorialTask = new FactorialTask(i);
			Future<Double> term = executor.submit(factorialTask);			
			terms.add(term);
		}
		
		double eullerNumber =  CalculateSeriesSum.calculate(terms);
		System.out.println("the calculation of Euler's number is: " + eullerNumber);
		
		executor.shutdown();
	}
}
