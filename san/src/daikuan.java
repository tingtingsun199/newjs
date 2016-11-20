import java.util.Scanner;


public class daikuan {

	public static void main (String[] args){
		Scanner input = new Scanner(System.in);

        // Promt enter the amount of loan
        System.out.print("Enter loan amount:");
        double loanAmount = input.nextDouble();

        // Promt enter the year of loan
        System.out.print("Enter loan year as a integer:");
        int yearOfLoan = input.nextInt();

        System.out.print("Interest Rate");
        System.out.print("\tMonthly Payment");
        System.out.println("\t\tTotal Payment"); // \t take 8 position

        for (double annualInterestRate = 5.0; annualInterestRate <= 8.0;
            annualInterestRate += 1.0 / 8) {
            // Obtain monthly interest rate
            double monthlyInterestRate = annualInterestRate / 1200;

            // Compute mortgage
            double monthlyPayment = loanAmount * monthlyInterestRate /
                (1 - (Math.pow(1 / (1 + monthlyInterestRate), yearOfLoan * 12)));
                double totalPayment = monthlyPayment * yearOfLoan * 12;

            // Display results
            System.out.printf("%5.3f%c %20.2f %20.2f\n", annualInterestRate, 
                '%', monthlyPayment, totalPayment);
        } 
	}
}
