package projectX.banking.security;
//package projectX.banking;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.nio.ByteBuffer;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Encryption {
//
//	private static int contentKey;
//	private static int forKey;
//
//	public static void main(String args[]) {
//		int i = 'A';
//		System.out.println("before right rotate:" + Integer.toBinaryString(i));
//		i = Integer.rotateLeft(i, 5);
//		System.out.println("after right rotate:" + Integer.toBinaryString(i));
//		i = Integer.rotateRight(i, 5);
//		System.out.println("after left rotate:" + Integer.toBinaryString(i));
//
//		System.out.println(i);
//	}
//
//	public static void encrypt(String targetFile, BankAccount[] array) {
//		ArrayList<String> convertedBankAccount = new ArrayList<String>();
//		for (BankAccount currentAccount : array) {
//			convertedBankAccount.add(currentAccount.toFile());
//		}
//
//		StringBuffer encryptionHolder = new StringBuffer();
//		contentKey = keyGenerator();
//		forKey = keyGenerator();
//		int index = 0;
//		int holder = 0;
//		for (String currentAccount : convertedBankAccount) {
//			String content = currentAccount;
//			byte[] ascii = content.getBytes(StandardCharsets.US_ASCII);
//			for (Byte activeAccount : ascii) {
//				holder = activeAccount >>> 4;
//				encryptionHolder.append(holder);
//			}
//			index++;
//		}
//		System.out.println("Encryption holder countent " + encryptionHolder);
//		Utility.writeIntegers(targetFile, encryptionHolder);
//	}
//
//	public static void encryptTest(String targetFile, int a, BankAccount[] array) {
//		ArrayList<String> convertedBankAccount = new ArrayList<String>();
//		for (BankAccount currentAccount : array) {
//			convertedBankAccount.add(currentAccount.toFile() + "^");
//		}
//
//		StringBuffer encryptionHolder = new StringBuffer();
//		contentKey = a;
//		int index = 0;
//		int holder = 0;
//		System.out.println("First Account:" + convertedBankAccount.get(0));
//		for (String currentAccount : convertedBankAccount) {
//			String content = currentAccount;
//			byte[] ascii = content.getBytes(StandardCharsets.US_ASCII);
//			for (Byte activeAccount : ascii) {
//				holder = Integer.rotateLeft(activeAccount, contentKey);
//				encryptionHolder.append(holder);
//			}
//			index++;
//		}
//		System.out.println("First Account after encryption:" + encryptionHolder.toString().indent(0));
//		// System.out.println("Encryption holder countent " + encryptionHolder);
//		Utility.writeIntegers(targetFile, encryptionHolder);
//	}
//
//	public static String decryptTest(File file, int a) {
//
//		byte[] fileContent = null;
//		try {
//			fileContent = Files.readAllBytes(file.toPath());
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		int contentKey = a;
//		byte holder = 0;
//		for (int index = 0; index < fileContent.length; index++) {
//			int currentChar = (int) fileContent[index];
//			if (index == 0) {
//				System.out.println("first char read:" + Integer.toBinaryString(currentChar));
//			}
//			fileContent[index] = (byte) Integer.rotateRight(fileContent[index], contentKey);
//
//		}
//		System.out.println("first char after convert:" + Integer.toBinaryString(fileContent[0]));
//		try {
//			String decrypted = new String(fileContent, "UTF-8");
//			return decrypted;
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//
//	}
//
//	public static String[] getInformation(String rawCustomerInfo) {
//		int i = 0;
//		while (true) {
//			char atIndex = rawCustomerInfo.charAt(i);
//			if (Character.isDigit(atIndex)) {
//				String[] informationParsed = new String[1];
//				informationParsed[0] = rawCustomerInfo.substring(0, i - 1);
//				informationParsed[1] = rawCustomerInfo.substring(i);
//				return informationParsed;
//			}
//
//		}
//	}
//
//	private ArrayList<Integer> getKey() {
//		ArrayList<Integer> keyNumbers = new ArrayList<Integer>();
//		keyNumbers.add(contentKey);
//		keyNumbers.add(forKey);
//		// Utility.writeIntegers("passwordFile.txt", keyNumbers);
//		return keyNumbers;
//	}
//
//	private static int keyGenerator() {
//		int value = (int) (Math.random() * 5) + 1;
//		return value;
//	}
//}
