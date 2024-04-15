package ex01; 
import java.util.Scanner;
import java.io.IOException;  
import java.io.BufferedReader;  
import java.io.InputStreamReader; 

public class Main {
private Calc calc = new Calc(); 

private void menu() { 
String s = null; 
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));  
do { 
do { 
System.out.println("Enter command..."); 
System.out.print("| Quit: 0 | Manual enter: 1 | Random enter: 2 | Show current variables: 3 | Double representation of resistance: 4 | \n"
				+ "| Hexadecimal representation of resistance: 5 | Octal Representation of resistance: 6 | Save current: 7 | View Last : 8 |\n");  //Simple console UI
try { 
s = in.readLine(); 
} 
catch(IOException e) {  
System.out.println("Error: " + e);  
System.exit(0); 
} 
} while (s.length() != 1);  
switch (s.charAt(0)) {  
case '0': 
System.out.println("Exit."); //switch contol falls to the end of do while loop
break; 
case '1':
	try { //each case uses try catch construction to console log occurred errors
		Scanner scanner = new Scanner(System.in); //scanner call to replace System.in.read() with further types manipulation
		System.out.println("Manual enter");  
		System.out.println("Enter power of flow (can't be negative):");
		double flow = scanner.nextDouble(); //getting flow parameter
		System.out.println("Enter voltage");
		double[] array = new double[3];
		System.out.println("Enter three double values:");
		for (int i = 0; i < 3; i++) { //getting voltage array
		    System.out.print("Enter value " + (i + 1) + ": ");
		    array[i] = scanner.nextDouble();
		}
		calc.Init(array, flow); //initializing new ElectricCircle based on entered data
		calc.Show(); //showing parameters that were inputed
	}catch(Exception e) {
		System.out.println("Oops! Error: " + e);
	}
break;  
case '2': 
	try {
		System.out.println("Random enter.");  
		calc.Init(new double[] {Math.random() * 100, Math.random() * 100, Math.random()* 100}, Math.random() * 100); //randomizing both voltage array and power of flow
		calc.Show();
	}catch(Exception e) {
		System.out.println("Oops! Error: " + e);
	}
break;  
case '3': 
	try {
		System.out.println("Show current variables.");  
		calc.Show(); 
	}catch(Exception e) {
		System.out.println("Oops! Error: " + e);
	}
break; 
case '4': 
	try {		
		System.out.println("Double representation of resistance.");  
		System.out.print(String.format("Double representation: %s Ohms \n", calc.GetResistance())); //Getting double representation of summary circle resistance
	}catch(Exception e) {
		System.out.println("Oops! Error: " + e);
	}
	break;
case '5': 
	try {
		System.out.println("Hexadecimal representation of resistance.");  
		System.out.print(String.format("Hexadecimal representation: 0x%s\n", calc.HexadecimalRepresentation())); //Getting Hexadecimal representation of summary circle resistance
calc.HexadecimalRepresentation();
	}catch(Exception e) {
		System.out.println("Oops! Error: " + e);
	}
	break;
case '6': 
	try {
		System.out.println("Octal Representation of resistance.");  
		System.out.print(String.format("Octal representation: 0o%s\n", calc.OctalRepresentation())); //Getting Octal representation of summary circle resistance
	}catch(Exception e) {
		System.out.println("Oops! Error: " + e);
	}
	break;
case '7': 
	try {
		System.out.println("Save current.");  
		calc.Save();
	}catch(Exception e) {
		System.out.println("Oops! Error: " + e);
	}
	break;
case '8': 
	try {
		System.out.println("Restore last saved.");
		calc.Restore();
	}catch(Exception e) {
		System.out.println("Oops! Error: " + e);
	}
	break;

default: 
System.out.print("Wrong command. "); 
} 
} while(s.charAt(0) != '0');
} 

public static void main(String[] args) {  
Main main = new Main(); 
main.menu(); 
}
} 
