//все буквы, входящие в текст не менее двух раз; 
package aa;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class lab31 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите текст:");
		String text = scanner.nextLine();

		Set<Character> arr = new HashSet<>();

		for (char c : text.toCharArray()) {
			if (text.length() - text.replace(String.valueOf(c), "").length() >= 2) {
				 arr.add(Character.toLowerCase(c));
			}
		}
		System.out.println("Уникальные буквы в тексте: " + arr); 
	}
}
