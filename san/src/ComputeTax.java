import java.util.Scanner;


public class ComputeTax {
	
	public static void main(String[] args) {
		   
		Scanner input = new Scanner(System.in);
	    System.out.print(
	    		"(0-single filer, 1-married jointly,or qualifying window(er)\n" +
	            "2-married separately, 3-head of household)\n");
	    System.out.print("Enter the filing status: ");
	    int status = input.nextInt();
	    
	    double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};

	    // Prompt the user to enter taxable income
	    System.out.print("Enter the taxable income: ");
	    double income = input.nextDouble();
        int[][] brackets = {
	    		{8350, 33950, 82250, 171550, 372950},
	    		{16700, 67900, 137050, 20885, 372950},
	    		                                   
	    		{8350, 33950, 68525, 104425, 186475},
	    		{11950, 45500, 117450, 190200, 372950}
	    };
	    
	    double tax;
	    tax = brackets[0][0] * rates[0]+
	    		(brackets[0][1] - brackets[0][0]) * rates[1] +
	    		(brackets[0][2] - brackets[0][1]) * rates[2] +
	    		(brackets[0][3] - brackets[0][2]) * rates[3] +
	    		(brackets[0][4] - brackets[0][3]) * rates[4] +
	    		(income - brackets[0][4]) * rates[5];
	    System.out.println("Tax is " + (int)(tax * 100)/100.0);
	    }


}
