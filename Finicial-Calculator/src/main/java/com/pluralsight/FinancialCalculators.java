package com.pluralsight;

import java.util.Scanner;

public class FinancialCalculators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose which calculator you would like to use.");
        System.out.println("Here are your options:");
        System.out.println("Enter 1 for a mortgage calculator" );
        System.out.println("Enter 2 for a future value calculator");
        System.out.println("Enter 3 for a present value calculator");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                mortgageCalculator();
                break;
            case 2:
                futureValue();
                break;
            case 3:
                presentValue();
                break;
            default:
                System.out.println("Oh no! You've input something outside of your options. " +
                        "Please try again and enter 1, 2, or 3.");
        }

    }
    public static void mortgageCalculator() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter principal loan amount: ");
        double loanAmt = scanner.nextDouble();

        System.out.println("Enter interest rate: ");
        double annualInterestRt = scanner.nextDouble();

        System.out.println("Enter loan length in years: ");
        int loanLength = scanner.nextInt();

        double interestRt = (annualInterestRt / 100) / 12;

        double totalPayments = loanLength * 12;

        double compoundedInterest = Math.pow(1 + interestRt, totalPayments);

        double monthlyPayment = (loanAmt * interestRt * compoundedInterest) / (compoundedInterest - 1);

        double totalAmtPaid = monthlyPayment * totalPayments;

        double interestTotal = totalAmtPaid - loanAmt;

        System.out.printf("Your monthly payment would be: $%.2f ", monthlyPayment);
        System.out.println();
        System.out.printf("Your total interest would be: $%.2f", interestTotal);

    }

    public static void futureValue() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the deposit amount: ");
        double depositAmount = scanner.nextDouble();

        System.out.println("Enter the interest rate: ");
        double interestRate = scanner.nextDouble();

        System.out.println("Enter the number of years: ");
        int yearAmount = scanner.nextInt();

        double dailyInterest = interestRate / 100;

        double totalLength = 365;

        double compoundedInterest = depositAmount * Math.pow(1 + (dailyInterest / totalLength), totalLength * yearAmount);

        double interestEarned = compoundedInterest - depositAmount;

        System.out.printf("Your ending balance would calculate to: $%.2f " ,compoundedInterest);
        System.out.println();
        System.out.printf("You earned $%.2f of interest" , interestEarned);






    }

    public static void presentValue() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter desired monthly payout: ");
        double monthlyPayout = scanner.nextDouble();

        System.out.println("Enter expected interest rate: ");
        double annualInterestRate = scanner.nextDouble();

        System.out.println("Enter the length of years: ");
        int years = scanner.nextInt();

        double interestRate = (annualInterestRate /100) /12;

        double amountOfPayments = years * 12;

        double presentValue = monthlyPayout * (1 - Math.pow(1 + interestRate, -amountOfPayments)) / interestRate;

        System.out.printf("You would need to invest $%.2f\n " , presentValue);
    }
}
