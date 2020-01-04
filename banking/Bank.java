package projectX.banking;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bank {
	private static ArrayList<BankAccount> listofAccounts;
	public static String tellerFile = "tellersAccount.txt";
	private static ArrayList<BankTeller> tellersList = new ArrayList<BankTeller>();

	public static void setTellers(ArrayList<BankTeller> tellers) {
		tellers = tellers;
	}

	public static ArrayList<BankTeller> getTellers() {
		return tellersList;
	}

	public static BankTeller searchTellerList(String searchInput) {

		for (BankTeller currentTeller : tellersList) {
			if (currentTeller.toString().contains(searchInput)) {
				return currentTeller;
			}
		}
		return null;
	}

	public static void modifyAccount() {

	}

	public static void addTeller() {
		BankTeller teller = new BankTeller();
		teller.setTellerInformation();
		Bank.addTellers(teller);
	}

	public static void adminAddTeller() {
		while (true) {
			addTeller();
			String inputOption = Utility
					.prompt("Would you like to continue adding accounts? \n Type in Y for YES  \n Type in N for NO");
			if (!inputOption.equalsIgnoreCase("Y")) {
				writeTellers();
				break;
			}
		}
	}

	private static void addTellers(BankTeller teller) {
		tellersList.add(teller);
	}

	public static void main(String[] args0) {
		loadTellerAccounts();
		System.out.println("finished loading " + tellersList.size());
		for (BankTeller currentTeller : tellersList) {
			System.out.println(currentTeller.toString());
		}
	}

	private static void writeTellers() {
		StringBuffer tellersString = new StringBuffer();
		for (BankTeller currentTeller : tellersList) {
			tellersString.append(currentTeller.toFormattedString());
		}
		System.out.println("List of tellers to apphend " + tellersString);

		BankingEncryption.encrypt(tellersString.toString(), "default", "tellersAccount.txt");
	}

	public static ArrayList<BankAccount> getListofAccounts() {
		return listofAccounts;
	}

	public static void loadTellerAccounts() {
		String tellers = BankingEncryption.decrypt("default", "tellersAccount.txt");
		// System.out.println("tellers " + tellers);
		StringTokenizer verticalLine = new StringTokenizer(tellers, "|");
		while (verticalLine.hasMoreTokens()) {
			String separatedAccount = verticalLine.nextToken();
			StringTokenizer currentAccount = new StringTokenizer(separatedAccount);
			ArrayList<String> tellerTraits = new ArrayList<String>();
			while (currentAccount.hasMoreTokens()) {
				String trait = currentAccount.nextToken();
				tellerTraits.add(trait);
			}
			tellersList.add(new BankTeller(tellerTraits.get(0), tellerTraits.get(1), tellerTraits.get(2)));
		}
	}

	public static void setListofAccounts(ArrayList<BankAccount> listofAccounts) {
		Bank.listofAccounts = listofAccounts;
	}

	public static void showBankAccounts() {
		System.out.println("LIST OF ALL ACCOUNTS");
		for (BankAccount currentAccount : listofAccounts) {
			System.out.println(currentAccount.toString());
		}
		Utility.printLine();
		System.out.println("Total Number of Accounts: " + listofAccounts.size());
	}
}
