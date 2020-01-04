package projectX.banking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Utility {
	public static ArrayList<BankAccount> accountList = new ArrayList<BankAccount>();

	public static String prompt(String prompt) {
		System.out.println(prompt);
		Scanner scan = new Scanner(System.in);
		String value = scan.next();
		return value;
	}

	public static boolean isStringOnlyAlphabet(String str) {
		return ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z]*$")));
	}

	public static void printLine() {
		System.out.println("__________________________________________");
	}

	public static void print(String stringInput) {
		System.out.println(stringInput);
	}

	public static void allocateAccounts(String rawString) {
		StringTokenizer st = new StringTokenizer(rawString, "\n");
		while (st.hasMoreTokens()) {
			accountList.add(new BankAccount(st.nextToken()));
		}
		Bank.setListofAccounts(accountList);
		Bank.showBankAccounts();
	}

	public static void debug(String prompt) {
		System.out.println("DEBUGGIN INFORMATION " + prompt);
	}

	public static String converter(ArrayList<BankAccount> inputArray) {
		String toString = "";
		for (BankAccount currentAccount : inputArray) {
			toString = currentAccount.toFile();
		}
		return toString;
	}

	public static String readContent(String fileName) {
		try {
			InputStream is = new FileInputStream(fileName);
			BufferedReader buf = new BufferedReader(new InputStreamReader(is));

			String line = buf.readLine();
			StringBuilder sb = new StringBuilder();

			while (line != null) {
				sb.append(line).append("\n");
				line = buf.readLine();
			}
			String fileAsString = sb.toString();
			return fileAsString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void writeStrings(String fileName, String encryptedContent) {
		try {
			BufferedWriter file = Files.newBufferedWriter(Paths.get(fileName));
			file.write("");
			file.write(encryptedContent);
			file.flush();
			file.close();
			System.out.println(fileName + " has been written successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String greeter(String name) {
		return "hello" + name;
	}
}
