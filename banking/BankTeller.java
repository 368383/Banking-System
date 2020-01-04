package projectX.banking;

import java.util.ArrayList;

public class BankTeller {
	private String firstName;
	private String lastName;
	private String credentials;

	public BankTeller(String inputFirstName, String inputLastName, String inputCredentials) {
		firstName = inputFirstName;
		lastName = inputLastName;
		credentials = inputCredentials;
	}

	public BankTeller() {
		// default constructor
	}

	public void setTellerInformation() {
		while (true) {
			firstName = Utility.prompt("Please enter in your first name");
			if (Utility.isStringOnlyAlphabet(firstName)) {
				break;
			}
			System.out.println("Invalid characters, must contain English Alphabetical Characters");
		}
		while (true) {
			lastName = Utility.prompt("Please enter in your last name");
			if (Utility.isStringOnlyAlphabet(lastName)) {
				break;
			}
			System.out.println("Invalid characters, must contain English Alphabetical Characters");
		}
		while (true) {
			String userPasswordInput = Utility.prompt("Please enter in your credentials");
			if (userPasswordInput.length() > 5) {
				credentials = userPasswordInput;
				break;
			}
			System.out.println("Password is two short. Must be an excess of 5 characters");
		}
	}

	public String toString() {
		return firstName + " " + lastName;
	}

	public String toFormattedString() {
		return firstName + " " + lastName + " " + credentials + " |";
	}

}
