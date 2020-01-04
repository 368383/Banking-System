package projectX.banking;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class BankingEncryption {
	private static SecretKeySpec secretKey;
	private static byte[] key;

	public static void main(String[] args) {
		String message = "hello 243987 adfa";
		String passPhrase = " 849sajl";
		String encrptedString = encrypt(message, passPhrase);
		System.out.println("String:" + decrypt(passPhrase, encrptedString, true));
		String tempFile = "temp.txt";
		encrypt(message, passPhrase, tempFile);
		System.out.println("String:" + decrypt(passPhrase, tempFile));
	}

	public static void setKey(String myKey) {
		MessageDigest sha = null;
		try {
			key = myKey.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void encrypt(String inputString, String passPhrase, String fileName) {
		String encryptedString = encrypt(inputString, passPhrase);
		Utility.writeStrings(fileName, encryptedString);
	}

	private static String encrypt(String inputString, String passPhrase) {
		try {
			setKey(passPhrase);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);

			return Base64.getEncoder().encodeToString(cipher.doFinal(inputString.getBytes("UTF-8")));
		} catch (Exception e) {
			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}

	public static String decrypt(String passRephrase, String fileName) {

		String inputDecrypt = Utility.readContent(fileName);
		return decrypt(passRephrase, inputDecrypt, true);
	}

	private static String decrypt(String passRephrase, String inputDecrypt, boolean noFile) {
		inputDecrypt = inputDecrypt.trim();
		try {
			// System.out.println("Input to be decrypted:" + inputDecrypt + ":");
			setKey(passRephrase);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			String decrypted = new String(cipher.doFinal(Base64.getDecoder().decode(inputDecrypt)));
			return decrypted;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
