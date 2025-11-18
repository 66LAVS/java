package aa;

import java.util.List;
//Задать хешмап вида (магазин)-(список товаров). Найти магазины, у которых в списке кол-во 
//товаров больше числа, введенного пользователем
import java.util.HashMap;
import java.util.Scanner;

public class lab34 {

	public static void main(String[] args) {

		HashMap<String, List<String>> Magaz = new HashMap<>();

		Magaz.put("Пятерочка", List.of("тантум верде", "Пиво"));
		Magaz.put("Магнит", List.of("тантум верде", "Пиво","Вино"));
		Magaz.put("Европа - сити", List.of("тантум верде"));
		Magaz.put("Балаган", List.of("тантум верде", "Пиво","джава", "питон"));
		Magaz.put("Магаз", List.of("тантум верде", "Пиво"));

		Scanner scanner = new Scanner(System.in);

		System.out.println("Введите Число:");
		int a = scanner.nextInt();

		for (String i : Magaz.keySet()) {
			if (Magaz.get(i).size() > a) {
				System.out.println(i);
			}
		}

		scanner.close();
	}
}
