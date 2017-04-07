package service;

public class Operations {
	/*
	 *  param�tre long... numbers => transforme une liste de long en tableau de long [sans taille pr�d�finie] (attention, �a marche qu'en arguments !!!!)
	 */
	public static long add(long... numbers) {
		if (numbers.length > 0) {
			long res = 0;
			/*
			 * for (i = 0; i < numbers.length; i++) 
			 * { res = res * numbers[i]; }
			 */
			// syntaxe de for abr�g�e
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
