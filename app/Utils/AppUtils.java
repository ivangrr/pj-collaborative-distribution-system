package Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AppUtils {
	private final static String ALGORITHM_TO_ENCRIPT = "MD5"; 
	
	public static String getEncrypt(final String toEncript) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance(ALGORITHM_TO_ENCRIPT);
		md.update(toEncript.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}
	
}
