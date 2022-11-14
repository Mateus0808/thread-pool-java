package calculate_euller_number;

import java.util.concurrent.Callable;

public class FactorialTask implements Callable<Double> {
	private int number;
	
	public FactorialTask(int number) {
		this.number = number;
	}
	
	@Override
	public Double call() throws Exception {
		double num = this.calculateNumberOfSerie(this.number);
		return num;
	}
	
	private double calculateNumberOfSerie(int number) {
		int factorial = this.factorial(number);		
		double serie = (double) 1 / factorial;
		return serie;			
	}
	
	private int factorial(int number) {
		if(number == 0 || number == 1) {
			return 1;
		}
		return number * factorial(number - 1);
	}
}
