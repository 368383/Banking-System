package projectX.banking;

import java.io.File;
import java.util.ArrayList;

public class BankTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank.addTeller();

		String testArray;
		String originalFile = "bank_account_2013.txt";
		String targetFile = "passwordFile.txt";
		String passPhrase = " 234AHG";
		testArray = Utility.readContent(originalFile);
		BankingEncryption.encrypt(testArray, passPhrase, targetFile);
		String decrypted = BankingEncryption.decrypt(passPhrase, targetFile);
		Utility.allocateAccounts(decrypted);

	}

	
}
