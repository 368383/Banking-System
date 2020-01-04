package projectX.banking;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BankSecurity {
	private boolean secureStatus = false;
	private int secure = 3;

	private static String systemMessage = "default";
	private int attempts = 0;

	private static String error1 = "Contact your administrator for password total reset.";

	public BankSecurity() {
		secureStatus = false;
	}

	private String passwordRetrieval() {
		System.out.println("Please enter in your credentials");
		Scanner code = new Scanner(System.in);
		String returnValue = code.next();
		return returnValue;

	}

	private void pause() {
		System.out.println("Logged in too many times. Please wait 5 minutes to try again");
		try {

			Thread.sleep(5000);
			System.in.read(new byte[System.in.available()]);// read and ignore
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return;
	}

	public boolean passwordChecker() throws InterruptedException {
		String passCode = "";
		while (true) {
			if (attempts == 2) {
				secureStatus = false;
				systemMessage = error1;
				System.out.println(systemMessage);
				return secureStatus;
			}

			int max = secure;
			for (int i = 0; i < max + 1; i++) {
				passCode = passwordRetrieval();
				if (secure == 0) {
					pause();
					reset();
					secureStatus = false;
					continue;
				}
				if (passCode.equals("passcodeSample")) {
					secureStatus = true;
					systemMessage = "You have successfully logged in";
					System.out.println(systemMessage);
					return secureStatus;
				} else {
					System.out.println("Invalid Code. Try again with " + (secure) + " times remaining");
					secureStatus = false;
					secure--;
				}
			}
		}

	}

	private void reset() {
		secure = 3;
		// attempts++;

	}

	public boolean getStatus() {
		return secureStatus;
	}

}
