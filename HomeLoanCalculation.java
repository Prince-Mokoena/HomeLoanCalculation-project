

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;

public class HomeLoanCalculation{
	
	public static double calculateMonthlyPay(double principalAmt, double annualRate,int loanPeriod){
		
		double amtPerPeriod = (principalAmt * (annualRate / 12) * Math.pow(1 + (annualRate / 12), loanPeriod)) / (Math.pow(1 + (annualRate / 12), loanPeriod) - 1);

		return amtPerPeriod;
		
	}
	public static boolean checkLoanQualify(int creditScore, int minimumCreditScore,double minimumDeposit){
		minimumCreditScore=520;
		if(creditScore >= minimumCreditScore && minimumDeposit > 0.20){
			return true;
		}else {
			return false;
		}
	}
	
	public static void displayMonthlyPayment(double amtPerPeriod , int loanPeriod){
		DecimalFormat df = new DecimalFormat ("R####.00");
		System.out.println("Monthly amount: "+df.format(amtPerPeriod)+"Period: "+loanPeriod);
	}
	public static void displayQualification(boolean checkLoanQualify){
		           
		if (checkLoanQualify){
			System.out.println( "Congragualtion. You qualify for home loan.");
		}else {
			System.out.println("Sorry you dont qualify for home loan.");
		}
	}
	
	
	
	
	public static void main (String [] args){
		Scanner sc=new Scanner(System.in);
		int minimumCreditScore=520;
		System.out.print("Do you want to check home loan (Yes /No) : ");
		char check=sc.next().charAt(0);
		
		while (check !='N'  ){
			
			System.out.print("Enter the loan amount (principal): ");
			double principalAmt = sc.nextDouble();
			System.out.print("Enter annual interest rate (in decimal): ");
			double annualRate = sc.nextDouble();
			
			Random rand =  new Random ();
			
			int loanPeriod = rand.nextInt(5)+15;
			
			double monthlyPayment = calculateMonthlyPay(principalAmt , annualRate , loanPeriod);
			displayMonthlyPayment(monthlyPayment, loanPeriod);
			
			System.out.print("\n\nDo you want to check if you qualify for a home loan? Yes/No: ");
			char qualifyCheck = sc.next().charAt(0);
			
			while (qualifyCheck!='N'){
				System.out.print("Enter your credit score: ");
				int creditScore =sc.nextInt();
				System.out.print("Enter the minimum deposit percentage(eg. 20% for 0.20): ");
				double minimumDeposit = sc.nextDouble();
				boolean checkLoanQualify = checkLoanQualify(creditScore , minimumCreditScore ,minimumDeposit);
				if (checkLoanQualify){
					displayQualification(checkLoanQualify);
				}else {
					displayQualification(checkLoanQualify);
				}
				System.out.print("\n\nDo you want to check if you qualify for a home loan? Yes/No: ");
			 qualifyCheck = sc.next().charAt(0);
			}
		System.out.print("Do you want to check home loan (Yes /No) : ");
		check=sc.next().charAt(0);	
		}
		
		
	}
}