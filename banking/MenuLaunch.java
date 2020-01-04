package projectX.banking;

public class MenuLaunch {

	private static final String addAccountMap = "A";
	private static final String modifyAccountMap = "M";
	private static String addAccount = " \n Add Account " + addAccountMap;
	private static String modifyAccount = " \n Modify Account " + modifyAccountMap;

	public static void main(String[] args) {
		boolean cycleRepeat = true;
		while (cycleRepeat) {
			String inputOption = Utility.prompt("Employee or User \n E for EMPLOYEE \n C for CUSTOMER");
			Utility.printLine();
			switch (inputOption.toUpperCase()) {
			case "E":
				cycleRepeat = false;
				employeeMenu();
				continue;
			case "C":
				cycleRepeat = false;
			default:
				Utility.print("Invalid input");

			}

		}
	}

	public static void employeeMenu() {
		// TODO Auto-generated method stub
		String baseInput = "";
		boolean cycleRepeat = true;
		while (cycleRepeat) {
			baseInput = Utility.prompt("Please Select What You Would Like To Do: " + addAccount + modifyAccount)
					.toUpperCase();
			Utility.printLine();
			// System.out.println("Base input " + baseInput);

			switch (baseInput) {
			case addAccountMap:
				cycleRepeat = false;
				Bank.adminAddTeller();
				continue;
			case modifyAccountMap:
				cycleRepeat = false;
				Bank.loadTellerAccounts();
				continue;
			default:
				Utility.print("Invalid Input");
			}
		}
	}
}
