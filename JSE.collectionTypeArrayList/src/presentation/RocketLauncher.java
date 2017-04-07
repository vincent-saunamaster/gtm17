package presentation;

import java.util.ArrayList;
import java.util.List;

public class RocketLauncher {

	public static void main(String[] args) {

		List al = new ArrayList();
		al.add(12);
		al.add("cons");
		al.add(true);
		al.add('d');
		al.add('d');

		// parcours
		for (int i = 0; i < al.size(); i++) {
			System.out.println("donnée à l'indice " + i + " = " + al.get(i));
		}
	}
}
