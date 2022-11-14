package calculate_euller_number;

public class ValidateArguments {
	public static int getNumberOfTerms(String[] args) throws Exception {
		int numberOfTerms = 0;
		
		if(args.length != 1) {
			System.out.println("ERROR. You must provide the number of terms");
			throw new Exception();
		}
		
		try {
			numberOfTerms = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			System.out.println("The argument must be an integer");
			throw new Exception(e);
		}
		
		return numberOfTerms;
	}
}
