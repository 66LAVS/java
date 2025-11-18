//. Сформировать множество, в которое входят только латинские буквы, встретившиеся во входной 
//строке, и множество знаков препинания из входной строки. 
package aa;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class lab32 {
	public static void main(String[] args) {
		 Set<Character> punctuation = Set.of(';', '?', '.', ',', '!');
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите текст:");
		String text = scanner.nextLine();

		Set<Character> arr = new HashSet<>();

		for (char c : text.toCharArray()) {
			if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (punctuation.contains(c))) {
				 arr.add(c);
			}
		}
		System.out.println("Уникальные буквы в тексте: " + arr); 
	}
}
