package aa;

//Задать хешмап вида (страна)-(кол-во населения). Организовать поиск стран с количеством 
//населения, меньшим и большим значения, введенного пользователем.
import java.util.HashMap;
import java.util.Scanner;

public class lab33 {

	public static void main(String[] args) {

		HashMap<String, Integer> Countrys = new HashMap<>();

		Countrys.put("Испания", 190000);
		Countrys.put("Франция", 1111);
		Countrys.put("Португалия", 1900);
		Countrys.put("Китай", 19);
		Countrys.put("Нижневартовск", 777777);

		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите население для поиска:");

		int filtr = scanner.nextInt();

		System.out.println("Население больше ");

		for (String strana : Countrys.keySet()) {
			if (Countrys.get(strana) >= filtr) {
				System.out.print(strana + " ");
			}
		}
		System.out.println();
		System.out.println("Население меньше");
		for (String strana : Countrys.keySet()) {
			if (Countrys.get(strana) < filtr) {
				System.out.print(strana + " ");
			}
		}
		scanner.close();
	}
}
