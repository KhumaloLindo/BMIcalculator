package BmiCalculator;

import java.util.Locale;
import java.util.Scanner;

public class BmiCalculator {

	public static void displayCategory(double bmi) { //method that accepts a double
		if(bmi<16.0) {
	System.out.println("Severely underweight"); //else if statement
		}else if(bmi >= 16.0 && bmi <= 18.4){
		System.out.println("Underweight");
		}else if(bmi >= 18.8 || bmi <= 24.9){
			System.out.println("Normal");
		}else if(bmi >= 25.0 || bmi <= 29.9){
			System.out.println("Overweight");
		}else if(bmi >= 30.0 || bmi <= 34.9) {
			System.out.println("Moderately Obese");
		}else if(bmi >= 35.0 || bmi <= 39.9){
			System.out.println("Severely Obese");
		}else if(bmi >= 40.0){
			System.out.println("Morbidly Obese");
		}
		}
	
	public static char askToRepeat(Scanner scanner) { //2nd method, need to return something
		
	while(true) {
	System.out.println("Do you want to run the program again ?");
	char input = scanner.next().charAt(0); //getting the character from the command prompt
	if(input == 'Y' || input == 'Y' || input == 'N' || input == 'n' ) { //Validation
		break; // because the input is valid
	}else {
	System.out.println("Invalid input. Enter Y/y or N/n");
	}
	}
	return 0;
	
	}
	
	public static void main(String[] args) { //TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		scanner.useLocale(Locale.US);
		
		char repeat = 0;
		
		do {

// All Our code
int unitChoice = getUnitChoice(scanner);
	
double weight = (unitChoice	== 1) ? getValidInput(scanner, "Enter your weight in kilograms :", 10, 600)
		:getValidInput(scanner, "Enter your weight in pounds " , 22, 1300);

double height = (unitChoice == 1)? getValidInput(scanner , "Enter your height in meters:" ,0.5 , 2.5)
		: getValidInput(scanner, "Enter your weight in inches", 20, 100);

double bmi = calculateBMI(unitChoice, weight, height);
System.out.println("Your BMI is " + bmi);
displayCategory(bmi);
repeat = askToRepeat(scanner);
System.out.println();


}while (repeat == 'Y' || repeat == 'y');

}

// Unit - Metric and Imperial
	public static int getUnitChoice(java.util.Scanner scanner) {
		int choice;
		
while(true)	{
System.out.println("Select a preferred unit:\n" 
+ "1. Metric (kg, m)\n" 
+ "2. Imperial (1bs, in)\n" 
+ "Please select either option 1 or option 2");

	if(scanner.hasNextInt()) {
		choice = scanner.nextInt();
		if(choice == 1 || choice == 2) {
			break;
		}else {
			System.out.println("Invalid choice. Please enter either 1 or 2");
		}
}else {
	System.out.println("Inavlid input. Please enter a number(1 or 2");
	scanner.next();
		}
	
}
		
		return choice;
	}
	
	public static double getValidInput(java.util.Scanner scanner, String prompt, double min, double max) {
		double value;
		
while(true) {
	System.out.println(prompt);
	
	if(scanner.hasNextDouble()) {
		value = scanner.nextDouble();
		if(value >= min && value <= max) {
			break;
		}else {
			System.out.printf("Please enter a value between %.1f and %.1f.\n", min, max);
		}
	}else {
		System.out.println("Invalid input. Please enter a value");
		scanner.next();
		}
	}
		
		return value;
	}
public static double calculateBMI(int unitChoice, double weight, double height) {
	double totalBMI;
	
	if(unitChoice == 1) {
		totalBMI = weight / (height * height);
	}else {
		totalBMI = (703 * weight) / (height / height);
	}
	
{
	
}
return totalBMI;
}
}