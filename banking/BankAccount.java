package projectX.banking;

import java.util.StringTokenizer;

public class BankAccount {
	private double balance;
	private String name;
	private int mobilePhonumber;
	private static double annualServiceFee;

	public static double getAnnualServiceFee() {
		return annualServiceFee;
	}

	public static void setAnnualServiceFee(double annualServiceFee) {
		annualServiceFee = annualServiceFee;
	}

	public int getMobilePhonumber() {
		// I want to make sure this is not a scam number before giving out;
		return mobilePhonumber;
	}

	public void setMobilePhonumber(int mobilePhonumber) {
		// I want to make sure this is a legitimate number before set,

		this.mobilePhonumber = mobilePhonumber;
	}

	public BankAccount() {
		balance = 0;
		name = "guest";
		annualServiceFee = 1;
	}

	public BankAccount(String record) {
		StringTokenizer st = new StringTokenizer(record);
		name = st.nextToken();
		balance = Integer.parseInt(st.nextToken());
		annualServiceFee = 1;
		if (st.hasMoreTokens()) {
			System.out.println("Record error:" + st.nextToken());
		}

	}

	public BankAccount(String userName, double amount) {
		balance = amount;
		name = userName;
	}

	public void deposit(double in) {
		if (in < 0) {
			System.out.println("UNABLE TO PROCESS: DEPOSIT CANNOT BE NEGATIVE");
			return;
		}
		balance = balance + in;
	}

	public void withdraw(double out) {
		if (balance < out) {
			System.out.println("UNABLE TO PROCESS: BALANCE IS LESS THAN WITHDRAW");
			return;
		}
		balance = balance - out;
	}

	public void bonus(int bonus) {
		if (bonus < 0) {
			System.out.println("UNABLE TO PROCESS: BONUS IS NEGATIVE ");
			return;
		}
		balance = balance + bonus;
	}

	public String toString() {
		return "name " + "<" + name + ">" + " balance " + "<" + balance + ">";
	}

	public double getBalance() {
		if (balance < 0) {
			System.out.println("Your account is not in good standing, please see administrator");
			return 0;
		}
		return balance;
	}

	public String toFile() {
		return name + ":" + balance;
	}
}
