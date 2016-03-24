package coursera.java.prog.alsd;

public class CaesarCipher2 {
	private String alphabet;
	private String shifted_alphabet_one;
	private String shifted_alphabet_two;
	private int main_key_one;
	private int main_key_two;
	
	public CaesarCipher2(int key_one, int key_two) {
		alphabet = "abcdefghijklmnopqrstuvwxyz";
		shifted_alphabet_one = alphabet.substring(key_one) + alphabet.substring(0, key_one);
		shifted_alphabet_two = alphabet.substring(key_two) + alphabet.substring(0, key_two);
		main_key_one = key_one;
		main_key_two = key_two;
	}
	
	public String encrypt(String input) {
		StringBuilder encrypted = new StringBuilder(input);
		
		for(int i = 0; i < encrypted.length(); i++) {
			char current = encrypted.charAt(i);
			int index = alphabet.indexOf(Character.toLowerCase(current));
			
			if(index != -1) {
				char new_char;
				if((i % 2) != 1) {
					if(Character.isUpperCase(current)) {
						new_char = Character.toUpperCase(shifted_alphabet_one.charAt(index));
					} else {
						new_char = shifted_alphabet_one.charAt(index);
					}
					encrypted.setCharAt(i, new_char);
				} else {
					if(Character.isUpperCase(current)) {
						new_char = Character.toUpperCase(shifted_alphabet_two.charAt(index));
					} else {
						new_char = shifted_alphabet_two.charAt(index);
					}
					encrypted.setCharAt(i, new_char);
				}
			}
		}
		
		return encrypted.toString();
	}
	
	private String decrypt(String input) {
		CaesarCipher2 c = new CaesarCipher2((26 - main_key_one), (26 - main_key_two));
		
		return c.encrypt(input);
	}
	public static void main(String[] args) {
		CaesarCipher2 c = new CaesarCipher2(17, 4);
		String n = "Uybi Gfqgykii Jgziegv Uigeixdiex Smiizzin";
		//System.out.println(n);
		//System.out.println(c.encrypt(n));
		System.out.println(c.decrypt(n));
//		for(int i = 0; i < 26; i++) {
//			for(int j = 0; j < 26; j++) {
//				Caesar_Cipher2 m = new Caesar_Cipher2(i, j);
//				System.out.println("Keys: " + i + "," + j + " : "+ m.decrypt(n));
//			}
//		}
	}
}
