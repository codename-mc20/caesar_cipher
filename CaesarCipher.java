package coursera.java.prog.alsd;

public class CaesarCipher {
	private String alphabet;
	private String shifted_alphabet;
	private int main_key;
	
	public CaesarCipher(int key) {
		alphabet = "abcdefghijklmnopqrstuvwxyz";
		shifted_alphabet = alphabet.substring(key) + alphabet.substring(0, key);
		main_key = key;
	}
	
	public String encrypt(String input) {
		StringBuilder encrypted = new StringBuilder(input);
				
		for(int i = 0; i < encrypted.length(); i++) {
			char current = encrypted.charAt(i);
			int index = alphabet.indexOf(Character.toLowerCase(current));
			
			if(index != -1) {
				char new_char;
				if(Character.isUpperCase(current)) {
					new_char = Character.toUpperCase(shifted_alphabet.charAt(index));
				} else {
					new_char = shifted_alphabet.charAt(index);
				}
				encrypted.setCharAt(i, new_char);
			}
		}
		
		return encrypted.toString();
	}
	
	public String decrypt(String input) {
		CaesarCipher cipher = new CaesarCipher(26 - main_key);
		
		return cipher.encrypt(input);
	}
	
	public static void main(String[] args) {
		CaesarCipher c = new CaesarCipher(15);
		String q1 = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
		System.out.println(q1);
		System.out.println(c.encrypt(q1));
		//System.out.println(c.decrypt(c.encrypt(q1)));
	}
}
