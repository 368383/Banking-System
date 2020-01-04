package projectX.banking;

import java.util.Scanner;

public class BankInterface {

	public static  void accountPrompt() {
		while (true) {
			System.out.println("Please inserthe following parameters. To stop program, type STOP");
			String firstName = Utility.prompt("Enter first name");
			String lastName = Utility.prompt("Enter last name");
			String stringValue = Utility.prompt("Enter Initial Amount");
			int value = Integer.valueOf(stringValue);
			BankTools usage = new BankTools();
			BankAccount result = usage.addAccount(firstName, lastName, value);
			System.out.println("Add User to the system: " + result.toString());
			String count = Utility.prompt("Continue adding more names? Y = Yes | N = No");
			if (count.toUpperCase().equals("Y")) {
			} else {
				System.out.println("Program has stopped");
				break;
			}
		}
	}

}
