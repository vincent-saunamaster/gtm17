package service;

public class Operations {
	/*
	 *  paramètre long... numbers => transforme une liste de long en tableau de long [sans taille prédéfinie] (attention, ça marche qu'en arguments !!!!)
	 */
	public static long add(long... numbers) {
		if (numbers.length > 0) {
			long res = 0;
			/*
			 * for (i = 0; i < numbers.length; i++) 
			 * { res = res * numbers[i]; }
			 */
			// syntaxe de for abrégée
			for (long i : numbers) {
				res += i;
			}
			return res;
		} else {
			return 0;
		}
	}

	public static long mult(long... numbers) {
		if (numbers.length > 0) {
			long res = 1;
			for (long i : numbers) {
				res *= i;
			}
			return res;
		} else {
			return 0;
		}
	}

}
